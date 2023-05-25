package com.app.bookstore.person.dto;

import java.util.List;

import com.app.bookstore.car.dto.CarGetDTO;

public class PersonWithCarsDTO {

	private Integer id;
	private String nume;
	private String prenume;
	private Integer varsta;
	private List<CarGetDTO> cars;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public Integer getVarsta() {
		return varsta;
	}
	public void setVarsta(Integer varsta) {
		this.varsta = varsta;
	}
	public List<CarGetDTO> getCars() {
		return cars;
	}
	public void setCars(List<CarGetDTO> cars) {
		this.cars = cars;
	}
	
	
}
