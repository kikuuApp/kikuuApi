package com.kikuu.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= {"com.kikuu.api.*"})
@SpringBootApplication
public class KikuuApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KikuuApiApplication.class, args);
	}
}
