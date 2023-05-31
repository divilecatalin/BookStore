package com.app.bookstore.book.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.bookstore.author.mapper.AuthorMapper;
import com.app.bookstore.book.Book;
import com.app.bookstore.book.dto.BookCreateDTO;
import com.app.bookstore.book.dto.BookGetDTO;
import com.app.bookstore.book.dto.BookWithAuthorsDTO;
import com.app.bookstore.book.dto.BookWithExemplariesDTO;
import com.app.bookstore.exemplary.mapper.ExemplaryMapper;

@Component
public class BookMapper {
	
	@Autowired
	private ExemplaryMapper exemplaryMapper;
	
	@Autowired
	private AuthorMapper authorMapper;
	
	public Book bookCreateDTO2Book(BookCreateDTO bookDto) {
		Book book = new Book();
		book.setIsbn(bookDto.getIsbn());
		book.setTitle(bookDto.getTitle());
		book.setYear(bookDto.getYear());
		return book;
	}
	
	public BookGetDTO book2BookGetDTO(Book book) {
		BookGetDTO bookGetDto = new BookGetDTO();
		bookGetDto.setId(book.getId());
		bookGetDto.setIsbn(book.getIsbn());
		bookGetDto.setTitle(book.getTitle());
		bookGetDto.setYear(book.getYear());
		return bookGetDto;
	}
	
	public List<BookGetDTO> listBook2listGetDTO(List<Book> books){
		return books.stream()
				.map(book->book2BookGetDTO(book))
				.toList();
	}
	
	public List<BookWithExemplariesDTO> bookList2BooksWithExemplariesDTO(List<Book> books){
		return books.stream()
				.map(book -> book2BookWithExemplariesDTO(book))
				.toList();
	}
	
	private BookWithExemplariesDTO book2BookWithExemplariesDTO(Book book) {
		BookWithExemplariesDTO bookGetDto = new BookWithExemplariesDTO();
		bookGetDto.setId(book.getId());
		bookGetDto.setIsbn(book.getIsbn());
		bookGetDto.setTitle(book.getTitle());
		bookGetDto.setYear(book.getYear());
		bookGetDto.setExemplaries(book.getExemplaries().stream().map(exemplary -> exemplaryMapper.exemplary2ExemplaryGetDTO(exemplary)).toList());
		return bookGetDto;
	}
	
	public List<BookWithAuthorsDTO> bookList2BookWithAuthorsDTO(List<Book> books){
		return books.stream()
				.map(book -> book2BookWithAuthorsDTO(book))
				.toList();
	}
	
	public BookWithAuthorsDTO book2BookWithAuthorsDTO (Book book) {
		BookWithAuthorsDTO bookGetDto = new BookWithAuthorsDTO();
		bookGetDto.setId(book.getId());
		bookGetDto.setIsbn(book.getIsbn());
		bookGetDto.setTitle(book.getTitle());
		bookGetDto.setYear(book.getYear());
		bookGetDto.setAuthors(book.getAuthors().stream().map(author -> authorMapper.author2AuthorGetDTO(author)).toList());
		return bookGetDto;
	}
	

}
