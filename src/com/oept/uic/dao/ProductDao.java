package com.oept.uic.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.oept.uic.model.Product;

/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/17
 * Description: Product info dao inteface.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
public interface ProductDao {
	/**
	 * Get all users info
	 * @return return User model object
	 * @throws Exception 
	 */
	public List<Product> queryForList();
	
	public void set_jdbc(JdbcTemplate jdbcTemplate);

}
