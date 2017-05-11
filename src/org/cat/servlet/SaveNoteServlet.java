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
		//�������ռǵĶ���
		//1.�����ռ���Ҫ��ֵ:�û�id,������,���ڼ�,�������,����,��������
		HttpSession session = request.getSession();
		//�Ƚ����ж��û���Ϣ�Ƿ����,��Ϊ��¼��û�в�ѯ�����û���������Ϣ
		User user = null;
		int userId;
		//System.out.println("[��ʼ�ж�session���Ƿ���userInfo]");
		if(session.getAttribute("userInfo") == null){
			//System.out.println("[û��userInfo]");
			String userAccount = (String) session.getAttribute("useraccount");
			user = us.findUserInfo(userAccount);
			session.setAttribute("userInfo", user);
			//System.out.println("[userInfo��������]");
			userId = user.getUserId();		//�û���id
		}else{			//���session���ھͲ����ٴα����û�������
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
					(!contentType.equals("����") && !contentType.equals("˽��"))
		  ){
			request.getRequestDispatcher("WEB-INF/jsp/error/error.jsp")
				.forward(request, response);
			}else{
				//���ݲ�Ϊ��,ȡ��������,����
				int year = Integer.parseInt(udate.split("-")[0]);
				int month = Integer.parseInt(udate.split("-")[1]);
				int day = Integer.parseInt(udate.split("-")[2]);
				int weekInt = Integer.parseInt(week);
				//����diary����
				Diary diary = new Diary(userId, year, month, day, weekInt, 
						weather, content,contentType);
				if(ds.saveDiary(diary)){
					//�ɹ������ռ�
					request.getRequestDispatcher("WEB-INF/jsp/view.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("WEB-INF/jsp/error/saveDiaryError.jsp").forward(request, response);
				}
			}
		
	}
		
}
