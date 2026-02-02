package com.app.service;

import org.springframework.stereotype.Service;

@Service("impl2")
public class GreetingServiceImpl2 implements GreetingService {

	@Override
	public String greet(String name) {
		return "Welcome : (2nd imp) ";
	}

}