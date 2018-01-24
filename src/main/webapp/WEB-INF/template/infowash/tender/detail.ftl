[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['wash_tender','infowash'] otherjs=jss sername=['数据清洗','招标信息'] pagename='招标信息']
		[#macro sub info]
	[#if info?length>80]
		${info[0..80]}....
	[#else]
		${info}
	[/#if]
	[/#macro]
						<table class="table table-bordered dataTable no-footer">
							<tbody>
								<tr>
									<td class="old" width="12%" style="text-align:right;">项目名称</td><td width="44%">${zhaobiaogg.project_name}</td>
									<td class="old" width="12%" style="text-align:right;">项目编号</td><td width="44%">${zhaobiaogg.project_code_cq}</td>
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">行业类别</td><td width="44%">${zhaobiaogg.industry}</td>
									<td class="old" width="12%" style="text-align:right;">招标类别</td><td width="44%">${zhaobiaogg.zhaobiao_type}</td>								
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">项目业主</td><td width="44%">${zhaobiaogg.zhaobiaoren}</td>
									<td class="old" width="12%" style="text-align:right;">招标代理机构</td><td width="44%">${zhaobiaogg.zhaobiaodaili}</td>								
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">资金来源</td><td width="44%">${zhaobiaogg.zijinlaiyuan}</td>
									<td class="old" width="12%" style="text-align:right;">招标公告编号</td><td width="44%">${zhaobiaogg.zhaobiao_no}</td>								
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">桩号</td><td width="44%">${zhaobiaogg.zhuanghao}</td>
									<td class="old" width="12%" style="text-align:right;">合同段</td><td width="44%">${zhaobiaogg.htd}</td>								
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">公共类型</td><td width="44%">${zhaobiaogg.gg_type}</td>
									<td class="old" width="12%" style="text-align:right;">状态</td>
									[#if zhaobiaogg.state=='1']	
									<td width="44%">采信</td>
									[#elseif zhaobiaogg.state=='2']
									<td width="44%">不采信</td>	
									[#else]
									<td width="44%">待清理</td>
									[/#if]
								</tr>								
								<tr>
									<td class="old" width="12%" style="text-align:right;">招标人</td><td width="44%">${zhaobiaogg.zhaobiaoren}</td>
									<td class="old" width="12%" style="text-align:right;">招标代理机构</td><td width="44%">${zhaobiaogg.zhaobiaodaili}</td>							
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">公告发布时间</td><td width="44%">${zhaobiaogg.gg_update}</td>
									<td class="old" width="12%" style="text-align:right;">来源网站</td><td width="44%">${zhaobiaogg.web_name}</td>								
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">文章内容</td><td colspan="3">${zhaobiaogg.web_content}</td>
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">网址URL</td><td width="44%"><a href="${zhaobiaogg.url}" target="_blank">[@sub zhaobiaogg.url][/@sub]</a></td>
									<td class="old" width="12%" style="text-align:right;">网址所属单位</td><td width="44%">${zhaobiaogg.webunit}</td>								
								</tr>
								<tr>
									<td class="old" style="text-align:right;">可信度</td>
									[#if zhaobiaogg.credit=='0']	
									<td colspan="3">可信度低</td>
									[#else]
									<td colspan="3">可信度高</td>
									[/#if]
								</tr>
								<tr>
									<td class="old" style="text-align:right;">附件</td>
									<td colspan="3">
<!-- 									[#if zhaobiaogg.files??] -->
<!-- 										[#list zhaobiaogg.files as f] -->
											<a href="${base}/common/file/load?filename=${f}" target="_blank" title="${f}">${f}</a><br/>
<!-- 										[/#list] -->
<!-- 									[/#if] -->
									</td>
								</tr>	
							</tbody>
						</table>
						<div class="form-actions" style="text-align:center;margin-bottom:20px;">
							<button class="btn btn-xs btn-width btn-primary" type="button" onclick="upInfo('${zhaobiaogg.zhaobiao_id}','1');">采 信</button>
							<button class="btn btn-xs btn-width btn-primary" type="button" onclick="upInfo('${zhaobiaogg.zhaobiao_id}','2');">不采信</button>
							<button class="btn btn-xs btn-width btn-primary" type="button" onClick="history.go(-1)">取 消</button>
					</div>
	<script type="text/javascript">
function upInfo(id,state) {
	var message=null;
	if(state=='1'){
		message="确认采信该信息?";
	}else{
		message="确认不采信该信息?";
	}
	 if(confirm(message)) {
		 window.location.href=base + "/infowash/tender/wash/"+id+"/"+state;
	 }
}
</script>
[/@layout.main]
