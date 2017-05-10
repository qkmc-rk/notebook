<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="org.cat.entities.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><%=(String)session.getAttribute("useraccount") %>--个人中心</title>
</head>
<body>
	<h1>个人资料</h1>
	<fieldset>
		<legend>详细资料</legend>
		<table border="1px">
			<thead>
				<tr>
					<td>用户名</td>
					<td>账号</td>
					<td>性别</td>
					<td>年龄</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%= ((User)session.getAttribute("userInfo")).getUserName() %></td>
					<td><%= ((User)session.getAttribute("userInfo")).getUserAccount() %></td>
					<td><%= ((User)session.getAttribute("userInfo")).getSex() %></td>
					<td><%= ((User)session.getAttribute("userInfo")).getAge() %></td>
				</tr>
			</tbody>
		</table>
		<h2>暂时不能修改你的信息,请自重</h2>
	</fieldset>
</body>
</html>