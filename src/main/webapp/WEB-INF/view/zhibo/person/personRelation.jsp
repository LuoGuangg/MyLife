<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>节奏直播导航间</title>
<meta name="keywords"
	content="直播,导航,直播导航,斗鱼,虎牙,熊猫,龙珠,全名,火猫,节奏直播间,DOTA2,LOL">
<meta name="description"
	content="直播导航,汇集各大主流平台的时时直播房间,统一按人气排名,让你不错过每一个主播的直播，让你寻找到平时难以发现的直播间">
<meta name="content-type" content="text/html; charset=UTF-8">
<meta name="author" content="lg">

<link rel="stylesheet" href="${ctxResources}/css/head.css">
	
<link rel="stylesheet" href="${ctxResources}/css/zhibostyle.css">
<link rel="stylesheet" href="${ctxResources}/css/layui.css">
	
</head>
<body>
	
	<div class="header" style="float: left;">
		<div class="headerinner">
			<ul class="headernav">
				<li class="logo">
					<!---<img src="" alt="" />--->
				</li>
				<li><a href="${ctx}/ZhiBo.html">直播导航</a></li>
				<li><a href="${ctx}/person/personRelation.html">角色关系</a></li>
				<c:if test="${user.id != null}">
				<li><a href="${ctx}/person/personGuanLi.html">关系管理</a></li>
				</c:if>
			</ul>

		</div>
	</div>

	<div id="zhiboCss">
		<div id="main" style="width: 100%;height:100%;"></div>
	</div>
	
	
	<script src="${ctxResources}/js/zhibo/person/person.js"></script>
	<script src="${ctxResources}/js/layer.js"></script>
	<script src="${ctxResources}/layui.js"></script>
	<script src="${ctxResources}/js/zhibo/zhibo.js"></script>
	<script src="${ctxResources}/js/echarts/echarts.min.js"></script>
	<script type="text/javascript">
		var myChart = echarts.init(document.getElementById('main'));
		option = {
			    title: {
			        text: ''
			    },
			    tooltip: {},
			    animationDurationUpdate: 1500,
			    animationEasingUpdate: 'quinticInOut',
			    label: {
			        normal: {
			            show: true,
			            textStyle: {
			                fontSize: 22
			            },
			        }
			    },
			    legend: {
			        x: "center",
			        show: false,
			        data: ["朋友", "战友", '亲戚']
			    },
			    series: [
	
			        {
			            type: 'graph',
			            layout: 'force',
			            symbolSize: 45,//圈大小
			            focusNodeAdjacency: true,
			            roam: true,
			            categories: [{
			                name: '朋友',
			                itemStyle: {
			                    normal: {
			                        color: "#FF0000",
			                    }
			                }
			            }, {
			                name: '同学',
			                itemStyle: {
			                    normal: {
			                        color: "#4592FF",
			                    }
			                }
			            }, {
			                name: '亲戚',
			                itemStyle: {
			                    normal: {
			                        color: "#3592F",
			                    }
			                }
			            }],
			            label: {
			                normal: {
			                    show: true,
			                    textStyle: {
			                        fontSize: 12//圈内字大小
			                    },
			                }
			            },
			            force: {
			                repulsion: 5000
			            },
			            edgeSymbolSize: [4, 50],
			            edgeLabel: {
			                normal: {
			                    show: true,
			                    textStyle: {
			                        fontSize: 13//线上字大小
			                    },
			                    formatter: "{c}"
			                }
			            },
			            data: [
			            	
			              <c:forEach items="${personList}" var="person">
			                {
				                name: '${person.name}',
				                category: ${person.category},
				                draggable: true
				            },
				          </c:forEach>  
			                
			             ],
			            links: [
			            	
			              <c:forEach items="${personRelationList}" var="personRelation">
			                {
			                	source: ${personRelation.source},
			                	target: ${personRelation.target},
			                	value: '${personRelation.relation}' ,
				            },
				          </c:forEach>  
				              	
			            ],
			            lineStyle: {
			                normal: {
			                    opacity: 0.9,
			                    width: 1,
			                    curveness: 0
			                }
			            }
			        }
			    ]
			};
	
	    myChart.setOption(option);  
	</script>
</body>
</html>
