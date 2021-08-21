package com.atrs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class ArbitrageRecommendationApplication {
	int a;
	public static void main(String[] args) {
		SpringApplication.run(ArbitrageRecommendationApplication.class, args);
	}

}
