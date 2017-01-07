<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<title>员工保存页面</title>

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
					<li><a href="#">主页</a> <span class="divider">/</span></li>
					<li class="active">增加新项目</li>
				</ul>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span8">
				<form class="form-horizontal"
					action="${pageContext.request.contextPath}/experenceService/savaExperence"
					method="post">

					<table class="table table-bordered">
						<tr>
							<td>项目承建编号：</td>
							<td><input type="text" name="eId" />
						</tr>
						<tr>
							<td>项目责任人编号：</td>
							<td><input type="text" name="pId" /></td>
						</tr>
						<tr>
							<td>项目类型编号：</td>
							<td><input type="text" name="eType" /></td>
						</tr>
						<tr>
							<td>开始时间：</td>
							<td><input type="text" name="eStartTime" /></td>
						</tr>
						<tr>
							<td>项目完成度：</td>
							<td><input type="text" name="eProgress" /></td>
						</tr>
						
						
						<tr>
							<input class="btn btn-danger" type="submit" value="保存" />
							<td></td>
							<input type="reset" value="取消" class="btn btn-info" />
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div class="span4">
				<div class="alert">
					<button type="button" class="close" data-dismiss="alert">×</button>
					<h4>提示!</h4>
					<strong>警告!</strong> 请注意你的个人隐私安全.
				</div>
			</div>
		</div>
	</div>
</body>
</html>
