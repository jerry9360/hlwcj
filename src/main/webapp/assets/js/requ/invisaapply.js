$(function() { 	
	FormValidation1.init();
	FormValidation2.init();
});

$("#tree_1").jstree({
		'core' : {
			data : shipport.data
		}
	});
   
   $('#tree_1').on('select_node.jstree', function(e,data) {
		if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
			$("#s_btn_startportname1").val(data.node.text);
			$("#s_btn_startportid1").val(data.node.id);
			$("#s_btn_indockname1").val(data.node.text);
			hideMenu1();
		}
   });
   
   $("#tree_2").jstree({
		'core' : {
			data : shipport.data
		}
	}); 
  
  $('#tree_2').on('select_node.jstree', function(e,data) {
		if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
			$("#s_btn_aimportname2").val(data.node.text);
			$("#s_btn_aimportid2").val(data.node.id);
			$("#s_btn_outdockname2").val(data.node.text);
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
			$("#s_btn_codedesc3").val(data.node.text);
			$("#s_btn_codedesccache3").val(data.node.text);
			$("#s_btn_codeid3").val(data.node.id);
			hideMenu3();
		}
});

$("#tree_4").jstree({
	'core' : {
		data : shipport.data
	}
});

$('#tree_4').on('select_node.jstree', function(e,data) {
	if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
		$("#s_btn_startportname4").val(data.node.text);
		$("#s_btn_startportid4").val(data.node.id);
		$("#s_btn_indockname4").val(data.node.text);
		hideMenu4();
	}
});

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
		$("#s_btn_startportname7").val(data.node.text);
		$("#s_btn_startportid7").val(data.node.id);
		$("#s_btn_indockname7").val(data.node.text);
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

$("#tree_9").jstree({
	'core' : {
		data : shipport.data
	}
});

$('#tree_9').on('select_node.jstree', function(e,data) {
	if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
		$("#s_btn_startportname9").val(data.node.text);
		$("#s_btn_startportid9").val(data.node.id);
		$("#s_btn_indockname9").val(data.node.text);
		hideMenu9();
	}
});

$("#tree_10").jstree({
	'core' : {
		data : cargotype.data
	}
});

$('#tree_10').on('select_node.jstree', function(e,data) {
	if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
		$("#s_btn_codedesc10").val(data.node.text);
		$("#s_btn_codedesccache10").val(data.node.text);
		$("#s_btn_codeid10").val(data.node.id);
		hideMenu10();
	}
});

$("#tree_11").jstree({
	'core' : {
		data : shipport.data
	}
});

$('#tree_11').on('select_node.jstree', function(e,data) {
	if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
		$("#s_btn_startportname11").val(data.node.text);
		$("#s_btn_startportid11").val(data.node.id);
		$("#s_btn_indockname11").val(data.node.text);
		hideMenu11();
	}
});

$("#tree_12").jstree({
	'core' : {
		data : cargotype.data
	}
});

$('#tree_12').on('select_node.jstree', function(e,data) {
	if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
		$("#s_btn_codedesc12").val(data.node.text);
		$("#s_btn_codedesccache12").val(data.node.text);
		$("#s_btn_codeid12").val(data.node.id);
		hideMenu12();
	}
});

//$("#tree_13").jstree({
//	'core' : {
//		data : msacode.data
//	}
//});
//
//$('#tree_13').on('select_node.jstree', function(e,data) {
//	if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
//		$("#s_btn_codedesc13").val(data.node.text);
//		$("#s_btn_codeid13").val(data.node.id);
//		hideMenu13();
//	}
//});
//
//$("#tree_14").jstree({
//	'core' : {
//		data : msacode.data
//	}
//});
//
//$('#tree_14').on('select_node.jstree', function(e,data) {
//	if ($("#" + data.node.id).parent().attr("class") != "jstree-container-ul") {
//		$("#s_btn_codedesc14").val(data.node.text);
//		$("#s_btn_codeid14").val(data.node.id);
//		hideMenu14();
//	}
//});

function showStartshipportTree1(index) {
	var cityObj = $("#select_startport1"+index);
	var cityOffset = $("#s_btn_startportname1"+index).offset();
	$("#select_tree_startport1"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_startport1"+index).width() +  $("#s_btn_startportname1"+index).width() }).slideDown("fast");
	$("body").bind("mousedown", onBodyDown1);
}

 
function hideMenu1() {
	$("div[id^='select_tree_startport1']").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown1);
}

