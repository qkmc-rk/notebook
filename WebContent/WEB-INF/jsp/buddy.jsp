<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><%=(String)session.getAttribute("useraccount") %>--好友管理</title>
</head>
<body>
	<h1>好友管理</h1>
	<h2>你的好友如下:</h2>
	<table border="1px">
		<thead>
			<tr>
				<td>好友名字</td>
				<td>好友性别</td>
				<td>好友年龄</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ friendList}" var="friend">
				<tr>
					<td>${ friend.getUserName()}</td>
					<td>${ friend.getSex()}</td>
					<td>${ friend.getAge()}</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
</body>
</html>