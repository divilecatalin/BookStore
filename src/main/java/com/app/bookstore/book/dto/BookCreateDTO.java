package com.app.bookstore.book.dto;

import java.time.LocalDate;

public class BookCreateDTO {
	
	private String title;
	private LocalDate year;
	private String isbn;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getYear() {
		return year;
	}
	public void setYear(LocalDate year) {
		this.year = year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {
		return "BookCreateDTO [title=" + title + ", year=" + year + ", isbn=" + isbn + "]";
	}
}
