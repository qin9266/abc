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
					<a href="teacher_main_add.jsp">增加一个成绩信息</a>
					<form name="myform" method="post" style="overflow-x: auto;">
						<br />

						<table width="100%">
							<tr>
								<td>序号</td>
								<td>学号</td>
								<td>姓名</td>
								<td>课程</td>
								<td>学分</td>
								<td>类别</td>
								<td>考试方式</td>
								<td>修读性质</td>
								<td>成绩</td>
								<td>取得学分</td>
								<td>绩点</td>
								<td>学分绩点</td>
								<td>备注</td>
								<td>操作</td>
							</tr>
							<c:forEach items="${page.recordList}" var="pm" varStatus="i">
								<tr>
									<td>${i.index+1}</td>
									<td>${pm.sno}</td>
									<td>${pm.sname}</td>
									<td>${pm.cname}</td>
									<td>${pm.credit}</td>
									<td>${pm.type}</td>
									<td>${pm.exam_method}</td>
									<td>${pm.property}</td>
									<td>${pm.grade}</td>
									<td>${pm.get_credit}</td>
									<td>${pm.GPA}</td>
									<td>${pm.credit_GPA}</td>
									<td>${pm.note}</td>
									<td>
										<a href="GetScoreToUpdateServlet?sno=${pm.sno}&cno=${pm.cno}&tokenStr=${sessionScope.CONTROL_REFRESH}&pageNum=${page.currentPageNum}">修改</a> &nbsp; &nbsp;
										<a href="DeleteScoreServlet?sno=${pm.sno}&cno=${pm.cno}&tokenStr=${sessionScope.CONTROL_REFRESH}&pageNum=${page.currentPageNum}">刪除</a>
									</td>
								</tr>
							</c:forEach>
						</table>

						<div>
							第&nbsp;${page.currentPageNum}&nbsp;页&nbsp;/&nbsp;共&nbsp;${page.totalPage}&nbsp;页&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath}${page.url}?pageNum=${page.currentPageNum-1>0?page.currentPageNum-1:1}">上一页</a>&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath}${page.url}?pageNum=${page.currentPageNum+1>page.totalPage?page.totalPage:page.currentPageNum+1}">下一页</a>
						</div>

					</form>
				</div>
			</div>

		</div>
	</div>
	</div>
	${message }

</body>
</html>
