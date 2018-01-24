$(function(){
	initUserinfo();
});

var initUserinfo = function(){
	$.ajax({
		type : "GET",
		url : base+"/common/userinfo",
		dataType : "json",
		async : true,
		success : function(data){
			if(data.id != null || data.id != undefined){
				$("body").data("userinfo",data);
				$("#commonuserinfoid").show();
				$("#commonusernameid").html(data.username);
				$("#userloginid").remove();
			}
		},
		error : function(){
		}
	});
}