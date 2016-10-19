package com.oept.uic.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.oept.uic.model.Permission;
import com.oept.uic.model.User;

/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/16
 * Description: Permission info dao inteface.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
public interface PermissionDao {
	/**
	 * Insert permission info
	 * @param user permission model object
	 * @return return true if insert succeed
	 * @throws Exception 
	 */
	public boolean insertPermission(Permission permission);
	/**
	 * Get permission info by permission name
	 * @param name permission name
	 * @return return permission model object
	 * @throws Exception 
	 */
	public User getPermissionById(String name);
	/**
	 * Get all permissions info
	 * @return return permission model List
	 * @throws Exception 
	 */
	public List<Permission> queryForList();
	/**
	 * Get permissions list
	 * @param userId user id
	 * @return return permission model List
	 * @throws Exception 
	 */
	public List<Permission> queryForList(int userId);
	
	public void set_jdbc(JdbcTemplate jdbcTemplate);
	/**
	 * Add permission for one user
	 * @param permissionId permission id
	 * @param userId user id
	 * @return return true if add succeed
	 * @throws Exception 
	 */
	boolean addPermissionForUser(int permissionId, int userId);
	/**
	 * Clear permission for one user
	 * @param userId user id
	 * @return return true if add succeed
	 * @throws Exception 
	 */
	boolean clearPermissionForUser(int userId);

}
