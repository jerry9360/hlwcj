[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=['crawlerconfig','spider'] otherjs=jss sername=['爬虫配置管理','爬虫深度配置'] pagename='爬虫深度配置']
		<form class="horizontal-form form" id="formid" action="${base}/crawler/crawlerconfig" method="post">
			<input type='hidden' id="id" name="id" value="${crawlerconfig.id}"/>
			<input type='hidden' id="create_date" name="create_date" value="${(crawlerconfig.create_date?string('yyyy-MM-dd HH:mm:ss'))!}"/>
			<table class="table-form">
				<tbody>
					<tr>
						<td class="td-center" style="width:30%;">爬取深度</td>
						<td style="width:40%;">
							<input class="form-control" id="crawl_depth" name="crawl_depth" value="${crawlerconfig.crawl_depth }">
						</td>
						<td style="width:30%;"></td>
					</tr>
					<tr>
						<td class="td-center">爬取线程数</td>
						<td>
							<input class="form-control" id="crawl_thread_num" name="crawl_thread_num" value="${crawlerconfig.crawl_thread_num}">
						</td>
						<td></td>
					</tr>
					<tr>
						<td class="td-center">每轮爬取url上限</td>
						<td>
							<input class="form-control" id="crawl_topn" name="crawl_topn" value="${crawlerconfig.crawl_topn}">
						</td>
						<td></td>
					</tr>							   							   							   							   																																								
				</tbody>
			</table> 
			<div class="form-actions" style="text-align: center;">
				<button class="btn btn-width-70 btn-primary" type="submit" id="submitid">保 存</button>
				<button class="btn btn-width-70 default" type="button" onclick="history.go(-1)">取 消</a></button>
		
			</div>
		</form>
[/@layout.main]
