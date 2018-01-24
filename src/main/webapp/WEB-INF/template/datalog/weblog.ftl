[#import "common/layout.ftl" as layout]  
[#assign jss=["assets/js/echarts/echarts.js","assets/js/Basestat.js","assets/js/date-time/bootstrap-datetimepicker.min.js"]]
[#assign css=["assets/css/bootstrap-timepicker.css","assets/css/datetimepicker.css"]]
[@layout.main modelcode=['logclean','cleanlog'] otherjs=jss othercss=css sername=['数据清洗','网站清洗日志']  ]

[#assign  tablewidth=(280+datelist?size*110)+'px']

<form class="form-horizontal" role="form" id="formid" action="${base}/logmgr/weblog" method="get"  autocomplete="off">
<div class="col-xs-12" >
<table class="table-form"  > 
	<tbody>
		<tr>
			<td style="width:10%;font-size:16px;font-weight: bold;padding-bottom: 10px;margin-top:10px;">快捷方式</td>
			<td style="width:90%;font-size:16px;font-weight: bold;padding-bottom: 10px;margin-top:10px;">
				<button class="btn btn-sm btn-primary" type="button" style="float:left;margin-top: 1px;"  onclick="search('oneweek');">近一周</button>
				<button class="btn btn-sm btn-primary" type="button" style="float:left;margin-top: 1px;margin-left:5px;" onclick="search('onemonth');">近一个月</button>
				<button class="btn btn-sm btn-primary" type="button" style="float:left;margin-top: 1px;margin-left:5px;" onclick="search('thisyear');">今年</button>
				<button class="btn btn-sm btn-primary" type="button" style="float:left;margin-top: 1px;margin-left:5px;" onclick="search('lastyear');">去年</button>
				<input id="searchtype"  name="searchtype" type="hidden" > 
			</td>
		</tr>
		<tr>
			<td style="width:10%;font-size:16px;font-weight: bold;padding-bottom: 10px;margin-top:10px;">统计方式</td>
			<td style="width:90%;font-size:16px;font-weight: bold;padding-bottom: 10px;margin-top:10px;">
			<input type="radio" name="searchtypesub" value="year" onclick="changesearchtypesub()"  [#if searchtypesub=="year"]checked[/#if]> 按年 
			<input type="radio" name="searchtypesub" value="month"  onclick="changesearchtypesub()"  [#if searchtypesub=="month"]checked[/#if]> 按月 
			<input type="radio" name="searchtypesub" value="day"  onclick="changesearchtypesub()"  [#if searchtypesub=="day"]checked[/#if][#if !searchtypesub??]checked[/#if]> 按日
			
			</td>
		</tr>
		
		
		<tr>
			<td style="width:10%;font-size:16px;font-weight: bold;padding-bottom: 10px;margin-top:10px;"></td>
			<td style="width:90%;font-size:16px;font-weight: bold;padding-bottom: 10px;margin-top:10px;">
			<div    class="  input-group date form_datetime formtd-width80" style="width:180px;float:left;margin-left:8px;">
						<input class="form-control formtd-width80 input-inline"  name="begindate" id="begindate"  readonly 
									[#if !searchtypesub??]data-date-format="yyyy-MM-dd" value="${(begindate?string('yyyy-MM-dd'))!}"[/#if] 
									[#if searchtypesub=="day"]data-date-format="yyyy-MM-dd" value="${(begindate?string('yyyy-MM-dd'))!}"[/#if] 
									[#if searchtypesub=="month"]data-date-format="yyyy-MM" value="${(begindate?string('yyyy-MM'))!}"[/#if] 
									[#if searchtypesub=="year"]data-date-format="yyyy" value="${(begindate?string('yyyy'))!}"[/#if] 
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
									[#if !searchtypesub??]data-date-format="yyyy-MM-dd" value="${(enddate?string('yyyy-MM-dd'))!}"[/#if] 
									[#if searchtypesub=="day"]data-date-format="yyyy-MM-dd" value="${(enddate?string('yyyy-MM-dd'))!}"[/#if] 
									[#if searchtypesub=="month"]data-date-format="yyyy-MM" value="${(enddate?string('yyyy-MM'))!}"[/#if] 
									[#if searchtypesub=="year"]data-date-format="yyyy" value="${(enddate?string('yyyy'))!}"[/#if] 
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





	<div class="col-xs-12" style="text-align:center;font-size:16px;font-weight: bold;padding-bottom: 10px;margin-top:10px;">

			[#if searchtype=="oneweek"]近一周数据清洗量统计 
	[#elseif searchtype=="onemonth"]近一个月数据清洗量统计 
	[#elseif searchtype=="thisyear"]今年数据清洗量统计 
	[#elseif searchtype=="lastyear"]去年数据清洗量统计 
	[#elseif searchtype=="subtime"]
		[#if searchtypesub=="day"]
		${(begindate?string('yyyy-MM-dd'))!}~${(enddate?string('yyyy-MM-dd'))!}数据清洗量按日统计
		[#elseif searchtypesub=="month"]
		${(begindate?string('yyyy-MM'))!}~${(enddate?string('yyyy-MM'))!}数据清洗量按月统计
		[#elseif searchtypesub=="year"]
		${(begindate?string('yyyy'))!}~${(enddate?string('yyyy'))!}数据清洗量按年统计
		[/#if]
	[/#if]
	
	
	
	</div>
		<div class="col-xs-12" style="overflow-x: auto;  text-align:center;font-size:16px; padding-bottom: 10px;margin-top:10px;">
		
		<table class="table table-bordered table-hover"  style="width:${tablewidth};text-align:center;" >
			<thead>
				<tr>
					
					<th style="width:60px;text-align:center;">序号 </th>
					<th style="width:220px;text-align:center;">数据来源</th>
					[#if datelist??]
					[#list datelist as date]
					<th style="width:110px; text-align:center;">${date}</th>
					[/#list]
					[/#if]
				</tr>
			</thead>
			<tbody>
			[#if tabletr??]
			[#list tabletr as tr]
				<tr>
					<td style="text-align:center;">${tr_index+1}</td>
					[#list tr as td]
					<td style="text-align:center;">${td}</td>
					[/#list]
					
				</tr>
			[/#list]
			[/#if]
			</tbody>
		</table>
		</div>
				<div class="col-xs-12">
			<div class="chart" id="chart_collection" style="padding: 0px; position: relative;height:400px;width:100%;"></div>
		</div>
<script type="text/javascript">

$(function() {
	initchars();
	initTime();
});
function search(searchtype){
	$("#searchtype").val(searchtype);
	
	
	if(searchtype=='subtime'){
		var searchtypesub=$("input[name='searchtypesub']:checked").val();
		var begindate=$("#begindate").val();
		var enddate=$("#enddate").val();
		if(searchtypesub!="year"&&searchtypesub!="month"&&searchtypesub!="day"){
			alert("请选择统计方式： 按年、按月、按日。");
		}else if(begindate==null||begindate==undefined||begindate==""||enddate==null||enddate==undefined||enddate==""){
			alert("请选择时间范围。");
		}else{
			if(begindate>=enddate){
				alert("结束时间必须大于开始时间。");
			}else{ 
				if(searchtypesub=="day"){
					var time1 = Date.parse(new Date(begindate));
				    var time2 = Date.parse(new Date(enddate));  
					var cc=  parseInt(Math.abs(parseInt(time2 - time1)) / 1000 / 60 / 60 / 24); 
					if(cc>31){
						alert("按日统计时，日期相差不得超过1个月");
					}else{
						$("#fomsubmit").click();
					}
				}
				if(searchtypesub=="month"){
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
				if(searchtypesub=="year"){
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
		
// 		if(bool==true){
// 			$("#fomsubmit").click();
// 		}
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
	var searchtypesub=$("input[name='searchtypesub']:checked").val();
	$(".form_datetime").datetimepicker('remove');
	if(searchtypesub=="year"){
		initTimeYear();
	}
	if(searchtypesub=="month"){
		initTimeMonth();
	}
	if(searchtypesub=="day"){
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



		var initchars = function(){
			
			
		var legenddata=${chartdata[0]};
		var xAxisdata=${chartdata[1]};
		var seriesdata=${chartdata[2]};
		var myChart = echarts.init(document.getElementById("chart_collection")); 
		var  option = {
			    title : {
			        text: '',
			        x :'center',
			    },
			    tooltip : {
			        trigger: 'axis'
			    },
			    legend: {
			        data:legenddata,
			    	x :'right',
					orient:'vertical',
					tooltip:{
						show:true
					}
			    },
			    grid: {
			        left: '4%',
			        right:'4%',
					top:'1%'
			    },
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            data : xAxisdata,
						axisLabel:{
		            	interval:0,
		            	rotate:20
						}
			        }
			    ],
			    yAxis : [
			        {
			        type : 'value',
					axisLine: {show: false}
			        }
			    ],
			    series : seriesdata
			};
		 myChart.setOption(option); 
		 window.onresize = function(){
			 myChart.resize();
		 }
		}
		</script>
 

[/@layout.main]