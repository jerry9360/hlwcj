[#assign jss=[]] 
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['spiderrun','spider'] otherjs=jss sername=['爬虫管理','爬虫程序管理'] pagename='爬虫程序管理']
			<form class="form-horizontal" role="form" id="formid" action="${base}/crawler/spilders" method="get">
				<table class="table-form">
					<tbody>
						<tr>
							<td style="width:10%;text-align:right;">爬虫名称</td>
							<td style="width:30%;"><input type="text" id="name" name="name" value="${name }" class="form-control"></td>
							<td style="width:60%;padding-left:20px;">
								<button class="btn btn-sm btn-primary" type="submit">查 询</button>
								<a class="btn btn-sm btn-primary" data-toggle="modal" href="#large" onclick="addCrawler();">新 增</a>
								<!-- <a class="btn btn-sm btn-danger" data-toggle="modal" href="javascript:void(0)" onclick="closeAllCrawler();">关闭所有爬虫</a> -->
							</td>
						</tr>
					</tbody>
				</table>
			</form>
			<table class="table  table-bordered table-hover">
				<thead>
					<tr>
						<th style="width:5%;text-align:center;">序号 </th>
						<th style="width:8%;">编码</th>
						<th style="width:25%;">爬虫名称</th>
						<th style="width:15%;">执行周期（小时）</th>
						<th style="width:7%;">状态</th>
						<th style="width:15%;">更新时间</th>
						<th style="width:25%;">操作</th>
					</tr>
				</thead>
				<tbody>
				[#list page.content as p]
					<tr>
						<td  style="text-align:center;">${pageable.offset + p_index+1}</td>
						<td >${p.code }</td>
						<td >${p.name }</td>
						<td >${p.period }</td>
						<td style="color:red;font-weight:600;">
							[#if p.isrun=='0']未运行
							[#elseif p.isrun=='1']运行中
							[#elseif p.isrun=='2']待运行
							[#elseif p.isrun=='3']待关闭
							[/#if]
						</td>
						<td >${(p.modify_date?string('yyyy-MM-dd HH:mm:ss'))!}</td>
						<td>
							[#if p.isrun=='0']
								<button class="btn btn-xs btn-primary" onclick="startCrawler('${p.id}')">启动</button>
								<button class="btn btn-xs default" disabled="disabled">关闭</button>
								<button class="btn btn-xs btn-danger" onclick="deleteCrawler('${p.id}')">删除</button>
							[#elseif p.isrun=='1']
								<button class="btn btn-xs default" disabled="disabled">启动</button>
								<button class="btn btn-xs btn-danger" onclick="closeCrawler('${p.id}')">关闭</button>
								<button class="btn btn-xs default" disabled="disabled">删除</button>
							[#elseif p.isrun=='2']
								<button class="btn btn-xs default" disabled="disabled">启动</button>
								<button class="btn btn-xs default" disabled="disabled">关闭</button>
								<button class="btn btn-xs default" disabled="disabled">删除</button>
							[#elseif p.isrun=='3']
								<button class="btn btn-xs default" disabled="disabled">启动</button>
								<button class="btn btn-xs default" disabled="disabled">关闭</button>
								<button class="btn btn-xs default" disabled="disabled">删除</button>
							[/#if]
								<a class="btn btn-xs btn-primary" data-toggle="modal" href="#large" onclick="editCrawler('${p.id}','${p.code}','${p.name}','${p.period}')">编辑</a>
						</td>
					</tr>
					[/#list]
				</tbody>
			</table>
			[#assign pagepath="${base}/crawler/spilders?name=${name}&"]  
			[#include "common/pagemodel.ftl"]
<div class="modal fade bs-modal-lg in" id="large" tabindex="-1" role="dialog" data-backdrop="static" aria-hidden="false" style="display: none;">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-body">
				<div class="portlet box blue-madison ">
					<div class="portlet-title">
						<div class="caption">
							爬虫程序管理
						</div>
					</div>
					<div class="portlet-body form">
						<form role="form" action="${base }/crawler/spilders" method="post">
							<input type="hidden" id="crawler_id" name="id" value="">
							<table class="table-form">
								<tbody>
									<tr>
										<td style="width:20%;text-align:right;">爬虫编码</td>
										<td style="width:40%;"><input type="text" id="crawler_code" name="code" value="" class="form-control"></td>
										<td style="width:40%;">（编码为四位数字，定制爬虫程序时使用！）</td>
									</tr>
									<tr>
										<td style="width:20%;text-align:right;">爬虫名称 </td>
										<td style="width:40%;"><input type="text" id="crawler_name" name="name" value="" class="form-control"></td>
										<td style="width:40%;">（爬虫程序）</td>
									</tr>
									<tr>
										<td style="width:20%;text-align:right;">执行周期 </td>
										<td style="width:40%;"><input type="text" id="crawler_period" name="period" value="" class="form-control"></td>
										<td style="width:40%;">（小时）</td>
									</tr>
								</tbody>
							</table>																									
							<div class="form-actions" style="text-align: center;">
								<button class="btn btn-width-70 btn-primary" type="submit" id="submitid">保 存</button>
								<button class="btn default" type="button" data-dismiss="modal">取消</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var addCrawler = function(){
		clerarCrawler();
	}
	var startCrawler = function(id){
		if(confirm("确认要启动此爬虫程序！")){
			window.location.href = base + "/crawler/spilders/start/"+id;
		}
	}
	var closeCrawler = function(id){
		if(confirm("确认要关闭此爬虫程序！")){
			window.location.href = base + "/crawler/spilders/close/"+id;
		}
	}
	var deleteCrawler = function(id){
		if(confirm("确认要删除此爬虫程序！")){
			window.location.href = base + "/crawler/spilders/delete/"+id;
		}
	}
	var editCrawler = function(id,code,name,period){
		$("#crawler_id").val(id);
		$("#crawler_code").val(code);
		$("#crawler_code").attr("readonly","readonly");
		$("#crawler_name").val(name);
		$("#crawler_period").val(period);
	}
	var clerarCrawler = function(){
		$("#crawler_code").removeAttr("readonly");
		$("#crawler_id").val("");
		$("#crawler_code").val("");
		$("#crawler_name").val("");
		$("#crawler_period").val("");
	}
	/**
	var closeAllCrawler = function(){
		if(confirm("确定要关闭所有爬虫吗？此功能只在关闭爬虫程序，更新爬虫程序时使用！使用前需要手动关闭爬虫程序，如果未关闭，切勿做此操作！")){
			window.location.href = base + "/crawler/spilders/closeSpilder";
		}
	}
	**/
</script>
[/@layout.main]