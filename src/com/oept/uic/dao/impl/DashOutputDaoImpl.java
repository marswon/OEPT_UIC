package com.oept.uic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.oept.uic.dao.DashOutputDao;
import com.oept.uic.model.Dashboard;
/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/16
 * Description: Dashboard for output dao implementor.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
@Repository("dashOutputDao")
public class DashOutputDaoImpl implements DashOutputDao {

	private static final Logger logger = Logger.getLogger(DashOutputDaoImpl.class);
	private final static String _SELECT_STRING1="select * from uic_output a inner join uic_product b on a.uic_prod_id=b.uic_prod_id";
	private final static String _SELECT_STRING2="select * from uic_machine";
	private final static String _UPDATE_STRING1="UPDATE uic_output SET uic_prod_id = ?, uic_machine_num = ?,"
			+ "uic_output_plan = ?,uic_output_actual=? "
			+ "WHERE id = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Dashboard> getDashboardOutput() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(_SELECT_STRING1,   
                new RowMapper<Dashboard>(){         
                    @Override  
                    public Dashboard mapRow(ResultSet rs, int rowNum) throws SQLException {  
                    	Dashboard dashboard  = new Dashboard(); 
                    	dashboard.set_id(rs.getInt("id"));
                    	dashboard.set_uic_prod_id(rs.getInt("uic_prod_id"));  
                    	dashboard.set_uic_prod_name(rs.getString("uic_prod_name"));  
                    	dashboard.set_uic_machine_num(rs.getString("uic_machine_num"));
                    	dashboard.set_uic_output_plan(Integer.parseInt(rs.getString("uic_output_plan")));
                    	dashboard.set_uic_output_actual(Integer.parseInt(rs.getString("uic_output_actual"))); 
                        return dashboard;  
                    }  
        }); 
	}
	
	@Override
	public List<Dashboard> getDashboard3() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(_SELECT_STRING2,   
                new RowMapper<Dashboard>(){         
                    @Override  
                    public Dashboard mapRow(ResultSet rs, int rowNum) throws SQLException {  
                    	Dashboard dashboard  = new Dashboard(); 
                    	dashboard.set_id(rs.getInt("uic_machine_id"));
                    	dashboard.set_uic_machine_name(rs.getString("uic_machine_name"));  
                    	dashboard.set_uic_status(rs.getString("uic_status"));
                    	dashboard.set_uic_failure_desc(rs.getString("uic_failure_desc"));
                        return dashboard;  
                    }  
        }); 
	}
	@Override
	public boolean updateDashOutput(Dashboard dashboard) {
		// TODO Auto-generated method stub
		try{
			Object[] params = new Object[] {
					dashboard.get_uic_prod_id(),
					dashboard.get_uic_machine_num(),
					dashboard.get_uic_output_plan(),
					dashboard.get_uic_output_actual(),
					dashboard.get_id()};
			jdbcTemplate.update(_UPDATE_STRING1,params);
			return true;
		}catch(Exception e){
			logger.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public void set_jdbc(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated method stub
		this.jdbcTemplate = jdbcTemplate;
	}
}
