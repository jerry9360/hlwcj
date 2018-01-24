[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['orgbadinfo','infocheck'] otherjs=jss sername=['互联网采集数据查询','行业局不良信息'] pagename='行业局不良信息']
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
				<div class="caption"><a style="color:white;" href="${base}/org/orgbadinfo">行业局不良信息</a></div>
			</div>
			<div class="portlet-body">
				<div class="dataTables_wrapper no-footer">
						<table class="table table-bordered dataTable no-footer">
							<tbody>
								<tr>
								<td class="old" width="10%" style="text-align:right;">名称</td><td width="90%">${orgbadinfo.orgname}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">类别</td><td>${orgbadinfo.type}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">标题</td><td>${orgbadinfo.title}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">发布单位</td><td>${orgbadinfo.issueunit}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">发布时间</td><td>${orgbadinfo.issuedate}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">来源网站</td><td>${orgbadinfo.source}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">网页URL</td><td><a href="${orgbadinfo.url}" target="_blank">${orgbadinfo.url}</a></td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">网页内容</td><td>${orgbadinfo.content}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">可信度</td>
								[#if orgbadinfo.credit=='0']	
								<td>可信度低</td>
								[#else]
								<td>可信度高</td>
								[/#if]
								</tr>
								<tr>
								<td class="old" style="text-align:right;">附件</td>
								<td>
									[#if orgbadinfo.files??]
										[#list orgbadinfo.files as f]
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
