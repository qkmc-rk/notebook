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
		//System.out.println("空指针?[INFO]-->"+((User)session.getAttribute("userInfo")).getUserId());
		//先进行判断用户信息是否存在,因为登录后并没有查询单个用户的所有信息
		String userAccount = (String) session.getAttribute("useraccount");
		User user = us.findUserInfo(userAccount);
		session.setAttribute("userInfo", user);
		int userId = ((User)session.getAttribute("userInfo")).getUserId();
		List<UserFriend> list = us.getAllFriend(userId);//拿到了好友的所有Id,通过id找到好友的对象信息
		List<Integer> ufIdList = null;
		List<User> users = null;
		if(!(list == null)){
			ufIdList = new ArrayList<>();
			for(UserFriend uf:list){		//获取到了所有好友的id
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
