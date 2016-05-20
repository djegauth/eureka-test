package com.jgauthier.eureka;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/client")
	public String client() {
		URI serviceUri = serviceUri();
		if (serviceUri != null) {
			URI productUri = URI.create(String.format("http://%s:%s/service/", serviceUri.getHost(), serviceUri.getPort()));
			return restTemplate.getForObject(productUri, String.class);
		}
		return "Hello client";
	}

	private URI serviceUri() {
		List<ServiceInstance> list = discoveryClient.getInstances("eureka-service");
		if (list != null && !list.isEmpty()) {
			return list.get(0).getUri();
		}
		return null;
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
