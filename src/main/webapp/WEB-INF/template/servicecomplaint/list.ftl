[#import "common/layout.ftl" as layout] 
[#assign jss=[]] 
[@layout.main modelcode=['servicecomplaint','infocheck'] otherjs=jss sername=['从业企业信用信息查询','服务质量投诉'] pagename='服务质量投诉']
		<form class="form-horizontal" role="form" id="formid" action="${base}/corp/servicecomplaint" method="get">
			<table class="table-form">
				<tbody>
					<tr>
						<td style="width:10%;text-align:right;">企业名称</td>
						<td style="width:25%;"><input type="text" id="corp_name" name="corp_name" value="${corp_name}" class="form-control"></td>
						<td style="width:10%;text-align:right;">车辆（挂车）号牌</td>
						<td style="width:25%;"><input type="text" id="vehicle_no" name="vehicle_no" value="${vehicle_no}" class="form-control"></td>
						<td style="width:30%;padding-left:20px;">
							<button class="btn btn-sm btn-primary" type="submit">查 询</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<table  class="table table-bordered table-hover">
			<thead>
				<tr>
 				
					<th style="width:5%;text-align:center;">序号 </th>
					<th style="width:20%;">企业名称</th>
					<th style="width:15%;">车辆（挂车）号牌</th>
					<th style="width:12%;">投诉时间</th>
					<th style="width:40%;">投诉内容</th>
					<th style="width:8%;">操作</th>
				</tr>
			</thead>
			<tbody>
				[#list page.content as complaint]
				<tr>
					<td  style="text-align:center;">${pageable.offset + complaint_index+1}</td>
					<td  style="text-align:left;">${complaint.corp_name}</td>
					<td>${complaint.vehicle_no }</td>
					<td>${complaint.event_time }</td>
					<td>${complaint.event_content}</td>
 					<td><a  class="btn btn-xs btn-primary" href="${base}/corp/servicecomplaint/detail/${complaint.id}">查看</a></td>
				</tr>
				[/#list]
			</tbody>
		</table>
		[#assign pagepath="${base}/corp/servicecomplaint?corp_name=${corp_name}&vehicle_no=${vehicle_no}&"]  
		[#include "common/pagemodel.ftl"]
<script>
 
</script>

[/@layout.main]