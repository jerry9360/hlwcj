[#import "common/layout.ftl" as layout] 
[#assign jss=[]]
[#assign css=["assets/css/download.css","assets/css/zhemutanchukuang.css"]] 
[@layout.main modelcode=['collectlist','datacollect'] otherjs=jss othercss=css sername=['数据采集','采集清单']  ]
[#include "collectlist/tanchu.ftl"]
<button class="btn btn-sm btn-primary" type="button" style="margin-top:2px;"   onclick="addinfo()" >新 增</button>
 <a class="btn btn-sm btn-primary" data-toggle="modal" href="#large" id="open"  style="display:none;"> </a>
<table class="table table-bordered table-hover" style="margin-top:10px;">
			<thead>
				<tr>
					<th style="width:5%;text-align:center;">序号 </th>
					<th style="width:20%;text-align:center;">业务类别</th>
					<th style="width:65%;text-align:center;">数据来源</th>
					<th style="width:10%;text-align:center;">操作</th>
				</tr>
			</thead>
			<tbody>
			[#list collectlist as collect ]
				<tr>
					<td style="text-align:center;">${collect_index+1}</td>
					<td style="text-align:left;">${collect.type}</td>
					<td style="text-align:left;">${collect.dataresource}</td>
 					<td style="text-align:center;">
					<a class="btn btn-xs btn-primary"  onclick="editform('${collect.id}')"   href="javascript:void(0)">编辑</a>
					<a class="btn btn-xs btn-danger"   onclick="deleteinfo('${collect.id}')"   href="javascript:void(0)" >删除</a>
					</td>			
				</tr>
			[/#list]
			
			</tbody>
		</table>
 

[/@layout.main]