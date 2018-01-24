[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['cleanorgbad','netdataclean']  otherjs=jss sername=['互联网采集数据清洗','行业局不良信息'] pagename='行业局不良信息' ]
	<div class="col-md-12" style="padding-left:0px;padding-right:0px;">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box blue-madison">
			<div class="portlet-title">
				<div class="caption"><a style="color:white;" href="${base}/org/orgbadinfo"  >行业局不良信息</a></div>
			</div>
			<div class="portlet-body">
				<div class="sdataTables_wrapper no-footer">
					<form class="horizontal-form form" method="post">
						<table class="table table-bordered dataTable no-footer">
							<tbody>
								<tr>
								<td class="old" width="10%" style="text-align:right;">名称</td><td width="90%">${orgbadinfo.orgname}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">类别</td><td>${orgbadinfo.type}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">标题</td><td>${orgbadinfo.title}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">发布单位</td><td>${orgbadinfo.issueunit}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">发布时间</td><td>${orgbadinfo.issuedate}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">来源网站</td><td>${orgbadinfo.source}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">网页URL</td><td><a href="${orgbadinfo.url}" target="_blank">${orgbadinfo.url}</a></td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">网页内容</td><td>${orgbadinfo.content}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">可信度</td>
								[#if orgbadinfo.credit=='0']	
								<td>可信度低</td>
								[#else]
								<td>可信度高</td>
								[/#if]
								</tr>
								<tr>
								<td class="old" style="text-align:right;">附件</td>
								<td>
									[#if orgbadinfo.files??]
										[#list orgbadinfo.files as f]
											<a href="${base}/common/file/load?filename=${f}" target="_blank" title="${f}">${f}</a><br/>
										[/#list]
									[/#if] 
								</tr>	
							</tbody>
						</table>
						<div class="form-actions" style="text-align: center;">
							<button class="btn btn-width-70 btn-primary" type="button" onclick="dealCreditServiceData('${orgbadinfo.id}','1')">通过</button>
							<button class="btn btn-width-70 btn-primary" type="button" onclick="dealCreditServiceData('${orgbadinfo.id}','2')">不通过</button>
							<button class="btn btn-width-70 btn-primary" type="button" onclick="window.history.go(-1)">返回</button>
						</div>
						</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var dealCreditServiceData = function(id,state){
			$.ajax({
				type:"POST",
				url:base + "/org/orgbadinfo/dear/" + id,
				data:{
					state:state
				},
				dataType:"text",
				success:function(data){
					if(data=="success"){
						alert("数据保存成功！");
						window.location.href = base + "/org/orgbadinfo/clear";
					}else if(data=="error"){
						alert("数据保存失败！");
					}
				},
				error:function(){
					alert("数据保存失败！");
				}
			});
		}
	</script>
[/@layout.main]
