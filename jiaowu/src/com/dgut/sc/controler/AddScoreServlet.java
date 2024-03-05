package com.dgut.sc.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dgut.sc.domain.Score;
import com.dgut.sc.domain.Student;
import com.dgut.sc.domain.Teacher;
import com.dgut.sc.service.BusinessService;
import com.dgut.sc.service.impl.BusinessServiceImpl;
import com.sc.util.Page;

public class AddScoreServlet extends HttpServlet {

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
			String sno = request.getParameter("sno");
			String sname = request.getParameter("sname");
			String cno = request.getParameter("cno");
			String cname = request.getParameter("cname");
			String credit = request.getParameter("credit");
			String type = request.getParameter("type");
			String exam_method = request.getParameter("exam_method");
			String property = request.getParameter("property");
			String grade = request.getParameter("grade");
			String get_credit = request.getParameter("get_credit");
			String GPA = request.getParameter("GPA");
			String credit_GPA = request.getParameter("credit_GPA");
			String note = request.getParameter("note");
			String tno = request.getParameter("tno");

			boolean flag = false;
			if (sname != null && sno != null && cno != null && cname != null
					&& credit != null && type != null && exam_method != null
					&& property != null && grade != null && get_credit != null
					&& GPA != null && credit_GPA != null && note != null
					&& tno != null) {
				Score score = new Score(sno, sname, cno, cname, credit, type, exam_method, property, grade, get_credit, GPA, credit_GPA, note, tno);
				flag = service.addScore(score);
				if (flag) {
					request.setAttribute("message",
							"<script type='text/javascript'>alert('增加成功')</script>");

				} else {
					request.setAttribute("message",
							"<script type='text/javascript'>alert('增加失败')</script>");
				}
				String pageNum = request.getParameter("pageNum");
				Page page = service.findScoresRecordsByTno(tno, pageNum);
				page.setUrl("/LoginServlet");
				request.setAttribute("page", page);
				request.getRequestDispatcher("/WEB-INF/teacher_main.jsp")
						.forward(request, response);
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
