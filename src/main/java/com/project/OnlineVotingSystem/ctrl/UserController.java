package com.project.OnlineVotingSystem.ctrl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.OnlineVotingSystem.model.User;
import com.project.OnlineVotingSystem.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public User registerUser(@RequestBody User user) 
	{
		return userService.registerUser(user);
	
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) 
	{
		return userService.updateUser(user);
	
	}
	
	@DeleteMapping("/users/{userId}")
	public User deleteUser(@PathVariable int userId) 
	{
		return userService.deleteUser(userId);
	
	}
	
	@GetMapping("/users")
	public List<User> viewUserList()
	{
		return userService.viewUserList();
	
	}
	
	@GetMapping("/users/{userId}")
	public Optional<User> findByUserId(@PathVariable int userId) 
	{
		return userService.findByUserId(userId);
	
	}


}
