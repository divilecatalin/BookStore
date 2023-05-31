package com.app.bookstore.author.dto;

import java.time.LocalDate;
import java.util.List;

import com.app.bookstore.book.dto.BookGetDTO;

public class AuthorWithBooksDTO {

	private Integer id;
	private String name;
	private LocalDate birthDate;
	private LocalDate deathDate;
	private String gender;
	private String nationality;
	private List<BookGetDTO> books;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public LocalDate getDeathDate() {
		return deathDate;
	}
	public void setDeathDate(LocalDate deathDate) {
		this.deathDate = deathDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public List<BookGetDTO> getBooks() {
		return books;
	}
	public void setBooks(List<BookGetDTO> books) {
		this.books = books;
	}
	
	
}
