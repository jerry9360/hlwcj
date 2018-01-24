[#macro sort_q sort][#if (sort)??][#list sort.iterator() as order]
[#if order_index != 0]&[/#if]sort=${order.property},${order.direction}
[/#list][/#if][/#macro]

[#macro header title orderProperty sort]
  <th class="col header [#if (sort)??][#list sort.iterator() as order][#if order.roperty == orderProperty][#if order.direction == "ASC"]headerSortDown[#else]headerSortUp[/#if][/#if][#break/][/#list][/#if]">
      <a href="webRoot/{$table.code}?sort=${orderProperty},[#if (sort)??][#list sort.iterator() as order][#if order.direction == "DESC"]ASC[#else]DESC[/#if][#break/][/#list][/#if]">${title}</a>
  </th>
[/#macro]

[#assign breads=[{"name":message('{$packagelastname}.title'), "value":message('{$packagelastname}.url')}, {"name":message("{$packagelastname}.{$table.code}.title"), "value":"/{$packagelastname}/{$table.code}"}]]
[#import "{$packagelastname}/layout.ftl" as layout]
[@layout.main title=message('{$packagelastname}.{$table.code}.manage.title') modlecode="{$table.code}" bread=breads]

<div class="right mar-left">

<div class="typname">停车场信息一览</div>
	<div class="ps_10 position" style="box-sizing: border-box;height:50px">
		<div class="container tenement" style="box-sizing: border-box;">
		  <table style="box-sizing: border-box">
				<tr>
					<td>停车场名称：</td>
					<td><input class="form-tenement"  name="parkname" id=" name="parkname" size="16" type="text" value="${{$table.code}.parkname}"></td>
					<td align="right"><a href="${webRoot}/{$packagelastname}/{$table.code}/listedit" class="querybtn text_center" style="display: inline-block;margin-left:300px">搜索</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div align="right" style="height: 40px; box-sizing: border-box;"  >
		<a href="javascript:void(0)" class="querybtn text_center" style="display: inline-block;margin-right:78px">添加新停车场</a>
	</div>

  <div class="tabbable bor_ddsh rb_oo1">
    <table class="tes_table_dy">
      <thead>
	      <tr>
          {$while}
	        <th class="text_center">${message("{$packagelastname}.{$table.code}.{$column.code}")}</th>
          {$whileEnd}
	      </tr>
      </thead>
      <tbody>
        [#list page.content as {$table.code}]
        <tr>
          {$while}
	        <td class="text_center">${{$table.code}.{$column.code}}</td>
          {$whileEnd}
          <td class="text_center"><a href="${webRoot}/{$packagelastname}/{$table.code}/${{$table.code}.id}/show">${message("showdetail")}</a></td>
        </tr>
        [/#list]
      </tbody>
	  </table>
  </div>

	<div id="pagination" class="pages text_right">
		<span class="page2">  
			<a>
				[#if pageable.offset ==0]
          [@spring.messageArgs "{$packagelastname}.page.display", [page.number+1, pageable.offset/9 +2]/]
        [#else]
          [@spring.messageArgs "{$packagelastname}.page.display", [page.number+1, pageable.offset/9+1]/]
        [/#if]
			</a>
			
			[#list 0.. page.totalElements/9 as t]
				[#if t lte page.totalElements/9]
					<a href="${webRoot}/{$packagelastname}/{$table.code}?page/listedit=${t}&f=${filter}&[@sort_q pageable.sort /]" class="text_center">${t+1}</a>
				[/#if]
			[/#list]
		</span>
    <span class="page1">
    	<a href="${webRoot}/{$packagelastname}/{$table.code}?page=0&f=${filter}&[@sort_q pageable.sort /]" class="text_center"><<${message("page.first")}</a>
      [#if page.hasPrevious()]
        <a href="${webRoot}/{$packagelastname}/{$table.code}?page=${page.number - 1}&f=${filter}&[@sort_q pageable.sort /]" class="text_center">${message("page.previous")}</a>
      [#else]
        <a class="next disabled" >${message("page.previous")}</a>
      [/#if]
      [#if page.hasNext()]
        <a href="${webRoot}/{$packagelastname}/{$table.code}?page=${page.number + 1}&f=${filter}&[@sort_q pageable.sort /]" class="text_center">${message("page.next")}</a>
      [#else]
        <a class="next disabled">${message("page.next")}</a>
      [/#if]
      [#if pageable.offset ==0]
      	<a href="${webRoot}/{$packagelastname}/{$table.code}?page=${pageable.offset/9 +1}&f=${filter}&[@sort_q pageable.sort /]" class="text_center">${message("page.last")}>></a>
  	  [#else]
  	    <a href="${webRoot}/{$packagelastname}/{$table.code}?page=${pageable.offset/9 }&f=${filter}&[@sort_q pageable.sort /]" class="text_center">${message("page.last")}>></a>
      [/#if]
    </span>
  </div>
</div>
</div>

[/@layout.main]
