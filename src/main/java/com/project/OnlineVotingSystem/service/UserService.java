package com.project.OnlineVotingSystem.service;

import java.util.List;
import java.util.Optional;

import com.project.OnlineVotingSystem.model.User;

public interface UserService {
	User registerUser(User user);
	User updateUser(User user);
	User deleteUser(int userId);
	List<User>viewUserList();
	Optional<User> findByUserId(int userId);


}
