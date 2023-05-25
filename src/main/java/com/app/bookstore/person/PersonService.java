package com.app.bookstore.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Person create(Person person) {
		return personRepository.saveAndFlush(person);
	}

	public Person findById(Integer id) {
		return personRepository.findById(id).orElseThrow();
	}

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person update(Person person, Integer id) {
		Person existingPerson = personRepository.findById(id).orElseThrow();
		existingPerson.setNume(person.getNume());
		existingPerson.setPrenume(person.getPrenume());
		existingPerson.setVarsta(person.getVarsta());
		return personRepository.save(existingPerson);
	}

	public void delete(Integer id) {
		personRepository.deleteById(id);
	}
}
