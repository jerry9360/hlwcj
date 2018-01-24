[#import "common/layout.ftl" as layout] 
[#assign jss=["assets/js/date-time/bootstrap-datetimepicker.min.js"]] 
[#assign css=["assets/css/zhemutanchukuang.css","assets/css/datetimepicker.css"]]
[@layout.main  modelcode=['fx_dangan' ]   otherjs=jss othercss=css  ]
[#include "common/loading.ftl"] 
 <div class="col-xs-12 search-info">
	<div class="widget-box">
 		<div class="widget-body">
			<div class="row rowp">
				<div class="col-xs-12">
					<div class="table-responsive">
		<form class="form-horizontal" role="form" id="formid" action="${base}/analyzemgr/corp" method="get"  autocomplete="off">
					<table class="table-form">
						<tbody>
							<tr>
							<td style="width:5%;text-align:right;">企业名称</td>
							<td style="width:25%;">
							<input type="text" id="corpname" name="corpname" value="${corpname}" class="form-control">
							</td>
							<td style="width:30%;padding-left:20px;">
								<button class="btn btn-sm btn-primary" type="submit">查 询</button>
								</td>
							</tr>
						</tbody>
					</table>	
		</form>
		<table  class="table  table-bordered table-hover">
			<thead>
					<tr>
						<th colspan="5" class="td-bgtitle" style="text-align:center;border-bottom:0px;font-size:15px;">
					${corpname}
						</th>
					</tr>
					<tr>
						<th colspan="5" class="td-bgtitle" style="text-align:left;border-bottom:0px;font-size:15px;">
					司法判决信息共计${pageJudgedoc.totalElements}条
						</th>
					</tr>
						<tr>
							<th style="width:40%;text-align:center;">标题</th>
							<th style="width:20%;text-align:center;">案件号</th>
							<th style="width:10%;text-align:center;">类型</th>
						    <th style="width:10%;text-align:center;">信息来源</th>
							<th style="width:20%;text-align:center;">发布日期</th>
						</tr>
			</thead>
			<tbody id="pagejudgedoc" style="border-top:none">
				[#list pageJudgedoc.content as page]	
						<tr  >
							<td style="text-align:center;"><a href="${page.url}${page.filename}" target="view_window">${page.hidcasename}</a></td>
							<td style="text-align:center;">${page.hidcasenumber}</td>
							<td style="text-align:center;">${page.servicetype}</td>
							<td style="text-align:center;">
								${page.hidcourt}
							</td>
							<td style="text-align:center;">${page.releasetime}</td>
						</tr>
				[/#list]
				[#if pageJudgedoc.totalPages>1]
			<tr>
					<td colspan="2" style="text-align:left;border-right: 0px; ">
							第${pageJudgedoc.number+1 }页/共${pageJudgedoc.totalPages }页，总共${pageJudgedoc.totalElements }条记录
						</td>
					<td colspan="3" style="text-align:right; border-left: 0px; ">
						[#if (pageJudgedoc.number+1 > 1)]
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','judgedoc','${pageJudgedoc.number-1}');">上一页</a>
							[/#if]
							[#if !(pageJudgedoc.number+1 > pageJudgedoc.totalPages)&&!(pageJudgedoc.number+1 == pageJudgedoc.totalPages)] 
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','judgedoc','${pageJudgedoc.number+1}');">下一页</a>									
						[/#if]
					</td>
			</tr>
			[/#if]
			</tbody>
		</table>

			<table class="table table-bordered table-hover">
				<thead>
						<tr>
							<th colspan="5" class="td-bgtitle" style="text-align:left;border-bottom:0px;font-size:15px;">
						失信被执行人信息共计${pageDishonestman.totalElements}条
							 <a class="dropdown-table" name="show"> </a>
							</th>
							</tr>
							<tr>
							<th style="width:40%;text-align:center;">未履行的义务</th>
							<th style="width:10%;text-align:center;">案件号</th>
							<th style="width:10%;text-align:center;">企业法人</th>
						    <th style="width:20%;text-align:center;">数据类型</th>
							<th style="width:20%;text-align:center;">发布日期</th>
							</tr>
				</thead>
				<tbody  id="pagedishonestman" style="border-top:none">
					[#list pageDishonestman.content as page]	
						<tr  >
							<td style="text-align:center;">${page.lawduty}</td>
							<td style="text-align:center;">${page.casenumber}</td>
							<td style="text-align:center;">${page.corporatename}</td>
							<td style="text-align:center;">
								${page.datatype}
							</td>
							<td style="text-align:center;">
							${(page.releasetime?string('yyyy-MM-dd'))!}</td>
						</tr>
				[/#list]
				[#if pageDishonestman.totalPages>1]
			<tr>
					<td colspan="2" style="text-align:left;border-right: 0px; ">
							第${pageDishonestman.number+1 }页/共${pageDishonestman.totalPages }页，总共${pageDishonestman.totalElements }条记录
						</td>
					<td colspan="3" style="text-align:right; border-left: 0px; ">
						[#if (pageDishonestman.number+1 > 1)]
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','dishonestman','${pageDishonestman.number-1}');">上一页</a>
							[/#if]
							[#if !(pageDishonestman.number+1 > pageDishonestman.totalPages)&&!(pageDishonestman.number+1 == pageDishonestman.totalPages)] 
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','dishonestman','${pageDishonestman.number+1}');">下一页</a>									
						[/#if]
					</td>
			</tr>
			[/#if]
			</tbody>
			</table>
			
			<table class="table table-bordered table-hover">
				<thead>
						<tr>
							<th colspan="5" class="td-bgtitle" style="text-align:left;border-bottom:0px;font-size:15px;">
						表彰信息共计${pageBiaoZhang.totalElements}条
							 <a class="dropdown-table" name="show"> </a>
							</th>
							</tr>
							<tr>
							<th style="width:40%;text-align:center;">标题</th>
							<th style="width:10%;text-align:center;">类型</th>
							<th style="width:10%;text-align:center;">来源网站</th>
						    <th style="width:20%;text-align:center;">发布日期</th>
							</tr>
				</thead>
				<tbody  id="pagebiaozhang" style="border-top:none">
					[#list pageBiaoZhang.content as page]	
						<tr  >
							<td style="text-align:center;"><a href="${page.url}" target="view_window">${page.title}</a></td>
							<td style="text-align:center;">${page.type}</td>
							<td style="text-align:center;">${page.source}</td>
							<td style="text-align:center;">${page.issuedate}</td>
						</tr>
				[/#list]
				[#if pageBiaoZhang.totalPages>1]
			<tr>
					<td colspan="2" style="text-align:left;border-right: 0px; ">
							第${pageBiaoZhang.number+1 }页/共${pageBiaoZhang.totalPages }页，总共${pageBiaoZhang.totalElements }条记录
						</td>
					<td colspan="3" style="text-align:right; border-left: 0px; ">
						[#if (pageBiaoZhang.number+1 > 1)]
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','biaozhang','${pageBiaoZhang.number-1}');">上一页</a>
							[/#if]
							[#if !(pageBiaoZhang.number+1 > pageBiaoZhang.totalPages)&&!(pageBiaoZhang.number+1 == pageBiaoZhang.totalPages)] 
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','biaozhang','${pageBiaoZhang.number+1}');">下一页</a>									
						[/#if]
					</td>
			</tr>
			[/#if]
			</tbody>
			</table>
			
			<table class="table table-bordered table-hover">
				<thead>
						<tr>
							<th colspan="5" class="td-bgtitle" style="text-align:left;border-bottom:0px;font-size:15px;">
						获奖信息共计${pageHuoJiang.totalElements}条
							 <a class="dropdown-table" name="show"> </a>
							</th>
							</tr>
							<tr>
							<th style="width:40%;text-align:center;">标题</th>
							<th style="width:10%;text-align:center;">类型</th>
							<th style="width:10%;text-align:center;">来源网站</th>
						    <th style="width:20%;text-align:center;">发布日期</th>
							</tr>
				</thead>
				<tbody  id="pagehuojiang" style="border-top:none">
					[#list pageHuoJiang.content as page]	
						<tr  >
							<td style="text-align:center;"><a href="${page.url}" target="view_window">${page.title}</a></td>
							<td style="text-align:center;">${page.type}</td>
							<td style="text-align:center;">${page.source}</td>
							<td style="text-align:center;">${page.issuedate}</td>
						</tr>
				[/#list]
				[#if pageHuoJiang.totalPages>1]
			<tr>
					<td colspan="2" style="text-align:left;border-right: 0px; ">
							第${pageHuoJiang.number+1 }页/共${pageHuoJiang.totalPages }页，总共${pageHuoJiang.totalElements }条记录
						</td>
					<td colspan="3" style="text-align:right; border-left: 0px; ">
						[#if (pageHuoJiang.number+1 > 1)]
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','huojiang','${pageHuoJiang.number-1}');">上一页</a>
							[/#if]
							[#if !(pageHuoJiang.number+1 > pageHuoJiang.totalPages)&&!(pageHuoJiang.number+1 == pageHuoJiang.totalPages)] 
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','huojiang','${pageHuoJiang.number+1}');">下一页</a>									
						[/#if]
					</td>
			</tr>
			[/#if]
			</tbody>
			</table>
			
			<table class="table table-bordered table-hover">
				<thead>
						<tr>
							<th colspan="5" class="td-bgtitle" style="text-align:left;border-bottom:0px;font-size:15px;">
						通报批评信息共计${pagePiping.totalElements}条
							 <a class="dropdown-table" name="show"> </a>
							</th>
							</tr>
							<tr>
							<th style="width:40%;text-align:center;">标题</th>
							<th style="width:10%;text-align:center;">类型</th>
							<th style="width:10%;text-align:center;">来源网站</th>
						    <th style="width:20%;text-align:center;">发布日期</th>
							</tr>
				</thead>
				<tbody  id="pagepiping" style="border-top:none">
					[#list pagePiping.content as page]	
						<tr  >
						<td style="text-align:center;"><a href="${page.url}" target="view_window">${page.title}</a></td>
							<td style="text-align:center;">${page.type}</td>
							<td style="text-align:center;">${page.source}</td>
							<td style="text-align:center;">${page.issuedate}</td>
						</tr>
				[/#list]
				[#if pagePiping.totalPages>1]
			<tr>
					<td colspan="2" style="text-align:left;border-right: 0px; ">
							第${pagePiping.number+1 }页/共${pagePiping.totalPages }页，总共${pagePiping.totalElements }条记录
						</td>
					<td colspan="3" style="text-align:right; border-left: 0px; ">
						[#if (pagePiping.number+1 > 1)]
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','piping','${pagePiping.number-1}');">上一页</a>
							[/#if]
							[#if !(pagePiping.number+1 > pagePiping.totalPages)&&!(pagePiping.number+1 == pagePiping.totalPages)] 
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','piping','${pagePiping.number+1}');">下一页</a>									
						[/#if]
					</td>
			</tr>
			[/#if]
			</tbody>
			</table>
			
			<table class="table table-bordered table-hover">
				<thead>
						<tr>
							<th colspan="5" class="td-bgtitle" style="text-align:left;border-bottom:0px;font-size:15px;">
						公众表扬信息共计${pagePrise.totalElements}条
							 <a class="dropdown-table" name="show"> </a>
							</th>
							</tr>
							<tr>
							<th style="width:10%;text-align:center;">工单号</th>
							<th style="width:10%;text-align:center;">车牌号</th>
							<th style="width:50%;text-align:center;">工单内容</th>
							<th style="width:10%;text-align:center;">数据来源</th>
						    <th style="width:20%;text-align:center;">发生时间</th>
							</tr>
				</thead>
				<tbody  id="pageprise" style="border-top:none">
					[#list pagePrise.content as page]	
						<tr  >
							<td style="text-align:center;">${page.accept_num}</td>
							<td style="text-align:center;">${page.carno}</td>
							<td style="text-align:center;">${page.name}</td>
							<td style="text-align:center;">${page.casenumber}</td>
							<td style="text-align:center;">${page.prisetime}</td>
						</tr>
				[/#list]
				[#if pagePrise.totalPages>1]
			<tr>
					<td colspan="2" style="text-align:left;border-right: 0px; ">
							第${pagePrise.number+1 }页/共${pagePrise.totalPages }页，总共${pagePrise.totalElements }条记录
						</td>
					<td colspan="3" style="text-align:right; border-left: 0px; ">
						[#if (pagePrise.number+1 > 1)]
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','prise','${pagePrise.number-1}');">上一页</a>
							[/#if]
							[#if !(pagePrise.number+1 > pagePrise.totalPages)&&!(pagePrise.number+1 == pagePrise.totalPages)] 
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','prise','${pagePrise.number+1}');">下一页</a>									
						[/#if]
					</td>
			</tr>
			[/#if]
			</tbody>
			</table>
			
			<table class="table table-bordered table-hover">
				<thead>
						<tr>
							<th colspan="5" class="td-bgtitle" style="text-align:left;border-bottom:0px;font-size:15px;">
						服务质量投诉信息共计${pageComplaint.totalElements}条
							 <a class="dropdown-table" name="show"> </a>
							</th>
							</tr>
							<tr>
							<th style="width:10%;text-align:center;">工单号</th>
							<th style="width:10%;text-align:center;">车牌号</th>
							<th style="width:50%;text-align:center;">工单内容</th>
							<th style="width:10%;text-align:center;">数据来源</th>
						    <th style="width:20%;text-align:center;">发生时间</th>
							</tr>
				</thead>
				<tbody  id="pagecomplaint" style="border-top:none">
					[#list pageComplaint.content as page]	
						<tr  >
							<td style="text-align:center;">${page.accept_num}</td>
							<td style="text-align:center;">${page.vehicle_no}</td>
							<td style="text-align:center;">${page.event_content}</td>
							<td style="text-align:center;">${page.event_type_name}</td>
							<td style="text-align:center;">${page.event_time}</td>
						</tr>
				[/#list]
				[#if pageComplaint.totalPages>1]
			<tr>
					<td colspan="2" style="text-align:left;border-right: 0px; ">
							第${pageComplaint.number+1 }页/共${pageComplaint.totalPages }页，总共${pageComplaint.totalElements }条记录
						</td>
					<td colspan="3" style="text-align:right; border-left: 0px; ">
						[#if (pageComplaint.number+1 > 1)]
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','complaint','${pageComplaint.number-1}');">上一页</a>
							[/#if]
							[#if !(pageComplaint.number+1 > pageComplaint.totalPages)&&!(pageComplaint.number+1 == pageComplaint.totalPages)] 
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','complaint','${pageComplaint.number+1}');">下一页</a>									
						[/#if]
					</td>
			</tr>
			[/#if]
			</tbody>
			</table>
			
			<table class="table table-bordered table-hover">
				<thead>
						<tr>
							<th colspan="5" class="td-bgtitle" style="text-align:left;border-bottom:0px;font-size:15px;">
						项目招标信息共计${pageZhaobiao.totalElements}条
							 <a class="dropdown-table" name="show"> </a>
							</th>
							</tr>
							<tr>
							<th style="width:40%;text-align:center;">项目名称</th>
							<th style="width:10%;text-align:center;">招标类别</th>
							<th style="width:10%;text-align:center;">来源网站</th>
							<th style="width:10%;text-align:center;">项目类型</th>
						    <th style="width:20%;text-align:center;">发布时间</th>
							</tr>
				</thead>
				<tbody  id="pagezhaobiao" style="border-top:none">
					[#list pageZhaobiao.content as page]	
						<tr  >
							<td style="text-align:center;"><a href="${page.url}" target="view_window">${page.project_name}</a></td>
							<td style="text-align:center;">${page.zhaobiao_type}</td>
							<td style="text-align:center;">${page.web_name}</td>
							<td style="text-align:center;">${page.industry}</td>
							<td style="text-align:center;">${page.gg_update}</td>
						</tr>
				[/#list]
				[#if pageZhaobiao.totalPages>1]
			<tr>
					<td colspan="2" style="text-align:left;border-right: 0px; ">
							第${pageZhaobiao.number+1 }页/共${pageZhaobiao.totalPages }页，总共${pageZhaobiao.totalElements }条记录
						</td>
					<td colspan="3" style="text-align:right; border-left: 0px; ">
						[#if (pageZhaobiao.number+1 > 1)]
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','zhaobiao','${pageZhaobiao.number-1}');">上一页</a>
							[/#if]
							[#if !(pageZhaobiao.number+1 > pageZhaobiao.totalPages)&&!(pageZhaobiao.number+1 == pageZhaobiao.totalPages)] 
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','zhaobiao','${pageZhaobiao.number+1}');">下一页</a>									
						[/#if]
					</td>
			</tr>
			[/#if]
			</tbody>
			</table>
			
			<table class="table table-bordered table-hover">
				<thead>
						<tr>
							<th colspan="5" class="td-bgtitle" style="text-align:left;border-bottom:0px;font-size:15px;">
						项目中标信息共计${pageZhongbiao.totalElements}条
							 <a class="dropdown-table" name="show"> </a>
							</th>
							</tr>
							<tr>
							<th style="width:40%;text-align:center;">项目名称</th>
							<th style="width:10%;text-align:center;">招标类别</th>
							<th style="width:10%;text-align:center;">来源网站</th>
							<th style="width:10%;text-align:center;">项目类型</th>
						    <th style="width:20%;text-align:center;">发布时间</th>
							</tr>
				</thead>
				<tbody  id="pagezhongbiao" style="border-top:none">
					[#list pageZhongbiao.content as page]	
						<tr  >
						<td style="text-align:center;"><a href="${page.url}" target="view_window">${page.project_name}</a></td>
							<td style="text-align:center;">${page.zhongbiao_type}</td>
							<td style="text-align:center;">${page.web_name}</td>
							<td style="text-align:center;">${page.industry}</td>
							<td style="text-align:center;">${page.gg_update}</td>
						</tr>
				[/#list]
				[#if pageZhongbiao.totalPages>1]
			<tr>
					<td colspan="2" style="text-align:left;border-right: 0px; ">
							第${pageZhongbiao.number+1 }页/共${pageZhongbiao.totalPages }页，总共${pageZhongbiao.totalElements }条记录
						</td>
					<td colspan="3" style="text-align:right; border-left: 0px; ">
						[#if (pageZhongbiao.number+1 > 1)]
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','zhongbiao','${pageZhongbiao.number-1}');">上一页</a>
							[/#if]
							[#if !(pageZhongbiao.number+1 > pageZhongbiao.totalPages)&&!(pageZhongbiao.number+1 == pageZhongbiao.totalPages)] 
								<a  href="javascript:void(0);" type="button"  onclick="searchpage('${corpname}','zhongbiao','${pageZhongbiao.number+1}');">下一页</a>									
						[/#if]
					</td>
			</tr>
			[/#if]
			</tbody>
			</table>
			
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
var searchpage = function(corpname,infotype,page){
   var data = {
   			page:page
	};
	$.ajax({
		type:"get",
		url:base+"/analyzemgr/corp/"+infotype+"/"+corpname,
		data:data,
		dataType:"json",
		success:function(data){
			var page=data;
			var html=""; 
  			if(infotype=="judgedoc"){
			    $.each(page.content,function(index,judgedoc){
 			    	html=html
			    	+"<tr>"
			    	+"<td style='text-align:center;'><a href='"+nullcheck(judgedoc.url)+nullcheck(judgedoc.filename)+"' target='view_window'>"+nullcheck(judgedoc.hidcasename)+"</a></td>"
			    	+"<td style='text-align:center;'>"+nullcheck(judgedoc.hidcasenumber)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(judgedoc.servicetype)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(judgedoc.hidcourt)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(judgedoc.releasetime)+"</td>"
			    	+"</tr>";
			    })
			    html=html+getpagehtml(2,3,corpname,infotype,page);
			}else if(infotype=="dishonestman"){
			    $.each(page.content,function(index,dishonestman){
			    	html=html
			    	+"<tr>"                 
			    	+"<td style='text-align:center;'>"+nullcheck(dishonestman.lawduty) +" </td>"
			    	+"<td style='text-align:center;'>"+nullcheck(dishonestman.casenumber)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(dishonestman.corporatename)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(dishonestman.datatype)+"</td>"
			    	+"<td style='text-align:center;'>"+parseDatetime(dishonestman.releasetime)+"</td>"
			    	+"</tr>";
			    })
			    html=html+getpagehtml(2,3,corpname,infotype,page);
			}else if(infotype=="biaozhang"){
			    $.each(page.content,function(index,biaozhang){
			    	html=html
			    	+"<tr>"                    
			    	+"<td style='text-align:center;'>"+nullcheck(biaozhang.title) +" </td>"
			    	+"<td style='text-align:center;'>"+nullcheck(biaozhang.type)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(biaozhang.source)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(biaozhang.issuedate)+"</td>"
			    	+"</tr>";
			    })
			    html=html+getpagehtml(2,3,corpname,infotype,page);
			}else if(infotype=="huojiang"){
			    $.each(page.content,function(index,huojiang){
			    	html=html
			    	+"<tr>"                    
			    	+"<td style='text-align:center;'>"+nullcheck(huojiang.title) +" </td>"
			    	+"<td style='text-align:center;'>"+nullcheck(huojiang.type)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(huojiang.source)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(huojiang.issuedate)+"</td>"
			    	+"</tr>";
			    })
			    html=html+getpagehtml(2,3,corpname,infotype,page);
			}else if(infotype=="piping"){
			    $.each(page.content,function(index,piping){
			    	html=html
			    	+"<tr>"                    
			    	+"<td style='text-align:center;'>"+nullcheck(piping.title) +" </td>"
			    	+"<td style='text-align:center;'>"+nullcheck(piping.type)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(piping.source)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(piping.issuedate)+"</td>"
			    	+"</tr>";
			    })
			    html=html+getpagehtml(2,3,corpname,infotype,page);
			}else if(infotype=="prise"){
			    $.each(page.content,function(index,prise){
			    	html=html
			    	+"<tr>"                    
			    	+"<td style='text-align:center;'>"+nullcheck(prise.accept_num) +" </td>"
			    	+"<td style='text-align:center;'>"+nullcheck(prise.carno)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(prise.name)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(prise.casenumber)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(prise.prisetime)+"</td>"
			    	+"</tr>";
			    })
			    html=html+getpagehtml(2,3,corpname,infotype,page);
			}else if(infotype=="complaint"){
			    $.each(page.content,function(index,complaint){
			    	html=html
			    	+"<tr>"                    
			    	+"<td style='text-align:center;'>"+nullcheck(complaint.accept_num) +" </td>"
			    	+"<td style='text-align:center;'>"+nullcheck(complaint.vehicle_no)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(complaint.event_content)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(complaint.event_type_name)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(complaint.event_time)+"</td>"
			    	+"</tr>";
			    })
			    html=html+getpagehtml(2,3,corpname,infotype,page);
			}else if(infotype=="zhaobiao"){
			    $.each(page.content,function(index,zhaobiao){
			    	html=html
			    	+"<tr>"                    
			    	+"<td style='text-align:center;'>"+nullcheck(zhaobiao.project_name) +" </td>"
			    	+"<td style='text-align:center;'>"+nullcheck(zhaobiao.zhaobiao_type)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(zhaobiao.web_name)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(zhaobiao.industry)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(zhaobiao.gg_update)+"</td>"
			    	+"</tr>";
			    })
			    html=html+getpagehtml(2,3,corpname,infotype,page);
			}else if(infotype=="zhongbiao"){
			    $.each(page.content,function(index,zhongbiao){
			    	html=html
			    	+"<tr>"                    
			    	+"<td style='text-align:center;'>"+nullcheck(zhongbiao.project_name) +" </td>"
			    	+"<td style='text-align:center;'>"+nullcheck(zhongbiao.zhongbiao_type)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(zhongbiao.web_name)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(zhongbiao.industry)+"</td>"
			    	+"<td style='text-align:center;'>"+nullcheck(zhongbiao.gg_update)+"</td>"
			    	+"</tr>";
			    })
			    html=html+getpagehtml(2,3,corpname,infotype,page);
			}
   			$("#page"+infotype).html(html);
		},
		error:function(){
			 alert("数据加载失败");
		}
	});
}
function getpagehtml(colspan1,colspan2,corpname,infotype,page){
	var html=html
		+"<tr>"
		+"<td colspan='"+colspan1+"' style='text-align:left;border-right: 0px; '>"
		+" 第"+(page.number+1)+"页/共"+page.totalPages+"页，总共"+page.totalElements+"条记录"
		+"</td>"
		+"<td colspan='"+colspan2+"' style='text-align:right;border-left: 0px; '>";
		if((page.number+1)>1){
 			html=html+"<a  href='javascript:void(0);' type='button' onclick='searchpage(\""+corpname+"\"\,\""+infotype+"\"\,\""+(page.number-1)+"\")'> 上一页</a>";
		}
		if((page.number+1)<page.totalPages){
 			html=html+"<a  href='javascript:void(0);' type='button' onclick='searchpage(\""+corpname+"\"\,\""+infotype+"\"\,\""+(page.number+1)+"\")'> 下一页</a>";								
		}
		html=html+"</td>"+"</tr>";
	return html;
}
function nullcheck(value){
	if(value==null){
		value="";
	}
	return value;
} 
</script >
[/@layout.main]