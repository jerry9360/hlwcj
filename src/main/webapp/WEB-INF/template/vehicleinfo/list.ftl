[#import "common/layout.ftl" as layout] 
[#assign jss=[]]
[#assign css=["assets/css/download.css","assets/css/zhemutanchukuang.css"]] 
[@layout.main modelcode=['vehiclemgr','basedatamgr'] otherjs=jss othercss=css sername=['基础数据管理','车辆信息查询'] pagename='从业企业查询']
[#include "common/loading.ftl"] 
		<form class="form-horizontal" role="form" id="formid" action="${base}/vehiclemgr/vehicleinfo/list" method="get">
			<table class="table-form">
				<tbody>
					<tr>
						<td style="width:10%;text-align:right;">车牌号</td>
						<td style="width:15%;"><input type="text" id="vehicle_no" name="vehicle_no" value="${vehicle_no }" class="form-control"></td>
						<td style="width:10%;text-align:right;">企业名称</td>
						<td style="width:15%;"><input type="text" id="corp_name" name="corp_name" value="${corp_name }" class="form-control"></td>
 
						<td style="width:25%;padding-left:20px;">
							<button class="btn btn-sm btn-primary" type="submit">查 询</button>
							<a class="btn btn-sm btn-primary" onclick="exportInfo();">导出Excel</a>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<table  class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th style="width:5%;text-align:center;">序号 </th>
					<th style="width:15%;text-align:center;">车牌号</th>
					<th style="width:15%;text-align:center;">车牌颜色</th>
					<th style="width:65%;text-align:center;">企业名称</th>
				</tr>
			</thead>
			<tbody>
				[#list page.content as info]
				<tr>
					<td  style="text-align:center;">${pageable.offset + info_index+1}</td>
					<td  style="text-align:left;">${info.vehicle_no}</td>
					<td style="text-align:left;">${info.plate_color_name}</td>
					<td style="text-align:left;">${info.corp_name}</td>
				</tr>
				[/#list]
			</tbody>
		</table>

  		<div id=large1 class="modal fade bs-modal-lg in" style="display:none;" tabindex="-1" data-backdrop="static" role="dialog" aria-hidden="false">  
            <div class="massage">  
                <div class="header" >  
                    <div style="display: inline; width: 150px; position: absolute">  
                    	    正在加载中 ... ...  
                    </div>  
                </div>  
                <div  
                    style="margin-top: 20px; margin-left: 20px; width: 128px; height: 128px; float: left;">  
                    <img src="${base}/assets/img/down.gif" />  
                </div>  
                <div  
                    style="margin-top: 50px; width: 136px; height: 128px; float: right;">  
                		    查询请求已发送  
                    <br/>  
                  		  等待返回查询结果  
                </div>  
            </div>  
        </div>  
		[#assign pagepath="${base}/vehiclemgr/vehicleinfo/list?corp_name=${corp_name}&vehicle_no=${vehicle_no}&"]  
		[#include "common/pagemodel.ftl"]
<script>
		  function exportInfo(){
				var corp_name=$("#corp_name").val();
				$("#loadingbg").show();
			    $("#loading").show();
				$.ajax({
					type:"get",
					url:base+"/vehiclemgr/vehicleinfo/exportExcel",
					data:{
						corp_name:corp_name
					},
					dataType:"text",
					success:function(data){
						$("#loadingbg").hide();
					    $("#loading").hide();
						 window.location.href =base+"/doc/"+data;
					},
					error:function(){
					   alert("报告出错！");
					   $("#loadingbg").hide();
					    $("#loading").hide();
					}
				});
			}
</script>

[/@layout.main]