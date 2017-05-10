package org.cat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cat.entities.User;
import org.cat.service.UserService;
import org.cat.service.impl.UserServiceImpl;

@WebServlet({ "/RegistServlet", "/regist.do" })
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//ʵ���û��ķ�����
	UserService us = new UserServiceImpl();

	public RegistServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/error/error.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������Ӧ����
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//��ȡ��¼����
		String userAccount = request.getParameter("useraccount");
		String userPassword = request.getParameter("userpassword");
		String userPassword2 = request.getParameter("userpassword2");
		String sex = request.getParameter("sex");
		String ageStr = request.getParameter("age");
		//�п�
		if(ageStr == "" || userPassword.equals(""))request.getRequestDispatcher("WEB-INF/jsp/error/error.jsp").forward(request, response);
		else{  
			int age = Integer.parseInt(request.getParameter("age"));
			String userName = request.getParameter("username");
			//System.out.println("[NAME]--->"+userName);
			//System.out.println("[SE X]--->"+sex);
			//�ж���Ϣ�Ϸ���
			if(!(userPassword.equals(userPassword2)) || userAccount.equals("") || 
					userName.equals("") || sex.equals("")){
				request.getRequestDispatcher("WEB-INF/jsp/error/error.jsp").forward(request, response);
			}
			User user = new User();
			user.setAge(age);
			user.setSex(sex);
			user.setUserAccount(userAccount);
			user.setUserName(userName);
			user.setUserPassword(userPassword);
			if(us.regist(user)){
				PrintWriter ps = response.getWriter();
				ps.write("<html><head><title>ע��ɹ�!</title></head><body>");
				ps.write("<h1>��ϲ���Ѿ��ɹ�ע��,��������Ե�¼��</h1>");
				ps.write("<h1><a href=\"login.jsp\">ȥ��¼</a></h1>");
				ps.write("</body></html>");
			}
		}
	}
}
