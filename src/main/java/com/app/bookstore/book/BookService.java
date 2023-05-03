package com.app.bookstore.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	public Book create(Book book) {
		return bookRepository.saveAndFlush(book);
	}
	
	public Book findById(Integer id) {
		return bookRepository.findById(id).orElseThrow();
	}
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	
	public Book update(Book bookToUpdate,Integer id) {
		Book existingBook = bookRepository.findById(id).orElseThrow();
		existingBook.setAuthor(bookToUpdate.getAuthor());
		existingBook.setName(bookToUpdate.getName());
		existingBook.setPrice(bookToUpdate.getPrice());
		return bookRepository.save(existingBook);
	}
	
	public void delete(Integer id) {
		bookRepository.deleteById(id);
	}
	
	
	public List<Book> findByName(String name){
		return bookRepository.findByName(name);
	}

}
