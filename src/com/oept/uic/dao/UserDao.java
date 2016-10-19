package com.oept.uic.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.oept.uic.model.User;

/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/14
 * Description: User info dao inteface.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
public interface UserDao {
	/**
	 * Insert user info
	 * @param user user model object
	 * @return return true if insert succeed
	 * @throws Exception 
	 */
	public boolean insertUser(User user);
	/**
	 * Get user info by username
	 * @param username user name
	 * @return return User model object
	 * @throws Exception 
	 */
	public User getUserByName(String username);
	/**
	 * Get all users info
	 * @return return User model object
	 * @throws Exception 
	 */
	public List<User> queryForList();
	/**
	 * Get user info by user id
	 * @param username user id
	 * @return return User model object
	 * @throws Exception 
	 */
	public User getUserById(int userId);
	
	public void set_jdbc(JdbcTemplate jdbcTemplate);
	/**
	 * update user info
	 * @param user user model object
	 * @return return true if update succeed
	 * @throws Exception 
	 */
	boolean updateUserById(User user);
	/**
	 * delete user info
	 * @param userId user id
	 * @return return true if delete succeed
	 * @throws Exception 
	 */
	boolean deleteUserById(int userId);

}
