package com.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.challenge.repository")
@EnableScheduling
@EnableWebMvc
public class Challenge extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(Challenge.class, args);
	}
}