[#import "common/layout.ftl" as layout] 
[#assign jss=[]] 
[@layout.main modelcode=['corpmediaexposed','infocheck'] otherjs=jss sername=['从业企业信用信息查询','媒体曝光信息查询'] pagename='媒体曝光信息查询']
		<form class="form-horizontal" role="form" id="formid" action="${base}/corp/corpmediaexposed" method="get">
			<table class="table-form">
				<tbody>
					<tr>
						<td style="width:10%;text-align:right;">企业名称</td>
						<td style="width:25%;"><input type="text" id="corp_name" name="corp_name" value="${corp_name }" class="form-control"></td>
						<td style="width:10%;text-align:right;">行业类别</td>
						<td style="width:25%;">
							<select class="bs-select form-control" id="industry"  name="industry">
								<option value="" [#if industry==""] selected[/#if]>全部</option>
								<option value="1" [#if industry=="1"] selected[/#if]>公路建设市场</option>
								<option value="2" [#if industry=="2"] selected[/#if]>水运建设市场</option>
 								<option value="4" [#if industry=="4"] selected[/#if]>道路运输市场</option>
							</select>
						</td>						<td style="width:30%;padding-left:20px;">
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
					<th style="width:12%;">行业类别</th>
					<th style="width:25%;">文章标题</th>
					<th style="width:20%;">来源网站</th>
					<th style="width:10%;">发布时间</th>
					<th style="width:8%;">操作</th>
				</tr>
			</thead>
			<tbody>
				[#list page.content as corpmediaexposed]
				<tr>
					<td  style="text-align:center;">${pageable.offset + corpmediaexposed_index+1}</td>
					<td  style="text-align:left;">${corpmediaexposed.corp_name}</td>
					<td>
						[#if corpmediaexposed.industry=='1']
							公路建设市场
						[#elseif corpmediaexposed.industry=='2']
							水运建设市场
						[#elseif corpmediaexposed.industry=='4']
							道路运输市场
						[/#if]
					</td>					
					<td>${corpmediaexposed.title }</td>
					<td>${corpmediaexposed.source }</td>
					<td>${corpmediaexposed.issuedate}</td>
 					<td><a  class="btn btn-xs btn-primary" href="${base}/corp/corpmediaexposed/detail/${corpmediaexposed.id}">查看</a></td>
				</tr>
				[/#list]
			</tbody>
		</table>
		[#assign pagepath="${base}/corp/corpmediaexposed?corp_name=${corp_name}&industry=${industry}&"]  
		[#include "common/pagemodel.ftl"]
<script>
 
</script>

[/@layout.main]