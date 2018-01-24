[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['wash_servicecomplaint','infowash'] otherjs=jss sername=['数据清洗','服务质量投诉'] pagename='服务质量投诉']
		[#macro sub info]
	[#if info?length>65]
		${info[0..65]}....
	[#else]
		${info}
	[/#if]
	[/#macro]
						<table class="table table-bordered dataTable no-footer">
							<tbody>
								<tr>
									<td class="old" width="10%" style="text-align:right;">企业名称</td><td width="90%">${complaint.corp_name}</td>
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">车辆（挂车）号牌</td><td width="90%">${complaint.vehicle_no}</td>
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">投诉认姓名</td><td width="90%">${complaint.complainant_party}</td>								
								</tr>
																<tr>
									<td class="old" width="10%" style="text-align:right;">投诉方式</td><td width="90%">${complaint.event_type_name}</td>
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">投诉时间</td><td width="90%">${complaint.event_time}</td>								
								</tr>
																<tr>
									<td class="old" width="10%" style="text-align:right;">投诉内容</td><td width="90%">${complaint.event_content}</td>
								</tr>
								<tr>									
									<td class="old" width="10%" style="text-align:right;">受理机构</td><td width="90%">${complaint.accept_org}</td>								
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">核查处理情况</td><td width="90%">${complaint.feedback}</td>
								</tr>
								<tr>									
									<td class="old" width="10%" style="text-align:right;">被投诉人姓名</td><td width="90%">${complaint.respondent_person}</td>								
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">状态</td><td width="90%">[#if complaint.state=='0']待清洗[#elseif complaint.state=='1']采信[#else]不采信[/#if]</td>
								</tr>
							</tbody>
						</table>
						<div class="form-actions" style="text-align:center;margin-bottom:20px;">
							<button class="btn btn-xs btn-width btn-primary" type="button" onclick="upInfo('${complaint.id}','1');">采 信</button>
							<button class="btn btn-xs btn-width btn-primary" type="button" onclick="upInfo('${complaint.id}','2');">不采信</button>
							<button class="btn btn-xs btn-width btn-primary" type="button" onClick="history.go(-1)">取 消</button>
					</div>
	<script type="text/javascript">
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
