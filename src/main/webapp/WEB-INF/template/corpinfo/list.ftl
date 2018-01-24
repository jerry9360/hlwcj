[#import "common/layout.ftl" as layout] 
[#assign jss=[]]
[#assign css=["assets/css/download.css","assets/css/zhemutanchukuang.css"]] 
[@layout.main modelcode=['corpmgr','basedatamgr'] otherjs=jss othercss=css sername=['基础数据管理','从业企业信息查询'] pagename='从业企业查询']
[#include "common/loading.ftl"] 
		<form class="form-horizontal" role="form" id="formid" action="${base}/corpmgr/corpinfo/list" method="get">
			<table class="table-form">
				<tbody>
					<tr>
						<td style="width:10%;text-align:right;">企业名称</td>
						<td style="width:15%;"><input type="text" id="corp_name" name="corp_name" value="${corp_name }" class="form-control"></td>
						 <!-- <td style="width:10%;text-align:right;">企业简称</td> -->
						<!-- <td style="width:15%;"><input type="text" id="corp_short" name="corp_short" value="${corp_short }" class="form-control"></td> -->
						 
						<td style="width:10%;text-align:right;">所属行业</td>
						<td style="width:15%;">
							<select class="bs-select form-control"id="industry"  name="industry"  >
								<option value="" [#if industry==""] selected[/#if]>全部</option>
								<option value="1" [#if industry=="1"] selected[/#if]>公路建设市场</option>
								<option value="2" [#if industry=="2"] selected[/#if]>水运建设市场</option>
 								<option value="4" [#if industry=="4"] selected[/#if]>道路运输市场</option>
							</select>
						</td>
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
					<th style="width:40%;text-align:center;">企业名称</th>
					<th style="width:25%;text-align:center;">统一社会信用代码</th>
					<th style="width:15%;text-align:center;">所属行业</th>
				<!-- 	<th style="width:15%;text-align:center;">操作</th> -->
				</tr>
			</thead>
			<tbody>
				[#list page.content as corpinfo]
			 	<input type="hidden" name="corp_id" id="corp_id" value="${corpinfo.corp_id}">
				<tr>
					<td  style="text-align:center;">${pageable.offset + corpinfo_index+1}</td>
					<td  style="text-align:left;">${corpinfo.corp_name}</td>
					<td style="text-align:left;">${corpinfo.credit_code}</td>
					<td>
						[#if corpinfo.industry=='1']
							公路建设市场
						[#elseif corpinfo.industry=='2']
							水运建设市场
						[#elseif corpinfo.industry=='4']
							道路运输市场
						[/#if]
					</td>
					<!-- <td><a  class="btn btn-xs btn-primary" onclick='showDiv(this)'  data-toggle="modal" href="#large">修改企业简称</a></td> -->
				</tr>
				[/#list]
			</tbody>
		</table>
		<div class="modal fade bs-modal-lg in" id="large" tabindex="-1" data-backdrop="static" role="dialog" aria-hidden="false" style="display: none;">
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
		</div>
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
		[#assign pagepath="${base}/corpmgr/corpinfo/list/?corp_name=${corp_name}&corp_short=${corp_short}&"]  
		[#include "common/pagemodel.ftl"]
<script>
  function showDiv(obj){
	  var value=$(obj).parent().prev().prev().html();
	  var id=$(obj).parent().parent().prev().val();
	  $("#corp_short1").val(value);
	  $("#corp_id1").val(id);
  }
 
  function exportInfo(){
		var corp_name=$("#corp_name").val();
		var industry=$("#industry").val();
		$("#loadingbg").show();
	    $("#loading").show();
		$.ajax({
			type:"get",
			url:base+"/corpmgr/corpinfo/exportExcel",
			data:{
				corp_name:corp_name,
				industry:industry
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