package com.app.bookstore.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bookstore.car.dto.CarCreateDTO;
import com.app.bookstore.car.dto.CarGetDTO;
import com.app.bookstore.car.mapper.CarMapper;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	private CarMapper carMapper;
	
	@Autowired
	private CarService carService;
	
	@PostMapping
	public ResponseEntity<CarGetDTO> createCar(@RequestBody CarCreateDTO carCreateDTO){
		Car car = carService.create(carMapper.carCreateDTO2Car(carCreateDTO),carCreateDTO.getPersonId());
		return new ResponseEntity<>(carMapper.car2CarGetDTO(car),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public CarGetDTO findById(@PathVariable Integer id) {
		Car car = carService.findById(id);
		return carMapper.car2CarGetDTO(car);
	}
	
	@GetMapping("/list")
	public List<CarGetDTO> findAll(){
		return carMapper.carList2CarGetDTOList(carService.findAll());
	}
	
	@PutMapping("/{id}")
	public CarGetDTO update(@RequestBody CarCreateDTO carCreateDto, @PathVariable Integer id) {
		Car car = carMapper.carCreateDTO2Car(carCreateDto);
		Car updateCar = carService.update(car, id);
		return carMapper.car2CarGetDTO(updateCar);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		carService.delete(id);
	}

}
