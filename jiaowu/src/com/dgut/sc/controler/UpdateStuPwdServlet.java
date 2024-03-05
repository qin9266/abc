package com.dgut.sc.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgut.sc.domain.Student;
import com.dgut.sc.service.BusinessService;
import com.dgut.sc.service.impl.BusinessServiceImpl;

public class UpdateStuPwdServlet extends HttpServlet {

	private BusinessService service = new BusinessServiceImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/jsp;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Student student = (Student) request.getSession().getAttribute("student");
		
		if (student == null) {
			request.setAttribute("message",
					"<script type='text/javascript'>alert('请先登录才可修改密码')</script>");
			request.getRequestDispatcher("/index.jsp").forward(
					request, response);
			return;
		} else {
			String oldPwd = request.getParameter("old_password");
			String newPwd = request.getParameter("new_password");
			String newPwdAgain = request.getParameter("new_password_again");
			System.out.println("旧密码"+oldPwd);
			System.out.println("新密码"+newPwd);
			System.out.println("再次输入新密码"+newPwdAgain);
			student = service.queryStudent(student.getSno(), oldPwd);
			if(oldPwd.equals("")||newPwd.equals("")||newPwdAgain.equals("")){
				request.setAttribute("message",
						"<script type='text/javascript'>alert('原密码和新密码不能为空')</script>");
				request.getRequestDispatcher("/update_stu_pwd.jsp").forward(
						request, response);
			}
			if (student == null) {
				request.setAttribute("message",
						"<script type='text/javascript'>alert('原密码错误')</script>");
				request.getRequestDispatcher("/update_stu_pwd.jsp").forward(
						request, response);
			} else {
				if (!newPwd.equals(newPwdAgain)) {
					request.setAttribute("message",
							"<script type='text/javascript'>alert('两次输入的密码不一致')</script>");
					request.getRequestDispatcher("/update_stu_pwd.jsp")
							.forward(request, response);
				} else {
					boolean flag = service.updateStudentPwd(student.getSno(), newPwd);
					if (flag) {
						request.setAttribute("message",
								"<script type='text/javascript'>alert('修改密码成功，请重新登录！')</script>");
						request.getSession().invalidate();
						request.getRequestDispatcher("/index.jsp").forward(
								request, response);
					}

				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
