package com.oept.uic.model;

/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/16
 * Description: Permission model.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
public class Permission {
	
	private int _uic_permission_id;
	private String _uic_permission_name;
	private boolean checked;
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public int get_uic_permission_id() {
		return _uic_permission_id;
	}
	public void set_uic_permission_id(int _uic_permission_id) {
		this._uic_permission_id = _uic_permission_id;
	}
	public String get_uic_permission_name() {
		return _uic_permission_name;
	}
	public void set_uic_permission_name(String _uic_permission_name) {
		this._uic_permission_name = _uic_permission_name;
	}
	
}
