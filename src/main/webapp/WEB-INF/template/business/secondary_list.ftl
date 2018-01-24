[#assign jss=[]] 
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['business_keyword','spider'] otherjs=jss sername=['96096关键词配置','关键词配置','${industry_name}'] pagename='${industry_name}']
	<table class="table-form">
					<tbody>
			<a class="btn btn-sm btn-primary"  data-toggle="modal"  href="${base}/business/keyword" >返 回</a>&nbsp;
			<a class="btn btn-sm btn-primary"  data-toggle="modal" href="#large" onclick="addBusinessSecondary('${root_id}');" >新增行为特征</a>
			</tbody>
			</table>
	<table class="table  table-bordered table-hover">
				<thead>
					<tr>
						<th style="width:5%;text-align:center;">序号 </th>
						<th style="width:10%;">行为特征</th>
						<th style="width:30%;">正向词</th>
						<th style="width:25%;">反向词</th>
						<th style="width:10%;">正则表达式</th>
						<th style="width:10%;">所属行业</th>
						<th style="width:20%;">操作</th>
					</tr>
				</thead>
				<tbody id="A">
				[#list page as p]
					<tr>
						<td  style="text-align:center;">${p_index+1}</td>
						<td>${p.business_name }</td>
						<td>${p.key_word}</td>
						<td>${p.un_key_word}</td>
						<td>${p.regex}</td>
						<td>${p.industry}</td>
						<td>
						<a class="btn btn-xs btn-primary" data-toggle="modal" href="#large" onclick="editSecondary('${root_id}','${p.id}','${p.business_name}','${p.types}','${p.create_date}','${p.key_word}','${p.un_key_word}','${p.regex}','${p.industry}')">编 辑
							</a>
							<a class="btn btn-xs btn-danger"   onclick="deleteSecondary('${root_id}','${p.id}')"    href="#large">删 除</a>
						</td>
					</tr>
					[/#list]
				</tbody>
			</table>
			
						
<div class="modal fade bs-modal-lg in" id="large" tabindex="-1" role="dialog" data-backdrop="static" aria-hidden="false" style="display: none;">
		<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="portlet box blue-madison ">
					<div class="portlet-title">
						<div class="caption">
							行为特征
						</div>
					</div>
					</div>
			<div class="portlet-body form">
						<form role="form"     id="idForm" >
							<input type="hidden"     id="root_id" name="root_id" value=""> 
							<input type="hidden" id="id" name="id" value=""> 
							<input type="hidden" id="create_date" name="create_date" value="">
							 <table class="table-form">
								<tbody>
									<tr>
										<td style="width:20%;text-align:right;">行为特征名称</td>
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
									<tr>
										<td style="width:20%;text-align:right;">所属行业</td>
										<td style="width:50%;"><input type="text" id="industry" name="industry" value="" class="form-control"></td>
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
<script type="text/javascript">	
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
	var root_id = document.getElementById("root_id").value.trim();
	$.ajax({
		type:"post",
		url:base+"/business/keyword/save/secondary",
		data:$("#idForm").serialize(),
		async:false,  
		success:function(data){
			if(data=="SUCCESS"){
				alert("保存成功！");
                window.location.href=base + "/business/keyword/secondary/list/"+root_id;
			}else{
				alert("保存失败！");
			}
		},
		error:function(){
			 alert("数据加载失败");
		}
	});
}

var addBusinessSecondary = function(root_id){
	clearBusinessSecondary(root_id);
}

var clearBusinessSecondary = function(root_id){
	$("#root_id").val(root_id);
	$("#id").val("");
	$("#business_name").val("");
	$("#key_word").val("");
	$("#un_key_word").val("");
	$("#create_date").val("");
	$("#regex").val("");
	$("#industry").val("");
}

var editSecondary = function(root_id,id,business_name,types,create_date,key_word,un_key_word,regex,industry ){	
	$("#root_id").val(root_id);
	$("#id").val(id);
	$("#business_name").val(business_name);
	$("#key_word").val(key_word);
	$("#un_key_word").val(un_key_word);
	$("#create_date").val(create_date);
	$("#regex").val(regex);
	$("#industry").val(industry);
}
var deleteSecondary = function(root_id,id){
	if(confirm("确认要删除此分类")){
		window.location.href = base + "/business/keyword/delete/secondary/"+root_id+"/"+id;
	}
}


</script>
	
	
	
	
				
[/@layout.main]
