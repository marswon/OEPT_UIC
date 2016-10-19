<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<% String url = basePath+""; %>
<%@ page import="com.oept.uic.model.Permission"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%  List<Permission> permissionList = (List<Permission>)session.getAttribute("permissions"); %>
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
<!DOCTYPE html>
<!-- 
/**
 * Author: mwan
 * Version: 1.0
 * Date: 2015/05/27
 * Description: System home page.
 * Copyright (c) 2015年 mwan. All rights reserved.
 */
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>OEPT UIC首页</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->

<link href="../assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="../assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link href="../assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="../assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="../assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="../assets/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
<link href="../assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="../assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
<link id="style_color" href="../assets/admin/layout/css/themes/default.css" rel="stylesheet" type="text/css"/>
<link href="../assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link href="../css/autods.css" rel="stylesheet" type="text/css"/>
<link rel="shortcut icon" href="../favicon.ico"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed page-quick-sidebar-over-content page-full-width"> 
<!-- BEGIN HEADER -->
<jsp:include page="navigationSidebar.jsp" />
<!-- END HEADER -->
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN PAGE HEADER-->
			<h3 class="page-title">
			看板中心 <small>演示</small>
			</h3>
			<!-- END PAGE HEADER-->
			<!-- BEGIN PORTLETS -->
			<div class="row" id="sortable_portlets">
				<% 
					if(hasPermission("车间生产看板", permissionList)){
				%>
				<div class="col-md-4 column sortable">
					<div class="portlet portlet-sortable light bordered">
						<div class="portlet-title">
							<div class="caption font-green-sharp">
								<i class="icon-speech font-green-sharp"></i>
								<span class="caption-subject bold uppercase"> 车间生产看板</span>
							</div>
							<div class="actions">
								<a href="<%=path%>/dashboard/details.do?id=1" class="btn btn-circle btn-default btn-sm">
								<i class="fa fa-plus"></i> 数据编辑 </a>
								<a class="btn btn-circle btn-icon-only btn-default fullscreen" href="#"></a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="scroller" style="height:200px" data-rail-visible="1" data-rail-color="yellow" data-handle-color="#a1b2bd">
								<div class="table-responsive">
								<table class="table dashboard1">
								<thead>
								<tr>
									<th>
										 机台
									</th>
									<th>
										 产品
									</th>
									<th>
										 计划产量
									</th>
									<th>
										 实际产量
									</th>
								</tr>
								</thead>
								<tbody>
								 <!-- refreshed by js -->
								</tbody>
								</table>
							</div>
							</div>
						</div>
					</div>
					<!-- empty sortable porlet required for each columns! -->
					<div class="portlet portlet-sortable-empty">
					</div>
				</div>
				<%}%>
				<% 
					if(hasPermission("产品生产看板", permissionList)){
				%>
				<div class="col-md-4 column sortable">
				<div class="alert alert-danger display-hide" style="display: none;">
					<button class="close" data-close="alert"></button>
					<span>You have some form errors. Please check below.</span>
				</div>
				<div class="alert alert-success display-hide" style="display: none;">
					<button class="close" data-close="alert"></button>
					<span>成功修改!</span>
				</div>
					<div class="portlet portlet-sortable light bordered">
						<div class="portlet-title">
							<div class="caption font-green-sharp">
								<i class="icon-speech font-green-sharp"></i>
								<span class="caption-subject bold uppercase"> 产品生产看板</span>
							</div>
							<div class="actions">
								<a href="#" class="btn btn-circle btn-default btn-sm btn-publish">
								<i class="fa fa-plus"></i> 发布 </a>
								<a class="btn btn-circle btn-icon-only btn-default fullscreen" href="#"></a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="scroller" style="height:200px" data-rail-visible="1" data-rail-color="yellow" data-handle-color="#a1b2bd">
								<h4>车门框</h4>
								<b>机台号：</b>#<span class="machine-num">1</span><br>
								<span class="product-id" style="display:none"></span>
								<b>今日计划产量：</b><span class="dashboard-number output-plan">2415</span><br>
								<b>现已完成产量：</b><span class="dashboard-number output-actual">241</span><br>
								<b>完成率：</b><span class="complete-rate"></span><br>
							</div>
						</div>
					</div>
					<!-- empty sortable porlet required for each columns! -->
					<div class="portlet portlet-sortable-empty">
					</div>
				</div>
				<%}%>
				<% 
					if(hasPermission("设备预警看板", permissionList)){
				%>
				<div class="col-md-4 column sortable">
					<div class="portlet portlet-sortable light bordered">
						<div class="portlet-title">
							<div class="caption font-green-sharp">
								<i class="icon-speech font-green-sharp"></i>
								<span class="caption-subject bold uppercase"> 设备预警看板</span>
							</div>
							<div class="actions">
								<a class="btn btn-circle btn-icon-only btn-default fullscreen" href="#"></a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="scroller" style="height:200px" data-rail-visible="1" data-rail-color="yellow" data-handle-color="#a1b2bd">						
							<div class="table-responsive">
								<table class="table dashboard3">
								<thead>
								<tr>
									<th>
										 机台
									</th>
									<th>
										 设备
									</th>
									<th>
										 状态
									</th>
									<th>
										 故障原因
									</th>
								</tr>
								</thead>
								<tbody>
								<!-- Refreshed by JS -->
								</tbody>
								</table>
								</div>
							</div>
						</div>
					</div>				
					<!-- empty sortable porlet required for each columns! -->
					<div class="portlet portlet-sortable-empty">
					</div>
				</div>
				<%}%>
			</div>
			<!-- END PORTLETS -->
			<div class="clearfix">
			</div>
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<jsp:include page="footer.jsp" />
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="../assets/global/plugins/respond.min.js"></script>
<script src="../assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
<script src="../assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="../assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="../assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="../assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="../assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="../assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="../assets/admin/pages/scripts/portlet-draggable.js"></script>
<script src="../scripts/refresh-dashboard.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
jQuery(document).ready(function() {       
   // initiate layout and plugins
   	Metronic.init(); // init metronic core components
	Layout.init(); // init current layout
	QuickSidebar.init(); // init quick sidebar
	Demo.init(); // init demo features
   	PortletDraggable.init();
   	refreshDashboards.init();
});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>