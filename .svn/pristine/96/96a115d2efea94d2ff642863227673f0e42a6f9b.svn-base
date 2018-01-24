[#import "common/layout.ftl" as layout] 
[#assign jss=["assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"]] 
[@layout.main modelcode=['hniiquery_label_${servicecode}','96096_label'] otherjs=jss sername=['96096标注数据','${service}信息'] pagename='${service}信息查询']
<button class="btn btn-sm btn-primary" type="button" onclick="window.history.go(-1)">返 回</button>
				[#if servicecode=="complaint"]	
					<table class="table table-bordered dataTable no-footer">
						<tbody>
						    <tr> <td class="old"  width="10%" style="text-align:right;">行业类别</td><td>${object.industry}</td> </tr>
 							<tr> <td class="old"  width="10%" style="text-align:right;">主体对象</td><td>${object.object}</td> </tr>
 							<tr> <td class="old"  width="10%" style="text-align:right;">主体对象名称</td><td>${object.objectname}</td> </tr>
							<tr> <td class="old" style="text-align:right;">业务大类</td><td>${service}</td> </tr>
							<tr> <td class="old" style="text-align:right;">业务小类</td><td>${object.servicetype}</td> </tr>
							<tr> <td class="old" style="text-align:right;">工单流水号   </td><td>${object.myid}</td> </tr>
							<tr> <td class="old" style="text-align:right;">事发时间</td><td>${object.time}</td> </tr>
							<tr> <td class="old" style="text-align:right;">事发起点</td><td>${object.baddress}</td> </tr>
							<tr> <td class="old" style="text-align:right;">事发终点</td><td>${object.eaddress}</td> </tr>
 							<!--  <tr> <td class="old" style="text-align:right;">受理状态</td><td>${object.dealresult}</td> </tr>-->
							<tr> <td class="old" style="text-align:right;">受理单位</td><td>${object.unit}</td> </tr>
							<tr> <td class="old"  width="10%" style="text-align:right;">车牌号</td><td>${object.carno}</td> </tr>
 							<tr> <td class="old" style="text-align:right;">工单内容</td><td>${object.content}</td> </tr>
						</tbody>
					</table>
			    [#elseif servicecode=="prise"]
				    <table class="table table-bordered dataTable no-footer">
							<tbody>
							    <tr> <td class="old"  width="10%" style="text-align:right;">行业类别</td><td>${object.industry}</td> </tr>
	 							<tr> <td class="old"  width="10%" style="text-align:right;">主体对象</td><td>${object.object}</td> </tr>
	 							<tr> <td class="old"  width="10%" style="text-align:right;">主体对象名称</td><td>${object.objectname}</td> </tr>
								<tr> <td class="old" style="text-align:right;">业务大类</td><td>${service}</td> </tr>
								<tr> <td class="old" style="text-align:right;">业务小类</td><td>${object.servicetype}</td> </tr>
								<tr> <td class="old" style="text-align:right;">工单流水号   </td><td>${object.myid}</td> </tr>
	 							<!-- <tr> <td class="old" style="text-align:right;">受理状态</td><td>${object.dealresult}</td> </tr> -->
								<tr> <td class="old" style="text-align:right;">受理单位</td><td>${object.unit}</td> </tr>
								<tr> <td class="old"  width="10%" style="text-align:right;">车牌号</td><td>${object.carno}</td> </tr>
	 							<tr> <td class="old" style="text-align:right;">工单内容</td><td>${object.content}</td> </tr>
							</tbody>
						</table>
				[#else]
				    <table class="table table-bordered dataTable no-footer">
							<tbody>
								<tr> <td class="old"  width="10%" style="text-align:right;">行业类别</td><td>${object.industry}</td> </tr>
								<tr> <td class="old" style="text-align:right;">业务大类</td><td>${service}</td> </tr>
								<tr> <td class="old" style="text-align:right;">业务小类</td><td>${object.servicetype}</td> </tr>
								<tr> <td class="old" style="text-align:right;">工单流水号   </td><td>${object.myid}</td> </tr>
	 							<!-- <tr> <td class="old" style="text-align:right;">受理状态</td><td>${object.dealresult}</td> </tr> -->
								<tr> <td class="old" style="text-align:right;">受理单位</td><td>${object.unit}</td> </tr>
								<tr> <td class="old"  width="10%" style="text-align:right;">车牌号</td><td>${object.carno}</td> </tr>
	 							<tr> <td class="old" style="text-align:right;">工单内容</td><td>${object.content}</td> </tr>
							</tbody>
						</table>
				[/#if]
[/@layout.main]
