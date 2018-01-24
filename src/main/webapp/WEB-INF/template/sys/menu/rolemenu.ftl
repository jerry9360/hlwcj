[#assign modelcodes=['rolemgr','adminmgr']]
[#assign jss=[]]
[#import "common/layout.ftl" as layout] 
[@layout.main modelcode=modelcodes otherjs=jss sername=['系统管理','角色管理'] pagename='角色管理']
[#macro sub info]
	[#if info?length>20]
		${info[0..20]}....
	[#else]
		${info}
	[/#if]
[/#macro]
		<div class="form-actions">
			<button class="btn btn-sm btn-primary" type="button" onclick="menuconfirm();">提 交</button>
			<a class="btn btn-sm btn-primary" href="${base}/adminmgr/role">返回角色管理</a>
		</div>
		<span style="font-size:13px;color:red;">角色名称：${role.rolename},角色编码;${role.rolecode}</span>
		<form action="${base }/adminmgr/menu" method="post" id="rolemenuform">
		<input name="roleid" value="${roleid }" type="hidden" id="roleid">
			<table id="sample-table-1"
				class="table table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" style="width:5%;"></th>
						<th style="width:20%;">功能描述</th>
						<th style="width:20%;">菜单简称</th>
						<th style="width:15%;">菜单编码</th>
						<th style="width:20%;">Url</th>
						<th style="width:5%;">序号</th>
						<th style="width:5%;">操作</th>
					</tr>
				</thead>
				<tbody>
				[#list menulist as menu]
				[#if !menu.pid??]
					<tr>
						<td style="text-align: center;">
							<button style="width: 50%" class="btn btn-xs btn-success" name="${menu.id }" fname="${menu.id }" onclick="showchildmenu(this)">+</button>
						</td>
						<td>${menu.menudesc }</td>
						<td>${menu.shortname }</td>
						<td>${menu.menucode }</td>
						<td>${menu.url }</td>
						<td>${menu.orderno }</td>
						<td>
						<input id="fmenuselect${menu.id }${menu_index+1}"  name="menuid" value="${menu.id }" type="checkbox"  [#list menuexidlist as menuex][#if menuex.id==menu.id]checked[/#if][/#list]>
						</td>
					</tr>
					[#list menulist as menu2]
						[#if menu.id==menu2.pid]
						<tr  name="pid${menu.id }" hidden="hidden" fname="pid${menu.id }">
							<td style="text-align: right;"></td>
							<td>${menu2.menudesc }</td>
							<td>${menu2.shortname }</td>
							<td>${menu2.menucode }</td>
							<td title="${menu2.url}">[@sub menu2.url][/@sub]</td>
							<td>${menu2.orderno }</td>
							<td>
								<input id="cmenuselect${menu2.id }${menu2_index+1}" fid="${menu.id }"  name="menuid" value="${menu2.id }" type="checkbox"  [#list menuexidlist as menuex][#if menuex.id==menu2.id]checked[/#if][/#list]>
								<input type="hidden" value="${menu2.pid }">
							</td>
						</tr>
						[/#if]
					[/#list]
					[/#if]
					[/#list]
				</tbody>
			</table>
			</form>
<script type="text/javascript">
function showchildmenu(ele){
	var fid = $(ele).attr("name");
	var ffid = $(ele).attr("fname");
	var html = "<button style='width: 50%' class='btn btn-xs btn-success' name='" + fid + "' fname='" + ffid + "' onclick='hidechildmenu(this)'>-</button>";
	$(ele).replaceWith(html);
	$("tr[name='pid"+ fid + "']").show();
}

function hidechildmenu(ele){
	var fid = $(ele).attr("name");
	var ffid = $(ele).attr("fname");
	var html = "<button style='width: 50%' class='btn btn-xs btn-success' name='" + fid + "' fname='" + ffid + "' onclick='showchildmenu(this)'>+</i></button>";
	$(ele).replaceWith(html);
	$("tr[name='pid"+ fid + "']").hide();
	$("tr[fname='pid"+ fid + "']").hide();
	$("button[fname='"+ fid + "']").each(function(index, element){
		$(element).attr("onclick","showchildmenu(this)")
		$(element).text("+");
	});
}

// function checkChildmenu(ele){
// 	if(ele.checked==false){
// 		var fid = ele.value;
// 		$("input[fid^='"+ fid + "']").removeAttr("checked");
// 	}
// }

// function checkFathermenu(ele){
// 	if(ele.checked==true){
// 		var fid = $(ele).next().val();
// 		var ffid = $(ele).attr("fid");
// 		$("input[id^='fmenuselect"+ ffid + "']").attr("checked",'true');
// 		$("input[id^='cmenuselect"+ fid + "']").attr("checked",'true');
// 	}
// }

// function checkFatherAndChildmenu(ele){
// 	if(ele.checked==false){
// 		var fcid = ele.value;
// 		$("input[fcid^='"+ fcid + "']").removeAttr("checked");
// 	}
// 	if(ele.checked==true){
// 		var fid = $(ele).next().val();
// 		$("input[id^='fmenuselect"+ fid + "']").attr("checked",'true');
// 	}
// }

function menuconfirm(){
	$("#rolemenuform").submit();
}
</script>
[/@layout.main]
