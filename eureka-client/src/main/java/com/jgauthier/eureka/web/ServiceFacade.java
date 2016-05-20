package com.jgauthier.eureka.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("eureka-service")
public interface ServiceFacade {

	@RequestMapping(method = RequestMethod.GET, value = "/service")
	String service();
}
