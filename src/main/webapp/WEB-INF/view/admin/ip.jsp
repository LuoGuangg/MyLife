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
<link rel="stylesheet" href="${ctxResources}/css/admin/userList.css">

</head>
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
				<li class="layui-nav-item leftSelect"><a href="${ctx}/admin/ip.html">访问情况</a></li>
			</ul>
		</div>
	</div>

	<div class="layui-body">
		<!-- 内容主体区域 -->
		<div style="padding: 15px;">
				<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
				  <legend>用户列表</legend>
				</fieldset>  
				 
				<table class="layui-table">
				  <colgroup>
				    <col width="25%">
				    <col width="25%">
				    <col width="25%">
				    <col width="25%">
				  </colgroup>
				  <thead>
				    <tr>
				      <th>IP地址</th>
				      <th>国家</th>
				      <th>城市</th>
				      <th>访问时间</th>
				    </tr> 
				  </thead>
				  <tbody>
				  <c:forEach items="${vistIpList}" var="list">
				    <tr>
				      <td>${list.ip}</td>
				      <td>${list.country}</td>
				      <td>${list.city}</td>
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
	
<script>
	//用户下拉
	layui.use('element', function() {
		var element = layui.element;

	});
</script>
</body>
</html>
