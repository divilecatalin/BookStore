package com.app.bookstore.appointment.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.bookstore.appointment.Appointment;
import com.app.bookstore.appointment.dto.AppointmentCreateDTO;
import com.app.bookstore.appointment.dto.AppointmentGetDTO;
import com.app.bookstore.exemplary.mapper.ExemplaryMapper;
import com.app.bookstore.user.mapper.UserMapper;

@Component
public class AppointmentMapper {
	
	@Autowired
	private ExemplaryMapper exemplaryMapper;
	@Autowired
	private UserMapper userMapper;
	
	public Appointment appointmentCreateDTO2Appointment(AppointmentCreateDTO appointmentCreateDTO){
		Appointment appointment = new Appointment();
		appointment.setStartDate(appointmentCreateDTO.getStartDate());
		appointment.setEndDate(appointmentCreateDTO.getEndDate());
		return appointment;
	}
	
	public AppointmentGetDTO appointment2AppointmentGetDto(Appointment appointment) {
		AppointmentGetDTO appointmentGetDto = new AppointmentGetDTO();
		appointmentGetDto.setId(appointment.getId());
		appointmentGetDto.setStartDate(appointment.getStartDate());
		appointmentGetDto.setEndDate(appointment.getEndDate());
		appointmentGetDto.setExemplaries(exemplaryMapper.exemplary2ExemplaryGetDTO(appointment.getExemplary()));
		appointmentGetDto.setUsers(userMapper.user2UserGetDTO(appointment.getUser()));
		return appointmentGetDto;
	}
	
	public List<AppointmentGetDTO> listAppointment2ListAppointmentGetDto(List<Appointment> appointments){
		return appointments.stream()
				.map(appointment -> appointment2AppointmentGetDto(appointment))
				.toList();
	}

}
