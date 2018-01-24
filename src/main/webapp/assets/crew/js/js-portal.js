var manualScroll = false;

function markMenuItem(idx) {
	$(".js-menu div").removeClass("js-menuitem-selected");
	$(".js-menu div:eq(" + idx + ")").addClass("js-menuitem-selected");
}

function floatActionBar() {
	$(".js-actionBar").css("top",$(window).scrollTop()+"px");
}

function floatMenu() {
	var top = calcMenuYOffset() + $(window).scrollTop();
	$(".js-menu").css("top", top+"px");

	if (manualScroll) {
		manualScroll = false;
		return true;
	}

	var clientHeight = document.documentElement.clientHeight || document.body.clientHeight;
	var viewlineY = $(window).scrollTop() + clientHeight*0.382;
	var marked = -1;
	$(".js-formArea").each(function(){
		var offsetY = $(this).offset().top;
		if (viewlineY > offsetY)
			marked++;
	});
	marked = marked==-1 ? 0 : marked;
	markMenuItem(marked);
}

function floatElements() {
	floatActionBar();
	floatMenu();
}

function calcJsPageXOffset() {
	var width = $(".js-formArea").width();
	var clientWidth = document.documentElement.clientWidth || document.body.clientWidth;
	return clientWidth>width ? (clientWidth-width)/2 : 0;
}

function calcMenuYOffset() {
	var clientHeight = document.documentElement.clientHeight || document.body.clientHeight;
	return clientHeight*0.2;
}

function relocateActionBar() {
	var left = calcJsPageXOffset();
	$(".js-actionBar").css("left", left +"px");
}

function relocateMenu() {
	var pageOffsetX = (calcJsPageXOffset()-$(".js-menu").width())/2;
	var left = pageOffsetX>0 ? pageOffsetX : 0;
	var top = calcMenuYOffset();
	$(".js-menu").css("left", left+"px").css("top", top+"px");
}

function relocateElements() {
	relocateActionBar();
	relocateMenu();
}

function initMenu() {
	var clientWidth = document.documentElement.clientWidth || document.body.clientWidth;
	if (clientWidth <= 1280)
		return false;
	var menu = $("<div class='js-menu'></div>");
	$(".js-page").append(menu);
	$(".js-formArea .js-title").each(function(){
		var title = $(this).text();
		menu.append("<div class='js-menuitem'>" + title + "</div>");
	});
	markMenuItem(0);
	$(".js-menuitem").click(function(){
		var idx = $(".js-menuitem").index(this);
		var offsetY = $(".js-formArea:eq(" + idx + ")").offset().top;
		var clientHeight = document.documentElement.clientHeight || document.body.clientHeight;
		manualScroll = true;
		$(window).scrollTop(offsetY-clientHeight*0.382);
		markMenuItem(idx);
	});
}

function clickOperateBtn() {
	if($(this).hasClass("js-operateBtn-expand")) {
	   $(this).text("收起").addClass("js-operateBtn-collapse").removeClass("js-operateBtn-expand");
	   $(this).parents(".js-titleBar").next("div").slideDown();
	}else {
		$(this).text("展开").addClass("js-operateBtn-expand").removeClass("js-operateBtn-collapse");
		$(this).parents(".js-titleBar").next("div").slideUp();
	}
}


$(function() {
	initMenu();
	$(window).ready(relocateElements).resize(relocateElements);
	$(window).scroll(floatElements);
	$(".js-operateBtn").click(clickOperateBtn);
});