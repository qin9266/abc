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
					<h3>增加成绩信息</h3>
				</div>

				<div>
					<div>
						<div>
							<div>
								<div>&nbsp;</div>
							</div>
							<div>
								<form action="AddScoreServlet?tokenStr=${sessionScope.CONTROL_REFRESH}&pageNum=${pageNum}" method="post">
									<fieldset>
										<legend></legend>
										<input type="hidden" name="tno" value="${teacher.tno}">
										<div>
											<label>学号</label>
											<div>
												<input type="text" name="sno" value="">
											</div>
										</div>
										<div>
											<label>姓名</label>
											<div>
												<input type="text" name="sname" value="">
											</div>
										</div>
										<div>
											<label>课程号</label>
											<div>
												<input type="text" name="cno" value="">
											</div>
										</div>
										<div>
											<label>课程名</label>
											<div>
												<input type="text" name="cname" value="">
											</div>
										</div>
										<div>
											<label>学分</label>
											<div>
												<input type="text" name="credit" value="">
											</div>
										</div>
										<div>
											<label>类型</label>
											<div>
												<input type="text" name="type" value="">
											</div>
										</div>
										<div>
											<label>考试方式</label>
											<div>
												<input type="text" name="exam_method" value="">
											</div>
										</div>
										<div>
											<label>性质</label>
											<div>
												<input type="text" name="property" value="">
											</div>
										</div>
										<div>
											<label>分数</label>
											<div>
												<input type="text" name="grade" value="">
											</div>
										</div>
										<div>
											<label>获得学分</label>
											<div>
												<input type="text" name="get_credit" value="">
											</div>
										</div>
										<div>
											<label>绩点</label>
											<div>
												<input type="text" name="GPA" value="">
											</div>
										</div>
										<div>
											<label>学分绩点</label>
											<div>
												<input type="text" name="credit_GPA" value="">
											</div>
										</div>
										<div>
											<label>备注</label>
											<div>
												<input type="text" name="note" value="">
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
