<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公告页面</title>

</head>
<body>
	<h1>公告</h1>
	<h2>当前时间为</h2><h2 id="time"></h2>
	<div style="border: solid 1px; width: 300px; height:200px">
		<p>这里会时不时发布一些新的公告,请各位用户经常关注~ ~!</p>
	</div>
	<div style="border: solid 1px; width: 300px; height:200px">
		<p>2017-05-10 17:19</p>
		<p>听阮少爷说,这个网站目前已经实现了注册登录查看好友和自己的信息了哦~ ~!</p>
	</div>
	
	<script>
		var date =new Date();
		document.getElementById("time").innerHTML = date;
	</script>
</body>
</html>