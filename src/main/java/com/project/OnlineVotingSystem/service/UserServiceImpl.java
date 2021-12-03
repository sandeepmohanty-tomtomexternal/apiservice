package com.project.OnlineVotingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineVotingSystem.dao.UserDao;
import com.project.OnlineVotingSystem.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public User registerUser(User user) {
		return userDao.save(user);
	}

	@Override
	public User updateUser(User user) {
		int userId = user.getUserId();
		Optional<User> existingUserContainer = userDao.findById(userId);
		User existingUser = null;
		if(existingUserContainer.isPresent()) {
			existingUser = existingUserContainer.get();
			existingUser.setEmailId(user.getEmailId());
			existingUser.setFirstName(user.getFirstName());
			existingUser.setLastName(user.getLastName());
			existingUser.setMobileno(user.getMobileno());
			existingUser.setPassword(user.getPassword());
			userDao.saveAndFlush(existingUser);
		}
		return existingUser;
	}

	@Override
	public User deleteUser(int userId) {
		Optional<User> existingUserContainer = userDao.findById(userId);
		User existingUser = null;
		if(existingUserContainer.isPresent()) {
			existingUser = existingUserContainer.get();
			userDao.deleteById(userId);
		}
		
		return existingUser;
	}

	@Override
	public List<User> viewUserList() {
		return userDao.findAll();
	}

	@Override
	public Optional<User> findByUserId(int UserId) {
		return userDao.findById(UserId);
	}

}