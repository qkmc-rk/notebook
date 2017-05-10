package org.cat.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cat.entities.User;
import org.cat.service.UserService;
import org.cat.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/index")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//ʵ���û��ķ�����
	UserService us = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		//��ȡ��¼����
		String useraccount = request.getParameter("useraccount");
		String userpassword = request.getParameter("userpassword");
		//���ݰ󶨵�user���� 
		User user = new User();
		user.setUserAccount(useraccount);
		user.setUserPassword(userpassword);
		//��¼
		if(us.login(user)){
			//��¼�ɹ�
			HttpSession session = request.getSession();
			session.setAttribute("useraccount", useraccount);
			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
			
		}else{
			//��¼ʧ��
			response.sendRedirect("classpath:/login.jsp");
		}
	}

}
