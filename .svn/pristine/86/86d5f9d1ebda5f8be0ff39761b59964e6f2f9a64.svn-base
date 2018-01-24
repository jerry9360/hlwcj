[#import "common/layout.ftl" as layout] 
[#assign jss=[]] 
[@layout.main modelcode=['hnii_analyze','infocheck'] otherjs=jss sername=['数据查询','96096工单数据'] pagename='96096工单数据']
<button class="btn btn-sm btn-primary" type="button" onclick="window.history.go(-1)">返 回</button>
<table class="table table-bordered dataTable no-footer">
	<tbody>
		<tr> <td class="old" width="10%" style="text-align:right;">业务大类</td><td>${object.btype}</td> </tr>
		<tr> <td class="old" style="text-align:right;">业务小类</td><td>${object.stype}</td> </tr>
	    <tr> <td class="old" style="text-align:right;">行业类别</td><td>${object.industry}</td> </tr>
		<tr> <td class="old" style="text-align:right;">主体对象</td><td>${object.object}</td> </tr>
		<tr> <td class="old" style="text-align:right;">主体对象名称</td><td>${object.objectname}</td> </tr>
		<tr> <td class="old" style="text-align:right;">工单流水号   </td><td>${object.myid}</td> </tr>
		<tr> <td class="old" style="text-align:right;">来电时间</td><td>${object.calltime?string("yyyy-MM-dd HH:mm:ss")}</td> </tr>
		<tr> <td class="old" style="text-align:right;">责任单位</td><td>${object.unit}</td> </tr>
		<tr> <td class="old" style="text-align:right;">办理意见</td><td>${object.dealopinion}</td> </tr>
		<tr> <td class="old" style="text-align:right;">车牌号</td><td>${object.carno}</td> </tr>
		<tr> <td class="old" style="text-align:right;">线路号</td><td>${object.lineno}</td> </tr>
		<tr> <td class="old" style="text-align:right;">事发时间</td><td>${object.time}</td> </tr>
		<tr> <td class="old" style="text-align:right;">事发起点</td><td>${object.baddress}</td> </tr>
		<tr> <td class="old" style="text-align:right;">事发终点</td><td>${object.eaddress}</td> </tr>
		<tr> <td class="old" style="text-align:right;">工单内容</td><td>${object.content}</td> </tr>
	</tbody>
</table>
[/@layout.main]
