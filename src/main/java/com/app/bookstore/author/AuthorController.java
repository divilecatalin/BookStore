package com.app.bookstore.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.bookstore.author.dto.AuthorCreateDTO;
import com.app.bookstore.author.dto.AuthorGetDTO;
import com.app.bookstore.author.mapper.AuthorMapper;
import com.app.bookstore.exception.ValidationOrder;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	private AuthorMapper authorMapper;
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping
	public ResponseEntity<AuthorGetDTO> createAuthor(@Validated(value = ValidationOrder.class) @RequestBody AuthorCreateDTO authorCreateDTO){
		Author author = authorService.create(authorMapper.authorCreateDTO2Author(authorCreateDTO));
		return new ResponseEntity<>(authorMapper.author2AuthorGetDTO(author),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public AuthorGetDTO findById(@PathVariable Integer id) {
		Author author = authorService.findById(id);
		return authorMapper.author2AuthorGetDTO(author);
	}
	
	@GetMapping("/list")
	public List<Author> findAll(){
		return authorService.findAll();
	}
	
	@GetMapping("/name")
	public List<AuthorGetDTO> findByName(@RequestParam String name){
		return authorMapper.listAuhor2ListAuthorGetDTO(authorService.findByName(name));
	}
	
	@PutMapping("/{id}")
	public AuthorGetDTO updateAuthor(@RequestBody AuthorCreateDTO authorCreateDTO, @PathVariable Integer id) {
		Author author = authorMapper.authorCreateDTO2Author(authorCreateDTO);
		Author updatedAuthor = authorService.update(author, id);
		return authorMapper.author2AuthorGetDTO(updatedAuthor);
	}
	
	@DeleteMapping("/{id}")
	void deleteAuthor(@PathVariable Integer id) {
		authorService.delete(id);
	}

}
