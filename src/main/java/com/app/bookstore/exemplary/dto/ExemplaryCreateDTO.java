package com.app.bookstore.exemplary.dto;

import java.time.LocalDate;

import com.app.bookstore.exception.BasicInfo;
import com.app.bookstore.exception.EmptyInfo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ExemplaryCreateDTO {

	@NotNull(groups = BasicInfo.class)
	@NotEmpty(groups = EmptyInfo.class)
	private LocalDate releaseDate;
	@NotNull(groups = BasicInfo.class)
	@NotEmpty(groups = EmptyInfo.class)
	private String stampCode;
	private Integer pageNumber;
	@NotNull(groups = BasicInfo.class)
	@NotEmpty(groups = EmptyInfo.class)
	private Integer bookId;

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getStampCode() {
		return stampCode;
	}

	public void setStampCode(String stampCode) {
		this.stampCode = stampCode;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

}
