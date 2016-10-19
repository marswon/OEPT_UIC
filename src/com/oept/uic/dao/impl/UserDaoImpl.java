package com.oept.uic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.oept.uic.dao.UserDao;
import com.oept.uic.model.User;

/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/14
 * Description: User info dao implementor.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
@Repository("UserDao")
public class UserDaoImpl implements UserDao {
	
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	private final static String _INSERT_STRING1="insert into uic_user (uic_username,uic_password,uic_lastname,uic_firstname)"
			+ " values (?,?,?,?)";
	private final static String _DELETE_STRING1="delete from uic_user where uic_user_id=?";
	private final static String _SELECT_STRING1="select * from uic_user where uic_username = ?";
	private final static String _SELECT_STRING2="select * from uic_user where uic_user_id = ?";
	private final static String _SELECT_STRING3="select * from uic_user";
	private final static String _UPDATE_STRING1="UPDATE uic_user SET uic_username = ?, uic_password = ?,"
			+ "uic_lastname = ?,uic_firstname=? "
			+ "WHERE uic_user_id = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate get_jdbc() {
		return jdbcTemplate;
	}

	@Override
	public void set_jdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		try{
		Object[] params = new Object[] {
				user.get_uic_username(),
				user.get_uic_password(),
				user.get_uic_lastname(),
				user.get_uic_firstname()};
		jdbcTemplate.update(_INSERT_STRING1,params);
		return true;
		}catch(Exception e){
			logger.info(e.getMessage());
			throw e;
		}
	}
	
	@Override
	public boolean deleteUserById(int userId) {
		// TODO Auto-generated method stub
		try{
		Object[] params = new Object[] {
				userId};
		jdbcTemplate.update(_DELETE_STRING1,params);
		return true;
		}catch(Exception e){
			logger.info(e.getMessage());
			throw e;
		}
	}
	
	@Override
	public boolean updateUserById(User user) {
		// TODO Auto-generated method stub
		try{
		Object[] params = new Object[] {
				user.get_uic_username(),
				user.get_uic_password(),
				user.get_uic_lastname(),
				user.get_uic_firstname(),
				user.get_uic_user_id()};
		jdbcTemplate.update(_UPDATE_STRING1,params);
		return true;
		}catch(Exception e){
			logger.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public User getUserByName(String username) {
		 
		Object[] params = new Object[] {username};
          
        return (User) jdbcTemplate.queryForObject(_SELECT_STRING1, params, new RowMapper<Object>(){  
            @Override  
            public Object mapRow(ResultSet rs,int rowNum)throws SQLException {  
                User user  = new User();  
                user.set_uic_user_id(rs.getInt("uic_user_id"));  
                user.set_uic_username(rs.getString("uic_username"));  
                user.set_uic_password(rs.getString("uic_password"));
                user.set_uic_firstname(rs.getString("uic_firstname"));
                user.set_uic_lastname(rs.getString("uic_lastname"));
                return user;  
            } 
        });
	}
	
	@Override
	public User getUserById(int userId) {
		
		Object[] params = new Object[] {userId};
          
        return (User) jdbcTemplate.queryForObject(_SELECT_STRING2, params, new RowMapper<Object>(){  
            @Override  
            public Object mapRow(ResultSet rs,int rowNum)throws SQLException {  
                User user  = new User();  
                user.set_uic_user_id(rs.getInt("uic_user_id"));  
                user.set_uic_username(rs.getString("uic_username"));  
                user.set_uic_password(rs.getString("uic_password"));
                user.set_uic_firstname(rs.getString("uic_firstname"));
                user.set_uic_lastname(rs.getString("uic_lastname"));
                return user;  
            } 
        });
	}
	
	public List<User> queryForList() {  
		return jdbcTemplate.query(_SELECT_STRING3,   
                new RowMapper<User>(){         
                    @Override  
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {  
                        User user  = new User();  
                        user.set_uic_user_id(rs.getInt("uic_user_id"));  
                        user.set_uic_username(rs.getString("uic_username"));  
                        user.set_uic_password(rs.getString("uic_password"));
                        user.set_uic_firstname(rs.getString("uic_firstname"));
                        user.set_uic_lastname(rs.getString("uic_lastname")); 
                        return user;  
                    }  
        }); 
    }

}
