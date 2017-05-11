package org.cat.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cat.entities.Diary;
import org.cat.entities.User;
import org.cat.service.DiaryService;
import org.cat.service.impl.DiaryServiceImpl;

@WebServlet("/mydiary.do")
public class MyDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DiaryService ds = new DiaryServiceImpl();   
    public MyDiaryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("[UNCAUGHTABLE ERROR BY RK]");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//首先查找所有我的日记
		HttpSession session = request.getSession();
		int userId = ((User)(session.getAttribute("userInfo")))
				.getUserId();
		List<Diary> list= ds.getAllDiary(userId);
		if(session.getAttribute("myDiaryList") != null){
			session.removeAttribute("myDiaryList");
		}
		session.setAttribute("myDiaryList", list);
		request.getRequestDispatcher("WEB-INF/jsp/mydiary.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
