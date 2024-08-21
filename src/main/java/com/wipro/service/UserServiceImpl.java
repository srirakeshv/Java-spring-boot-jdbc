package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dao.UserDao;
import com.wipro.model.User;
import com.wipro.payload.RequestPayload;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public User getUserById(Integer id) {
		
		return userDao.getUserById(id);
	}

	@Override
	public String addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userDao.getAllUsers();
	}

	@Override
	public User updateUser(RequestPayload requestPayload) {
		
		return userDao.updateUser(requestPayload);
	}

	

	
	
}
