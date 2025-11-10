package com.healthcare.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

/*to declare spring configuration class - to be able to add Spring beans (@Bean)
*/
@Configuration
@EnableWebSecurity //to enable spring security
@EnableMethodSecurity //enables the customization of spring sec support at the method level.
@AllArgsConstructor
public class SecurityConfiguration {
	private final PasswordEncoder passwordEncoder;
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
		
		
		
		
		
		//4. Specify URL based authorization rules 
		http.authorizeHttpRequests(request 
				-> request.requestMatchers("/swagger-ui/**","/v3/api-docs/**","/users/signin","/patients/signup","/doctors/signup").permitAll()
				.requestMatchers("/patients/**").hasRole("PATIENT")
				.requestMatchers("/doctors/**").hasRole("DOCTOR")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated());
		return http.build();
		
		
		
		
	}
	
}
