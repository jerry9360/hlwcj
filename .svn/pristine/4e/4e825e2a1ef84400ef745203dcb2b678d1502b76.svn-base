[#import "common/layout.ftl" as layout] 
[#assign jss=[]] 
[@layout.main modelcode=['fx_chepai' ]  otherjs=jss sername=['96096车牌投诉分析','涉及车牌统计排名'] pagename='96096投诉车牌分析']
<button class="btn btn-sm btn-primary" type="button" onclick="window.history.go(-1)">返 回</button>
<table class="table table-bordered dataTable no-footer">
	<thead>
		<tr>
			<th style="width:5%;text-align:center;">序号 </th>
			<th style="width:10%;text-align:center;">工单号</th>
			<th style="width:10%;text-align:center;">涉及车牌</th>
			<th style="width:10%;text-align:center;">发生时间</th>
			<th style="width:60%;text-align:center;">事件内容</th>
		</tr>
	</thead>
	<tbody>
		[#list page.content as detail]
		<tr id="${detail.id}">
			<td  style="text-align:center;">${pageable.offset +  detail_index+1}</td>
			<td>${detail.myid}</td>
			<td>${detail.carno}</td>
			<td>${detail.calltime}</td>
			<td >${detail.content}</a></td>
		</tr>
		[/#list] 
	
	</tbody>
</table>
[#assign pagepath="${base}/analyzemgr/complaintcarno/show?carno=${carno}&"]  
[#include "common/pagemodel.ftl"]
[/@layout.main]
