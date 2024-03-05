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
					<li><a href="LoginServlet">学生信息管理</a></li>
					<li><a href="AdminToTeaServlet">教师信息</a></li>
					<li class="active"><a href="AdminToCourseServlet">课程信息管理</a></li>
				</ul>
			</div>


			<!-- content -->
			<div>
				<div>
					<div>
						<h3>增加课程信息</h3>
					</div>
				</div>

				<div>
					<div>
						<div>
							<form action="AddCourseServlet?tokenStr=${sessionScope.CONTROL_REFRESH}&pageNum=${pageNum}" method="post">
								<fieldset>
									<legend></legend>
									<div>
										<label>课程号</label>
										<input type="text" name="cno" value="">
									</div>
									<div>
										<label>课程名</label>
										<input type="text" name="cname" value="">
									</div>
									<div>
										<label>教工号</label>
										<input type="text" name="tno" value="">
									</div>
									<div>
										<label>教师名</label>
										<input type="text" name="tname" value="">
									</div>
									<div>
										<label>学分</label>
										<input type="text" name="credit" value="">
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
