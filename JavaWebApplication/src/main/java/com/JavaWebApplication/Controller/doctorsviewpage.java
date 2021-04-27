package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaWebApplication.Beans.LoginBean;
import com.JavaWebApplication.Model.UserDb;
import java.time.LocalDate; 
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;
/**
 * Servlet implementation class doctorsviewpage
 */
public class doctorsviewpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doctorsviewpage() {
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
		String password = request.getParameter("password");
		
		LoginBean lb = new LoginBean(name,password);
		
		lb.setName(name);
		lb.setPassword(password);
		
		
		UserDb ud = new UserDb();
		
		int x=ud.getdocid(name);
		
		String s1 = ud.searchDoctor(lb);
		System.out.println(s1);
		if(s1=="You have succesfully Logged in")
		{
			System.out.print(" Hey Welcome");
			HttpSession session = request.getSession();
			session.setAttribute("DOCName",name);
			session.setAttribute("doctor_id_in",x);
			Date d = Calendar.getInstance().getTime();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
            String strDate = dateFormat.format(d);  
			session.setAttribute("d_date",strDate);
			System.out.println(strDate);
			response.sendRedirect("http://localhost:8085/JavaWebApplication/doctorwelcome.jsp");
		}
		else
		{
			response.sendRedirect("http://localhost:8085/JavaWebApplication/jsp/doctorsview.jsp");
		}
	}

}
