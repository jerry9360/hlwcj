[#import "common/layout.ftl" as layout] 
[#assign jss=["assets/js/date-time/bootstrap-datetimepicker.min.js"]] 
[#assign css=["assets/css/zhemutanchukuang.css","assets/css/datetimepicker.css"]]
[@layout.main modelcode=['hnii_analyze_key','infocheck'] otherjs=jss othercss=css sername=['数据查询','96096工单数据关键词查询'] pagename='96096工单数据']

[#macro sub info]
	[#if info?length>2000]
		${info[0..2000]}....
	[#else]
		${info}
	[/#if]
[/#macro]

[#macro sub2 info]
	[#if info?length>2000]
		${info[0..2000]}....
	[#else]
		${info}
	[/#if]
[/#macro]
[#include "common/loading.ftl"] 
<form class="form-horizontal" role="form" id="formid" action="${base}/hnii_analyze/hnii_analyze_datakey" method="get"  autocomplete="off">
	<table class="table-form">
		<tbody>
              <tr>
				<td style="width:10%;text-align:right;">业务</td>
				<td style="width:30%;">
				<select class="bs-select form-control" id="btype"  name="btype" onclick="changeView(this);">
				<option value="" >请选择</option>
				 [#list roots  as root]
					<option value="${root.business_name}" [#if btype=root.business_name]  selected="selected"   [/#if] >${root.business_name}</option>
				[/#list]
				</select>
  				<td style="width:10%;text-align:right;">关键词：</td>
				<td style="width:20%;"><input type="text" id="keyword" name="keyword" value="${keyword}" class="form-control">
				<td>多个词请用"*"连接</td>
				</td>
			<td style="width:20%;padding-left:10px;">
					<button class="btn btn-sm btn-primary" type="submit">查 询</button>
				</td>
			</tr>
			 
			 
		</tbody>
	</table>
</form>
<table  class="table  table-bordered table-hover">
	<thead>
		<tr> 
			<th style="width:5%;text-align:center;">序号 </th>
			<th style="width:10%;">工单流水号</th>
			<th style="width:15%;">业务类型</th>
			<th style="width:15%;">来电时间</th>
			<th style="width:40%;">工单内容</th>
			<th style="width:10%;">操作</th>
		</tr>
	</thead>
	<tbody>
		[#list page.content as per]
		<tr id="${per.id}">
			<td  style="text-align:center;">${pageable.offset + per_index+1}</td>
			<td>${per.myid}</td>
			<td>${per.btype}</td>
			<td name="object" >${per.calltime?string("yyyy-MM-dd HH:mm:ss") }</td>
			<td name="content" title="${per.content}">[@sub per.content][/@sub]</td>
			<td><a class="btn btn-xs btn-primary" href="${base}/hnii_analyze/hnii_analyze_data/${per.id}/show">查看</a>
			</td>
		</tr>
		[/#list]
	</tbody>
</table>

[#assign pagepath="${base}/hnii_analyze/hnii_analyze_datakey?btype=${btype}&keyword=${keyword}&"]  
[#include "common/pagemodel.ftl"]
 
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

 
     
	
 
</script>
[/@layout.main]