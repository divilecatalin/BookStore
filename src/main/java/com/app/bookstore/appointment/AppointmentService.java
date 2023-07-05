package com.app.bookstore.appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bookstore.exemplary.Exemplary;
import com.app.bookstore.exemplary.ExemplaryRepository;
import com.app.bookstore.user.User;
import com.app.bookstore.user.UserRepository;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ExemplaryRepository exemplaryRepository;
	
	public Appointment createAppointment(Appointment appointment, Integer userId, Integer exemplaryId) {
		User user = userRepository.findById(userId).orElseThrow();
		Exemplary exemplary = exemplaryRepository.findById(exemplaryId).orElseThrow();
		exemplary.setControlDate(LocalDateTime.now());
		appointment.setUser(user);
		appointment.setExemplary(exemplary);
		return appointmentRepository.saveAndFlush(appointment);
	}
	
	public Appointment checkIfExemplaryAlreadyBooked(Integer exemplaryId, LocalDate startDate, LocalDate endDate) {
		return appointmentRepository.checkIfExemplaryAlreadyBooked(exemplaryId, startDate, endDate);
	}
	
	public Appointment findById(Integer id) {
		return appointmentRepository.findById(id).orElseThrow();
	}
	
	public List<Appointment> findAll(){
		return appointmentRepository.findAll();
	}
	
	public Appointment update(Appointment appointment, Integer appointmentId,Integer userId,Integer exemplaryId) {
		Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElseThrow();
		User existingUser = userRepository.findById(userId).orElseThrow();
		Exemplary existingExemplary = exemplaryRepository.findById(exemplaryId).orElseThrow();
		existingExemplary.setControlDate(LocalDateTime.now());
		existingAppointment.setExemplary(existingExemplary);
		existingAppointment.setUser(existingUser);
		existingAppointment.setStartDate(appointment.getStartDate());
		existingAppointment.setEndDate(appointment.getEndDate());
		return appointmentRepository.save(existingAppointment);
	}
	
	public void delete(Integer appointmentId,Integer userId,Integer exemplaryId) {
		Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
		User user = userRepository.findById(userId).orElseThrow();
		Exemplary exemplary = exemplaryRepository.findById(exemplaryId).orElseThrow();
		user.removeAppointment(appointment);
		exemplary.removeAppointment(appointment);
		appointmentRepository.flush();
	}

}
