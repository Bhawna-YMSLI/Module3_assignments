package com.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookDto;
import com.app.service.BookServiceImpl;

@RestController
@RequestMapping("/api/books")
public class BookController {
	private final BookServiceImpl service;

	public BookController(BookServiceImpl service) {
		this.service = service;
	}

	@PostMapping
	public BookDto add(@RequestBody BookDto dto) {
		return service.addBook(dto);
	}

	@GetMapping("/{id}")
	public BookDto get(@PathVariable Integer id) {
		return service.getBook(id);
	}

	@GetMapping
	public List<BookDto> getAll() {
		return service.getAllBooks();
	}

	@PutMapping("/{id}")
	public BookDto update(@PathVariable Integer id, @RequestBody BookDto dto) {
		return service.updateBook(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteBook(id);
	}

}
