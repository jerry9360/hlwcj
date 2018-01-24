[#import "common/layout.ftl" as layout] 
[#assign jss=[]] 
[@layout.main modelcode=['corpgood_badinfo','infocheck'] otherjs=jss sername=['从业企业信用信息查询','表彰、通报批评查询'] pagename='表彰、通报批评查询']
		<form class="form-horizontal" role="form" id="formid" action="${base}/corp/corpgood_badinfo" method="get" autocomplete="off">
			<table class="table-form">
				<tbody>
					<tr>
						<td style="width:10%;text-align:right;">企业名称</td>
						<td style="width:20%;"><input type="text" id="corp_name" name="corp_name" value="${corp_name }" class="form-control"></td>
						<td style="width:10%;text-align:right;">类别</td>
						<td style="width:20%;"><input type="text" id="type" name="type" value="${type }" class="form-control"></td>
						<td style="width:10%;text-align:right;">来源网站</td>
						<td style="width:20%;"><input type="text" id="source" name="source" value="${source }" class="form-control"></td>
						<td style="width:10%;padding-left:20px;">
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
					<th style="width:20%;">企业名称</th>
					<th style="width:12%;">类别</th>
					<th style="width:25%;">标题</th>
					<th style="width:20%;">来源网站</th>
					<th style="width:10%;">发布时间</th>
					<th style="width:8%;">操作</th>
				</tr>
			</thead>
			<tbody>
				[#list page.content as corpgood_badinfo]
				<tr>
					<td  style="text-align:center;">${pageable.offset + corpgood_badinfo_index+1}</td>
					<td  style="text-align:left;">${corpgood_badinfo.corp_name}</td>
					<td>${corpgood_badinfo.type}</td>
					<td>${corpgood_badinfo.title }</td>
					<td>${corpgood_badinfo.source }</td>
					<td>${corpgood_badinfo.issuedate}</td>
 					<td><a  class="btn btn-xs btn-primary" href="${base}/corp/corpgood_badinfo/detail/${corpgood_badinfo.id}">查看</a></td>
				</tr>
				[/#list]
			</tbody>
		</table>
		[#assign pagepath="${base}/corp/corpgood_badinfo?corp_name=${corp_name}&type=${type}&source=${source}&"]  
		[#include "common/pagemodel.ftl"]
<script>
 
</script>

[/@layout.main]