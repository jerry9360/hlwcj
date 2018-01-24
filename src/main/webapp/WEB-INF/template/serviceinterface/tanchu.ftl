 <div id="fullbg"></div>
<div class="modal fade bs-modal-lg in" id="large" tabindex="-1" role="dialog" data-backdrop="static" aria-hidden="false" style="display: none;">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-body">
				<div class="portlet box blue-madison ">
					<div class="portlet-title">
						<div class="caption">
							数据服务类别
						</div>
					</div>
					<div class="portlet-body form">
						<form role="form"  method="post"  id="infoForm">
							<input type="hidden" id="id" name="id" value="">
							<table class="table-form">
								<tbody>
									<tr>
										<td style="width:20%;text-align:right;">接口名称</td>
										<td style="width:20%;"><input type="text" id="interface_name" name="interface_name" value="" class="form-control"></td>
										<td style="width:20%;"></td>
									</tr>
									<tr>
										<td style="text-align:right;width:20%;">访问地址</td>
										<td style="width:20%;"><input type="text" id="visit_url" name="visit_url" value="" class="form-control"></td>
										<td style="width:20%;"></td>
									</tr>
									<tr>
										<td style="width:20%;text-align:right;">命名空间</td>
										<td style="width:20%;"><input type="text" id="name_space" name="name_space" value="" class="form-control"></td>
										<td style="width:20%;"></td>
									</tr>
									<tr>
										<td style="width:20%;text-align:right;">方法名</td>
										<td style="width:20%;"><input type="text" id="function_name" name="function_name" value="" class="form-control"></td>
										<td style="width:20%;"></td>
									</tr>
									<tr>
										<td style="width:20%;text-align:right;">参数名</td>
										<td style="width:20%;"><input type="text" id="parameter_name" name="parameter_name" value="" class="form-control"></td>
										<td style="width:20%;"></td>
									</tr>
								</tbody>
							</table>																									
							<div class="form-actions" style="text-align: center;">
								<button class="btn btn-width-70 btn-primary" type="button" onclick="saveform()">保 存</button>
								<button class="btn btn-width-70 default" type="button" onclick="closeform()">取 消</button>
								<input id="res" name="res" type="reset" style="display:none;" /> 
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var adddinfo = function(){
		 $("input[name='res']").click(); 
		 $("#fullbg").show();
		 $("#large").show();
	}
	var closeform= function(){
		$("input[name='res']").click(); 
		 $("#fullbg").hide();
		 $("#large").hide();
	}
	var saveform=function(){
		$.ajax({
			type:"post",
			url:base+"/servicemgr/list/save",
			data:$("#infoForm").serialize(),
			async:true,  
			success:function(data){
				if(data=="SUCCESS"){
					alert("保存成功！");
                   location.href=base + "/servicemgr/list";
				}else{
					alert("保存失败！");
				}
			},
			error:function(){
				 alert("数据加载失败");
			}
		});
	}
	
	var editform=function(id){
		$.ajax({
			type:"get",
			url:base+"/servicemgr/list/edit/"+id ,
			data:"",
			dataType:"json",
			success:function(data){
				if(data!=null){
					$("#id").val(data.id) ;
					$("#interface_name").val(data.interface_name) ;
					$("#visit_url").val(data.visit_url) ;
					$("#name_space").val(data.name_space) ;
					$("#function_name").val(data.function_name) ;
					$("#parameter_name").val(data.parameter_name) ;
					 $("#large").show();
				}else{
					alert("数据不存在！")
				}
			},
			error:function(){
				 alert("数据加载失败");
			}
		});
	}
	
	/* var deleteinfo=function(id){
		$.ajax({
			type:"get",
			url:base+"/servicemgr/list/delete/"+id ,
			data:"",
			dataType:"text",
			success:function(data){
				if(data=="SUCCESS"){
					alert("删除成功！");
                    window.location.href=base + "/servicemgr/list";
				}else{
					alert("删除失败！");
				}
			},
			error:function(){
				 alert("数据加载失败");
			}
		});
	}
	 */

</script>
