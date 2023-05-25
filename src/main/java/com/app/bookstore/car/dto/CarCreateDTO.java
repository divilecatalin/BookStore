package com.app.bookstore.car.dto;

import java.time.LocalDate;

public class CarCreateDTO {
	
	private String marca;
	private String model;
	private LocalDate dataFabricatiei;
	private Integer caiPutere;
	private Integer personId;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public LocalDate getDataFabricatiei() {
		return dataFabricatiei;
	}
	public void setDataFabricatiei(LocalDate dataFabricatiei) {
		this.dataFabricatiei = dataFabricatiei;
	}
	public Integer getCaiPutere() {
		return caiPutere;
	}
	public void setCaiPutere(Integer caiPutere) {
		this.caiPutere = caiPutere;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	
	@Override
	public String toString() {
		return "CarCreateDTO [marca=" + marca + ", model=" + model + ", dataFabricatiei=" + dataFabricatiei
				+ ", caiPutere=" + caiPutere + "]";
	}
	
}
