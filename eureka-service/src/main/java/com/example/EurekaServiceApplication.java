package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaServiceApplication {

	@RequestMapping("/service")
	public String test() {
		return "Hello service";
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceApplication.class, args);
	}
}
