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

	<!-- main / large navbar -->
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

			<!-- content -->
			<div>
				<div>
					<div>
						<h3>修改课程信息</h3>
					</div>
				</div>

				<div>
					<div>
						<div>
							<form action="UpdateCourseServlet?tokenStr=${sessionScope.CONTROL_REFRESH}&pageNum=${pageNum}" method="post">
								<fieldset>
									<legend>课程号:${course.cno }</legend>
									<input type="hidden" name="cno" value="${course.cno }">
									<div>
										<label>课程名</label>
										<input type="text" name="cname" value="${course.cname }">
									</div>
									<div>
										<label>教工号</label>
										<input type="text" name="tno" value="${course.tno }">
									</div>
									<div>
										<label>教师</label>
										<input type="text" name="tname" value="${course.tname }">
									</div>
									<div>
										<label>学分</label>
										<input type="text" name="credit" value="${course.credit }">
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
