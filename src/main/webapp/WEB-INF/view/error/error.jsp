<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>节奏直播导航间错误异常</title>
<meta name="keywords"
	content="直播,导航,直播导航,斗鱼,虎牙,熊猫,龙珠,全名,火猫,节奏直播间,DOTA2,LOL">
<meta name="description"
	content="直播导航,汇集各大主流平台的时时直播房间,统一按人气排名,让你不错过每一个主播的直播，让你寻找到平时难以发现的直播间">
<meta name="content-type" content="text/html; charset=UTF-8">
<meta name="author" content="lg">

<link rel="stylesheet" href="${ctxResources}/css/admin/pintuer.css" />

</head>
<div class="container" style=" margin-top:8%;"> 
   <div class="panel margin-big-top">
      <div class="text-center">
         <br>
         <h2 class="padding-top"> <stong>${loginerror}</stong> </h2>
         <div class=""> 
            <div class="float-left">
                <img src="${ctxResources}/img/error/error-1.gif">
                <div class="alert"> 卧槽！页面不见了！ </div>
            </div>
            <div class="float-right">
               <img src="${ctxResources}/img/error/error-2.png" width="260"> 
            </div>
          </div>
          <div class="padding-big">
               <a href="${ctx}/ZhiBo.html" class="button bg-yellow">返回首页</a>
               <a href="" class="button">保证不打死管理员</a>
          </div> 
      </div> 
   </div> 
</div>
</html>
