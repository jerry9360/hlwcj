[#assign jss=[ "assets/js/Basestat.js"]]
[#assign jss=["assets/js/date-time/bootstrap-datetimepicker.min.js"]] 
[#assign css=["assets/css/zhemutanchukuang.css","assets/css/datetimepicker.css"]]
[#import "common/layout.ftl" as layout] 
[@layout.main  modelcode=['fx_data']  otherjs=jss othercss=css  ]
[#include "common/loading.ftl"] 
 <div class="col-xs-12" style="text-align:center;font-size:16px;font-weight: bold;padding-bottom: 10px;">数据采集量统计</div>
<table  class="table  table-bordered table-hover">
	<thead>
		<tr>
			<th style="width:5%;text-align:center;">序号 </th>
			<th style="width:30%;text-align:center;">业务类别</th>
			<th style="width:20%;text-align:center;">采集量</th>
		</tr>
	</thead>
	<tbody>
		[#list object as corp]
		<tr  >
			<td  style="text-align:center;">${corp_index+1}</td>
			<td >${corp[0]}</td>
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
				text: "业务数据统计柱形图",
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