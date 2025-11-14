package com.healthcare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.AuthRequest;
import com.healthcare.dto.AuthResp;
import com.healthcare.security.JwtUtils;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
	// depcy
	private final AuthenticationManager authenticationManager;
	private JwtUtils jwtUtils;

	/*
	 * 1. Patient Login / Doctor Login(User Login) common - Controller -
	 * UserController URL - http://host:port/users/signin Method - POST (for
	 * security , JWT generation, JSON payload)
	 * 
	 * Payload - email , password (Auth Request DTO) Success Resp -Sc 201 Auth Resp
	 * DTO (JWTS, message) Failure Resp - SC 401 ApiResp DTO(status : succes |
	 * failure , timestamp , message)
	 * 
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> userAuthentication(@RequestBody @Valid AuthRequest dto) {
		System.out.println("in user auth " + dto);
		// 1 . Invoke the method of Spring Supplied AuthManager
		/*
		 * AuthenticationManager - i/f , Method public Authentication
		 * authenticate(Authentication auth) throws AuthenticationException
		 * Authentication - i/f Implemented by -
		 * UsernamePasswordAuthenticationToken(String email,String password) i/p - not
		 * yet verified (isAuth : false) o/p - Fully Authenticated UserDetails -
		 * email|username , password-null , Collection<GrantedAuthority> , isAuth : true
		 */
		UsernamePasswordAuthenticationToken authToken = new 		UsernamePasswordAuthenticationToken(dto.getEmail(),
				dto.getPassword());
		// 2. To invoke the method on AuthMgr - first configure AuthMgr as bean(@Bean)
		// & then add it as the depcy
		System.out.println("before " + authToken.isAuthenticated());// false
		Authentication fullyAuthenticated = authenticationManager.authenticate(authToken);
		System.out.println("FullyAuthenticated Object after successful authenticate!..=>"+fullyAuthenticated );
		System.out.println(fullyAuthenticated.isAuthenticated());// true
		System.out.println(fullyAuthenticated.getPrincipal().getClass());
		// 3. In case of success, create JWT send it to the REST Client (using JWT Utils
		// - helper class)

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new AuthResp(jwtUtils.genrateToken(fullyAuthenticated), "Auth Success!"));

	}

}
