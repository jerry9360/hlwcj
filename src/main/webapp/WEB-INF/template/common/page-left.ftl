<div class="content-left">
	<ul class="inbox-nav">
		<li class="inbox ul-bottom">
			<a href="${base}/index-${userinfo.index}" class="btn-menu">首页</a>
		</li>
		[#list userinfo.menus as m]
			[#if userinfo.index =='maintain']
				[#if m.shortname == 'yunwei']
					<li class="inbox ul-bottom">
					[#if m.url!=null]
						<a href="${base}${m.url}" class="btn" name="pmenu">${m.menudesc}</a>
					[#else]
						<a href="javascript:void(0);" class="btn" name="pmenu">${m.menudesc}<i name="closed" [#if modelcode[1]== m.menucode]class="fa fa-angle-down"[#else]class="fa fa-angle-left"[/#if] style="margin-right: 10px;float:right;"></i></a>
						<ul name="cmenu" class="inbox-nav" style="[#if modelcode[1]== m.menucode]display:block;[#else]display:none;[/#if]">
							[#list m.menus as m2]
							[#if modelcode[0]== m2.menucode]
								[#assign pagetitle=m2.menudesc]
							[/#if]
								<li class="inbox [#if modelcode[0]== m2.menucode]active[/#if]">
									<a class="btn-menu" [#if m2.menucode?ends_with('cognos')]href="${base}/stat/cognos?menuid=${m2.id}"[#else]href="${base}${m2.url}"[/#if] style="border-bottom:0px;"><div style="margin-left:15px;"> ${m2.menudesc}</div></a>
								</li>
							[/#list]
						</ul>
					[/#if]
					</li>
				[/#if]
			[#elseif userinfo.index =='service']
				[#if m.shortname == 'fuwu']
					<li class="inbox [#if modelcode[0]== m.menucode]active[/#if]">
					[#if m.url!=null]
						<a href="${base}${m.url}" class="btn" name="pmenu">${m.menudesc}</a>
					[#else]
						<a href="javascript:void(0);" class="btn" name="pmenu">${m.menudesc}<i name="closed" [#if modelcode[1]== m.menucode]class="fa fa-angle-down"[#else]class="fa fa-angle-left"[/#if] style="margin-right: 10px;float:right;"></i></a>
						<ul name="cmenu" class="inbox-nav" style="[#if modelcode[1]== m.menucode]display:block;[#else]display:none;[/#if]">
							[#list m.menus as m2]
							[#if modelcode[0]== m2.menucode]
								[#assign pagetitle=m2.menudesc]
							[/#if]
								<li class="inbox [#if modelcode[0]== m2.menucode]active[/#if]">
									<a class="btn-menu" [#if m2.menucode?ends_with('cognos')]href="${base}/stat/cognos?menuid=${m2.id}"[#else]href="${base}${m2.url}"[/#if] style="border-bottom:0px;"><div style="margin-left:15px;"> ${m2.menudesc}</div></a>
								</li>
							[/#list]
						</ul>
					[/#if]
					</li>
				[/#if]
			[#elseif userinfo.index =='analyze']
				[#if m.shortname == 'fenxi']
					<li class="inbox [#if modelcode[0]== m.menucode]active[/#if]">
					[#if m.url!=null]
						<a href="${base}${m.url}" class="btn" name="pmenu">${m.menudesc}</a>
					[#else]
						<a href="javascript:void(0);" class="btn" name="pmenu">${m.menudesc}<i name="closed" [#if modelcode[1]== m.menucode]class="fa fa-angle-down"[#else]class="fa fa-angle-left"[/#if] style="margin-right: 10px;float:right;"></i></a>
						<ul name="cmenu" class="inbox-nav" style="[#if modelcode[1]== m.menucode]display:block;[#else]display:none;[/#if]">
							[#list m.menus as m2]
							[#if modelcode[0]== m2.menucode]
								[#assign pagetitle=m2.menudesc]
							[/#if]
								<li class="inbox [#if modelcode[0]== m2.menucode]active[/#if]">
									<a class="btn-menu" [#if m2.menucode?ends_with('cognos')]href="${base}/stat/cognos?menuid=${m2.id}"[#else]href="${base}${m2.url}"[/#if] style="border-bottom:0px;"><div style="margin-left:15px;"> ${m2.menudesc}</div></a>
								</li>
							[/#list]
						</ul>
					[/#if]
					</li>
				[/#if]
			[/#if]
		[/#list]
		 
	</ul>
</div>
<script type="text/javascript">
	$(function(){
		$("a[name='pmenu']").bind("click",function(){
			var cla = $(this).find("i").attr("name");
			if(cla=='open'){
				$(this).find("i").attr("name","closed");
				$(this).find("i").attr("class","fa fa-angle-left");
				$(this).next().hide();
			}else{
				$(this).find("i").attr("name","open");
				$(this).find("i").attr("class","fa fa-angle-down");
				$(this).next().show();
			}
		});
	});
</script>