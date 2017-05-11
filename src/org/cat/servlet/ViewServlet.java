package org.cat.servlet;

import java.io.IOException;
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

@WebServlet("/view.do")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserService us = new UserServiceImpl();
    public ViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//ȷ��session�д����û�����Ϣ
		HttpSession session = request.getSession();
		User user = null;
		String userAccount = (String) session.getAttribute("useraccount");
		user = us.findUserInfo(userAccount);
		session.setAttribute("userInfo", user);
		//���Ҫ�鿴���ѵ��ռ�,�����õ������б�,Ȼ��ͨ�������б�ȥ�ҵ����ѵ��ռ�.
		List<UserFriend> list = us.getAllFriend(user.getUserId());
		session.setAttribute("userFriend", list);
		//��ת��view��ҳ��
		request.getRequestDispatcher("WEB-INF/jsp/view.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
