package com.app.bookstore.person;

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

import com.app.bookstore.person.dto.PersonCreateDTO;
import com.app.bookstore.person.dto.PersonGetDTO;
import com.app.bookstore.person.dto.PersonWithCarsDTO;
import com.app.bookstore.person.mapper.PersonMapper;

@RestController
@RequestMapping("/persons")
public class PersonController {
	@Autowired
	private PersonMapper personMapper;
	@Autowired
	private PersonService personService;

	@PostMapping()
	public ResponseEntity<PersonGetDTO> create(@RequestBody PersonCreateDTO personCreateDto) {
		Person person = personService.create(personMapper.personCreateDTO2Person(personCreateDto));
		return new ResponseEntity<>(personMapper.person2PersonGetDTO(person), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public PersonGetDTO findById(@PathVariable Integer id) {
		Person person = personService.findById(id);
		return personMapper.person2PersonGetDTO(person);
	}

	@GetMapping("/car/{id}")
	public PersonWithCarsDTO findByIdWithCar(@PathVariable Integer id) {
		Person person = personService.findById(id);
		return personMapper.person2PersonWithCarsDTO(person);
	}

	@GetMapping("/list")
	public List<PersonGetDTO> findAll() {
		return personMapper.listPerson2ListPersonGetDTO(personService.findAll());
	}

	@GetMapping("/list-with-cars")
	public List<PersonWithCarsDTO> findAllWithCars() {
		return personMapper.personList2PersonWithCarsDTO(personService.findAll());
	}

	@PutMapping("/{id}")
	public PersonGetDTO updatePerson(@RequestBody PersonCreateDTO personCreateDTO, @PathVariable Integer id) {
		Person person = personMapper.personCreateDTO2Person(personCreateDTO);
		Person personUpdate = personService.update(person, id);
		return personMapper.person2PersonGetDTO(personUpdate);
	}

	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable Integer id) {
		personService.delete(id);
	}
}
