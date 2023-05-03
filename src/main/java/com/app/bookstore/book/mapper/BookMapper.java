package com.app.bookstore.book.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.bookstore.book.Book;
import com.app.bookstore.book.dto.BookCreateDTO;
import com.app.bookstore.book.dto.BookGetDTO;

@Component
public class BookMapper {
	
	public Book bookCreateDTO2Book(BookCreateDTO bookDto) {
		Book book = new Book();
		book.setAuthor(bookDto.getAuthor());
		book.setName(bookDto.getName());
		book.setPrice(bookDto.getPrice());
		return book;
	}
	
	public BookGetDTO book2BookGetDTO(Book book) {
		BookGetDTO bookGetDto = new BookGetDTO();
		bookGetDto.setAuthor(book.getAuthor());
		bookGetDto.setId(book.getId());
		bookGetDto.setName(book.getName());
		bookGetDto.setPrice(book.getPrice());
		return bookGetDto;
	}
	
	public List<BookGetDTO> listBook2listGetDTO(List<Book> books){
		return books.stream()
				.map(book->book2BookGetDTO(book))
				.toList();
	}

}
