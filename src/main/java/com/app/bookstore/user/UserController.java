package com.app.bookstore.user;

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

import com.app.bookstore.exception.ValidationOrder;
import com.app.bookstore.user.dto.UserCreateDTO;
import com.app.bookstore.user.dto.UserGetDTO;
import com.app.bookstore.user.mapper.UserMapper;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/list")
	public List<User> findAll(){
		return userService.findAll();
	}
	
//	@PostMapping()
//	public UserGetDTO createUser(@RequestBody UserCreateDTO userCreateDto) {
//		User user = userMapper.userCreateDTO2User(userCreateDto);
//		User createdUser = userService.create(user);
//		return userMapper.user2UserGetDTO(createdUser);
//	}
	
	@PostMapping()
	public ResponseEntity<UserGetDTO> createUser(@Validated(value = ValidationOrder.class) @RequestBody UserCreateDTO userCreateDto){
		User user = userService.create(userMapper.userCreateDTO2User(userCreateDto));
		return new ResponseEntity<>(userMapper.user2UserGetDTO(user),HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{id}")
	public UserGetDTO update(@RequestBody UserCreateDTO userCreateDto, @PathVariable Integer id) {
		User user = userMapper.userCreateDTO2User(userCreateDto);
		User updatedUser = userService.update(user,id);
		return userMapper.user2UserGetDTO(updatedUser);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		userService.delete(id);
	}
}
