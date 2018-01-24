[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['dishonestMan','infocheck'] otherjs=jss sername=['从业企业信用信息查询','失信被执行人'] pagename='失信被执行人']
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
									<td class="old" width="10%" style="text-align:right;">企业名称</td><td width="90%">${dishonestMan.corp_name}</td>
								</tr>
								 <tr>
									<td class="old" width="10%" style="text-align:right;">统一社会信用代码</td><td width="90%"></td>								
								</tr> 
								<tr>	
									<td class="old" width="10%" style="text-align:right;">行业类别</td>
									<td width="90%">
										[#if dishonestMan.industry=='1']
											公路建设市场
										[#elseif dishonestMan.industry=='2']
											水运建设市场
										[#elseif dishonestMan.industry=='4']
											道路运输市场
										[/#if]
									</td>								
								</tr>					
								<!-- <tr>
									<td class="old" width="10%" style="text-align:right;">业务类型</td><td width="90%">${dishonestMan.servicetype}</td>								
								</tr> -->
																<tr>
									<td class="old" width="10%" style="text-align:right;">数据类别</td><td width="90%">${dishonestMan.datatype}</td>
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">案号</td><td width="90%">${dishonestMan.casenumber}</td>								
								</tr>
																<tr>
									<td class="old" width="10%" style="text-align:right;">失信被执行人名称</td><td width="90%">${dishonestMan.name}</td>
								</tr>
								<tr>									
									<td class="old" width="10%" style="text-align:right;">企业法人姓名</td><td width="90%">${dishonestMan.corporatename}</td>								
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">执行法院</td><td width="90%">${dishonestMan.dealcourt}</td>
								</tr>
								<tr>									
									<td class="old" width="10%" style="text-align:right;">地域名称</td><td width="90%">${dishonestMan.region}</td>								
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">失信被执行依据文号</td><td width="90%">${dishonestMan.dealcasenumber}</td>
								</tr>
								<tr>									
									<td class="old" width="10%" style="text-align:right;">作出执行依据单位</td><td width="90%">${dishonestMan.dealunit}</td>								
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">法律生效文书确定的义务</td><td width="90%">${dishonestMan.lawduty}</td>
								</tr>
								<tr>									
									<td class="old" width="10%" style="text-align:right;">发布时间</td><td width="90%">${dishonestMan.releasetime}</td>								
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">立案时间</td><td width="90%">${dishonestMan.filingtime}</td>
								</tr>
								<tr>									
									<td class="old" width="10%" style="text-align:right;">来源网站</td><td width="90%">${dishonestMan.source}</td>								
								</tr>																								
								<tr>
									<td class="old" width="10%" style="text-align:right;">网站所属单位</td><td width="90%">${dishonestMan.pageunit}</td>
								</tr>
								<tr>									
									<td class="old" width="10%" style="text-align:right;">网址URL</td><td width="90%" target="_blank"><a href="${dishonestMan.url}">${dishonestMan.url}</a></td>								
								</tr>								
								<tr>
									<td class="old" style="text-align:right;">可信度</td>
									[#if dishonestMan.credit=='0']	
									<td>可信度低</td>
									[#else]
									<td>可信度高</td>
									[/#if]
								</tr>
									<tr>
									<td class="old" width="10%" style="text-align:right;">数据来源</td><td width="90%">${dishonestMan.datasource}</td>
								</tr>
								<tr>
									<td class="old" style="text-align:right;">附件</td>
									<td>
									[#if dishonestMan.files??]
										[#list dishonestMan.files as f]
											<a href="${base}/common/file/load?filename=${f}" target="_blank" title="${f}">${f}</a><br/>
										[/#list]
									[/#if]
									</td>
								</tr>	
							</tbody>
						</table>
[/@layout.main]
