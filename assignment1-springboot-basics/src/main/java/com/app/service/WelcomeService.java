package com.app.service;

import org.springframework.stereotype.Service;

import com.app.util.NameFormatter;

@Service
public class WelcomeService {
	private final NameFormatter formatter;

	public WelcomeService(NameFormatter formatter) {
		this.formatter = formatter;
	}

	public String greet(String name) {
		String formattedName = formatter.format(name);
		return "Welcome " + formattedName + " to Spring Boot!";
	}
}
