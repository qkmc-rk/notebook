<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>查看好友日记</title>
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
		<h1>好友的日记不要乱翻,尤其是别人不让你翻阅的时候!</h1>
		<h2>好友也有喜欢给你看的日记</h2>
		<c:forEach items="${diaryMap }" var="diarylist">
			<c:forEach items="${diarylist.value }" var="diary">
				<div class="record">
					<div class="record-head">
						<table border="0px">
							<tr>
								<th>好友:<a href="#">${diarylist.key }</a></th>
								<th>日期:${diary.getYear() }-${diary.getMonth() }-${diary.getDay() }</th>
								<th>星期:${diary.getWeek() }</th>
								<th>天气:${diary.getWeather() }</th>
							</tr>
						</table>
					</div>
					<div id="record-content">
						<p>${diary.getContent() }</p>
					</div>
				</div>
			</c:forEach>
		</c:forEach>
	</body>
</html>