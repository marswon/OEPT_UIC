package com.oept.uic.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oept.uic.model.User;
import com.oept.uic.service.DashboardService;
import com.oept.uic.service.PermissionInfoService;
import com.oept.uic.service.UserInfoService;
/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/14
 * Description: User login, validation and logout actions.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
@Controller
@RequestMapping(value="/auth")
public class LoginAct {
	@Qualifier("UserInfoService")
	@Autowired
	private UserInfoService UserInfoService;
	@Qualifier("PermissionInfoService")
	@Autowired
	private PermissionInfoService PermissionInfoService;
	@Qualifier("DashboardService")
	@Autowired
	private DashboardService DashboardService;
	private static final Log logger = LogFactory.getLog(LoginAct.class);

	//for test
	@RequestMapping(value="/login.do", method = RequestMethod.GET, params = "username")
	@ResponseBody
	public String userAuthenticate(Model model, HttpServletRequest request, HttpSession session){
		String username = request.getParameter("username");	
		try {
			
			return UserInfoService.getUserByName(username).get_uic_password();
		} catch (Exception e) {
			// Exception handle
			logger.info(e.getMessage());
			model.addAttribute("exception", e.toString());
			return "exception";
		}
	}
	//User authentication usually invoked by JS when login
	@RequestMapping(value="/login.do", params = "json")
	@ResponseBody
	public String userAuthenticate(HttpServletRequest request, HttpSession session) throws Exception{
		String username = request.getParameter("username");
		String password = request.getParameter("password");	

		try {
			User user = UserInfoService.getUserByName(username);
			user.set_permission(PermissionInfoService.queryForList(user.get_uic_user_id()));
			if(password.equals(user.get_uic_password())){
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("permissions", user.get_permission());
				return "{'status':'login.success'}";
			}else{
				return "{'status':'login.fail'}";
			}		
		} catch (Exception e) {
			// Exception handle
			logger.info(e.getMessage());
			return "{'status':'login.fail'}";
		}
	}

	//Display home page dashboard
	@RequestMapping(value="/dashboard.do")
	public String navToDashboad(Model model, HttpServletRequest request, HttpSession session, HttpServletResponse response)
	{

		model.addAttribute("username", session.getAttribute("username"));
		return "homePage";
	}
	
	//Logout action
	@RequestMapping(value="/logout.do")
	public String userLogout(Model model, HttpServletRequest request, HttpSession session){
		try {
			
			session.removeAttribute("username");
			session.removeAttribute("password");
			session.removeAttribute("permissions");

			return "redirect:/";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			model.addAttribute("exception", e.toString());
			return "exception";
		}
	}
}
