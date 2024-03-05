<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="utf-8">
<title>教务处学生成绩管理系统</title>
</head>

<body>

<div>
	<h1>修改密码</h1>
	<form action="UpdateTeaPwdServlet" method="post">
		<input type="text" name="old_password" placeholder="原密码">
		<input type="password" name="new_password" placeholder="新密码">
		<input type="password" name="new_password_again" placeholder="再次输入密码">
		<div>
			<div>&nbsp;</div>
			<button type="submit">修改</button>
		</div>
	</form>
</div>

${message }
</body>

</html>


