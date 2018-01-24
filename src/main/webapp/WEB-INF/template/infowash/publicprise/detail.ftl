[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['wash_publicprise','infowash'] otherjs=jss sername=['数据清洗','公众表扬'] pagename='公众表扬']
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
									<td class="old" width="10%" style="text-align:right;">企业名称</td><td width="90%">${prise.corp_name}</td>
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">受理单号</td><td width="90%">${prise.accept_num}</td>
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">受表扬时间</td><td width="90%">${prise.prisetime}</td>								
								</tr>
																<tr>
									<td class="old" width="10%" style="text-align:right;">表扬单位</td><td width="90%">${prise.priseunit}</td>
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">表扬内容</td><td width="90%">${prise.name}</td>								
								</tr>
																<tr>
									<td class="old" width="10%" style="text-align:right;">数据来源</td><td width="90%">${prise.casenumber}</td>
								</tr>
								<tr>
									<td class="old" width="10%" style="text-align:right;">状态</td><td width="90%">[#if prise.state=='0']待清洗[#elseif prise.state=='1']采信[#else]不采信[/#if]</td>
								</tr>
							</tbody>
						</table>
						<div class="form-actions" style="text-align:center;margin-bottom:20px;">
							<button class="btn btn-xs btn-width btn-primary" type="button" onclick="upInfo('${prise.id}','1');">采 信</button>
							<button class="btn btn-xs btn-width btn-primary" type="button" onclick="upInfo('${prise.id}','2');">不采信</button>
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
		 window.location.href=base + "/infowash/publicprise/wash/"+id+"/"+state;
	 }
}
</script>
[/@layout.main]
