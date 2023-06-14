package com.app.bookstore.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "book_author")
@Table(name="book_author", schema="public")
public class BookAuthor {
	
	@EmbeddedId
	private BookAuthorPk bookAuthorPk;

	public BookAuthorPk getBookAuthorPk() {
		return bookAuthorPk;
	}

	public void setBookAuthorPk(BookAuthorPk bookAuthorPk) {
		this.bookAuthorPk = bookAuthorPk;
	}
	
	

}
