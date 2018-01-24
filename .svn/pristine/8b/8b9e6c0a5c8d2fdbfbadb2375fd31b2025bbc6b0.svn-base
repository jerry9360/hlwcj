$(function() {    
   $("a[name='deleteper']").click(function(){
	   var ele = this;
       bootbox.confirm("确认删除该公共代码?", function(result) {
    	   if(result){
    		   var id = $(ele).attr("value");
    		  
    		   window.location.href=base + "/sys/generalcode/"+id+"/delete";
    	   }
       }); 
   });
	   FormValidation.init();
});

var FormValidation = function() {
	var handleValidation = function(e) {
		var form = e;
		var error1 = $('.alert-danger', form);
		var success1 = $('.alert-success', form);

		form.validate({
			errorElement : 'span', 
			errorClass : 'validation_error help-block-error',
			focusInvalid : false,
			ignore : "", 
			rules : {
				codeid : {
					maxlength : 10,
					required : true
				},
				codedesc : {
					maxlength : 30,
					required : true
				},
				ucode: {
					maxlength : 10,
					required : true
				},
				usedfrequency: {
					maxlength : 10,
					required : true
				},
				fatherid: {
					maxlength : 10,
					required : true
				},
				memo: {
					maxlength : 200,
					required : true
				}
			},
			messages : {
				codeid : {
					maxlength : jQuery.validator.format("代码编号长度过长"),
					required : jQuery.validator.format("请输入代码编号")
				},				
				codedesc : {
					maxlength : jQuery.validator.format("代码名称长度过长"),
					required : jQuery.validator.format("请输入代码名称")
				},
				ucode : {
					maxlength : jQuery.validator.format("代码长度过长"),
					required : jQuery.validator.format("请输入代码")
				},
				usedfrequency : {
					maxlength : jQuery.validator.format("顺序号长度过长"),
					required : jQuery.validator.format("请输入顺序号")
				},
				fatherid : {
					maxlength : jQuery.validator.format("上级代码长度过长"),
					required : jQuery.validator.format("请输入上级代码")
				},
				memo : {
					maxlength : jQuery.validator.format("memo长度过长"),
					required : jQuery.validator.format("请输入memo")
				}
			},

			invalidHandler: function (event, validator) {             
                success1.hide();
                error1.show();
                Metronic.scrollTo(error1, -200);
            },

        
            highlight: function (element) { 
                $(element)
                    .closest('.form-group').addClass('has-error'); 
            },

            unhighlight: function (element) {
                $(element)
                    .closest('.form-group').removeClass('has-error'); 
            },

            success: function (label) {
                label
                    .closest('.form-group').removeClass('has-error');
            },
            submitHandler: function (form) {
                success1.show();
                error1.hide();
                form.submit();
            }
		});
	}
	
	var handleValidation2 = function() {
		var form2 = $('#codeeditform');
		var error2 = $('.alert-danger', form2);
		var success2 = $('.alert-success', form2);

		form2.validate({
			errorElement : 'span', 
			errorClass : 'validation_error help-block-error', 
			focusInvalid : false, 
			ignore : "",
			rules : {
				codedesc : {
					maxlength : 30,
					required : true
				},
				ucode: {
					maxlength : 10,
					required : true
				},
				usedfrequency: {
					maxlength : 10,
					required : true
				},
				fatherid: {
					maxlength : 10,
					required : true
				},
				memo: {
					maxlength : 200,
					required : true
				}
			},
			messages : {			
				codedesc : {
					maxlength : jQuery.validator.format("代码名称长度过长"),
					required : jQuery.validator.format("请输入代码名称")
				},
				ucode : {
					maxlength : jQuery.validator.format("代码长度过长"),
					required : jQuery.validator.format("请输入代码")
				},
				usedfrequency : {
					maxlength : jQuery.validator.format("顺序号长度过长"),
					required : jQuery.validator.format("请输入顺序号")
				},
				fatherid : {
					maxlength : jQuery.validator.format("上级代码长度过长"),
					required : jQuery.validator.format("请输入上级代码")
				},
				memo : {
					maxlength : jQuery.validator.format("memo长度过长"),
					required : jQuery.validator.format("请输入memo")
				}
			},

			invalidHandler: function (event, validator) {             
                success2.hide();
                error2.show();
                Metronic.scrollTo(error2, -200);
            },

            highlight: function (element) { 
                $(element)
                    .closest('.form-group').addClass('has-error'); 
            },

            unhighlight: function (element) { 
                $(element)
                    .closest('.form-group').removeClass('has-error'); 
            },

            success: function (label) {
                label
                    .closest('.form-group').removeClass('has-error'); 
            },
            submitHandler: function (form2) {
                success2.show();
                error2.hide();
                form2.submit();
            }
		});
	}
	
	var handleValidation3 = function() {
		var form3 = $('#generalcodenameedit');
		var error3 = $('.alert-danger', form3);
		var success3 = $('.alert-success', form3);

		form3.validate({
			errorElement : 'span', 
			errorClass : 'validation_error help-block-error', 
			focusInvalid : false, 
			ignore : "",
			rules : {
				codetableid : {
					maxlength : 10,
					required : true
				},
				codetablename: {
					maxlength : 20,
					required : true
				},
				codetabledesc: {
					maxlength : 30,
					required : true
				}
			},
			messages : {			
				codetableid : {
					maxlength : jQuery.validator.format("类别编号长度过长"),
					required : jQuery.validator.format("请输入类别编号")
				},
				codetablename : {
					maxlength : jQuery.validator.format("类别名称长度过长"),
					required : jQuery.validator.format("请输入类别名称")
				},
				codetabledesc : {
					maxlength : jQuery.validator.format("类别说明长度过长"),
					required : jQuery.validator.format("请输入类别说明")
				}
			},

			invalidHandler: function (event, validator) {             
                success3.hide();
                error3.show();
                Metronic.scrollTo(error3, -200);
            },

            highlight: function (element) { 
                $(element)
                    .closest('.form-group').addClass('has-error'); 
            },

            unhighlight: function (element) {
                $(element)
                    .closest('.form-group').removeClass('has-error'); 
            },

            success: function (label) {
                label
                    .closest('.form-group').removeClass('has-error');
            },
            submitHandler: function (form3) {
                success3.show();
                error3.hide();
                form3.submit();
            }
		});
	}
	  var handleWysihtml5 = function() {
	        if (!jQuery().wysihtml5) {
	            
	            return;
	        }

	        if ($('.wysihtml5').size() > 0) {
	            $('.wysihtml5').wysihtml5({
	                "stylesheets": ["../../assets/global/plugins/bootstrap-wysihtml5/wysiwyg-color.css"]
	            });
	        }
	    }
	return {
		init : function() {
			handleWysihtml5();
			handleValidation($('#generalcodeform'));
			handleValidation2();
			handleValidation3();
		}
	};
	}();


function editcode(codetableid,codeid){
	$.ajax({
		type:"GET",
		url:base+"/sys/generalcode/"+codetableid+"/"+codeid,
		cache:false,
		async:false,
		dataType:"text",
		success:function(data){
			var info = eval("(" + data + ")");
			$("#codetableid_edit").val(info.codetableid);
			$("#codeid_edit").val(info.codeid);
			$("#ucode_edit").val(info.ucode);
			$("#codedesc_edit").val(info.codedesc);
			$("#memo_edit").val(info.memo);
			$("#usedfrequency_edit").val(info.usedfrequency);
			$("#fatherid_edit").val(info.fatherid);
			
			$("#codeeditform :radio").each(function(index, element){
				if(element.value==info.isdisabled){
					element.checked="checked";
				}
			});
		}		
	});
	$("#tab_editcode").click();
}