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

<link rel="stylesheet" type="text/css"
	href="${ctxResources}/css/head.css">
	
<link rel="stylesheet" type="text/css"
	href="${ctxResources}/css/zhibostyle.css">
	
<link rel="stylesheet" type="text/css"
	href="${ctxResources}/css/zhiboPage.css">
</head>
<body>
	<form:form id="pageForm" action="ZhiBo.html" method="post">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<input id="index" name="index" type="hidden" />
	</form:form>

	<div class="header" style="float: left;">
		<div class="headerinner">
			<ul class="headernav">
				<li class="logo">
					<!---<img src="" alt="" />--->
				</li>
				<li><a href="ZhiBo.html">直播导航</a></li>
				<!-- 
				<li><a href="#">词云制作</a></li>
				 -->
				<li class="search"><a class="search_pic"></a></li>
				<li class="list"><a></a></li>
			</ul>
			<!-- 搜索 -->
			<form:form id="searchForm" action="ZhiBo.html" method="post">
				<div class="search_main">
					<button class="search_btn" type="submit"></button>
					<!-- 
					<input id="index" name="index" type="hidden" value="${page.results[0].index}"/> -->
					<input class="search_text" type="text" placeholder="搜索" id="name"
						name="name"> <span class="close_btn"></span>
				</div>
			</form:form>
			<!-- 
			<form action="ZhiBo.html">
				<div class="search_main">
					<button class="search_btn" type="submit"></button>
					<input class="search_text" type="text" placeholder="搜索"> <span
						class="close_btn"></span>
				</div>
			</form>
			 -->
			<!-- 会员登录 -->
			<div class="member">
				<p>会员中心</p>
				<ul>
					<li><img src="${ctxResources}/img/huiyuan1.png" alt="">
						<a href="javascript:void(0)" onclick="login();">登录</a></li>
					<li><img src="${ctxResources}/img/huiyuan1.png" alt="">
						<a href="#" onclick="register();">新会员注册</a></li>
				</ul>
			</div>
			
		</div>
	</div>

	<div id="zhiboCss">
		<div id="leftUl">
			<ul>
				<li id="li1"><a href="#" onclick="ZhiBoTiao(1);"><b>Dota2</b></a></li>
				<li id="li2"><a href="#" onclick="ZhiBoTiao(2);"><b>LOL</b></a></li>
				<li id="li3"><a href="#" onclick="ZhiBoTiao(3);"><b>DNF</b></a></li>
				<li id="li4"><a href="#" onclick="ZhiBoTiao(4);"><b>CSGO</b></a></li>
				<li id="li5"><a href="#" onclick="ZhiBoTiao(5);"><b>炉石传说</b></a></li>
				<li id="li6"><a href="#" onclick="ZhiBoTiao(6);"><b>守望先锋</b></a></li>
				<li id="li7"><a href="#" onclick="ZhiBoTiao(7);"><b>美女秀</b></a></li>
				<li id="li8"><a href="#" onclick="ZhiBoTiao(8);"><b>主机游戏</b></a></li>
				<li id="li9"><a href="#" onclick="ZhiBoTiao(9);"><b>绝地H1Z1</b></a></li>
			</ul>
		</div>
		<div id="rigt">
			<ul class="ul_d">
				<c:forEach items="${page.results}" var="list" varStatus="title">
					<li>
						<div id="div_${title.index }"
							onmousemove="onmove('${title.index}')"
							onmouseout="onout('${title.index}')"
							onclick="dianji('${list.url }')">
							<img src="${list.img }">
							<table>
								<tr>
									<td><font id="title_${title.index }">${list.title}</font></td>
								</tr>
								<tr>
									<td><font>${list.name}</font></td>
								</tr>
								<tr>
									<td><font>人气值：${list.num}</font></td>
								</tr>
								<tr id="tr_${title.index}">
									<td></td>
								</tr>
							</table>

						</div>
					</li>
				</c:forEach>
			</ul>
			<div class="pagination">${page}</div>
		</div>
	</div>
	
	
	<script src="${ctxResources}/js/jquery-1.8.3.min.js"></script>
	<script src="${ctxResources}/js/jquery.min.js"></script>
	<script src="${ctxResources}/js/layer.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			//console.log($(document).height());
			$("body:eq(0)").height($(document).height());
			var inx = ${page.results[0].index}
			var index = 'li' + inx
			$('#' + index).attr("class", "hover")
		});
		

		function register(){
			layer.open({
			  type: 1 //Page层类型
			  ,area: ['600px', '400px']
			  ,title: '注册'
			  ,shade: 0.6 //遮罩透明度
			  ,maxmin: true //允许全屏最小化
			  ,anim: 1 //0-6的动画形式，-1不开启
			  ,content: '<div class="register">'+
			  				'<form:form modelAttribute="user" method="post" action="user/save.html" onsubmit="return checkRegister();">'+
			  					'<form:input path="userName" id="userName" placeholder="账号：" onblur="userNameMouseOver();" value = "admin" /><div id="userName_div"></div><br />'+
			  					'<form:password path="userPwd" id="passWord" placeholder="密码：" onblur="passWordMouseOver();" value = "admin"/><div id="passWord_div"></div><br />'+
			  					'<input type="password" id="passWord2" placeholder="确认密码：" onblur="passWord2MouseOver();" value = "admin"/><div id="passWord2_div"></div><br />'+
			  					'<form:input path="email" id="email" placeholder="邮箱："  onblur="emailMouseOver();" value = "admin@qq.com"/><div id="email_div"></div><br />'+
			  					'<input type="submit" id="passWord" value="注册" /><br />'+
			  				'</form:form>'+
			  			'</div>'
			});    
		} 
	</script>
	<script src="${ctxResources}/js/zhibo/zhibo.js"></script>
</body>
</html>
