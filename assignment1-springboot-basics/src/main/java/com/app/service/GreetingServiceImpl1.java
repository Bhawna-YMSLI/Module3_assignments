package com.app.service;

import org.springframework.stereotype.Service;

@Service("impl1")

public class GreetingServiceImpl1 implements GreetingService {

	@Override
	public String greet(String name) {

		return "Welcome : (1st imp) ";
	}

}
