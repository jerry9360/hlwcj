$(function() {   
	FormValidation1.init();
	FormValidation2.init();
	$("#tree_5").jstree({
		'core' : {
			data : shipport.data
		}
	}); 
  
  $('#tree_5').on('select_node.jstree', function(e,data) {
		if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
			$("#s_btn_aimportname5").val(data.node.text);
			$("#s_btn_aimportid5").val(data.node.id);
			$("#s_btn_outdockname5").val(data.node.text);
			hideMenu5();
		}
  });
  $("#tree_6").jstree({
		'core' : {
			data : cargotype.data
		}
	});

$('#tree_6').on('select_node.jstree', function(e,data) {
		if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
			$("#s_btn_codedesc6").val(data.node.text);
			$("#s_btn_codedesccache6").val(data.node.text);
			$("#s_btn_codeid6").val(data.node.id);
			hideMenu6();
		}
});
$("#tree_7").jstree({
	'core' : {
		data : shipport.data
	}
}); 

$('#tree_7').on('select_node.jstree', function(e,data) {
	if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
		$("#s_btn_aimportname7").val(data.node.text);
		$("#s_btn_aimportid7").val(data.node.id);
		$("#s_btn_outdockname7").val(data.node.text);
		hideMenu7();
	}
});
$("#tree_8").jstree({
	'core' : {
		data : cargotype.data
	}
});

$('#tree_8').on('select_node.jstree', function(e,data) {
	if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
		$("#s_btn_codedesc8").val(data.node.text);
		$("#s_btn_codedesccache8").val(data.node.text);
		$("#s_btn_codeid8").val(data.node.id);
		hideMenu8();
	}
});
   $("#tree_2").jstree({
		'core' : {
			data : shipport.data
		}
	}); 
  
  $('#tree_2').on('select_node.jstree', function(e,data) {
		if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
			$("#s_btn_aimportname").val(data.node.text);
			$("#s_btn_aimportid").val(data.node.id);
			$("#s_btn_outdockname").val(data.node.text);
			hideMenu2();
		}
  });
  $("#tree_3").jstree({
		'core' : {
			data : cargotype.data
		}
	});

$('#tree_3').on('select_node.jstree', function(e,data) {
		if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
			$("#s_btn_codedesc").val(data.node.text);
			$("#s_btn_codedesccache").val(data.node.text);
			$("#s_btn_codeid").val(data.node.id);
			
			hideMenu3();
		}
});

$("#tree_11").jstree({
	'core' : {
		data : shipport.data
	}
});

$('#tree_11').on('select_node.jstree', function(e,data) {
	if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
		$("#s_btn_indockname1").val(data.node.text);
		hideMenu11();
	}
});

$("#tree_12").jstree({
	'core' : {
		data : shipport.data
	}
}); 

$('#tree_12').on('select_node.jstree', function(e,data) {
	if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
		$("#s_btn_aimportname1").val(data.node.text);
		$("#s_btn_aimportid1").val(data.node.id);
		$("#s_btn_outdockname1").val(data.node.text);
		hideMenu12();
	}
});
$("#tree_13").jstree({
	'core' : {
		data : cargotype.data
	}
});

$('#tree_13').on('select_node.jstree', function(e,data) {
	if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
		$("#s_btn_codedesc1").val(data.node.text);
		$("#s_btn_codedesccache1").val(data.node.text);
		$("#s_btn_codeid1").val(data.node.id);
		hideMenu13();
	}
});

$("#tree_14").jstree({
'core' : {
	data : shipport.data
}
});

$('#tree_14').on('select_node.jstree', function(e,data) {
if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
	$("#s_btn_jiajieportname1").val(data.node.text);
	$("#s_btn_jiaieportid1").val(data.node.id);
	hideMenu14();
}
});

});
function showAimshipportTree5(index){
	var cityObj = $("#select_aimport5"+index);
	var cityOffset = $("#s_btn_aimportname5"+index).offset();
	$("#select_tree_aimport5"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_aimport5"+index).width() +  $("#s_btn_aimportname5"+index).width()}).slideDown("fast");
	$("body").bind("mousedown", onBodyDown5);
}

function onBodyDown5(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_aimport5" || $(event.target).parents("#select_tree_aimport5").length>0
			)) {
		hideMenu5();
	}
}

