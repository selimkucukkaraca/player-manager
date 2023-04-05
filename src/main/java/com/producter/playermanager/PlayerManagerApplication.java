package com.producter.playermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PlayerManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerManagerApplication.class, args);
	}

}
