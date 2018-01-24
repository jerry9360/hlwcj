[#import "common/layout.ftl" as layout] 
[#assign jss=[]] 
[@layout.main modelcode=['orggoodinfo','infocheck'] otherjs=jss sername=['互联网采集数据查询','行业局良好信息'] pagename='行业局良好信息']
<div class="portlet box blue">
	<div class="portlet-title">
		<div class="caption">行业局</div>
	</div>
	<div class="portlet-body">
	<div class="table-responsive">
		<form class="form-horizontal" role="form" id="formid" action="${base}/org/orggoodinfo" method="get">
			<table class="table-form">
				<tbody>
					<tr>
						<td style="width:10%;text-align:right;">名称</td>
						<td style="width:20%;"><input type="text" id="orgname" name="orgname" value="${orgname }" class="form-control"></td>
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
					<th style="width:20%;">名称</th>
					<th style="width:12%;">类别</th>
					<th style="width:25%;">标题</th>
					<th style="width:20%;">来源网站</th>
					<th style="width:10%;">发布时间</th>
					<th style="width:8%;">操作</th>
				</tr>
			</thead>
			<tbody>
				[#list page.content as orggoodinfo]
				<tr>
					<td  style="text-align:center;">${pageable.offset + orggoodinfo_index+1}</td>
					<td  style="text-align:left;">${orggoodinfo.orgname}</td>
					<td>${orggoodinfo.type}</td>
					<td>${orggoodinfo.title }</td>
					<td>${orggoodinfo.source }</td>
					<td>${orggoodinfo.issuedate}</td>
 					<td><a  class="btn btn-xs btn-success" href="${base}/org/orggoodinfo/detail/${orggoodinfo.id}">查看</a></td>
				</tr>
				[/#list]
			</tbody>
		</table>
		[#assign pagepath="${base}/org/orggoodinfo?orgname=${orgname}&type=${type}&source=${source}&"]  
		[#include "common/pagemodel.ftl"]
	</div>
	</div>
</div>
<script>
 
</script>

[/@layout.main]