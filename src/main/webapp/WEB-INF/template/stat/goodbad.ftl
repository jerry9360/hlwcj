[#import "common/layout.ftl" as layout] 
[#assign jss=["assets/js/date-time/bootstrap-timepicker.min.js","assets/js/echarts/echarts.js","assets/js/Basestat.js"]]
 [@layout.main modelcode=['stat_goodbad','96096_data'] otherjs=jss sername=['表彰、通报批评类信息按类型统计'] pagename='统计分析']
 
  <div class="col-xs-12">
  <div style="text-align: center;"><span style="font-weight: 600;font-size: 18px;">表彰、通报批评类信息按类型统计</span></div>
		<table  class="table  table-bordered table-hover">
			<thead>
				<tr>
					<th style="text-align:center;">数据类型</th>
					<th style="text-align:center;">数据量</th>
				</tr>
			</thead>
			<tbody>
			[#list goodbads as obj]
			<tr>
			<td style="text-align:center;">${obj[0]}</td>
			<td style="text-align:center;">${obj[1]}</td>
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
		<div id="goodbad" class="col-xs-12" style="height:400px;padding:10px;">
	</div>
</div>
 
<script type="text/javascript">
var corp_lengend = ['数据量'];
$(function(){
	Basestat.createBar("goodbad",'表彰、通报批评类信息按类型统计','','数据量',corp_lengend,${xdata},${ydata});
});

</script>	 																								


[/@layout.main]