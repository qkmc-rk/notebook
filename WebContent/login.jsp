<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css"/>
</head>
<body>
	<h1 class="nav_title">登录页面</h1>
	<fieldset>
		<legend>登录吧小宝贝</legend>
		<form action="index" method="post">
				<p>
					<label for="useraccount">账户名:</label>
					<input type="text" id="useraccount" name="useraccount" placeholder="请输入账号" />	
				</p>
				<p>
					<label for="username">密 &nbsp; 码:</label>
					<input type="password" name="userpassword" id="userpassword" placeholder="请输入密码" />
					
				</p>
				<p>
					<input type="submit" value="登录"/>	
				</p>
			</form>
	</fieldset>
</body>
</html>