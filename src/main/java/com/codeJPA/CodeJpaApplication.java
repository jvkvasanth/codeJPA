package com.codeJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.codeJPA.entity")
public class CodeJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeJpaApplication.class, args);
	}

}
