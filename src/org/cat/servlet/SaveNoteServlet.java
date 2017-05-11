package org.cat.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cat.entities.Diary;
import org.cat.entities.User;
import org.cat.service.DiaryService;
import org.cat.service.UserService;
import org.cat.service.impl.DiaryServiceImpl;
import org.cat.service.impl.UserServiceImpl;

@WebServlet("/savenote.do")
public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService us = new UserServiceImpl();   
	DiaryService ds = new DiaryServiceImpl();
    public SaveNoteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/error/error.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//处理保存日记的动作
		//1.保存日记需要的值:用户id,年月日,星期几,天气情况,内容,内容类型
		HttpSession session = request.getSession();
		//先进行判断用户信息是否存在,因为登录后并没有查询单个用户的所有信息
		User user = null;
		int userId;
		//System.out.println("[开始判断session中是否有userInfo]");
		if(session.getAttribute("userInfo") == null){
			//System.out.println("[没有userInfo]");
			String userAccount = (String) session.getAttribute("useraccount");
			user = us.findUserInfo(userAccount);
			session.setAttribute("userInfo", user);
			//System.out.println("[userInfo存了起来]");
			userId = user.getUserId();		//用户的id
		}else{			//如果session存在就不用再次保存用户数据了
			user = (User)session.getAttribute("userInfo");
			userId = user.getUserId();
		}
		String udate = request.getParameter("date");
		String week = request.getParameter("week");
		String weather = request.getParameter("weather");
		String content = request.getParameter("content");
		String contentType = request.getParameter("type");
		if(udate.equals("") || week.equals("") || weather.equals("") ||
				content.equals("") || contentType.equals("") ||
					(!contentType.equals("公开") && !contentType.equals("私密"))
		  ){
			request.getRequestDispatcher("WEB-INF/jsp/error/error.jsp")
				.forward(request, response);
			}else{
				//数据不为空,取得年月日,星期
				int year = Integer.parseInt(udate.split("-")[0]);
				int month = Integer.parseInt(udate.split("-")[1]);
				int day = Integer.parseInt(udate.split("-")[2]);
				int weekInt = Integer.parseInt(week);
				//创建diary对象
				Diary diary = new Diary(userId, year, month, day, weekInt, 
						weather, content,contentType);
				if(ds.saveDiary(diary)){
					//成功保存日记
					request.getRequestDispatcher("WEB-INF/jsp/view.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("WEB-INF/jsp/error/saveDiaryError.jsp").forward(request, response);
				}
			}
		
	}
		
}
