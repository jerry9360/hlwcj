[#import "common/layout.ftl" as layout] 
[#assign jss=["assets/js/date-time/bootstrap-datetimepicker.min.js"]] 
[#assign css=["assets/css/zhemutanchukuang.css","assets/css/datetimepicker.css"]]
[@layout.main  modelcode=['fx_behavior' ]   otherjs=jss othercss=css  ]
[#include "common/loading.ftl"] 

<form class="form-horizontal" role="form" id="formid" action="${base}/analyzemgr/behavior" method="get"  autocomplete="off">
<div class="col-xs-12" >
<table class="table-form"  > 
	<tbody>
	<tr>
	<td style="width:100%;font-size:18px;padding-bottom: 10px;margin-top:10px;">行业：
		 [#list industrys  as industrys]
		<input id="industry"  type="radio" name="industry" value="${industrys.industry_name}" > ${industrys.industry_name} 
		[/#list]
		</tr>
	<tr>
	<td style="width:100%;font-size:16px;padding-bottom: 10px;margin-top:10px;">业务：
		 [#list roots  as root]
		<input id="btype"  type="radio" name="btype"  onclick="changeView(this);" value="${root.business_name}"  > ${root.business_name} </input>
		[/#list]
		</td>
		</tr>
		<tr>
			<td style="width:90%;font-size:16px;padding-bottom: 10px;margin-top:10px;">统计方式
			<input type="radio" name="timetype" value="year" onclick="changesearchtypesub()"  [#if timetype=="year"]checked[/#if]> 按年 
			<input type="radio" name="timetype" value="month"  onclick="changesearchtypesub()"  [#if timetype=="month"]checked[/#if]> 按月 
			<input type="radio" name="timetype" value="day"  onclick="changesearchtypesub()"  [#if timetype=="day"]checked[/#if][#if !timetype??]checked[/#if]> 按日
			</td>
		</tr>
		<tr>
			<td style="width:90%;font-size:16px;font-weight: bold;padding-bottom: 10px;margin-top:10px;">
			<div    class="  input-group date form_datetime formtd-width80" style="width:180px;float:left;margin-left:8px;">
						<input class="form-control formtd-width80 input-inline"  name="begindate" id="begindate"  readonly 
									[#if !timetype??]data-date-format="yyyy-MM-dd" value="${(begindate?string('yyyy-MM-dd'))!}"[/#if] 
									[#if timetype=="day"]data-date-format="yyyy-MM-dd" value="${(begindate?string('yyyy-MM-dd'))!}"[/#if] 
									[#if timetype=="month"]data-date-format="yyyy-MM" value="${(begindate?string('yyyy-MM'))!}"[/#if] 
									[#if timetype=="year"]data-date-format="yyyy" value="${(begindate?string('yyyy'))!}"[/#if] 
									style="border-right: 0px; background-color: white;">
						<span class="input-group-btn">
							<button class="btn btn-primary date-set" type="button" style="padding: 0px 2px;height: 31px;">
									<img  src="${base}/assets/images/rl.png" style="float:left;">
								</button>
							</span>
						</div>
						<div style="float:left;margin-left:10px;margin-top: 5px;">~</div>
						<div class="input-group date form_datetime formtd-width80" style="width:180px;float:left;margin-left:10px;">
						<input class="form-control formtd-width80 input-inline"  name="enddate"  id="enddate"  readonly 
									[#if !timetype??]data-date-format="yyyy-MM-dd" value="${(enddate?string('yyyy-MM-dd'))!}"[/#if] 
									[#if timetype=="day"]data-date-format="yyyy-MM-dd" value="${(enddate?string('yyyy-MM-dd'))!}"[/#if] 
									[#if timetype=="month"]data-date-format="yyyy-MM" value="${(enddate?string('yyyy-MM'))!}"[/#if] 
									[#if timetype=="year"]data-date-format="yyyy" value="${(enddate?string('yyyy'))!}"[/#if] 
									style="border-right: 0px; background-color: white;">
						<span class="input-group-btn">
							<button class="btn btn-primary date-set" type="button" style="padding: 0px 2px;height: 31px;">
											<img src="${base}/assets/images/rl.png" style="float:left;">
							</button>
						</span>
					</div>
				<button class="btn btn-sm btn-primary" type="button" style="float:left;margin-top: 1px;margin-left:5px;" onclick="search('subtime');">查 询</button>
			 	<button class="btn btn-sm btn-primary" type="submit"  id="fomsubmit" style="float:left;margin-top: 1px;margin-left:20px;display:none;"></button> 
			</td>
		</tr>
	</tbody>
</table>
</div>
</form>

 <div class="col-xs-12" style="overflow-x: auto;  text-align:center;font-size:16px; padding-bottom: 10px;margin-top:10px;">
			
		<table class="table table-bordered table-hover"   >
	 
			 
			<tbody>
				 
			<tr> 
					<td style="width:100px; height: 10px; " align="center"  valign="middle"rowspan="2" >时间</td>
					<td style="width:50px; height: 10px; " align="center"  valign="middle"rowspan="2" >工单数据量</td>
					<td style="width:50px; height: 10px; " align="center"  valign="middle"rowspan="2" >处理出工单量</td>
					<td style="width:50px; height: 10px; " align="center"  valign="middle"rowspan="2" >总占比率</td>
					[#list stypedata as tr]
						<td style="text-align:center;" colspan="2">${tr[0]} </td> 
					[/#list]
				</tr>
				 
				<tr>
				[#list stypedata as tr]
					<td style="text-align:center;">工单量</td>
					<td style="text-align:center;">占比率</td>
				[/#list]
				</tr>
				<tr>
				[#list list as tr]
				<tr>
					[#list tr as td]
				<td style="text-align:center;">${td}</td>
					[/#list]
				</tr>
			[/#list]
				</tr>
			</tbody>
		</table>
		</div>
	 <div class="col-md-12">
	<div class="chart" id="sfpjtablediv" style="padding: 10px;position: relative; height:425px; "></div>
    </div>
     
 <script type="text/javascript">
 $(function() {
	 sfpjChart();
	initTime();
	});
 
 function changesearchtypesub(){
		$("#begindate").val(null);
		$("#enddate").val(null);
		initTime();
	}
 function search(searchtype){
		$("#searchtype").val(searchtype);
		if(searchtype=='subtime'){
			var timetype=$("input[name='timetype']:checked").val();
			var begindate=$("#begindate").val();
			var enddate=$("#enddate").val();
			if(timetype!="year"&&timetype!="month"&&timetype!="day"){
				alert("请选择统计方式： 按年、按月、按日。");
			}else if(begindate==null||begindate==undefined||begindate==""||enddate==null||enddate==undefined||enddate==""){
				alert("请选择时间范围。");
			}else{
				if(begindate>=enddate){
					alert("结束时间必须大于开始时间。");
				}else{ 
					if(timetype=="day"){
						var time1 = Date.parse(new Date(begindate));
					    var time2 = Date.parse(new Date(enddate));  
						var cc=  parseInt(Math.abs(parseInt(time2 - time1)) / 1000 / 60 / 60 / 24); 
						if(cc>31){
							alert("按日统计时，日期相差不得超过1个月");
						}else{
							$("#fomsubmit").click();
						}
					}
					if(timetype=="month"){
						var time1=new Date(begindate);
						var time2=new Date(enddate);
						var year1=time1.getFullYear();
						var year2=time2.getFullYear();
						var month1=time1.getMonth()+1;
						var month2=time2.getMonth()+1;
						var cc=0; 
						if((year2-year1)==0){
							cc=month2-month1+1;
						}else if((year2-year1)==1){
							cc=(12-month1)+month2+1;
						}else{
							cc=13;
						}
						if(cc>12){
							alert("按月统计时，月份相差不得超过1年");
						}else{
							$("#fomsubmit").click();
						}
					}
					if(timetype=="year"){
						var time1=new Date(begindate);
						var time2=new Date(enddate);
						var year1=time1.getFullYear();
						var year2=time2.getFullYear();
						var cc=year2-year1+1;
						if(cc>12){
							alert("按年统计时，年份相差不得超过12年");
						}else{
							$("#fomsubmit").click();
						}
						
					}
				}
				
			}
//	 		if(bool==true){
//	 			$("#fomsubmit").click();
//	 		}
		}else{
			$("#fomsubmit").click();
		}
		
	}
	function initTimeDate() {
	 	$(".form_datetime").datetimepicker({
			autoclose : true,
			format : "yyyy-MM-dd",
			startView:'month',
			minView :'month',
			pickerPosition:'bottom-left',
			language : 'zh_CN'
		});
	}
	function initTimeMonth() {
		$(".form_datetime").datetimepicker({
			autoclose : true,
			format : "yyyy-MM",
			startView:'year',
			minView :'year',
			pickerPosition:'bottom-left',
			language : 'zh_CN'
		});
	}
	function initTimeYear() {
		$(".form_datetime").datetimepicker({
			autoclose : true,
			format : "yyyy",
			startView:'decade',
			minView :'decade',
			pickerPosition:'bottom-left',
			language : 'zh_CN'
		});
	}
	function initTime(){
		var timetype=$("input[name='timetype']:checked").val();
		$(".form_datetime").datetimepicker('remove');
		if(timetype=="year"){
			initTimeYear();
		}
		if(timetype=="month"){
			initTimeMonth();
		}
		if(timetype=="day"){
			initTimeDate();
		}else{
			initTimeDate();
			
		}
	}
	function changesearchtypesub(){
		$("#begindate").val(null);
		$("#enddate").val(null);
		initTime();
	}
   //96096工单行为特征排名
	var sfpjChart = function(){
	var data_x =  ${xAxis};
	var data_y =  ${yAxis};
	var myChart = echarts.init(document.getElementById("sfpjtablediv")); 
	var option = {
			title : {
				text: "按照行为特征分类统计折线图",
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