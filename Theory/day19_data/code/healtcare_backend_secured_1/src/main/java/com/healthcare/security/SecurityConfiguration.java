package com.healthcare.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/*to declare spring configuration class - to be able to add Spring beans (@Bean)
*/
@Configuration
@EnableWebSecurity //to enable spring security
@EnableMethodSecurity //enables the customization of spring sec support at the method level.
public class SecurityConfiguration {
	/*
	 * Configure a bean to customize Spring security filter chain.
	 */
	@Bean 
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		//1. disable CSRF protection
		http.csrf(csrf -> csrf.disable());
		//2. session creation policy - stateless (i.e Spring Security will NOT create HttpSession)
		http.sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		//3. enable Basic Authentication
		http.httpBasic(Customizer.withDefaults());
		
		
		//4. Add authentication - for ANY request coming from client
		
		
		
		
		//giving specific permits to access
		http.authorizeHttpRequests(request 
				-> request.anyRequest().authenticated());
		return http.build();
	}

}
