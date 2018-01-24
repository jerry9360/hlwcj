[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['perbadinfo','infocheck']  otherjs=jss sername=['互联网采集数据','从业人员不良信息查询'] pagename='从业人员查询' ]
<div class="row">
	<div class="col-md-12">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box blue-madison">
			<div class="portlet-title">
				<div class="caption"><a style="color:white;" href="${base}/per/perbadinfo"  >从业人员不良信息</a></div>
			</div>
			<div class="portlet-body">
						<table
							class="table table-bordered dataTable no-footer">
							<tbody>
								<tr>
								<td class="old" width="10%" style="text-align:right;">姓名</td><td width="90%">${perbadinfo.name}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">类别</td><td>${perbadinfo.type }</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">标题</td><td>${perbadinfo.title}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">发布单位</td><td>${perbadinfo.issueunit}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">发布时间</td><td>${perbadinfo.issuedate} </td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">来源网站</td><td>${perbadinfo.source}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">网页URL</td><td><a href="${perbadinfo.url}" target="_blank">${perbadinfo.url}</a></td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">网页内容</td><td>${perbadinfo.content}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">可信度</td>
								[#if perbadinfo.credit=='0']	
								<td>可信度低</td>
								[#else]
								<td>可信度高</td>
								[/#if]
								</tr>
								<tr>
								<td class="old" style="text-align:right;">附件</td><td>${perbadinfo.filename}</td>
								</tr>	
							</tbody>
						</table>
			</div>
			<!-- END EXAMPLE TABLE PORTLET-->
		</div>
	</div>
</div>
[/@layout.main]
