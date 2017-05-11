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
		//设置响应头
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//要查找所有好友的日记,然后放在一个list中,使用session传给好友日记页面
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		List<UserFriend> list = (List<UserFriend>) session.getAttribute("userFriend");
		if(list == null){
			//我没有好友
			request.getRequestDispatcher("WEB-INF/jsp/error/nofriend.jsp").forward(request, response);
		}
		//现在要找出所有好友的公开类型的日记
		List<Diary> frddiaryList = new ArrayList<>();
		Map<String,ArrayList<Diary>> diaryMap = new HashMap<>();
		for (UserFriend userFriend : list) {
			int userId = userFriend.getFriend_id();
			String userName = us.getUserName(userId);
			List<Diary> frdiarys = ds.getAllDiary(userId);
			//找出好友的公开日记,并保存在frddiaryList中
			for (Diary diary : frdiarys) {
				if(diary.getContenType().equals("公开")){
					frddiaryList.add(diary);
				}
			}
			//把对应好友的日记保存在map中
			diaryMap.put(userName,(ArrayList<Diary>) frddiaryList );
			frddiaryList = new ArrayList<>();
		}
		//找到所有好友日记,跳转到好友日记页面,并进行展示
		session.setAttribute("diaryMap", diaryMap);
		request.getRequestDispatcher("WEB-INF/jsp/frddiary.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
