package com.app.bookstore.person.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.bookstore.car.mapper.CarMapper;
import com.app.bookstore.person.Person;
import com.app.bookstore.person.dto.PersonCreateDTO;
import com.app.bookstore.person.dto.PersonGetDTO;
import com.app.bookstore.person.dto.PersonWithCarsDTO;

@Component
public class PersonMapper {
	
	@Autowired
	private CarMapper carMapper;
	
	public Person personCreateDTO2Person(PersonCreateDTO personCreateDTO) {
		Person person = new Person();
		person.setNume(personCreateDTO.getNume());
		person.setPrenume(personCreateDTO.getPrenume());
		person.setVarsta(personCreateDTO.getVarsta());
		return person;
	}
	
	public PersonGetDTO person2PersonGetDTO(Person person) {
		PersonGetDTO personGetDTO = new PersonGetDTO();
		personGetDTO.setId(person.getId());
		personGetDTO.setNume(person.getNume());
		personGetDTO.setPrenume(person.getPrenume());
		personGetDTO.setVarsta(person.getVarsta());
		return personGetDTO;
	}
	
	public List<PersonGetDTO> listPerson2ListPersonGetDTO(List<Person> persons){
		return persons.stream()
				.map(person->person2PersonGetDTO(person))
				.toList();
	}
	
	public List<PersonWithCarsDTO> personList2PersonWithCarsDTO(List<Person> persons){
		return persons.stream()
				.map(person-> person2PersonWithCarsDTO(person))
				.toList();
	}
	
	public PersonWithCarsDTO person2PersonWithCarsDTO(Person person) {
		PersonWithCarsDTO personWithCarsDTO = new PersonWithCarsDTO();
		personWithCarsDTO.setId(person.getId());
		personWithCarsDTO.setNume(person.getNume());
		personWithCarsDTO.setPrenume(person.getPrenume());
		personWithCarsDTO.setVarsta(person.getVarsta());
		personWithCarsDTO.setCars(person.getCars().stream().map(car->carMapper.car2CarGetDTO(car)).toList());
		return personWithCarsDTO;
	}

}
