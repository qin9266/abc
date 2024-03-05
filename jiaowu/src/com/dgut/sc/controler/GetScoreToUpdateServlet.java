package com.dgut.sc.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dgut.sc.domain.Score;
import com.dgut.sc.domain.Teacher;
import com.dgut.sc.domain.Course;
import com.dgut.sc.service.BusinessService;
import com.dgut.sc.service.impl.BusinessServiceImpl;

public class GetScoreToUpdateServlet extends HttpServlet {

	private BusinessService service = new BusinessServiceImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/jsp;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Teacher teacher = (Teacher) request.getSession()
				.getAttribute("teacher");
		if (teacher == null) {
			request.setAttribute("message",
					"<script type='text/javascript'>alert('请先登录才可操作')</script>");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		} else {
			// 时间戳
			String timeStamp = String.valueOf(new java.util.Date().getTime());
			HttpSession session = request.getSession();
			// 创建新令牌值
			String tokenStr = session.getId() + timeStamp;
			// 识别令牌,不合法将中止页面运行
			// 更新令牌
			session.setAttribute("CONTROL_REFRESH", tokenStr);
			String pageNum = request.getParameter("pageNum");
			String cno = request.getParameter("cno");
			String sno = request.getParameter("sno");
			System.out.println(sno + "" + cno);
			Score score = service.queryScore(sno, cno);
			request.setAttribute("score", score);
			request.setAttribute("pageNum", pageNum);
			request.getRequestDispatcher("/WEB-INF/teacher_score_update.jsp")
					.forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
