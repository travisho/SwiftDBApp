package com.example.SwiftDatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.SwiftDatabase.repository")
public class SwiftDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwiftDatabaseApplication.class, args);
	}

}