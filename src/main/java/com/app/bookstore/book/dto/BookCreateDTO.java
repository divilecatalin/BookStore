package com.app.bookstore.book.dto;

import java.time.LocalDate;
import java.util.List;

import com.app.bookstore.exception.AdvanceInfo;
import com.app.bookstore.exception.BasicInfo;
import com.app.bookstore.exception.ValidYear;

import jakarta.validation.constraints.NotNull;

public class BookCreateDTO {

	@NotNull(groups = BasicInfo.class)
	private String title;
	@NotNull(groups = BasicInfo.class)
	@ValidYear(groups = AdvanceInfo.class)
	private LocalDate year;
	private String isbn;
	private List<Integer> authorsId;

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

	public List<Integer> getAuthorsId() {
		return authorsId;
	}

	public void setAuthorsId(List<Integer> authorsId) {
		this.authorsId = authorsId;
	}

	@Override
	public String toString() {
		return "BookCreateDTO [title=" + title + ", year=" + year + ", isbn=" + isbn + "]";
	}
}
