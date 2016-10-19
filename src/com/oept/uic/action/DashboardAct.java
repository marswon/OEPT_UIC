package com.oept.uic.action;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oept.uic.model.Dashboard;
import com.oept.uic.model.Product;
import com.oept.uic.service.DashboardService;
import com.oept.uic.service.ProductService;
/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/14
 * Description: Dashboard actions.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
@Controller
@RequestMapping(value="/dashboard")
public class DashboardAct {
	@Qualifier("DashboardService")
	@Autowired
	private DashboardService DashboardService;
	@Qualifier("ProductService")
	@Autowired
	private ProductService ProductService;
	private static final Log logger = LogFactory.getLog(DashboardAct.class);
	private static Map<String,String> dashProduct = new HashMap<String, String>(); 

	//for test
	@RequestMapping(value="/details.do", method = RequestMethod.GET)
	public String navToDashboard(Model model, HttpServletRequest request, HttpSession session){
		String dashboard_id = request.getParameter("id");			
		try {
			List<Dashboard> dashOutputList = DashboardService.getDashOutput();
			List<Product> productList = ProductService.queryForList();
			model.addAttribute("dashOutputList", dashOutputList);
			model.addAttribute("productList", productList);
			return "dashboard"+dashboard_id;
		} catch (Exception e) {
			// Exception handle
			logger.info(e.getMessage());
			model.addAttribute("exception", e.toString());
			return "exception";
		}
	}
	//Update dashboard
	@RequestMapping(value="/update1.do", method = RequestMethod.POST)
	@ResponseBody
	public String update1(HttpServletRequest request, HttpSession session) throws Exception{
		String dashboardId = request.getParameter("dashboardId");
		String uic_machine_num = request.getParameter("uic_machine_num");	
		String uic_prod_id = request.getParameter("uic_prod_id");
		String uic_output_plan = request.getParameter("uic_output_plan");
		String uic_output_actual = request.getParameter("uic_output_actual");

		try {
			Dashboard dashoutput = new Dashboard();
			dashoutput.set_id(Integer.parseInt(dashboardId));
			dashoutput.set_uic_machine_num(uic_machine_num);
			dashoutput.set_uic_prod_id(Integer.parseInt(uic_prod_id));
			dashoutput.set_uic_output_plan(Integer.parseInt(uic_output_plan));
			dashoutput.set_uic_output_actual(Integer.parseInt(uic_output_actual));
			DashboardService.updateDashOutput(dashoutput);
			return "{'value':'done'}";	
		} catch (Exception e) {
			// Exception handle
			logger.info(e.getMessage());
			return "{'value':'fail'}";
		}
	}
	
	@RequestMapping(value="/refresh1.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String refresh1(HttpServletRequest request, HttpSession session) throws Exception{

		try {
			List<Dashboard> dashOutputList = DashboardService.getDashOutput();
			
			ObjectMapper om = new ObjectMapper();
			String responseStr = om.writeValueAsString(dashOutputList);
			return responseStr;	
		} catch (Exception e) {
			// Exception handle
			logger.info(e.getMessage());
			return "{'value':'fail'}";
		}
	}
	
	@RequestMapping(value="/refresh2.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String refresh2(HttpServletRequest request, HttpSession session) throws Exception{

		try {
			
			ObjectMapper om = new ObjectMapper();
			String responseStr = om.writeValueAsString(dashProduct);
			return responseStr;	
		} catch (Exception e) {
			// Exception handle
			logger.info(e.getMessage());
			return "{'value':'fail'}";
		}
	}
	
	@RequestMapping(value="/refresh3.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String refresh3(HttpServletRequest request, HttpSession session) throws Exception{

		try {
			List<Dashboard> dashboard = DashboardService.getDashboard3();
			
			ObjectMapper om = new ObjectMapper();
			String responseStr = om.writeValueAsString(dashboard);
			return responseStr;	
		} catch (Exception e) {
			// Exception handle
			logger.info(e.getMessage());
			return "{'value':'fail'}";
		}
	}
	
	@RequestMapping(value="/publish2.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String publish2(HttpServletRequest request, HttpSession session) throws Exception{

		try {
			String productName = request.getParameter("productName");
			String outputPlan = request.getParameter("outputPlan");
			String outputActual = request.getParameter("outputActual");
			String completeRate = request.getParameter("completeRate");
			String machineNumber = request.getParameter("machineNumber");
			String productId = request.getParameter("productId");
			
			dashProduct.put("productName", productName);
			dashProduct.put("outputPlan", outputPlan);
			dashProduct.put("outputActual", outputActual);
			dashProduct.put("completeRate", completeRate);
			dashProduct.put("machineNumber", machineNumber);
			dashProduct.put("productId", productId);
			
			return "{'value':'done'}";	
		} catch (Exception e) {
			// Exception handle
			logger.info(e.getMessage());
			return "{'value':'fail'}";
		}
	}
	
	@RequestMapping(value="/refreshData2.do", method = RequestMethod.POST)
	@ResponseBody
	public String refreshData2(@RequestBody List<Dashboard> dashboardList) throws Exception{

		try {
			
			Iterator<Dashboard> iter = dashboardList.iterator();
			Dashboard dashboard = new Dashboard();
			while(iter.hasNext())  
	        {  
				dashboard = iter.next();
				if(dashboard.get_uic_machine_num().equals(dashProduct.get("machineNumber")) &&
						dashboard.get_uic_prod_id() == Integer.parseInt(dashProduct.get("productId"))){
					dashProduct.put("outputPlan", String.valueOf(dashboard.get_uic_output_plan()));
					dashProduct.put("outputActual", String.valueOf(dashboard.get_uic_output_actual()));
					float plan = (float)dashboard.get_uic_output_plan();
					float actual = (float)dashboard.get_uic_output_actual();
					DecimalFormat decimalFormat=new DecimalFormat(".00");
					String completeRate = decimalFormat.format((actual/plan*100))+"%";
					dashProduct.put("completeRate", completeRate);
				}		              
	        }
			return "{\"value\":\"done\"}";	
		} catch (Exception e) {
			// Exception handle
			logger.info(e.getMessage());
			return "{\"value\":\"fail\"}";
		}
	}

	//Display home page dashboard
	@RequestMapping(value="/dashboard.do")
	public String navToDashboad(Model model, HttpServletRequest request, HttpSession session)
	{
		model.addAttribute("username", session.getAttribute("username"));
		return "homePage";
	}
}
