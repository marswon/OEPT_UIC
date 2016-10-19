package com.oept.uic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.oept.uic.dao.ProductDao;
import com.oept.uic.model.Product;
import com.oept.uic.service.ProductService;
@Service("ProductService")
public class ProductServiceImpl implements ProductService {

	@Qualifier("ProductDao")
	@Autowired
	private ProductDao ProductDao;
	
	@Override
	public List<Product> queryForList() {
		// TODO Auto-generated method stub
		return ProductDao.queryForList();
	}

}
