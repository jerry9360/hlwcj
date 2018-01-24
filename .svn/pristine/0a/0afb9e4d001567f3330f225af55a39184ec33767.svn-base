(function() {
	var url = $("head").find("link[href$='font-awesome.min.css']").attr('href');
	var re = /(fa-([\w\-]+?):before{content:"\\(\w+?)"})/ig;
	
	var map = {};
	window.FONT_AWESOME = map;
	window.FONT_AWESOME_ICON = [];
	
	$.get(url, function(data) {
		while (result = re.exec(data)) {
			var value = "&#x" + result[3] + ";";
			value = value.replace("\\", "f");
			map["fa-" + result[2]] = "&#x" + result[3] + ";"; 
			FONT_AWESOME_ICON.push(result[2]);
		}
		
		map["fa-gears"] 	= "&#xf085;";
		map["fa-cogs"] 		= "&#xf085;"
	});
	
}).call(this);