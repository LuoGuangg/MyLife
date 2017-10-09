<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>节奏直播导航间后台</title>
<meta name="keywords"
	content="直播,导航,直播导航,斗鱼,虎牙,熊猫,龙珠,全名,火猫,节奏直播间,DOTA2,LOL">
<meta name="description"
	content="直播导航,汇集各大主流平台的时时直播房间,统一按人气排名,让你不错过每一个主播的直播，让你寻找到平时难以发现的直播间">
<meta name="content-type" content="text/html; charset=UTF-8">
<meta name="author" content="lg">

<link rel="stylesheet" href="${ctxResources}/css/layui.css">
<link rel="stylesheet" href="${ctxResources}/css/admin/admin.css">

</head>
<body>

<div class="layui-layout layui-layout-admin">
	<div class="layui-header">
		<div class="layui-logo">节奏直播导航后台</div>
		<!--
		<ul class="layui-nav layui-layout-left">
			<li class="layui-nav-item"><a href="">控制台</a></li>
			<li class="layui-nav-item"><a href="">商品管理</a></li>
			<li class="layui-nav-item"><a href="">用户</a></li>
			<li class="layui-nav-item"><a href="javascript:;">其它系统</a>
				<dl class="layui-nav-child">
					<dd>
						<a href="">邮件管理</a>
					</dd>
					<dd>
						<a href="">消息管理</a>
					</dd>
					<dd>
						<a href="">授权管理</a>
					</dd>
				</dl></li>
		</ul>
		  -->
		<ul class="layui-nav layui-layout-right">
			<li class="layui-nav-item"><a href="javascript:;"> <img
					src="http://t.cn/RCzsdCq" class="layui-nav-img"> ${user.userName}
			</a>
				<dl class="layui-nav-child">
					<dd>
						<a href="">基本资料</a>
					</dd>
					<dd>
						<a href="">安全设置</a>
					</dd>
				</dl></li>
			<li class="layui-nav-item"><a href="">退了</a></li>
		</ul>
	</div>

	<div class="layui-side layui-bg-black">
		<div class="layui-side-scroll">
		
			<ul class="layui-nav layui-nav-tree" lay-filter="test">
				<li class="layui-nav-item"><a href="${ctx}/admin.html">用户信息</a></li>
				<li class="layui-nav-item"><a href="${ctx}/admin/ip.html">访问情况</a></li>
				<li class="layui-nav-item leftSelect"><a href="${ctx}/admin/addDuMa.html">赌马统计</a></li>
			</ul>
		</div>
	</div>

	<div class="layui-body">
		<!-- 内容主体区域 -->
		<div style="padding: 15px;">
				<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
				  <legend>添加赌马信息</legend>
				</fieldset>  
					<form action="${ctx}/admin/addDuMa.html" method="post">
						<select name="maName1"> 
							<option value="爱德华">爱德华</option> 
							<option value="伊萨尔">伊萨尔</option> 
							<option value="希恩">希恩</option> 
							<option value="罗兰">罗兰</option> 
							<option value="吉利特">吉利特</option> 
							<option value="理查德">理查德</option> 
							<option value="莱奥">莱奥</option> 
							<option value="贝奥武夫">贝奥武夫</option> 
						</select> 
						
						<select name="maColor1"> 
							<option value="蓝">蓝</option> 
							<option value="绿">绿</option> 
							<option value="红">红</option> 
							<option value="黄">黄</option> 
							<option value="紫">紫</option> 
						</select> 
						
						<span>VS</span>
						
						<select name="maName2"> 
							<option value="爱德华">爱德华</option> 
							<option value="伊萨尔">伊萨尔</option> 
							<option value="希恩">希恩</option> 
							<option value="罗兰">罗兰</option> 
							<option value="吉利特">吉利特</option> 
							<option value="理查德">理查德</option> 
							<option value="莱奥">莱奥</option> 
							<option value="贝奥武夫">贝奥武夫</option> 
						</select> 
						
						<select name="maColor2"> 
							<option value="蓝">蓝</option> 
							<option value="绿">绿</option> 
							<option value="红">红</option> 
							<option value="黄">黄</option> 
							<option value="紫">紫</option> 
						</select> 
						
						<span>胜者</span>
							<select name="maWin"> 
							<option value="前者">前者</option> 
							<option value="后者">后者</option> 
						</select> 
						
						<button type="submit">添加记录</button>
					</form>
				<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
				  <legend>赌马统计信息</legend>
				</fieldset> 
					
				<form:form id="searchForm" action="${ctx}/admin/addDuMa.html" method="post">
					<select name="maNameSearch"> 
							<option value=""></option> 
							<option value="爱德华">爱德华</option> 
							<option value="伊萨尔">伊萨尔</option> 
							<option value="希恩">希恩</option> 
							<option value="罗兰">罗兰</option> 
							<option value="吉利特">吉利特</option> 
							<option value="理查德">理查德</option> 
							<option value="莱奥">莱奥</option> 
							<option value="贝奥武夫">贝奥武夫</option> 
					</select> 
					
					<select name="maColorSearch"> 
							<option value=""></option> 
							<option value="蓝">蓝</option> 
							<option value="绿">绿</option> 
							<option value="红">红</option> 
							<option value="黄">黄</option> 
							<option value="紫">紫</option> 
					</select> 
					
					<span> VS </span>
					
					<select name="maNameSearch2"> 
							<option value=""></option> 
							<option value="爱德华">爱德华</option> 
							<option value="伊萨尔">伊萨尔</option> 
							<option value="希恩">希恩</option> 
							<option value="罗兰">罗兰</option> 
							<option value="吉利特">吉利特</option> 
							<option value="理查德">理查德</option> 
							<option value="莱奥">莱奥</option> 
							<option value="贝奥武夫">贝奥武夫</option> 
					</select> 
					
					<select name="maColorSearch2"> 
							<option value=""></option> 
							<option value="蓝">蓝</option> 
							<option value="绿">绿</option> 
							<option value="红">红</option> 
							<option value="黄">黄</option> 
							<option value="紫">紫</option> 
					</select> 
					
					<button class="layui-btn layui-btn-small" type="submit" value="查询">查询</button>
				</form:form>
				
				<table class="layui-table">
				  <colgroup>
				    <col width="25%">
				    <col width="25%">
				    <col width="25%">
				    <col width="25%">
				  </colgroup>
				  <thead>
				    <tr>
				      <th>马匹</th>
				      <th>马匹</th>
				      <th>胜利者</th>
				      <th>时间</th>
				    </tr> 
				  </thead>
				  <tbody>
				  <c:forEach items="${maList}" var="list">
				    <tr>
				      <td>${list.maType}</td>
				      <td>${list.maType2}</td>
				      <td>${list.maWin}</td>
				      <td>${list.createDateString}</td>
				    </tr>
				  </c:forEach>
				  </tbody>
				</table>
		</div>
	</div>

	<div class="layui-footer">
		<!-- 底部固定区域 -->
		© zhibolg.com - 节奏导航
	</div>
</div>

<script src="${ctxResources}/layui.js"></script>
<script src="${ctxResources}/js/admin/admin.js"></script>
	
<script>
	//用户下拉
	layui.use('element', function() {
		var element = layui.element;

	});
</script>
</body>
</html>
