$(function() { 
	FormValidation.init();
   $("a[name='deleteper']").click(function(){
	   var ele = this;
       bootbox.confirm("确认删除该系统功能?", function(result) {
    	   if(result){
    		   var id = $(ele).attr("value");
    		   if(checkPerdelete(id)){
    			   window.location.href=base + "/sys/permission/"+id+"/delete";
    		   }else{
                   bootbox.alert("该系统功能有被角色使用，不能删除！");
    		   }
    	   }
       }); 
   });
});

function editPermission(functionid,functiondesc,url){
	clearFormErrorInfo();
	$("#editperform").attr("action",base+"/sys/permission/"+functionid);
	$("#functiondescEdit").html(functiondesc);
	$("#functiondescEdit").attr("value",functiondesc);
	$("#urlEdit").val(url);
	$("#tab_editper").click();
}

function checkPerdelete(functionid){
	var flag = false; 
	$.ajax({
		type:"GET",
		url:base+"/sys/permission/"+functionid+"/delete/check",
		cache:false,
		async:false,
		dataType:"text",
		success:function(data){
			if(data=="success"){
				flag = true;
			}
		},
		error:function(){
		}
	});
	return flag;
}

//validation using icons
var FormValidation = function () {
	var handleValidation = function() {
	
	        var form = $('#addperform');
	        var error1 = $('.alert-danger', form);
	        var success1 = $('.alert-success', form);
	
	        form.validate({
	            errorElement: 'span', //default input error message container
	            errorClass: 'help-block help-block-error', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            ignore: "",  // validate all fields including form hidden input
	            rules: {
	            	functiondesc: {
	            		maxlength: 50,
	                    required: true
	                },
	                url: {
	                	maxlength:100,
	                    required: true
	                   // url: true
	                }
	            },
                messages: {
                	functiondesc: {
                        maxlength: jQuery.validator.format("功能描述不能超过50个汉字"),
                        required: jQuery.validator.format("请输入功能描述")
                    },
                    url: {
                        maxlength: jQuery.validator.format("功能URL不能超过50个字符"),
                        required: jQuery.validator.format("请输入功能URL"),
                       // url: jQuery.validator.format("请输入正确的URL")
                    }
                },
	
                invalidHandler: function (event, validator) { //display error alert on form submit              
                    success1.hide();
                    error1.show();
                    Metronic.scrollTo(error1, -200);
                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.form-group').addClass('has-error'); // set error class to the control group
                },

                unhighlight: function (element) { // revert the change done by hightlight
                    $(element)
                        .closest('.form-group').removeClass('has-error'); // set error class to the control group
                },

                success: function (label) {
                    label
                        .closest('.form-group').removeClass('has-error'); // set success class to the control group
                },
                submitHandler: function (form) {
                    success1.show();
                    error1.hide();
                    form.submit();
                }
	        });
	}
	
	var handleValidation2 = function() {
		
        var form2 = $('#editperform');
        var error2 = $('.alert-danger', form2);
        var success2 = $('.alert-success', form2);

        form2.validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block help-block-error', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",  // validate all fields including form hidden input
            rules: {
            	functiondesc: {
            		maxlength: 50,
                    required: true
                },
                url: {
                	maxlength:100,
                    required: true
                    //url: true
                }
            },
            messages: {
            	functiondesc: {
                    maxlength: jQuery.validator.format("功能描述不能超过50个汉字"),
                    required: jQuery.validator.format("请输入功能描述")
                },
                url: {
                    maxlength: jQuery.validator.format("功能URL不能超过50个字符"),
                    required: jQuery.validator.format("请输入功能URL"),
                    //url: jQuery.validator.format("请输入正确的URL")
                }
            },

            invalidHandler: function (event, validator) { //display error alert on form submit              
                success2.hide();
                error2.show();
                Metronic.scrollTo(error2, -200);
            },

            highlight: function (element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            unhighlight: function (element) { // revert the change done by hightlight
                $(element)
                    .closest('.form-group').removeClass('has-error'); // set error class to the control group
            },

            success: function (label) {
                label
                    .closest('.form-group').removeClass('has-error'); // set success class to the control group
            },
            submitHandler: function (form2) {
                success2.show();
                error2.hide();
                form2.submit();
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
	    //main function to initiate the module
	    init: function () {
	        handleWysihtml5();
	        handleValidation();
	        handleValidation2();
	    }
	};
}();

function clearFormErrorInfo(){
	$('.form-group').removeClass('has-error');
	$('.form-group').each(function(i,e){
		if($(e).contents("span[class='help-block help-block-error']").is("span")){
			$(e).contents("span[class='help-block help-block-error']").remove();
		}
	});
}
