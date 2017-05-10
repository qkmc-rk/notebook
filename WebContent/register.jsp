<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>

<script type="text/javascript">
	
</script>
</head>
<body>
	<h1 align="ceter">注册页面</h1>
	<fieldset>
		<legend>注册吧小宝贝</legend>
		<form action="regist.do" method="post">
				<p>
					<label for="useraccount">账户名:</label>
					<input type="text" id="useraccount" name="useraccount" placeholder="请输入账号" />	
				</p>
				<p>
					<label for="username">请输入昵称:</label>
					<input type="text" id="username" name="username" placeholder="请输入昵称" />	
				</p>
				<p>
					<label for="username">性别:</label>
					<label><input type="radio" name="sex" value="男">男</label>
					<label><input type="radio" name="sex" value="女">女</label>
				</p>
				<p>
					<label for="age">年龄:</label>
					<input type="number" name="age" min="1" max="150" />
					
				</p>
				<p>
					<label for="userpassword">密 &nbsp; 码:</label>
					<input type="password" name="userpassword" id="userpassword" placeholder="请输入密码" />
					
				</p>
				<p>
					<label for="userpassword2">确 认密码:</label>
					<input type="password" name="userpassword2" id="userpassword2" placeholder="请输入密码" />
					
				</p>
				<p>
					<input type="submit" value="注册"/>	
				</p>
			</form>
	</fieldset>
</body>
</html>