package com.wipro.service;

import java.util.List;

import com.wipro.model.User;
import com.wipro.payload.RequestPayload;

public interface UserService {

	public abstract User getUserById(Integer Id);
	public abstract String addUser(User user);//post
	public abstract List<User> getAllUsers();
	public abstract User updateUser(RequestPayload requestPayload);
}