function onBodyDown1(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_startport1" || $(event.target).parents("#select_tree_startport1").length>0
			)) {
		hideMenu1();
	}
}

function showAimshipportTree2(index){
	var cityObj = $("#select_aimport2"+index);
	var cityOffset = $("#s_btn_aimportname2"+index).offset();
	$("#select_tree_aimport2"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_aimport2"+index).width() +  $("#s_btn_aimportname2"+index).width()}).slideDown("fast");
	$("body").bind("mousedown", onBodyDown2);
}

function onBodyDown2(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_aimport2" || $(event.target).parents("#select_tree_aimport2").length>0
			)) {
		hideMenu2();
	}
}

function hideMenu2() {
	$("div[id^='select_tree_aimport2']").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown2);
}

function showCargotypeTree3 (index) {
	var cityObj = $("#select_cargotype3"+index);
	var cityOffset = $("#s_btn_codedesc3"+index).offset();
	$("#select_tree_cargotype3"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_cargotype3"+index).width() +  $("#s_btn_codedesc3"+index).width()}).slideDown("fast");
	$("body").bind("mousedown", onBodyDown3);
}

function hideMenu3() {
	$("div[id^='select_tree_cargotype3']").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown3);
}

function onBodyDown3(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_cargotype3" || $(event.target).parents("#select_tree_cargotype3").length>0
			)) {
		hideMenu3();
	}
}

function showStartshipportTree4(index) {
	var cityObj = $("#select_startport4"+index);
	var cityOffset = $("#s_btn_startportname4"+index).offset();
	$("#select_tree_startport4"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_startport4"+index).width() +  $("#s_btn_startportname4"+index).width() }).slideDown("fast");
	$("body").bind("mousedown", onBodyDown4);
}

 
function hideMenu4() {
	$("div[id^='select_tree_startport4']").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown4);
}

function onBodyDown4(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_startport4" || $(event.target).parents("#select_tree_startport4").length>0
			)) {
		hideMenu4();
	}
}

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
			|| event.target.id == "select_tree_cargotype6" || $(event.target).parents("#select_tree_cargotype6").length>0)) {
		hideMenu6();
	}
}

function showStartshipportTree7(index) {
	var cityObj = $("#select_startport7"+index);
	var cityOffset = $("#s_btn_startportname7"+index).offset();
	$("#select_tree_startport7"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_startport7"+index).width() +  $("#s_btn_startportname7"+index).width() }).slideDown("fast");
	$("body").bind("mousedown", onBodyDown7);
}

 
function hideMenu7() {
	$("div[id^='select_tree_startport7']").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown7);
}

function onBodyDown7(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_startport7" || $(event.target).parents("#select_tree_startport7").length>0
			)) {
		hideMenu7();
	}
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

function showStartshipportTree9(index) {
	var cityObj = $("#select_startport9"+index);
	var cityOffset = $("#s_btn_startportname9"+index).offset();
	$("#select_tree_startport9"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_startport9"+index).width() +  $("#s_btn_startportname9"+index).width() }).slideDown("fast");
	$("body").bind("mousedown", onBodyDown9);
}

 
function hideMenu9() {
	$("div[id^='select_tree_startport9']").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown9);
}

function onBodyDown9(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_startport9" || $(event.target).parents("#select_tree_startport9").length>0
			)) {
		hideMenu9();
	}
}

function showCargotypeTree10 (index) {
	var cityObj = $("#select_cargotype10"+index);
	var cityOffset = $("#s_btn_codedesc10"+index).offset();
	$("#select_tree_cargotype10"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_cargotype10"+index).width() +  $("#s_btn_codedesc10"+index).width()}).slideDown("fast");
	$("body").bind("mousedown", onBodyDown10);
}

function hideMenu10() {
	$("div[id^='select_tree_cargotype10']").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown10);
}

function onBodyDown10(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_cargotype10" || $(event.target).parents("#select_tree_cargotype10").length>0
			)) {
		hideMenu10();
	}
}

function showStartshipportTree11(index) {
	var cityObj = $("#select_startport11"+index);
	var cityOffset = $("#s_btn_startportname11"+index).offset();
	$("#select_tree_startport11"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_startport11"+index).width() +  $("#s_btn_startportname11"+index).width() }).slideDown("fast");
	$("body").bind("mousedown", onBodyDown11);
}

 
function hideMenu11() {
	$("div[id^='select_tree_startport11']").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown11);
}

