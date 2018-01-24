[#import "common/layout.ftl" as layout] 
[#assign jss=["assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"]] 
 [@layout.main modelcode=['hniiquery_label_${servicecode}','96096_label'] otherjs=jss sername=['96096标注数据','${service}信息'] pagename='${service}信息查询']

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

		<form class="form-horizontal" role="form" id="formid" action="${base}/hnii/hniilabeldata/hniiquery/list/${servicecode}" method="get">
			<table class="table-form">
				<tbody>
 					<tr>
 					<td style="width:5%;text-align:right;">小类</td>
						<td style="width:20%;">
						<select class="bs-select form-control" id="type"  name="type"  >
						<option value="" [#if type==""] selected[/#if]>全部</option>
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
								<option value="吃拿卡要" [#if type=="吃拿卡要"] selected[/#if]>吃拿卡要</option>
								<option value="不安排学习考试" [#if type=="不安排学习考试"] selected[/#if]>不安排学习考试</option>
								<option value="不按规定线路行驶" [#if type=="不按规定线路行驶"] selected[/#if]>不按规定线路行驶</option>
								<option value="不按规定站点停靠" [#if type=="不按规定站点停靠"] selected[/#if]>不按规定站点停靠</option>
								<option value="站外上客" [#if type=="站外上客"] selected[/#if]>站外上客</option>
								<option value="转客" [#if type=="转客"] selected[/#if]>转客</option>
								<option value="搭售保险" [#if type=="搭售保险"] selected[/#if]>搭售保险</option>
								<option value="儿童收全票" [#if type=="儿童收全票"] selected[/#if]>儿童收全票</option>
								<option value="提前发车" [#if type=="提前发车"] selected[/#if]>提前发车</option>
								<option value="晚点" [#if type=="晚点"] selected[/#if]>晚点</option>
								<option value="票据问题" [#if type=="票据问题"] selected[/#if]>票据问题</option>
								<option value="非法营运" [#if type=="非法营运"] selected[/#if]>非法营运</option>
								<option value="服务态度差" [#if type=="服务态度差"] selected[/#if]>服务态度差</option>
								<option value="安检" [#if type=="安检"] selected[/#if]>安检</option>
								<option value="噪声扰民" [#if type=="噪声扰民"] selected[/#if]>噪声扰民</option>
								<option value="久等无车" [#if type=="久等无车"] selected[/#if]>久等无车</option>
							    <option value="不按时发车" [#if type=="不按时发车"] selected[/#if]>不按时发车</option>
							    <option value="不按站点停靠" [#if type=="不按站点停靠"] selected[/#if]>不按站点停靠</option>
 							[#elseif  servicecode=="ask"]
								<option value="查投诉" [#if type=="查投诉"] selected[/#if]>查投诉</option>
								<option value="咨询价格" [#if type=="咨询价格"] selected[/#if]>咨询价格</option>
 								<option value="从业资格证" [#if type=="从业资格"] selected[/#if]>从业资格</option>
								<option value="电招出租车" [#if type=="电招出租车"] selected[/#if]>电招出租车</option> 
								<option value="网约车政策" [#if type=="网约车政策"] selected[/#if]>网约车政策</option> 
								<option value="手续办理" [#if type=="手续办理"] selected[/#if]>手续办理</option> 
								<option value="退费" [#if type=="退费"] selected[/#if]>退费</option> 
								<option value="驾校电话" [#if type=="驾校电话"] selected[/#if]>驾校电话</option> 
								<option value="预约考试" [#if type=="预约考试"] selected[/#if]>预约考试</option> 
								<option value="考试科目" [#if type=="考试科目"] selected[/#if]>考试科目</option> 
								<option value="驾校事宜" [#if type=="驾校事宜"] selected[/#if]>驾校事宜</option> 
								<option value="收费事宜" [#if type=="收费事宜"] selected[/#if]>收费事宜</option> 
								<option value="班次信息" [#if type=="班次信息"] selected[/#if]>班次信息</option> 
								<option value="班车发车时间" [#if type=="班车发车时间"] selected[/#if]>班车发车时间</option> 
								<option value="班车票价" [#if type=="班车票价"] selected[/#if]>班车票价</option> 
								<option value="班车线路" [#if type=="班车线路"] selected[/#if]>班车线路</option> 
								<option value="车站服务电话" [#if type=="车站服务电话"] selected[/#if]>车站服务电话</option> 
								<option value="车站位置" [#if type=="车站位置"] selected[/#if]>车站位置</option>
								<option value="包车业务" [#if type=="包车业务"] selected[/#if]>包车业务</option> 
								<option value="资格证事宜" [#if type=="资格证事宜"] selected[/#if]>资格证事宜</option> 
								<option value="学习考试事宜" [#if type=="学习考试事宜"] selected[/#if]>学习考试事宜</option> 
								<option value="资格证办理注销" [#if type=="资格证办理注销"] selected[/#if]>资格证办理注销</option> 
								<option value="货运站电话" [#if type=="货运站电话"] selected[/#if]>货运站电话</option> 
								<option value="资格证年审" [#if type=="资格证年审"] selected[/#if]>资格证年审</option> 
								<option value="查询成绩" [#if type=="查询成绩"] selected[/#if]>查询成绩</option> 
								<option value="资格证更换" [#if type=="资格证更换"] selected[/#if]>资格证更换</option> 
								<option value="IC卡" [#if type=="IC卡"] selected[/#if]>IC卡</option> 
								<option value="乘车规定" [#if type=="乘车规定"] selected[/#if]>乘车规定</option> 
								<option value="线路" [#if type=="线路"] selected[/#if]>线路</option> 
								<option value="站点" [#if type=="站点"] selected[/#if]>站点</option> 
								<option value="广播声音调整" [#if type=="广播声音调整"] selected[/#if]>广播声音调整</option> 
								<option value="空调调整" [#if type=="空调调整"] selected[/#if]>空调调整</option> 
								<option value="班次时间调整" [#if type=="班次时间调整"] selected[/#if]>班次时间调整</option> 
								<option value="车辆挂靠" [#if type=="车辆挂靠"] selected[/#if]>车辆挂靠</option> 
								<option value="码头位置" [#if type=="码头位置"] selected[/#if]>码头位置</option> 
								<option value="道路养护" [#if type=="道路养护"] selected[/#if]>道路养护</option> 
							[#elseif  servicecode=="suggest"]	
								<option value="线路调整" [#if type=="线路调整"] selected[/#if]>线路调整</option>
 								<option value="站点调整" [#if type=="站点调整"] selected[/#if]>站点调整</option>
								<option value="时间班次调整" [#if type=="时间班次调整"] selected[/#if]>时间班次调整</option> 	
							[#elseif  servicecode=="prise"]	
								<option value="拾金不昧" [#if type=="拾金不昧"] selected[/#if]>拾金不昧</option>			
								<option value="热情服务" [#if type=="热情服务"] selected[/#if]>热情服务</option>							
							[/#if]	 
					</select>
						
						</td>
 					    <td style="width:5%;text-align:right;">行业</td>
 					    <td style="width:20%;">
						<select class="bs-select form-control"id="industry"  name="industry" onchange="changeIndustry(this);" >
							[#if servicecode=="complaint"]
								<option value="" [#if type==""] selected[/#if]>全部</option>
								<option value="出租车行业" [#if industry=="出租车行业"] selected[/#if]>出租车行业</option>
								<option value="网约车行业" [#if industry=="网约车行业"] selected[/#if]>网约车行业</option>
								<option value="驾培行业" [#if industry=="驾培行业"] selected[/#if]>驾培行业</option>
								<option value="道路旅客行业" [#if industry=="道路旅客行业"] selected[/#if]>道路旅客行业</option>
								<option value="道路货运行业" [#if industry=="道路货运行业"] selected[/#if]>道路货运行业</option>
								<option value="公交车行业" [#if industry=="公交车行业"] selected[/#if]>公交车行业</option>
								<option value="轨道交通行业" [#if industry=="轨道交通行业"] selected[/#if]>轨道交通行业</option>
								<option value="水运作业" [#if industry=="水运作业"] selected[/#if]>水运作业</option>
 							[#elseif  servicecode=="ask"]
								<option value="" [#if type==""] selected[/#if]>全部</option>
								<option value="出租车行业" [#if industry=="出租车行业"] selected[/#if]>出租车行业</option>
								<option value="网约车行业" [#if industry=="网约车行业"] selected[/#if]>网约车行业</option>
								<option value="驾培行业" [#if industry=="驾培行业"] selected[/#if]>驾培行业</option>
								<option value="道路旅客行业" [#if industry=="道路旅客行业"] selected[/#if]>道路旅客行业</option>
								<option value="道路货运行业" [#if industry=="道路货运行业"] selected[/#if]>道路货运行业</option>
								<option value="公交车行业" [#if industry=="公交车行业"] selected[/#if]>公交车行业</option>
								<option value="轨道交通行业" [#if industry=="轨道交通行业"] selected[/#if]>轨道交通行业</option>
								<option value="汽车租赁行业" [#if industry=="汽车租赁行业"] selected[/#if]>汽车租赁行业</option>
								<option value="水运旅客运输行业" [#if industry=="水运旅客运输行业"] selected[/#if]>水运旅客运输行业</option>
								<option value="公路建设行业" [#if industry=="公路建设行业"] selected[/#if]>公路建设行业</option>
							[#elseif  servicecode=="suggest"]	
								<option value="" [#if type==""] selected[/#if]>全部</option>
								<option value="公交车行业" [#if industry=="公交车行业"] selected[/#if]>公交车行业</option>
							[#elseif  servicecode=="prise"]	
								<option value="" [#if type==""] selected[/#if]>全部</option>
								<option value="出租车行业" [#if industry=="出租车行业"] selected[/#if]>出租车行业</option>
								<option value="公交车行业" [#if industry=="公交车行业"] selected[/#if]>公交车行业</option>
								<option value="轨道交通行业" [#if industry=="轨道交通行业"] selected[/#if]>轨道交通行业</option>
							[/#if]							
						</select>
						</td>
						
						<td style="width:10%;text-align:right;">工单内容</td>
						<td style="width:20%;"><input type="text" id="content" name="content" value="${content }" class="form-control"></td>
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
					<th style="width:5%;text-align:center;">序号 </th>
 					<th style="width:10%;">小类</th>
 					<th style="width:10%;">行业类别</th>
					<th style="width:10%;">主体对象</th>
					<th style="width:8%;">事发起点</th>
					<th style="width:8%;">事发终点</th>
					<th style="width:10%;">事发时间</th>
					<th style="width:10%;">车牌号</th>
 					<th style="width:24%;">工单内容</th>
  					<th style="width:5%;">操作</th>
				</tr>
			</thead>
			<tbody>
				[#list page.content as per]
				<tr id="${per.id}">
					<td  style="text-align:center;">${pageable.offset + per_index+1}</td>
 					<td>${per.servicetype}</td>
 					<td name="industry" >${per.industry }</td>
					<td name="object" >${per.object }</td>
 					<td name="baddress">${per.baddress }</td>
 					<td name="eaddress">${per.eaddress }</td>
 					<td>${per.time}</td>
 					<td>${per.carno}</td>
 					<td name="content" title="${per.content}">[@sub per.content][/@sub]</td>
					<td><a class="btn btn-xs btn-primary" href="${base}/hnii/hniilabeldata/hniiquery/detail/${servicecode}/${per.id}">查看</a>
					<!-- <a class="btn btn-xs btn-info" data-toggle="modal" href="#large" onclick="edit(this,'${servicecode}')" >编辑</a> -->
					
					</td>
				</tr>
				[/#list]
			</tbody>
		</table>
		[#elseif servicecode=="prise"]
		   <table  class="table  table-bordered table-hover">
			<thead>
				<tr>
					<th style="width:5%;text-align:center;">序号 </th>
 					<th style="width:11%;">小类</th>
 					<th style="width:12%;">行业类别</th>
					<th style="width:12%;">主体对象</th>
 					<th style="width:11%;">事发时间</th>
					<th style="width:10%;">车牌号</th>
 					<th style="width:32%;">工单内容</th>
  					<th style="width:7%;">操作</th>
				</tr>
			</thead>
			<tbody>
				[#list page.content as per]
				<tr id="${per.id}">
					<td  style="text-align:center;">${pageable.offset + per_index+1}</td>
 					<td>${per.servicetype}</td>
 					<td name="industry" >${per.industry }</td>
					<td name="object" >${per.object }</td>
					<td>${per.time}</td>
 					<td>${per.carno}</td>
					<td name="content" title="${per.content}">[@sub per.content][/@sub]</td>
					<td><a class="btn btn-xs btn-primary" href="${base}/hnii/hniilabeldata/hniiquery/detail/${servicecode}/${per.id}">查看</a>
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
					<th style="width:5%;text-align:center;">序号 </th>
 					<th style="width:18%;">小类</th>
 					<th style="width:17%;">行业类别</th>
					<th style="width:10%;">车牌号</th>
					<th style="width:40%;">工单内容</th>
 					<th style="width:10%;">操作</th>
				</tr>
			</thead>
			<tbody>
				[#list page.content as per]
				<tr id="${per.id}">
					<td  style="text-align:center;">${pageable.offset + per_index+1}</td>
 					<td>${per.servicetype}</td>
 					<td name="industry" >${per.industry }</td>
					<td>${per.carno}</td>
 					<td name="content" title="${per.content}">[@sub2 per.content][/@sub2]</td>
					<td>
					<a class="btn btn-xs btn-primary" href="${base}/hnii/hniilabeldata/hniiquery/detail/${servicecode}/${per.id}">查看</a>
					<!-- <a class="btn btn-xs btn-info" data-toggle="modal" href="#large" onclick="edit(this)" >编辑</a> -->
					
					</td>
				</tr>
				[/#list]
			</tbody>
		</table>
		[/#if]
		
		
		[#assign pagepath="${base}/hnii/hniilabeldata/hniiquery/list/${servicecode}?type=${type}&unit=${unit}&myid=${myid}&"]  
		[#include "common/pagemodel.ftl"]
<input  type="hidden" id="servicecode"   value="${servicecode }">

<div class="modal fade bs-modal-lg in" id="large" tabindex="-1" role="dialog" data-backdrop="static" aria-hidden="false" style="display: none;">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-body">
				<div class="portlet box blue-madison ">
					<div class="portlet-title">
						<div class="caption">
							${service}
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
	function changeIndustry(obj){
		var industry=$(obj).val();
		var servicecode='${servicecode}';
		if(industry=="出租车行业"){
			$("#type").html("");
			if (servicecode=="complaint"){
				$("#type").append("<option value=\"\">全部</option>")
						  .append("<option value=\"拒载\">拒载</option>")
						  .append("<option value=\"强打组合\">强打组合</option>")
						  .append("<option value=\"甩客\">甩客</option>")
						  .append("<option value=\"不开发票\">不开发票</option>")
						  .append("<option value=\"不使用计价器\">不使用计价器</option>")
						  .append("<option value=\"绕道\">绕道</option>")
						  .append("<option value=\"乱收费\">乱收费</option>")
						  .append("<option value=\"不文明服务\">不文明服务</option>")
						  .append("<option value=\"危险驾驶\">危险驾驶</option>")
						  .append("<option value=\"找补假钱\">找补假钱</option>")
			}else if(servicecode=="ask"){
				$("#type").append("<option value=\"\">全部</option>")
				  .append("<option value=\"查投诉\">查投诉</option>")
				  .append("<option value=\"咨询价格\">咨询价格</option>")
				  .append("<option value=\"从业资格\">从业资格</option>")
				  .append("<option value=\"电招出租车\">电招出租车</option>")
			}else if(servicecode=="suggest"){
				$("#type").append("<option value=\"\">全部</option>")

			}else if(servicecode=="prise"){
				$("#type").append("<option value=\"\">全部</option>")
				  .append("<option value=\"拾金不昧\">拾金不昧</option>")
				  .append("<option value=\"热情服务\">热情服务</option>")
			}			  
		}else if(industry=="网约车行业"){
			$("#type").html("");
			if (servicecode=="complaint"){
			$("#type").append("<option value=\"\">全部</option>")
					  .append("<option value=\"拒载\">拒载</option>")
					  .append("<option value=\"强打组合\">强打组合</option>")
					  .append("<option value=\"甩客\">甩客</option>")
					  .append("<option value=\"绕道\">绕道</option>")
					  .append("<option value=\"乱收费\">乱收费</option>")
					  .append("<option value=\"不文明服务\">不文明服务</option>")
			}else if(servicecode=="ask"){
				$("#type").append("<option value=\"\">全部</option>")
				  .append("<option value=\"网约车政策\">网约车政策</option>")
				  .append("<option value=\"从业资格\">从业资格</option>")
				  .append("<option value=\"手续办理\">手续办理</option>")
			}else if(servicecode=="suggest"){
				$("#type").append("<option value=\"\">全部</option>")
			}else if(servicecode=="prise"){
				$("#type").append("<option value=\"\">全部</option>")
			}			  
		}else if(industry=="驾培行业"){
			$("#type").html("");
			if (servicecode=="complaint"){
			$("#type").append("<option value=\"\">全部</option>")
					  .append("<option value=\"乱收费\">乱收费</option>")
					  .append("<option value=\"服务态度差\">服务态度差</option>")
					  .append("<option value=\"吃拿卡要\">吃拿卡要</option>")
					  .append("<option value=\"不安排学习考试\">不安排学习考试</option>")
			}else if(servicecode=="ask"){
				$("#type").append("<option value=\"\">全部</option>")
				  .append("<option value=\"退费\">退费</option>")
				  .append("<option value=\"驾校电话\">驾校电话</option>")
				  .append("<option value=\"预约考试\">预约考试</option>")
				  .append("<option value=\"考试科目\">考试科目</option>")
				  .append("<option value=\"驾校事宜\">驾校事宜</option>")
				  .append("<option value=\"收费事宜\">收费事宜</option>")

			}else if(servicecode=="suggest"){
				$("#type").append("<option value=\"\">全部</option>")
			}else if(servicecode=="prise"){
				$("#type").append("<option value=\"\">全部</option>")
			}	  
		}else if(industry=="道路旅客行业"){
			$("#type").html("");
			if (servicecode=="complaint"){
			$("#type").append("<option value=\"\">全部</option>")
					  .append("<option value=\"不按规定线路行驶\">不按规定线路行驶</option>")
					  .append("<option value=\"不按规定站点停靠\">不按规定站点停靠</option>")
					  .append("<option value=\"乱收费\">乱收费</option>")
					  .append("<option value=\"不文明服务\">不文明服务</option>")
					  .append("<option value=\"超载\">超载</option>")
					  .append("<option value=\"甩客\">甩客</option>")
					  .append("<option value=\"站外上客\">站外上客</option>")	
					  .append("<option value=\"转客\">转客</option>")			
					  .append("<option value=\"危险驾驶\">危险驾驶</option>")			
					  .append("<option value=\"拒载\">拒载</option>")			
					  .append("<option value=\"搭售保险\">搭售保险</option>")			
					  .append("<option value=\"儿童收全票\">儿童收全票</option>")			
					  .append("<option value=\"疲劳驾驶\">疲劳驾驶</option>")			
					  .append("<option value=\"提前发车\">提前发车</option>")			
					  .append("<option value=\"晚点\">晚点</option>")
					  .append("<option value=\"票据问题\">票据问题</option>")
			}else if(servicecode=="ask"){
				$("#type").append("<option value=\"\">全部</option>")
				  .append("<option value=\"班次信息\">班次信息</option>")
				  .append("<option value=\"班车发车时间\">班车发车时间</option>")
				  .append("<option value=\"班车票价\">班车票价</option>")
				  .append("<option value=\"班车线路\">班车线路</option>")
				  .append("<option value=\"车站服务电话\">车站服务电话</option>")
				  .append("<option value=\"车站位置\">车站位置</option>")
				  .append("<option value=\"包车业务\">包车业务</option>")
			}else if(servicecode=="suggest"){
				$("#type").append("<option value=\"\">全部</option>")

			}else if(servicecode=="prise"){
				$("#type").append("<option value=\"\">全部</option>")
			}			  
		}else if(industry=="道路货运行业"){
			$("#type").html("");
			if (servicecode=="complaint"){
			$("#type").append("<option value=\"\">全部</option>")
					  .append("<option value=\"非法营运\">非法营运</option>")
					  .append("<option value=\"服务态度差\">服务态度差</option>")
			}else if(servicecode=="ask"){
				$("#type").append("<option value=\"\">全部</option>")
				  .append("<option value=\"资格证事宜\">资格证事宜</option>")
				  .append("<option value=\"学习考试事宜\">学习考试事宜</option>")
				  .append("<option value=\"资格证办理注销\">资格证办理注销</option>")
				  .append("<option value=\"货运站电话\">货运站电话</option>")
				  .append("<option value=\"资格证年审\">资格证年审</option>")
				  .append("<option value=\"查询成绩\">查询成绩</option>")
				  .append("<option value=\"资格证更换\">资格证更换</option>")
			}else if(servicecode=="suggest"){
				$("#type").append("<option value=\"\">全部</option>")
			}else if(servicecode=="prise"){
				$("#type").append("<option value=\"\">全部</option>")
			}			  
		}else if(industry=="公交车行业"){
			$("#type").html("");
			if (servicecode=="complaint"){
			$("#type").append("<option value=\"\">全部</option>")
					  .append("<option value=\"服务态度差\">服务态度差</option>")
					  .append("<option value=\"不按站点停靠\">不按站点停靠</option>")
					  .append("<option value=\"不按时发车\">不按时发车</option>")
					  .append("<option value=\"久等无车\">久等无车</option>")
					  .append("<option value=\"危险驾驶\">危险驾驶</option>")
					  .append("<option value=\"拒载\">拒载</option>")
			}else if(servicecode=="ask"){
				$("#type").append("<option value=\"\">全部</option>")
				  .append("<option value=\"IC卡\">IC卡</option>")
				  .append("<option value=\"乘车规定\">乘车规定</option>")
				  .append("<option value=\"线路\">线路</option>")
				  .append("<option value=\"站点\">站点</option>")
			}else if(servicecode=="suggest"){
				$("#type").append("<option value=\"\">全部</option>")
				  .append("<option value=\"线路调整\">线路调整</option>")
				  .append("<option value=\"站点调整\">站点调整</option>")
				  .append("<option value=\"时间班次调整\">时间班次调整</option>")
			}else if(servicecode=="prise"){
				$("#type").append("<option value=\"\">全部</option>")
				  .append("<option value=\"拾金不昧\">拾金不昧</option>")
				  .append("<option value=\"热情服务\">热情服务</option>")
			}			  
		}else if(industry=="轨道交通行业"){
			$("#type").html("");
			if (servicecode=="complaint"){
				$("#type").append("<option value=\"\">全部</option>")
						  .append("<option value=\"服务态度差\">服务态度差</option>")
						  .append("<option value=\"安检\">安检</option>")
		   }else if(servicecode=="ask"){
				$("#type").append("<option value=\"\">全部</option>")
				  .append("<option value=\"广播声音调整\">广播声音调整</option>")
				  .append("<option value=\"空调调整\">空调调整</option>")
				  .append("<option value=\"班次时间调整\">班次时间调整</option>")

			}else if(servicecode=="prise"){
				$("#type").append("<option value=\"\">全部</option>")
				  .append("<option value=\"拾金不昧\">拾金不昧</option>")
				  .append("<option value=\"热情服务\">热情服务</option>")
			}				  
		}else if(industry=="汽车租赁行业"){
			$("#type").html("");
			if(servicecode=="ask"){
				$("#type").append("<option value=\"\">全部</option>")
				  .append("<option value=\"车辆挂靠\">车辆挂靠</option>")
			}			  
		}else if(industry=="水运旅客运输行业"){
			$("#type").html("");
			if(servicecode=="ask"){
				$("#type").append("<option value=\"\">全部</option>")
				  .append("<option value=\"票价\">票价</option>")
				  .append("<option value=\"码头位置\">码头位置</option>")
			} 
		}else if(industry=="公路建设行业"){
			$("#type").html("");
			if(servicecode=="ask"){
				$("#type").append("<option value=\"\">全部</option>")
				  .append("<option value=\"道路养护\">道路养护</option>")
			} 
		}else if(industry=="水运作业"){
			$("#type").html("");
			if (servicecode=="complaint"){
			$("#type").append("<option value=\"\">全部</option>")
					  .append("<option value=\"噪声扰民\">噪声扰民</option>")
			}		  
		}else{
			$("#type").html("");
				if (servicecode=="complaint"){
					$("#type").append("<option value=\"\">全部</option>")
							  .append("<option value=\"拒载\">拒载</option>")
							  .append("<option value=\"强打组合\">强打组合</option>")
							  .append("<option value=\"甩客\">甩客</option>")
							  .append("<option value=\"不开发票\">不开发票</option>")
							  .append("<option value=\"不使用计价器\">不使用计价器</option>")
							  .append("<option value=\"绕道\">绕道</option>")
							  .append("<option value=\"乱收费\">乱收费</option>")
							  .append("<option value=\"不文明服务\">不文明服务</option>")
							  .append("<option value=\"危险驾驶\">危险驾驶</option>")
							  .append("<option value=\"找补假钱\">找补假钱</option>")
							  .append("<option value=\"乱收费\">乱收费</option>")
							  .append("<option value=\"吃拿卡要\">吃拿卡要</option>")
							  .append("<option value=\"不安排学习考试\">不安排学习考试</option>")
							  .append("<option value=\"不按规定线路行驶\">不按规定线路行驶</option>")
							  .append("<option value=\"不按规定站点停靠\">不按规定站点停靠</option>")
							  .append("<option value=\"站外上客\">站外上客</option>")	
							  .append("<option value=\"转客\">转客</option>")			
							  .append("<option value=\"搭售保险\">搭售保险</option>")			
							  .append("<option value=\"儿童收全票\">儿童收全票</option>")			
							  .append("<option value=\"提前发车\">提前发车</option>")			
							  .append("<option value=\"晚点\">晚点</option>")
							  .append("<option value=\"票据问题\">票据问题</option>")
							  .append("<option value=\"非法营运\">非法营运</option>")
							  .append("<option value=\"服务态度差\">服务态度差</option>")
							  .append("<option value=\"安检\">安检</option>")
							  .append("<option value=\"噪声扰民\">噪声扰民</option>")
							  .append("<option value=\"久等无车\">久等无车</option>")
							  .append("<option value=\"不按时发车\">不按时发车</option>")
							  .append("<option value=\"不按站点停靠\">不按站点停靠</option>")
				}else if(servicecode=="ask"){
					$("#type").append("<option value=\"\">全部</option>")
					  .append("<option value=\"查投诉\">查投诉</option>")
					  .append("<option value=\"咨询价格\">咨询价格</option>")
					  .append("<option value=\"从业资格\">从业资格</option>")
					  .append("<option value=\"电招出租车\">电招出租车</option>")
					  .append("<option value=\"网约车政策\">网约车政策</option>")
					  .append("<option value=\"从业资格\">从业资格</option>")
					  .append("<option value=\"手续办理\">手续办理</option>")
					  .append("<option value=\"退费\">退费</option>")
					  .append("<option value=\"驾校电话\">驾校电话</option>")
					  .append("<option value=\"预约考试\">预约考试</option>")
					  .append("<option value=\"考试科目\">考试科目</option>")
					  .append("<option value=\"驾校事宜\">驾校事宜</option>")
					  .append("<option value=\"收费事宜\">收费事宜</option>")
					  .append("<option value=\"班次信息\">班次信息</option>")
					  .append("<option value=\"班车发车时间\">班车发车时间</option>")
					  .append("<option value=\"班车票价\">班车票价</option>")
					  .append("<option value=\"班车线路\">班车线路</option>")
					  .append("<option value=\"车站服务电话\">车站服务电话</option>")
					  .append("<option value=\"车站位置\">车站位置</option>")
					  .append("<option value=\"包车业务\">包车业务</option>")
					  .append("<option value=\"资格证事宜\">资格证事宜</option>")
					  .append("<option value=\"学习考试事宜\">学习考试事宜</option>")
					  .append("<option value=\"资格证办理注销\">资格证办理注销</option>")
					  .append("<option value=\"货运站电话\">货运站电话</option>")
					  .append("<option value=\"资格证年审\">资格证年审</option>")
					  .append("<option value=\"查询成绩\">查询成绩</option>")
					  .append("<option value=\"资格证更换\">资格证更换</option>")
					  .append("<option value=\"IC卡\">IC卡</option>")
					  .append("<option value=\"乘车规定\">乘车规定</option>")
					  .append("<option value=\"线路\">线路</option>")
					  .append("<option value=\"站点\">站点</option>")
					  .append("<option value=\"广播声音调整\">广播声音调整</option>")
					  .append("<option value=\"空调调整\">空调调整</option>")
					  .append("<option value=\"班次时间调整\">班次时间调整</option>")
					  .append("<option value=\"车辆挂靠\">车辆挂靠</option>")
					  .append("<option value=\"码头位置\">码头位置</option>")
					  .append("<option value=\"道路养护\">道路养护</option>")
				}else if(servicecode=="suggest"){
					$("#type").append("<option value=\"\">全部</option>")
						      .append("<option value=\"线路调整\">线路调整</option>")
				 			  .append("<option value=\"站点调整\">站点调整</option>")
				  			  .append("<option value=\"时间班次调整\">时间班次调整</option>")
	
				}else if(servicecode=="prise"){
					$("#type").append("<option value=\"\">全部</option>")
					  .append("<option value=\"拾金不昧\">拾金不昧</option>")
					  .append("<option value=\"热情服务\">热情服务</option>")
				}
		}
		
	}
</script>

[/@layout.main]