[#import "common/layout.ftl" as layout] 
[#assign jss=[]]
[#assign css=["assets/css/download.css","assets/css/zhemutanchukuang.css"]] 
[@layout.main modelcode=['fw_service' ]   otherjs=jss othercss=css sername=['数据服务','服务接口']  ]


[#include "serviceinterface/tanchu.ftl"]

<div style="float:left;margin-left:25px;margin-top: 5px;">
	接口名称
</div>
<div style="width:250px;float:left;margin-left:12px;">
	<input type="text" class="interface_name" name="interface_name" value= "${interface_name}" style="height:29px;width:200px;">
</div>


<button class="btn btn-sm btn-primary" type="button" style="float:left;margin-left:5px;" onclick="select()">查 询</button>



<table class="table table-bordered table-hover" style="margin-top:10px;">
			<thead>
				<tr>
					<th style="width:5%;text-align:center;">序号 </th>
					<th style="width:20%;text-align:center;">接口名称</th>
					<th style="width:30%;text-align:center;">访问地址</th>
					<th style="width:15%;text-align:center;">命名空间</th>
					<th style="width:10%;text-align:center;">方法名</th>
					<th style="width:10%;text-align:center;">参数名</th>
				    <th style="width:10%;text-align:center;">操作</th>
				</tr>
			</thead>
			<tbody>
			[#list serviceinterface as serviceinterface ]
				<tr>
				    <td style="text-align:center;">${serviceinterface_index+1}</td>
					<td style="text-align:center;">${serviceinterface.interface_name} </td>
					<td style="text-align:center;">${serviceinterface.visit_url}</td>
					<td style="text-align:center;">${serviceinterface.name_space}</td>
					<td style="text-align:center;">${serviceinterface.function_name}</td>
					<td style="text-align:center;">${serviceinterface.parameter_name}</td>
 					<td style="text-align:center;"><a  class="btn btn-xs btn-primary" href="${base}/servicemgr/list/detail/${serviceinterface.id}">详情</a></td>
									
				</tr>
			[/#list]
			
			</tbody>
</table>
		
		<script type="text/javascript">
		
	 function select(){
		 var ine=$(".interface_name").val();
		/*  alert(ine); */
		 location.href=base+'/servicemgr/list?interface_name='+ine;
		 
	 }
		
		
		</script>
 

[/@layout.main]