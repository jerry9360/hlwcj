[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['jwquery','infocheck'] otherjs=jss sername=['互联网采集数据','采集数据查询'] pagename='采集数据查询']

<div class="row">
	<div class="col-md-12">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box blue-madison">
			<div class="portlet-title">
				<div class="caption"><a style="color:white;" href="${base}/jw/jwdata/jwquery/list"  >采集数据查询</a></div>
			</div>
			<div class="portlet-body">
				<div class="dataTables_wrapper no-footer" id="sample_1_wrapper">
					<div class="table-scrollable">
						<table
							class="table table-striped table-bordered table-hover dataTable no-footer"
							id="sample_1" role="grid" aria-describedby="sample_1_info">
 							<tbody>
 							<tr> <td class="old" width="10%"; style="text-align:right;">标题</td><td>${jwdata.title}</td> </tr>
							<!-- 
							<tr> <td class="old" style="text-align:right;">发布时间</td><td>${(jwdata.issuetime?string('yyyy-MM-dd'))!}</td> </tr>
							<tr> <td class="old" style="text-align:right;">所属单位</td><td>${jwdata.unitname}</td> </tr>
							<tr> <td class="old" style="text-align:right;">网站类别  </td><td>
								[#if jwdata.sourcetype=='1']政府监管类
								[#elseif jwdata.sourcetype=='2']媒体评价类
								[#elseif jwdata.sourcetype=='3']其它
								[/#if]</td> 
							</tr>
							 -->
 							<tr> <td class="old" style="text-align:right;">来源网站 </td><td>${jwdata.source}</td> </tr>
  							<tr> <td class="old" style="text-align:right;">网页URL</td><td><a href=	"${jwdata.url}" target="_blank">${jwdata.url}</a></td> </tr>
 							<tr> <td class="old" style="text-align:right;">内容</td><td>${jwdata.content}</td> </tr>
    						<tr> <td class="old" style="text-align:right;">附件信息</td><td>${jwdata.attachment}</td> </tr>

						</tbody>
						</table>
					</div>
				</div>
			</div>
 		</div>
	</div>
</div>
[/@layout.main]
