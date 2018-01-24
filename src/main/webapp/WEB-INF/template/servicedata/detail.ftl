[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['credit_servicedata','creditdata']  otherjs=jss sername=['互联网采集数据','业务数据查询'] pagename='业务数据查询' ]

						<table
							class="table table-striped table-bordered table-hover dataTable no-footer"
							id="sample_1" role="grid" aria-describedby="sample_1_info">
 							<tbody>
 							<tr> <td class="old" width="10%"; style="text-align:right;">业务类型</td><td  width="90%">${servicedata.type}</td> </tr>
							<tr> <td class="old" style="text-align:right;">标题</td><td>${servicedata.title}</td> </tr>
							<!-- 
							<tr> <td class="old" style="text-align:right;">发布时间</td><td>${servicedata.issuedate}</td> </tr>
							<tr> <td class="old" style="text-align:right;">发布单位</td><td>${servicedata.issueunit}</td> </tr>
							
							<tr> <td class="old" style="text-align:right;">网站类别  </td><td>
								[#if servicedata.sourcetype=='1']政府监管类
								[#elseif servicedata.sourcetype=='2']媒体评价类
								[#elseif servicedata.sourcetype=='3']其它
								[/#if]</td> 
							</tr>
							 -->
 							<tr> <td class="old" style="text-align:right;">来源网站 </td><td>${servicedata.source}</td> </tr>
  							<tr> <td class="old" style="text-align:right;">网页URL</td><td><a href=	"${servicedata.url}" target="_blank">${servicedata.url}</a></td> </tr>
							<tr> <td class="old" style="text-align:right;">网页内容</td><td>${servicedata.content}</td> </tr>
   							<tr> <td class="old" style="text-align:right;">附件名称</td><td>${servicedata.filename}</td> </tr>

						</tbody>
						</table>
[/@layout.main]
