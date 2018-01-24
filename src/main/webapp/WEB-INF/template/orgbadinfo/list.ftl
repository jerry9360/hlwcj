[#import "common/layout.ftl" as layout] 
[#assign jss=[]] 
[@layout.main modelcode=['orgbadinfo','infocheck'] otherjs=jss sername=['互联网采集数据查询','行业局不良信息'] pagename='行业局不良信息']
<div class="portlet box blue">
	<div class="portlet-title">
		<div class="caption">行业局</div>
	</div>
	<div class="portlet-body">
	<div class="table-responsive">
		<form class="form-horizontal" role="form" id="formid" action="${base}/org/orgbadinfo" method="get">
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
				[#list page.content as orgbadinfo]
				<tr>
					<td  style="text-align:center;">${pageable.offset + orgbadinfo_index+1}</td>
					<td  style="text-align:left;">${orgbadinfo.orgname}</td>
					<td>${orgbadinfo.type}</td>
					<td>${orgbadinfo.title }</td>
					<td>${orgbadinfo.source }</td>
					<td>${orgbadinfo.issuedate}</td>
 					<td><a  class="btn btn-xs btn-success" href="${base}/org/orgbadinfo/detail/${orgbadinfo.id}">查看</a></td>
				</tr>
				[/#list]
			</tbody>
		</table>
		[#assign pagepath="${base}/org/orgbadinfo?orgname=${orgname}&type=${type}&source=${source}&"]  
		[#include "common/pagemodel.ftl"]
	</div>
	</div>
</div>
<script>
 
</script>

[/@layout.main]