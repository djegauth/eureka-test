package com.jgauthier.eureka.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

	@RequestMapping("/service")
	public String test() {
		return "Hello service";
	}
}
