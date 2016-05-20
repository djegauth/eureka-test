package com.jgauthier.eureka.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	@Autowired
	private ServiceFacade serviceFacade;

	@RequestMapping("/client")
	public String client() {
		if (serviceFacade != null) {
			return serviceFacade.service();
		}
		return "Hello client";
	}
}
