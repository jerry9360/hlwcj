$(function(){
//	$("#waterworkrequsubmit").bind("click",function(){
//		waterworkrequSave();
//	});
	
	$("#waterworkdessubmit").bind("click",function(){
		waterworkdesSave();
	});
	
	$("#waterworkannexsubmit").bind("click",function(){
		waterworkannexSave();
	});
	initTime();
	FormValidation.init();
});

function initTime() {
	$(".form_datetime").datetimepicker(
			{
				autoclose : true,
				isRTL : Metronic.isRTL(),
				format : "yyyy-mm-dd hh:ii:ss",
				minuteStep : 1,
				minView : 0,
				pickerPosition : (Metronic.isRTL() ? "bottom-right"
						: "bottom-left"),
				language : 'zh_CN'
			});
}

var waterworkrequSave = function(){
	var workcode = $("#workcode").val();
	var url = $("#waterworkrequform").attr("action")+workcode;
	
	$.ajax({
		url:url,
		type:"POST",
		async:false,
		data:$("#waterworkrequform").serialize(),
		dataType:"text",
		success:function(data){
			if(data == "error" ){
				bootbox.alert("水工作业申请信息保存失败！");
			}else{
				$("#workcode").val(workcode);
				bootbox.alert("水工作业申请信息保存成功！");
			}
		},
		error:function(){
			bootbox.alert("水工作业申请信息保存失败！");
		}
	});
}

var waterworkdesSave = function(){
	var workcode = $("#workcode").val();
	if(workcode == "" || workcode == undefined){
		bootbox.alert("请先输入水工作业申请信息！");
		return;
	}
	var workname = $("#editWorkname").val();
	var techparams = $("#editTechparams").val();
	if(workname == ""){
		bootbox.alert("请输入名称信息！");
		return false;
	}
	if(techparams == ""){
		bootbox.alert("请输入主要技术参数信息！");
		return false;
	}
	if(workname.length >100){
		bootbox.alert("名称长度过长！");
		return false;
	}
	if(techparams.length > 100){
		bootbox.alert("主要技术参数长度过长！");
		return false;
	}
	var url = $("#waterworkdesform").attr("action");
	$.ajax({
		url:url,
		type:"POST",
		async:false,
		data:$("#waterworkdesform").serialize(),
		dataType:"json",
		success:function(data){
			if(data.id == "error" ){
				bootbox.alert("作业船舶及设备信息保存失败！");
			}else{
				var html = "<tr style='height:35px;' id='waterworkdess_"+data.id+"'>" 
							+ "<td style='width: 30%;'>"+data.workname+"</td>"
							+ "<td style='width: 50%;'>"+data.techparams+"</td>"
							+ "<td style='width: 20%;'>" 
							+ "<button class='btn btn-xs btn-primary' type='button' onclick=\"editWaterworkdes(\'"+data.id+"\',\'"+data.workname+"\',\'"+data.techparams+"\')\">编辑</button>"
							+ "<button class='btn btn-xs red' style='margin-left: 8px;' type='button' onclick=\"deleteWaterworkdes(\'"+data.id+"\',\'"+data.workname+"\')\">删除</button>"
							+ "</td></tr>"
				if($("#editId").val()!=""){
					$("#waterworkdess_"+$("#editId").val()).replaceWith(html);
				}else{
					$("#waterworkdescontent").prepend(html);
				}
				clearWaterworkdes();
				bootbox.alert("作业船舶及设备信息保存成功！");
			}
		},
		error:function(){
			bootbox.alert("作业船舶及设备信息保存失败！");
		}
	});
}

var deleteWaterworkdes = function(id,name){
	 var url =base+"/inner/waterworkrequ/waterworkdes/delete/"+id;
     bootbox.confirm("确认要删除此条（"+name+"）信息？", function(result) {
  	   if(result){
  			$.ajax({
  				url:url,
  				type:"GET",
  				async:false,
  				dataType:"text",
  				success:function(data){
  					if(data == "error" ){
  						//$("#waterworkdescontent").children().find("tr[name='waterworkdess_"+id+"']")
  						bootbox.alert("（"+name+")删除失败!");
  					}else{
  						$("#waterworkdess_"+id).remove();
  					}
  				},
  				error:function(){
  					bootbox.alert("（"+name+")删除失败!");
  				}
  			});
  	   }
     });
}

var editWaterworkdes = function(id,workname,techparams){
	$("#editId").val(id);
	$("#editWorkname").val(workname);
	$("#editTechparams").val(techparams);
}

var clearWaterworkdes = function(){ 
	editWaterworkdes("","","");
}

var waterworkannexSave = function(){
	var workcode = $("#workcode").val();
	if(workcode == "" || workcode == undefined){
		bootbox.alert("请先输入水工作业申请信息！");
		return;
	}
	var attention = "";
	var val;
	var reg = new RegExp("^[0-9]*$");  
	var flag = false;
	$.each($("td[name='waterworkannexslist']"),function(i,e){
		if($(e).children(":first")[0].checked){
			flag = true;
			val = $(e).next().next().children(":first").val();
			if(!reg.test(val)){
				attention = "申请材料输入份数中存在非法数字！";
				return false;
			}
		}
	});
	if(!flag){
		bootbox.alert("请选择申请材料信息！");
		return;
	}
	
	if(attention!=""){
		bootbox.alert(attention);
		return;
	}
	var url = $("#waterworkannexform").attr("action");
	$.ajax({
		url:url,
		type:"POST",
		async:false,
		data:$("#waterworkannexform").serialize(),
		dataType:"text",
		success:function(data){
				if(data == "success"){
					bootbox.alert("申请材料信息保存成功！");
				} else {
					bootbox.alert("申请材料信息保存成功！");
				}
		},
		error:function(){
			bootbox.alert("申请材料信息保存失败！");
		}
	});
}

