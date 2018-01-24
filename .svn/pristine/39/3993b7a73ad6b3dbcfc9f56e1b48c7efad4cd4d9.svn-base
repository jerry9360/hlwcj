$(function() {    
   $("a[name='deleteper']").click(function(){
	   var ele = this;
       bootbox.confirm("确认删除该公共代码类别?", function(result) {
    	   if(result){
    		   var id = $(ele).attr("value");
    		   window.location.href=base + "/sys/generalcodename/"+id+"/delete";
    	   }
       }); 
   });
   if($('#generalcodenameform').length>0){
	   FormValidation.init();
   }
});

var FormValidation = function() {
	var handleValidation = function(e) {
		var form = e;
		var error = $('.alert-danger', form);
		var success = $('.alert-success', form);

		form.validate({
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
                success.hide();
                error.show();
                Metronic.scrollTo(error, -200);
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
                success.show();
                error.hide();
                form.submit();
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
			 handleValidation($('#generalcodenameform'));
		}
	};
}();