[#assign jss=[]] 
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['orglabel','labelmgr'] otherjs=jss sername=['标签管理','行业局标签'] pagename='行业局标签']
<div class="portlet box blue">
	<div class="portlet-title">
		<div class="caption">行业局信息</div>
	</div>
	<div class="portlet-body">
		<div class="table-responsive">
			<form class="form-horizontal" role="form" id="formid" action="${base}/orgmgr/organs" method="get">
				<table class="table-form">
					<tbody>
						<tr>
							<td style="width:10%;text-align:right;">标签名称</td>
							<td style="width:30%;"><input type="text" id="name" name="name" value="${name }" class="form-control"></td>
							<td style="width:60%;padding-left:20px;">
								<button class="btn btn-sm btn-primary" type="submit">查 询</button>
								<a class="btn btn-sm btn-primary" data-toggle="modal" href="#large" onclick="addlabel();">新 增</a>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
			<table class="table  table-bordered table-hover">
				<thead>
					<tr>
						<th style="width:5%;text-align:center;">序号 </th>
						<th style="width:25%;">标签名称</th>
						<th style="width:40%;">标签关键字</th>
						<th style="width:15%;">更新时间</th>
						<th style="width:15%;">操作</th>
					</tr>
				</thead>
				<tbody>
				[#list page.content as p]
					<tr>
						<td  style="text-align:center;">${pageable.offset + p_index+1}</td>
						<td >${p.orgname }</td>
						<td >${p.keyval }</td>
						<td >${(p.modifydate?string('yyyy-MM-dd HH:mm:ss'))!}</td>
						<td>
							<a class="btn btn-xs btn-info" data-toggle="modal" href="#large" onclick="editLabel('${p.orgid}','${p.orgname}','${p.keyval}')">编辑</a>
							<a class="btn btn-xs btn-danger" href="javascript:void(0)" onclick="deletelabel('${p.orgid}')">删除</a>
						</td>
					</tr>
					[/#list]
				</tbody>
			</table>
			[#assign pagepath="${base}/orgmgr/organs?name=${name}&"]  
			[#include "common/pagemodel.ftl"]
		</div>
	</div>
</div>
<div class="modal fade bs-modal-lg in" id="large" tabindex="-1" role="dialog" data-backdrop="static" aria-hidden="false" style="display: none;">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-body">
				<div class="portlet box blue-madison ">
					<div class="portlet-title">
						<div class="caption">
							标签管理
						</div>
					</div>
					<div class="portlet-body form">
						<form role="form" action="${base }/orgmgr/organs" method="post">
							<input type="hidden" id="organid" name="id" value="">
							<table class="table-form">
								<tbody>
									<tr>
										<td style="width:20%;text-align:right;">名称</td>
										<td style="width:50%;"><input type="text" id="orgname" name="orgname" value="" class="form-control"></td>
										<td style="width:30%;"></td>
									</tr>
									<tr>
										<td style="text-align:right;">关键字</td>
										<td><textarea id="keyval" name="keyval" rows="3" class="form-control"></textarea></td>
										<td>（多个关键字顿号“+”隔开）</td>
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
	var addlabel = function(){
		clearlabel();
	}
	var deletelabel = function(id){
		if(confirm("确认要删除此分类")){
			window.location.href = base + "/orgmgr/organs/delete/"+id;
		}
	}
	var editLabel = function(id,orgname,keyval){
		clearlabel();
		$("#organid").val(id);
		$("#orgname").val(orgname);
		$("#keyval").val(keyval);
	}
	var clearlabel = function(){
		$("#organid").val("");
		$("#orgname").val("");
		$("#keyval").val("");
	}
</script>
[/@layout.main]