function hideMenu5() {
	$("div[id^='select_tree_aimport5']").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown5);
}

function showCargotypeTree6 (index) {
	var cityObj = $("#select_cargotype6"+index);
	var cityOffset = $("#s_btn_codedesc6"+index).offset();
	$("#select_tree_cargotype6"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_cargotype6"+index).width() +  $("#s_btn_codedesc6"+index).width()}).slideDown("fast");
	$("body").bind("mousedown", onBodyDown6);
}

function hideMenu6() {
	$("div[id^='select_tree_cargotype6']").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown6);
}

function onBodyDown6(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_cargotype6" || $(event.target).parents("#select_tree_cargotype6").length>0
			)) {
		hideMenu6();
	}
}
function showAimshipportTree7(index){
	var cityObj = $("#select_aimport7"+index);
	var cityOffset = $("#s_btn_aimportname7"+index).offset();
	$("#select_tree_aimport7"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_aimport7"+index).width() +  $("#s_btn_aimportname7"+index).width()}).slideDown("fast");
	$("body").bind("mousedown", onBodyDown7);
}

function onBodyDown7(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_aimport7" || $(event.target).parents("#select_tree_aimport7").length>0
			)) {
		hideMenu7();
	}
}

function hideMenu7() {
	$("div[id^='select_tree_aimport7']").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown7);
}

function showCargotypeTree8 (index) {
	var cityObj = $("#select_cargotype8"+index);
	var cityOffset = $("#s_btn_codedesc8"+index).offset();
	$("#select_tree_cargotype8"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_cargotype8"+index).width() +  $("#s_btn_codedesc8"+index).width()}).slideDown("fast");
	$("body").bind("mousedown", onBodyDown8);
}

function hideMenu8() {
	$("div[id^='select_tree_cargotype8']").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown8);
}

function onBodyDown8(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_cargotype8" || $(event.target).parents("#select_tree_cargotype8").length>0
			)) {
		hideMenu8();
	}
}
function showAimshipportTree(index){
	var cityObj = $("#select_aimport"+index);
	var cityOffset = $("#s_btn_aimportname"+index).offset();
	$("#select_tree_aimport"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_aimport"+index).width() +  $("#s_btn_aimportname"+index).width()}).slideDown("fast");
	$("body").bind("mousedown", onBodyDown2);
}

function onBodyDown2(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_aimport" || $(event.target).parents("#select_tree_aimport").length>0
			)) {
		hideMenu2();
	}
}

function hideMenu2() {
	$("div[id^='select_tree_aimport']").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown2);
}

function showCargotypeTree (index) {
	var cityObj = $("#select_cargotype"+index);
	var cityOffset = $("#s_btn_codedesc"+index).offset();
	$("#select_tree_cargotype"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_cargotype"+index).width() +  $("#s_btn_codedesc"+index).width()}).slideDown("fast");
	$("body").bind("mousedown", onBodyDown3);
}

function hideMenu3() {
	$("div[id^='select_tree_cargotype']").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown3);
}

