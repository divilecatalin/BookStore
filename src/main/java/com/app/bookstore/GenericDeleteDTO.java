package com.app.bookstore;

public class GenericDeleteDTO {
	
	private Integer bookId;
	private Integer userId;
	private Integer exemplaryId;
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getExemplaryId() {
		return exemplaryId;
	}
	public void setExemplaryId(Integer exemplaryId) {
		this.exemplaryId = exemplaryId;
	}
	
}
