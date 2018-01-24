[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['fw_service' ] otherjs=jss sername=['服务接口信息查询','接口信息'] ]
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
									<td class="old" width="12%" style="text-align:right;">接口名称</td><td width="44%">${serviceinterface.interface_name}</td>
									
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">访问地址</td><td width="44%">${serviceinterface.visit_url}</td>
														
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">命名空间</td><td width="44%">${serviceinterface.name_space}</td>
															
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">方法名</td><td width="44%">${serviceinterface.function_name}</td>
																
								</tr>
								<tr>
									<td class="old" width="12%" style="text-align:right;">参数名</td><td width="44%">${serviceinterface.parameter_name}</td>
															
								</tr>
					
							</tbody>
						</table>
[/@layout.main]
