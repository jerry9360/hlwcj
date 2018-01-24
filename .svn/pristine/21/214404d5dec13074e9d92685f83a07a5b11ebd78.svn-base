var initMarkData = function(data){
	var dataMark = [];
	$.each(data,function(i,e){
		dataMark.push({value:data[i],xAxis:i,yAxis:data[i]});
	});
	return dataMark;
}
var createIndexLine1 = function(id,text,name,data_x,data_y21,data_y22,dataMark){
	var myChart = echarts.init(document.getElementById(id)); 
	var  option = {
		    title : {
		        text: text,
		        x :'left',
		        textStyle :{
		            fontSize: 20,
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
		            data:data_y21,
		            markPoint:{
		            
		            	data:dataMark
		            },
		            itemStyle:{
		            	normal:{color : '#CD2626'}
		            }
		        },
		        {
		            name:name[1],
		            type:'line',
		            data:data_y22,
		            markPoint:{
		            	data:dataMark
		            },
		            itemStyle:{
		            	normal:{color : '#474747'}
		            }
		         },
		    ]
		};    
	 myChart.setOption(option); 
	 window.onresize = function(){
		 myChart.resize();
	 }
	 return myChart;
};