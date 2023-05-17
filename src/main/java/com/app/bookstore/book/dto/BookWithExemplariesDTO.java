package com.app.bookstore.book.dto;

import java.time.LocalDate;
import java.util.List;

import com.app.bookstore.exemplary.dto.ExemplaryGetDTO;

public class BookWithExemplariesDTO {
	private Integer id;
	private String title;
	private LocalDate year;
	private String isbn;
	private List<ExemplaryGetDTO> exemplaries;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public List<ExemplaryGetDTO> getExemplaries() {
		return exemplaries;
	}

	public void setExemplaries(List<ExemplaryGetDTO> exemplaries) {
		this.exemplaries = exemplaries;
	}

}
