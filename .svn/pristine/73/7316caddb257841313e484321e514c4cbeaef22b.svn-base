Basestat = function(){};

/**
 * 饼图和地图的数据模板(按机构)
 */
Basestat.datavalue = [
                      {name: '南京市',value: Math.round(Math.random()*1000)},
                      {name: '苏州市',value: Math.round(Math.random()*1000)},
                      {name: '常州市',value: Math.round(Math.random()*1000)},
                      {name: '无锡市',value: Math.round(Math.random()*1000)},
                      {name: '镇江市',value: Math.round(Math.random()*1000)},
                      {name: '南通市',value: Math.round(Math.random()*1000)},
                      {name: '泰州市',value: Math.round(Math.random()*1000)},
                      {name: '扬州市',value: Math.round(Math.random()*1000)},
                      {name: '盐城市',value: Math.round(Math.random()*1000)},
                      {name: '淮安市',value: Math.round(Math.random()*1000)},
                      {name: '宿迁市',value: Math.round(Math.random()*1000)},
                      {name: '连云港市',value: Math.round(Math.random()*1000)},
                      {name: '徐州市',value: Math.round(Math.random()*1000)}
                  ];

Basestat.dataname = ['南京市', '苏州市', '常州市', '无锡市','镇江市','南通市','泰州市','扬州市','盐城市','淮安市','宿迁市','连云港市','徐州市'];

/**
 * 折线图
 * @param id
 * @param text
 * @param subtext
 * @param name
 * @param data_x
 * @param data_y
 * @returns
 */
Basestat.createLine = function(id,text,subtext,name,data_x,data_y){
	var myChart = echarts.init(document.getElementById(id)); 
	var  option = {
		    title : {
		        text: text,
		        subtext:subtext,
		        x :'center',
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
		        data:[name],
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
		            boundaryGap : true,
		            splitLine : false,
		            data : data_x,
		            axisLabel : {
		            	rotate: 60
		            }
		        }
		    ],
		    grid: {
		    	x: 40,
		    	x2: 20,
		    	y2: 100,
		    	},
		    yAxis : [
		        {
		            type : 'value',
		            nameLocation : 'start'
		        }
		    ],
		    series : [
		        {
		            name:name,
		            type:'line',
		            data:data_y,
		            itemStyle:{
		            	normal:{color : '#FFB90F'}
		            }
		        }
		    ]
		};    
	 myChart.setOption(option); 
	 window.onresize = function(){
		 myChart.resize();
	 }
	 return myChart;
};

/**
 * 柱形图
 * @param id
 * @param text
 * @param subtext
 * @param name
 * @param data_x
 * @param data_y
 * @returns
 */
Basestat.createBar = function(id,text,subtext,name,lengend,data_x,data_y){
	var myChart = echarts.init(document.getElementById(id)); 
	var option = {
		    title : {
		        text: text,
		        subtext: subtext,
		        x:'center'
		    },
		    color: ['#3398DB'],
		    legend: {
		        data:lengend,
		    	x:'right'
		    },
		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'line'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
		    grid: {
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : data_x,
		            axisTick: {
		                alignWithLabel: true
		            }
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:lengend,
		            type:'bar',
		            barWidth: '60%',
		            data:data_y
		        }
		    ]
		};  
	 myChart.setOption(option); 
	 window.onresize = function(){
		 myChart.resize();
	 }
	 return myChart;
};

/**
 * 堆叠柱状图
 * 
 */
    Basestat.createPilePie = function(id,title,subtext,lengend,data_x,data_y){
	var myChart = echarts.init(document.getElementById(id)); 
	option = {
		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
		    legend: {
		        data:lengend
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : data_x
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : data_y
		};
    myChart.setOption(option); 
	 window.onresize = function(){
		 myChart.resize();
	 }
	 return myChart;
};

/**
 * 饼图
 * @param id
 * @param text
 * @param subtext
 * @param name
 * @param dataname
 * @param datavalue
 * @returns
 */
Basestat.createPie = function(id,title,subtitle,name,data_legend,data_value){
	var myChart = echarts.init(document.getElementById(id)); 
	var option = {
		    title : {
		        text: title,
		        subtext: subtitle,
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient : 'vertical',
		        x : 'right',
		        data:data_legend
		    },
		    calculable : true,
		    series : [
		        {
		            name:name,
		            type:'pie',
		            radius : '55%',
		            itemStyle : {
		                normal : {
		                    label : {
		                        show : true,
		                        formatter: '{b} : {c} ({d}%)'
		                    },
		                    labelLine : {
		                        show : true
		                    }
		                },
		                emphasis : {
		                    label : {
		                        show : true,
		                        position : 'center',
		                        textStyle : {
		                            fontSize : '30',
		                            fontWeight : 'bold'
		                        }
		                    }
		                }
		            },
		            data:data_value
		        }
		    ]
		};
	 myChart.setOption(option); 
	 window.onresize = function(){
		 myChart.resize();
	 }
	 return myChart;	                    
}

/**
 * 饼图
 * @param id
 * @param text
 * @param subtext
 * @param name
 * @param dataname
 * @param datavalue
 * @returns
 */
Basestat.createAnnulus = function(id,title,subtitle,sname,data_legend,data_value){
	var myChart = echarts.init(document.getElementById(id)); 
	var option = {
		    title : {
		        text: title,
		        subtext: subtitle,
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		    	 orient : 'vertical',
			        x : 'right',
		        data:data_legend
		    },
		    calculable : true,
		    series : [
		        {
		            name:sname,
		            type:'pie',
		            radius : ['50%', '70%'],
		            itemStyle : {
		                normal : {
		                    label : {
		                        show : true,
		                        formatter: '{b} : {c} ({d}%)'
		                    },
		                    labelLine : {
		                        show : true,
		                        position: 'outer'
		                    }
		                },
		                emphasis : {
		                    label : {
		                        show : true,
		                        position : 'center',
		                        textStyle : {
		                            fontSize : '30',
		                            fontWeight : 'bold'
		                        }
		                    }
		                }
		            },
		            data:data_value
		        }
		    ]
		};
	 myChart.setOption(option); 
	 window.onresize = function(){
		 myChart.resize();
	 }
	 return myChart;	                    
}

/**
 * 地图
 * @param id
 * @param text
 * @param subtext
 * @param name
 * @param datavalue
 * @param min
 * @param max
 * @returns
 */
Basestat.createMap = function(id,text,data,minvalue,maxvalue){
	var myChart = echarts.init(document.getElementById(id)); 
	var option = {
            title: {
                text: text,
                left: 'center'
            },
            tooltip : {
		        trigger: 'item'
		    },
		    dataRange: {
		        min: minvalue,
		        max: maxvalue,
		        x: 'left',
		        y: 'bottom',
		        color:['red','yellow'],
		        text:['高','低'],// 文本，默认为数值文本
		        calculable : true
		    },
            series: [
                {
                    type: 'map',
                    mapType: '重庆',
                    label: {
                        emphasis: {
                            textStyle: {
                                color: '#fff'
                            }
                        }
                    },
                    itemStyle: {
                        normal: {
                            borderColor: '#389BB7',
                            areaColor: '#fff'
                        },
                        emphasis: {
                            areaColor: '#389BB7',
                            borderWidth: 0
                        }
                    },
                    animation: false,
                    data:data
                }
            ]
        };
	 myChart.setOption(option); 
	 window.onresize = function(){
		 myChart.resize();
	 }
	 return myChart;	                    
}
