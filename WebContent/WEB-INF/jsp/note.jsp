<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>写日记,做计划</title>
	</head>
	<body>
		<h1>写日记</h1>
		<h1>还是写计划?<small>随便你咯~ ~!</small></h1>
		<fieldset id="">
			<legend>日记</legend>
			<form action="savenote.do" method="post">
				<p>
					<label for="date">日期</label>
					<input type="date" name="date" id="date" value="" />
				</p>
				<p>
					<label for="week">星期</label>
					<input type="number" name="week" id="week" value="1" max="7"	min="1" />
				</p>
				<p>
					<label for="weather">天气</label>
					<input type="text" name="weather" id="weather" value=""/>
				</p>
				<p>
					<label for="type">日记类型</label>
					<input type="radio" name="type" id="type" value="私密" >私密</input>
					<input type="radio" name="type" id="type" value="公开" >公开</input>
				</p>
				<p>
					<textarea name="content" rows="20" cols="50">输入日记的内容..</textarea>
				</p>
				<input type="submit" value="提交日记"/>
			</form>			
		</fieldset>
		<input type="button" value="测试日期" onclick="func1()">
		<script type="text/javascript">
			function func1(){
				var dv = document.getElementById("date");
				alert(dv.value);
			}
		</script>
	</body>
</html>
</html>