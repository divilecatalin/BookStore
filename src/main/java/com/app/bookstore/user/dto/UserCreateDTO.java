package com.app.bookstore.user.dto;

import com.app.bookstore.exception.AdvanceInfo;
import com.app.bookstore.exception.BasicInfo;
import com.app.bookstore.exception.EmptyInfo;
import com.app.bookstore.exception.ValidAge;
import com.app.bookstore.exception.ValidEmail;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserCreateDTO {
	@NotNull(groups = BasicInfo.class)
	@NotEmpty(groups = EmptyInfo.class)
	private String name;
	@NotNull(groups = BasicInfo.class)
	@NotEmpty(groups = EmptyInfo.class)
	private String firstName;
	@NotNull(groups = BasicInfo.class)
	@NotEmpty(groups = EmptyInfo.class)
	private String lastName;
	@NotNull(groups = BasicInfo.class)
	@ValidAge(groups = AdvanceInfo.class)
	private Integer age;
	@NotNull(groups = BasicInfo.class)
	@NotEmpty(groups = EmptyInfo.class)
	@ValidEmail(groups = AdvanceInfo.class)
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
