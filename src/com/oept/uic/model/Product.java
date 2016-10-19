package com.oept.uic.model;

/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/16
 * Description: Permission model.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
public class Product {
	
	private int _uic_prod_id;
	private String _uic_prod_name;
	private String _uic_prod_desc;
	
	public int get_uic_prod_id() {
		return _uic_prod_id;
	}
	public void set_uic_prod_id(int _uic_prod_id) {
		this._uic_prod_id = _uic_prod_id;
	}
	public String get_uic_prod_name() {
		return _uic_prod_name;
	}
	public void set_uic_prod_name(String _uic_prod_name) {
		this._uic_prod_name = _uic_prod_name;
	}
	public String get_uic_prod_desc() {
		return _uic_prod_desc;
	}
	public void set_uic_prod_desc(String _uic_prod_desc) {
		this._uic_prod_desc = _uic_prod_desc;
	}
	
}
