package com.app.bookstore.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	public List<Book> findAllPaginated(Integer pageSize, Integer pageNumber){
		return bookRepository.findAllPaginated(pageSize, pageNumber);
	}
	
	public List<Book> findPaginated(Integer pageSize, Integer pageNumber){
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return bookRepository.findAllBooks(pageable,"Baltagul");
	}
	
	public List<Book> findByName(String title){
		return bookRepository.findByTitle(title);
	}
	
	public List<Book> findByTitleContains(String title){
		return bookRepository.findByTitleContains(title);
	}
	
	public List<Book> findByBookTitleOrAuthorName(String field){
		return bookRepository.findBookByTitleOrAuthorName(field);
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
