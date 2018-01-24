[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['wash_goodbadinfo','infowash'] otherjs=jss sername=['数据清洗','表彰、通报批评查询'] pagename='表彰、通报批评查询']
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
								<td class="old" width="10%" style="text-align:right;">企业名称</td><td width="90%">${corpgood_badinfo.corp_name}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">类别</td><td>${corpgood_badinfo.type}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">标题</td><td>${corpgood_badinfo.title}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">发布单位</td><td>${corpgood_badinfo.issueunit}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">发布时间</td><td>${corpgood_badinfo.issuedate}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">来源网站</td><td>${corpgood_badinfo.source}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">网页URL</td><td><a href="${corpgood_badinfo.url}" target="_blank">${corpgood_badinfo.url}</a></td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">网页内容</td><td>${corpgood_badinfo.content}</td>
								</tr>
								<tr>
								<td class="old" style="text-align:right;">可信度</td>
								[#if corpgood_badinfo.credit=='0']	
								<td>可信度低</td>
								[#else]
								<td>可信度高</td>
								[/#if]
								</tr>
								<tr>
								<td class="old" style="text-align:right;">附件</td>
								<td>
									[#if corpgood_badinfo.files??]
										[#list corpgood_badinfo.files as f]
											<a href="${base}/common/file/load?filename=${f}" target="_blank" title="${f}">${f}</a><br/>
										[/#list]
									[/#if]
								</td>
								</tr>	
							</tbody>
						</table>
						<div class="form-actions" style="text-align:center;margin-bottom:20px;">
							<button class="btn btn-xs btn-width btn-primary" type="button" onclick="upInfo('${corpgood_badinfo.id}','1');">采 信</button>
							<button class="btn btn-xs btn-width btn-primary" type="button" onclick="upInfo('${corpgood_badinfo.id}','2');">不采信</button>
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
		 window.location.href=base + "/infowash/good_badinfo/wash/"+id+"/"+state;
	 }
}
</script>
[/@layout.main]
