package com.app.bookstore.author.dto;

import java.time.LocalDate;

import com.app.bookstore.exception.BasicInfo;
import com.app.bookstore.exception.EmptyInfo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AuthorCreateDTO {

	@NotNull(groups = BasicInfo.class)
	@NotEmpty(groups = EmptyInfo.class)
	private String name;
	
	private LocalDate birthDate;
	
	private LocalDate deathDate;
	
	private String gender;
	@NotNull(groups = BasicInfo.class)
	@NotEmpty(groups = EmptyInfo.class)
	private String nationality;

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
	
	
}
