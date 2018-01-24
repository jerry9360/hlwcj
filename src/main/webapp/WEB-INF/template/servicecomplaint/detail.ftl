[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['servicecomplaint','infocheck'] otherjs=jss sername=['从业企业信用信息查询','服务质量投诉'] pagename='服务质量投诉']
		[#macro sub info]
	[#if info?length>65]
		${info[0..65]}....
	[#else]
		${info}
	[/#if]
	[/#macro]
	<button class="btn btn-sm btn-primary" type="button" onclick="window.history.go(-1)">返 回</button>
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
[/@layout.main]
