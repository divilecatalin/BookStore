package com.app.bookstore.car.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.bookstore.car.Car;
import com.app.bookstore.car.dto.CarCreateDTO;
import com.app.bookstore.car.dto.CarGetDTO;

@Component
public class CarMapper {
	
	public Car carCreateDTO2Car(CarCreateDTO carCreateDTO) {
		Car car = new Car();
		car.setCaiPutere(carCreateDTO.getCaiPutere());
		car.setDataFabricatiei(carCreateDTO.getDataFabricatiei());
		car.setMarca(carCreateDTO.getMarca());
		car.setModel(carCreateDTO.getModel());
		return car;
	}
	
	public CarGetDTO car2CarGetDTO(Car car) {
		CarGetDTO carGetDTO = new CarGetDTO();
		carGetDTO.setCaiPutere(car.getCaiPutere());
		carGetDTO.setDataFabricatiei(car.getDataFabricatiei());
		carGetDTO.setId(car.getId());
		carGetDTO.setMarca(car.getMarca());
		carGetDTO.setModel(car.getModel());
		return carGetDTO;
	}
	
	public List<CarGetDTO> carList2CarGetDTOList(List<Car> cars){
		return cars.stream()
				.map(car->car2CarGetDTO(car))
				.toList();
	}

}
