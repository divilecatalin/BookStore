package com.app.bookstore.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Author create(Author author) {
		return authorRepository.saveAndFlush(author);
	}
	
	public Author findById(Integer id) {
		return authorRepository.findById(id).orElseThrow();
	}
	
	public List<Author> findAll(){
		return authorRepository.findAll();
	}
	
	public List<Author> findByGender(String gender){
		return authorRepository.findByGender(gender);
	}
	
	public List<Author> findByNationality(String nationality){
		return authorRepository.findByNationality(nationality);
	}
	
	public List<Author> findByName(String name){
		return authorRepository.findByName(name);
	}
	
	public Author update(Author author,Integer id) {
		Author existingAuthor = authorRepository.findById(id).orElseThrow();
		existingAuthor.setBirthDate(author.getBirthDate());
		existingAuthor.setDeathDate(author.getDeathDate());
		existingAuthor.setGender(author.getGender());
		existingAuthor.setName(author.getName());
		existingAuthor.setNationality(author.getNationality());
		return authorRepository.save(existingAuthor);
	}
	
	public void delete(Integer id) {
		authorRepository.deleteById(id);
	}
	

}
