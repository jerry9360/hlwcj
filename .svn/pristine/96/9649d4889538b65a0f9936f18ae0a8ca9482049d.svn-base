$(function() {   
	FormValidation.init();
   $("a[name='deleteroles']").click(function(){
	   var ele = this;
       bootbox.confirm("确认删除该系统角色?", function(result) {
    	   if(result){
    		   var id = $(ele).attr("value");
    		   window.location.href=base + "/sys/roles/"+id+"/delete";
    	   }
       }); 
   });
   
   $("a[name='deleterolemenu']").click(function(){
	   var ele = this;
       bootbox.confirm("确认删除该角色菜单?", function(result) {
    	   if(result){
    		   var id = $(ele).attr("value");
    		   if(checkRolemenuDelete(id)){
    			   window.location.href=base + "/sys/roles/menu/"+id+"/delete";
    		   }else{
                   bootbox.alert("该角色下有子菜单，不能删除！");
    		   }
    	   }
       }); 
   });
});

function checkRolemenuDelete(id){
	var flag = false; 
	$.ajax({
		type:"GET",
		url:base+"/sys/roles/menu/"+id+"/delete/check",
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

function editRoles(roleid,rolename,roletype,mainpage){
	clearFormErrorInfo();
	$("#editrolesform").attr("action",base+"/sys/roles/"+roleid);
	$("#rolenameEdit").html(rolename);
	$("#rolenameEdit").attr("value",rolename);
	$("#mainpageEdit").val(mainpage);
	$.each($("#roletypeEdit").contents("input[name='roletype']"),function(i,e){
		if($(e).val()==roletype){
			e.checked = true;
		}else{
			e.checked = false;
		}
	});
	
	$("#tab_editroles").click();
}

function addChildMenu(menu,id){
	clearFormErrorInfo();
	$("#parentmenu").val(menu);
	$("#parentid").val(id);
	$("#tab_addmenu").click();
}

function editRolemenu(id,menudesc,shortname,menucode,url,pid,orderno){
	clearFormErrorInfo();
	$("#idEdit").val(id);
	$("#menudescEdit").val(menudesc);
	$("#shortnameEdit").val(shortname);
	$("#menucodeEdit").val(menucode);
	$("#menucodeEditShow").val(menucode);
	$("#pidEdit").val(pid);
	$("#urlEdit").val(url);
	$("#ordernoEdit").val(orderno);
	$("#tab_editrolemenu").click();
}

function mgtRolePermission(roleid,rolename,permissions){
	$("#per_roleid").val(roleid);
	$("#rolenamePermissionEdit").val(rolename);
	clearFunction();
	var firstid = "none";
	if(permissions!=""){
		var perIds = permissions.split(",");
		$.each($("span[name='editrolefunctionid']"),function(id,e){
			$.each(perIds,function(id,str){
				if($(e).children("input[name='functionid']").val()==str){
					$(e).children("input[name='functionid']")[0].checked = true;
					if(firstid=="none"){
						firstid = e;
					}
				}
			});
		});
	}
	initPermissionRadio(firstid);
	$("#tab_editrolepermission").click();
}

function clearAllFunctions(){
    bootbox.confirm("确认清空该角色的所有权限?", function(result) {
    	if(result){
        	clearFunction();
        	initPermissionRadio("none");
    	}
    }); 
}

function clearFunction(){
	var eles = $("span[name='editrolefunctionid']");
	$.each(eles,function(i,e){
		if($(e).children("input[name='functionid']")[0].checked){
			$(e).children("input[name='functionid']")[0].checked = false;
		}
	});
}

function initPermissionRadio(e){
	var per_sizes = parseInt($("#permissions_sizes").html());
	if(e=="none"){
		editPageing(1,per_sizes,$("button[name='edit_btn1']")[0]);
	}else{
		var $tr = $(e).parent().parent();
		var trId = $tr.attr("id");
		var position = parseInt(trId.split("_")[1]);
		var i = position%10;
		var j = Math.floor(position/10);
		var btnStr = "";
		if(i!=0){
			j++;
		}
		btnStr = "button[name='edit_btn"+j+"']";
		editPageing(j,per_sizes,$(btnStr)[0]);
	}
}

function editPageing(m,size,e){
	$("button[name^='edit_btn']").attr("class","btn btn-default");
	$(e).attr("class","btn blue-madison");
	for(var i=1;i<size+1;i++){
		$("#edittr_"+i).hide();
	}
	var position = 10*(m-1)+1;
	var endPosition = position+10;
	for(var j=position;j<endPosition;j++){
		if($("#edittr_"+j).is("tr")){
			$("#edittr_"+j).show();
		}
	}		
}

function expandNote(ele,type){
	var $trs;
	if(type==1){
		$trs = $(ele).parent().parent();
	}else{
		$trs = $(ele).parent().parent().parent();
	}
	var trName = "tree_menu"+(type+1);
	var name = "tree_menu"+type;
	var $nexttr = $trs.next("tr[name^=tree_menu]");
	while($nexttr.attr("name")!=name&&$nexttr.attr("name")!=undefined){
		if($nexttr.attr("name")==trName){
			 $nexttr.show();
		}
		 $nexttr =  $nexttr.next("tr[name^=tree_menu]");
	}
	var html = "<a class='btn btn-xs default' href='javascript:void(0)' onclick='collapseNote(this,"+type+")' style='width:20px;'>-</a>"
	$(ele).replaceWith(html);
	
}

function collapseNote(ele,type){
	var $trs;
	if(type==1){
		$trs = $(ele).parent().parent();
	}else{
		$trs = $(ele).parent().parent().parent();
	}
	var html = "";
	html = "<a class='btn btn-xs default' href='javascript:void(0)' onclick='expandNote(this,"+(type+1)+")' style='width:20px;'>+</a>"
	var trName = "tree_menu"+(type+1);
	var name = "tree_menu"+type;
	var $nexttr = $trs.next("tr[name^=tree_menu]");
	while($nexttr.attr("name")!=name&&$nexttr.attr("name")!=undefined){
		 if($nexttr.attr("name")=="tree_menu"+(type-1)){
			 break;
		 }
		 $nexttr.hide();
		 if($nexttr.attr("name")==trName){
			 $nexttr.children(":first").children(":first").children(":first").replaceWith(html);
		 }
		 $nexttr = $nexttr.next("tr[name^=tree_menu]");
	}
	html = "<a class='btn btn-xs default' href='javascript:void(0)' onclick='expandNote(this,"+type+")' style='width:20px;'>+</a>"
	$(ele).replaceWith(html);
}

//validation using icons
var FormValidation = function () {
	var handleValidation1 = function(e) {
	
	        var form = e;
	        var error1 = $('.alert-danger', form);
	        var success1 = $('.alert-success', form);
	
	        form.validate({
	            errorElement: 'span', //default input error message container
	            errorClass: 'validation_error help-block-error', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            ignore: "",  // validate all fields including form hidden input
	            rules: {
	            	menudesc: {
	            		maxlength: 50,
	                    required: true
	                },
	            	shortname: {
	            		maxlength: 2,
	                    required: true
	                },
	                menucode: {
	                    required: true,
	                    menucode_unique:true
	                },
	                url: {
	                	maxlength:100,
	                    //required: true
	                   // url: true
	                }
	            },
                messages: {
                	menudesc: {
                        maxlength: jQuery.validator.format("菜单名称不能超过50个字符"),
                        required: jQuery.validator.format("请输入菜单名称")
                    },
                	shortname: {
                        maxlength: jQuery.validator.format("菜单简称不能超过2个字符"),
                        required: jQuery.validator.format("请输入菜单简称")
                    },
                    menucode: {
                        required: jQuery.validator.format("请输入菜单代码"),
                        menucode_unique:jQuery.validator.format("菜单代码已存在，请重新输入")
                    },
                    url: {
                        maxlength: jQuery.validator.format("功能URL不能超过100个字符"),
                        //required: jQuery.validator.format("请输入功能URL"),
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
		
        var form2 = $('#editmenuform');
        var error2 = $('.alert-danger', form2);
        var success2 = $('.alert-success', form2);

        form2.validate({
            errorElement: 'span', //default input error message container
            errorClass: 'validation_error help-block-error', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",  // validate all fields including form hidden input
            rules: {
            	menudesc: {
            		maxlength: 50,
                    required: true
                },
            	shortname: {
            		maxlength: 2,
                    required: true
                },
                url: {
                	maxlength:100,
                    //required: true
                   // url: true
                }
            },
            messages: {
            	menudesc: {
                    maxlength: jQuery.validator.format("菜单名称不能超过50个汉字"),
                    required: jQuery.validator.format("请输入菜单名称")
                },
            	shortname: {
                    maxlength: jQuery.validator.format("菜单简称不能超过2个字符"),
                    required: jQuery.validator.format("请输入菜单简称")
                },
                url: {
                    maxlength: jQuery.validator.format("功能URL不能超过100个字符"),
                    required: jQuery.validator.format("请输入功能URL"),
                   // url: jQuery.validator.format("请输入正确的URL")
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
	
var handleValidation4 = function(e) {
	
    var form4 = e;
    var error4 = $('.alert-danger', form4);
    var success4 = $('.alert-success', form4);

    form4.validate({
        errorElement: 'span', //default input error message container
        errorClass: 'validation_error help-block-error', // default input error message class
        focusInvalid: false, // do not focus the last invalid input
        ignore: "",  // validate all fields including form hidden input
        rules: {
        	rolename: {
        		maxlength: 40,
                required: true
            },
            mainpage: {
                required: true
            }
        },
        messages: {
        	rolename: {
                maxlength: jQuery.validator.format("角色名称不能超过40个汉字"),
                required: jQuery.validator.format("请输入角色名称")
            },
            mainpage: {
                required: jQuery.validator.format("请输入角色主页")
            }
        },

        invalidHandler: function (event, validator) { //display error alert on form submit              
            success4.hide();
            error4.show();
            Metronic.scrollTo(error4, -200);
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
        submitHandler: function (form4) {
            success4.show();
            error4.hide();
            form4.submit();
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
	        handleValidation1($('#addmenuform'));
	        handleValidation2();
	        handleValidation1($('#addchildmenuform'));
	        handleValidation4($('#addrolesform'));
	        handleValidation4($('#editrolesform'));
	    }
	};
}();

function clearFormErrorInfo(){
	$('.form-group').removeClass('has-error');
	$('.form-group').each(function(i,e){
		if($(e).contents("span[class='validation_error help-block-error']").is("span")){
			$(e).contents("span[class='validation_error help-block-error']").remove();
		}
	});
}

jQuery.validator.addMethod("menucode_unique", function(value, element) {
	var flag = false;
	var roleid = $("#rolemenu_roleid").html();
	$.ajax({
		type:"post",
		cache:false,
		async:false,
		url:base+"/sys/roles/menu/code/check",
		data:{
			roleid:roleid,
			menucode:value,
		},
		dataType:"text",
		success:function(data){
			if(data=="success"){
				flag = true;
			}else{
				flag = false;
			}
		},
		error:function(){
		}
	});
	return this.optional(element) || flag;
}, "Letters, numbers, and underscores only please");

