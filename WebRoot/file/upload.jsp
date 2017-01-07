<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文件-上传下载页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <h1>文件上传</h1> <br>
    <form method="post" action="${pageContext.request.contextPath}/UploadServlet" enctype="multipart/form-data">
    选择一个文件：
    <input type="text" name="filename"/>
    <input type="file" name="uploadFile"/>
    <br><br>
    <input type="submit" value="上传">
    </form>
    
     
    <br><br>
    
    <a href="FileDownload">下载文件</a>
    
  </body>
</html>
