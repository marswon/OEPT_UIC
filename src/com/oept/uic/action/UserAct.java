package com.oept.uic.action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.oept.uic.model.Permission;
import com.oept.uic.model.User;
import com.oept.uic.service.UserInfoService;
import com.oept.uic.service.PermissionInfoService;

/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/16
 * Description: User management when navigate to system page.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
@Controller
@RequestMapping(value="/user")
public class UserAct {
	
	@Qualifier("UserInfoService")
	@Autowired
	private UserInfoService UserInfoService;
	@Qualifier("PermissionInfoService")
	@Autowired
	private PermissionInfoService PermissionInfoService;
	private static final Log logger = LogFactory.getLog(UserAct.class);
	
	@RequestMapping(value="/list.do")
	public String navToUserList(Model model, HttpServletRequest request, HttpSession session) throws Exception{
		
		try {
				List<User> userList = UserInfoService.queryForList();
				List<Permission> permissionList = PermissionInfoService.queryForList();
				Iterator<User> iter = userList.iterator();
				User user = new User();
				while(iter.hasNext())  
		        {  
					user = iter.next();
					List<Permission> permission = PermissionInfoService.queryForList(user.get_uic_user_id());
					if(permission!=null){
						user.set_permission(permission);
					}		              
		        }
				model.addAttribute("userList", userList);
				model.addAttribute("permissionList", permissionList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw e;
		}
		return "userList";
	}

	@RequestMapping(value="/details.do")
	public String navToUserDetail(Model model, HttpServletRequest request, HttpSession session) throws Exception{
			
		try {
			String userId = request.getParameter("userId");
			List<Permission> permissionList = PermissionInfoService.queryForList();
			User user = UserInfoService.getUserById(Integer.parseInt(userId));
			List<Permission> userPermissionList = PermissionInfoService.queryForList(Integer.parseInt(userId));
			
			if(userPermissionList!=null){
				Iterator<Permission> iter = permissionList.iterator();
				Iterator<Permission> iterPerm = userPermissionList.iterator();
				Permission perm = new Permission();
				Permission userPerm = new Permission();
							
				while(iter.hasNext()){
					perm = iter.next();
					iterPerm = userPermissionList.iterator();
					while(iterPerm.hasNext())  
			        {  
						userPerm = iterPerm.next();
						if(perm.get_uic_permission_id() == userPerm.get_uic_permission_id()){
							perm.setChecked(true);
						}		              
			        }
				}
			}		
			user.set_permission(permissionList);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw e;
		}
		return "userDetails";		
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	@ResponseBody
	public String updateUser(HttpServletRequest request, HttpSession session) throws Exception{	
		try {
			User user = new User();
			user.set_uic_username(request.getParameter("username"));
			if("".equals(request.getParameter("newPassword"))){
				user.set_uic_password(request.getParameter("oldPassword"));
			}else{
				user.set_uic_password(request.getParameter("newPassword"));
			}			
			user.set_uic_lastname(request.getParameter("lastname"));
			user.set_uic_firstname(request.getParameter("firstname"));
			user.set_uic_user_id(Integer.parseInt(request.getParameter("userId")));
			UserInfoService.updateUserById(user);
			PermissionInfoService.clearPermissionForUser(Integer.parseInt(request.getParameter("userId")));
			
			String roleIds = request.getParameter("roleIds");
			if(!("".equals(roleIds))){
				String roleId[] = roleIds.split(",");
				for(int i=0;i<roleId.length;i++){			
					PermissionInfoService.addPermissionForUser(Integer.parseInt(roleId[i]), Integer.parseInt(request.getParameter("userId")));
				}
			}
			
			return "update.success";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw e;
		}
	}
	
	@RequestMapping(value="/delete.do", method = RequestMethod.GET)
	@ResponseBody
	public String deleteUserById(HttpServletRequest request, HttpSession session) throws Exception{
		
		try {
			String userIds = request.getParameter("userIds");			
			String userId[] = userIds.split(",");
			for(int i=0;i<userId.length;i++){
				PermissionInfoService.clearPermissionForUser(Integer.parseInt(userId[i]));
				UserInfoService.deleteUserById(Integer.parseInt(userId[i]));
			}
			
			return "delete.success";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw e;
		}
	}
	
	@RequestMapping(value="/create.do", method = RequestMethod.POST)
	@ResponseBody
	public String createUser(HttpServletRequest request, HttpSession session) throws Exception{		
		try {
			User user = new User();
			user.set_uic_username(request.getParameter("username"));
			user.set_uic_password(request.getParameter("password"));
			user.set_uic_lastname(request.getParameter("lastname"));
			user.set_uic_firstname(request.getParameter("firstname"));
			UserInfoService.InsertUser(user);
			
			int userId = UserInfoService.getUserByName(request.getParameter("username")).get_uic_user_id();
			String roleIds = request.getParameter("roleIds");
			
			String roleId[] = roleIds.split(",");
			for(int i=0;i<roleId.length;i++){
				PermissionInfoService.addPermissionForUser(Integer.parseInt(roleId[i]), userId);
			}
			
			return "{'id':"+userId+"}";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw e;
		}
	}
}
