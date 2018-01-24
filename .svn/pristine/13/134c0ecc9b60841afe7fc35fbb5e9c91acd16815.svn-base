[#import "common/layout.ftl" as layout] 
[#assign jss=[]] 
[@layout.main modelcode=['wash_tender','infowash'] otherjs=jss sername=['数据清洗','招标信息'] pagename='招标信息']
		<form class="form-horizontal" role="form" id="formid" action="${base}/infowash/tender" method="get">
			<table class="table-form">
				<tbody>
					<tr>
						<td style="width:10%;text-align:right;">项目名称</td>
						<td style="width:25%;"><input type="text" id="project_name" name="project_name" value="${project_name}" class="form-control"></td>
						<td style="width:10%;text-align:right;">项目业主</td>
						<td style="width:25%;"><input type="text" id="zhaobiaore" name="zhaobiaore" value="${zhaobiaore}" class="form-control"></td>
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
					<th style="width:20%;">项目名称</th>
					<th style="width:12%;">项目编号</th>
					<th style="width:23%;">项目业主</th>
					<th style="width:18%;">来源网站</th>
					<th style="width:10%;">公告发布时间</th>
					<th style="width:12%;">操作</th>
				</tr>
			</thead>
			<tbody>
				[#list page.content as zhaobiaogg]
				<tr>
					<td  style="text-align:center;">${pageable.offset + zhaobiaogg_index+1}</td>
					<td  style="text-align:left;">${zhaobiaogg.project_name}</td>
					<td>${zhaobiaogg.project_code_cq}</td>
					<td>${zhaobiaogg.zhaobiaoren }</td>
					<td>${zhaobiaogg.web_name }</td>
					<td>${zhaobiaogg.gg_update}</td>
 					<td><a  class="btn btn-xs btn-primary" href="${base}/infowash/tender/${zhaobiaogg.zhaobiao_id}">处 理</a>
 					<button class="btn btn-xs btn-width btn-primary" type="button" onclick="upInfo('${zhaobiaogg.zhaobiao_id}','1');">采 信</button>
					<button class="btn btn-xs btn-width btn-primary" type="button" onclick="upInfo('${zhaobiaogg.zhaobiao_id}','2');">不采信</button>
 					</td>
				</tr>
				[/#list]
			</tbody>
		</table>
		[#assign pagepath="${base}/infowash/tender?project_name=${project_name}&zhaobiaore=${zhaobiaore}&"]  
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
				 window.location.href=base + "/infowash/tender/wash/"+id+"/"+state;
			 }
		}

</script>
[/@layout.main]