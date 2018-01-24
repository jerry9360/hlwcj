[#import "common/layout.ftl" as layout] 
[#assign jss=[]] 
[@layout.main modelcode=['publicprise','infocheck'] otherjs=jss sername=['从业企业信用信息查询','公众表扬'] pagename='公众表扬']
		<form class="form-horizontal" role="form" id="formid" action="${base}/corp/publicprise" method="get"  autocomplete="off">
			<table class="table-form">
				<tbody>
					<tr>
						<td style="width:10%;text-align:right;">企业名称</td>
						<td style="width:25%;"><input type="text" id="corp_name" name="corp_name" value="${corp_name}" class="form-control"></td>
						<td style="width:10%;text-align:right;">受理单号</td>
						<td style="width:25%;"><input type="text" id="accept_num" name="accept_num" value="${accept_num}" class="form-control"></td>
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
					<th style="width:20%;">企业名称</th>
					<th style="width:15%;">受理单号</th>
					<th style="width:12%;">表扬时间</th>
					<th style="width:40%;">表扬内容</th>
					<th style="width:8%;">操作</th>
				</tr>
			</thead>
			<tbody>
				[#list page.content as prise]
				<tr>
					<td  style="text-align:center;">${pageable.offset + prise_index+1}</td>
					<td  style="text-align:left;">${prise.corp_name}</td>
					<td>${prise.accept_num}</td>	
					<td>${prise.prisetime}</td>
					<td>${prise.name}</td>				
 					<td><a  class="btn btn-xs btn-primary" href="${base}/corp/publicprise/detail/${prise.id}">查看</a></td>
				</tr>
				[/#list]
			</tbody>
		</table>
		[#assign pagepath="${base}/corp/publicprise?corp_name=${corp_name}&accept_num=${accept_num}&"]  
		[#include "common/pagemodel.ftl"]
<script>
 
</script>

[/@layout.main]