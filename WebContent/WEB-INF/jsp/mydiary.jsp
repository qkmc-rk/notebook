<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>我的日记</title>
		<style type="text/css">
			.record{
				width: 500px;
				height: 200px;
				margin: auto;
				border: solid 1px royalblue;
			}
			.record-head{
				width: 100%;
				height: 40px;
				margin: auto;
				border: solid 1px royalblue;
			}
		</style>
	</head>
	<body>
		<h1>日记,日记,每日一记!</h1>
		<h2>你莫搞笑</h2>
		<c:forEach items="${myDiaryList }" var="diary">
			<div class="record">
				<div class="record-head">
					<table border="0px">
						<tr>
							<th>时间:${diary.getYear() }-${diary.getMonth() }-${diary.getDay() }</th>
							<th> | 星期:${diary.getWeek() }</th>
							<th> | 天气:${diary.getWeather() }</th>
							<th> | 日记类型:${diary.getContenType() }</th>
						</tr>
					</table>
				</div>
				<div id="record-content">
					<p>${diary.getContent() }</p>
				</div>
			</div>
		</c:forEach>
		
	</body>
</html>