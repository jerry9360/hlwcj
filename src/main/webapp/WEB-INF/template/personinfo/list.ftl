[#assign jss=[]] 
[#import "common/layout.ftl" as layout] 
[#assign css=["assets/css/download.css","assets/css/zhemutanchukuang.css"]] 
[@layout.main modelcode=['permgr','basedatamgr'] otherjs=jss othercss=css sername=['基础数据管理','从业人员信息查询'] pagename='从业人员查询']
[#include "common/loading.ftl"] 
<form class="form-horizontal" role="form" id="formid" action="${base}/permgr/personinfo/list" method="get">
	<table class="table-form">
		<tbody>
			<tr>
				<td style="width:10%;text-align:right;">姓名</td>
				<td style="width:15%;"><input type="text" id="name" name="name" value="${name }" class="form-control"></td>
				<td style="width:10%;text-align:right;">身份证号</td>
				<td style="width:15%;"><input type="text" id="card_no" name="card_no" value="${card_no }" class="form-control"></td>
				<td style="width:10%;text-align:right;">所属行业</td>
				<td style="width:15%;">
				<select class="bs-select form-control" id="industry"  name="industry"  >
					<option value="" [#if industry==""] selected[/#if]>全部</option>
					<option value="1" [#if industry=="1"] selected[/#if]>公路建设市场</option>
					<option value="2" [#if industry=="2"] selected[/#if]>水运建设市场</option>
						<option value="4" [#if industry=="4"] selected[/#if]>道路运输市场</option>
				</select>
				</td>
				<td style="width:25%;padding-left:20px;">
					<button class="btn btn-sm btn-primary" type="submit">查 询</button>
					<a class="btn btn-sm btn-primary" onclick="exportInfo();">导出Excel</a>
					<p id="uploadresult" style="margin-bottom: 0px;"></p>
				</td>
			</tr>
		</tbody>
	</table>
</form>
<table class="table  table-bordered table-hover">
	<thead>
		<tr>
			<th style="width:5%;text-align:center;">序号 </th>
			<th style="width:30%;text-align:center;">姓名</th>
			<th style="width:40%;text-align:center;">身份证号</th>
			<th style="width:10%;text-align:center;">性别</th>
			<th style="width:15%;text-align:center;">所属行业</th>
		</tr>
	</thead>
	<tbody>
	[#list page.content as personinfo]
		<tr>
			<td  style="text-align:center;">${pageable.offset + personinfo_index+1}</td>
			<td style="text-align:left;">${personinfo.name }</td>
			<td style="text-align:left;">${personinfo.card_no }</td>
			<td style="text-align:left;">${personinfo.sex }</td>
			<td style="text-align:left;">
			[#if corpinfo.industry=='1']
				公路建设市场
			[#elseif corpinfo.industry=='2']
				水运建设市场
			[#elseif corpinfo.industry=='4']
				道路运输市场
			[/#if]
			</td>
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
[#assign pagepath="${base}/permgr/personinfo/list/?name=${name}&card_no=${card_no}&"]  
[#include "common/pagemodel.ftl"]
<script type="text/javascript">
function exportInfo(){
	var name=$("#name").val();
	var card_no=$("#card_no").val();
	var industry=$("#industry").val();
	$("#loadingbg").show();
    $("#loading").show();
	$.ajax({
		type:"get",
		url:base+"/permgr/personinfo/exportExcel",
		data:{
			name:name,
			card_no:card_no,
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