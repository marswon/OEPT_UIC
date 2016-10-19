package com.oept.uic.model;

import java.util.List;

/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/14
 * Description: User info model.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
public class User {
	
	private int _id;
	private String _username;
	private String _password;
	private String _lastname;
	private String _firstname;
	private List<Permission> _permission;
	
	public List<Permission> get_permission() {
		return _permission;
	}
	public void set_permission(List<Permission> _permission) {
		this._permission = _permission;
	}
	public String get_uic_lastname() {
		return _lastname;
	}
	public void set_uic_lastname(String _lastname) {
		this._lastname = _lastname;
	}
	public String get_uic_firstname() {
		return _firstname;
	}
	public void set_uic_firstname(String _firstname) {
		this._firstname = _firstname;
	}
	public int get_uic_user_id() {
		return _id;
	}
	public void set_uic_user_id(int user_id) {
		this._id = user_id;
	}
	public String get_uic_username() {
		return _username;
	}
	public void set_uic_username(String username) {
		this._username = username;
	}
	public String get_uic_password() {
		return _password;
	}
	public void set_uic_password(String password) {
		this._password = password;
	}
}
