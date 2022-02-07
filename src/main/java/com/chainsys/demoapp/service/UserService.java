package com.chainsys.demoapp.service;

import java.util.List;

import com.chainsys.demoapp.dao.UserDAO;
import com.chainsys.demoapp.model.User;
import com.chainsys.demoapp.validator.UserValidator;

public class UserService {

	public List<User> findAllUsers() {
		UserDAO userDao = UserDAO.getInstance();
		return userDao.findAllUsers();
	}

	public boolean userInsert(User user) {
		UserDAO userDao = UserDAO.getInstance();
		return userDao.insertUser(user);
	}

	public boolean updateUser(User user) {
		UserDAO userDao = UserDAO.getInstance();
		return userDao.updateUser(user);
	}

	public User findUser(int userId) {
		UserDAO userDao = UserDAO.getInstance();
		return userDao.findUser(userId);
	}

	public User validateUser(String email, String password) {
		UserValidator userValidator = UserValidator.getInstance();
		return userValidator.validateUser(email, password);
	}
}
