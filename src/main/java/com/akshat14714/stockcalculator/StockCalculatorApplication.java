package com.akshat14714.stockcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("com.akshat14714.stockcalculator.repository")
@ComponentScan("com.akshat14714.stockcalculator.repository")
//@Configuration
public class StockCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockCalculatorApplication.class, args);
	}

}
