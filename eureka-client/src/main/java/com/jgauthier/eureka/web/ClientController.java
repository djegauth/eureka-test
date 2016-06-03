package com.jgauthier.eureka.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgauthier.eureka.service.BreakerService;

@RestController
public class ClientController {

	@Autowired
	private ServiceFacade serviceFacade;

	@Autowired
	private BreakerService breakerService;

	@RequestMapping("/client")
	public String client() {
		if (serviceFacade != null) {
			return serviceFacade.service();
		}
		return "Hello client";
	}

	@RequestMapping("/breaker")
	public String breaker(@RequestParam("fallback") boolean fallback) {
		return breakerService.getLabel(fallback);
	}
}
