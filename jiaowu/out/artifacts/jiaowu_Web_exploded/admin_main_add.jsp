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

	<div>
		<div>
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
						<div >
							<h3>增加学生信息</h3>
						</div>
					</div>

				<div>
					<div>
						<div>
							<div>
								<div>&nbsp;</div>
							</div>
							<div>
								<form action="AddStuServlet?tokenStr=${sessionScope.CONTROL_REFRESH}&pageNum=${pageNum}" onsubmit="return check();" method="post">
									<fieldset>
										<legend></legend>
										<div>
											<label>学号</label>
											<div>
												<input type="text" name="sno" id="sno" value="">
											</div>
										</div>
										<div>
											<label>姓名</label>
											<div>
												<input type="text" name="sname" id="sname" value="">
											</div>
										</div>
										<div>
											<label>密码</label>
											<div>
												<input type="text" name="password" id="password" value="">
											</div>
										</div>
										<div>
											<label>性别</label>
											<div>
												<input type="text" name="sex" id="sex" value="">
											</div>
										</div>
										<div>
											<label>专业</label>
											<div>
												<input type="text" name="major" id="major" value="">
											</div>
										</div>
										<div>
											<label>院系</label>
											<div>
												<input type="text" name="department" id="department" value="">
											</div>
										</div>
										<div>
											<label>班级</label>
											<div>
												<input type="text" name="sclass" id="sclass" value="">
											</div>
										</div>
										<button type="submit">保存</button>
										<a href="LoginServlet">返回</a>
									</fieldset>
								</form>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
<script>
 
		 function check()
		 {   
			 var sno = document.getElementById("sno").value;
			 var sname = document.getElementById("sname").value;
			 var password = document.getElementById("password").value;
			 var sex = document.getElementById("sex").value;
			 var major = document.getElementById("major").value;
			 var department = document.getElementById("department").value;
			 var sclass = document.getElementById("sclass").value;
			 if(sno == ""){
				 alert("请输入学号！");
				 return false;
			 }
			 if(sname == ""){
				 alert("请输入姓名！");
				 return false;
			 } 
			 if(password == ""){
				 alert("请输入密码！");
				 return false;
			 } 
			 
			 if(sex == ""){
				 alert("请输入密码！");
				 return false;
			 } 
			 if(major == ""){
				 alert("请输入专业！");
				 return false;
			 } 
			 if(department == ""){
				 alert("请输入院系！");
				 return false;
			 } 
			 if(sclass == ""){
				 alert("请输入班级！");
				 return false;
			 } 
			 
			 return true;
		 }
		</script>
	${message }

</body>
</html>
