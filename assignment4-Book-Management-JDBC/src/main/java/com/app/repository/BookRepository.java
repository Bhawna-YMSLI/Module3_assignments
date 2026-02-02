package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("SELECT b FROM Book b WHERE b.author LIKE %:author%")
	List<Book> findByAuthor(@Param("author") String author);

	@Query("SELECT b FROM Book b WHERE   b.price < :price ")
	List<Book> findByPriceLessThan(@Param("price") Double price);

	@Modifying
	@Transactional
	@Query("delete from Book b where b.title = :title")
	void deleteByTitle(@Param("title") String title);

	@Query("SELECT b FROM Book b WHERE b.title LIKE %:title%")
	List<Book> searchByTitle(@Param("title") String title);

	@Query("SELECT b FROM Book b ORDER BY b.price DESC")
	List<Book> sortByPriceDesc();

	@Query(value = "SELECT * FROM books WHERE price BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Book> findBooksInPriceRange(Double min, Double max);
}
