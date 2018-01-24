[#assign jss=[ "assets/js/Basestat.js"]]
[#assign jss=["assets/js/date-time/bootstrap-datetimepicker.min.js"]] 
[#assign css=["assets/css/zhemutanchukuang.css","assets/css/datetimepicker.css"]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['fx_chepai' ]   otherjs=jss othercss=css  ]
[#include "common/loading.ftl"] 
<form class="form-horizontal" role="form" id="formid" action="${base}/analyzemgr/complaintcarno" method="get"  autocomplete="off">
			<table class="table-form">
			<thead>
			<button class="btn btn-sm btn-primary" type="button" style="float:left;margin-top: 1px;" onclick="location.href='${base}/analyzemgr/complaintcarno?time=0&'">近一周</button>
			<button class="btn btn-sm btn-primary" type="button" style="float:left;margin-top: 1px;margin-left:8px;" onclick="location.href='${base}/analyzemgr/complaintcarno?time=1&'">近一个月</button>
			<button class="btn btn-sm btn-primary" type="button" style="float:left;margin-top: 1px;margin-left:8px;" onclick="location.href='${base}/analyzemgr/complaintcarno?time=2&'">今年</button>
			<button class="btn btn-sm btn-primary" type="button" style="float:left;margin-top: 1px;margin-left:8px;" onclick="location.href='${base}/analyzemgr/complaintcarno?time=3&'">去年</button>
			<div    class="input-group date form_datetime formtd-width80" style="width:180px;float:left;margin-left:8px;">
			<input class="form-control formtd-width80 input-inline"  name="begindate" readonly 
						id="begindate" data-date-format="yyyy-MM-dd" value="${(begindate?string('yyyy-MM-dd'))!}"
						style="border-right: 0px; background-color: white;">
			<span class="input-group-btn">
				<button class="btn btn-primary date-set" type="button" style="padding: 0px 2px;height: 31px;">
								<img  src="${base}/assets/images/rl.png" style="float:left;">
					</button>
				</span>
			</div>
			<div style="float:left;margin-left:10px;margin-top: 5px;">~</div>
			<div class="input-group date form_datetime formtd-width80" style="width:180px;float:left;margin-left:10px;">
			<input class="form-control formtd-width80 input-inline"  name="enddate" readonly 
						id="begindate" data-date-format="yyyy-MM-dd" value="${(enddate?string('yyyy-MM-dd'))!}"
						style="border-right: 0px; background-color: white;">
			<span class="input-group-btn">
				<button class="btn btn-primary date-set" type="button" style="padding: 0px 2px;height: 31px;">
								<img src="${base}/assets/images/rl.png" style="float:left;">
				</button>
			</span>
		</div>
	 	
		<button class="btn btn-sm btn-primary" type="submit" style="float:left;margin-top: 1px;margin-left:20px;">查 询</button> 
	</table>
</form>


<table  class="table  table-bordered table-hover">
	<thead>
		<tr>
			<th style="width:5%;text-align:center;">序号 </th>
			<th style="width:30%;text-align:center;">车牌号</th>
			<th style="width:20%;text-align:center;">工单数据量</th>
		</tr>
	</thead>
	<tbody>
		[#list page as corp]
		<tr  >
			<td  style="text-align:center;">${corp_index+1}</td>
			<td ><a  href="${base}/analyzemgr/complaintcarno/show?carno=${corp[0]}&">${corp[0]}</a></td>
			<td>${corp[1]}</td>
			</td>
		</tr>
		[/#list]
	</tbody>
</table>
	<div class="col-xs-12">
		<div class="chart" id="sfpjtablediv" style="padding: 0px;position: relative; height:425px;width:100%;"></div>
	</div>
<script type="text/javascript">
$(function() {
	$("#btype").click();
	initTime();
});

function initTime() {
	$(".form_datetime").datetimepicker({
		autoclose : true,
		format : "yyyy-MM-dd",
		minuteStep : 1,
		minView : 2,
		pickerPosition:'bottom-left',
		language : 'zh_CN'
	});
}

$(function(){
	sfpjChart();
});
//96096工单投诉业务信息排名
var sfpjChart = function(){
	var data_x =  ${xAxis};
	var data_y =  ${yAxis};
	var myChart = echarts.init(document.getElementById("sfpjtablediv")); 
	var option = {
			title : {
				text: "96096工单投诉车牌号排名",
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