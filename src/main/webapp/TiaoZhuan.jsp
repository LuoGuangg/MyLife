<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>     

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>正在跳转</title>
  </head>

  <body>
    请稍后，正在跳转...... <br>
  </body>
   <script type="text/javascript"> 
	window.onload=function(){ 
		var str=location.href;
		var num=str.indexOf("=");
		var url=str.substring(num+1, str.length);
		
		window.location.href=url;
	}	 

</script> 
</html>
