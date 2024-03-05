package com.dgut.sc.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dgut.sc.domain.Admin;
import com.dgut.sc.domain.Student;
import com.dgut.sc.service.BusinessService;
import com.dgut.sc.service.impl.BusinessServiceImpl;
import com.sc.util.Page;

public class AddStuServlet extends HttpServlet {

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
			String sno = request.getParameter("sno");
			String sname = request.getParameter("sname");
			String sex = request.getParameter("sex");
			String password = request.getParameter("password");
			String major = request.getParameter("major");
			String department = request.getParameter("department");
			String sclass = request.getParameter("sclass");
			Student student = new Student(sno, sname, password, sex, major,
					department, sclass);
			boolean flag = false;
			if (sname != null && sno != null && sex != null && password != null
					&& department != null && major != null && sclass != null) {
				flag = service.addStudent(student);
				if (flag) {
					request.setAttribute("message",
							"<script type='text/javascript'>alert('增加成功')</script>");

				} else {
					request.setAttribute("message",
							"<script type='text/javascript'>alert('增加失败')</script>");
				}
				String pageNum = request.getParameter("pageNum");
				Page page = service.findStudentsRecords(pageNum);
				page.setUrl("/LoginServlet");
				request.setAttribute("page", page);
				request.getRequestDispatcher("/WEB-INF/admin_main.jsp")
						.forward(request, response);
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
