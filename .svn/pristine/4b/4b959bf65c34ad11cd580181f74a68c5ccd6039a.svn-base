[#import "common/layout.ftl" as layout] 
[#assign jss=[]] 
[@layout.main modelcode=['wash_mediaexposed','infowash'] otherjs=jss sername=['数据清洗','媒体曝光信息查询'] pagename='媒体曝光信息查询']
		<form class="form-horizontal" role="form" id="formid" action="${base}/infowash/mediaexposed" method="get">
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
					<th style="width:23%;">文章标题</th>
					<th style="width:18%;">来源网站</th>
					<th style="width:10%;">发布时间</th>
					<th style="width:12%;">操作</th>
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
 					<td><a  class="btn btn-xs btn-primary" href="${base}/infowash/mediaexposed/${corpmediaexposed.id}">处 理</a>
 					<button class="btn btn-xs btn-width btn-primary" type="button" onclick="upInfo('${corpmediaexposed.id}','1');">采 信</button>
					<button class="btn btn-xs btn-width btn-primary" type="button" onclick="upInfo('${corpmediaexposed.id}','2');">不采信</button>
 					</td>
				</tr>
				[/#list]
			</tbody>
		</table>
		[#assign pagepath="${base}/infowash/mediaexposed?corp_name=${corp_name}&industry=${industry}&"]  
		[#include "common/pagemodel.ftl"]
<script>
		function upInfo(id,state) {
			var message=null;
			if(state=='1'){
				message="确认采信该信息?";
			}else{
				message="确认不采信该信息?";
			}
			 if(confirm(message)) {
				 window.location.href=base + "/infowash/mediaexposed/wash/"+id+"/"+state;
			 }
		} 
</script>

[/@layout.main]