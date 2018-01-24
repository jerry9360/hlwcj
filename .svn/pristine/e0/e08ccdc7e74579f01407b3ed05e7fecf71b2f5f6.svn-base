[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['wash_judgedoc','infowash'] otherjs=jss sername=['数据清洗','司法判决信息'] pagename='司法判决信息']
		[#macro sub info]
	[#if info?length>65]
		${info[0..65]}....
	[#else]
		${info}
	[/#if]
	[/#macro]
						<table class="table table-bordered dataTable no-footer">
							<tbody>
								<tr>
									<td class="old" width="10%" style="text-align:right;">企业名称</td><td width="90%">${judgedoc.corp_name}</td>
								</tr>
								<tr>	
									<td class="old" width="10%" style="text-align:right;">行业类别</td>
									<td width="90%">
										[#if judgedoc.industry=='1']
											公路建设市场
										[#elseif judgedoc.industry=='2']
											水运建设市场
										[#elseif judgedoc.industry=='4']
											道路运输市场
										[/#if]
									</td>
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">案件类型</td>
									<td width="90%">
										[#if judgedoc.hidcasetype=='1']
											刑事案件
										[#elseif judgedoc.hidcasetype=='2']
											民事案件
										[#elseif judgedoc.hidcasetype=='3']
											行政案件
										[#elseif judgedoc.hidcasetype=='4']
											赔偿文件
										[#elseif judgedoc.hidcasetype=='5']
											执行案件
										[/#if]
									</td>
								</tr>
								<tr>		
									<td class="old" width="10%" style="text-align:right;">业务类型</td><td width="90%">${judgedoc.servicetype}</td>								
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">被告/原告</td><td width="90%">${judgedoc.casemantype}</td>
								</tr>
								<tr>		
									<td class="old" width="10%" style="text-align:right;">判决法院</td><td width="90%">${judgedoc.hidcourt}</td>								
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">文书标题</td><td width="90%">${judgedoc.hidcasename}</td>
								</tr>
								<tr>		
									<td class="old" width="10%" style="text-align:right;">案号</td><td width="90%">${judgedoc.hidcasenumber}</td>								
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">发布时间</td><td width="90%">${judgedoc.releasetime}</td>
								</tr>
								<tr>		
									<td class="old" width="10%" style="text-align:right;">来源网站</td><td width="90%">${judgedoc.source}</td>								
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">网站所属单位</td><td width="90%">${judgedoc.pageunit}</td>
								</tr>
								<tr>		
									<td class="old" width="10%" style="text-align:right;">网址URL</td><td width="90%"><a href="${judgedoc.url+judgedoc.filename}" target="_blank">${judgedoc.url+judgedoc.filename}</a></td>								
								</tr>								
								<tr>
									<td class="old" width="10%" style="text-align:right;">文书内容</td><td>${judgedoc.hidcaseinfo}</td>
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">网页内容</td><td>${judgedoc.content}</td>
								</tr>
								<tr>
									<td class="old" style="text-align:right;">可信度</td>
									[#if judgedoc.credit=='0']	
									<td>可信度低</td>
									[#else]
									<td>可信度高</td>
									[/#if]
								</tr>
								<tr>
									<td class="old" style="text-align:right;">附件</td>
									<td>
									[#if judgedoc.files??]
										[#list judgedoc.files as f]
											<a href="${base}/common/file/load?filename=${f}" target="_blank" title="${f}">${f}</a><br/>
										[/#list]
									[/#if]
									</td>
								</tr>	
							</tbody>
						</table>
						<div class="form-actions" style="text-align:center;margin-bottom:20px;">
							<button class="btn btn-xs btn-width btn-primary" type="button" onclick="upInfo('${judgedoc.id}','1');">采 信</button>
							<button class="btn btn-xs btn-width btn-primary" type="button" onclick="upInfo('${judgedoc.id}','2');">不采信</button>
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
		 window.location.href=base + "/infowash/judgedoc/wash/"+id+"/"+state;
	 }
}
</script>
[/@layout.main]
