package com.microservices.oauth.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.microservices.commonsUsers.models.User;
import com.microservices.oauth.service.IUserService;

@Component
public class AditionalInfoToken implements TokenEnhancer{

	@Autowired
	private IUserService userService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();
		String username = authentication.getName();
		User user = userService.findByUsername(username);
		info.put("name", user.getName());
		info.put("lastName", user.getLastName());
		info.put("email", user.getEmail());
		DefaultOAuth2AccessToken defaultAccessToken = (DefaultOAuth2AccessToken) accessToken;
		defaultAccessToken.setAdditionalInformation(info);
		return defaultAccessToken;
		
	}

}
