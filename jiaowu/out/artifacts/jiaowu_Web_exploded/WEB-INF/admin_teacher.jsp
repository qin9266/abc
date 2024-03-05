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

			<!-- content -->
			<div>
				<div>
					<div>
						<div>详细内容</div>
					</div>
					<div>
						<a href="admin_tea_add.jsp"> 增加一个教师信息</a>
						<form name="myform" method="post" style="overflow-x: auto;">
							<br />
							<table width="100%">
								<tr>
									<td>序号</td>
									<td>教工号</td>
									<td>姓名</td>
									<td>密码</td>
									<td>性别</td>
									<td>院系</td>
									<td>学历</td>
									<td>职称</td>
									<td>操作</td>
								</tr>
								<c:forEach items="${page.recordList}" var="pm" varStatus="i">
									<tr>
										<td>${i.index+1}</td>
										<td>${pm.tno}</td>
										<td>${pm.tname}</td>
										<td>${pm.password}</td>
										<td>${pm.sex}</td>
										<td>${pm.department}</td>
										<td>${pm.degree}</td>
										<td>${pm.title}</td>
										<td>
											<a href="GetTeaToUpdateServlet?tno=${pm.tno}&tokenStr=${sessionScope.CONTROL_REFRESH}&pageNum=${page.currentPageNum}">修改 </a> &nbsp; &nbsp;
											<a href="DeleteTeaServlet?tno=${pm.tno}&tokenStr=${sessionScope.CONTROL_REFRESH}&pageNum=${page.currentPageNum}">刪除</a>
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
	</div>

	${message }
</body>
</html>
