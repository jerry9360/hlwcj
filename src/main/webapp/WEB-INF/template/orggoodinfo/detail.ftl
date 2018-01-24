[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['orggoodinfo','infocheck'] otherjs=jss sername=['互联网采集数据查询','行业局良好信息'] pagename='行业局良好信息']
		[#macro sub info]
	[#if info?length>65]
		${info[0..65]}....
	[#else]
		${info}
	[/#if]
	[/#macro]
	<div class="col-md-12" style="padding-left:0px;padding-right:0px;">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box blue-madison">
			<div class="portlet-title">
				<div class="caption"><a style="color:white;" href="${base}/org/orggoodinfo">行业局良好信息</a></div>
			</div>
			<div class="portlet-body">
				<div class="dataTables_wrapper no-footer">
						<table class="table table-bordered dataTable no-footer">
							<tbody>
								<tr>
								<td class="old" width="10%" style="text-align:right;">名称</td><td width="90%">${orggoodinfo.orgname}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">类别</td><td>${orggoodinfo.type}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">标题</td><td>${orggoodinfo.title}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">发布单位</td><td>${orggoodinfo.issueunit}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">发布时间</td><td>${orggoodinfo.issuedate}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">来源网站</td><td>${orggoodinfo.source}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">网页URL</td><td><a href="${orggoodinfo.url}" target="_blank">${orggoodinfo.url}</a></td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">网页内容</td><td>${orggoodinfo.content}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">可信度</td>
								[#if orggoodinfo.credit=='0']	
								<td>可信度低</td>
								[#else]
								<td>可信度高</td>
								[/#if]
								</tr>
								<tr>
								<td class="old" style="text-align:right;">附件</td>
								<td>
									[#if orggoodinfo.files??]
										[#list orggoodinfo.files as f]
											<a href="${base}/common/file/load?filename=${f}" target="_blank" title="${f}">${f}</a><br/>
										[/#list]
									[/#if]
								</td>
								</tr>	
							</tbody>
						</table>
				</div>
			</div>
		</div>
	</div>
[/@layout.main]
