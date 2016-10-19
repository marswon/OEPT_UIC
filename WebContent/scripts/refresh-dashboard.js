
/**
 * Author: mwan
 * Version: 1.0
 * Date: 2015/09/17
 * Description: Timer events to refresh dashboard data.
 */
// Refresh dashbord1.
var responseJson;
var dataIndex=0;
var refreshDashboard1 = function() {

	$.ajax({
		type: "GET",
		async: false,
		url: "../dashboard/refresh1.do",
		dataType: "text",
		success: function (result) {
			responseJson = eval ("(" + result + ")");
			var tableData = "";
			for(var data in responseJson){
				tableData = tableData + "<tr id="+data+"><td>#"+responseJson[data]._uic_machine_num+"</td>" +
				"<td>"+responseJson[data]._uic_prod_name+"</td>" +
				"<td>"+responseJson[data]._uic_output_plan+"</td>" +
				"<td>"+responseJson[data]._uic_output_actual+"</td></tr>";
			}
			$('table.dashboard1 tbody').html(tableData);

			$("table.dashboard1 tbody tr").each(function(){
				$(this).click(function(){
					dataIndex = $(this).attr('id');
					refreshDashboard2(responseJson[dataIndex]);
				})
			});
			refreshDashboard2(responseJson[dataIndex]);
		},
		error: function(xhr, textStatus, thrownError) {
			alert(thrownError);
		}
	});
};

var refreshDashboard3 = function() {

	$.ajax({
		type: "GET",
		async: false,
		url: "../dashboard/refresh3.do",
		dataType: "text",
		success: function (result) {
			var responseJson3 = eval ("(" + result + ")");
			var tableData = "";
			for(var data in responseJson3){
				var statusHtml = "";
				if(responseJson3[data]._uic_status == "正常运行"){
					statusHtml = "<span class='label label-sm label-success'>正常运行</span>"
				}else if(responseJson3[data]._uic_status == "非正常运行"){
					statusHtml = "<span class='label label-sm label-warning'>非正常运行</span>"
				}else if(responseJson3[data]._uic_status == "停止工作"){
					statusHtml = "<span class='label label-sm label-danger'>停止工作</span>"
				}else{
					statusHtml = responseJson3[data]._uic_status;
				}
				tableData = tableData + "<tr id="+data+"><td>#"+responseJson3[data]._id+"</td>" +
				"<td>"+responseJson3[data]._uic_machine_name+"</td>" +
				"<td>"+statusHtml+"</td>" +
				"<td>"+responseJson3[data]._uic_failure_desc+"</td></tr>";
			}
			$('table.dashboard3 tbody').html(tableData);
		},
		error: function(xhr, textStatus, thrownError) {
			alert(thrownError);
		}
	});
};
// Refresh dashbord2.
var refreshDashboard2 = function(data) {

	$('h4').text(data._uic_prod_name);
	$('span.machine-num').text(data._uic_machine_num);
	$('.product-id').text(data._uic_prod_id);
	$('span.output-plan').text(data._uic_output_plan);
	$('span.output-actual').text(data._uic_output_actual);
	var completeRate = (data._uic_output_actual/data._uic_output_plan*100).toFixed(2)+'%';
	$('span.complete-rate').text(completeRate);
};
//Publish dashbord2.
var publish2 = function(data) {

	$.ajax({
		type: "POST",
		async: false,
		url: "../dashboard/publish2.do",
		dataType: "text",
		data: {
			productId:$('.product-id').text(),
			productName:$('h4').text(),
			machineNumber:$('span.machine-num').text(),
			outputPlan:$('span.output-plan').text(),
			outputActual:$('span.output-actual').text(),
			completeRate:$('span.complete-rate').text()
		},
		success: function (result) {
			responseJson = eval ("(" + result + ")");
			$('.alert-success').hide();	
			$('.alert-danger').hide();
			if( responseJson.value == "done" ){
				$('.alert-success span').text("信息发布成功！");
				$('.alert-success').show();	
			}else{
				$('.alert-danger span').text("信息发布失败！");
				$('.alert-danger').show();
			}  
			
		},
		error: function(xhr, textStatus, thrownError) {
			alert(thrownError);
		}
	});
	
	setTimeout(function(){
			$('.alert-success').fadeOut();
			$('.alert-danger').fadeOut();	
	},3000);
	$('html, body').animate({scrollTop:0}, 'slow');
};

//Refresh dashbord2 data intervally.
var refreshData2 = function(data) {

	$.ajax({
		type: "POST",
		async: false,
		url: "../dashboard/refreshData2.do",
		dataType: "json",
		data: JSON.stringify(data),
		contentType:"application/json;charset=UTF-8",
		success: function (result) {
			
		},
		error: function(xhr, textStatus, thrownError) {
			alert(thrownError);
		}
	});

};

var refreshDashboards = function(){
    
	return {
	
		init: function(){
			
			refreshDashboard1();
			refreshDashboard2(responseJson[0]);
			refreshDashboard3();
			$('a.btn-publish').click(function() {
				publish2();
		    });
			self.setInterval("refreshDashboard1()",5*1000);
			self.setInterval("refreshData2(responseJson)",5*1000);
			self.setInterval("refreshDashboard3()",5*1000);
		}
		
	};

}();