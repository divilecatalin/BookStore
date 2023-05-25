package com.app.bookstore.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bookstore.person.Person;
import com.app.bookstore.person.PersonRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private PersonRepository personRepository;
	public Car create(Car car, Integer personId) {
		Person person = personRepository.findById(personId).orElseThrow();
		person.addCar(car);
		return carRepository.saveAndFlush(car);
	}
	
	public Car findById(Integer id) {
		return carRepository.findById(id).orElseThrow();
	}
	
	public List<Car> findAll(){
		return carRepository.findAll();
	}
	
	public Car update(Car car, Integer id) {
		Car existingCar = carRepository.findById(id).orElseThrow();
		existingCar.setCaiPutere(car.getCaiPutere());
		existingCar.setDataFabricatiei(car.getDataFabricatiei());
		existingCar.setMarca(car.getMarca());
		existingCar.setModel(car.getModel());
		return carRepository.save(existingCar);
	}
	
	public void delete(Integer id) {
		carRepository.deleteById(id);
	}

}
