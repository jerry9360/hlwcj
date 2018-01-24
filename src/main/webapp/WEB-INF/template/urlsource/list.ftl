[#assign jss=["assets/js/data/urlSource.js",
"assets/js/common/webuploader/webuploader.js"
]] 
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['urlmgr','datacollect'] otherjs=jss sername=['配置管理','数据源配置'] pagename='数据源配置']
[#macro sub info]
	[#if info?length>65]
		${info[0..65]}....
	[#else]
		${info}
	[/#if]
[/#macro]
			<form class="form-horizontal" role="form" id="formid" action="${base}/urlmgr/urlSource" method="get" autocomplete="off">
				<table class="table-form">
					<tbody>
						<tr>
							<td style="width:10%;text-align:right;">网站名称</td>
							<td style="width:30%;"><input type="text" id="urlname1" name="urlname" value="${urlname }" class="form-control"></td>
							<td style="width:60%;padding-left:20px;">
								<button class="btn btn-sm btn-primary" type="submit">查 询</button>
								<a class="btn btn-sm btn-primary" href="#large" data-toggle="modal" onclick="addUrl();">添加数据源</a>
								<!--  <a class="btn btn-sm btn-primary" onclick="export1(this);">导出Excel</a>-->
							</td>
						</tr>
					</tbody>
				</table>
		</form>
			<table class="table  table-bordered table-hover">
				<thead>
					<tr>
						<th style="width:5%;text-align:center;">序号</th>
						<th style="width:20%;">网站名称</th>
						<th style="width:20%;">版块名称</th>
						<th style="width:40%;">板块链接地址</th>
						<th style="width:15%;">操作</th>
					</tr>
				</thead>
				<tbody>
					[#list page.content as urlSource]
					<tr>
						<td style="text-align:center;">${pageable.offset + urlSource_index+1}</td>
						<td>${urlSource.webname}</td>
						<td>${urlSource.platename}</td>
						<td><a href=	"${urlSource.plateurl}" title="${urlSource.plateurl}" target="_blank">[@sub urlSource.plateurl][/@sub]</a></td>
						<td>
							<a class="btn btn-xs btn-primary"  href="#large" data-toggle="modal" onclick="editUrl('${urlSource.id}');">编辑</a>
							<a class="btn btn-xs btn-danger"  href="javascript:void(0)" onclick="deleteUrl('${urlSource.id}')">删除</a>
						</td>
					</tr>
					[/#list]
				</tbody>
			</table>
		<div class="modal fade bs-modal-lg in" id="large" tabindex="-1" role="dialog" data-backdrop="static" aria-hidden="false" style="display: none;">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-body">
						<div class="portlet box blue-madison ">
							<div class="portlet-title">
								<div class="caption">
									数据源配置
								</div>
							</div>
							<div class="portlet-body form">
					<form class="horizontal-form form" urlSource="form"     id="inForm"    >
						<input type='hidden' id="id" name="id" value=""/>
						<input type='hidden' id="createDate" name="createDate" value=""/>
						<table class="table-form">
							<tbody>
								<tr>
									<td class="td-center" style="width:20%;">网站类别</td>
									<td style="width:60%;">
										<input  type="radio" checked="checked" name="webtype" value="1">交通行业政务网站
										<input  type="radio" name="webtype" value="2">新闻媒体网站
									</td>
									<td style="width:20%;"></td>
								</tr>
								<tr>
									<td class="td-center">网站名称</td>
									<td>
										<input class="form-control" id="webname" name="webname" value="">
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="td-center">版块名称</td>
									<td>
										<input class="form-control" id="platename" name="platename" value="">
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="td-center">板块链接地址</td>
									<td>
										<input class="form-control" id="plateurl" name="plateurl" value="">
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="td-center">正文正则表达式</td>
									<td>
										<input class="form-control" id="contentregex" name="contentregex" value="">
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="td-center">翻页正则表达式</td>
									<td>
										<input class="form-control" id="pageregex" name="pageregex" value="">
									</td>
									<td></td>
							   </tr>
								<tr>
									<td class="td-center">可信度</td>
									<td>
										<input  type="radio"  name="credit"   value="0">可信度低
										<input  type="radio" checked="checked"  name="credit" value="1">可信度高				
									</td>
									<td></td>
							   </tr>
							   	<tr>
									<td class="td-center">所属单位</td>
									<td>
										<input class="form-control" id="unitname" name="unitname" value="">
									</td>
									<td></td>
							   </tr>						   							   							   							   																																								
							</tbody>
						</table> 
						<div class="form-actions" style="text-align: center;">
							<button class="btn btn-width-70 btn-primary" type="button" onclick="saveform()">保 存</button>
								<button  class="btn btn-width-70 default" type="button" data-dismiss="modal">取消</button>
						</div>
					</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>			
				[#assign pagepath="${base}/urlmgr/urlSource/?type=${type}&urlname=${urlname }&"]
				[#include "common/pagemodel.ftl"]
<script type="text/javascript">
function addUrl(){
	clearUrlsource();
}
var saveform=function(){
    var label_namedesc = document.getElementById("webname").value.trim();
    var type = document.getElementById("platename").value.trim();
    var datasource = document.getElementById("plateurl").value.trim();
	 if(label_namedesc==""||type==""||datasource=="" ){
			alert("请输入有效内容!");
	}else{
		save();
	}
	
}
var save=function(){
	$.ajax({
		type:"post",
		url:base+"/urlmgr/urlSource/save",
		data:$("#inForm").serialize(),
		async:false,  
		success:function(data){
			if(data=="SUCCESS"){
				alert("保存成功！");
                window.location.href=base + "/urlmgr/urlSource";
			}else{
				alert("保存失败！");
			}
		},
		error:function(){
			 alert("数据加载失败");
		}
	});
}
function deleteUrl(id){
	if(confirm("确认要删除此条数据源信息？")){
		window.location.href = base + "/urlmgr/urlSource/delete/" + id;
	}
}
function editUrl(id){
	 clearUrlsource();
	 $.ajax({
		type:"GET",
		url:base + "/urlmgr/urlSource/toEdit/" + id,
	 	dataType:"json",
	 	success:function(data){
 		  $("#id").val(data.id);
 		  $("#createDate").val(parseDatetime(data.createDate));
 			var wts = $("input[name='webtype']");
 			$.each(wts,function(i,e){
 				e.checked = false;
 				if($(e).val()==data.webtype){
 					e.checked = true;
 				}
 			});
 		  $("#webname").val(data.webname);
 		  $("#platename").val(data.platename);
 		  $("#plateurl").val(data.plateurl);
 		  /**
 		   			var ips = $("input[name='isstaticpage']");
 			$.each(ips,function(i,e){
 				e.checked = false;
 				if($(e).val()==data.isstaticpage){
 					e.checked = true;
 				}
 			});
 		  **/
 			$("#contentregex").val(data.contentregex);
 			$("#pageregex").val(data.pageregex);
 			var cs = $("input[name='credit']");
 			$.each(cs,function(i,e){
 				e.checked = false;
 				if($(e).val()==data.credit){
 					e.checked = true;
 				}
 			});
	 		$("#unitname").val(data.unitname);
	 	},
	 	error:function(){
	 		alert("不存在此条数据源信息！");
	 	}
	 });
}
function clearUrlsource(){
	$("#id").val("");
	$("#createDate").val("");
	$("#webname").val("");
	$("#platename").val("");
	$("#plateurl").val("");
	var ips = $("input[name='isstaticpage']");
	$.each(ips,function(i,e){
		if(1==0){
			e.checked = true;
		}else{
			e.checked = false;
		}
	});
	$("#contentregex").val("");
	$("#pageregex").val("");
	$("#unitname").val("");
}
function export1(ele){
	$.ajax({
		type:"get",
		url:base+"/urlmgr/urlSource/exportExcel",
		dataType:"text",
		success:function(data){
			if(data=="FAIL"){
				alert("导出失败！");
			}
			if(data=="SUCCESS"){
				 if(confirm("确认导出?")) {
			 		 alert("导出成功！");
			 		 window.location.href= base + "/common/file/down?filename=数据源.xls&filesource=D:/数据源.xls";
			    }
				
			}
		},
		error:function(){
		   alert("报告出错！");
		}
	});
}
</script>
[/@layout.main]