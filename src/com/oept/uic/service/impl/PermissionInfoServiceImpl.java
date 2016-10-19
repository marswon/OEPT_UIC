package com.oept.uic.service.impl;
/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/16
 * Description: permission Info service implementor.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.oept.uic.dao.PermissionDao;
import com.oept.uic.model.Permission;
import com.oept.uic.service.PermissionInfoService;
@Service("PermissionInfoService")
public class PermissionInfoServiceImpl implements PermissionInfoService {

	@Qualifier("permissionDao")
	@Autowired
	private PermissionDao PermissionDao;
	
	@Override
	public boolean InsertPermission(Permission permission) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean addPermissionForUser(int permissionId, int userId) throws Exception {
		// TODO Auto-generated method stub
		return PermissionDao.addPermissionForUser(permissionId, userId);
	}
	
	@Override
	public boolean clearPermissionForUser(int userId) throws Exception {
		// TODO Auto-generated method stub
		return PermissionDao.clearPermissionForUser(userId);
	}

	@Override
	public List<Permission> queryForList(int userId) {
		// TODO Auto-generated method stub
		return PermissionDao.queryForList(userId);
	}

	@Override
	public List<Permission> queryForList() {
		// TODO Auto-generated method stub
		return PermissionDao.queryForList();
	}

}
