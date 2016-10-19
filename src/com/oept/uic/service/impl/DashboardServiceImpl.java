package com.oept.uic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.oept.uic.dao.DashOutputDao;
import com.oept.uic.model.Dashboard;
import com.oept.uic.service.DashboardService;
@Service("DashboardService")
public class DashboardServiceImpl implements DashboardService {

	@Qualifier("dashOutputDao")
	@Autowired
	private DashOutputDao dashOutputDao;
	
	@Override
	public List<Dashboard> getDashOutput() {
		// TODO Auto-generated method stub
		return dashOutputDao.getDashboardOutput();
	}
	
	@Override
	public List<Dashboard> getDashboard3() {
		// TODO Auto-generated method stub
		return dashOutputDao.getDashboard3();
	}
	
	@Override
	public boolean updateDashOutput(Dashboard dashboard) {
		// TODO Auto-generated method stub
		return dashOutputDao.updateDashOutput(dashboard);
	}

}
