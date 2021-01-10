package com.microservices.oauth.service;

import com.microservices.commonsUsers.models.User;

public interface IUserService {

	public User findByUsername(String username);
	
	public User update( User user, Long id);

}
