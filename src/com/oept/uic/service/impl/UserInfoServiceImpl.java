package com.oept.uic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.oept.uic.dao.UserDao;
import com.oept.uic.model.User;
import com.oept.uic.service.UserInfoService;
/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/14
 * Description: User info service implementor.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Qualifier("UserDao")
	@Autowired
	private UserDao UserDao;
	
	@Override
	public User getUserByName(String username) throws Exception {
		// TODO Auto-generated method stub
		return UserDao.getUserByName(username);
	}
	
	@Override
	public User getUserById(int userId) throws Exception {
		// TODO Auto-generated method stub
		return UserDao.getUserById(userId);
	}

	@Override
	public boolean InsertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return UserDao.insertUser(user);
	}
	
	@Override
	public boolean deleteUserById(int userId) {
		// TODO Auto-generated method stub
		return UserDao.deleteUserById(userId);
	}
	
	@Override
	public boolean updateUserById(User user) {
		// TODO Auto-generated method stub
		return UserDao.updateUserById(user);
	}

	@Override
	public List<User> queryForList() {
		// TODO Auto-generated method stub
		return UserDao.queryForList();
	}
}
