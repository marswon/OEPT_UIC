/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/14
 * Description: User Info Interface.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
package com.oept.uic.service;

import java.util.List;

import com.oept.uic.model.User;

public interface UserInfoService {
	/**
	 * Get user info by username
	 * @param username user name
	 * @return return User model object
	 * @throws Exception 
	 */
	public User getUserByName(String username) throws Exception;
	/**
	 * Insert user info
	 * @param user user model info
	 * @return return true if user was inserted
	 * @throws Exception 
	 */
	public boolean InsertUser(User user) throws Exception;
	/**
	 * Get user info by user id
	 * @param userId user id
	 * @return return User model object
	 * @throws Exception 
	 */
	public User getUserById(int userId) throws Exception;
	/**
	 * Get all users info
	 * @return return User model object
	 * @throws Exception 
	 */
	public List<User> queryForList();
	/**
	 * delete user info
	 * @param userId user id
	 * @return return true if user was deleted
	 * @throws Exception 
	 */
	boolean deleteUserById(int userId);
	/**
	 * Update user info
	 * @param user user model info
	 * @return return true if user was updated
	 * @throws Exception 
	 */
	boolean updateUserById(User user);
	
}