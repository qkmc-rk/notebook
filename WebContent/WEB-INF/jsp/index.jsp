<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="center.do"><%=(String)session.getAttribute("useraccount")%></a>,你已成功登录</h1>
	<fieldset>
		<legend>想做点什么？</legend>
		<ul>
			<li><a href="center.do">个人中心</a></li>
			<li><a href="buddy.do">好友管理</a></li>
			<li><a href="view.do">查看日记</a></li>
			<li><a href="note.do">写日记</a></li>
		</ul>
	</fieldset>
</body>
</html>