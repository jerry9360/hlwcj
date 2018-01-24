[#import "common/layout.ftl" as layout] 
[#assign jss=["assets/js/date-time/bootstrap-timepicker.min.js","assets/js/echarts/echarts.js"]]
 [@layout.main modelcode=['hnii_datacollect','96096_data'] otherjs=jss sername=['96096工单数据汇总'] pagename='统计分析']
 
  <div class="col-xs-12">
	<div class="col-xs-4" style="padding:10px;">
		<span style="font-weight: 600;font-size: 18px;">处理基数</span>
		<table  class="table  table-bordered table-hover">
			<thead>
				<tr>
					<th style="width:20%;text-align:center;">年份</th>
					<th style="width:20%;text-align:center;">数据量</th>
				</tr>
			</thead>
			<tbody>
			[#list years  as obj]
			<tr>
			<td style="text-align:center;">${obj[1]}</td>
			<td style="text-align:center;">${obj[0]}</td>
  			</tr>
  			 [/#list]
  			 <tr>
  			 <td style="width:20%;text-align:center;font-weight:bold;">合计</td>
  			 <td style="width:20%;text-align:center;">${countAll}</td>
  			 </tr>
			</tbody>
		</table>
	</div>
<div class="col-xs-8" style="padding:10px;">
	<div id="year" class="col-xs-12" style="height:500px;padding:10px;">
	</div>
</div>
</div>
 
  <div class="col-xs-12">
	<div class="col-xs-4" style="padding:10px;">
		<span style="font-weight: 600;font-size: 18px;">行业统计</span>
		<table  class="table  table-bordered table-hover">
			<thead>
				<tr>
					<th style="width:20%;text-align:center;">行业</th>
					<th style="width:20%;text-align:center;">数据量</th>
				</tr>
			</thead>
			<tbody>
			[#list dataIndustry  as obj]
			<tr>
			<td style="text-align:center;" name="hangyename">${obj[0]}</td>
			<td style="text-align:center;">${obj[1]}</td>
  			</tr>
  			 [/#list]
			</tbody>
		</table>
	</div>
<div class="col-xs-8" style="padding:10px;">
	<div id="hangye" class="col-xs-12" style="height:500px;padding:10px;">
	</div>
</div>
</div>

  <div class="col-xs-12">
	<div class="col-xs-4" style="padding:10px;">
		<span style="font-weight: 600;font-size: 18px;">大类统计</span>
		<table  class="table  table-bordered table-hover">
			<thead>
				<tr>
					<th style="width:20%;text-align:center;">大类</th>
					<th style="width:20%;text-align:center;">数据量</th>
				</tr>
			</thead>
			<tbody>
			[#list dataDalei as obj] 
			<tr>
			<td style="text-align:center;">${obj[0]}</td>
			<td style="text-align:center;">${obj[1]}</td>
  			</tr>
			  
			[/#list]
			</tbody>
		</table>
	</div>
<div class="col-xs-8" style="padding:10px;">
	<div id="dalei" class="col-xs-12" style="height:500px;padding:10px;">
	</div>
</div>
</div>
   [#assign index=0]
   [#list entityDaleis as dalei] 
   [#assign index=index+1]
   <div class="col-xs-12">
   <div class="col-xs-4">
        <span style="font-weight: 600;font-size: 18px;">小类统计--${dalei.name}</span>
		<table  class="table  table-bordered table-hover">
			<thead>
				<tr>
					<th style="width:20%;text-align:center;">小类</th>
					<th style="width:20%;text-align:center;">数据量</th>
				</tr>
			</thead>
			<tbody>
			[#list dalei.values as value]
			<tr>
			<td style="text-align:center;">${value.name}</td>
			<td style="text-align:center;">${value.count}</td>
			 </tr>
			 [/#list]
			
			</tbody>
		</table>
	</div>
 <div class="col-xs-8" style="padding:10px;">
	<div id="xiaolei${index}" name="chart" class="col-xs-12" style="height:500px;padding:10px;">
	<input type="hidden" name="${dalei.namedata}" id="${dalei.countdata}">
	</div>
</div>
</div>
[/#list]
 
<script type="text/javascript">


$(function(){
	    createBar("year",'96096工单数据处理基数',${yearnames},${yearcount});
		createBar("hangye",'96096数据汇总按行业统计',${industrynames},${industrycount});
		createBar("dalei",'96096数据汇总按大类统计',${rootnames},${rootcount});
		var namedatas=${namedatas};
		var countdatas=${countdatas};
		var charts=$("div[name='chart']");
		for(i=0;i<charts.length;i++){
			var name=${namedatas}[i];
			var count=${countdatas}[i];
			var position="xiaolei"+(i+1);
			createBar(position,'96096数据汇总按小类统计',name,count);
		} 
		
});
createBar = function(id,title,name,count){
	var myChart = echarts.init(document.getElementById(id)); 
	var option = {
		    title : {
		        text: '',
		        subtext: '',
		        x:'left'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		    	 x : 'center',
		         y : 'bottom',
		        data:name
		    },
		    calculable : true,
		    series : [
		        {
		            name:title,
		            type:'pie',
		            radius : '55%',
		            itemStyle : {
		                normal : {
		                    label : {
		                        show : true,
		                        formatter: '{b} : {c} ({d}%)'
		                    },
		                    labelLine : {
		                        show : true
		                    }
		                },
		                emphasis : {
		                    label : {
		                        show : true,
		                        position : 'center',
		                        textStyle : {
		                            fontSize : '18',
		                            fontWeight : 'bold'
		                        }
		                    }
		                }
		            },
		            data:count
		        }
		    ]
		};
	 myChart.setOption(option); 
	 window.onresize = function(){
		 myChart.resize();
	 }
	 return myChart;
}
</script>
[/@layout.main]	