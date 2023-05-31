package com.app.bookstore.author.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.bookstore.author.Author;
import com.app.bookstore.author.dto.AuthorCreateDTO;
import com.app.bookstore.author.dto.AuthorGetDTO;
import com.app.bookstore.author.dto.AuthorWithBooksDTO;
import com.app.bookstore.book.mapper.BookMapper;

@Component
public class AuthorMapper {
	
//	@Autowired
//	private BookMapper bookMapper;
	
	public Author authorCreateDTO2Author(AuthorCreateDTO authorCreateDTO) {
		Author author = new Author();
		author.setBirthDate(authorCreateDTO.getBirthDate());
		author.setDeathDate(authorCreateDTO.getDeathDate());
		author.setGender(authorCreateDTO.getGender());
		author.setName(authorCreateDTO.getName());
		author.setNationality(authorCreateDTO.getNationality());
		return author;
	}
	
	public AuthorGetDTO author2AuthorGetDTO(Author author) {
		AuthorGetDTO authorGetDTO = new AuthorGetDTO();
		authorGetDTO.setId(author.getId());
		authorGetDTO.setName(author.getName());
		authorGetDTO.setBirthDate(author.getBirthDate());
		authorGetDTO.setDeathDate(author.getDeathDate());
		authorGetDTO.setGender(author.getGender());
		authorGetDTO.setNationality(author.getNationality());
		return authorGetDTO;
	}
	
	public List<AuthorGetDTO> listAuhor2ListAuthorGetDTO(List<Author> authors){
		return authors.stream()
				.map(author -> author2AuthorGetDTO(author))
				.toList();
	}
	
	public List<AuthorWithBooksDTO> listAuthor2AuthorWithBooksDTO(List<Author> authors){
		return authors.stream()
				.map(author -> author2AuthorWithBoosDTO(author))
				.toList();
	}
	
	private AuthorWithBooksDTO author2AuthorWithBoosDTO(Author author) {
		AuthorWithBooksDTO authorGetDto = new AuthorWithBooksDTO();
		authorGetDto.setId(author.getId());
		authorGetDto.setName(author.getName());
		authorGetDto.setBirthDate(author.getBirthDate());
		authorGetDto.setDeathDate(author.getDeathDate());
		authorGetDto.setGender(author.getGender());
		authorGetDto.setNationality(author.getNationality());
		authorGetDto.setBooks(author.getBooks().stream().map(book ->new BookMapper().book2BookGetDTO(book)).toList());
		return authorGetDto;
	}

}
