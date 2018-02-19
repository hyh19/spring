package com.wisely.ch6_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Ch64Application {

	@RequestMapping("/")
	public String index() {
		return "Hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(Ch64Application.class, args);
	}
}
