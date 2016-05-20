package com.jgauthier.eureka.web;

public class HystrixServiceFallback implements ServiceFacade {

	@Override
	public String service() {
		return "Failed";
	}
}
