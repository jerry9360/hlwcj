[#import "common/layout.ftl" as layout] 
[#assign jss=["assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"]] 
 [@layout.main modelcode=['hniiquery_${ctypecode}_${servicecode}','96096_${ctypecode}'] otherjs=jss sername=['96096${ctype}数据','${service}信息'] pagename='${service}信息查询']
<button class="btn btn-sm btn-primary" type="button" onclick="window.history.go(-1)">返 回</button>
					<table class="table table-bordered dataTable no-footer">
						<tbody>
 							<tr> <td class="old"  width="10%" style="text-align:right;">分析对象</td><td>${hniiservicedata.ctype}</td> </tr>
							<tr> <td class="old" style="text-align:right;">业务大类</td><td>${hniiservicedata.service}</td> </tr>
							<tr> <td class="old" style="text-align:right;">业务小类</td><td>${hniiservicedata.type}</td> </tr>
							<tr> <td class="old" style="text-align:right;">车牌号   </td><td>${hniiservicedata.cnum}</td> </tr>
							[#if servicecode=="complaint"]
							<tr> <td class="old" style="text-align:right;">事发时间</td><td>${(hniiservicedata.time?string('yyyy-MM-dd HH:mm:ss'))!}</td> </tr>
							<tr> <td class="old" style="text-align:right;">事发地点</td><td>${hniiservicedata.address}</td> </tr>
							<tr> <td class="old" style="text-align:right;">事发起点</td><td>${hniiservicedata.baddress}</td> </tr>
							<tr> <td class="old" style="text-align:right;">事发终点</td><td>${hniiservicedata.eaddress}</td> </tr>
							[/#if]
 							<tr> <td class="old" style="text-align:right;">受理状态</td><td>${hniiservicedata.state}</td> </tr>
							<tr> <td class="old" style="text-align:right;">受理单位</td><td>${hniiservicedata.unit}</td> </tr>
 							<tr> <td class="old" style="text-align:right;">工单内容</td><td>${hniiservicedata.content}</td> </tr>
						</tbody>
					</table>

[/@layout.main]
