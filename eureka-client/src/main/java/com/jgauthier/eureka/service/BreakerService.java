package com.jgauthier.eureka.service;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BreakerService {

	@HystrixCommand(fallbackMethod = "getDefaultLabel")
	public String getLabel(boolean fallback) {
		if (fallback) {
			throw new RuntimeException("fallback");
		}
		return "Everything ok";
	}

	public String getDefaultLabel(boolean fallback) {
		return "Nooooooooooooooo";
	}
}