function onBodyDown11(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_startport11" || $(event.target).parents("#select_tree_startport11").length>0
			)) {
		hideMenu11();
	}
}

function showCargotypeTree12 (index) {
	var cityObj = $("#select_cargotype12"+index);
	var cityOffset = $("#s_btn_codedesc12"+index).offset();
	$("#select_tree_cargotype12"+index).css({left:cityOffset.left  +"px", top:(cityOffset.top-13) +  "px",width: $("#select_cargotype12"+index).width() +  $("#s_btn_codedesc12"+index).width()}).slideDown("fast");
	$("body").bind("mousedown", onBodyDown12);
}

function hideMenu12() {
	$("div[id^='select_tree_cargotype12']").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown12);
}

function onBodyDown12(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_cargotype12" || $(event.target).parents("#select_tree_cargotype12").length>0
			)) {
		hideMenu12();
	}
}

//function showMsacodeTree13() {
//	var cityObj = $("#select_msacode13");
//	var cityOffset = $("#s_btn_codedesc13").offset();
//	$("#select_tree_msacode13").css({
//		left:cityOffset.left +"px", 
//		top:(cityOffset.top-13) +  "px",
//		width : $("#select_msacode13").width() +  $("#s_btn_codedesc13").width()
//		}).slideDown("fast");
//	$("body").bind("mousedown", onBodyDown13);
//	
//	
//}
//function hideMenu13() {
//	$("#select_tree_msacode13").fadeOut("fast");
//	$("body").unbind("mousedown", onBodyDown13);
//}
//
//function onBodyDown13(event) {
//	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_msacode13" || $(event.target).parents("#select_tree_msacode13").length>0)) {
//		hideMenu13();
//	}
//}
//
//function showMsacodeTree14() {
//	var cityObj = $("#select_msacode14");
//	var cityOffset = $("#s_btn_codedesc14").offset();
//	$("#select_tree_msacode14").css({
//		left:cityOffset.left +"px", 
//		top:(cityOffset.top-13) +  "px",
//		width : $("#select_msacode14").width() +  $("#s_btn_codedesc14").width()
//		}).slideDown("fast");
//	$("body").bind("mousedown", onBodyDown14);
//	
//	
//}
//function hideMenu14() {
//	$("#select_tree_msacode14").fadeOut("fast");
//	$("body").unbind("mousedown", onBodyDown14);
//}
//
//function onBodyDown14(event) {
//	if (!(event.target.id == "menuBtn" || event.target.id == "select_tree_msacode14" || $(event.target).parents("#select_tree_msacode14").length>0)) {
//		hideMenu14();
//	}
//}

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
	}
	if(shipinfo.shiptypeid == "0000000001"){
		$("#chuanduiinvisa").show();
		$("#danchuaninvisa").hide();
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
				$("#inbargecount").val(data);
			},
			error : function() {
				alert("报告出错了");
			}
		});
		$.ajax({
			url : base + "/ship/invisa/securcheck/" + shipinfo.shipinfoid,
			type : "POST",
			dataType : "text",
			success : function(data) {
				$("#chuanduicheckdate").val(data);
			},
			error : function() {
				alert("报告出错了");
			}
		});
	}
	if(shipinfo.shiptypeid != "0000000001"&&shipinfo.shiptypeid != "0000000002"){
		$("#chuanduiinvisa").hide();
		$("#danchuaninvisa").show();
		$("#shipinfoid2").val($("#s_btn_shipinfoid").val());
		$("#uvsersion").val($("#s_btn_uvsersion").val());
		$("#oshipinfoid").val($("#s_btn_shipinfoid").val());
		$("#ouvsersion").val($("#s_btn_uvsersion").val());
		$("#shipname").val($("#s_btn_shipname").val());
	}
	$.ajax({
		url : base + "/ship/invisa/securcheck/" + shipinfo.shipinfoid,
		type : "POST",
		dataType : "text",
		success : function(data) {
			$("#danchuancheckdate").val(data);
		},
		error : function() {
			alert("报告出错了");
		}
	});
}


