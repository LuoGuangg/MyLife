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
<link rel="stylesheet" href="${ctxResources}/css/person/person.css">

</head>
<body>

<div class="layui-layout layui-layout-admin">
	<div class="layui-header">
		<div class="layui-logo goperson" onclick="window.location='${ctx}/person/personRelation.html'">返回角色关系页面</div>
	</div>

	<div class="layui-side layui-bg-black">
		<div class="layui-side-scroll">
		
			<ul class="layui-nav layui-nav-tree" lay-filter="test">
				<li class="layui-nav-item leftSelect"><a href="${ctx}/person/personGuanLi.html">人物列表</a></li>
			</ul>
		</div>
	</div>

	<div class="layui-body">
		<!-- 内容主体区域 -->
		<div style="padding: 15px;">
				<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
				  <legend>人物列表</legend>
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
				      <th>角色</th>
				      <th>角色</th>
				      <th>关系</th>
				      <th>操作</th>
				    </tr> 
				  </thead>
				  <tbody>
				  <c:forEach items="${personRelationlist}" var="list">
				    <tr>
				      <td>${list.source}</td>
				      <td>${list.target}</td>
				      <td>${list.relation}</td>
				      <td>
				      	<a href="${ctx}/person/personRelationDelete.html?rid=${list.id}">删除关系</a>
				      </td>
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
