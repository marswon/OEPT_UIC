package com.oept.uic.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.oept.uic.model.Dashboard;

/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/14
 * Description: User info dao inteface.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
public interface DashOutputDao {
	/**
	 * Insert user info
	 * @param user user model object
	 * @return return Dashboard data list
	 * @throws Exception 
	 */
	public List<Dashboard> getDashboardOutput();

	
	public void set_jdbc(JdbcTemplate jdbcTemplate);


	boolean updateDashOutput(Dashboard dashboard);


	public List<Dashboard> getDashboard3();

}
