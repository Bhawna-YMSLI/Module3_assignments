package com.app.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.GreetingService;
import com.app.service.WelcomeService;

@RestController
@RequestMapping("/api")
public class WelcomeController {
	@Value("${app.author}")
	private String author;

	private final GreetingService greetingService;

	public WelcomeController(@Qualifier("impl2") GreetingService service) {
		this.greetingService = service;
	}

	@GetMapping("/welcome/{name}")
	public String welcome(@PathVariable String name) {
		return greetingService.greet(name) + " (Author: " + author + ")";
	}
}
