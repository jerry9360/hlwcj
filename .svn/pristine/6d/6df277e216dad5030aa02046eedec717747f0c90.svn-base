[#import "common/layout.ftl" as layout] 
[#assign jss=[]] 
[@layout.main modelcode=['wash_servicecomplaint','infowash'] otherjs=jss sername=['数据清洗','服务质量投诉'] pagename='服务质量投诉']
		<form class="form-horizontal" role="form" id="formid" action="${base}/infowash/servicecomplaint" method="get">
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
					<th style="width:10%;">投诉时间</th>
					<th style="width:38%;">投诉内容</th>
					<th style="width:12%;">操作</th>
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
 					<td><a  class="btn btn-xs btn-primary" href="${base}/infowash/servicecomplaint/${complaint.id}">处 理</a>
 					<button class="btn btn-xs btn-width btn-primary" type="button" onclick="upInfo('${complaint.id}','1');">采 信</button>
					<button class="btn btn-xs btn-width btn-primary" type="button" onclick="upInfo('${complaint.id}','2');">不采信</button>
 					</td>
				</tr>
				[/#list]
			</tbody>
		</table>
		[#assign pagepath="${base}/infowash/servicecomplaint?corp_name=${corp_name}&vehicle_no=${vehicle_no}&"]  
		[#include "common/pagemodel.ftl"]
<script>
		function upInfo(id,state) {
			var message=null;
			if(state=='1'){
				message="确认采信该信息?";
			}else{
				message="确认不采信该信息?";
			}
			 if(confirm(message)) {
				 window.location.href=base + "/infowash/servicecomplaint/wash/"+id+"/"+state;
			 }
		}
</script>

[/@layout.main]