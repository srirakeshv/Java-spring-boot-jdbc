package com.wipro.dao;

import java.util.List;

import com.wipro.model.User;
import com.wipro.payload.RequestPayload;

public interface UserDao {

	public abstract User getUserById(Integer id);//GET gives 1 value 
	public abstract String addUser(User user);//POST
	public abstract List<User> getAllUsers();//GET
	public abstract User updateUser(RequestPayload requestPayload);//PUT
}
