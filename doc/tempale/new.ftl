[#assign breads=[{"name":message('{$packagelastname}.title'), "value":message('{$packagelastname}.url')}, {"name":message("{$packagelastname}.{$table.code}.title"), "value":"/{$packagelastname}/{$table.code}"}]]
[#assign jss=[ "assets/js/{$packagelastname}/{$table.code}eidt.js"]]
[#import "{$packagelastname}/layout.ftl" as layout]
[@layout.main title=message('{$packagelastname}.{$table.code}.manage.title') modlecode="{$table.code}" bread=breads js=jss]

<div class="right mar-left">
	<div class="typname">${message("{$packagelastname}.{$table.code}.manage.title")}</div>
</div>
<div class="tc01_right mar-left">
	[#include "{$packagelastname}/{$table.code}/_form.ftl"]
</div>

[/@layout.main]
