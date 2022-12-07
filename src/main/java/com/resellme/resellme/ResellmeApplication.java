package com.resellme.resellme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ResellmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResellmeApplication.class, args);
	}

}
