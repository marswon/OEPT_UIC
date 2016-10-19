<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<% String url = basePath+""; %>
<%@ page import="com.oept.uic.model.Permission"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%  List<Permission> permissionList = (List<Permission>)session.getAttribute("permissions"); %>
<% String username = session.getAttribute("username").toString();%>
<%!
	public boolean hasPermission(String permName, List<Permission> permissionList){
		if(permissionList == null){
			return false;
		}
		Iterator<Permission> iter = permissionList.iterator();
		Permission permission = new Permission();
		while(iter.hasNext())  
        {  
			permission = iter.next();
			if(permission.get_uic_permission_name().equals(permName)){
				return true;
			}		              
        }
		return false;
	}
%>
<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner">
		<!-- BEGIN LOGO -->
		<div class="page-logo">
			<a href="index.html">
			<img src="../img/logo.png" alt="logo" class="logo-default"/>
			</a>
		</div>
		<!-- END LOGO -->
		<!-- BEGIN HORIZANTAL MENU -->
		<div class="hor-menu hor-menu-light hidden-sm hidden-xs">
			<ul class="nav navbar-nav">
				<!-- DOC: Remove data-hover="dropdown" and data-close-others="true" attributes below to disable the horizontal opening on mouse hover -->
				<li class="classic-menu-dropdown active">
					<a href="<%=path%>/auth/dashboard.do">
					看板中心 <span class="selected">
					</span>
					</a>
				</li>
				<li class="mega-menu-dropdown">
					<a data-toggle="dropdown" href="javascript:;" class="dropdown-toggle">
					按部门查看看板 <i class="fa fa-angle-down"></i>
					</a>
					<ul class="dropdown-menu" style="min-width: 500px;">
						<li>
							<!-- Content container to add padding -->
							<div class="mega-menu-content">
								<div class="row">
									<div class="col-md-4">
										<ul class="mega-menu-submenu">
											<li>
												<a href="<%=path%>/dashboard/details.do?id=1">
												工业信息化室</a>
											</li>
											<li>
												<a href="<%=path%>/dashboard/details.do?id=1">
												办公自动化室</a>
											</li>
											<li>
												<a href="<%=path%>/dashboard/details.do?id=1">
												计算机支持室</a>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</li>
					</ul>
				</li>
				<li class="mega-menu-dropdown">
					<a data-toggle="dropdown" href="javascript:;" class="dropdown-toggle">
					看板数据管理 <i class="fa fa-angle-down"></i>
					</a>
					<ul class="dropdown-menu" style="min-width: 500px;">
						<li>
							<!-- Content container to add padding -->
							<div class="mega-menu-content">
								<div class="row">
									<div class="col-md-4">
										<ul class="mega-menu-submenu">
											<% 
												if(hasPermission("车间生产看板", permissionList)){
											%>
											<li>
												<a href="<%=path%>/dashboard/details.do?id=1">
												车间产品生产看板</a>
											</li>
											<%}%>
										</ul>
									</div>
								</div>
							</div>
						</li>
					</ul>
				</li>
				<% 
					if("admin".equals(username)){
				%>
				<li class="mega-menu-dropdown">
					<a data-toggle="dropdown" href="javascript:;" class="dropdown-toggle">
					系统管理 <i class="fa fa-angle-down"></i>
					</a>
					<ul class="dropdown-menu" style="min-width: 500px;">
						<li>
							<!-- Content container to add padding -->
							<div class="mega-menu-content">
								<div class="row">
									<div class="col-md-4">
										<ul class="mega-menu-submenu">
											<li>
												<a href="<%=path%>/user/list.do">
												用户管理</a>
											</li>
											<li>
												<a href="#">
												其他… </a>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</li>
					</ul>
				</li>
				<%}%>
			</ul>
		</div>
		<!-- END HORIZANTAL MENU -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
		</a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<!-- BEGIN TOP NAVIGATION MENU -->
		<div class="top-menu">
			<ul class="nav navbar-nav pull-right">
				<!-- BEGIN USER LOGIN DROPDOWN -->
				<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
				<li class="dropdown dropdown-user">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
					<img alt="" class="img-circle" src="../assets/admin/layout/img/avatar2.jpg"/>
					<span class="username username-hide-on-mobile">
					${username} </span>
					<i class="fa fa-angle-down"></i>
					</a>
					<ul class="dropdown-menu dropdown-menu-default">
						<li>
							<a href="<%=path%>/personal/settings.do">
							<i class="icon-user"></i> 账户设置 </a>
						</li>
						<li>
							<a href="<%=path%>/personal/password.do">
							<i class="icon-user"></i> 修改密码 </a>
						</li>
						<li class="divider">
						</li>
						<li>
							<a href="<%=path%>/auth/logout.do">
							<i class="icon-key"></i> 登出 </a>
						</li>
					</ul>
				</li>
				<!-- END USER LOGIN DROPDOWN -->
				<!-- BEGIN QUICK SIDEBAR TOGGLER -->
				<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
				<li class="dropdown dropdown-quick-sidebar-toggler">
					<a href="<%=path%>/auth/logout.do" class="dropdown-toggle">
					<i class="icon-logout"></i>
					</a>
				</li>
				<!-- END QUICK SIDEBAR TOGGLER -->
			</ul>
		</div>
		<!-- END TOP NAVIGATION MENU -->
	</div>
	<!-- END HEADER INNER -->
</div>
<!-- END HEADER -->