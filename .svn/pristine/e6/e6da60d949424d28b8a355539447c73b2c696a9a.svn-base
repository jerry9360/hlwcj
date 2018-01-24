
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
										<td style="width:20%;text-align:right;">服务接口</td>
										<td style="width:20%;"><input type="text" id="interfaces" name="interfaces" value="" class="form-control"></td>
										<td style="width:20%;"></td>
									</tr>
									<tr>
										<td style="text-align:right;">服务信用数据类别</td>
										<td><textarea id="data_type" name="data_type" rows="3" class="form-control"></textarea></td>
									</tr>
									<tr>
										<td style="width:20%;text-align:right;">服务单位</td>
										<td style="width:20%;"><input type="text" id="unit" name="unit" value="" class="form-control"></td>
										<td style="width:20%;"></td>
									</tr>
									<tr>
										<td style="width:20%;text-align:right;">服务数据量</td>
										<td style="width:20%;"><input type="text" id="data_size" name="data_size" value="" class="form-control"></td>
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
		 $("#large").show();
	}
	var closeform= function(){
		$("input[name='res']").click(); 
		 $("#large").hide();
	}
	
	
	var saveform=function(){
		$.ajax({
			type:"post",
			url:base+"/servicemgr/logs/save",
			data:$("#infoForm").serialize(),
			async:true,  
			success:function(data){
				if(data=="SUCCESS"){
					alert("保存成功！");
                   location.href=base + "/servicemgr/logs";
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
			url:base+"/servicemgr/logs/edit/"+id ,
			data:"",
			dataType:"json",
			success:function(data){
				if(data!=null){
					$("#id").val(data.id) ;
					$("#interfaces").val(data.interfaces) ;
					$("#data_type").val(data.data_type) ;
					$("#unit").val(data.unit) ;
					$("#data_size").val(data.data_size) ;
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
	
	var deleteinfo=function(id){
		$.ajax({
			type:"get",
			url:base+"/servicemgr/logs/delete/"+id ,
			data:"",
			dataType:"text",
			success:function(data){
				if(data=="SUCCESS"){
					alert("删除成功！");
                    window.location.href=base + "/servicemgr/logs/";
				}else{
					alert("删除失败！");
				}
			}
		});
	}
	

</script>
