package com.oept.uic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.oept.uic.dao.ProductDao;
import com.oept.uic.model.Product;

/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/17
 * Description: Product info dao implementor.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
@Repository("ProductDao")
public class ProductDaoImpl implements ProductDao {

	private final static String _SELECT_STRING1="select * from uic_product";
	
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
	public List<Product> queryForList() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(_SELECT_STRING1,   
                new RowMapper<Product>(){         
                    @Override  
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {  
                    	Product product  = new Product();  
                    	product.set_uic_prod_id(rs.getInt("uic_prod_id"));  
                    	product.set_uic_prod_name(rs.getString("uic_prod_name"));  
                    	product.set_uic_prod_desc(rs.getString("uic_prod_desc"));
                        return product;  
                    }  
        });
	}

}
