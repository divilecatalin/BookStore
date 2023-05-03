package com.app.bookstore.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Integer>{
	 List<Book> findByName(String name);

}
