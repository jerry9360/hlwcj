var parseDatetime = function(millis){
	if(millis==null){
		return "";
	}
	var nowDate = new Date();
	var d = new Date();
	d.setTime(millis);
	var year = d.getFullYear();
	var month = d.getMonth()+1;
	var day = d.getDate();
	var dateHtml = year+"-"+month+"-"+day;
	return dateHtml;
};

//var printPage = function(){
//	var url = base + "/common/print"
//	html2canvas( $("body") ,{  		
//		onrendered: function(canvas){
//			$("#printpage").attr("href",canvas.toDataURL())
//		}
//	});
//}