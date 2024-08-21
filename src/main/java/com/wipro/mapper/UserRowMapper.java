package com.wipro.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.wipro.model.User;

@Component
public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("ID"));
        user.setName(rs.getString("NAME"));
        
        
        return user;
    }
}






