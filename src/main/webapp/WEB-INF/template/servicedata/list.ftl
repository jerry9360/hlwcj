[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['dataquery','infocheck']  otherjs=jss sername=['互联网采集数据','业务类型数据查询'] pagename='业务类型数据查询' ]

[#macro sub info]
	[#if info?length>35]
		${info[0..35]}....
	[#else]
		${info}
	[/#if]
[/#macro]
		<form class="form-horizontal" role="form" id="formid" action="${base}/data/servicedata" method="get">
			<table class="table-form">
				<tbody>
					<tr>
						<td style="width:10%;text-align:right;">业务标签</td>
						<td style="width:20%;"><input type="text" id="type" name="type" value="${type }" class="form-control"></td>
						<td style="width:10%;text-align:right;">来源网站</td>
						<td style="width:20%;"><input type="text" id="source" name="source" value="${source }" class="form-control"></td>
						<td style="width:40%;padding-left:20px;">
							<button class="btn btn-sm btn-primary" type="submit">查 询</button>
							<!-- <a class="btn btn-sm btn-primary" onclick="export1(this);">导出Excel</a> -->
						</td> 
					</tr>
				</tbody>
			</table>
		</form>
		<table  class="table table-bordered table-hover">
			<thead>
				<tr>
					<th style="width:5%;text-align:center;">序号 </th>
					<th style="width:30%;">标题</th>
 					<th style="width:10%;">业务标签</th>
					<th style="width:25%;">来源网站</th>
					<th style="width:25%;">网页URL</th>
					<th style="width:5%;">操作</th>
				</tr>
			</thead>
			<tbody>
				[#list page.content as per]
			 	<!-- <input type="hidden" name="corp_id" id="corp_id" value="${corpinfo.corp_id}"> -->
				<tr>
					<td  style="text-align:center;">${pageable.offset + per_index+1}</td>
					<td  style="text-align:left;">${per.title}</td>
 					<td  style="text-align:left;">${per.type}</td>
					<td  style="text-align:left;">${per.source}</td>
					<td  style="text-align:left;"><a href=	"${per.url}" title="${per.url}" target="_blank">[@sub per.url][/@sub]</a></td>
					<td><a class="btn btn-xs btn-success" href="${base}/data/servicedata/detail/${per.id}">查看</a></td>
				</tr>
				[/#list]
			</tbody>
		</table>
		<!-- <div class="modal fade bs-modal-lg in" id="large" tabindex="-1" data-backdrop="static" role="dialog" aria-hidden="false" style="display: none;">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-body">
						<div class="portlet box blue-madison ">
							<div class="portlet-title">
								<div class="caption">
									修改企业简称
								</div>
							</div>
							<div class="portlet-body form">
								<form role="form" action="${base}/corpmgr/corpinfo/editShortname" method="post" id="addrolesform">
									<div class="form-body">
										<div class="form-group" style="text-align:center;">
											<label class="control-label">企业简称</label>
											<input type="hidden" name="corp_id" id="corp_id1" class="form-control" value="">
											<input class="form-control" name="corp_short" id="corp_short1" type="text" style="display:inline-block;width:400px;" value="">
										</div>	
										<div class="form-actions" align="center">
											<button class="btn btn-width-70 btn-primary" type="submit">保 存</button>
											<button class="btn default" type="button" data-dismiss="modal">取 消</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div> -->
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
        </div> 
		[#assign pagepath="${base}/data/servicedata?type=${type}&source=${source}&"]  
		[#include "common/pagemodel.ftl"]
<script>
  function showDiv(obj){
	  var value=$(obj).parent().prev().html();
	  var id=$(obj).parent().parent().prev().val();
	  $("#corp_short1").val(value);
	  $("#corp_id1").val(id);
  }
  /* function export1(ele){
	  if(confirm("确认导出?")) {
			$.ajax({
				type:"get",
				url:base+"/corpmgr/corpinfo/exportExcel",
				dataType:"text",
				beforeSend: function(XMLHttpRequest) {
					 $("#large1").show();
	                },
				success:function(data){
					if(data=="FAIL"){
						alert("导出失败！");
					}else{
						$("#large1").hide();
				 		alert("导出成功！");
				 			window.location.href= base + "/common/file/download?filename=从业企业.xls&filesource=D:/从业企业.xls&index="+data;
					} 
				},
			    complete: function (XMLHttpRequest, textStatus) {
			    	$("#large1").hide();
			    },
				error:function(){
				   alert("报告出错！");
				}
			});
	  }
	} */
</script>

[/@layout.main]