var FormValidation = function() {
	var handleValidation = function() {
		var form = $('#waterworkrequform');
		var error = $('.alert-danger', form);
		var success = $('.alert-success', form);
		var formflag = true;
		form.validate({
			errorElement : 'span', //default input error message container
			errorClass : 'help-block help-block-error', // default input error message class
			focusInvalid : false, // do not focus the last invalid input
			ignore : "", // validate all fields including form hidden input
			rules : {
				projectname : {
					required : true,
					maxlength : 100
				},								
				buildunit : {
					required : true,
					maxlength : 100
				},
				activityunit : {
					required : true,
					maxlength : 100
				},	
				placearea : {
					required : true,
					maxlength : 500
				},	
				buildwork : {
					required : true,
					maxlength : 400 
				},	
				sosstep : {
					required : true,
					maxlength : 400 
				},	
				requman : {
					required : true,
					maxlength : 50 
				},	
				requunit : {
					required : true,
					maxlength : 50 
				},	
				requzipcode : {
					required : true,
					maxlength : 6,
					minlength: 6
				},	
				linkman : {
					required : true,
					maxlength : 30
				},	
				requmanphone : {
					required : true,
					maxlength : 20
				},	
				bankname : {
					required : true,
					maxlength : 50
				},
				accountno : {
					required : true,
					maxlength : 50,
					number:true
				}
			},
			messages : {
				projectname : {
					required : jQuery.validator.format("请输入项目名称！"),
					maxlength : jQuery.validator.format("项目名称过长！")
				},				
				buildunit : {
					required : jQuery.validator.format("请输入建设单位名称！"),
					maxlength : jQuery.validator.format("建设单位名称过长！")
				},
				activityunit : {
					required : jQuery.validator.format("请输入活动主办单位！"),
					maxlength : jQuery.validator.format("活动主办单位过长！")
				},
				placearea : {
					required : jQuery.validator.format("请输入地点范围！"),
					maxlength : jQuery.validator.format("地点范围过长！")
				},
				buildwork : {
					required : jQuery.validator.format("请输入施工作业信息！"),
					maxlength : jQuery.validator.format("施工作业信息过长！")
				},	
				
				
				sosstep : {
					required : jQuery.validator.format("请输入应急措施信息！"),
					maxlength : jQuery.validator.format("应急措施信息过长！")
				},	
				requman : {
					required : jQuery.validator.format("请输入申请人信息！"),
					maxlength : jQuery.validator.format("申请人信息过长！")
				},	
				requunit : {
					required : jQuery.validator.format("请输入申请地址信息！"),
					maxlength : jQuery.validator.format("申请地址信息过长！")
				},	
				requzipcode : {
					required : jQuery.validator.format("请输入申请人邮编信息！"),
					maxlength : jQuery.validator.format("请输入有效申请人邮编信息！"),
					minlength: jQuery.validator.format("请输入有效申请人邮编信息！")
				},	
				linkman : {
					required : jQuery.validator.format("请输入联系人信息！"),
					maxlength : jQuery.validator.format("联系人信息过长！")
				},	
				requmanphone : {
					required : jQuery.validator.format("请输入联系电话信息！"),
					maxlength : jQuery.validator.format("联系电话信息过长！")
				},	
				bankname : {
					required : jQuery.validator.format("请输入账户名称信息！"),
					maxlength : jQuery.validator.format("账户名称信息过长！")
				},
				accountno : {
					required : jQuery.validator.format("请输入账号信息！"),
					maxlength : jQuery.validator.format("账号信息过长！"),
					number:jQuery.validator.format("请输入有效账号！")
				}
			},
			invalidHandler: function (event, validator) {             
                success.hide();
                error.show();
                Metronic.scrollTo(error, -200);
            },
            errorPlacement: function (error, element) {
                var icon = $(element).parent('.input-icon').children('i');
                icon.addClass("fa-warning");  
                icon.attr("data-original-title", error.text()).tooltip({'container': 'body'});
            },
            highlight: function (element) {
                $(element).closest('.form_padding').addClass('has-error');  
                $(element).parent().parent().prev().addClass('validation_error');
            },
            unhighlight: function (element) {
                
            },
            success: function (label, element) {
                var icon = $(element).parent('.input-icon').children('i');
                $(element).closest('.form_padding').removeClass('has-error');
                $(element).parent().parent().prev().removeClass('validation_error');
                icon.removeClass("fa-warning");
            },
            submitHandler: function (form) {
                success.show();
                error.hide();
                if(formflag){
                	formflag = false;
                	form.submit();
                }
            }
		});
	}
	return {
		init : function() {
			handleValidation();
		}
	};
}();