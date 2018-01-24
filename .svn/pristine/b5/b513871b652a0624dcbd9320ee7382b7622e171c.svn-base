[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['zhongbiao','infocheck'] otherjs=jss sername=['项目招标(中标)信息查询','中标信息'] pagename='中标信息']
		[#macro sub info]
	[#if info?length>65]
		${info[0..65]}....
	[#else]
		${info}
	[/#if]
	[/#macro]
	<button class="btn btn-sm btn-primary" type="button" onclick="window.history.go(-1)">返 回</button>
						<table class="table table-bordered dataTable no-footer">
							<tbody>
								<tr>
									<td class="old" width="12%" style="text-align:right;">项目名称</td><td width="44%">${zhongbiaogg.project_name}</td>
									<td class="old" width="12%" style="text-align:right;">项目编号</td><td width="44%">${zhongbiaogg.project_code_cq}</td>
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">行业类别</td><td width="44%">${zhongbiaogg.industry}</td>
									<td class="old" width="12%" style="text-align:right;">中标类别</td><td width="44%">${zhongbiaogg.zhongbiao_type}</td>								
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">项目业主</td><td width="44%">${zhongbiaogg.zhaobiaoren}</td>
									<td class="old" width="12%" style="text-align:right;">中标代理机构</td><td width="44%">${zhongbiaogg.zhaobiaodaili}</td>								
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">资金来源</td><td width="44%">${zhongbiaogg.zijinlaiyuan}</td>
									<td class="old" width="12%" style="text-align:right;">中标公告编号</td><td width="44%">${zhongbiaogg.zhongbiao_no}</td>								
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">桩号</td><td width="44%">${zhongbiaogg.zhuanghao}</td>
									<td class="old" width="12%" style="text-align:right;">合同段</td><td width="44%">${zhongbiaogg.htd}</td>								
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">公告发布时间</td><td width="44%">${zhongbiaogg.gg_update}</td>
									<td class="old" width="12%" style="text-align:right;">第一中标候选人</td><td width="44%">${zhongbiaogg.first_candidate}</td>								
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">第一中标候选人报价金额</td><td width="44%">${zhongbiaogg.first_money}</td>
									<td class="old" width="12%" style="text-align:right;">第二中标候选人</td><td width="44%">${zhongbiaogg.sec_candidate}</td>							
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">第二中标候选人报价金额</td><td width="44%">${zhongbiaogg.sec_money}</td>
									<td class="old" width="12%" style="text-align:right;">第三中标候选人</td><td width="44%">${zhongbiaogg.third_candidate}</td>								
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">第三中标候选人报价金额</td><td width="44%">${zhongbiaogg.third_money}</td>
									<td class="old" width="12%" style="text-align:right;">拟标候选人</td><td width="44%">${zhongbiaogg.main_candidate}</td>								
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">公共类型</td><td width="44%">${zhongbiaogg.gg_type}</td>
									<td class="old" width="12%" style="text-align:right;">状态</td>
									[#if zhongbiaogg.state=='1']	
									<td width="44%">采信</td>
									[#elseif zhaobiaogg.state=='2']
									<td width="44%">不采信</td>	
									[#else]
									<td width="44%">待清理</td>
									[/#if]
									</td>								
								</tr>	
								<tr>
									<td class="old" width="12%" style="text-align:right;">拟标候选人报价金额</td><td width="44%">${zhongbiaogg.main_money}</td>
									<td class="old" width="12%" style="text-align:right;">来源网站</td><td width="44%">${zhongbiaogg.web_name}</td>								
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">文章内容</td><td colspan="3">${zhongbiaogg.web_content}</td>
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">网址URL</td><td width="44%"><a href="${zhongbiaogg.url}" target="_blank">${zhongbiaogg.url}</a></td>
									<td class="old" width="12%" style="text-align:right;">网址所属单位</td><td width="44%">${zhongbiaogg.webunit}</td>								
								</tr>
								<tr>
									<td class="old" style="text-align:right;">可信度</td>
									[#if zhongbiaogg.credit=='0']	
									<td colspan="3">可信度低</td>
									[#else]
									<td colspan="3">可信度高</td>
									[/#if]
								</tr>
								<tr>
									<td class="old" style="text-align:right;">附件</td>
									<td colspan="3">
<!-- 									[#if zhongbiaogg.files??] -->
<!-- 										[#list zhongbiaogg.files as f] -->
											<a href="${base}/common/file/load?filename=${f}" target="_blank" title="${f}">${f}</a><br/>
<!-- 										[/#list] -->
<!-- 									[/#if] -->
									</td>
								</tr>	
							</tbody>
						</table>
[/@layout.main]
