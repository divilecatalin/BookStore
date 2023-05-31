package com.app.bookstore.book;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.app.bookstore.author.Author;
import com.app.bookstore.exemplary.Exemplary;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="book", schema="public")
public class Book {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="year")
	private LocalDate year; // o lista de autori
	
	@Column(name="isbn")
	private String isbn;
	
	//lazy - daca incarc parintele, nu imi aduce si copiii la incarcarea parintelui
	//eager - daca incarca parintele, imi aduce si copiii (join) la incarcarea parintelui
	//de la parinte la copil: lazy
	//de la copil la parinte: eager
	@OneToMany(mappedBy = "book", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Exemplary> exemplaries;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "author_id", nullable = false))
	private Set<Author> authors = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getYear() {
		return year;
	}

	public void setYear(LocalDate year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Exemplary> getExemplaries() {
		return exemplaries;
	}

	public void setExemplaries(Set<Exemplary> exemplaries) {
		this.exemplaries = exemplaries;
	}
	
	public void addExemplary(Exemplary exemplary) {
		this.exemplaries.add(exemplary);
		exemplary.setBook(this);
	}
	
	public void removeExemplary(Exemplary exemplary) {
		this.exemplaries.remove(exemplary);
		exemplary.setBook(null);
	}
	
	public void addAuthor(Author author) {
		this.authors.add(author);
		author.getBooks().add(this);
	}
	
	public void removeAuthor(Author author) {
		this.authors.remove(author);
		author.getBooks().remove(this);
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	
}
