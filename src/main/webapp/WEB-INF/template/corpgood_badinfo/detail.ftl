[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['corpgood_badinfo','infocheck'] otherjs=jss sername=['从业企业信用信息查询','表彰、通报批评查询'] pagename='表彰、通报批评查询']
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
								<td class="old" width="10%" style="text-align:right;">企业名称</td><td width="90%">${corpgood_badinfo.corp_name}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">类别</td><td>${corpgood_badinfo.type}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">标题</td><td>${corpgood_badinfo.title}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">发布单位</td><td>${corpgood_badinfo.issueunit}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">发布时间</td><td>${corpgood_badinfo.issuedate}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">来源网站</td><td>${corpgood_badinfo.source}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">网页URL</td><td><a href="${corpgood_badinfo.url}" target="_blank">${corpgood_badinfo.url}</a></td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">网页内容</td><td>${corpgood_badinfo.content}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">可信度</td>
								[#if corpgood_badinfo.credit=='0']	
								<td>可信度低</td>
								[#else]
								<td>可信度高</td>
								[/#if]
								</tr>
								<tr>
								<td class="old" style="text-align:right;">附件</td>
								<td>
									[#if corpgood_badinfo.files??]
										[#list corpgood_badinfo.files as f]
											<a href="${base}/common/file/load?filename=${f}" target="_blank" title="${f}">${f}</a><br/>
										[/#list]
									[/#if]
								</td>
								</tr>	
							</tbody>
						</table>
[/@layout.main]