var FormValidation1 = function() {
	var handleValidation = function() {
		var form = $('#cdinvisaform');
		var error = $('.alert-danger', form);
		var success = $('.alert-success', form);
		var formflag = true;
		form.validate({
			errorElement : 'span', //default input error message container
			errorClass : 'help-block help-block-error', // default input error message class
			focusInvalid : false, // do not focus the last invalid input
			ignore : "", // validate all fields including form hidden input
			rules : {
				departsiteid : {
					required : true,
					maxlength : 20
				},								
				insailornum : {
					required : true,
					number : true,
					max : 99999999.99,
					min : 0
				},								
				indangerton : {
					required : true,
					maxlength : 10,
					number:true
				},	
				ingoodquantity : {
					required : true,
					maxlength : 10,
					number:true
				},	
				inloadquantity : {
					required : true,
					maxlength : 10,
					number:true
				},	
				inondutysalernum : {
					required : true,
					number : true,
					max : 99999999.99,
					min : 0
				},	
				inondutyworkernum : {
					required : true,
					number : true,
					max : 99999999.99,
					min : 0
				},	
				inseamaninfo : {
					required : true,
					maxlength : 30
				},	
				inportdrawfirst : {
					required : true,
					maxlength : 10,
					number:true
				},	
				inportdrawafter : {
					required : true,
					maxlength : 10,
					number:true
				},	
				invisaapplyman : {
					required : true,
					maxlength : 5
				},	
				inaddbargecount : {
					required : true,
					number : true,
					max : 99999999.99,
					min : 0
				},
				inbargecount : {
					required : true,
					number : true,
					max : 99999999.99,
					min : 0
				}
			},
			messages : {
				departsiteid : {
					required : jQuery.validator.format("请输入靠泊地点！"),
					maxlength : jQuery.validator.format("靠泊地点过长！")
				},				
				insailornum : {
					required : jQuery.validator.format("请输入进港配员人数！"),
					number : jQuery.validator.format("请输入有效数字！"),
					max : jQuery.validator.format("请输入有效数字！")
				},
				indangerton : {
					required : jQuery.validator.format("请输入进港实载危险品！"),
					maxlength : jQuery.validator.format("进港实载危险品过长！"),
					number:jQuery.validator.format("请输入有效进港实载危险品！")
				},
				ingoodquantity : {
					required : jQuery.validator.format("请输入进港实载客货！"),
					maxlength : jQuery.validator.format("进港实载客货过长！"),
					number:jQuery.validator.format("请输入有效进港实载客货！")
				},
				inloadquantity : {
					required : jQuery.validator.format("请输入进港下客/卸货！"),
					maxlength : jQuery.validator.format("进港下客/卸货过长！"),
					number:jQuery.validator.format("请输入有效进港下客/卸货！")
				},	
				inondutysalernum : {
					required : jQuery.validator.format("请输入进港值班水手数！"),
					number : jQuery.validator.format("请输入有效数字！"),
					max : jQuery.validator.format("请输入有效数字！")
				},	
				inondutyworkernum : {
					required : jQuery.validator.format("请输入进港值班机工数！"),
					number : jQuery.validator.format("请输入有效数字！"),
					max : jQuery.validator.format("请输入有效数字！")
				},	
				inseamaninfo : {
					required : jQuery.validator.format("请输入船员配备！"),
					maxlength : jQuery.validator.format("船员配备过长！")
				},	
				inportdrawfirst : {
					required : jQuery.validator.format("请输入进港前吃水！"),
					maxlength : jQuery.validator.format("进港前吃水过长！"),
					number:jQuery.validator.format("请输入有效进港前吃水！")
				},	
				inportdrawafter : {
					required : jQuery.validator.format("请输入进港后吃水！"),
					maxlength : jQuery.validator.format("进港后吃水过长！"),
					number:jQuery.validator.format("请输入有效进港后吃水！")
				},	
				invisaapplyman : {
					required : jQuery.validator.format("请输入进港签证申请人！"),
					maxlength : jQuery.validator.format("进港签证申请人过长！")
				},	
				inaddbargecount : {
					required : jQuery.validator.format("请输入本港加解驳船数量！"),
					number : jQuery.validator.format("请输入有效数字！"),
					max : jQuery.validator.format("请输入有效数字！")
				},	
				inbargecount : {
					required : jQuery.validator.format("请输入进港驳船数量！"),
					number : jQuery.validator.format("请输入有效数字！"),
					max : jQuery.validator.format("请输入有效数字！")
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
		var form = $('#dcinvisaform');
		var error = $('.alert-danger', form);
		var success = $('.alert-success', form);
		var formflag = true;
		form.validate({
			errorElement : 'span', //default input error message container
			errorClass : 'help-block help-block-error', // default input error message class
			focusInvalid : false, // do not focus the last invalid input
			ignore : "", // validate all fields including form hidden input
			rules : {
				departsiteid : {
					required : true,
					maxlength : 20
				},								
				insailornum : {
					required : true,
					number : true,
					max : 99999999.99,
					min : 0
				},								
				indangerton : {
					required : true,
					maxlength : 10,
					number:true
				},	
				ingoodquantity : {
					required : true,
					maxlength : 10,
					number:true
				},	
				inloadquantity : {
					required : true,
					maxlength : 10,
					number:true
				},	
				inondutysalernum : {
					required : true,
					number : true,
					max : 99999999.99,
					min : 0
				},	
				inondutyworkernum : {
					required : true,
					number : true,
					max : 99999999.99,
					min : 0
				},	
				inseamaninfo : {
					required : true,
					maxlength : 30
				},	
				inportdrawfirst : {
					required : true,
					maxlength : 10,
					number:true
				},	
				inportdrawafter : {
					required : true,
					maxlength : 10,
					number:true
				},	
				invisaapplyman : {
					required : true,
					maxlength : 5
				},	
				inaddbargecount : {
					required : true,
					number : true,
					max : 99999999.99,
					min : 0
				},
				inbargecount : {
					required : true,
					number : true,
					max : 99999999.99,
					min : 0
				}
			},
			messages : {
				departsiteid : {
					required : jQuery.validator.format("请输入靠泊地点！"),
					maxlength : jQuery.validator.format("靠泊地点过长！")
				},				
				insailornum : {
					required : jQuery.validator.format("请输入进港配员人数！"),
					number : jQuery.validator.format("请输入有效数字！"),
					max : jQuery.validator.format("请输入有效数字！")
				},
				indangerton : {
					required : jQuery.validator.format("请输入进港实载危险品！"),
					maxlength : jQuery.validator.format("进港实载危险品过长！"),
					number:jQuery.validator.format("请输入有效进港实载危险品！")
				},
				ingoodquantity : {
					required : jQuery.validator.format("请输入进港实载客货！"),
					maxlength : jQuery.validator.format("进港实载客货过长！"),
					number:jQuery.validator.format("请输入有效进港实载客货！")
				},
				inloadquantity : {
					required : jQuery.validator.format("请输入进港下客/卸货！"),
					maxlength : jQuery.validator.format("进港下客/卸货过长！"),
					number:jQuery.validator.format("请输入有效进港下客/卸货！")
				},	
				inondutysalernum : {
					required : jQuery.validator.format("请输入进港值班水手数！"),
					number : jQuery.validator.format("请输入有效数字！"),
					max : jQuery.validator.format("请输入有效数字！")
				},	
				inondutyworkernum : {
					required : jQuery.validator.format("请输入进港值班机工数！"),
					number : jQuery.validator.format("请输入有效数字！"),
					max : jQuery.validator.format("请输入有效数字！")
				},	
				inseamaninfo : {
					required : jQuery.validator.format("请输入船员配备！"),
					maxlength : jQuery.validator.format("船员配备过长！")
				},	
				inportdrawfirst : {
					required : jQuery.validator.format("请输入进港前吃水！"),
					maxlength : jQuery.validator.format("进港前吃水过长！"),
					number:jQuery.validator.format("请输入有效进港前吃水！")
				},	
				inportdrawafter : {
					required : jQuery.validator.format("请输入进港后吃水！"),
					maxlength : jQuery.validator.format("进港后吃水过长！"),
					number:jQuery.validator.format("请输入有效进港后吃水！")
				},	
				invisaapplyman : {
					required : jQuery.validator.format("请输入进港签证申请人！"),
					maxlength : jQuery.validator.format("进港签证申请人过长！")
				},	
				inaddbargecount : {
					required : jQuery.validator.format("请输入本港加解驳船数量！"),
					number : jQuery.validator.format("请输入有效数字！"),
					max : jQuery.validator.format("请输入有效数字！")
				},	
				inbargecount : {
					required : jQuery.validator.format("请输入进港驳船数量！"),
					number : jQuery.validator.format("请输入有效数字！"),
					max : jQuery.validator.format("请输入有效数字！")
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
		    	$("#dcisindanger").val("1");
		    	$("#cdisindanger").val("0");
		    	var radios = $("#newdcinseeshipselect").children("input");
				$.each(radios,function(i,ele){
					if($(ele).val() == '1'){
						ele.checked = true;
						return false;
					}
				});
				bootbox.confirm("货物种类为危险品，请办理进港实船签证并登记危险品", function(result) {
					if (result) {
						$("#signtypeid").val("1");
						var cargoname = $("#s_btn_codedesc6").val();
						$("#cargoname").val(cargoname);
						$("#btn_dangersigntheme").click();
					}
				});
				}else{
					$("#dcisindanger").val("0");
					$("#dcinvisaform").submit();
				}
		},
		error : function() {
			alert("报告出错了");
		}
	});
}
function cdcheckisdanger(){
	var outcargotype = $("#s_btn_codeid3").val();
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
		    	$("#cdisindanger").val("1");
		    	$("#dcisindanger").val("0");
		    	var radios = $("#newcdinseeshipselect").children("input");
				$.each(radios,function(i,ele){
					if($(ele).val() == '1'){
						ele.checked = true;
						return false;
					}
				});
				bootbox.confirm("货物种类为危险品，请办理进港实船签证并登记危险品", function(result) {
					if (result) {
						$("#signtypeid").val("1");
						var cargoname = $("#s_btn_codedesc3").val();
						$("#cargoname").val(cargoname);
						$("#btn_dangersigntheme").click();
					}
				});
				}else{
					$("#cdisindanger").val("0");
					$("#cdinvisaform").submit();
				}
		},
		error : function() {
			alert("报告出错了");
		}
	});
}

function visaformSubmit(){
	$("#dcvisacode").val($("body").data("visacode"));
	$("#dcinvisaform").submit();
}

function bcinvisacheck(){
	var outcargotype = $("#s_btn_codeid8").val();
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
			    	$("#bcisindanger").val("1");
			    	$("#cdisindanger").val("0");
			    	$("#dcisindanger").val("0");
				bootbox.confirm("货物种类为危险品，请登记", function(result) {
					if (result) {
						$("#signtypeid").val("1");
						$("#dangersignvisacode").val($("#bcvisacode").val());
						var cargoname = $("#s_btn_codedesc8").val();
						$("#cargoname").val(cargoname);
						$("#btn_dangersigntheme").click();
					}
				});
				}else{
					$("#bcisindanger").val("0");
					$("#bcinvisaform").submit();
				}
		},
		error : function() {
			alert("报告出错了");
		}
	});
}


