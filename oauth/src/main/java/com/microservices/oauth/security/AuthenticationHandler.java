package com.microservices.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.microservices.commonsUsers.models.User;
import com.microservices.oauth.service.UsersService;

import brave.Tracer;

@Component
public class AuthenticationHandler implements AuthenticationEventPublisher {

	@Autowired
	UsersService userService;
	
	
	@Autowired
	private Tracer tracrer;

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		Integer attempts = 0;
		try {
			StringBuilder errors = new StringBuilder();
			User myUser = userService.findByUsername(authentication.getName());
			if (myUser.getLoginAttempts() != null) {
				attempts = myUser.getLoginAttempts();
				myUser.setLoginAttempts(attempts + 1);
				errors.append("intentos: " + attempts + 1);
				if(myUser.getLoginAttempts() >= 3) myUser.setEnabled(false);
				userService.update(myUser, myUser.getId());
				tracrer.currentSpan().tag("message.error", errors.toString());
			}
		} catch (Exception e) {
			System.out.println("error authentication fialute ");
		}
	}

	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		UserDetails user = (UserDetails) authentication.getPrincipal();
		User myUser = userService.findByUsername(authentication.getName());
		myUser.setLoginAttempts(0);
		userService.update(myUser, myUser.getId());
		System.out.println("succes acces for the user:" + user.getUsername());

	}
}
