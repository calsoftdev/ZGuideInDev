package com.calsoft.springbootjwthelloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calsoft.springbootjwthelloworld.model.JwtRequest;
import com.calsoft.springbootjwthelloworld.service.JwtUserDetailsService;
import com.calsoft.springbootjwthelloworld.util.JwtTokenUtil;

@RestController
public class HelloWorldController {

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	
	@RequestMapping({ "/hello" })
	public String firstPage(@RequestBody JwtRequest authenticationRequest ,@RequestHeader(value="Authorization") String token) {
	  
		
		  if (token != null && token.startsWith("Bearer ")) { token =
		  token.substring(7); }
		  JwtTokenUtil utilObj = new JwtTokenUtil();
		  utilObj.setSecret("password");
		  
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
	 utilObj.validateToken(token, userDetails);
		return "Hello World";
	}

}
	