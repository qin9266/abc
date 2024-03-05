<%@page import="com.dgut.sc.domain.Teacher"%>
<%@page import="com.dgut.sc.domain.Admin"%>
<%@page import="com.dgut.sc.domain.Student"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="utf-8">
<title>教务处学生成绩管理系统</title>
<style>
	.page-container {
		position: absolute;
		top: 30%;
		left: 50%;
		transform: translate(-50%, -50%);
		border-radius: 10px; /* 添加圆角边框 */
		border: 2px solid #4CAF50; /* 添加实线边框 */
		box-shadow: 0 0 20px rgba(0, 0, 0, 0.4);
		/* 其他样式 */
	}

</style>
</head>

<body>
<%
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		Student student = (Student) request.getSession().getAttribute("student");
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		if (admin != null||student!=null||teacher!=null) {
			request.getRequestDispatcher("LoginServlet").forward(
					request, response);
		}
		
	%>
	<div class="page-container">
		<h1>教务处学生成绩管理系统</h1>
		<form action="LoginServlet" method="post">
			<input type="text" name="username" class="username" placeholder="用户名">
			<input type="password" name="password" class="password" placeholder="密码">
			<div id="content-left" class="demo">
				<div class="infolist">
					<label>登录类型：</label>
					<div class="liststyle">
                <span id="Province"> <i>请选择身份</i>
                    <ul>
                        <!-- 修改下面的li和a标签 -->
                        <li>
                            <a href="#" onclick="setProvince('管理员')">管理员</a>
                        </li>
                        <li>
                            <a href="#" onclick="setProvince('教师')">教师</a>
                        </li>
                        <li>
                            <a href="#" onclick="setProvince('学生')">学生</a>
                        </li>
                    </ul>
					<!-- 将隐藏字段放在ul标签之外 -->
                    <input type="hidden" name="cho_Province" id="cho_Province" value="请选择身份">
                </span>
					</div>
				</div>
				<button type="submit">登录</button>
				<div class="error"><span>+</span></div>
			</div>
		</form>
	</div>

	<!-- Javascript -->
	${message }
	<script>
	function setProvince(province) {
		document.getElementById("cho_Province").value = province;
	}
</script>

</body>

</html>