function dcinvisacheck(){
	var outcargotype = $("#s_btn_codeid12").val();
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
			    	$("#bcisindanger").val("0");
			    	$("#cdisindanger").val("0");
			    	$("#dcisindanger").val("1");
			    	$("#bcisindanger").val("0");
			    	$("#cdisindanger").val("1");
			    	$("#dcisindanger").val("0");
			    	var radios = $("#editdcinseeshipselect").children("input");
				bootbox.confirm("货物种类为危险品，请办理进港实船签证并登记危险品", function(result) {
					if (result) {
						$("#signtypeid").val("1");
						$("#dangersignvisacode").val($("#danchuanvisacode").val());
						var cargoname = $("#s_btn_codedesc12").val();
						$("#cargoname").val(cargoname);
						$("#btn_dangersigntheme").click();
					}
				});
				}else{
					$("#dcisindanger").val("0");
					$("#dcinvisaform").submit();
				}
		},
		error : function() {
			alert("报告出错了");
		}
	});
}

function cdinvisacheck(){
	var outcargotype = $("#s_btn_codeid10").val();
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
			    	$("#bcisindanger").val("0");
			    	$("#cdisindanger").val("1");
			    	$("#dcisindanger").val("0");
			    	var radios = $("#editcdinseeshipselect").children("input");
					$.each(radios,function(i,ele){
						if($(ele).val() == '1'){
							ele.checked = true;
							return false;
						}
					});
				bootbox.confirm("货物种类为危险品，请办理进港实船签证并登记危险品", function(result) {
					if (result) {
						$("#signtypeid").val("1");
						$("#dangersignvisacode").val($("#chuanduivisacode").val());
						var cargoname = $("#s_btn_codedesc10").val();
						$("#cargoname").val(cargoname);
						$("#btn_dangersigntheme").click();
					}
				});
				}else{
					$("#cdisindanger").val("0");
					$("#cdinvisaform").submit();
				}
		},
		error : function() {
			alert("报告出错了");
		}
	});
}