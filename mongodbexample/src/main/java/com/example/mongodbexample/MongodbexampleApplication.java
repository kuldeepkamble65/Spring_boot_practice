package com.example.mongodbexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.mongodbexample")
public class MongodbexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbexampleApplication.class, args);
	}

}
