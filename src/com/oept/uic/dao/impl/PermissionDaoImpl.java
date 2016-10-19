package com.oept.uic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.oept.uic.dao.PermissionDao;
import com.oept.uic.model.Permission;
import com.oept.uic.model.User;
/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/16
 * Description: Permission info dao implementor.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
@Repository("permissionDao")
public class PermissionDaoImpl implements PermissionDao {

	private static final Logger logger = Logger.getLogger(PermissionDaoImpl.class);
	private final static String _INSERT_STRING1="insert into uic_permission (uic_permission_name) values (?)";
	private final static String _INSERT_STRING2="insert into uic_permission_user (uic_permission_id,uic_user_id) values (?,?)";
	private final static String _DELETE_STRING1="delete from uic_permission_user where uic_user_id=?";
	private final static String _SELECT_STRING1="select * from uic_permission";
	private final static String _SELECT_STRING2="select c.uic_permission_id,c.uic_permission_name from uic_user a inner join "
			+ "uic_permission_user b on a.uic_user_id=b.uic_user_id inner join "
			+ "uic_permission c on b.uic_permission_id=c.uic_permission_id where a.uic_user_id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean insertPermission(Permission permission) {
		// TODO Auto-generated method stub
		try{
			Object[] params = new Object[] {
					permission.get_uic_permission_name()};
			jdbcTemplate.update(_INSERT_STRING1,params);
			return true;
		}catch(Exception e){
			logger.info(e.getMessage());
			throw e;
		}
	}
	
	@Override
	public boolean addPermissionForUser(int permissionId, int userId) {
		// TODO Auto-generated method stub
		try{
			Object[] params = new Object[] {
					permissionId,
					userId};
			jdbcTemplate.update(_INSERT_STRING2,params);
			return true;
		}catch(Exception e){
			logger.info(e.getMessage());
			throw e;
		}
	}
	
	@Override
	public boolean clearPermissionForUser(int userId) {
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
	public User getPermissionById(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permission> queryForList() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(_SELECT_STRING1, 
                new RowMapper<Permission>(){         
                    @Override  
                    public Permission mapRow(ResultSet rs, int rowNum) throws SQLException {  
                    	Permission permission  = new Permission();  
                    	permission.set_uic_permission_id(rs.getInt("uic_permission_id"));  
                    	permission.set_uic_permission_name(rs.getString("uic_permission_name"));
                        return permission;  
                    }  
        });
	}

	@Override
	public List<Permission> queryForList(int userId) {
		// TODO Auto-generated method stub
		Object[] params = new Object[] {userId};
		
		return jdbcTemplate.query(_SELECT_STRING2, params,   
                new RowMapper<Permission>(){         
                    @Override  
                    public Permission mapRow(ResultSet rs, int rowNum) throws SQLException {  
                    	Permission permission  = new Permission();  
                    	permission.set_uic_permission_id(rs.getInt("uic_permission_id"));  
                    	permission.set_uic_permission_name(rs.getString("uic_permission_name"));
                        return permission;  
                    }  
        });
	}

	@Override
	public void set_jdbc(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated method stub
		this.jdbcTemplate = jdbcTemplate;
	}
}
