 <div id="fullbg"></div>
<div class="modal fade bs-modal-lg in" id="large" tabindex="-1" role="dialog" data-backdrop="static" aria-hidden="false" style="display: none;">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-body">
				<div class="portlet box blue-madison ">
					<div class="portlet-title">
						<div class="caption">
							数据存储类别
						</div>
					</div>
					<div class="portlet-body form">
						<form role="form"  method="post"  id="infoForm">
							<input type="hidden" id="id" name="id" value="">
							<table class="table-form">
								<tbody>
									<tr>
										<td style="width:20%;text-align:right;">业务类别</td>
										<td style="width:50%;"><input type="text" id="type" name="type" value="" class="form-control"></td>
										<td style="width:30%;"></td>
									</tr>
									<tr>
										<td style="text-align:right;">数据来源</td>
										<td><textarea id="dataresource" name="dataresource" rows="3" class="form-control"></textarea></td>
										<td>多个数据来源用（“、”）隔开</td>
									</tr>
								</tbody>
							</table>																									
							<div class="form-actions" style="text-align: center;">
								<button class="btn btn-width-70 btn-primary" type="button" onclick="saveform()">保 存</button>
								<button class="btn btn-width-70 default" type="button" onclick="closeform()">取 消</button>
								<button class="btn default" type="button" data-dismiss="modal"  id="close" style="display:none;"></button>
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
	var addinfo = function(){
		 $("input[name='res']").click(); 
			$("#open").click(); 
		 
	}
	var closeform= function(){
		$("input[name='res']").click(); 
		$("#close").click(); 
		
		
	}
	var saveform=function(){
		var type = document.getElementById("type").value.trim();
        var dataresource = document.getElementById("dataresource").value.trim();
		 if(type==""){
				alert("请输入业务名称和数据来源!");
		}else if(type==""){
			alert("请输入业务名称!");
		}else if(dataresource==""  ){
			alert("请输入数据来源!");
		}else{
			save();
		}
		
	}
	var save=function(){
		$.ajax({
			type:"post",
			url:base+"/urlmgr/collectlist/save",
			data:$("#infoForm").serialize(),
			async:true,  
			success:function(data){
				if(data=="SUCCESS"){
					alert("保存成功！");
                    window.location.href=base + "/urlmgr/collectlist";
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
			url:base+"/urlmgr/collectlist/edit/"+id ,
			data:"",
			dataType:"json",
			success:function(data){
				if(data!=null){
					$("#id").val(data.id) ;
					$("#type").val(data.type) ;
					$("#dataresource").val(data.dataresource) ;
					$("#open").click(); 
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
			url:base+"/urlmgr/collectlist/delete/"+id ,
			data:"",
			dataType:"text",
			success:function(data){
				if(data=="SUCCESS"){
					alert("删除成功！");
                    window.location.href=base + "/urlmgr/collectlist";
				}else{
					alert("删除失败！");
				}
			},
			error:function(){
				 alert("数据加载失败");
			}
		});
	}
	

</script>
