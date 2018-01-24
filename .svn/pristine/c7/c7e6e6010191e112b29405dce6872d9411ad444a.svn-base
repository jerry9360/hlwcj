[#import "common/layout.ftl" as layout] 
[#assign jss=["assets/js/date-time/bootstrap-datetimepicker.min.js"]] 
[#assign css=["assets/css/zhemutanchukuang.css","assets/css/datetimepicker.css"]]
[@layout.main  modelcode=['fx_corp' ]   otherjs=jss othercss=css  ]
[#include "common/loading.ftl"] 
<form class="form-horizontal" role="form" id="formid" action="${base}/analyzemgr/corporder" method="get"  autocomplete="off">
	<table class="table-form">
		<tbody>
              <tr>
				<td style="width:10%;text-align:right;">数据类别</td>
				<td style="width:30%;">
				<select class="bs-select form-control" id="datatype"  name="datatype"  >
				<option value="judgedoc"  selected="selected" >请选择</option>
				<option value="judgedoc"  [#if datatype== 'judgedoc'] selected="selected" [/#if] >司法判决信息</option>
					<option value="dishonestman"  [#if datatype== 'dishonestman'] selected="selected" [/#if]>失信被执行人信息</option>
					<option value="biaozhang" [#if datatype== 'biaozhang'] selected="selected" [/#if] >表彰信息</option>
					<option value="huojiang"[#if datatype== 'huojiang'] selected="selected" [/#if] >获奖信息</option>
					<option value="tongbaopiping" [#if datatype== 'tongbaopiping'] selected="selected" [/#if] >通报批评类信息</option>
					<option value="public_prise"[#if datatype== 'public_prise'] selected="selected" [/#if] >公众表扬信息</option>
					<option value="servicecomplaint" [#if datatype== 'servicecomplaint'] selected="selected" [/#if]>服务质量投诉信息</option>
					<option value="zhaobiao" [#if datatype== 'zhaobiao'] selected="selected" [/#if]>项目招标信息</option>
					<option value="zhongbiao" [#if datatype== 'zhongbiao'] selected="selected" [/#if]>项目中标信息</option>
				</select>
				</td>
			</tr>
			<tr>
			<td style="width:10%;text-align:right;">开始时间</td>
			<td style="width:30%;"><div class="input-group date form_datetime formtd-width80">
				<input class="form-control formtd-width80 input-inline"  name="begindate" readonly 
						id="begindate" data-date-format="yyyy-MM-dd" value="${(begindate?string('yyyy-MM-dd'))!}"
						style="border-right: 0px; background-color: white;">
				 <span class="input-group-btn">
						<button class="btn btn-primary date-set" type="button" style="padding:0px;height:31px;">
							<img src="${base}/assets/images/rl.png" style="float:left;">
						</button>
				</span>
				</div></td>
				<td style="width:10%;text-align:right;">结束时间</td>
				<td style="width:30%;"><div class="input-group date form_datetime formtd-width80">
			   <input class="form-control formtd-width80 input-inline"   name="enddate" readonly
					id="enddate" data-date-format="yyyy-MM-dd" value="${(enddate?string('yyyy-MM-dd'))!}"
					style="border-right: 0px; background-color: white;">
			   <span class="input-group-btn">
					<button class="btn btn-primary date-set" type="button" style="padding:0px;height:31px;">
						<img src="${base}/assets/images/rl.png" style="float:left;">
					</button>
			  </span>
			  </div>
					</td>
					<td style="width:20%;padding-left:10px;">
					<button class="btn btn-sm btn-primary" type="submit">查 询</button>
				</td>
			</tr>
		</tbody>
	</table>
</form>


<table  class="table  table-bordered table-hover">
	<thead>
		<tr>
			<th style="width:5%;text-align:center;">序号 </th>
			<th style="width:30%;">企业名称</th>
			<th style="width:20%;">信用数据总数</th>
		</tr>
	</thead>
	<tbody>
		[#list page as corp]
		<tr  >
			<td  style="text-align:center;">${corp_index+1}</td>
			<td><a  href="${base}/analyzemgr/corporder/show?corpname=${corp[0]}&datatype=${datatype}&">${corp[0]}</a></td>
			<td>${corp[1]}</td>
			</td>
		</tr>
		[/#list]
	</tbody>
</table>
 
<script type="text/javascript">
$(function() {
	$("#btype").click();
	initTime();
});

function initTime() {
	$(".form_datetime").datetimepicker({
		autoclose : true,
		format : "yyyy-MM-dd",
		minuteStep : 1,
		minView : 2,
		pickerPosition:'bottom-left',
		language : 'zh_CN'
	});
}
 
</script>
[/@layout.main]