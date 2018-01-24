<div class="modal fade bs-modal-lg in" id="changepasswdid" tabindex="-1" role="dialog" data-backdrop="static" aria-hidden="false" style="display: none;">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-body">
				<div class="portlet box blue-madison ">
					<div class="portlet-title">
						<div class="caption">
							修改密码
						</div>
					</div>
					<div class="portlet-body form">
						<form id="changepwdformid">
							<table class="table-form">
								<tbody>
									<tr>
										<td class="td-center" style="width:35%">请输入原密码</td>
										<td style="width:35%"><input type="password" id="oldpassage" value="${oldpassage }" class="form-control"></td>
										<td class="td-center" style="width:30%"></td>
									</tr>
									<tr>
										<td class="td-center" style="width:35%">请输入新密码</td>
										<td style="width:35%"><input type="password" id="passage" 
												value="${passage }" class="form-control"></td>
										<td class="td-center" style="width:30%"></td>
									</tr>
									<tr>
										<td class="td-center" style="width:35%">请确认新密码</td>
										<td style="width:35%"><input type="password" id="conpassage" 
												value="${conpassage }" class="form-control"></td>
										<td class="td-center" style="width:30%"></td>
									</tr>
								</tbody>
							</table>	
						</form>																							
						<div class="form-actions" style="text-align: center;">
							<button class="btn btn-width-70 btn-primary" type="button" onclick="changePwd()">保 存</button>
							<button class="btn default" type="button" data-dismiss="modal">取消</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>	
<script type="text/javascript">
function openChangepwd(){
	$("#changepasswdid").click();
	$("#oldpassage").val("");
	$("#passage").val("");
	$("#conpassage").val("");
}
function changePwd(){
	var oldpassage = $("#oldpassage").val();
	var passage = $("#passage").val();
	var conpassage = $("#conpassage").val();
	if(oldpassage==""||oldpassage==undefined){
		alert("请输入原密码！");
		return;
	}
	if(passage==""||oldpassage==undefined){
		alert("请输入新密码！");
		return;
	}
	if(conpassage==""||conpassage==undefined){
		alert("请再次输入新密码！");
		return;
	}
	if(passage!=conpassage){
		alert("新密码两次输入不一致！");
		return;
	}
	$.ajax({
		type:"post",
		data:$("#changepwdformid").serialize(),
		url:base+"/pwdmgr/changepwd",
		dataType:"text",
		async:false,
		success:function(data){
			if(data=="OK"){
				alert("修改成功！");
				window.location.href = base + "/logout";
			}else{
				if(data=="erroroldpwd"){
					$("#oldpassage").val("");
					alert("原密码输入错误，请重新输入！");
				}else if(data=="noOldpwd"){
					alert("请输入原密码！");
				}else if(data=="noNewpwd"){
					alert("请输入新密码！");
				}else if(data=="noConpwd"){
					alert("请再次输入新密码！");
				}else if(data=="noConpwd"){
					alert("请再次输入新密码！");
				}else if(data=="notequal"){
					$("#conpassage").val("");
					alert("新密码两次输入不一致！");
				}else if(data=="equalpwd"){
					$("#conpassage").val("");
					$("#passage").val("");
					alert("新密码不能和原密码相等！");
				}
			} 
		},
		error:function(){
			alert("修改失败！");
		}
	});
}
</script>