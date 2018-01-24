[#import "common/layout.ftl" as layout] 
[#assign jss=[]]
[#assign css=["assets/css/download.css","assets/css/zhemutanchukuang.css"]] 
[@layout.main modelcode=['datacategory','datastore'] otherjs=jss othercss=css sername=['数据存储','数据存储类别'] ]

[#include "datacategory/tanchu.ftl"]
<button class="btn btn-sm btn-primary" type="button" style="margin-top:2px;"   onclick="adddinfo()" >新 增</button>
 <a class="btn btn-sm btn-primary" data-toggle="modal" href="#large" id="open"  style="display:none;"> </a>
<table class="table table-bordered table-hover" style="margin-top:10px;">
			<thead>
				<tr>
					<th style="width:5%;text-align:center;">序号 </th>
					<th style="width:20%;text-align:center;">数据类别</th>
					<th style="width:50%;text-align:center;">元字段</th>
					<th style="width:15%;text-align:center;">存储位置</th>
					<th style="width:10%;text-align:center;">操作</th>
				</tr>
			</thead>
			<tbody>
			[#list datacategorylist as datacategory]
				<tr>
					<td style="text-align:center;">${datacategory_index+1}</td>
					<td style="text-align:center;">${datacategory.type}</td>
					<td style="text-align:left;">${datacategory.yuancolumn}</td>
					<td style="text-align:center;">${datacategory.datalocation}</td>
					<td style="text-align:center;">
					<a class="btn btn-xs btn-primary"  onclick="editform('${datacategory.id}')"   href="javascript:void(0)">编辑</a>
					<a class="btn btn-xs btn-danger"   onclick="deleteinfo('${datacategory.id}')"   href="javascript:void(0)" >删除</a>
					</td>			
				</tr>
			[/#list]
			
			</tbody>
		</table>
 
[/@layout.main]