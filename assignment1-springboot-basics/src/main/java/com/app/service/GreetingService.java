package com.app.service;

import org.springframework.beans.factory.annotation.Qualifier;

public interface GreetingService {

	String greet(String name);
}
