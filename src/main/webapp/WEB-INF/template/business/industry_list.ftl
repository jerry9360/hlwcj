[#assign jss=[]] 
[#assign css=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['business_keyword','spider'] otherjs=jss  othercss=css sername=['96096关键词配置','关键词配置','${industry_name}'] pagename='${industry_name}']
			[#include "business/taburl.ftl"]
			
			<table class="table-form">
					<tbody>
			&nbsp;&nbsp;&nbsp;<a class="btn btn-sm btn-primary"  data-toggle="modal" href="#large" onclick="addlabel();">新 增</a>
			<br>
			</tbody>
			</table>
		<table class="table  table-bordered table-hover">
				<thead>
					<tr>
						<th style="width:5%;text-align:center;">序号 </th>
						<th style="width:10%;">行业类型</th>
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
						<td>${p.industry_name }</td>
						<td>${p.key_word}</td>
						<td>${p.un_key_word}</td>
						<td>${p.regex}</td>
						<td>
							<a class="btn btn-xs btn-primary" data-toggle="modal" href="#large" onclick="editLabel('${p.industry_id}','${p.industry_name}','${p.key_word}','${p.un_key_word}','${p.belong_industry}','${p.create_date}','${p.regex}')">编 辑</a>
							<a class="btn btn-xs btn-danger" href="javascript:void(0)" onclick="deletelabel('${p.industry_id}')">删 除</a>
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
							行业类型
						</div>
					</div>
					<div class="portlet-body form">
						<form role="form"  id="formid" >
							<input type="hidden" id="industry_id" name="industry_id" value="">
							<input type="hidden" id="create_date" name="create_date" value="">
							<table class="table-form">
								<tbody>
									<tr>
										<td style="width:20%;text-align:right;">行业类型名称</td>
										<td style="width:50%;"><input type="text" id="industry_name" name="industry_name" value="" class="form-control"></td>
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
										<td style="width:20%;text-align:right;">所属行业市场</td>
										<td style="width:50%;"> 
										<select id="belong_industry" name="belong_industry"   style=""   class="form-control">
										<option value='0' [#if mangecodetable.source=='0']selected = "selected"[/#if]>道路运输市场</option>
										<option value='1' [#if mangecodetable.source=='1']selected = "selected"[/#if]>水路运输市场</option>
										<option value='2' [#if mangecodetable.source=='2']selected = "selected"[/#if]>公路建设市场 </option>
	          							<option value='3' [#if mangecodetable.source=='3']selected = "selected"[/#if]>水运建设市场</option>
										 </select>
										</td>
										<td style="width:30%;"></td> 
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
    var label_namedesc = document.getElementById("industry_name").value.trim();
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
		url:base+"/business/keyword/save/industry",
		data:$("#formid").serialize(),
		async:false,  
		success:function(data){
			if(data=="SUCCESS"){
				alert("保存成功！");
                window.location.href=base + "/business/keyword/industry/list";
			}else{
				alert("保存失败！");
			}
		},
		error:function(){
			 alert("数据加载失败");
		}
	});
}
var clearlabel = function(){
	$("#industry_id").val("");
	$("#industry_name").val("");
	$("#key_word").val("");
	$("#un_key_word").val("");
	$("#belong_industry").val("");
	$("#regex").val("");
}
var editLabel = function(industry_id,industry_name,key_word,un_key_word,belong_industry,create_date,regex){		
	$("#industry_id").val(industry_id);
	$("#industry_name").val(industry_name);
	$("#key_word").val(key_word);
	$("#un_key_word").val(un_key_word);
	$("#belong_industry").val(belong_industry);
	$("#create_date").val(create_date);
	$("#regex").val(regex);
	 
}


var deletelabel = function(id){
	if(confirm("确认要删除此分类")){
		window.location.href = base + "/business/keyword/delete/industry/"+id;
	}
}
</script>
[/@layout.main]
