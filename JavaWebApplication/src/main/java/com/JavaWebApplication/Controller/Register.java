package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaWebApplication.Beans.RegisterBean;
import com.JavaWebApplication.Model.UserDb;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//String phone = request.getParameter("phone");
		
		RegisterBean rb = new RegisterBean(name,email,password);
		rb.setEmail(email);
		rb.setName(name);
		rb.setPassword(password);
		//rb.setPhone(phone);
		
		UserDb ud = new UserDb();
		
		String s1 = ud.insertUSer(rb);
		System.out.println(s1);
		
		if(s1=="Data Inserted")
		{
			HttpSession session = request.getSession();
			response.sendRedirect("http://localhost:8085/JavaWebApplication/jsp/login.jsp");
		}
		else
		{
			response.sendRedirect("http://localhost:8085/JavaWebApplication/Notregister.jsp");
		}
	}

}
