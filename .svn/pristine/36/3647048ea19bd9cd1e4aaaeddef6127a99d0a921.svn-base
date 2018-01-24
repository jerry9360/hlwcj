[#assign breads=[{"name":message('{$packagelastname}.title'), "value":message('{$packagelastname}.url')}, {"name":message("{$packagelastname}.{$table.code}.title"), "value":"/{$packagelastname}/{$table.code}"}]]
[#import "{$packagelastname}/layout.ftl" as layout]
[@layout.main title=message('{$packagelastname}.{$table.code}.manage.title') modlecode="{$table.code}" bread=breads]

<div class="right mar-left">
	<table class="table table-bordere_hy ">
		<thead>
            <tr>
              <th class="tab1 weight" style="padding-left:20px;">${{$table.code}.parkname}</th>
              <th class="text_center tab1"></th>
              <th class="tab1 text_center"></th>
            </tr>
        </thead>
    </table>
	<div class="tc_table1">
		<table class="table-bordered table-responsive">
			<tbody>
	            <tr>
	              	<td><img width="189" height="118" src="${webRoot}${{$table.code}.picpath}"></td>
	             	<td class="padding_lr10">
					<table class="table-bordered table-responsive padding_he list_imgs">
						<tbody>
		                    {$while}
							<tr>
								<td class="modal_span">${message("{$packagelastname}.{$table.code}.{$column.code}")}:</td>
								<td class="modal_span1">${{$table.code}.{$column.code}}</td>
							</tr>
		                    {$whileEnd}
						</tbody>
					</table>
					</td>
	            </tr>
	        </tbody>
	    </table>
	</div>

	<div class="hdxq_div_tc1">
		<a href="javascript:void(0)" onclick="return window.history.back();" >${message("gotopre")}</a>
        <a href="${webRoot}"  > ${message("gotohome")}</a>
	</div>
</div>

[/@layout.main]
