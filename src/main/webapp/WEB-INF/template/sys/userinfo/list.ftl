[#assign jss=[]] 
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['userInfomgr','adminmgr'] otherjs=jss sername=['系统管理','用户管理'] pagename='用户管理']
			<a class="btn btn-sm btn-primary" href="#large" data-toggle="modal" style="margin-bottom:10px;" onclick="addUser()">添加用户</a>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th style="text-align:center;">序号</th>
						<th>用户名</th>
						<th>性别</th>
						<th>联系方式</th>
						<th>邮箱</th>
						<th>登录名</th>
						<th>创建时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				[#list list as userInfo]
					<tr>
						<td style="text-align:center;">${userInfo_index+1}</td>
						<td>${userInfo.username }</td>
						<td>${userInfo.sex }</td>
						<td>${userInfo.linkphone }</td>
						<td>${userInfo.email }</td>
						<td>${userInfo.loginname }</td>
						<td>${(userInfo.createDate?string('yyyy-MM-dd HH:mm:ss'))!}</td>
						<td>
							<input type="hidden" name="password" value="${userInfo.password}">
							<input type="hidden" name="salt" value="${userInfo.salt}">
							<input type="hidden" name="id" value="${userInfo.id}">
							<input type="hidden" name="isvaild" value="${userInfo.isvaild}"/>
							<a class="btn btn-xs btn-info"  href="#large" onclick="editUser(this)" data-toggle="modal">编 辑</a>
							[#if userInfo.isvaild=="0"]<button class="btn btn-xs btn-danger" onclick="forbidden(this)" value="${userInfo.id}">禁 用</button>
							[#else]<button class="btn btn-xs btn-warning" onclick="restart(this)" value="${userInfo.id}">启 用</button>
							[/#if]
							<a class="btn btn-xs btn-success" href="${base}/adminmgr/userInfo/${userInfo.id}/initial" >密码初始化</a>
						</td>
					</tr>
					[/#list]
				</tbody>
			</table>
			<div class="modal fade bs-modal-lg in" id="large" tabindex="-1" data-backdrop="static" role="dialog" aria-hidden="false" style="display: none;">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-body">
						<div class="portlet box blue-madison ">
							<div class="portlet-title">
								<div class="caption" id="caption">
									用户管理
								</div>
							</div>
							<div class="portlet-body form">
							
							
					<form class="horizontal-form form" user="form" id="formid"  >
						<input type="hidden" id="password" name="password" value="">
						<input type="hidden" id="salt" name="salt" value="">
						<input type='hidden' id="id" name="id" value=""/>
						<input type='hidden' id="createDate" name="createDate" value=""/>
						<input type='hidden' id="isvaild" name="isvaild" value="[#if user.isvaild==null||user.isvaild=='']0[#else]${user.isvaild}[/#if]"/>
						<table class="table-form">
							<tbody>
							     <tr>
									<td class="td-center" style="width:30%">姓名</td>
									<td style="width:40%;">
										<input class="form-control" id="username" name="username" value="">
									</td>
									<td class="td-center" style="width:30%"></td>
								</tr>
								<tr>
									<td class="td-center">性别</td>
									<td>
										<input class="form-control" id="sex" name="sex" value="">
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="td-center">联系方式</td>
									<td>
										<input class="form-control" id="linkphone" name="linkphone" value="">
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="td-center">邮箱</td>
									<td>
										<input class="form-control" id="email" name="email" value="">
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="td-center">登录名</td>
									<td>
										<input class="form-control" id="loginname" name="loginname" value="">
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

<script type="text/javascript">
var saveform=function(){
	 var sex = document.getElementById("sex").value.trim();
    var label_namedesc = document.getElementById("loginname").value.trim();
    var type = document.getElementById("email").value.trim();
    var datasource = document.getElementById("linkphone").value.trim();
    var reg = /^1[34578][0-9]{9}/;
    var re= /^0[0-9]{2,3}-?[0-9]{8}/;  
    var reg1 = /[a-zA-Z0-9]{1,10}@[a-zA-Z0-9]{1,5}\.[a-zA-Z0-9]{1,5}/;
    if(sex!='男'&&sex!='女')  {
    	alert("请正确的性别");
    }
     else if(!reg.test(datasource)&&!re.test(datasource)){
            alert("请正确填写联系方式");
     }else if(!reg1.test(type)){
        alert("请正确邮箱地址");
	 } else if(label_namedesc=="" ){
			alert("登录名为必填项!");
	}else {
		save();
	}
	
}
var save=function(){
	$.ajax({
		type:"post",
		url:base+"/adminmgr/userInfo/save",
		data:$("#formid").serialize(),
		async:false,  
		success:function(data){
			if(data=="SUCCESS"){
				alert("保存成功！");
                window.location.href=base + "/adminmgr/userInfo";
			}else{
				alert("保存失败！");
			}
		},
		error:function(){
			 alert("数据加载失败");
		}
	});
}
function forbidden(obj){
	$.ajax({
        type: "POST",
        url:"${base}/adminmgr/userInfo/isVaild/"+obj.value+"/1",
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
        	window.location.href="${base}/adminmgr/userInfo";
        }
    });
}

function restart(obj){
	$.ajax({
        type: "POST",
        url:"${base}/adminmgr/userInfo/isVaild/"+obj.value+"/0",
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
        	window.location.href="${base}/adminmgr/userInfo";
        }
    });
}
function editUser(obj){
	  var isvaild=$(obj).prev().val();
	  var id=$(obj).prev().prev().val();
	  var password=$(obj).siblings().eq(0).val();
	  var salt=$(obj).siblings().eq(1).val();
	  var username=$(obj).parent().siblings().eq(1).html();
	  var sex=$(obj).parent().siblings().eq(2).html();
	  var linkphone=$(obj).parent().siblings().eq(3).html();
	  var email=$(obj).parent().siblings().eq(4).html();
	  var loginname=$(obj).parent().siblings().eq(5).html();
	  var createDate=$(obj).parent().siblings().eq(6).html();
	  $("#isvaild").val(isvaild);
	  $("#id").val(id);
	  $("#password").val(password);
	  $("#salt").val(salt);	  
	  $("#username").val(username);
	  $("#sex").val(sex);
	  $("#linkphone").val(linkphone);
	  $("#email").val(email);
	  $("#loginname").val(loginname);
	  $("#createDate").val(createDate);
	  //$(".caption").html("编辑用户");
}
function addUser(){
	  //$(".caption").html("添加用户");
	  $("#isvaild").val(0);
}
</script>
[/@layout.main]