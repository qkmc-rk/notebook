package org.cat.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cat.entities.User;
import org.cat.entities.UserFriend;
import org.cat.service.UserService;
import org.cat.service.impl.UserServiceImpl;

/**
 * Servlet implementation class BuddyServlet
 */
@WebServlet("/buddy.do")
public class BuddyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserService us = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuddyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//System.out.println("��ָ��?[INFO]-->"+((User)session.getAttribute("userInfo")).getUserId());
		//�Ƚ����ж��û���Ϣ�Ƿ����,��Ϊ��¼��û�в�ѯ�����û���������Ϣ
		String userAccount = (String) session.getAttribute("useraccount");
		User user = us.findUserInfo(userAccount);
		session.setAttribute("userInfo", user);
		int userId = ((User)session.getAttribute("userInfo")).getUserId();
		List<UserFriend> list = us.getAllFriend(userId);//�õ��˺��ѵ�����Id,ͨ��id�ҵ����ѵĶ�����Ϣ
		List<Integer> ufIdList = null;
		List<User> users = null;
		if(!(list == null)){
			ufIdList = new ArrayList<>();
			for(UserFriend uf:list){		//��ȡ�������к��ѵ�id
				ufIdList.add(uf.getFriend_id());
				//System.out.println(uf.getFriend_id());
			}
			users = us.findSomeUsers(ufIdList);
		}
		session.setAttribute("friendList", users);
		request.getRequestDispatcher("WEB-INF/jsp/buddy.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
