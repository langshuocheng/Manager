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

<title>用户管理系统</title>
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
	<div class="container">
		<div class="row">
			<div class="span12">
				<div class="navbar navbar-inverse">
					<div class="navbar-inner">
						<div class="container-fluid">
							

							<div class="nav-collapse collapse navbar-responsive-collapse">
									
								
								
							</div>

						</div>
					</div>

				</div>
			</div>
		</div>
		<div class="row">
			<div class="span4">
				<form class="form-search">
					<input class="input-medium search-query" type="text" />
					<button type="submit" class="btn">查找</button>
				</form>
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/personService/toselectAllPerson">员工管理</a>
					</li>
					<li><a
						href="${pageContext.request.contextPath}/experenceService/toselectPerosnExperenceWithList">承建项目管理</a>
					</li>
					<li><a
						href="${pageContext.request.contextPath}/projectService/toselectProject">项目名称列表</a>
					</li>
					<li><a
						href="${pageContext.request.contextPath}/file/upload.jsp">项目资料上传</a>
					</li>
				</ul>
			</div>
			<div class="span4"></div>

			<h4>提示!</h4>
			<strong>警告!</strong> 请注意你的个人隐私安全.
		</div>
	</div>
	<div class="row">
		<div class="span6"></div>
		<div class="span6"></div>
	</div>

</body>
</html>
