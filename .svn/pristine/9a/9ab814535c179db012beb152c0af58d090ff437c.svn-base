[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['pergoodinfo','infocheck']  otherjs=jss sername=['互联网采集数据','从业人员良好信息查询'] pagename='从业人员查询' ]
<div class="row">
	<div class="col-md-12">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box blue-madison">
			<div class="portlet-title">
				<div class="caption"><a style="color:white;" href="${base}/per/pergoodinfo"  >从业人员良好信息</a></div>
			</div>
			<div class="portlet-body">
				<div class="dataTables_wrapper no-footer" id="sample_1_wrapper">
						<table class="table table-bordered dataTable no-footer">
							<tbody>
								<tr>
								<td class="old" width="10%" style="text-align:right;">姓名</td><td width="90%">${pergoodinfo.name}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">类别</td><td>${pergoodinfo.type }</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">标题</td><td>${pergoodinfo.title}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">发布单位</td><td>${pergoodinfo.issueunit}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">发布时间</td><td> ${pergoodinfo.issuedate} </td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">来源网站</td><td>${pergoodinfo.source}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">网页URL</td><td><a href="${pergoodinfo.url}" target="_blank">${pergoodinfo.url}</a></td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">网页内容</td><td>${pergoodinfo.content}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">可信度</td>
								[#if pergoodinfo.credit=='0']	
								<td>可信度低</td>
								[#else]
								<td>可信度高</td>
								[/#if]
								</tr>
								<tr>
								<td class="old" style="text-align:right;">附件</td><td>${pergoodinfo.filename}</td>
								</tr>
							</tbody>
						</table>
				</div>
			</div>
			<!-- END EXAMPLE TABLE PORTLET-->
		</div>
	</div>
</div>
[/@layout.main]
