package com.dgut.sc.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dgut.sc.domain.Admin;
import com.dgut.sc.domain.Teacher;
import com.dgut.sc.service.BusinessService;
import com.dgut.sc.service.impl.BusinessServiceImpl;
import com.sc.util.Page;

public class AddTeaServlet extends HttpServlet {

	private BusinessService service = new BusinessServiceImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/jsp;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			request.setAttribute("message",
					"<script type='text/javascript'>alert('请先登录才可操作')</script>");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		} else {
			String tno = request.getParameter("tno");
			String tname = request.getParameter("tname");
			String sex = request.getParameter("sex");
			String password = request.getParameter("password");
			String degree = request.getParameter("degree");
			String department = request.getParameter("department");
			String title = request.getParameter("title");
			Teacher teacher = new Teacher(tno, tname, password, sex, department, degree, title);
			boolean flag = false;
			if (tname != null && tno != null && sex != null && password != null
					&& department != null && degree != null && title != null) {
				flag = service.addTeacher(teacher);
				if (flag) {
					request.setAttribute("message",
							"<script type='text/javascript'>alert('增加成功')</script>");
				}else{
					request.setAttribute("message",
							"<script type='text/javascript'>alert('增加失败')</script>");
				}
				String pageNum = request.getParameter("pageNum");
				Page page = service.findTeachersRecords(pageNum);
				page.setUrl("/AdminToTeaServlet");
				request.setAttribute("page", page);
				request.getRequestDispatcher("/WEB-INF/admin_teacher.jsp")
						.forward(request, response);
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
