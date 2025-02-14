package com.trupper.order.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TruppeOrderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruppeOrderApiApplication.class, args);
	}

}
