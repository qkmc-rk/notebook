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
 * Servlet implementation class CenterServlet
 * ����������ڴ������ݲ����ָ�������
 */
@WebServlet("/center.do")
public class CenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//ʵ���û��ķ�����
	UserService us = new UserServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//session�������û����˺�,ͨ���˺��ҵ�
		if(session != null && session.getAttribute("useraccount") != null){
			String userAccount = (String) session.getAttribute("useraccount");
			User user = us.findUserInfo(userAccount);
			session.setAttribute("userInfo", user);
			request.getRequestDispatcher("WEB-INF/jsp/center.jsp").forward(request, response);
		}else{
			response.sendRedirect("WEB-INF/jsp/error/error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
