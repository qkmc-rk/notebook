package org.cat.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cat.entities.Diary;
import org.cat.entities.UserFriend;
import org.cat.service.DiaryService;
import org.cat.service.UserService;
import org.cat.service.impl.DiaryServiceImpl;
import org.cat.service.impl.UserServiceImpl;

@WebServlet("/frddiary.do")
public class FriendDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DiaryService ds = new DiaryServiceImpl();  
	UserService us = new UserServiceImpl();
    public FriendDiaryServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������Ӧͷ
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//Ҫ�������к��ѵ��ռ�,Ȼ�����һ��list��,ʹ��session���������ռ�ҳ��
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		List<UserFriend> list = (List<UserFriend>) session.getAttribute("userFriend");
		if(list == null){
			//��û�к���
			request.getRequestDispatcher("WEB-INF/jsp/error/nofriend.jsp").forward(request, response);
		}
		//����Ҫ�ҳ����к��ѵĹ������͵��ռ�
		List<Diary> frddiaryList = new ArrayList<>();
		Map<String,ArrayList<Diary>> diaryMap = new HashMap<>();
		for (UserFriend userFriend : list) {
			int userId = userFriend.getFriend_id();
			String userName = us.getUserName(userId);
			List<Diary> frdiarys = ds.getAllDiary(userId);
			//�ҳ����ѵĹ����ռ�,��������frddiaryList��
			for (Diary diary : frdiarys) {
				if(diary.getContenType().equals("����")){
					frddiaryList.add(diary);
				}
			}
			//�Ѷ�Ӧ���ѵ��ռǱ�����map��
			diaryMap.put(userName,(ArrayList<Diary>) frddiaryList );
			frddiaryList = new ArrayList<>();
		}
		//�ҵ����к����ռ�,��ת�������ռ�ҳ��,������չʾ
		session.setAttribute("diaryMap", diaryMap);
		request.getRequestDispatcher("WEB-INF/jsp/frddiary.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
