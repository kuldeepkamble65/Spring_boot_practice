package com.example.sheduleDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SheduleDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SheduleDemoApplication.class, args);

	}

}
