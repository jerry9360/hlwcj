[#import "common/layout.ftl" as layout] 
[#assign jss=["assets/js/date-time/bootstrap-timepicker.min.js","assets/js/echarts/echarts.js","assets/js/Basestat.js"]]
 [@layout.main modelcode=['${menucode}','96096_data'] otherjs=jss sername=['${menuname}'] pagename='统计分析']

<iframe id="stat-frame" width="100%" height="800px" scrolling="no" frameBorder=0 marginwidth=0 marginheight=0 src="${urlpath}" onload=setIframeHeight(this)></iframe>
<script type="text/javascript">
//document.domain = "caibaojian.com";
function setIframeHeight(iframe) {
	iframe.height = $(".content-body").height();
};

/* window.onload = function () {
	setIframeHeight(document.getElementById('stat-frame'));
}; */
</script>
[/@layout.main]