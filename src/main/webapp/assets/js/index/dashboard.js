var initMarkData = function(data){
	var dataMark = [];
	$.each(data,function(i,e){
		dataMark.push({value:data[i],xAxis:i,yAxis:data[i]});
	});
	return dataMark;
}
var createIndexLine = function(id,text,name,data_x,data_y,dataMark){
	var myChart = echarts.init(document.getElementById(id)); 
	var  option = {
		    title : {
		        text: text,
		        x :'left',
		        textStyle :{
		            fontSize: 14,
		            fontWeight: 'bolder'
		        }
		    },
		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {         
		            type : 'shadow'
		        }
		    },
		    legend: {
		        data:name,
		        x:'right',
		        selectedMode:false
		    },
		    toolbox: {
		        show : false
		    },
		    calculable : false,
		    xAxis : [
		        {
		            type : 'category',
		            boundaryGap : false,
		            data : data_x
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:name[0],
		            type:'line',
		            data:data_y,
		            markPoint:{
		            	data:dataMark
		            },
		            itemStyle:{
		            	normal:{color : '#A020F0'}
		            }
		        }
//		        {
//		            name:name[1],
//		            type:'line',
//		            data:data_y12,
//		            markPoint:{
//		            	data:dataMark
//		            },
//		            itemStyle:{
//		            	normal:{color : '#8DEEEE'}
//		            }
//		        },
//		        {
//		            name:name[2],
//		            type:'line',
//		            data:data_y13,
//		            markPoint:{
//		            	data:dataMark
//		            },
//		            itemStyle:{
//		            	normal:{color : '#32CD32'}
//		            }
//		        }
		    ]
		};    
	 myChart.setOption(option); 
	 window.onresize = function(){
		 myChart.resize();
	 }
	 return myChart;
};