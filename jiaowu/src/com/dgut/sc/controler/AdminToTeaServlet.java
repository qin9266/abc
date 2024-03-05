package com.dgut.sc.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dgut.sc.domain.Admin;
import com.dgut.sc.service.BusinessService;
import com.dgut.sc.service.impl.BusinessServiceImpl;
import com.sc.util.Page;

public class AdminToTeaServlet extends HttpServlet {

	private BusinessService service = new BusinessServiceImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/jsp;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if(admin!=null){
			// 设置页码
			String pageNum = request.getParameter("pageNum");
			Page page =service.findTeachersRecords(pageNum);
			page.setUrl("/AdminToTeaServlet");
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/admin_teacher.jsp").forward(request,
					response);
		}else{
			request.setAttribute("message",
					"<script type='text/javascript'>alert('请先登录方可操作')</script>");
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
