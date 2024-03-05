package com.dgut.sc.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dgut.sc.domain.Teacher;
import com.dgut.sc.domain.Teacher;
import com.dgut.sc.service.BusinessService;
import com.dgut.sc.service.impl.BusinessServiceImpl;
import com.sc.util.Page;

public class DeleteScoreServlet extends HttpServlet {

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
			// 此段代码用于防止刷新后的重复提交
			// 时间戳
			String timeStamp = String.valueOf(new java.util.Date().getTime());
			HttpSession session = request.getSession();
			// 创建新令牌值
			String tokenStr = session.getId() + timeStamp;
			// 识别令牌,不合法将中止页面运行
			String sesValue = (String) session.getAttribute("CONTROL_REFRESH");
			System.out.println(sesValue);
			String reqValue = request.getParameter("tokenStr");
			System.out.println(reqValue);
			if (!sesValue.equals(reqValue)) {
				// 设置页码
				String pageNum = request.getParameter("pageNum");
				Page page = service.findScoresRecordsByTno(teacher.getTno(), pageNum);
				request.setAttribute("page", page);
				request.getRequestDispatcher("/WEB-INF/teacher_main.jsp")
						.forward(request, response);
				return;
			}
			// 更新令牌
			String cno = request.getParameter("cno");
			String sno = request.getParameter("sno");
			session.setAttribute("CONTROL_REFRESH", tokenStr);
			boolean flag = service.deleteScore(sno, cno);
			if (flag) {
				request.setAttribute("message",
						"<script type='text/javascript'>alert('删除成功')</script>");
			} else {
				request.setAttribute("message",
						"<script type='text/javascript'>alert('删除失败')</script>");
			}
			// 设置页码
			String pageNum = request.getParameter("pageNum");
			Page page = service.findScoresRecordsByTno(teacher.getTno(), pageNum);
			request.setAttribute("page", page);
			page.setUrl("/LoginServlet");
			request.getRequestDispatcher("/WEB-INF/teacher_main.jsp").forward(
					request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
