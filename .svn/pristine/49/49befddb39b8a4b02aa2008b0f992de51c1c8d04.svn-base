[#assign jss=["assets/js/echarts/echarts.js","assets/js/Basestat.js"]]
[#assign css=["assets/css/bootstrap-timepicker.css"]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['home'] otherjs=jss othercss=css]
<div class="row">
<div class="col-xs-12">
	<div class="responsive span3">
		<div class="dashboard-stat blue">
			<div class="details">
				<div class="number">${countcorp}</div>
				<div class="desc" style="font-weight: bold">从业企业数量</div>
			</div>
  			<a class="more" href="${base}/corpmgr/corpinfo/list">
			详细信息 <span style="float:right;">more</span>
			</a>                
		</div>
		</div>
		<div class="responsive span3">
			<div class="dashboard-stat purple">
				<div class="details">
					<div class="number">${countperson}</div>
					<div class="desc" style="font-weight: bold">&nbsp; &nbsp;&nbsp; &nbsp;从业人员数量 </div>
	
				</div>
				<a class="more"  href="${base}/permgr/personinfo/list">
				 详细信息 <span style="float:right;">more</span>
				</a>                 
			</div>
		</div>
		<div class="responsive span3">
			<div class="dashboard-stat green">
				<div class="details">
					<div class="number">${counthlwcollect}</div>
					<div class="desc" style="font-weight: bold">&nbsp; &nbsp;&nbsp; &nbsp;互联网采集数量 </div>
	
				</div>
				<a class="more"  href="${base}/corp/corpgood_badinfo">
				 详细信息 <span style="float:right;">more</span>
				</a>                 
			</div>
		</div>
		<div class="responsive span3">
			<div class="dashboard-stat yellow">
				<div class="details">
					<div class="number">${credit}</div>
					<div class="desc" style="font-weight: bold">公众评价信息</div>
				</div>
				 <a class="more"  href="${base}/corp/publicprise">
				详细信息 <span style="float:right;">more</span>
				</a>                
			</div>
		</div>
	</div>
	<div class="col-xs-6">
		<div class="chart" id="sfpjtablediv" style="padding: 0px;position: relative; height:425px;width:100%;"></div>
	</div>
	<div class="col-xs-6">
		<div class="chart" id="servicetablediv" style="padding: 0px;position: relative; height:425px;width:100%;"></div>
	</div>
	<div class="col-xs-6">
		<div class="chart" id="hangyetablediv" style="padding: 0px;position: relative; height:425px;width:100%;"></div>
	</div>
	<div class="col-xs-6">
		<div class="chart" id="ywtablediv" style="padding: 0px;position: relative; height:425px;width:100%;"></div>
	</div>
	 <div class="col-xs-6" style="display:none;">
	<div class="chart" id="tablediv" style="padding: 0px;position: relative; height:425px;width:100%;">
	</div>
    </div>	
    <div class="col-xs-6" style="display:none;">
		<div class="chart" id="chart_collection" style="padding: 0px; position: relative;height:350px;width:100%;"></div>
	</div>
</div>
<script type="text/javascript">

	$(function(){
		serviceChart();
		sfpjChart();
		hangyeChart();
		ywChart();
	});
	
	//司法判决信息
	var sfpjChart = function(){
		var data_x = ${datajudge[0]}; 
		var data_y = ${datajudge[1]};
		var myChart = echarts.init(document.getElementById("sfpjtablediv")); 
		var option = {
				title : {
					text: "司法判决信息统计",
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
		            	rotate:10
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
	
	//表彰、获奖、通报批评、司法判决、失信被执行人、招标信息、中标信息、服务质量投诉信息、公众表扬信息
	var serviceChart = function(){
		var data_x = ${datacredit[0]};
		var data_y = ${datacredit[1]};
		var myChart = echarts.init(document.getElementById("servicetablediv")); 
		var option = {
				title : {
					text: "从业企业信用数据采集统计",
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
		            	rotate:10
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
	
	//96096行业分布
	var hangyeChart = function(){
		
		var data_x =  ${data96096industrydesc[1]} ;
		var data_series =${data96096industrydesc[0]} ;
		var myChart = echarts.init(document.getElementById("hangyetablediv")); 
		var option = {
				title : {
					text: "96096工单行业分布统计",
					x:'center'
				},
			    tooltip: {
			        trigger: 'item',
			        formatter: "{a} <br/>{b}: {c} ({d}%)"
			    },
			    legend: {
			        orient: 'vertical',
			        x: 'right',
			        data:data_x
			    },
			    series: [
			        {
			            name:'工单数据量',
			            type:'pie',
			            radius: ['50%', '70%'],
			            center: ['45%', '55%'], 
			             
			            data:data_series
			        }
			    ]
			};
		 myChart.setOption(option); 
		 window.onresize = function(){
			 myChart.resize();
		 }
	}
	
	//96096行业分布
	var ywChart = function(){
		var data_x =  ${data96096btypedesc[1]} ;
		var data_series =${data96096btypedesc[0]} ;
		var myChart = echarts.init(document.getElementById("ywtablediv")); 
		var option = {
				title : {
					text: "96096工单业务分布统计",
					x:'center'
				},
			    tooltip: {
			        trigger: 'item',
			        formatter: "{a} <br/>{b}: {c} ({d}%)"
			    },
			    legend: {
			        orient: 'vertical',
			        x: 'right',
			        data:data_x
			    },
			    series: [
			        {
			            name:'工单数据量',
			            type:'pie',
			            radius: ['50%', '70%'],
			            center: ['45%', '55%'], 
			            data:data_series
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
