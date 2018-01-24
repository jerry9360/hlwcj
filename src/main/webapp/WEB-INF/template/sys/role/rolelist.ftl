[#assign jss=[]] 
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['rolemgr','adminmgr'] otherjs=jss sername=['系统管理','角色管理'] pagename='角色管理']
			<a class="btn btn-sm btn-primary" href="#large" data-toggle="modal" onclick='addRole()' style="margin-bottom:10px;">添加角色</a>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th style="text-align:center;">序号</th>
						<th>角色名</th>
						<th>角色编码</th>
						<th>角色描述</th>
						<th>更新时间</th>
						<th>主页面</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				[#list rolelist as role]
					<tr>
						<td style="text-align:center;">${role_index+1}</td>
						<td>${role.rolename }</td>
						<td>${role.rolecode }</td>
						<td>${role.description }</td>
						<td>${(role.modifyDate?string('yyyy-MM-dd HH:mm:ss'))!}</td>
						<td>${role.mainpage }</td>
						<td>
							<input type="hidden" name="createDate" value="${(role.createDate?string('yyyy-MM-dd HH:mm:ss'))!}">
							<input type="hidden" name="id" value="${role.id}">
							<input type="hidden" name="isforbidden" value="${role.isforbidden}"/>
							<a class="btn btn-xs btn-info" data-toggle="modal" onclick='editRole(this)' href="#large">编 辑</a>
							[#if role.isforbidden=="0"]<button class="btn btn-xs btn-danger" onclick="forbidden(this)" value="${role.id}">禁 用</button>
							[#else]<button class="btn btn-xs btn-warning" onclick="restart(this)" value="${role.id}">启 用</button>
							[/#if]
							<a class="btn btn-xs btn-success"  href="${base}/adminmgr/menu/${role.id}/setmenu">业务管理</a>
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
									<div class="caption">
										角色管理
									</div>
								</div>
								<div class="portlet-body form">
									<form class="horizontal-form form" role="form" id="formid" action="${base}/adminmgr/role/save" method="post">
										<input type='hidden' id="id" name="id" value=""/>
										<input type='hidden' id="isforbidden" name="isforbidden" value=""/>
										<input type="hidden" id="createDate" name="createDate" value="">
										<table class="table-form">
											<tbody>
											     <tr>
													<td class="td-center" style="width:30%">角色名</td>
													<td style="width:40%;">
														<input class="form-control" id="rolename" name="rolename" value="">
													</td>
													<td class="td-center" style="width:30%"></td>
												</tr>
												<tr>
													<td class="td-center">角色编码</td>
													<td>
														<input class="form-control" id="rolecode" name="rolecode" value="">
													</td>
													<td></td>
												</tr>
												<tr>
													<td class="td-center">角色描述</td>
													<td>
														<input class="form-control" id="description" name="description" value="">
													</td>
													<td></td>
												</tr>
												<tr>
													<td class="td-center">角色主页</td>
													<td>
														<input class="form-control" id="mainpage" name="mainpage" value="">
													</td>
													<td></td>
												</tr>
											</tbody>
										</table> 
										<div class="form-actions" style="text-align: center;">
											<button class="btn btn-width-70 btn-primary" type="submit" id="submitid">保 存</button>
											<button class="btn default" type="button" data-dismiss="modal">取消</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>				
<script type="text/javascript">
function forbidden(obj){
	$.ajax({
        type: "POST",
        url:"${base}/adminmgr/role/isforbidden/"+obj.value+"/1",
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
        	window.location.href="${base}/adminmgr/role";
        }
    });
}

function restart(obj){
	$.ajax({
        type: "POST",
        url:"${base}/adminmgr/role/isforbidden/"+obj.value+"/0",
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
        	window.location.href="${base}/adminmgr/role";
        }
    });
}
function editRole(obj){
	  var isforbidden=$(obj).prev().val();
	  var id=$(obj).prev().prev().val();
	  var createDate=$(obj).prev().prev().prev().val();
	  var rolename=$(obj).parent().siblings().eq(1).html();
	  var rolecode=$(obj).parent().siblings().eq(2).html();
	  var description=$(obj).parent().siblings().eq(3).html();
	  var modifyDate=$(obj).parent().siblings().eq(4).html();
	  var mainpage=$(obj).parent().siblings().eq(5).html();
	  $("#isforbidden").val(isforbidden);
	  $("#id").val(id);
	  $("#rolename").val(rolename);
	  $("#rolecode").val(rolecode);
	  $("#description").val(description);
	  $("#modifyDate").val(modifyDate);
	  $("#mainpage").val(mainpage);
	  $("#createDate").val(createDate);
	  //$(".caption").html("编辑角色");
}
function addRole(){
	  //$(".caption").html("添加角色");
	  $("#isforbidden").val(0);
}
</script>
[/@layout.main]