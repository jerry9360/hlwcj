[#assign modelcodes=["sysmanager","servicemgr"]]
[#assign jss=["assets/global/plugins/jquery-validation/js/jquery.validate.min.js","assets/js/sys/rolesedit.js"]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['menumgr','adminmgr'] otherjs=jss sername=['系统管理','菜单管理'] pagename='菜单管理']

[#macro sub info]
	[#if info?length>20]
		${info[0..20]}....
	[#else]
		${info}
	[/#if]
[/#macro]
				<label> 
			<a class="btn btn-sm btn-primary" data-toggle="modal" href="#large" onclick="addFmenu();">添加父类业务</a>
			<input id="isshowforbidden"  type="checkbox" onclick="checkisshowforbidden();" [#if isforbidden??&&isforbidden=="1"]checked[/#if]><span class="lbl"> 显示禁用</span>
		</label>
			<table id="sample-table-1"
				class="table table-bordered table-hover">
				<thead>
					<tr>
						<th style="width:5%;text-align:center;"></th>
						<th style="width:15%;">菜单名称</th>
						<th style="width:10%;">菜单简称</th>
						<th style="width:10%;">菜单编码</th>
						<th style="width:20%;">Url</th>
						<th style="width:10%;">序号</th>
						<th style="width:20%;">操作</th>
					</tr>
				</thead>
				<tbody>
				[#list menulist as menu]
				[#if !menu.pid??]
					<tr>
						<td style="text-align:center;"><button style="width: 50%" class="btn btn-xs btn-success" name="${menu.id }" fname="${menu.id }" onclick="showchildmenu(this)">+</button></td>
						<td>${menu.menudesc }</td>
						<td>${menu.shortname }</td>
						<td>${menu.menucode }</td>
						<td title="${menu.url}">[@sub menu.url][/@sub]</td>
						<td>${menu.orderno }</td>
						<td>
							<input type="hidden" name="pid" value="${menu.pid}">
							<input type="hidden" name="id" value="${menu.id}">
							<input type="hidden" name="isforbidden" value="${menu.isforbidden}"/>
							<a class="btn btn-xs btn-primary" onclick='editMenu(this)'  data-toggle="modal" href="#large">编 辑
							</a>
							[#if menu.isforbidden=="0"]<button class="btn btn-xs btn-danger" onclick="confirmfisforbidden(this);" value="${menu.id }">禁 用
							</button>[/#if][#if menu.isforbidden=="1"]<button class="btn btn-xs btn-warning" onclick="confirmfunforbidden(this);" value="${menu.id }">启 用
							</button>[/#if]
							<a class="btn btn-xs btn-success" onclick='addCmenu(this)'  data-toggle="modal" href="#large">添加子类业务
							</a>
						</td>
					</tr>
					[#list menulist as menu2]
						[#if menu.id==menu2.pid]
						<tr hidden="hidden" name="pid${menu.id }" fname="pid${menu.id }">
							<td style="text-align: right;"></td>
							<td>${menu2.menudesc }</td>
							<td>${menu2.shortname }</td>
							<td>${menu2.menucode }</td>
							<td title="${menu2.url}">[@sub menu2.url][/@sub]</td>
							<td>${menu2.orderno }</td>						
							<td>
								<input type="hidden" name="pid" value="${menu2.pid}">
								<input type="hidden" name="id" value="${menu2.id}">
								<input type="hidden" name="isforbidden" value="${menu2.isforbidden}"/>
								<a class="btn btn-xs btn-primary" onclick='editMenu(this)'  data-toggle="modal" href="#large">编 辑
								</a> 
								[#if menu2.isforbidden=="0"]<button class="btn btn-xs btn-danger" onclick="confirmcisforbidden(this);" value="${menu2.id }">禁 用
								</button>[/#if][#if menu2.isforbidden=="1"]<button class="btn btn-xs btn-warning" onclick="confirmcunforbidden(this);" value="${menu2.id }">启 用
								</button>[/#if]
							</a>
							</td>
						</tr>					
						[/#if]
					[/#list]
					[/#if]
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
							菜单管理
						</div>
					</div>
					<div class="portlet-body form">
						<form role="form"     id="addrolesform">
							<input id="isforbidden" type="hidden" name="isforbidden" value=""/>
							<input type="hidden" id="id" name="id" value="">
							<input id="pid" type="hidden" name="pid" value=""/>		
							<table class="table-form">
								<tbody>
									<tr>
										<td style="width:30%;text-align:right;">业务名称 </td>
										<td style="width:70%;"><input style="width:60%;" type="text" id="menudesc" name="menudesc" value="" class="form-control"></td>
									</tr>
									<tr>
										<td style="width:30%;text-align:right;">业务简称</td>
										<td style="width:70%;"><input style="width:60%;" type="text" id="shortname" name="shortname" value="" class="form-control"></td>
									</tr>
									<tr>
										<td style="width:30%;text-align:right;">业务编码</td>
										<td style="width:70%;"><input style="width:60%;" type="text" id="menucode" name="menucode" value="" class="form-control"></td>
									</tr>
									<tr>
										<td style="width:30%;text-align:right;">URL</td>
										<td style="width:70%;"> <input style="width:60%;" type="text" id="url" name="url" value="" class="form-control"></td>
									</tr>
									<tr>
										<td style="width:30%;text-align:right;">顺序 </td>
										<td style="width:70%;"><input style="width:60%;" type="text" id="orderno" name="orderno" value="" class="form-control"></td>
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
    var label_namedesc = document.getElementById("menudesc").value.trim();
    var type = document.getElementById("menucode").value.trim();
    var datasource = document.getElementById("url").value.trim();
	 if(label_namedesc==""||type==""||datasource==""  ){
			alert("业务名称,业务编码和URL为必填项!");
	}else{
		save();
	}
	
}
var save=function(){
	$.ajax({
		type:"post",
		url:base+"/adminmgr/menu/save",
		data:$("#addrolesform").serialize(),
		async:false,  
		success:function(data){
			if(data=="SUCCESS"){
				alert("保存成功！");
                window.location.href=base + "/adminmgr/menu";
			}else{
				alert("保存失败！");
			}
		},
		error:function(){
			 alert("数据加载失败");
		}
	});
}
function showchildmenu(ele){
	var fid = $(ele).attr("name");
	var ffid = $(ele).attr("fname");
	var html = "<button style='width: 50%' class='btn btn-xs btn-success' name='" + fid + "' fname='" + ffid + "' onclick='hidechildmenu(this)'>-</button>";
	$(ele).replaceWith(html);
	$("tr[name='pid"+ fid + "']").show();
}

function hidechildmenu(ele){
	var a = ele;
	var fid = $(ele).attr("name");
	var ffid = $(ele).attr("fname");
	var html = "<button style='width: 50%' class='btn btn-xs btn-success' name='" + fid + "' fname='" + ffid + "' onclick='showchildmenu(this)'>+</button>";
	$(ele).replaceWith(html);
	$("tr[name='pid"+ fid + "']").hide();
	$("tr[fname='pid"+ fid + "']").hide();
	$("button[fname='"+ fid + "']").each(function(index, element){
		$(element).attr("onclick","showchildmenu(this)")
		$(element).text("+");
	});
}

function confirmfisforbidden(ele){
	var a = ele;
	var id = a.value;
	$.ajax({
		type:"get",
		url:base+"/adminmgr/menu/ischildmenuforbidden/" + id,
		dataType:"text",
		async:false,
		success:function(data){
			if(data=="FAIL"){
				alert("请先禁用相关子类业务！");
			}if(data=="SUCCESS"){
				 if(confirm("确认禁用父菜单?")) {
			 		 window.location.href= base + "/adminmgr/menu/forbidmenu/"+id;
			    }
			}
		},
		error:function(){
		   alert("报告出错！")
		}
	});
}

function confirmcisforbidden(ele){
	 if(confirm("确认禁用子菜单?")) {
	 		    var a = ele;
				var id = a.value;
	 		   window.location.href= base + "/adminmgr/menu/forbidmenu/"+id;
	    }
}

function confirmfunforbidden(ele){
	 if(confirm("确认启用菜单?")) {
		    var a = ele;
			var id = a.value;
		   window.location.href= base + "/adminmgr/menu/unforbidmenu/"+id;
 }
}

function confirmcunforbidden(ele){
	var a = ele;
	var id = a.value;
	$.ajax({
		type:"get",
		url:base+"/adminmgr/menu/isfathermenuforbidden/" + id,
		dataType:"text",
		async:false,
		success:function(data){
			if(data=="FAIL"){
				alert("请先启用父类业务！");
			}if(data=="SUCCESS"){
				 if(confirm("确认启用菜单?")) {
					 window.location.href= base + "/adminmgr/menu/unforbidmenu/"+id;
			    }
			}
		},
		error:function(){
		   alert("报告出错！")
		}
	});
}



function checkisshowforbidden(){
	if($("#isshowforbidden").is(':checked')){
		window.location.href= base + "/adminmgr/menu?isforbidden=1";
	}else{
		window.location.href= base + "/adminmgr/menu";
	}
}
function editMenu(obj){
	  var isforbidden=$(obj).prev().val();
	  var id=$(obj).prev().prev().val();
	  var pid=$(obj).siblings("input").eq(0).val();
	  var menudesc=$(obj).parent().siblings().eq(1).html();
	  var shortname=$(obj).parent().siblings().eq(2).html();
	  var menucode=$(obj).parent().siblings().eq(3).html();
	  var url=$(obj).parent().siblings().eq(4).attr("title")
	  var orderno=$(obj).parent().siblings().eq(5).html();
	  $("#isforbidden").val(isforbidden);
	  $("#id").val(id);
	  $("#pid").val(pid);
	  $("#menudesc").val(menudesc);
	  $("#shortname").val(shortname);
	  $("#menucode").val(menucode);
	  $("#url").val(url);
	  $("#orderno").val(orderno);
	  $(".caption").html("编辑菜单");
}
function addFmenu(){
	 // $(".caption").html("添加父类业务");
	  $("#isforbidden").val(0);
}
function addCmenu(obj){
	 // $(".caption").html("添加子类业务");
	  $("#isforbidden").val(0);
	  var id=$(obj).siblings("input").eq(1).val();
	  $("#pid").val(id);
}
</script>
[/@layout.main]
