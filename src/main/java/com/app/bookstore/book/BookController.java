package com.app.bookstore.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
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

import com.app.bookstore.book.dto.BookCreateDTO;
import com.app.bookstore.book.dto.BookGetDTO;
import com.app.bookstore.book.dto.BookWithAuthorsDTO;
import com.app.bookstore.book.dto.BookWithExemplariesDTO;
import com.app.bookstore.book.mapper.BookMapper;
import com.app.bookstore.exception.ValidationOrder;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookMapper bookMapper;

	@Autowired
	private BookService bookService;

//	@PostMapping()
//	public BookGetDTO createBook(@RequestBody BookCreateDTO bookCreateDTO) {
//		Book book = bookMapper.bookCreateDTO2Book(bookCreateDTO);
//		Book createdBook = bookService.create(book);
//		return bookMapper.book2BookGetDTO(createdBook);
//	}

	@PostMapping
	public ResponseEntity<BookGetDTO> createBook(@Validated(value = ValidationOrder.class) @RequestBody BookCreateDTO bookCreateDTO) {
		Book book = bookService.create(bookMapper.bookCreateDTO2Book(bookCreateDTO));
		return new ResponseEntity<>(bookMapper.book2BookGetDTO(book), HttpStatus.CREATED);
	}

	@PostMapping("/create")
	public ResponseEntity<BookWithAuthorsDTO> createBookWithAuthors(@RequestBody BookCreateDTO bookCreateDTO) {
		Book book = bookService.createWithAuthors(bookMapper.bookCreateDTO2Book(bookCreateDTO),
				bookCreateDTO.getAuthorsId());
		return new ResponseEntity<>(bookMapper.book2BookWithAuthorsDTO(book), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public BookGetDTO findById(@PathVariable Integer id) {
		Book book = bookService.findById(id);
		return bookMapper.book2BookGetDTO(book);
	}

	@GetMapping("/name")
	public List<BookGetDTO> findByName(@RequestParam String name) {
		return bookMapper.listBook2listGetDTO(bookService.findByName(name));
	}

	@GetMapping("/search")
	public ResponseEntity<List<BookGetDTO>> findByBookTitleOrAuthorName(@RequestParam String field) {

		List<Book> list = bookService.findByBookTitleOrAuthorName(field);
		if (CollectionUtils.isEmpty(list)) {
			return new ResponseEntity<>(bookMapper.listBook2listGetDTO(list), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(bookMapper.listBook2listGetDTO(list), HttpStatus.OK);
	}

	@GetMapping("/list")
	public List<BookGetDTO> findAll() {
		return bookMapper.listBook2listGetDTO(bookService.findAll());
	}
	
	@GetMapping("/listPag")
	public List<BookGetDTO> findAllPaginated(@RequestParam Integer pageSize,@RequestParam Integer pageNumber) {
		Integer page = pageNumber;
		if(pageNumber !=0) {
			page = pageNumber*pageSize;
		}
		return bookMapper.listBook2listGetDTO(bookService.findAllPaginated(pageSize, page));
	}
	
	@GetMapping("/listPag2")
	public List<BookGetDTO> findPaginated(@RequestParam Integer pageSize,@RequestParam Integer pageNumber) {
		return bookMapper.listBook2listGetDTO(bookService.findPaginated(pageSize,pageNumber));
	}

	// duce la n+1 select problem (1 query pentru parinte, n query-uri pentru
	// fiecare parinte (n = numarul de parinti))
	@GetMapping("/list-with-exemplaries")
	public List<BookWithExemplariesDTO> findAllWithExemplaries() {
		return bookMapper.bookList2BooksWithExemplariesDTO(bookService.findAll());
	}

	@PutMapping("/{id}")
	public BookGetDTO update(@RequestBody BookCreateDTO bookCreateDTO, @PathVariable Integer id) {
		Book book = bookMapper.bookCreateDTO2Book(bookCreateDTO);
		Book bookUpdate = bookService.update(book, id);
		return bookMapper.book2BookGetDTO(bookUpdate);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		bookService.delete(id);
	}

}
