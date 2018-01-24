[#import "common/layout.ftl" as layout] 
[#assign jss=[]] 
[@layout.main  modelcode=['fx_corp' ]  otherjs=jss sername=['企业排名','企业相关信用信息'] pagename='信用信息']
<button class="btn btn-sm btn-primary" type="button" onclick="window.history.go(-1)">返 回</button>
<table class="table table-bordered dataTable no-footer">
	
	[#if  datatype = 'judgedoc']
	 <thead>
		<tr>
			<th style="width:5%;text-align:center;">序号 </th>
			<th style="width:40%;text-align:center;">文书标题</th>
			<th style="width:10%;text-align:center;">文书案号</th>
			<th style="width:10%;text-align:center;">发布日期</th>
			<th style="width:10%;text-align:center;">判决法院</th>
		</tr>
	</thead>
	<tbody>
		[#list page.content as judgedoc]
		<tr id="${judgedoc.id}">
			<td style="text-align:center;"><a href="${judgedoc.url}${judgedoc.filename}" target="_blank">${pageable.offset + judgedoc_index+1}</a></td>
			<td><a href="${judgedoc.url}${judgedoc.filename}" target="_blank">${judgedoc.hidcasename}</a></td>
			<td>${judgedoc.hidcasenumber}</td>
			<td>${judgedoc.releasetime}</td>
			<td >${judgedoc.hidcourt}</a></td>
		</tr>
		[/#list]
	</tbody>
	[/#if]
	
	[#if  datatype = 'dishonestman']
	 <thead>
		<tr>
			<th style="width:5%;text-align:center;">序号 </th>
			<th style="width:20%;text-align:center;">企业名称</th>
			<th style="width:10%;text-align:center;">企业法人名称</th>
			<th style="width:10%;text-align:center;">案号</th>
			<th style="width:20%;text-align:center;">发布日期</th>
		</tr>
	</thead>
	<tbody>
		[#list page.content as dishonestman]
		<tr id="${dishonestman.id}">
			<td  style="text-align:center;">${pageable.offset + dishonestman_index+1}</td>
			<td>${dishonestman.corp_name}</td>
			<td>${dishonestman.corporatename}</td>
			<td>${dishonestman.casenumber}</td>
			<td >${dishonestman.releasetime}</a></td>
		</tr>
		[/#list]
	</tbody>
	[/#if]
	
	[#if  datatype = 'biaozhang' || datatype = 'huojiang'  || datatype = 'tongbaopiping']
	 <thead>
		<tr>
			<th style="width:5%;text-align:center;">序号 </th>
			<th style="width:20%;text-align:center;">标题</th>
			<th style="width:10%;text-align:center;">来源网站</th>
			<th style="width:10%;text-align:center;">发布日期</th>
			<th style="width:20%;text-align:center;">源文链接</th>
		</tr>
	</thead>
	<tbody>
		[#list page.content as detail]
		<tr id="${ detail.id}">
			<td  style="text-align:center;">${pageable.offset +  detail_index+1}</td>
			<td>${detail.title}</td>
			<td>${detail.source}</td>
			<td>${detail.issuedate}</td>
			<td ><a href="${detail.url}" target="_blank">${detail.url}</a></td>
		</tr>
		[/#list]
	</tbody>
	[/#if]
	
	[#if  datatype = 'public_prise' || datatype = 'servicecomplaint'   ]
	 <thead>
		<tr>
			<th style="width:5%;text-align:center;">序号 </th>
			<th style="width:10%;text-align:center;">工单号</th>
			<th style="width:10%;text-align:center;">车牌号</th>
			<th style="width:10%;text-align:center;">发生时间</th>
			<th style="width:60%;text-align:center;">事件内容</th>
		</tr>
	</thead>
	<tbody>
	[#if  datatype = 'servicecomplaint']
		[#list page.content as detail]
		<tr id="${ detail.id}">
			<td  style="text-align:center;">${pageable.offset +  detail_index+1}</td>
			<td>${detail.accept_num}</td>
			<td>${detail.vehicle_no}</td>
			<td>${detail.event_time}</td>
			<td >${detail.event_content}</a></td>
		</tr>
		[/#list]
		[/#if]
		[#if  datatype = 'public_prise']
		[#list page.content as detail]
		<tr id="${ detail.id}">
			<td  style="text-align:center;">${pageable.offset +  detail_index+1}</td>
			<td>${detail.accept_num}</td>
			<td>${detail.carno}</td>
			<td>${detail.prisetime}</td>
			<td >${detail.name}</a></td>
		</tr>
		[/#list]
		[/#if]
	</tbody>
	[/#if]
	
	
	[#if   datatype = 'zhaobiao'  || datatype = 'zhongbiao' ]
	 <thead>
		<tr>
			<th style="width:5%;text-align:center;">序号 </th>
			<th style="width:20%;text-align:center;">项目名称</th>
			<th style="width:10%;text-align:center;">来源网站</th>
			<th style="width:10%;text-align:center;">发布日期</th>
			<th style="width:20%;text-align:center;">源文链接</th>
		</tr>
	</thead>
	<tbody>
		[#list page.content as project]
		[#if   datatype = 'zhaobiao' ]
		<tr id="${project.zhaobiao_id}">
		[/#if]
		[#if   datatype = 'zhongbiao' ]
		<tr id="${project.zhaobiao_id}">
		[/#if]
		
			<td  style="text-align:center;">${pageable.offset + project_index+1}</td>
			<td>${project.project_name}</td>
			<td>${project.web_name}</td>
			<td>${project.gg_update}</td>
			<td style="word-break:break-all;"><a href = "${project.url}" target="_blank">${project.url}</a></td>
		</tr>
		[/#list]
	</tbody>
	[/#if]
	
</table>
[#assign pagepath="${base}/analyzemgr/corporder/show?corpname=${corpname}&datatype=${datatype}&"]  
[#include "common/pagemodel.ftl"]
[/@layout.main]
