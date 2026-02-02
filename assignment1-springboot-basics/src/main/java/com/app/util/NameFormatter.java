package com.app.util;

import org.springframework.stereotype.Component;

@Component
public class NameFormatter {
	public String format(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}

	public NameFormatter() {
		super();
	}
}
