package com.app.bookstore.appointment.dto;

import java.time.LocalDate;

import com.app.bookstore.exemplary.dto.ExemplaryGetDTO;
import com.app.bookstore.user.dto.UserGetDTO;

public class AppointmentGetDTO {
	
	private Integer id;
	private LocalDate startDate;
	private LocalDate endDate;
	private UserGetDTO users;
	private ExemplaryGetDTO exemplaries;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public UserGetDTO getUsers() {
		return users;
	}
	public void setUsers(UserGetDTO users) {
		this.users = users;
	}
	public ExemplaryGetDTO getExemplaries() {
		return exemplaries;
	}
	public void setExemplaries(ExemplaryGetDTO exemplaries) {
		this.exemplaries = exemplaries;
	}
	

}
