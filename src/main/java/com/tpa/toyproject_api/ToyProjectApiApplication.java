package com.tpa.toyproject_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ToyProjectApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToyProjectApiApplication.class, args);
	}

}
