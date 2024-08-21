package com.wipro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wipro.mapper.UserRowMapper;
import com.wipro.model.User;
import com.wipro.payload.RequestPayload;


@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	UserRowMapper userRowMapper;

	@Override
	public User getUserById(Integer id) {
		String query = "SELECT * FROM USER_24 WHERE ID = ?";
		return (User) jdbcTemplate.queryForObject(query, userRowMapper, id);
	}

	@Override
	public String addUser(User user) {
		if (user.getId() == null) {
	        return "User ID cannot be null";
	    }
		String query = "INSERT INTO USER_24 (ID, NAME) VALUES (?, ?)";
		int n = jdbcTemplate.update(query, user.getId(), user.getName());
		return n>0 ? "User "+user.getId()+" added" : "no data added";
	}

	@Override
	public List<User> getAllUsers() {
		String query = "SELECT * FROM USER_24";
		return jdbcTemplate.query(query, userRowMapper);
	}

	@Override
	public User updateUser(RequestPayload requestPayload) {
		
		String query = "UPDATE USER_24 SET NAME = ? WHERE ID = ?";
		int n = jdbcTemplate.update(query, requestPayload.getName(), requestPayload.getId());
		return this.getUserById(requestPayload.getId());
//		String query1 = "SELECT * FROM USER_24 WHERE ID = ?";
//		User user = (User) jdbcTemplate.queryForObject(query1, userRowMapper, requestPayload.getId());
		
	}
	
	
}
