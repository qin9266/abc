package com.dgut.sc.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgut.sc.domain.Student;
import com.dgut.sc.service.BusinessService;
import com.dgut.sc.service.impl.BusinessServiceImpl;

public class StudentInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BusinessService service = new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/jsp;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Student student = (Student) request.getSession().getAttribute("student");
		System.out.println(student);
		if(student!=null){
			request.getRequestDispatcher("/WEB-INF/student_info.jsp").forward(request,
					response);
		}else{
			request.setAttribute("message",
					"<script type='text/javascript'>alert('请登录再执行操作')</script>");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
