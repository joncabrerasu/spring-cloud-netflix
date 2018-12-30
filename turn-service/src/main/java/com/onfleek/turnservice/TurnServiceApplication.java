package com.onfleek.turnservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TurnServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurnServiceApplication.class, args);
	}

}

