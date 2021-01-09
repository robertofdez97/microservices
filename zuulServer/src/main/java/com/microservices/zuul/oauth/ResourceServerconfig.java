package com.microservices.zuul.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerconfig extends ResourceServerConfigurerAdapter{

	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/api/security/oauth/**").permitAll()
		.antMatchers(HttpMethod.GET,"api/products/findAll" ,"api/items/findAll", "api/users/user").permitAll()
		.antMatchers(HttpMethod.GET, "api/products/findById", "api/items/findById")
		.hasAnyRole("ADMIN", "USER")
		.antMatchers("/api/products/**","/api/items/**" , "/api/users/**").hasRole("ADMIN")
		.anyRequest().authenticated();
//		.antMatchers(HttpMethod.PUT, "/api/products/update/{id}","/api/items/update/{id}").hasRole("ADMIN")
//		.antMatchers(HttpMethod.DELETE, "/api/products/delete/{id}","/api/items/delete/{id}").hasRole("ADMIN");

		
	
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore());
	}
	

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("some_secret_code");
		return tokenConverter;
	}
	
}
