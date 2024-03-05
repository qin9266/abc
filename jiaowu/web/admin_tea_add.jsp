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
					<li><a href="LoginServlet"><i class="glyphicon glyphicon-chevron-right"></i> 学生信息管理</a></li>
					<li><a href="AdminToTeaServlet"><i class="glyphicon glyphicon-chevron-right"></i> 教师信息管理</a></li>
					<li><a href="AdminToCourseServlet"><i class="glyphicon glyphicon-chevron-right"></i> 课程信息管理</a></li>
				</ul>
			</div>
			<div>
				<div>
					<div>
						<h3>增加教师信息</h3>
					</div>
					<div>
						<div>
							<div>
								<div>&nbsp;</div>
							</div>
							<div>
								<form action="AddTeaServlet?tokenStr=${sessionScope.CONTROL_REFRESH}&pageNum=${pageNum}" method="post">
									<fieldset>
										<legend></legend>
										<div>
											<label>教工号</label>
											<div>
												<input type="text" name="tno" value="">
											</div>
										</div>
										<div>
											<label>姓名</label>
											<div>
												<input type="text" name="tname" value="">
											</div>
										</div>
										<div>
											<label>密码</label>
											<div>
												<input type="text" name="password" value="">
											</div>
										</div>
										<div>
											<label>性别</label>
											<div>
												<input type="text" name="sex" value="">
											</div>
										</div>
										<div>
											<label>院系</label>
											<div>
												<input type="text" name="department" value="">
											</div>
										</div>
										<div>
											<label>degree</label>
											<div>
												<input type="text" name="degree" value="">
											</div>
										</div>
										<div>
											<label>职称</label>
											<div>
												<input type="text" name="title" value="">
											</div>
										</div>
										<button type="submit" class="btn btn-primary">保存</button>
										<button type="submit" class="btn btn-default" onclick="history.go(-1)">返回</button>
									</fieldset>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	${message }
</body>
</html>
