<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>学生成绩管理界面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<div>
	<a href="#">学生成绩管理系统</a>
	<ul>
		<li><a href="#">${admin.admin}</a>
			<ul>
				<li><a href="update_admin_pwd.jsp">修改密码</a></li>
				<li><a href="LogoutServlet">退出系统</a></li>
			</ul>
		</li>
	</ul>
</div>

	<div>
		<div>
			<div>
				<ul>
					<li><a href="LoginServlet"><i class="glyphicon glyphicon-chevron-right"></i> 成绩管理</a></li>
					<li><a href="TeacherInfoServlet"><i class="glyphicon glyphicon-chevron-right"></i> 个人信息</a></li>
				</ul>
			</div>
			<div>
				<div>
					<div>详细内容</div>
				</div>
				<div>
					<form name="myform" method="post" style="overflow-x: auto;">
						<br />

						<table width="100%">
							<tr>
								<td>教工号</td>
								<td>姓名</td>
								<td>性别</td>
								<td>院系</td>
								<td>学历</td>
								<td>职称</td>
							</tr>
							<tr>
								<td>${teacher.tno}</td>
								<td>${teacher.tname}</td>
								<td>${teacher.sex}</td>
								<td>${teacher.department}</td>
								<td>${teacher.degree}</td>
								<td>${teacher.title}</td>
							</tr>
						</table>

						<div></div>
						<div></div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>
	${message }
</body>
</html>
