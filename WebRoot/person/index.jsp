<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    
    <title>用户管理系统-查询页面</title>
    
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
    <div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<ul class="breadcrumb">
				<li>
					<a href="#">主页</a> <span class="divider">/</span>
				</li>
				<li class="active">
					用户列表
				</li>
			</ul>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span8">				 
		<a href="${pageContext.request.contextPath}/personService//tosavePerson" class="btn btn-danger"><span class="glyphicon glyphicon-wrench"></span>新增员工</a></td>
		
	<table  class="table table-striped">
        <thead><tr> <th>编号</th><th>姓名</th><th>性别</th><th>年龄</th><th>职位</th><th>入职时间</th><th>工作年限</th>
        <th> &nbsp; &nbsp; &nbsp;删除       &nbsp; &nbsp;   &nbsp;  &nbsp; &nbsp;    修改  &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; 添加项目经验</th> </tr>
        </thead>
        <tbody>
        <c:choose>
        <c:when test="${countPerson>=1}">
        	<c:forEach  items="${listPerson}" var="person">
         	<tr>
				<td>${person.pId}</td>
				<td>${person.pName}</td>
				<td>${person.pSex}</td>
				<td>${person.pAge}</td>
				<td>${person.pPost}</td>
				<td>${person.pStartTime}</td>
				<td>${person.pYear}</td>
				<td><a  href="${pageContext.request.contextPath}/personService/deletePerson?pId=${person.pId}" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-remove"></span>删除</a>
				<a class="btn btn-primary btn-lg active" 
				 href="${pageContext.request.contextPath}/personService/toupdataPerson?pId=${person.pId}" ><span class="glyphicon glyphicon-wrench"></span>修改</a>
				 <a href="${pageContext.request.contextPath}/experenceService/tosavaExperence?pId=${person.pId}" class="btn btn-danger"><span class="glyphicon glyphicon-wrench"></span>增加项目经验</a></td>
			</tr> 
        </c:forEach>
        </c:when>
        <c:otherwise>
         <tr ><td colspan="5" style="text-align: center;" >对不起 暂无相应的数据</td></tr>
        </c:otherwise>
        </c:choose>
        </tbody>
        </table>
		</div>
		<div class="span4">
			<div class="alert">
				 <button type="button" class="close" data-dismiss="alert">×</button>
				<h4>
					提示!
				</h4> <strong>警告!</strong> 请注意保护员工隐私安全.
			</div>
		</div>
	</div>
</div>
  </body>
</html>
