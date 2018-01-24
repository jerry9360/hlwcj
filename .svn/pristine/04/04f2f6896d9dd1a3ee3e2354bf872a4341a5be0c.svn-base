[#import "common/layout.ftl" as layout] 
[#assign jss=["assets/js/date-time/bootstrap-timepicker.min.js","assets/js/echarts/echarts.js","assets/js/Basestat.js"]]
[@layout.main modelcode=['stat_judgedoc','96096_data'] otherjs=jss sername=['司法判决信息按案件类型统计'] pagename='统计分析']
 
  <div class="col-xs-12">
  <div style="text-align: center;"><span style="font-weight: 600;font-size: 18px;">司法判决信息按案件类型统计</span></div>
		<table  class="table  table-bordered table-hover">
			<thead>
				<tr>
					<th style="text-align:center;">案件类型</th>
					<th style="text-align:center;">数据量</th>
				</tr>
			</thead>
			<tbody>
			[#list judgeDocs as judgeDoc]
			<tr>
			<td style="text-align:center;">
			[#if judgeDoc[0]=='1']刑事案件
			[#elseif judgeDoc[0]=='2']民事案件
			[#elseif judgeDoc[0]=='3']行政案件
			[#elseif judgeDoc[0]=='4']赔偿案件
			[#elseif judgeDoc[0]=='5']执行案件
			[/#if]
			</td>
			<td style="text-align:center;">${judgeDoc[1]}</td>
			</tr>
			[/#list]
			<tr>
  			 <td style="text-align:center;font-weight:bold;">合计</td>
  			 <td style="text-align:center;">${countAll}</td>
  			 </tr>
			</tbody>
		</table>
	</div>


<div class="col-xs-12">
		<div id="judgedoc" class="col-xs-12" style="height:400px;padding:10px;">
	</div>
</div>
 
<script type="text/javascript">
var corp_lengend = ['数据量'];
$(function(){
	Basestat.createBar("judgedoc",'司法判决信息按案件类型统计','','数据量',corp_lengend,${xdata},${ydata});
});

</script>	 																								


[/@layout.main]