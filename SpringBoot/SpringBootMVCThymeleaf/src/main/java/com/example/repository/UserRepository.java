package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public class UserRepository {

	// Here we are using jdbc template you may also use JpaRepository interface 
    @Autowired
    private final JdbcTemplate jdbcTemplate;
    
    //Dependency Injection 
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    } 
     
    
    //6. from service class it will come here in repository to save into the database and to check whether user is already existing or not
    // and return the response back to service and then service will give response back to front controller
    
    // Check if username already exists
    public boolean userExists(String username) {
        String sql = "SELECT COUNT(*) FROM usertable WHERE username=?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, username);
        return count > 0;
    }

    // Insert new user into the database
    public int saveUser(User user) {
        String sql = "INSERT INTO usertable (username, password) VALUES (?, ?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }

	
}
