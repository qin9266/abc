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

			<!-- content -->
			<div>
				<div>
					<div>
						<h3>修改成绩信息</h3>
					</div>
				</div>

				<div>
					<div>
						<div>&nbsp;</div>
					</div>
					<div>
						<form action="UpdateScoreServlet?tokenStr=${sessionScope.CONTROL_REFRESH}&pageNum=${pageNum}" method="post">
							<fieldset>
								<legend></legend>
								<div>
									<label>学号</label>
									<div>
										<span>${score.sno}</span>
										<input type="hidden" value="${score.sno}" name="sno">
									</div>
								</div>
								<div>
									<label>姓名</label>
									<div>
										<span>${score.sname}</span>
									</div>
								</div>
								<div>
									<label>课程</label>
									<div>
										<span>${score.cname}</span>
										<input type="hidden" name="cno" value="${score.cno}">
									</div>
								</div>
								<div>
									<label>成绩</label>
									<div>
										<input type="text" name="grade" value="${score.grade}">
									</div>
								</div>
								<div>
									<label>取得学分</label>
									<div>
										<input type="text" name="get_credit" value="${score.get_credit}">
									</div>
								</div>
								<div>
									<label>绩点</label>
									<div>
										<input type="text" name="GPA" value="${score.GPA}">
									</div>
								</div>
								<div>
									<label>学分绩点</label>
									<div>
										<input type="text" name="credit_GPA" value="${score.credit_GPA}">
									</div>
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

</body>
</html>
