package com.app.bookstore.appointment.dto;

import java.time.LocalDate;

public class AppointmentCreateDTO {
	
	//@NotNull(groups = BasicInfo.class)
	//@NotEmpty(groups = EmptyInfo.class)
	private Integer userId;
	//@NotNull(groups = BasicInfo.class)
	//@NotEmpty(groups = EmptyInfo.class)
	private Integer exemplaryId;
	//@NotNull(groups = BasicInfo.class)
	//@NotEmpty(groups = EmptyInfo.class)
	private LocalDate startDate;
	//@NotNull(groups = BasicInfo.class)
	//@NotEmpty(groups = EmptyInfo.class)
	private LocalDate endDate;
	
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

}
