package com.example.jounralApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.jounralApp")
public class JounralApplication {

	public static void main(String[] args) {

		SpringApplication.run(JounralApplication.class, args);
	}

}
