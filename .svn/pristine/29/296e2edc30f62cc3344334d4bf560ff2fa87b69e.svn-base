[#import "common/layout.ftl" as layout] 
[#assign jss=["assets/js/date-time/bootstrap-datetimepicker.min.js"]] 
[#assign css=["assets/css/zhemutanchukuang.css","assets/css/datetimepicker.css"]]
[@layout.main modelcode=['hnii_analyze','infocheck'] otherjs=jss othercss=css sername=['数据查询','96096工单数据'] pagename='96096工单数据']

[#macro sub info]
	[#if info?length>2000]
		${info[0..2000]}....
	[#else]
		${info}
	[/#if]
[/#macro]

[#macro sub2 info]
	[#if info?length>2000]
		${info[0..2000]}....
	[#else]
		${info}
	[/#if]
[/#macro]
[#include "common/loading.ftl"] 
<form class="form-horizontal" role="form" id="formid" action="${base}/hnii_analyze/hnii_analyze_data" method="get"  autocomplete="off">
	<table class="table-form">
		<tbody>
              <tr>
				<td style="width:10%;text-align:right;">业务</td>
				<td style="width:30%;">
				<select class="bs-select form-control" id="btype"  name="btype" onclick="changeView(this);">
				<option value="" >请选择</option>
				 [#list roots  as root]
					<option value="${root.business_name}" [#if btype=root.business_name]  selected="selected"   [/#if] >${root.business_name}</option>
				[/#list]
				</select>
				</td>
				<td style="width:10%;text-align:right;">行为特征</td>
				<td style="width:30%;">
				<input type="hidden" id="stype" name="stype" value="">
				<div id=""  name="xiaolei">
				<select class="bs-select form-control" id="sstype"  name="sstype"  onclick="setStype(this);">
				<option value="" >请选择</option>
				[#list secondarys  as secondary]
				<option value="${secondary.business_name}" [#if stype=secondary.business_name]  selected="selected"   [/#if]>${secondary.business_name}</option>
				[/#list]
				</select>
				</div>
				 [#list roots  as root]
				<div hidden="true" id="${root.business_name}" name="xiaolei">
				<select class="bs-select form-control" id="sstype"  name="sstype" onclick="setStype(this);">
				<option value="" >请选择</option>
				[#list root.secondarys  as secondary]
				<option value="${secondary.business_name}" [#if stype=secondary.business_name]  selected="selected"   [/#if]>${secondary.business_name}</option>
				[/#list]
				</select>
				</div>
				
				[/#list]
				</td>
  				<td style="width:20%;padding-left:20px;"></td>
			</tr>
			<tr>
				<td style="width:10%;text-align:right;">行业</td>
				<td style="width:30%;"><input type="text" id="industry" name="industry" value="${industry}" class="form-control"></td>
				<td style="width:10%;text-align:right;">工单流水号</td>
				<td style="width:30%;"><input type="text" id="content" name="content" value="${content }" class="form-control"></td>
			</tr>
			<tr>
			<td style="width:10%;text-align:right;">来电时间</td>
			<td style="width:30%;"><div class="input-group date form_datetime formtd-width80">
									<input class="form-control formtd-width80 input-inline"  name="begindate" readonly 
											id="begindate" data-date-format="yyyy-MM-dd" value="${(begindate?string('yyyy-MM-dd'))!}"
											style="border-right: 0px; background-color: white;">
									 <span class="input-group-btn">
											<button class="btn btn-primary date-set" type="button" style="padding:0px;height:31px;">
												<img src="${base}/assets/images/rl.png" style="float:left;">
											</button>
									</span>
									</div></td>
				<td style="width:10%;text-align:right;">至</td>
				<td style="width:30%;"><div class="input-group date form_datetime formtd-width80">
									   <input class="form-control formtd-width80 input-inline"   name="enddate" readonly
											id="enddate" data-date-format="yyyy-MM-dd" value="${(enddate?string('yyyy-MM-dd'))!}"
											style="border-right: 0px; background-color: white;">
									   <span class="input-group-btn">
											<button class="btn btn-primary date-set" type="button" style="padding:0px;height:31px;">
												<img src="${base}/assets/images/rl.png" style="float:left;">
											</button>
									  </span>
									  </div>
					</td>
					<td style="width:20%;padding-left:10px;">
					<button class="btn btn-sm btn-primary" type="submit">查 询</button>
					<a class="btn btn-sm btn-primary" href="#large" data-toggle="modal"  onclick="exportInfo();">导出Excel</a>
				</td>
			
			</tr>
		</tbody>
	</table>
</form>
<table  class="table  table-bordered table-hover">
	<thead>
		<tr>
			<th style="width:5%;text-align:center;">序号 </th>
			<th style="width:10%;">工单流水号</th>
			<th style="width:10%;">业务</th>
			<th style="width:15%;">行为特征</th>
			<th style="width:15%;">行业</th>
			<th style="width:15%;">来电时间</th>
			<th style="width:25%;">工单内容</th>
			<th style="width:10%;">操作</th>
		</tr>
	</thead>
	<tbody>
		[#list page.content as per]
		<tr id="${per.id}">
			<td  style="text-align:center;">${pageable.offset + per_index+1}</td>
			<td>${per.myid}</td>
			<td>${per.btype}</td>
			<td>${per.stype}</td>
			<td name="industry" >${per.industry }</td>
			<td name="object" >${per.calltime?string("yyyy-MM-dd HH:mm:ss") }</td>
			<td name="content" title="${per.content}">[@sub per.content][/@sub]</td>
			<td><a class="btn btn-xs btn-primary" href="${base}/hnii_analyze/hnii_analyze_data/${per.id}/show">查看</a>
			<!-- <a class="btn btn-xs btn-info" data-toggle="modal" href="#large" onclick="edit(this,'${servicecode}')" >编辑</a> -->
			</td>
		</tr>
		[/#list]
	</tbody>
</table>

[#assign pagepath="${base}/hnii_analyze/hnii_analyze_data?btype=${btype}&stype=${stype}&industry=${industry}&content=${content}&"]  
[#include "common/pagemodel.ftl"]
 
<script type="text/javascript">
$(function() {
	$("#btype").click();
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

/* function openExport(){
	 // $(".caption").html("添加父类业务");
	  $("#isforbidden").val(0);
}
 */

function exportInfo(){
	 $("#cancle").click();
	var btype=$("#btype").val();
	var stype=$("#sstype").val();
	var industry=$("#industry").val();
	var content=$("#content").val();
	var year=$("#year").val();
	var begindate=$("#begindate").val();
	var enddate=$("#enddate").val();
	var year=$("#year").val();
	
	if(begindate==null||enddate==null||begindate==""||enddate==""){
		 alert("来电时间不能为空！");
	}else if(begindate>enddate){
		alert("来电时间截止不能小于来电时间开始！");
	}else{
		var iDays=DateDiff(begindate,enddate);
		if(iDays > 0){
			alert("只能导出半年以内的数据！");
		}
		else{
		
			$("#loadingbg").show();
		    $("#loading").show();
			$.ajax({
				type:"get",
				url:base+"/hnii_analyze/hnii_analyze_data/export",
				data:{
					btype:btype,
					stype:stype,
					industry:industry,
					content:content,
					year:year,
					begindate:begindate,
					enddate:enddate
				},
				dataType:"text",
				success:function(data){
					$("#loadingbg").hide();
				    $("#loading").hide();
					window.location.href =base+"/doc/"+data;
				},
				error:function(){
				   alert("报告出错！");
				   $("#loadingbg").hide();
				   $("#loading").hide();
				}
			});
		}
	}
	
	
	
}

 function  DateDiff(date1,  date2){    //sDate1和sDate2是2006-12-18格式  
 /*     var  aDate,  oDate1,  oDate2,  iDays  
     aDate  =  sDate1.split("-")  
     oDate1  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0])    //转换为12-18-2006格式  
     aDate  =  sDate2.split("-")  
     oDate2  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0])  
     iDays  =  parseInt(Math.abs(oDate1  -  oDate2)  /  1000  /  60  /  60  /24)    //把相差的毫秒数转换为天数   */
     date1 = date1.split('-');
  // 得到月数
  date1 = parseInt(date1[0]) * 12 + parseInt(date1[1]);
  // 拆分年月日
  date2 = date2.split('-');
  // 得到月数
  date2 = parseInt(date2[0]) * 12 + parseInt(date2[1]);
  var m = Math.abs(date1 - date2);
     return  m;  
 }    
	
function changeView(e){
	var dalei=$(e).val();
	$("#"+dalei).attr("hidden",false);
	var divs=$("div[name='xiaolei']");
	for(i=0;i<divs.length;i++){
		if($(divs[i]).attr("id")!=dalei){
			$(divs[i]).attr("hidden",true);
		}
	}
}

function setStype(e) {
	var stype=$(e).val();
	$("#stype").val(stype);
}
	
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
</script>
[/@layout.main]