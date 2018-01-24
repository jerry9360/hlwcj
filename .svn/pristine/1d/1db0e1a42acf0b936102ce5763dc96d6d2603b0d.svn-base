$(function() {
	personIdUpload();	
	companyIdUpload();
	FormValidation.init();
});
var FormValidation = function() {
	var handleValidation = function() {
		var form = $("#register-form");
		var error = $('.alert-danger', form);
		var success = $('.alert-success', form);
		var formflag = true;
		form.validate({
			errorElement : 'span', //default input error message container
			errorClass : 'help-block help-block-error', // default input error message class
			focusInvalid : false, // do not focus the last invalid input
			ignore : "", // validate all fields including form hidden input
			rules : {	
				loginname : {
					required : true,
					maxlength : 30,
					loginnameunique : true,
					loginnameregex : true
				},
				password : {
					required : true,
					minlength : 6,
					maxlength : 50,
					passwordregex : true
				},
				repassword : {
					required : true,
					equalTo:"#password"
				},
				username : {
					required : true,
					maxlength : 10
				},
				shipname : {
					required : true,
				},
				mail : {
					required : true,
					email:true
				},
				idcardno : {
					required : true,
					maxlength:18,
					minlength:18
					
				},
				phone : {
					required : true,
					number: true,
					maxlength:11,
					minlength:11,
					phoneunique : true
				},
				iccode : {
					required : true,
				}
			},
			messages : {
				loginname : {
					required : jQuery.validator.format("请输入用户名！"),
					maxlength : jQuery.validator.format("用户名过长！"),
					loginnameunique : jQuery.validator.format("用户名已存在，请重新输入！"),
					loginnameregex : jQuery.validator.format("用户名必须是字母和数字组成！")
				},
				password : {
					required : jQuery.validator.format("请输入密码！"),
					maxlength : jQuery.validator.format("密码过长！"),
					minlength : jQuery.validator.format("密码长度不小于6位！"),
					passwordregex : jQuery.validator.format("以字母开头，只能包含字符、数字和下划线！")
				},
				repassword : {
					required : jQuery.validator.format("请输入密码！"),
					equalTo:jQuery.validator.format("两次密码输入不一致！")
				},
				username : {
					required : jQuery.validator.format("请输入申请人姓名！"),
					maxlength : jQuery.validator.format("姓名过长！")
				},
				shipname : {
					required : jQuery.validator.format("请输入所属船舶名称！"),
				},
				mail : {
					required : jQuery.validator.format("请输入电子邮件！"),
					email : jQuery.validator.format("格式错误！")
				},
				phone : {
					required : jQuery.validator.format("请输入手机号码！"),
					number : jQuery.validator.format("格式有误！"),
					maxlength:jQuery.validator.format("请输入11位手机号码！"),
					minlength:jQuery.validator.format("请输入11位手机号码！"),
					phoneunique : jQuery.validator.format("手机号码已存在，请重新输入！")
				},
				idcardno : {
					required : jQuery.validator.format("请输入身份证号！"),
					maxlength:jQuery.validator.format("请输入18位身份证号码！"),
					minlength:jQuery.validator.format("请输入18位身份证号码！")
				},
				iccode : {
					required : jQuery.validator.format("请输入所属船舶初次登记号！"),
				},
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
//                if(checkcompregisterinfoForm()&&formflag){
//                	formflag = false;
//                	form.submit();
//                }
                
              if(formflag){
            	  var imgs = $("img[name='fujian_list']");
            	  if(imgs.length<2){
            		  $("#fujianinfoid").click();
            	  }else{
            		  formflag = false;
            		  form.submit(); 
            	  }
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

jQuery.validator.addMethod("loginnameunique", function(value, element) {  
	return checkLoginname(value);
  }, "用户名已存在，请重新输入！");

jQuery.validator.addMethod("phoneunique", function(value, element) {  
	return checkPhone(value);
  }, "手机号码已存在，请重新输入！");	

jQuery.validator.addMethod("loginnameregex", function(value, element) {  
	var regex = new RegExp("^[A-Za-z0-9]+$");
	if(regex.test(value)){
		return true;
	}else{
		return false;
	}
  }, "");

jQuery.validator.addMethod("passwordregex", function(value, element) {  
	var regex = new RegExp("^[a-zA-Z]{1}[A-Za-z0-9]+$");
	if(regex.test(value)){
		return true;
	}else{
		return false;
	}
  }, "");

function deleteCompanyId() {
	var html = "<img src='' style='height:220px; margin-left: 75px' />";
	$("#companyIdList").html(html);
	$("#dci").hide();
}

function deletePersonId() {
	var html = "<img src='' style='height:220px; margin-left: 75px' />";
	$("#personIdList").html(html);
	$("#dpi").hide();
}

function checkinfo(type,type2) {
	$("#punishtype").val(type);
	$("#submittypeid").val(type2);
	$("#submit_info").click();
}

//登录名唯一性校验
function checkLoginname(loginname){
	var flag = true;
	$.ajax({
		type:"POST",
		url:base + "/common/crewregisterinfo/checkLoginName",
		data:{loginname:loginname},
		async:false,
		success:function(data){
			if(data=="exist"){
				flag = false;
			}
		},
		error:function(){
			flag = false;
		}
	});
	return flag;
}

//手机号码唯一性校验
function checkPhone(phone){
	var flag = true;
	$.ajax({
		type:"POST",
		url:base + "/common/crewregisterinfo/checkPhone",
		data:{phone:phone},
		async:false,
		success:function(data){
			if(data=="exist"){
				flag=false;
			}
		},
		error:function(){
			flag=false;
		}
	});
	return flag;
}

function personIdUpload() {
	var uploader = WebUploader.create({
		auto : true,
		swf : base + '/assets/js/common/webuploader/Uploader.swf',
		server : base + '/common/file',
		fileSingleSizeLimit : 5 * 1024 * 1024, // 5 M
		fileVal : "upfile",
		// 选择文件的按钮。可选。
		// 内部根据当前运行是创建，可能是input元素，也可能是flash.
		pick : '#uploadPersonId',
		duplicate : true,
		// 只允许选择图片文件。
		accept : {
			title : 'images',
			extensions : 'gif,jpg,jpeg,bmp,png',
			mimeTypes : 'image/*'
		}

	});
	// uploadAccept
	// uploader.on( 'uploadAccept', function( object , ret ) {
	// });
	uploader.on(
					'uploadSuccess',
					function(file, response) {
						var info = eval("(" + response._raw + ")");
						if (typeof (info['state']) != 'undefined') {
							if (info['state'] == 'SUCCESS') {
								var name = info['name'];
								var size = info['fileSize'];
								var id = info['id'];
								var fileid = info['fileid'];
								var fileAddr = info['url'];
								var ucode = $("#setUcode").val();
								var html_person =  "<span><input type='hidden' name='crewregisterannex[0].ucode' value='"
											+ ucode
											+ "'>"
											+ "<input type='hidden' name='crewregisterannex[0].fileid' value='"
											+ id
											+ "'>"
											+ "<input type='hidden' name='crewregisterannex[0].annexname' value='身份证图片'></span>"
											+ "<div><image  name='fujian_list' src='"
											+ fileAddr
											+ "'style='height:220px; margin-left: 75px'/>" 
											+ "</div>";
								setTimeout(function () { 
									$("#personIdList").html(html_person);
									$("#dpi").show();
							    }, 3000);
							} else {
								alert('上传出错');
							}
						} else {
							alert('上传出错');
						}

					});

	uploader.on('uploadError', function(file) {
		alert('上传出错');
	});
	uploader.on('error', function(type) {
		if ("F_EXCEED_SIZE" == type) {
			alert('图片大小不能超过5M！');
			return;
		}
		if ("Q_TYPE_DENIED" == type) {
			alert('文件类型不正确！');
			return;
		}

	});
}


function companyIdUpload() {
	var uploader_company = WebUploader.create({
		auto : true,
		swf : base + '/assets/js/common/webuploader/Uploader.swf',
		server : base + '/common/file',
		fileSingleSizeLimit : 5 * 1024 * 1024, // 5 M
		fileVal : "upfile",
		// 选择文件的按钮。可选。
		// 内部根据当前运行是创建，可能是input元素，也可能是flash.
		pick : '#uploadCompanyId',
		duplicate : true,
		// 只允许选择图片文件。
		accept : {
			title : 'images',
			extensions : 'gif,jpg,jpeg,bmp,png',
			mimeTypes : 'image/*'
		}

	});

	// uploadAccept
	// uploader.on( 'uploadAccept', function( object , ret ) {
	// });
	uploader_company.on(
					'uploadSuccess',
					function(file, response) {
						var info = eval("(" + response._raw + ")");
						if (typeof (info['state']) != 'undefined') {
							if (info['state'] == 'SUCCESS') {
								var name = info['name'];
								var size = info['fileSize'];
								var id = info['id'];
								var fileid = info['fileid'];
								var fileAddr = info['url'];
								var ucode = $("#setUcode").val();
								var html =  "<span><input type='hidden' name='crewregisterannex[1].ucode' value='"
											+ ucode
											+ "'>"
											+ "<input type='hidden' name='crewregisterannex[1].fileid' value='"
											+ id
											+ "'>"
											+ "<input type='hidden' name='crewregisterannex[1].annexname' value='船公司营业执照图片'></span>"
											+ "<div><image name='fujian_list' src='"
											+ fileAddr
											+ "'style='height:220px; margin-left: 75px'/>" 
											+ "</div>";
								setTimeout(function () { 
									$("#companyIdList").html(html);
									$("#dci").show();
							    }, 3000);
							} else {
								alert('上传出错');
							}
						} else {
							alert('上传出错');
						}

					});

	uploader_company.on('uploadError', function(file) {
		alert('上传出错');
	});
	uploader_company.on('error', function(type) {
		if ("F_EXCEED_SIZE" == type) {
			alert('图片大小不能超过5M！');
			return;
		}
		if ("Q_TYPE_DENIED" == type) {
			alert('文件类型不正确！');
			return;
		}

	});
}
