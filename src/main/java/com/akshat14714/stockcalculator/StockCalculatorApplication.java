package com.akshat14714.stockcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class StockCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockCalculatorApplication.class, args);
	}

}
