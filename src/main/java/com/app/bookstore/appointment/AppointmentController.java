package com.app.bookstore.appointment;

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
import org.springframework.web.bind.annotation.RestController;

import com.app.bookstore.GenericDeleteDTO;
import com.app.bookstore.appointment.dto.AppointmentCreateDTO;
import com.app.bookstore.appointment.dto.AppointmentGetDTO;
import com.app.bookstore.appointment.mapper.AppointmentMapper;
import com.app.bookstore.exception.ValidationException;
import com.app.bookstore.exception.ValidationOrder;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private AppointmentMapper appointmentMapper;
	
	@PostMapping()
	public ResponseEntity<AppointmentGetDTO> createAppointment(@Validated(value = ValidationOrder.class) @RequestBody AppointmentCreateDTO appointmentCreateDto) throws ValidationException{
		Appointment appointmentCheck = appointmentService.checkIfExemplaryAlreadyBooked(appointmentCreateDto.getExemplaryId(),
				appointmentCreateDto.getStartDate(),appointmentCreateDto.getEndDate());
		if(appointmentCheck != null) {
			throw new ValidationException("Exemplary already booked from " + appointmentCheck.getStartDate() + " to " +appointmentCheck.getEndDate());
		}
		Appointment appointment = appointmentService.createAppointment(
				appointmentMapper.appointmentCreateDTO2Appointment(appointmentCreateDto), appointmentCreateDto.getUserId(), appointmentCreateDto.getExemplaryId());
		return new ResponseEntity<>(appointmentMapper.appointment2AppointmentGetDto(appointment),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public AppointmentGetDTO findById(@PathVariable Integer id) {
		Appointment appointment = appointmentService.findById(id);
		return appointmentMapper.appointment2AppointmentGetDto(appointment);
	}
	
	@GetMapping("/list")
	public List<AppointmentGetDTO> findAll(){
		return appointmentMapper.listAppointment2ListAppointmentGetDto(appointmentService.findAll());
	}
	
	@PutMapping("/{id}")
	public AppointmentGetDTO updateAppointment(@RequestBody AppointmentCreateDTO appointmentCreateDto,@PathVariable Integer id) {
		Appointment appointment = appointmentMapper.appointmentCreateDTO2Appointment(appointmentCreateDto);
		Appointment updatedAppointment = appointmentService.update(appointment, id, appointmentCreateDto.getUserId(), appointmentCreateDto.getExemplaryId());
		return appointmentMapper.appointment2AppointmentGetDto(updatedAppointment);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAppointment(@RequestBody GenericDeleteDTO deleteId, @PathVariable Integer id) {
		appointmentService.delete(id, deleteId.getUserId(), deleteId.getExemplaryId());
	}

}
