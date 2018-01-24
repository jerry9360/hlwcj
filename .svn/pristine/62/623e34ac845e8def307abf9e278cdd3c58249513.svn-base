[#assign jss=[]] 
[#assign css=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['business_keyword','spider'] otherjs=jss  othercss=css sername=['96096关键词配置','关键词配置'] pagename='关键词配置']
	[#include "business/taburl.ftl"]
			<form class="form-horizontal" role="form" id="formid" action="${base}/business/keyword/secondary/page" method="get" autocomplete="off">
				<table class="table-form">
					<tbody>
						<tr>
							<td style="width:10%;text-align:center;">业务类别名称</td>
							<td style="width:30%;"><input type="text" id="name" name="industry" value="${industry}" class="form-control"></td>
							<td style="width:60%;padding-left:20px;">
								<button class="btn btn-sm btn-primary" type="submit">查 询</button>&nbsp;&nbsp;
							<a class="btn btn-sm btn-primary"  data-toggle="modal" href="#large" onclick="addlabel();">新 增</a> 
						</td>
						</tr>
					</tbody>
				</table>
			</form>
			<table class="table  table-bordered table-hover">
				<thead>
					<tr>
						<th style="width:5%;text-align:center;">序号 </th>
						<th style="width:10%;">业务类别</th>
						<th style="width:30%;">正向词</th>
						<th style="width:30%;">反向词</th>
						<th style="width:10%;">正则表达式</th>
						<th style="width:20%;">操作</th>
					</tr>
				</thead>
				<tbody id="A">
				[#list page.content as p]
					<tr>
						<td  style="text-align:center;">${pageable.offset + p_index+1}</td>
						<td>${p.business_name }</td>
						<td>${p.key_word}</td>
						<td>${p.un_key_word}</td>
						<td>${p.regex}</td>
						<td>
						<a class="btn btn-xs btn-primary" data-toggle="modal" href="#large" onclick="editRoot( '${p.root_id}','${p.business_name}','${p.types}','${p.create_date}','${p.key_word}','${p.un_key_word}','${p.regex}')">编 辑
							</a>
							<a class="btn btn-xs btn-primary"  href="${base}/business/keyword/secondary/list/${p.root_id}">行为特征</a>
							<a class="btn btn-xs btn-danger"   onclick="deleteRoot('${p.root_id}')"    href="#large">删 除</a>
						</td>
					</tr>
					[/#list]
				</tbody>
			</table>
			[#assign pagepath="${base}/business/keyword?&"]  
			[#include "common/pagemodel.ftl"]
			
<div class="modal fade bs-modal-lg in" id="large" tabindex="-1" role="dialog" data-backdrop="static" aria-hidden="false" style="display: none;">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-body">
				<div class="portlet box blue-madison ">
					<div class="portlet-title">
						<div class="caption">
							业务大类
						</div>
					</div>
					<div class="portlet-body form">
						<form role="form" id="inForm"   >
							<input type="hidden" id="root_id" name="root_id" value="">
							<input type="hidden" id="create_date" name="create_date" value="">
							<input type="hidden" id="types" name="types" value="">
							<table class="table-form">
								<tbody>
									<tr>
										<td style="width:20%;text-align:right;">业务名称</td>
										<td style="width:50%;"><input type="text" id="business_name" name="business_name" value="" class="form-control"></td>
										<td style="width:30%;"></td>
									</tr>
									<tr>
										<td style="text-align:right;">正向词</td>
										<td><textarea id="key_word" name="key_word" rows="6" class="form-control"></textarea></td>
										<td>单个关键词匹配用加号（“+”）隔开，例如：拒载+询问去向<br>
										多个关键词同时匹配用星号号（“*”）连接，例如：失物*收费
										</td>
									</tr>
									<tr>
										<td style="text-align:right;">反向词</td>
										<td><textarea id="un_key_word" name="un_key_word" rows="6" class="form-control"></textarea></td>
										<td>单个关键词匹配用加号（“+”）隔开，例如：拒载+询问去向<br>
										多个关键词同时匹配用星号号（“*”）连接，例如：失物*收费
										</td>
									</tr>
									<tr>
										<td style="width:20%;text-align:right;">正则表达式</td>
										<td style="width:50%;"><input type="text" id="regex" name="regex" value="" class="form-control"></td>
										<td style="width:30%;"></td>
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
	var addlabel = function(){
		clearlabel();
	}
	var saveform=function(){
	    var label_namedesc = document.getElementById("business_name").value.trim();
	    var type = document.getElementById("key_word").value.trim();
		 if(label_namedesc==""||type==""  ){
				alert("请输入有效内容!");
		}else{
			save();
		}
		
	}
	var save=function(){
		$.ajax({
			type:"post",
			url:base+"/business/keyword/save/root",
			data:$("#inForm").serialize(),
			async:false,  
			success:function(data){
				if(data=="SUCCESS"){
					alert("保存成功！");
	                window.location.href=base + "/business/keyword";
				}else{
					alert("保存失败！");
				}
			},
			error:function(){
				 alert("数据加载失败");
			}
		});
	}
	var deletelabel = function(id){
		if(confirm("确认要删除此分类")){
			window.location.href = base + "/business/keyword/delete/industry/"+id;
		}
	}
	var editRoot = function(root_id,business_name,types,create_date,key_word,un_key_word,regex){		
		$("#root_id").val(root_id);
		$("#business_name").val(business_name);
		$("#types").val(types);
		$("#key_word").val(key_word);
		$("#un_key_word").val(un_key_word);
		$("#create_date").val(create_date);
		$("#regex").val(regex);
	}
	var clearlabel = function(){
		$("#root_id").val("");
		$("#business_name").val("");
		$("#types").val("");
		$("#key_word").val("");
		$("#un_key_word").val("");
		$("#create_date").val("");
		$("#regex").val("");
	}
	var deleteRoot = function(root_id){
		$.ajax({
			type:"get",
			url:base+"/business/keyword/sureAllSecondaryDelete/" + root_id,
			dataType:"text",
			async:false,
			success:function(data){
				if(data=="FAIL"){
					alert("请先删除相关业务小类！");
				}if(data=="SUCCESS"){
					if(confirm("确认要删除此分类")){
						window.location.href = base + "/business/keyword/delete/root/"+root_id;
					}
				}
			},
			error:function(){
			   alert("报告出错！")
			}
		});
	}
</script>
[/@layout.main]