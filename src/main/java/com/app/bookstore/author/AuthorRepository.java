package com.app.bookstore.author;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
	List<Author> findByName(String name);
	List<Author> findByNationality(String nationality);
	List<Author> findByGender(String gender);

}
