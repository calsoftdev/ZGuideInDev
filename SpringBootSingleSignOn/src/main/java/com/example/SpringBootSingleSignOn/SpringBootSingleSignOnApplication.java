package com.example.SpringBootSingleSignOn;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableOAuth2Sso


public class SpringBootSingleSignOnApplication {
	@GetMapping("/")
	public String welcome(Principal principal) { return
			 "Welcome" +principal.getName()+"to my Api"; }
			 

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSingleSignOnApplication.class, args);
	}

}
