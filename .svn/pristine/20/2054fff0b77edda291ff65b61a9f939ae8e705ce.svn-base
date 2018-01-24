[#import "common/layout.ftl" as layout] 
[#assign jss=["assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"]] 
 [@layout.main modelcode=['hniiquery_${ctypecode}_${servicecode}','96096_${ctypecode}'] otherjs=jss sername=['96096${ctype}数据','${service}信息'] pagename='${service}信息查询']

[#macro sub info]
	[#if info?length>25]
		${info[0..25]}....
	[#else]
		${info}
	[/#if]
[/#macro]

[#macro sub2 info]
	[#if info?length>45]
		${info[0..45]}....
	[#else]
		${info}
	[/#if]
[/#macro]

		<form class="form-horizontal" role="form" id="formid" action="${base}/hnii/hniiservicedata/hniiquery/list/${ctypecode}/${servicecode}" method="get">
			<table class="table-form">
				<tbody>
 					<tr>
						<td style="width:5%;text-align:right;">小类</td>
						<td style="width:20%;">
						<select class="bs-select form-control"id="type"  name="type"  >
						<option value="" [#if type==""] selected[/#if]>全部</option>
						[#if ctypecode=="taxi"]
							[#if servicecode=="complaint"]
		 						<option value="拒载" [#if type=="拒载"] selected[/#if]>拒载</option>
								<option value="甩客" [#if type=="甩客"] selected[/#if]>甩客</option>		
								<option value="强打组合" [#if type=="强打组合"] selected[/#if]>强打组合</option>
								<option value="不开发票" [#if type=="不开发票"] selected[/#if]>不开发票</option>	 
								<option value="不使用计价器" [#if type=="不使用计价器"] selected[/#if]>不使用计价器</option>
								<option value="绕道" [#if type=="绕道"] selected[/#if]>绕道</option>
 								<option value="乱收费" [#if type=="乱收费"] selected[/#if]>乱收费</option>
								<option value="不文明服务" [#if type=="不文明服务"] selected[/#if]>不文明服务</option>
								<option value="危险驾驶" [#if type=="危险驾驶"] selected[/#if]>危险驾驶</option>
 								<option value="疲劳驾驶" [#if type=="疲劳驾驶"] selected[/#if]>疲劳驾驶</option>
								<option value="找补假钱" [#if type=="找补假钱"] selected[/#if]>找补假钱</option>
 							[#elseif  servicecode=="consult"]
								<option value="查投诉" [#if type=="查投诉"] selected[/#if]>查投诉</option>
								<option value="咨询价格" [#if type=="咨询价格"] selected[/#if]>咨询价格</option>
 								<option value="从业资格证" [#if type=="从业资格"] selected[/#if]>从业资格</option>
								<option value="电招出租车" [#if type=="电招出租车"] selected[/#if]>电招出租车</option> 
							[#elseif  servicecode=="reflect"]	
								<option value="移车" [#if type=="移车"] selected[/#if]>移车</option>
 								<option value="撞人撞物" [#if type=="撞人撞物"] selected[/#if]>撞人撞物</option>
								<option value="归还失物索取费用" [#if type=="归还失物索取费用"] selected[/#if]>归还失物索取费用</option> 	
							[#elseif  servicecode=="forhelp"]	
								<option value="寻物" [#if type=="寻物"] selected[/#if]>寻物</option>	
							[#elseif  servicecode=="praise"]	
								<option value="拾金不昧" [#if type=="拾金不昧"] selected[/#if]>拾金不昧</option>			
								<option value="热情服务" [#if type=="热情服务"] selected[/#if]>热情服务</option>							
							[/#if]	 
 						[#elseif ctypecode=="netcar"]
							[#if servicecode=="complaint"]
		 						<option value="拒载" [#if type=="拒载"] selected[/#if]>拒载</option>
								<option value="甩客" [#if type=="甩客"] selected[/#if]>甩客</option>		
								<option value="强打组合" [#if type=="强打组合"] selected[/#if]>强打组合</option>
 								<option value="绕道" [#if type=="绕道"] selected[/#if]>绕道</option>
 								<option value="乱收费" [#if type=="乱收费"] selected[/#if]>乱收费</option>
								<option value="不文明服务" [#if type=="不文明服务"] selected[/#if]>不文明服务</option>
 								<option value="非法营运" [#if type=="非法营运"] selected[/#if]>非法营运</option>
								<option value="驾驶员不一致" [#if type=="驾驶员不一致"] selected[/#if]>驾驶员不一致</option>
								<option value="危险驾驶" [#if type=="危险驾驶"] selected[/#if]>危险驾驶</option>
 								<option value="疲劳驾驶" [#if type=="疲劳驾驶"] selected[/#if]>疲劳驾驶</option>
								<option value="找补假钱" [#if type=="找补假钱"] selected[/#if]>找补假钱</option>		 					
							[/#if]	 
 						[/#if]	 
					</select>
						
						</td>
						<td style="width:10%;text-align:right;">车牌号</td>
						<td style="width:20%;"><input type="text" id="cnum" name="cnum" value="${cnum }" class="form-control"></td>
						<td style="width:10%;text-align:right;">受理单位</td>
						<td style="width:20%;"><input type="text" id="unit" name="unit" value="${unit }" class="form-control"></td>
    						<td style="width:15%;padding-left:20px;">
							<button class="btn btn-sm btn-primary" type="submit">查 询</button>
							
							 <a class="btn btn-sm btn-primary" onclick="export1(this);">导出Excel</a>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		[#if servicecode=="complaint"]
		<table  class="table  table-bordered table-hover">
			<thead>
				<tr>
					<th style="width:8%;text-align:center;">序号 </th>
 					<th style="width:12%;">小类</th>
					<th style="width:9%;">车牌号</th>
					<th style="width:9%;">事发起点</th>
					<th style="width:9%;">事发终点</th>
 					<th style="width:32%;">工单内容</th>
					<th style="width:16%;">事发时间</th>
  					<th style="width:5%;">操作</th>
				</tr>
			</thead>
			<tbody>
				[#list page.content as per]
				<tr id="${per.id}">
					<td  style="text-align:center;">${pageable.offset + per_index+1}</td>
 					<td>${per.type}</td>
 					<td name="cnum" >${per.cnum }</td>
 					<td name="baddress">${per.baddress }</td>
 					<td name="eaddress">${per.eaddress }</td>
 					<td name="content" title="${per.content}">[@sub per.content][/@sub]</td>
					<td>${(per.time?string('yyyy-MM-dd HH:mm:ss'))!}</td>
					<td><a class="btn btn-xs btn-primary" href="${base}/hnii/hniiservicedata/hniiquery/detail/${ctypecode}/${servicecode}/${per.id}">查看</a>
					<!-- <a class="btn btn-xs btn-info" data-toggle="modal" href="#large" onclick="edit(this,'${servicecode}')" >编辑</a> -->
					
					</td>
				</tr>
				[/#list]
			</tbody>
		</table>
		[#else]
			<table  class="table  table-bordered table-hover">
			<thead>
				<tr>
					<th style="width:8%;text-align:center;">序号 </th>
 					<th style="width:12%;">小类</th>
					<th style="width:15%;">车牌号</th>
					<th style="width:55%;">工单内容</th>
 					<th style="width:5%;">操作</th>
				</tr>
			</thead>
			<tbody>
				[#list page.content as per]
				<tr id="${per.id}">
					<td  style="text-align:center;">${pageable.offset + per_index+1}</td>
 					<td>[#if per.type=="从业资格证"]从业资格[#else]${per.type}[/#if]</td>
					<td name="cnum" >${per.cnum }</td>
 					<td name="content" title="${per.content}">[@sub2 per.content][/@sub2]</td>
					<td>
					<a class="btn btn-xs btn-primary" href="${base}/hnii/hniiservicedata/hniiquery/detail/${ctypecode}/${servicecode}/${per.id}">查看</a>
					<!-- <a class="btn btn-xs btn-info" data-toggle="modal" href="#large" onclick="edit(this)" >编辑</a> -->
					
					</td>
				</tr>
				[/#list]
			</tbody>
		</table>
		[/#if]
		
		
		[#assign pagepath="${base}/hnii/hniiservicedata/hniiquery/list/${ctypecode}/${servicecode}?type=${type}&unit=${unit}&cnum=${cnum}&"]  
		[#include "common/pagemodel.ftl"]
<input  type="hidden" id="servicecode"   value="${servicecode }">

<div class="modal fade bs-modal-lg in" id="large" tabindex="-1" role="dialog" data-backdrop="static" aria-hidden="false" style="display: none;">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-body">
				<div class="portlet box blue-madison ">
					<div class="portlet-title">
						<div class="caption">
							${ctype}${service}
						</div>
					</div>
					<div class="portlet-body form">
 							<table class="table-form">
								<tbody>
									<tr>
										<td style="width:20%;text-align:right;">车牌号</td>
										<td style="width:50%;"><input type="text" id="cnumm"   value="" class="form-control"></td>
										<td style="width:30%;"></td>
									</tr>
									[#if servicecode=="complaint"]
									<tr>
										<td style="width:20%;text-align:right;">事发起点</td>
										<td style="width:50%;"><input type="text" id="baddress"   value="" class="form-control"></td>
										<td style="width:30%;"></td>
									</tr>
									<tr>
										<td style="width:20%;text-align:right;">事发终点</td>
										<td style="width:50%;"><input type="text" id="eaddress"   value="" class="form-control"></td>
										<td style="width:30%;"></td>
									</tr>
									[/#if]
									<tr>
										<td style="width:20%;text-align:right;">内容</td>
										<td style="width:50%;" id="content"></td>
										<td style="width:30%;"></td>
									</tr>
								</tbody>
							</table>																									
							<div class="form-actions" style="text-align: center;">
								<button class="btn btn-width-70 btn-primary"  id="save" value=""  type="button" onclick="save();">保 存</button>
								<button id="close"  class="btn default" type="button" data-dismiss="modal">取消</button>
							</div>
 					</div>
				</div>
			</div>
		</div>
	</div>
</div>
 
<script>
function export1(ele){
	var type = $("#type").val();
	var ct = '${ctypecode}';
	var ser = '${servicecode}';
	var ctype = "";
	var service = "";
	if(ct=='taxi'){
		ctype = '出租车';
	}else if(ct=='netcar'){
		ctype = '网约车';
	}
	if(ser=='complaint'){
		service = '投诉';
	}else if(ser=='consult'){
		service = '咨询';
	}else if(ser=='reflect'){
		service = '反映情况';
	}else if(ser=='forhelp'){
		service = '求助';
	}else if(ser=='praise'){
		service = '表扬';
	}
	if(type==""){
		alert("请选择分类！")
		return;
	}
	$.ajax({
		type:"get",
		url:base+"/hnii/hniiservicedata/exportExcel",
		data:{
			ctype:ctype,
			service:service,
			type:type
		},
		dataType:"text",
		success:function(data){
			if(data=="FAIL"){
				alert("导出失败！");
			}
			if(data=="SUCCESS"){
				alert("导出成功！");
				
			}
		},
		error:function(){
		   alert("报告出错！");
		}
	});
}
$(function() {
  	initTime();
  	});
function initTime() {
	$(".form_datetime").datetimepicker({
		autoclose : true,
		format : "yyyy-MM-dd",
		minuteStep : 1,
		minView : 2,
		pickerPosition:'bottom-left',
		language : 'zh_CN'
	});
}

function edit(e){
	var servicecode=$("#servicecode").val();
	var tr=$(e).parent().parent();
	var id=$(tr).attr("id");
	var content=$(tr).find("td[name='content']").attr("title");
 	$("#content").text(content);
	$("#save").attr("value",id);
 	var cnum=$(tr).find("td[name='cnum']").text();
	$("#cnumm").val(cnum);
	if(servicecode=="complaint"){
 		var baddress=$(tr).find("td[name='baddress']").text();
		var eaddress=$(tr).find("td[name='eaddress']").text();
 		$("#baddress").val(baddress);
		$("#eaddress").val(eaddress);
 	}
 }


function save(){
	var servicecode=$("#servicecode").val();
  	var id=$("#save").attr("value");
 	var cnum=$("#cnumm").val();
 	var baddress="";
 	var eaddress="";
 	if(servicecode=="complaint"){
 	 	baddress=$("#baddress").val();
	 	eaddress=$("#eaddress").val();
	}
  	var data = {
  			cnum:cnum,
  			baddress:baddress,
  			eaddress:eaddress 
 	};
	$.ajax({
		type:"get",
		url:base+"/hnii/hniiservicedata/hniiquery/edit/"+servicecode+"/"+id ,
		data:data,
 		success:function(data){
			if(data=="SUCCESS"){
				var tr=$("#"+id);
				$(tr).find("td[name='cnum']").text(cnum);
				if(servicecode=="complaint"){
			 		$(tr).find("td[name='baddress']").text(baddress);
					$(tr).find("td[name='eaddress']").text(eaddress);
				}
				
				$("#close").click();
				$("#cnumm").val("");
				$("#content").text("");
				$("#save").attr("value","");
				if(servicecode=="complaint"){
			 		$("#baddress").val("");
					$("#eaddress").val("");
				}
				
			}else{
				alert("查无此信息");
			}
		},
		error:function(){
			 alert("数据加载失败");
		}
	});
}


</script>

[/@layout.main]