package com.oept.uic.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oept.uic.model.User;
import com.oept.uic.service.UserInfoService;
/**
 * @author mwan
 * Version: 2.0
 * Date: 2015/08/17
 * Description: Personal Settings actions.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
@Controller
@RequestMapping(value="/personal")
public class PersonalSettingsAct {
	
	private static final Log logger = LogFactory.getLog(PersonalSettingsAct.class);
	@Qualifier("UserInfoService")
	@Autowired
	private UserInfoService UserInfoService;
	//User settings view
	@RequestMapping(value="/settings.do")
	public String settingsView(Model model, HttpServletRequest request, HttpSession session) throws Exception{	
		
		try{	
			String username = session.getAttribute("username").toString();
			User user = UserInfoService.getUserByName(username);
			model.addAttribute("user", user);
			return "userSettings";
			
		}catch (Exception e) {
			// Exception handle
			logger.info(e.getMessage());
			throw e;
		}
	}
	//Change password view
	@RequestMapping(value="/password.do")
	public String changePasswordView(Model model, HttpServletRequest request, HttpSession session){	

		model.addAttribute("username", session.getAttribute("username"));
		return "changePassword";

	}
	//Change password action
	@RequestMapping(value="/changePassword.do")
	@ResponseBody
	public String changePassword(Model model, HttpServletRequest request, HttpSession session) throws Exception{	

		try{
			User user = UserInfoService.getUserByName(session.getAttribute("username").toString());
			
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			String confirmPassword = request.getParameter("confirmPassword");

			if("".equals(oldPassword) || "".equals(newPassword) || "".equals(confirmPassword)){
				return "inputErr";
			}else if( !(oldPassword.equals(session.getAttribute("password").toString())) ){
				return "oldPasswordErr";
			}else if( !(confirmPassword.equals(newPassword)) ){
				return "newPasswordErr";
			}
			user.set_uic_password(newPassword);
			UserInfoService.updateUserById(user);
			
			return "success";				
		}catch (Exception e) {
			// Exception handle
			logger.info(e.getMessage());
			throw e;
		}
	}
	
	//Update user settings action
	@RequestMapping(value="/updateSettings.do")
	@ResponseBody
	public String updateSettings(Model model, HttpServletRequest request, HttpSession session) throws Exception{	

		try{
			User user = UserInfoService.getUserByName(session.getAttribute("username").toString());
			user.set_uic_lastname(request.getParameter("lastname"));
			user.set_uic_firstname(request.getParameter("firstname"));
			UserInfoService.updateUserById(user);
			
			return "success";				
		}catch (Exception e) {
			// Exception handle
			logger.info(e.getMessage());
			throw e;
		}

	}
}
