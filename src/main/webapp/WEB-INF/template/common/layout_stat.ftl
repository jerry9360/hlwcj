[#macro main modelcode breads otherjs othercss sername pagename]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN" class="no-js">
	<head>
		<title>重庆市交通行业互联网信用数据采集与服务运维系统</title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
		<meta name="keywords" content="重庆市交通行业互联网信用数据采集与服务运维系统" />
		<meta name="description" content="重庆市交通行业互联网信用数据采集与服务运维系统" />
		<link rel="shortcut icon" href="${base}/assets/img/favicon.ico" type="image/x-icon">
		[#include "common/css_global.ftl"]
		[#include "common/css_theme.ftl"]
		[#include "common/css_page.ftl"]
		<link rel="stylesheet" href="${base}/assets/css/centit.css" />
		[#list othercss as map]
		  <link href="${base}/${map}" rel="stylesheet" type="text/css">
		[/#list] 
		<script src="${base}/assets/global/plugins/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script type="text/javascript">
			 var base = '${base}';
		</script>
		<style>
			.page_adapt{padding-left:0px;padding-right:0px;}
			.form_padding{padding:1px;}
			.input_bottom{border-left: 0px;border-right: 0px;border-top: 0px;padding-bottom: 0px;}
		</style>
	</head>
	<body class="page-header-fixed page-quick-sidebar-over-content page-full-width">
		 [#include "common/page-header.ftl"]
		<div class="page-container">
			<div class="page-content inbox">
			<!-- [#include "common/page-left.ftl"]  -->	
				<div class="content-body-stat">
						<script type="text/javascript">
							$(".content-body").css("min-height",$(window).height()-79);
						</script>
						<!-- 
					[#if modelcode[0]!='home']
					<div class="page-bar">
						<ul class="page-breadcrumb">
							<li>
								<i class="fa fa-home"></i>
								<a href="${base}/index">主页</a>
								[#list sername as name]
									<i class="fa fa-angle-right"></i>
									<a href="${base }">${name}</a>
								[/#list]
							</li>
							[#list breads as bread]
								<li>
									<a href="${base }/${bread[0]}">${bread[1]}</a><i class="fa fa-angle-right"></i>
								</li>
							[/#list]
						</ul>
					</div>
					[/#if]
					 -->
					<div>
						[#nested/]
					</div>
				</div>
			</div>
			[#include "common/bottom.ftl"]
		</div>
	</body>
	<!-- 解决ie9以下浏览器兼容性问题   -->
	<script src="${base}/assets/global/plugins/respond.min.js"></script>
	<script src="${base}/assets/global/plugins/excanvas.min.js"></script>
	<script src="${base}/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${base}/assets/js/common/webuploader/webuploader.js" type="text/javascript"></script>
	[#list otherjs as map]
			<script src="${base}/${map}" type="text/javascript"></script>
	[/#list] 
	 <script src="${base}/assets/js/util/Centitutil.js" type="text/javascript"></script>
	 <script src="${base}/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</html>
[/#macro]
