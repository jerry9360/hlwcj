$(function() {
FormValidationdangersign.init();
//	$("#dangersignsubmitid").bind("click",function(){
//		dangersignSave();
//	})
});
var dangersignSave = function(){
	if(!checkDangersign()){
		return;
	}
	var url = base+"/requ/dangersign/";
	$.ajax({
		type : "POST",
		url : url,
		data : $("#dangersignform").serialize(),
		dataType : "text",
		async : false,
		success : function(data){
			$("body").data("visacode",data);
			$("#dangersigncloseid").click();
		},
		error:function(){
			bootbox.alert("数据保存失败！")
		}
	});
	visaformSubmit();
}
var checkDangersign = function(){
	return true;
}
var FormValidationdangersign = function() {
	var handleValidation = function() {
		var form = $('#dangersignform');
		var error = $('.alert-danger', form);
		var success = $('.alert-success', form);
		var formflag = true;
		form.validate({
			errorElement : 'span', //default input error message container
			errorClass : 'help-block help-block-error', // default input error message class
			focusInvalid : false, // do not focus the last invalid input
			ignore : "", // validate all fields including form hidden input
			rules : {
				sendgoodsman : {
					required : true,
					maxlength : 30
				},	
				receivegoodsman : {
					required : true,
					maxlength : 30
				},				
				goodsapplyman : {
					required : true,
					maxlength : 30
				},
				applymancertid : {
					required : true,
					maxlength : 20
				},
				goodsremark : {
					maxlength : 100
				},
				transgoodname : {
					required : true,
					maxlength : 10
				},
				securecode : {
					required : true,
					maxlength : 10
				},
				totalweigth : {
					required : true,
					number:true,  
					min : 0,
					max : 999999.99
				},
				totalnum : {
					required : true,
					digits:true,
					min : 0,
					max : 999999
				},
				transapplyman : {
					required : true,
					maxlength : 30
				},
				transapplymancode : {
					required : true,
					maxlength : 20
				},
				transremark : {
					maxlength : 100
				}
			},
			messages : {
				sendgoodsman : {
					required : jQuery.validator.format("请输入发货人名称！"),
					maxlength : jQuery.validator.format("发货人名称过长！")
				},
				receivegoodsman : {
					required : jQuery.validator.format("请输入收货人名称！"),
					maxlength : jQuery.validator.format("收货人名称过长！")
				},
				goodsapplyman : {
					required : jQuery.validator.format("请输入载运申报员名称！"),
					maxlength : jQuery.validator.format("载运申报员名称长度过长！")
				},
				applymancertid : {
					required : jQuery.validator.format("请输入载运申报员证书编号信息！"),
					maxlength : jQuery.validator.format("载运申报员证书编号长度过长！")
				},
				goodsremark : {
					maxlength : jQuery.validator.format("载运备注信息过长！")
				},
				transgoodname : {
					required : jQuery.validator.format("请输入货物名称！"),
					maxlength : jQuery.validator.format("货物名称长度过长！")
				},
				securecode : {
					required : jQuery.validator.format("请输入申报单编号！"),
					maxlength : jQuery.validator.format("申报单编号长度过长！")
				},
				totalweigth : {
					required : jQuery.validator.format("请输入货物总重量！"),
					number:jQuery.validator.format("请输入有效数据！"), 
					min : jQuery.validator.format("请输入正确的货物总重量！"),
					max : jQuery.validator.format("请输入正确的货物总重量！"),
				},
				totalnum : {
					required : jQuery.validator.format("请输入货物件数！"),
					number:jQuery.validator.format("请输入有效数据！"), 
					min : jQuery.validator.format("请输入正确的货物件数！"),
					max : jQuery.validator.format("请输入正确的货物件数！"),
				},
				transapplyman : {
					required : jQuery.validator.format("请输入适运申报人！"),
					maxlength:jQuery.validator.format("适运申报人信息过长！")
				},
				transapplymancode : {
					required : jQuery.validator.format("请输入适运申报人证书编号！"),
					maxlength:jQuery.validator.format("适运申报人证书编号信息过长！")
				},
				transremark : {
					maxlength:jQuery.validator.format("适运备注信息过长！")
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
                	dangersignSave();
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