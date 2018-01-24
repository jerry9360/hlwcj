[#assign jss=[ "assets/js/Basestat.js"]]
[#assign css=["assets/css/bootstrap-timepicker.css"]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['home'] otherjs=jss othercss=css]
<div class="row">
<div class="col-xs-12">
	<div class="responsive span3">
		<div class="dashboard-stat blue" style="margin-bottom:0px;">
			<div class="details">
				<div class="number">${judgeCount}</div>
				<div class="desc" style="font-weight: bold">司法判决信息</div>
			</div>
  			<a class="more" href="${base}/analyzemgr/corporder?datatype=judgedoc&begindate=&enddate=">
			详细信息 <span style="float:right;">more</span>
			</a>                
		</div>
		</div>
		<div class="responsive span3">
			<div class="dashboard-stat purple" style="margin-bottom:0px;">
				<div class="details">
					<div class="number">${dishonestCount}</div>
					<div class="desc" style="font-weight: bold">&nbsp; &nbsp;&nbsp; &nbsp;失信被执行人信息 </div>
				</div>
				<a class="more" href="${base}/analyzemgr/corporder?datatype=dishonestman&begindate=&enddate=">
				 详细信息 <span style="float:right;">more</span>
				</a>                 
			</div>
		</div>
		<div class="responsive span3">
			<div class="dashboard-stat green" style="margin-bottom:0px;">
				<div class="details">
					<div class="number">${service_complaintCount}</div>
					<div class="desc" style="font-weight: bold">&nbsp; &nbsp;&nbsp; &nbsp;服务质量投诉信息</div>
				</div>
				<a class="more" href="${base}/analyzemgr/corporder?datatype=servicecomplaint&begindate=&enddate=">
				 详细信息 <span style="float:right;">more</span>
				</a>                 
			</div>
		</div>
		<div class="responsive span3">
			<div class="dashboard-stat yellow" style="margin-bottom:0px;">
				<div class="details">
					<div class="number">${public_priseCount}</div> 
					<!-- <div class="number">850</div> -->
					<div class="desc" style="font-weight: bold">公众表扬信息</div>
				</div>
				 <a class="more" href="${base}/analyzemgr/corporder?datatype=public_prise&begindate=&enddate=">
				详细信息 <span style="float:right;">more</span>
				</a>                
			</div>
		</div>
	</div>
	<div class="col-xs-6">
		<div style="text-align: center;font-size: 18px;font-weight: 600;padding-top:10px;">司法判决信息排名 (前5名)</div>
		<table class="table table-bordered table-hover" style="margin-top:10px;">
			<thead>
				<tr>
					<th style="width:20%;text-align:center;font-size:14px;background-color:#3398DB;color:white;">排名</th>
					<th style="width:60%;text-align:center;font-size:14px;background-color:#3398DB;color:white;">企业名称</th>
					<th style="width:20%;text-align:center;font-size:14px;background-color:#3398DB;color:white;">数据量</th>
				</tr>
			</thead>
			<tbody>
			[#list pageJudgedoc as judgedoc]
		<tr  >
			<td  style="text-align:center;">${judgedoc_index+1}</td>
			<td> ${judgedoc[0]}</td>
			<td> ${judgedoc[1]}</td>
			</td>
		</tr>
		[/#list]
			</tbody>
		</table>
	</div>
	<div class="col-xs-6">
		<div style="text-align: center;font-size: 18px;font-weight: 600;padding-top:10px;">失信被执行人信息排名  (前5名)</div>
		<table class="table table-bordered table-hover" style="margin-top:10px;">
			<thead>
				<tr>
					<th style="width:20%;text-align:center;font-size:14px;background-color:#3398DB;color:white;">排名</th>
					<th style="width:60%;text-align:center;font-size:14px;background-color:#3398DB;color:white;">企业名称</th>
					<th style="width:20%;text-align:center;font-size:14px;background-color:#3398DB;color:white;">数据量</th>
				</tr>
			</thead>
			<tbody>
		[#list pageDishonestMan as dishonestman]
		<tr>
			<td  style="text-align:center;">${dishonestman_index+1}</td>
			<td> ${dishonestman[0]}</td>
			<td> ${dishonestman[1]}</td>
			</td>
		</tr>
		[/#list] 
			</tbody>
		</table>
	</div>
		<div class="col-xs-6">
		<div style="text-align: center;font-size: 18px;font-weight: 600;padding-top:10px;">服务质量投诉信息排名  (前5名)</div>
		<table class="table table-bordered table-hover" style="margin-top:10px;">
			<thead>
				<tr>
					<th style="width:20%;text-align:center;font-size:14px;background-color:#3398DB;color:white;">排名</th>
					<th style="width:60%;text-align:center;font-size:14px;background-color:#3398DB;color:white;">企业名称</th>
					<th style="width:20%;text-align:center;font-size:14px;background-color:#3398DB;color:white;">数据量</th>
				</tr>
			</thead>
			<tbody>
				[#list pageServiceComplaint as complaint]
		<tr>
			<td  style="text-align:center;">${complaint_index+1}</td>
			<td> ${complaint[0]}</td>
			<td> ${complaint[1]}</td>
			</td>
		</tr>
		[/#list] 
			</tbody>
		</table>
	</div>
		<div class="col-xs-6">
		<div style="text-align: center;font-size: 18px;font-weight: 600;padding-top:10px;">公众表扬信息排名 (前5名) </div>
		<table class="table table-bordered table-hover" style="margin-top:10px;">
			<thead>
				<tr>
					<th style="width:20%;text-align:center;font-size:14px;background-color:#3398DB;color:white;">排名</th>
					<th style="width:60%;text-align:center;font-size:14px;background-color:#3398DB;color:white;">企业名称</th>
					<th style="width:20%;text-align:center;font-size:14px;background-color:#3398DB;color:white;">数据量</th>
				</tr>
			</thead>
			<tbody>
			[#list pagePublicPrise as publicprise]
		<tr>
			<td  style="text-align:center;">${publicprise_index+1}</td>
			<td> ${publicprise[0]}</td>
			<td> ${publicprise[1]}</td>
			</td>
		</tr>
		[/#list]	 
			</tbody>
		</table>
	</div>
	<div class="col-xs-6">
		<div class="chart" id="sfpjtablediv" style="padding: 0px;position: relative; height:425px;width:100%;"></div>
	</div>
	<div class="col-xs-6">
		<div class="chart" id="servicetablediv" style="padding: 0px;position: relative; height:425px;width:100%;"></div>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		serviceChart();
		sfpjChart();
	});
	
	//96096工单投诉业务信息排名
	var sfpjChart = function(){
		var data_x =  ${xComplaint};
		var data_y =  ${yComplaint};
		var myChart = echarts.init(document.getElementById("sfpjtablediv")); 
		var option = {
				title : {
					text: "96096工单投诉业务信息排名 (前10名)",
					x:'center'
				},
				color: ['#3398DB'],
				tooltip : {
					trigger: 'axis',
					axisPointer : {            // 坐标轴指示器，坐标轴触发有效
						type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				grid: {
					left: '1%',
					right: '1%',
					top:'8%',
					containLabel: true
				},
				xAxis : [
					{
						type : 'category',
						data : data_x,
						axisTick: {
							alignWithLabel: true
						},
						axisLabel:{
		            	interval:0,
		            	rotate:30
						}
					}
				],
				yAxis : [
					{
						type : 'value',
					    axisLine: {show: false}
					}
				],
				series : [
					{
						name:[""],
						type:'bar',
						barWidth: '60%',
						data:data_y,
						itemStyle: {
							normal: {
							label: {
								show: true,
								position: 'top',
								textStyle: {
									color: '#615a5a'
									}
								}
							}
						}
					}
				]
			};  
		 myChart.setOption(option); 
		 window.onresize = function(){
			 myChart.resize();
		 }
	}
	
	//96096工单咨询信息排名
	var serviceChart = function(){
		var data_x =  ${xConsult};
		var data_y =  ${yConsult};
		var myChart = echarts.init(document.getElementById("servicetablediv")); 
		var option = {
				title : {
					text: "96096工单咨询信息排名 (前10名)",
					x:'center'
				},
				color: ['#3398DB'],
				tooltip : {
					trigger: 'axis',
					axisPointer : {            // 坐标轴指示器，坐标轴触发有效
						type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				grid: {
					left: '1%',
					right: '1%',
					top:'8%',
					containLabel: true
				},
				xAxis : [
					{
						type : 'category',
						data : data_x,
						axisTick: {
							alignWithLabel: true
						},
						axisLabel:{
		            	interval:0,
		            	rotate:30
						}
					}
				],
				yAxis : [
					{
						type : 'value',
					    axisLine: {show: false}
					}
				],
				series : [
					{
						name:[""],
						type:'bar',
						barWidth: '60%',
						data:data_y,
						itemStyle: {
							normal: {
							label: {
								show: true,
								position: 'top',
								textStyle: {
									color: '#615a5a'
									}
								}
							}
						}
					}
				]
			};  
		 myChart.setOption(option); 
		 window.onresize = function(){
			 myChart.resize();
		 }
	}
	
	
</script>
[/@layout.main]
