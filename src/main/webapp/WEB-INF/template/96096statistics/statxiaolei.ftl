[#import "common/layout.ftl" as layout] 
[#assign jss=["assets/js/date-time/bootstrap-timepicker.min.js","assets/js/echarts/echarts.js"]]
 [@layout.main modelcode=['hnii_stat_xiaolei','96096_data'] otherjs=jss sername=['96096工单数据按业务小类统计'] pagename='统计分析']
<!--  	<form class="form-horizontal" role="form" id="formid" action="${base}/corp/judgedoc" method="get">
			<table class="table-form" >
				<tbody>
					<tr>
					  <td style="width:10%;text-align:right;">业务大类</td>
						<td style="width:25%;">
							<select class="bs-select form-control" id="dalei"  name="industry" onchange="changeView(this)">
							<option value="" >请选择</option>
							 [#list roots  as root]
								<option value="${root.business_name}" >${root.business_name}</option>
							 [/#list]
							</select>
						</td>
						<td style="width:10%;text-align:right;"></td>
						<td style="width:25%;"></td>
						<td style="width:30%;padding-left:20px;">
						</td>
					</tr>
				</tbody>
			</table>
		</form> -->

[#list roots  as root]
<!--   <div  id="${root.business_name}" name="dalei" hidden="true"> -->
<div  class="table-responsive"  style="width:1688px;overflow-x: auto;">
   <div style="text-align: center;margin-top: 20px;"><span style="font-weight: 600;font-size: 18px;">96096工单数据按小类统计--${root.business_name}</span></div>
		<table  class="table  table-bordered table-hover"  >
			<thead>
				<tr>
					<th style="text-align:center;">类别</th>
					<th style="text-align:center;" rowspan="2">处理基数</th>
					[#list root.secondarys  as secondary]
					<th style="text-align:center;" colspan="2" >${secondary.business_name}</th>
					[/#list]
				</tr>
				<tr>
				    <th style="text-align:center;">年份</th>
				   [#list root.secondarys  as secondary]
					<th style="text-align:center;">数据量</th>
					<th style="text-align:center;">匹配率</th>
					[/#list]
				</tr>
			</thead>
			<tbody>
			[#list root.infos  as info]
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
		 </div>
[/#list]


<script type="text/javascript">
function changeView(e){
	var dalei=$(e).val();
	$("#"+dalei).attr("hidden",false);
	var divs=$("div[name='dalei']");
	for(i=0;i<divs.length;i++){
		if($(divs[i]).attr("id")!=dalei){
			$(divs[i]).attr("hidden",true);
		}
	}
}
</script>	 																								


[/@layout.main]