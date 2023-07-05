package com.app.bookstore.exemplary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import com.app.bookstore.appointment.Appointment;
import com.app.bookstore.book.Book;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity(name = "exemplary")
@Table(name = "exemplary", schema = "public")
public class Exemplary {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "release_date")
	private LocalDate releaseDate;

	@Column(name = "stamp_code")
	private String stampCode;

	@Column(name = "page_number")
	private Integer pageNumber;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id")
	private Book book;
	
	@OneToMany(mappedBy = "exemplary", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Appointment> appointments;
	
	@Version
	private Integer version;
	
	@Column(name = "control_date")
	private LocalDateTime controlDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getStampCode() {
		return stampCode;
	}

	public void setStampCode(String stampCode) {
		this.stampCode = stampCode;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	public void addAppointment(Appointment appointment) {
		this.appointments.add(appointment);
		appointment.setExemplary(this);
	}
	
	public void removeAppointment(Appointment appointment) {
		this.appointments.remove(appointment);
		appointment.setExemplary(null);
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public LocalDateTime getControlDate() {
		return controlDate;
	}

	public void setControlDate(LocalDateTime controlDate) {
		this.controlDate = controlDate;
	}

}
