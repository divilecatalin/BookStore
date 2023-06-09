package com.app.bookstore.user.mapper;

import org.springframework.stereotype.Component;

import com.app.bookstore.user.User;
import com.app.bookstore.user.dto.UserCreateDTO;
import com.app.bookstore.user.dto.UserGetDTO;

@Component
public class UserMapper {
	
	public User userCreateDTO2User(UserCreateDTO userCreateDto) {
		User user = new User();
		user.setName(userCreateDto.getName());
		user.setAge(userCreateDto.getAge());
		user.setEmail(userCreateDto.getEmail());
		user.setFirstName(userCreateDto.getFirstName());
		user.setLastName(userCreateDto.getLastName());
		return user;
	}
	
	public UserGetDTO user2UserGetDTO(User user) {
		UserGetDTO userGetDTO = new UserGetDTO();
		userGetDTO.setName(user.getName());
		userGetDTO.setAge(user.getAge());
		userGetDTO.setEmail(user.getEmail());
		userGetDTO.setFirstName(user.getFirstName());
		userGetDTO.setLastName(user.getLastName());
		userGetDTO.setId(user.getId());
		return userGetDTO;
	}

}
