[#import "common/layout.ftl" as layout] 
[#assign jss=[]] 
[@layout.main modelcode=['jwquery','infocheck'] otherjs=jss sername=['互联网采集数据','采集数据查询'] pagename='采集数据查询']

[#macro sub info]
	[#if info?length>45]
		${info[0..45]}....
	[#else]
		${info}
	[/#if]
[/#macro]

<div class="portlet box blue">
	<div class="portlet-title">
		<div class="caption">采集数据</div>
	</div>
	<div class="portlet-body">
	<div class="table-responsive">
		<form class="form-horizontal" role="form" id="formid" action="${base}/jw/jwdata/jwquery/list" method="get">
			<table class="table-form">
				<tbody>
					<tr>
						<td style="width:10%;text-align:right;">标题</td>
						<td style="width:20%;"><input type="text" id="title" name="title" value="${title }" class="form-control"></td>
						<td style="width:10%;text-align:right;">来源网站</td>
						<td style="width:20%;"><input type="text" id="source" name="source" value="${source }" class="form-control"></td>
						<td style="width:40%;padding-left:20px;">
							<button class="btn btn-sm btn-primary" type="submit">查 询</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<table  class="table table-bordered table-hover">
			<thead>
				<tr>
 					<th style="width:5%;text-align:center;">序号 </th>
					<th style="width:35%;">标题</th>
 					<th style="width:20%;">来源网站</th>
					<th style="width:35%;">网页URL</th>
					<th style="width:5%;">操作</th>
				</tr>
			</thead>
			<tbody>
				[#list page.content as per]
				<tr>
					<td  style="text-align:center;">${pageable.offset + per_index+1}</td>
					<td  style="text-align:left;">${per.title}</td>
 					<td  style="text-align:left;">${per.source}</td>
					<td  style="text-align:left;"><a href=	"${per.url}" title="${per.url}" target="_blank">[@sub per.url][/@sub]</a></td>
					<td><a  class="btn btn-xs btn-success" href="${base}/jw/jwdata/jwquery/detail/${per.id}">查看</a></td>
				</tr>
				[/#list]
			</tbody>
		</table> 
		[#assign pagepath="${base}/jw/jwdata/jwquery/list?title=${title}&source=${source}&"]  
		[#include "common/pagemodel.ftl"]
	</div>
	</div>
</div>
<script>
 
</script>

[/@layout.main]