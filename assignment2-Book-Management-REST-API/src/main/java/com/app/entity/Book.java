package com.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Book {
	private Integer id;
	private String title;
	private String author;
	private double price;

	public Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
}
