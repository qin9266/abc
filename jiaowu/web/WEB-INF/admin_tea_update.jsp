<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>学生成绩管理界面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body >


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

	<div >
		<div >
			<div>
				<ul>
					<li><a href="LoginServlet"><i class="glyphicon glyphicon-chevron-right"></i> 学生信息管理</a></li>
					<li><a href="AdminToTeaServlet"><i class="glyphicon glyphicon-chevron-right"></i> 教师信息管理</a></li>
					<li><a href="AdminToCourseServlet"><i class="glyphicon glyphicon-chevron-right"></i> 课程信息管理</a></li>
				</ul>
			</div>

			<div>
				<div>
					<h3>修改课程信息</h3>
				</div>

				<div>
					<div>
						<div>
							<div>&nbsp;</div>
						</div>
						<div>
							<form action="UpdateTeaServlet?tokenStr=${sessionScope.CONTROL_REFRESH}&pageNum=${pageNum}" method="post">
								<fieldset>
									<legend>教工号:${teacher.tno}</legend>
									<input type="hidden" name="tno" value="${teacher.tno}">
									<div>
										<label>姓名</label>
										<input type="text" name="tname" value="${teacher.tname}">
									</div>
									<div>
										<label>密码</label>
										<input type="text" name="password" value="${teacher.password}">
									</div>
									<div>
										<label>性别</label>
										<input type="text" name="sex" value="${teacher.sex}">
									</div>
									<div>
										<label>院系</label>
										<input type="text" name="department" value="${teacher.department}">
									</div>
									<div>
										<label>学历</label>
										<input type="text" name="degree" value="${teacher.degree}">
									</div>
									<div>
										<label>职称</label>
										<input type="text" name="title" value="${teacher.title}">
									</div>
									<button type="submit">保存</button>
									<button type="submit" onclick="history.go(-1)">返回</button>
								</fieldset>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	${message }

</body>
</html>
