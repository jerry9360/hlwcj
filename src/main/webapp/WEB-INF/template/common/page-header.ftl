<div class="page-header navbar navbar-fixed-top">
	<div class="page-header-inner">
		<!-- BEGIN LOGO -->
		<div class="page-logo">
			<a style="text-decoration:none;"href="${base }/index">
				<span style="font-size:22px;color:white;font-weight:600;"><img class="logo-default" alt="logo" style="margin:0px 0px 5px 0px;" src="${base}/assets/img/logo.png">
					[#if userinfo.index =='maintain']
						重庆市交通行业互联网信用数据采集运维平台
					[#elseif userinfo.index =='service']
						重庆市交通行业互联网信用数据采集运维平台
					[#elseif userinfo.index =='analyze']
						重庆市交通行业互联网信用数据采集运维平台
					[/#if]
				</span>
			</a>
		</div>
		<div class="top-menu">
			<ul class="nav navbar-nav pull-right">
				<li class="dropdown dropdown-user" id="commonuserinfoid">
					<a id="user_dropdown" name="user_dropdown" data-close-others="true" data-hover="dropdown" data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0)" style="color: white;">
						<i class="fa fa-user"></i> ${userinfo.username}&nbsp;&nbsp;<i class="fa fa-angle-down"></i>
					</a>
					<ul id="user_dropdown-menu" name="user_dropdown-menu" class="dropdown-menu">
						<li>
							<a href="${base}/pwdmgr/changepwd" data-toggle="modal">修改密码</a>
						</li>
						<li>
							<a href="/" data-toggle="modal">运维平台</a>
						</li>
						<li>
							<a href="${base}/index-maintain" data-toggle="modal">数据处理</a>
						</li>
						<li>
							<a href="${base}/index-analyze" data-toggle="modal">数据分析</a>
						</li>
						<li>
							<a href="${base}/index-service" data-toggle="modal">数据服务</a>
						</li>
						<li>
							<a href="${base}/logout">退出 </a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		$("#user_dropdown").bind("mousedown",function(){
			$("#user_dropdown-menu").toggle();
		});
		$(document).click(function(){
		    $("#user_dropdown-menu").hide();
		});
	});
</script>