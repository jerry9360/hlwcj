[#assign jss=[]] 
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['label','spider'] otherjs=jss sername=['标签管理','业务标签'] pagename='业务标签']
			<form class="form-horizontal" role="form" id="formid" action="${base}/labelmgr/labels" method="get" autocomplete="off">
				<table class="table-form">
					<tbody>
						<tr>
							<td style="width:10%;text-align:right;">标签名称</td>
							<td style="width:30%;"><input type="text" id="name" name="name" value="${name }" class="form-control"></td>
							<td style="width:60%;padding-left:20px;">
								<button class="btn btn-sm btn-primary" type="submit">查 询</button>
								<a class="btn btn-sm btn-primary" data-toggle="modal" href="#large" onclick="addlabel();">新 增</a>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
			<table class="table  table-bordered table-hover">
				<thead>
					<tr>
						<th style="width:5%;text-align:center;">序号 </th>
						<th style="width:15%;">标签名称</th>
						<th style="width:10%;">信息类别</th>
						<th style="width:35%;">标签关键字</th>
						<th style="width:20%;">数据来源</th>
						<th style="width:15%;">操作</th>
					</tr>
				</thead>
				<tbody id="A">
				[#list page.content as p]
					<tr>
						<td  style="text-align:center;">${pageable.offset + p_index+1}</td>
						<td >${p.name }</td>
						<td >
							[#if p.type=='1']良好
							[#elseif p.type=='2']不良
							[/#if]
						</td>
						<td>${p.namedesc }</td>
						<td>${p.source}</td>
						<td>
							<a class="btn btn-xs btn-primary" data-toggle="modal" href="#large" onclick="editLabel('${p.id}','${p.type}','${p.name}','${p.namedesc}','${p.source}')">编辑</a>
							<a class="btn btn-xs btn-danger" href="javascript:void(0)" onclick="deletelabel('${p.id}')">删除</a>
						</td>
					</tr>
					[/#list]
				</tbody>
			</table>
			[#assign pagepath="${base}/labelmgr/labels?name=${name}&"]  
			[#include "common/pagemodel.ftl"]
<div class="modal fade bs-modal-lg in" id="large" tabindex="-1" role="dialog" data-backdrop="static" aria-hidden="false" style="display: none;">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-body">
				<div class="portlet box blue-madison ">
					<div class="portlet-title">
						<div class="caption">
							标签管理
						</div>
					</div>
					<div class="portlet-body form">
						<form role="form" id="infoForm"   >
							<input type="hidden" id="label_id" name="id" value="">
							<table class="table-form">
								<tbody>
									<tr>
										<td style="width:20%;text-align:right;">标签</td>
										<td style="width:50%;"><input type="text" id="label_name" name="name" value="" class="form-control"></td>
										<td style="width:30%;"></td>
									</tr>
									<tr>
										<td style="text-align:right;">关键字</td>
										<td><textarea id="label_namedesc" name="namedesc" rows="3" class="form-control"></textarea></td>
										<td>多个关键字加号（“+”）隔开</td>
									</tr>
									<tr>
										<td style="text-align:right;">信息类别</td>
										<td>
											<input type="radio" name="type" id="type" value="1" checked="checked">良好
											<input type="radio" name="type" id="type" value="2">不良
										</td>
										<td></td>
									</tr>
									<tr>
										<td style="text-align:right;">数据来源</td>
										<td colspan="2">
											<input type="checkbox" id="datasource" name="source" value="1" checked="checked">交通行业政务网站
											<input type="checkbox" id="datasource" name="source" value="2">新闻媒体网站
											<input type="checkbox" id="datasource" name="source" value="3">自媒体（微博、微信）
											<input type="checkbox" id="datasource" name="source" value="4">搜索引擎
											<input type="checkbox" id="datasource" name="source" value="0">其它
										</td>
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
<script type="text/javascript">

var saveform=function(){
	var label_name = document.getElementById("label_name").value.trim();
    var label_namedesc = document.getElementById("label_namedesc").value.trim();
    var type = document.getElementById("type").value.trim();
    var datasource = document.getElementById("datasource").value.trim();
	 if(label_name==""||label_namedesc==""||type==""||datasource==""){
			alert("请输入有效内容!");
	}else{
		save();
	}
	
}
var save=function(){
	$.ajax({
		type:"post",
		url:base+"/labelmgr/labels/save",
		data:$("#infoForm").serialize(),
		async:false,  
		success:function(data){
			if(data=="SUCCESS"){
				alert("保存成功！");
                window.location.href=base + "/labelmgr/labels";
			}else{
				alert("保存失败！");
			}
		},
		error:function(){
			 alert("数据加载失败");
		}
	});
}

	var addlabel = function(){
		clearlabel();
	}
	var deletelabel = function(id){
		if(confirm("确认要删除此分类")){
			window.location.href = base + "/labelmgr/labels/delete/"+id;
		}
	}
	var editLabel = function(id,type,name,namedesc,source){		
		$("#label_id").val(id);
		$("#label_name").val(name);
		$("#label_name").attr("readonly","readonly");
		$("#label_namedesc").val(namedesc);
		var types = $("input[name='type']");
		var source=source.split(",");
		$.each(types,function(i,e){
			e.checked = false;
			if($(e).val()==type){
				e.checked = true;
			}
		});
		var sources = $("input[name='source']");
		$.each(sources,function(i,e){
			e.checked = false;
			$.each(source,function(i,e1){
				if(e1=="交通行业政务网站"){
				   e1=1;
				}
				if(e1=="新闻媒体网站"){
				   e1=2;
				}
				if(e1=="自媒体（微博、微信）"){
				   e1=3;
				}
				if(e1=="搜索引擎"){
				   e1=4;
				}
				if(e1=="其它"){
				   e1=0;
				}
				if($(e).val()==e1){
					e.checked = true;
				}
			});
		});
	}
	var clearlabel = function(){
		$("#label_id").val("");
		$("#label_namedesc").val("");
		$("#label_name").val("");
		$("#label_name").removeAttr("readonly");
		$("input[name='type']")[0].checked = true;
		$("input[name='source']")[0].checked = true;
	}
</script>
[/@layout.main]