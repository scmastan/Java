package com.mastan.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.ribbon.proxy.annotation.Hystrix;

@RestController
@Hystrix
public class FallBackMethodController {
	
	@GetMapping("/userServiceFallBack")
	public String userServiceFallBackMethod() {
		
		return "User Servoce is not responding intime";		
	}
	
	@hy
	@GetMapping("/departmentServiceFallBack")
	public String departmentServiceFallBackMethod() {
		
		return "Department Servoce is not responding intime";		
	}


}
