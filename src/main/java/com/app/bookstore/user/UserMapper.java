package com.app.bookstore.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
	
	public User userCreateDTO2User(UserCreateDTO userCreateDto) {
		User user = new User();
		user.setAge(userCreateDto.getAge());
		user.setEmail(userCreateDto.getEmail());
		user.setFirstName(userCreateDto.getFirstName());
		user.setLastName(userCreateDto.getLastName());
		return user;
	}
	
	public UserGetDTO user2UserGetDTO(User user) {
		UserGetDTO userGetDTO = new UserGetDTO();
		userGetDTO.setAge(user.getAge());
		userGetDTO.setEmail(user.getEmail());
		userGetDTO.setFirstName(user.getFirstName());
		userGetDTO.setLastName(user.getLastName());
		userGetDTO.setId(user.getId());
		return userGetDTO;
	}

}
