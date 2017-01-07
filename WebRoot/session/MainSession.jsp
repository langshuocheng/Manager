<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%

	//获取session创建时间
	Date createTime = new Date (session.getCreationTime());
	//获取最后访问页面的时间
	Date lastAccessTime = new Date(session.getLastAccessedTime());
	
	String title = "访问菜鸟教程实例";
	Integer visitCount = new Integer(0);
	String visitCountKey = new String("visitCount");
	String userIDKey = new String("userID");
	String userID = new String("ABCD");
	
	//检测网页是否由新的访问用户
	if (session.isNew())
	{
		title = "访问菜鸟教程";
		session.setAttribute(userIDKey, userID);
		session.setAttribute(visitCountKey, visitCount);
	}
	else
	{
		visitCount = (Integer)session.getAttribute(visitCountKey);
		visitCount += 1;
		userID = (String)session.getAttribute(userIDKey);
		session.setAttribute(visitCountKey, visitCount);
	}
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>session 跟踪</title>
    
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
  <h1>访问统计</h1>
  <%
  	Integer hitsCount = (Integer)application.getAttribute("hitCounter");
  	if (hitsCount == null || hitsCount == 0)
  	{
  		//第一次访问
  		out.println("欢迎访问");
  		hitsCount = 1;
  		
  	}
  	else
  	{
  		//返回访问值
  		out.println("再次访问");
  		hitsCount += 1;
  	}
  	application.setAttribute("hitCounter", hitsCount);
  %>
  <p>页面访问量为：<%= hitsCount %></p>
  <h1>Session 跟踪</h1>
  <table border="1" align="center">
  <tr bgcolor="#949494">
  <th>值</th>
  </tr>
  <tr>
  <td>id</td>
  <td><% out.print( session.getId());  %></td>
  </tr>
  <tr>
  <td>创建时间</td>
  <td><% out.print( createTime); %></td>
  </tr>
  <tr>
  <td>最后访问时间</td>
  <td><% out.print( lastAccessTime); %></td>
  </tr>
  <tr>
  <td>用户 ID</td>
  <td><% out.print( userID); %></td>
  </tr>
  <tr>
  <td>访问次数</td>
  <td><% out.print( visitCount); %></td>
  </tr>
  </table>
  </body>
</html>
