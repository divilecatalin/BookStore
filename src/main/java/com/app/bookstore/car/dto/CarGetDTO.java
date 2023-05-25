package com.app.bookstore.car.dto;

import java.time.LocalDate;

public class CarGetDTO {
	
	private Integer id;
	private String marca;
	private String model;
	private LocalDate dataFabricatiei;
	private Integer caiPutere;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	
	@Override
	public String toString() {
		return "CarGetDTO [id=" + id + ", marca=" + marca + ", model=" + model + ", dataFabricatiei=" + dataFabricatiei
				+ ", caiPutere=" + caiPutere + "]";
	}
	
	
	
}
