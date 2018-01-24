[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main
modelcode=['sysmanager','usermgr'] otherjs=jss sername=['系统管理','用户管理']]

<div class="portlet box blue">
	<div class="portlet-title">
		<div class="caption">用户管理</div>
	</div>
	<div class="portlet-body">
						<div id="errorMessage" class="alert alert-block alert-success" style="display: none"></div>
					<form class="horizontal-form form" user="form" id="formid" action="${base}/adminmgr/userInfo/save" method="post">
						<input type='hidden' id="id" name="id" value="${user.id}"/>
						<input type='hidden' id="isvaild" name="isvaild" value="[#if user.isvaild==null||user.isvaild=='']0[#else]${user.isvaild}[/#if]"/>
						<table class="table-form">
							<tbody>
							     <tr>
									<td class="td-center" style="width:30%">姓名</td>
									<td style="width:40%;">
										<input class="form-control" id="username" name="username" value="${user.username }">
									</td>
									<td class="td-center" style="width:30%"></td>
								</tr>
								<tr>
									<td class="td-center">性别</td>
									<td>
										<input class="form-control" id="sex" name="sex" value="${user.sex }">
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="td-center">联系方式</td>
									<td>
										<input class="form-control" id="linkphone" name="linkphone" value="${user.linkphone}">
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="td-center">邮箱</td>
									<td>
										<input class="form-control" id="email" name="email" value="${user.email}">
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="td-center">登录名</td>
									<td>
										<input class="form-control" id="loginname" name="loginname" value="${user.loginname}">
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="td-center">密码</td>
									<td>
										<input class="form-control" id="password" name="password" value="${user.password }">
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="td-center">密钥</td>
									<td>
										<input class="form-control" id="salt" name="salt" value="${user.salt }">
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
