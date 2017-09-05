package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.builder.lib.ANSRBuilder;
import repository.builder.lib.enums.interfaces.Strategy;

@SpringBootApplication
public class PhotoWorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoWorkshopApplication.class, args);
	}
}
