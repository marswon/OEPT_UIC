/**
 * @author mwan
 * Version: 1.0
 * Date: 2015/09/16
 * Description: permission Info service interface.
 * Copyright (c) 2015 mwan. All rights reserved.
 */
package com.oept.uic.service;

import java.util.List;

import com.oept.uic.model.Dashboard;

public interface DashboardService {
	/**
	 * Get all permission info
	 * @return return permission model object
	 * @throws Exception 
	 */
	public List<Dashboard> getDashOutput();

	boolean updateDashOutput(Dashboard dashboard);

	public List<Dashboard> getDashboard3();
	
}