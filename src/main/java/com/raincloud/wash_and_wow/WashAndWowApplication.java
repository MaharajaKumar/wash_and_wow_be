package com.raincloud.wash_and_wow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true)
public class WashAndWowApplication {

	public static void main(String[] args) {
		SpringApplication.run(WashAndWowApplication.class, args);
	}

}
