package com.org.mvcdemo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.mvcdemo.factory.DAOFactory;
import com.org.mvcdemo.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String path = "index.jsp" ;
		String userid = request.getParameter("username") ;
		String userpass = request.getParameter("password") ;	
		
		User user = new User() ;
		user.setUserid(userid) ;
		user.setPassword(userpass) ;
		
		try{
			if(DAOFactory.getIUserDAOInstance().findLogin(user)){
				//���û���Ϣ���뵽session��
				request.getSession().setAttribute("info",user.getName());
				request.getRequestDispatcher(path).forward(request,response) ;
			} else {
				request.setAttribute("info", "�û������������!");
				request.getRequestDispatcher("login.jsp").forward(request,response) ;
			}
		}catch(Exception e){
			e.printStackTrace() ;
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
