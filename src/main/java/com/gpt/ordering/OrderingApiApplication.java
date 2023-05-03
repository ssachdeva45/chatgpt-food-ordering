package com.gpt.ordering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OrderingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderingApiApplication.class, args);
	}

}
