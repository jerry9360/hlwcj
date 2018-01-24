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
	<div class="typname">${message("{$packagelastname}.{$table.code}.title")}</div>
</div>
<div class="tc01_right mar-left">
	<div class="tabbable bor_ddsh rb_oo1">
		<ul>
        [#list page.content as {$table.code}]
            <li>
                {$while}
                <div class="tc_cw_car position">${message("{$packagelastname}.{$table.code}.{$column.code}")}:<span>${{$table.code}.{$column.code}}</span> 个</div>
                {$whileEnd}
                <a class="absolute tc_liimga" href="${webRoot}/{$packagelastname}/{$table.code}/${{$table.code}.id}/show">${message("showdetail")}</a></div>
            </li>
        [/#list]
		</ul>
	</div>
	<div id="pagination" class="pages text_right">
		<span class="page2">  
			<a>
				[#if pageable.offset ==0 ]
                	[@spring.messageArgs "{$packagelastname}.page.display", [page.number+1, pageable.offset/9 +2]/]
            	[#else]
            	    [@spring.messageArgs "{$packagelastname}.page.display", [page.number+1, pageable.offset/9+1]/]
                [/#if]
			</a>
			
			[#list 0.. page.totalElements/9 as t]
				[#if t lte page.totalElements/9]
					<a href="${webRoot}/{$packagelastname}/{$table.code}?page=${t}&f=${filter}&[@sort_q pageable.sort /]" class="text_center">${t+1}</a>
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
            [#if pageable.offset ==0 ]
            	<a href="${webRoot}/{$packagelastname}/{$table.code}?page=${pageable.offset/9 +1}&f=${filter}&[@sort_q pageable.sort /]" class="text_center">${message("page.last")}>></a>
        	[#else]
        	    <a href="${webRoot}/{$packagelastname}/{$table.code}?page=${pageable.offset/9 }&f=${filter}&[@sort_q pageable.sort /]" class="text_center">${message("page.last")}>></a>
            [/#if]
        </span>
    </div>
</div>

[/@layout.main]
