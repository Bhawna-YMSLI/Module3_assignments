package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dto.BookDto;
import com.app.entity.Book;
import com.app.exception.BookNotFoundException;

//Purpose of Service Layer:
//Validations
//Mapping DTO → Entity
//Error handling
//Business logic separation

import com.app.repository.BookRepository;
import com.app.util.BookConverter;

@Service
public class BookServiceImpl implements BookService {
	private final BookRepository repo;

	public BookServiceImpl(BookRepository repo) {
		this.repo = repo;
	}

	public BookDto addBook(BookDto dto) {
		return BookConverter.convertToBookDto(repo.save(BookConverter.convertToBook(dto)));

	}

	public BookDto updateBook(Integer id, BookDto dto) {

		Book bookToUpdate = repo.findById(id).orElseThrow(() -> new BookNotFoundException("book not found"));

		bookToUpdate.setTitle(dto.getTitle());

		bookToUpdate.setAuthor(dto.getAuthor());

		bookToUpdate.setPrice(dto.getPrice());

		Book updatedBook = repo.save(bookToUpdate);

		return BookConverter.convertToBookDto(updatedBook);
	}

	public BookDto getBook(Integer id) {

		Book book = repo.findById(id).orElseThrow(() -> new BookNotFoundException("book not found"));

		return BookConverter.convertToBookDto(book);

	}

	public List<BookDto> getAllBooks() {
		return repo.findAll().stream().map(BookConverter::convertToBookDto).toList();
	}

	public void deleteBook(Integer id) {

		Book book = repo.findById(id).orElseThrow(() -> new BookNotFoundException("book not found"));
		repo.delete(book);

	}

	public List<BookDto> getByAuthor(String author) {

		return repo.findByAuthor(author).stream().map(BookConverter::convertToBookDto).toList();

	}

	public List<BookDto> getByPriceLessThan(Double price) {

		return repo.findByPriceLessThan(price).stream().map(BookConverter::convertToBookDto).toList();

	}

	public List<BookDto> getByKeywordInTitle(String keyword) {

		return repo.searchByTitle(keyword).stream().map(BookConverter::convertToBookDto).toList();

	}

	public List<BookDto> getBooksInPriceRange(Double min, Double max) {

		return repo.findBooksInPriceRange(min, max).stream().map(BookConverter::convertToBookDto).toList();

	}

}
