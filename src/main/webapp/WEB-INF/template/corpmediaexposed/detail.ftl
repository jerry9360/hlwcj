[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['corpmediaexposed','infocheck'] otherjs=jss sername=['从业企业信用信息查询','媒体曝光信息查询'] pagename='媒体曝光信息查询']
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
									<td class="old" width="10%" style="text-align:right;">企业名称</td><td width="90%">${corpmediaexposed.corp_name}</td>
								</tr>
								<tr>	
									<td class="old" width="10%" style="text-align:right;">行业类别</td>
									<td width="90%">
										[#if corpmediaexposed.industry=='1']
											公路建设市场
										[#elseif corpmediaexposed.industry=='2']
											水运建设市场
										[#elseif corpmediaexposed.industry=='4']
											道路运输市场
										[/#if]
									</td>
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">文章标题</td><td width="90%">${corpmediaexposed.title}</td>
								</tr>
								<tr>									
									<td class="old" width="10%" style="text-align:right;">业务类型</td><td width="90%">${corpmediaexposed.servicetype}</td>								
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">发布时间</td><td width="90%">${corpmediaexposed.issuedate}</td>
								</tr>
								<tr>									
									<td class="old" width="10%" style="text-align:right;">来源网站</td><td width="90%">${corpmediaexposed.source}</td>								
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">网站所属单位</td><td width="90%">${corpmediaexposed.pageunit}</td>
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">网址URL</td><td width="90%"><a href="${corpmediaexposed.url}" target="_blank">${corpmediaexposed.url}</a></td>								
								</tr>								
								<tr>
									<td class="old" width="10%" style="text-align:right;">文章内容</td><td>${corpmediaexposed.content}</td>
								</tr>
								<tr>
									<td class="old" style="text-align:right;">可信度</td>
									[#if corpmediaexposed.credit=='0']	
									<td>可信度低</td>
									[#else]
									<td>可信度高</td>
									[/#if]
								</tr>
								<tr>
									<td class="old" style="text-align:right;">附件</td>
									<td>
									[#if corpmediaexposed.files??]
										[#list corpmediaexposed.files as f]
											<a href="${base}/common/file/load?filename=${f}" target="_blank" title="${f}">${f}</a><br/>
										[/#list]
									[/#if]
									</td>
								</tr>	
							</tbody>
						</table>
[/@layout.main]
