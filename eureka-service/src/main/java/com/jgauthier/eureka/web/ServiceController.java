package com.jgauthier.eureka.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

	@Value("${hello.service}")
	private String label;

	@RequestMapping("/service")
	public String test() {
		return label;
	}
}
