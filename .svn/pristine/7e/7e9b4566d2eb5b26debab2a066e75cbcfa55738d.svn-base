NumberToCnUtil = function(){};

NumberToCnUtil.number2CNMontrayUnit = function(num){
	if (!/^(0|[1-9]\d*)(\.\d+)?$/.test(num)){
		return "数据非法";
	}
    var unit = "千百拾亿千百拾万千百拾元角分";
    var str = "";
    num += "00";
    var p = num.indexOf('.');
    if (p >= 0)
    	num = num.substring(0, p) + num.substr(p+1, 2);
        unit = unit.substr(unit.length - num.length);
    for (var i=0; i < num.length; i++)
        str += '零壹贰叁肆伍陆柒捌玖'.charAt(num.charAt(i)) + unit.charAt(i);
    return str.replace(/零(千|百|拾|角)/g, "零").replace(/(零)+/g, "零").replace(/零(万|亿|元)/g, "$1").replace(/(亿)万|壹(拾)/g, "$1$2").replace(/^元零?|零分/g, "").replace(/元$/g, "元整");
}