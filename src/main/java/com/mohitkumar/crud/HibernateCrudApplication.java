package com.mohitkumar.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HibernateCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCrudApplication.class, args);
	}

}
