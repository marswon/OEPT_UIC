/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/16
 * Description: permission Info service interface.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
package com.oept.uic.service;

import java.util.List;

import com.oept.uic.model.Permission;

public interface PermissionInfoService {
	/**
	 * Insert permission info
	 * @param permission permission model info
	 * @return return true if permission was inserted
	 * @throws Exception 
	 */
	public boolean InsertPermission(Permission permission) throws Exception;
	/**
	 * Get all users info
	 * @return return User model object
	 * @throws Exception 
	 */
	public List<Permission> queryForList(int userId);
	/**
	 * Get all permission info
	 * @return return permission model object
	 * @throws Exception 
	 */
	public List<Permission> queryForList();
	/**
	 * Add permission info for one user
	 * @param permissionId permission id
	 * @param userId user id
	 * @return return true if add was executed
	 * @throws Exception 
	 */
	boolean addPermissionForUser(int permissionId, int userId) throws Exception;
	/**
	 * Clear permission info for one user
	 * @param userId user id
	 * @return return true if clear was executed
	 * @throws Exception 
	 */
	boolean clearPermissionForUser(int userId) throws Exception;
	
}