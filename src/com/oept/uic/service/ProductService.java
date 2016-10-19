/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/14
 * Description: User Info Interface.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
package com.oept.uic.service;

import java.util.List;

import com.oept.uic.model.Product;

public interface ProductService {
	/**
	 * Get all products info
	 * @return return Product model object
	 * @throws Exception 
	 */
	public List<Product> queryForList();
	
}