[#import "common/layout.ftl" as layout] 
[#assign jss=["assets/js/date-time/bootstrap-timepicker.min.js","assets/js/echarts/echarts.js","assets/js/Basestat.js"]]
 [@layout.main modelcode=['hnii_stat_industry','96096_data'] otherjs=jss sername=['96096工单数据按业务行业统计'] pagename='统计分析']
 <div  class="table-responsive"  style="width:1688px;overflow-x: auto;">
  <div style="text-align: center;"><span style="font-weight: 600;font-size: 18px;">96096工单数据按行业统计</span></div>
		<table  class="table table-bordered table-hover">
			<thead>
				<tr>
					<th style="text-align:center;">类别</th>
					<th style="text-align:center;" rowspan="2">处理基数</th>
					[#list industryList  as industry]
					<th style="text-align:center;" colspan="2" >${industry.industry_name}</th>
					[/#list]
				</tr>
				<tr>
				    <th style="text-align:center;">年份</th>
				   [#list industryList  as industry]
					<th style="text-align:center;">数据量</th>
					<th style="text-align:center;">匹配率</th>
					[/#list]
				</tr>
			</thead>
			<tbody>
			[#list infos  as info]
			<tr>
			<td style="text-align:center;">${info.years}</td>
			<td style="text-align:center;">${info.countAll}</td>
			[#list info.values  as value]
			<td style="text-align:center;">${value.count}</td>
			<td style="text-align:center;">${value.percent}[#if value.percent??]%[/#if]</td>
			[/#list]
			</tr>
			[/#list]
			</tbody>
		</table>


	<div id="hangye" class="col-xs-12" style="height:400px;padding:10px;">
	</div>
 </div>
<script type="text/javascript">
var xdata = ${yearstr}
var ydata = ${datas};
var legend = ${industrystr}; 
$(function(){
	Basestat.createPilePie('hangye','工单数据按行业统计','采集年份',legend,xdata,ydata);
});

</script>	 																								


[/@layout.main]