[#import "common/layout.ftl" as layout] 
[#assign jss=[]] 
[@layout.main modelcode=['credit_servicedata','creditdata'] otherjs=jss sername=['互联网采集数据','信用信息'] pagename='信用信息']
		<form class="form-horizontal" role="form" id="formid" action="${base}/solr/solrinfo/servicedatainfo" method="get">
			<table class="table-form">
				<tbody>
					<tr>
					<td style="width:40%;"><input type="text" placeholder="请输入关键字，多个关键字请用+号隔开" id="filed" name="filed" value="${field }" class="form-control"></td>
					<td style="width:60%;padding-left:20px;">
						<button class="btn btn-sm btn-primary" type="submit">查 询</button>
					</td>
					</tr>
				</tbody>
			</table>
		</form>
		<table  class="table  table-bordered table-hover">
			<thead>
				<tr>
					<th style="width:8%;text-align:center;">序号 </th>
					<th style="width:25%;">标题</th>
					<th style="width:15%;">业务标签</th>
					<th style="width:22%;">来源网站</th>
 					<th style="width:20%;">网页url</th>
					<th style="width:10%;">操作</th>
				</tr>
			</thead>
			<tbody>
				[#list page.content as servicedata]
				<tr>
					<td  style="text-align:center;">${pageable.offset +servicedata_index+1}</td>
					<td  style="text-align:left;">${servicedata.title}</td>
					<td>${servicedata.type }</td>
					<td>${servicedata.source }</td>
					<td>${servicedata.url }</td>
 					<td><a class="btn btn-xs btn-success" href="${base}/data/servicedata/detail/${servicedata.id}">查看</a></td>
				</tr>
				[/#list]
			</tbody>
		</table>
		[#assign pagepath="${base}/solr/solrinfo/servicedatainfo?"]  
		[#assign pageparams=[['field','${field}']]]
		[#include "common/pagemodel.ftl"]
[/@layout.main]