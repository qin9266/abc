package com.dgut.sc.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dgut.sc.domain.Admin;
import com.dgut.sc.domain.Student;
import com.dgut.sc.domain.Teacher;
import com.dgut.sc.service.BusinessService;
import com.dgut.sc.service.impl.BusinessServiceImpl;
import com.sc.util.Page;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/jsp;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		BusinessService service = new BusinessServiceImpl();
		// 获取登录类型
		String type = request.getParameter("cho_Province");
		// 获取session对象
		Student student = (Student) request.getSession()
				.getAttribute("student");
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		Teacher teacher = (Teacher) request.getSession()
				.getAttribute("teacher");

		// 如果session存在则刷新页面
		if (student != null || admin != null || teacher != null) {
			if (student != null) {
				String pageNum = request.getParameter("pageNum");
				Page page = service
						.findScoresRecords(student.getSno(), pageNum);
				page.setUrl("/LoginServlet");
				request.setAttribute("page", page);
				request.getRequestDispatcher("/WEB-INF/student_main.jsp")
						.forward(request, response);
			}
			if (admin != null) {
				String pageNum = request.getParameter("pageNum");
				Page page = service.findStudentsRecords(pageNum);
				page.setUrl("/LoginServlet");
				request.setAttribute("page", page);
				request.getRequestDispatcher("/WEB-INF/admin_main.jsp")
						.forward(request, response);
			}
			if (teacher != null) {
				String pageNum = request.getParameter("pageNum");
				Page page = service.findScoresRecordsByTno(teacher.getTno(), pageNum);
				page.setUrl("/LoginServlet");
				request.setAttribute("page", page);
				request.getRequestDispatcher("/WEB-INF/teacher_main.jsp")
						.forward(request, response);
			}

		} else {

			if ("管理员".equals(type)) {
				String username = request.getParameter("username");
				String password = request.getParameter("password");

				admin = service.queryAdmin(username);
				if (admin == null) {
					request.setAttribute("message",
							"<script type='text/javascript'>alert('账号不存在')</script>");
					request.getRequestDispatcher("/index.jsp").forward(request,
							response);
					return;
				}
				admin = service.queryAdmin(username, password);
				if (admin == null) {
					request.setAttribute("message",
							"<script type='text/javascript'>alert('密码错误')</script>");
					request.getRequestDispatcher("/index.jsp").forward(request,
							response);
					return;
				}
				request.getSession().setAttribute("admin", admin);
				// 此段代码用于防止刷新后的重复提交
				// 时间戳
				String timeStamp = String.valueOf(new java.util.Date().getTime());
				HttpSession session = request.getSession();
				// 创建新令牌值
				String tokenStr = session.getId() + timeStamp;
				// 识别令牌,不合法将中止页面运行
				// 更新令牌
				session.setAttribute("CONTROL_REFRESH", tokenStr);
				// 设置页码
				String pageNum = request.getParameter("pageNum");
				Page page = service.findStudentsRecords(pageNum);
				page.setUrl("/LoginServlet");
				request.setAttribute("page", page);
				request.getRequestDispatcher("/WEB-INF/admin_main.jsp")
						.forward(request, response);
			} else if ("教师".equals(type)) {
				String username = request.getParameter("username");
				String password = request.getParameter("password");

				teacher = service.queryTeacher(username);
				if (teacher == null) {
					request.setAttribute("message",
							"<script type='text/javascript'>alert('账号不存在')</script>");
					request.getRequestDispatcher("/index.jsp").forward(request,
							response);
					return;
				}
				teacher = service.queryTeacher(username,password);
				if (teacher == null) {
					request.setAttribute("message",
							"<script type='text/javascript'>alert('密码错误')</script>");
					request.getRequestDispatcher("/index.jsp").forward(request,
							response);
					return;
				}
				request.getSession().setAttribute("teacher", teacher);
				// 此段代码用于防止刷新后的重复提交
				// 时间戳
				String timeStamp = String.valueOf(new java.util.Date().getTime());
				HttpSession session = request.getSession();
				// 创建新令牌值
				String tokenStr = session.getId() + timeStamp;
				// 识别令牌,不合法将中止页面运行
				// 更新令牌
				session.setAttribute("CONTROL_REFRESH", tokenStr);
				// 设置页码
				String pageNum = request.getParameter("pageNum");
				Page page = service.findScoresRecordsByTno(teacher.getTno(), pageNum);
				page.setUrl("/LoginServlet");
				request.setAttribute("page", page);
				request.getRequestDispatcher("/WEB-INF/teacher_main.jsp")
						.forward(request, response);
			} else if ("学生".equals(type)) {
				String username = request.getParameter("username");
				String password = request.getParameter("password");

				student = service.queryStudent(username);
				if (student == null) {
					request.setAttribute("message",
							"<script type='text/javascript'>alert('账号不存在')</script>");
					request.getRequestDispatcher("/index.jsp").forward(request,
							response);
					return;
				}
				student = service.queryStudent(username, password);
				if (student == null) {
					request.setAttribute("message",
							"<script type='text/javascript'>alert('密码错误')</script>");
					request.getRequestDispatcher("/index.jsp").forward(request,
							response);
					return;
				}
				request.getSession().setAttribute("student", student);
				// 此段代码用于防止刷新后的重复提交
				// 时间戳
				String timeStamp = String.valueOf(new java.util.Date().getTime());
				HttpSession session = request.getSession();
				// 创建新令牌值
				String tokenStr = session.getId() + timeStamp;
				// 识别令牌,不合法将中止页面运行
				// 更新令牌
				session.setAttribute("CONTROL_REFRESH", tokenStr);
				// 设置页码
				String pageNum = request.getParameter("pageNum");
				Page page = service
						.findScoresRecords(student.getSno(), pageNum);
				page.setUrl("/LoginServlet");
				request.setAttribute("page", page);
				request.getRequestDispatcher("/WEB-INF/student_main.jsp")
						.forward(request, response);
			} else if("请选择身份".equals(type)){
				request.setAttribute("message",
						"<script type='text/javascript'>alert('请先选择登录类型')</script>");
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
				return;
			}else{
				request.setAttribute("message",
						"<script type='text/javascript'>alert('信息已过期,请重新登录')</script>");
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
				return;
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
