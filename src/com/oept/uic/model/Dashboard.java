package com.oept.uic.model;

/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/16
 * Description: Permission model.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
public class Dashboard {
	
	private int _id;
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	private int _uic_prod_id;
	private int _uic_output_plan;
	private int _uic_output_actual;
	private String _uic_prod_name;
	private String _uic_machine_num;
	private String _uic_machine_name;
	private String _uic_machine_desc;
	private String _uic_status;
	private String _uic_failure_desc;
	
	public int get_uic_prod_id() {
		return _uic_prod_id;
	}
	public void set_uic_prod_id(int _uic_prod_id) {
		this._uic_prod_id = _uic_prod_id;
	}
	public int get_uic_output_plan() {
		return _uic_output_plan;
	}
	public void set_uic_output_plan(int _uic_output_plan) {
		this._uic_output_plan = _uic_output_plan;
	}
	public int get_uic_output_actual() {
		return _uic_output_actual;
	}
	public void set_uic_output_actual(int _uic_output_actual) {
		this._uic_output_actual = _uic_output_actual;
	}
	public String get_uic_prod_name() {
		return _uic_prod_name;
	}
	public void set_uic_prod_name(String _uic_prod_name) {
		this._uic_prod_name = _uic_prod_name;
	}
	public String get_uic_machine_num() {
		return _uic_machine_num;
	}
	public void set_uic_machine_num(String _uic_machine_num) {
		this._uic_machine_num = _uic_machine_num;
	}
	public String get_uic_machine_name() {
		return _uic_machine_name;
	}
	public void set_uic_machine_name(String _uic_machine_name) {
		this._uic_machine_name = _uic_machine_name;
	}
	public String get_uic_machine_desc() {
		return _uic_machine_desc;
	}
	public void set_uic_machine_desc(String _uic_machine_desc) {
		this._uic_machine_desc = _uic_machine_desc;
	}
	public String get_uic_status() {
		return _uic_status;
	}
	public void set_uic_status(String _uic_status) {
		this._uic_status = _uic_status;
	}
	public String get_uic_failure_desc() {
		return _uic_failure_desc;
	}
	public void set_uic_failure_desc(String _uic_failure_desc) {
		this._uic_failure_desc = _uic_failure_desc;
	}
	
	
}
