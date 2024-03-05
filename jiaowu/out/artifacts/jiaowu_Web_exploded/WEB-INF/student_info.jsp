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
					<li><a href="LoginServlet"><i class="glyphicon glyphicon-chevron-right"></i> 查看成绩</a></li>
					<li><a href="StudentInfoServlet"><i class="glyphicon glyphicon-chevron-right"></i> 个人信息</a></li>
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
								<td>学号</td>
								<td>姓名</td>
								<td>性别</td>
								<td>专业</td>
								<td>院系</td>
								<td>班级</td>
							</tr>
							<tr>
								<td>${student.sno}</td>
								<td>${student.sname}</td>
								<td>${student.sex}</td>
								<td>${student.major}</td>
								<td>${student.department}</td>
								<td>${student.sclass}</td>
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
