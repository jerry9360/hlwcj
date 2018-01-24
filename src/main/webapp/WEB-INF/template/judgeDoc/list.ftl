[#import "common/layout.ftl" as layout] 
[#assign jss=[]] 
[@layout.main modelcode=['judgedoc','infocheck'] otherjs=jss sername=['从业企业信用信息查询','司法判决信息'] pagename='司法判决信息']
		<form class="form-horizontal" role="form" id="formid" action="${base}/corp/judgedoc" method="get" autocomplete="off">
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
						</td>
						<td style="width:30%;padding-left:20px;">
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
					<th style="width:18%;">企业名称</th>
					<th style="width:8%;">行业类别</th>
					<th style="width:13%;">案号</th>
					<th style="width:10%;">发布日期</th>
					<th style="width:21%;">文书标题</th>				
					<th style="width:20%;">原告/被告</th>					
					<th style="width:10%;">操作</th>
				</tr>
			</thead>
			<tbody>
				[#list page.content as judgedoc]
				<tr>
					<td  style="text-align:center;">${pageable.offset + judgedoc_index+1}</td>
					<td  style="text-align:left;">${judgedoc.corp_name}</td>
					<td>
						[#if judgedoc.industry=='1']
							公路建设市场
						[#elseif judgedoc.industry=='2']
							水运建设市场
						[#elseif judgedoc.industry=='4']
							道路运输市场
						[/#if]
					</td>
					
					<td>${judgedoc.hidcasenumber }</td>
					<td>${judgedoc.releasetime}</td>
					<td>${judgedoc.hidcasename }</td>					
					<td>${judgedoc.casemantype}</td>
 					<td><a  class="btn btn-xs btn-primary" href="${base}/corp/judgedoc/detail/${judgedoc.id}">查看</a></td>
				</tr>
				[/#list]
			</tbody>
		</table>
		[#assign pagepath="${base}/corp/judgedoc?corp_name=${corp_name}&industry=${industry}&"]  
		[#include "common/pagemodel.ftl"]
<script>
 
</script>

[/@layout.main]