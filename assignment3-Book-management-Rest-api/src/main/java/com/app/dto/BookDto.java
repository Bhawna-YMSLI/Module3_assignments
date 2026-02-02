package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Why DTO?   Prevent exposing internal entity structure

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BookDto {
	private String title;
	private String author;
	private double price;

}
