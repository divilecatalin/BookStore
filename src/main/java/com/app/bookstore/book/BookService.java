package com.app.bookstore.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bookstore.author.Author;
import com.app.bookstore.author.AuthorRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;
	
	public Book create(Book book) {
		return bookRepository.saveAndFlush(book);
	}
	
	public Book createWithAuthors(Book book, List<Integer> authorsId) {
		List<Author> authors = authorRepository.findAllById(authorsId);
		authors.stream().forEach(author -> author.addBook(book));
		return bookRepository.saveAndFlush(book);
	}
	
	public Book findById(Integer id) {
		return bookRepository.findById(id).orElseThrow();
	}
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public List<Book> findByName(String title){
		return bookRepository.findByTitle(title);
	}
	
	public List<Book> findByTitleContains(String title){
		return bookRepository.findByTitleContains(title);
	}
	
	public Book update(Book bookToUpdate,Integer id) {
		Book existingBook = bookRepository.findById(id).orElseThrow();
		existingBook.setTitle(bookToUpdate.getTitle());
		existingBook.setYear(bookToUpdate.getYear());
		existingBook.setIsbn(bookToUpdate.getIsbn());
		return bookRepository.save(existingBook);
	}
	
	public void delete(Integer id) {
		bookRepository.deleteById(id);
	}
	

}
