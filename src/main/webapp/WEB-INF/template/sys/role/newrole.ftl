[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main
modelcode=['sysmanager','rolemgr'] otherjs=jss sername=['系统管理','角色管理']]

<div class="portlet box blue">
	<div class="portlet-title">
		<div class="caption">角色管理</div>
	</div>
	<div class="portlet-body">
						<div id="errorMessage" class="alert alert-block alert-success" style="display: none"></div>
					<form class="horizontal-form form" role="form" id="formid" action="${base}/adminmgr/role/save" method="post">
						<input type='hidden' id="id" name="id" value="${role.id}"/>
						<input type='hidden' id="isforbidden" name="isforbidden" value="${role.isforbidden}"/>
						<table class="table-form">
							<tbody>
							     <tr>
									<td class="td-center" style="width:30%">角色名</td>
									<td style="width:40%;">
										<input class="form-control" id="rolename" name="rolename" value="${role.rolename }">
									</td>
									<td class="td-center" style="width:30%"></td>
								</tr>
								<tr>
									<td class="td-center">角色编码</td>
									<td>
										<input class="form-control" id="rolecode" name="rolecode" value="${role.rolecode }">
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="td-center">角色描述</td>
									<td>
										<input class="form-control" id="description" name="description" value="${role.description }">
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="td-center">角色主页</td>
									<td>
										<input class="form-control" id="mainpage" name="mainpage" value="${role.mainpage }">
									</td>
									<td></td>
								</tr>
							</tbody>
						</table> 
						<div class="form-actions" style="text-align: center;">
							<button class="btn btn-width-70 btn-primary" type="submit" id="submitid">保 存</button>
							<button class="btn btn-width-70 btn-primary" type="button" onclick="history.go(-1)">取 消</button>
						</div>
					</form>
	</div>
</div>
[/@layout.main]
