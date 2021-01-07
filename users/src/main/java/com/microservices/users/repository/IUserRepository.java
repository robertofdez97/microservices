package com.microservices.users.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.microservices.users.models.User;

@RepositoryRestResource(path = "user")
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {

	public User findByUsername(String username);
	
	@Query(value = "select u from User u where u.username = ?1")
	public User getUser(String username);
	
}