function onBodyDown3(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_cargotype" || $(event.target).parents("#select_tree_cargotype").length>0
			|| event.target.id == "select_tree_cargotype2" || $(event.target).parents("#select_tree_cargotype2").length>0)) {
		hideMenu3();
	}
}
	function showJiajieportTree(index) {
		var cityObj = $("#select_jiajieport"+index);
		var cityOffset = $("#s_btn_jiajieportname"+index).offset();
		$("#select_tree_jiajieport"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_jiajieport"+index).width() +  $("#s_btn_jiajieportname"+index).width() }).slideDown("fast");
		$("body").bind("mousedown", onBodyDown4);
	}

	 
	function hideMenu4() {
		$("div[id^='select_tree_jiajieport']").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown4);
	}

	function onBodyDown4(event) {
		if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_jiajieport" || $(event.target).parents("#select_tree_jiajieport").length>0
				)) {
			hideMenu4();
		}
	}	
		function showAimshipportTree1(index){
			var cityObj = $("#select_aimport1"+index);
			var cityOffset = $("#s_btn_aimportname1"+index).offset();
			$("#select_tree_aimport1"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_aimport1"+index).width() +  $("#s_btn_aimportname1"+index).width()}).slideDown("fast");
			$("body").bind("mousedown", onBodyDown12);
		}

		function onBodyDown12(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_aimport1" || $(event.target).parents("#select_tree_aimport1").length>0
					)) {
				hideMenu12();
			}
		}

		function hideMenu12() {
			$("div[id^='select_tree_aimport1']").fadeOut("fast");
			$("body").unbind("mousedown", onBodyDown12);
		}

		function showCargotypeTree1 (index) {
			var cityObj = $("#select_cargotype1"+index);
			var cityOffset = $("#s_btn_codedesc1"+index).offset();
			$("#select_tree_cargotype1"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_cargotype1"+index).width() +  $("#s_btn_codedesc1"+index).width()}).slideDown("fast");
			$("body").bind("mousedown", onBodyDown13);
		}

		function hideMenu13() {
			$("div[id^='select_tree_cargotype1']").fadeOut("fast");
			$("body").unbind("mousedown", onBodyDown13);
		}

		function onBodyDown13(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_cargotype1" || $(event.target).parents("#select_tree_cargotype1").length>0)) {
				hideMenu3();
			}
		}
			function showJiajieportTree1(index) {
				var cityObj = $("#select_jiajieport1"+index);
				var cityOffset = $("#s_btn_jiajieportname1"+index).offset();
				$("#select_tree_jiajieport1"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_jiajieport1"+index).width() +  $("#s_btn_jiajieportname1"+index).width() }).slideDown("fast");
				$("body").bind("mousedown", onBodyDown14);
			}

			 
			function hideMenu14() {
				$("div[id^='select_tree_jiajieport1']").fadeOut("fast");
				$("body").unbind("mousedown", onBodyDown14);
			}

			function onBodyDown14(event) {
				if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_jiajieport1" || $(event.target).parents("#select_tree_jiajieport1").length>0
						)) {
					hideMenu4();
				}
			}
		
	function addBcship(){
		$("body").data("shipselecttype","other");
		$("body").data("searchname","shiptypeid");
		$("body").data("searchvalue","0000000002");
		openShips();
		//$("#btn_passinfothemeid").click();
			}
	function setOthershipinfo(data){
		$("#bcshipshipinfoid2").val(data.shipinfoid);
		$("#bcshipuvsersion").val(data.uvsersion);
		$("#bcshiposhipinfoid").val(data.shipinfoid);
		$("#bcshipouvsersion").val(data.uvsersion);
		$("#bcshipshipname").val(data.shipname);
		$("#shiptitle").html(data.shipname);
		$("#addnewbcship").click();
			}
			
	function refreshShipRelation() {
		var shipinfo = $("body").data("shipinfo");
		if(shipinfo.shiptypeid == "0000000002"){
			alert("船舶类型是驳船，不能单独办理船舶签证。");
			return false;
		}if(shipinfo.shiptypeid == "0000000001"){
			$("#chuanduioutvisa").show();
			$("#danchuanoutvisa").hide();
			$("#chuanduishipinfoid2").val($("#s_btn_shipinfoid").val());
			$("#chuanduiuvsersion").val($("#s_btn_uvsersion").val());
			$("#chuanduioshipinfoid").val($("#s_btn_shipinfoid").val());
			$("#chuanduiouvsersion").val($("#s_btn_uvsersion").val());
			$("#chuanduishipname").val($("#s_btn_shipname").val());
			$.ajax({
				url : base + "/ship/invisa/bcships/" + shipinfo.shipinfoid,
				type : "POST",
				dataType : "text",
				success : function(data) {
					$("#outbargecount").val(data);
				},
				error : function() {
					alert("报告出错了");
				}
			});
			$.ajax({
				url : base + "/ship/outvisa/securcheck/" + shipinfo.shipinfoid,
				type : "POST",
				dataType : "text",
				success : function(data) {
					$("#chuanduicheckdate").val(data);
				},
				error : function() {
					alert("报告出错了");
				}
			});
			$.ajax({
				url : base + "/ship/outvisa/" + $("#s_btn_shipinfoid").val(),
				type : "POST",
				dataType : "json",
				success : function(data) {
					$("#chuanduicheckinvisa").hide();
					if(data.visacode!=null){
					bootbox.confirm("该船舶包含进港信息，是否关联?", function(result) {
						if (result) {
							$("#cdvisacode").val(data.visacode);
							$("#chuanduiinseeship").val("1");
							$("#chuanduicheckinvisa").val(data.visacode);
							$("#chuanduicheckinvisa").show();
						}
					});
					}
				},
				error : function() {
				}
			});
		}if(shipinfo.shiptypeid != "0000000001"&&shipinfo.shiptypeid != "0000000002"){
			$("#chuanduioutvisa").hide();
			$("#danchuanoutvisa").show();
			$("#shipinfoid2").val($("#s_btn_shipinfoid").val());
			$("#uvsersion").val($("#s_btn_uvsersion").val());
			$("#oshipinfoid").val($("#s_btn_shipinfoid").val());
			$("#ouvsersion").val($("#s_btn_uvsersion").val());
			$("#shipname").val($("#s_btn_shipname").val());
		$.ajax({
				url : base + "/ship/outvisa/securcheck/" + shipinfo.shipinfoid,
				type : "POST",
				dataType : "text",
				success : function(data) {
					$("#danchuancheckdate").val(data);
				},
				error : function() {
					alert("报告出错了");
				}
			});
		$.ajax({
			url : base + "/ship/outvisa/" + $("#s_btn_shipinfoid").val(),
			type : "POST",
			dataType : "json",
			success : function(data) {
				$("#checkinvisa").hide();
				$("#visacode").removeAttr("value");
				if(data.visacode!=null){
					bootbox.confirm("该船舶包含进港信息，是否关联?", function(result) {
						if (result) {
							$("#dcvisacode").val(data.visacode);
							$("#inseeship").val("1");
							$("#checkinvisa").val(data.visacode);
							$("#checkinvisa").show();
						}
					});
					}
			},
			error : function() {
			}
		});
	}

	}
	
	var FormValidation1 = function() {
		var handleValidation = function() {
			var form = $('#cdoutvisaform');
			var error = $('.alert-danger', form);
			var success = $('.alert-success', form);
			var formflag = true;
			form.validate({
				errorElement : 'span', //default input error message container
				errorClass : 'help-block help-block-error', // default input error message class
				focusInvalid : false, // do not focus the last invalid input
				ignore : "", // validate all fields including form hidden input
				rules : {
					waterarea : {
						required : true,
						maxlength : 25
					},								
					seaship : {
						required : true,
						maxlength : 25
					},
					startpointid : {
						required : true
					},	
					indockname : {
						required : true,
						maxlength : 20
					},	
					aimpoitid : {
						required : true
					},	
					outdockname : {
						required : true,
						maxlength : 20 
					},	
					leavesiteid : {
						required : true,
						maxlength : 20 
					},	
					outcargotype : {
						required : true
					},	
					outcargodesc : {
						required : true,
						maxlength : 20
					},	
					outdangerton : {
						required : true,
						maxlength : 10,
						number:true
					},	
					outloadquantity : {
						required : true,
						maxlength : 10,
						number:true
					},	
					outaddquantity : {
						required : true,
						maxlength : 10,
						number:true
					},	
					outbargecount : {
						required : true,
						digits : true
					},	
					outaddbargecount : {
						required : true,
						digits : true
					},	
					jiajieportid : {
						required : true
					},	
					outondutysalernum : {
						required : true,
						digits : true
					},	
					outondutyworkernum : {
						required : true,
						digits : true
					},	
					outportdrawfirst : {
						required : true,
						maxlength : 10,
						number:true
					},	
					outportdrawafter : {
						required : true,
						maxlength : 10,
						number:true
					},
					visaoutremark : {
						required : true,
						maxlength : 50
					},	
					outsailornum : {
						required : true,
						digits : true
					},
					outseamaninfo : {
						required : true,
						maxlength : 30
					},	
					rubbishnum : {
						required : true,
						maxlength : 10,
						number:true
					},	
					effluentnum : {
						required : true,
						maxlength : 10,
						number:true
					}
				},
				messages : {
					waterarea : {
						required : jQuery.validator.format("请输入经过水域！"),
						maxlength : jQuery.validator.format("经过水域过长！")
					},				
					seaship : {
						required : jQuery.validator.format("请输入实船签证！"),
						maxlength : jQuery.validator.format("实船签证过长！")
					},
					startpointid : {
						required : jQuery.validator.format("请输入始发港！")
					},
					indockname : {
						required : jQuery.validator.format("请输入始发港描述！"),
						maxlength : jQuery.validator.format("始发港描述过长！")
					},
					aimpoitid : {
						required : jQuery.validator.format("请输入目的港！")
					},	
					outdockname : {
						required : jQuery.validator.format("请输入目的港描述！"),
						maxlength : jQuery.validator.format("目的港描述过长！")
					},	
					leavesiteid : {
						required : jQuery.validator.format("请输入开航地点！"),
						maxlength : jQuery.validator.format("开航地点过长！")
					},	
					outcargotype : {
						required : jQuery.validator.format("请输入货物种类！")
					},	
					outcargodesc : {
						required : jQuery.validator.format("请输入出港货物描述"),
						maxlength : jQuery.validator.format("出港货物描述过长！")
					},	
					outdangerton : {
						required : jQuery.validator.format("请输入出港实载危险品！"),
						maxlength : jQuery.validator.format("出港实载危险品过长！"),
						number:jQuery.validator.format("请输入有效出港实载危险品！")
					},	
					outdangerton : {
						required : jQuery.validator.format("请输入出港实载客货！"),
						maxlength : jQuery.validator.format("出港实载客货过长！"),
						number:jQuery.validator.format("请输入有效出港实载客货！")
					},	
					outdangerton : {
						required : jQuery.validator.format("请输入出港上客/装货！"),
						maxlength : jQuery.validator.format("出港上客/装货过长！"),
						number:jQuery.validator.format("请输入有效出港上客/装货！")
					},	
					outbargecount : {
						required : jQuery.validator.format("请输入出港驳船数量！"),
						digits : jQuery.validator.format("请输入有效出港驳船数量！")
					},	
					outaddbargecount : {
						required : jQuery.validator.format("请输入出港预计解驳数量！"),
						digits : jQuery.validator.format("请输入有效出港预计解驳数量！")
					},	
					jiajieportid : {
						required : jQuery.validator.format("请输入出港预计解驳港口！")
					},	
					outondutysalernum : {
						required : jQuery.validator.format("请输入出港值班水手数！"),
						digits : jQuery.validator.format("请输入有效出港值班水手数！")
					},	
					outondutyworkernum : {
						required : jQuery.validator.format("请输入出港值班机工数！"),
						digits : jQuery.validator.format("请输入有效出港值班机工数！")
					},	
					outportdrawfirst : {
						required : jQuery.validator.format("请输入出港前吃水！"),
						maxlength : jQuery.validator.format("出港前吃水过长！"),
						number:jQuery.validator.format("请输入有效出港前吃水！")
					},	
					outportdrawafter : {
						required : jQuery.validator.format("请输入出港后吃水！"),
						maxlength : jQuery.validator.format("出港后吃水过长！"),
						number:jQuery.validator.format("请输入有效出港后吃水！")
					},
					visaoutremark : {
						required : jQuery.validator.format("请输入出港备注！"),
						maxlength : jQuery.validator.format("出港备注过长！")
					},	
					outsailornum : {
						required : jQuery.validator.format("请输入出港配员人数！"),
						digits : jQuery.validator.format("请输入有效出港配员人数！")
					},
					outseamaninfo : {
						required : jQuery.validator.format("请输入出港主要船员配备！"),
						maxlength : jQuery.validator.format("出港主要船员配备过长！")
					},	
					rubbishnum : {
						required : jQuery.validator.format("请输入垃圾数！"),
						maxlength : jQuery.validator.format("垃圾数过长！"),
						number:jQuery.validator.format("请输入有效垃圾数！")
					},	
					effluentnum : {
						required : jQuery.validator.format("请输入油废水处理数！"),
						maxlength : jQuery.validator.format("油废水处理数过长！"),
						number:jQuery.validator.format("请输入有效油废水处理数！")
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
	
	var FormValidation2 = function() {
		var handleValidation = function() {
			var form = $('#dcoutvisaform');
			var error = $('.alert-danger', form);
			var success = $('.alert-success', form);
			var formflag = true;
			form.validate({
				errorElement : 'span', //default input error message container
				errorClass : 'help-block help-block-error', // default input error message class
				focusInvalid : false, // do not focus the last invalid input
				ignore : "", // validate all fields including form hidden input
				rules : {
					waterarea : {
						required : true,
						maxlength : 25
					},								
					seaship : {
						required : true,
						maxlength : 25
					},
					startpointid : {
						required : true
					},	
					indockname : {
						required : true,
						maxlength : 20
					},	
					aimpoitid : {
						required : true
					},	
					outdockname : {
						required : true,
						maxlength : 20 
					},	
					leavesiteid : {
						required : true,
						maxlength : 20 
					},	
					outcargotype : {
						required : true
					},	
					outcargodesc : {
						required : true,
						maxlength : 20
					},	
					outdangerton : {
						required : true,
						maxlength : 10,
						number:true
					},	
					outloadquantity : {
						required : true,
						maxlength : 10,
						number:true
					},	
					outaddquantity : {
						required : true,
						maxlength : 10,
						number:true
					},	
					outbargecount : {
						required : true,
						digits : true
					},	
					outaddbargecount : {
						required : true,
						digits : true
					},	
					jiajieportid : {
						required : true
					},	
					outondutysalernum : {
						required : true,
						digits : true
					},	
					outondutyworkernum : {
						required : true,
						digits : true
					},	
					outportdrawfirst : {
						required : true,
						maxlength : 10,
						number:true
					},	
					outportdrawafter : {
						required : true,
						maxlength : 10,
						number:true
					},
					visaoutremark : {
						required : true,
						maxlength : 50
					},	
					outsailornum : {
						required : true,
						digits : true
					},
					outseamaninfo : {
						required : true,
						maxlength : 30
					},	
					rubbishnum : {
						required : true,
						maxlength : 10,
						number:true
					},	
					effluentnum : {
						required : true,
						maxlength : 10,
						number:true
					}
				},
				messages : {
					waterarea : {
						required : jQuery.validator.format("请输入经过水域！"),
						maxlength : jQuery.validator.format("经过水域过长！")
					},				
					seaship : {
						required : jQuery.validator.format("请输入实船签证！"),
						maxlength : jQuery.validator.format("实船签证过长！")
					},
					startpointid : {
						required : jQuery.validator.format("请输入始发港！")
					},
					indockname : {
						required : jQuery.validator.format("请输入始发港描述！"),
						maxlength : jQuery.validator.format("始发港描述过长！")
					},
					aimpoitid : {
						required : jQuery.validator.format("请输入目的港！")
					},	
					outdockname : {
						required : jQuery.validator.format("请输入目的港描述！"),
						maxlength : jQuery.validator.format("目的港描述过长！")
					},	
					leavesiteid : {
						required : jQuery.validator.format("请输入开航地点！"),
						maxlength : jQuery.validator.format("开航地点过长！")
					},	
					outcargotype : {
						required : jQuery.validator.format("请输入货物种类！")
					},	
					outcargodesc : {
						required : jQuery.validator.format("请输入出港货物描述"),
						maxlength : jQuery.validator.format("出港货物描述过长！")
					},	
					outdangerton : {
						required : jQuery.validator.format("请输入出港实载危险品！"),
						maxlength : jQuery.validator.format("出港实载危险品过长！"),
						number:jQuery.validator.format("请输入有效出港实载危险品！")
					},	
					outdangerton : {
						required : jQuery.validator.format("请输入出港实载客货！"),
						maxlength : jQuery.validator.format("出港实载客货过长！"),
						number:jQuery.validator.format("请输入有效出港实载客货！")
					},	
					outdangerton : {
						required : jQuery.validator.format("请输入出港上客/装货！"),
						maxlength : jQuery.validator.format("出港上客/装货过长！"),
						number:jQuery.validator.format("请输入有效出港上客/装货！")
					},	
					outbargecount : {
						required : jQuery.validator.format("请输入出港驳船数量！"),
						digits : jQuery.validator.format("请输入有效出港驳船数量！")
					},	
					outaddbargecount : {
						required : jQuery.validator.format("请输入出港预计解驳数量！"),
						digits : jQuery.validator.format("请输入有效出港预计解驳数量！")
					},	
					jiajieportid : {
						required : jQuery.validator.format("请输入出港预计解驳港口！")
					},	
					outondutysalernum : {
						required : jQuery.validator.format("请输入出港值班水手数！"),
						digits : jQuery.validator.format("请输入有效出港值班水手数！")
					},	
					outondutyworkernum : {
						required : jQuery.validator.format("请输入出港值班机工数！"),
						digits : jQuery.validator.format("请输入有效出港值班机工数！")
					},	
					outportdrawfirst : {
						required : jQuery.validator.format("请输入出港前吃水！"),
						maxlength : jQuery.validator.format("出港前吃水过长！"),
						number:jQuery.validator.format("请输入有效出港前吃水！")
					},	
					outportdrawafter : {
						required : jQuery.validator.format("请输入出港后吃水！"),
						maxlength : jQuery.validator.format("出港后吃水过长！"),
						number:jQuery.validator.format("请输入有效出港后吃水！")
					},
					visaoutremark : {
						required : jQuery.validator.format("请输入出港备注！"),
						maxlength : jQuery.validator.format("出港备注过长！")
					},	
					outsailornum : {
						required : jQuery.validator.format("请输入出港配员人数！"),
						digits : jQuery.validator.format("请输入有效出港配员人数！")
					},
					outseamaninfo : {
						required : jQuery.validator.format("请输入出港主要船员配备！"),
						maxlength : jQuery.validator.format("出港主要船员配备过长！")
					},	
					rubbishnum : {
						required : jQuery.validator.format("请输入垃圾数！"),
						maxlength : jQuery.validator.format("垃圾数过长！"),
						number:jQuery.validator.format("请输入有效垃圾数！")
					},	
					effluentnum : {
						required : jQuery.validator.format("请输入油废水处理数！"),
						maxlength : jQuery.validator.format("油废水处理数过长！"),
						number:jQuery.validator.format("请输入有效油废水处理数！")
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
	
	function dccheckisdanger(){
		var outcargotype = $("#s_btn_codeid").val();
		if(outcargotype==""||outcargotype==null){
			alert("请选择货物种类");
			return ;
		}
		$.ajax({
			url : base + "/sys/cargotype/checkisdanger/" + outcargotype,
			type : "POST",
			dataType : "text",
			success : function(data) {
				    if(data=="1"){
			    	$("#dcisoutdanger").val("1");
			    	$("#cdisoutdanger").val("0");
			    	var radios = $("#dcoutseeshipselect").children("input");
					$.each(radios,function(i,ele){
						if($(ele).val() == '1'){
							ele.checked = true;
							return false;
						}
					});
					bootbox.confirm("货物种类为危险品，请办理出港实船签证并登记危险品", function(result) {
						if (result) {
							$("#signtypeid").val("1");
							var cargoname = $("#s_btn_codedesc").val();
							$("#cargoname").val(cargoname);
							$("#btn_dangersigntheme").click();
						}
					});
					}else{
						$("#dcisoutdanger").val("0");
						$("#dcoutvisaform").submit();
					}
			},
			error : function() {
				alert("报告出错了");
			}
		});
	}
	function cdcheckisdanger(){
		var outcargotype = $("#s_btn_codeid1").val();
		if(outcargotype==""||outcargotype==null){
			alert("请选择货物种类");
			return ;
		}
		$.ajax({
			url : base + "/sys/cargotype/checkisdanger/" + outcargotype,
			type : "POST",
			dataType : "text",
			success : function(data) {
				    if(data=="1"){
			    	$("#cdisoutdanger").val("1");
			    	$("#dcisoutdanger").val("0");
			    	var radios = $("#cdoutseeshipselect").children("input");
					$.each(radios,function(i,ele){
						if($(ele).val() == '1'){
							ele.checked = true;
							return false;
						}
					});
					bootbox.confirm("货物种类为危险品，请办理出港实船签证并登记危险品", function(result) {
						if (result) {
							$("#signtypeid").val("1");
							var cargoname = $("#s_btn_codedesc1").val();
							$("#cargoname").val(cargoname);
							$("#btn_dangersigntheme").click();
						}
					});
					}else{
						$("#cdisoutdanger").val("0");
						$("#cdoutvisaform").submit();
					}
			},
			error : function() {
				alert("报告出错了");
			}
		});
	}
	
	function visaformSubmit(){
			$("#dcvisacode").val($("body").data("visacode"));
			$("#dcoutvisaform").submit();
	}
	
	function bcoutvisacheck(){
		var outcargotype = $("#s_btn_codeid6").val();
		if(outcargotype==""||outcargotype==null){
			alert("请选择货物种类");
			return ;
		}
		$.ajax({
			url : base + "/sys/cargotype/checkisdanger/" + outcargotype,
			type : "POST",
			dataType : "text",
			success : function(data) {
				    if(data=="1"){
				    	$("#bcisoutdanger").val("1");
				    	$("#cdisoutdanger").val("0");
				    	$("#dcisoutdanger").val("0");
					bootbox.confirm("货物种类为危险品，请登记", function(result) {
						if (result) {
							$("#signtypeid").val("1");
							$("#dangersignvisacode").val($("#bcvisacode").val());
							var cargoname = $("#s_btn_codedesc6").val();
							$("#cargoname").val(cargoname);
							$("#btn_dangersigntheme").click();
						}
					});
					}else{
						$("#bcisoutdanger").val("0");
						$("#bcoutvisaform").submit();
					}
			},
			error : function() {
				alert("报告出错了");
			}
		});
	}


	function dcoutvisacheck(){
		var outcargotype = $("#s_btn_codeid").val();
		if(outcargotype==""||outcargotype==null){
			alert("请选择货物种类");
			return ;
		}
		$.ajax({
			url : base + "/sys/cargotype/checkisdanger/" + outcargotype,
			type : "POST",
			dataType : "text",
			success : function(data) {
				    if(data=="1"){
				    	$("#bcisoutdanger").val("0");
				    	$("#cdisoutdanger").val("0");
				    	$("#dcisoutdanger").val("1");
				    	var radios = $("#editdcoutseeshipselect").children("input");
						$.each(radios,function(i,ele){
							if($(ele).val() == '1'){
								ele.checked = true;
								return false;
							}
						});
					bootbox.confirm("货物种类为危险品，请办理出港实船签证并登记危险品", function(result) {
						if (result) {
							$("#signtypeid").val("1");
							$("#dangersignvisacode").val($("#danchuanvisacode").val());
							var cargoname = $("#s_btn_codedesc").val();
							$("#cargoname").val(cargoname);
							$("#btn_dangersigntheme").click();
						}
					});
					}else{
						$("#dcisoutdanger").val("0");
						$("#dcoutvisaform").submit();
					}
			},
			error : function() {
				alert("报告出错了");
			}
		});
	}

	function cdoutvisacheck(){
		var outcargotype = $("#s_btn_codeid1").val();
		if(outcargotype==""||outcargotype==null){
			alert("请选择货物种类");
			return ;
		}
		$.ajax({
			url : base + "/sys/cargotype/checkisdanger/" + outcargotype,
			type : "POST",
			dataType : "text",
			success : function(data) {
				    if(data=="1"){
				    	$("#bcisoutdanger").val("0");
				    	$("#cdisoutdanger").val("1");
				    	$("#dcisoutdanger").val("0");
				    	var radios = $("#editcdoutseeshipselect").children("input");
						$.each(radios,function(i,ele){
							if($(ele).val() == '1'){
								ele.checked = true;
								return false;
							}
						});
					bootbox.confirm("货物种类为危险品，请办理出港实船签证并登记危险品", function(result) {
						if (result) {
							$("#signtypeid").val("1");
							$("#dangersignvisacode").val($("#chuanduivisacode").val());
							var cargoname = $("#s_btn_codedesc1").val();
							$("#cargoname").val(cargoname);
							$("#btn_dangersigntheme").click();
						}
					});
					}else{
						$("#cdisoutdanger").val("0");
						$("#cdoutvisaform").submit();
					}
			},
			error : function() {
				alert("报告出错了");
			}
		});
	}