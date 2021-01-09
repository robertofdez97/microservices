package com.microservices.oauth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.microservices.commonsUsers.models.User;
import com.microservices.oauth.client.UserClient;

@Service
public class UsersService implements UserDetailsService,IUserService {

	@Autowired
	UserClient userClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userClient.findByUsername(username);
		if (user != null) {
			List<GrantedAuthority> authorities = user.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
			return new org.springframework.security.core.userdetails.User(
					user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
		}
		throw new UsernameNotFoundException("Username not found");
	}

	@Override
	public User findByUsername(String username) {
		return userClient.findByUsername(username);
	}

}
