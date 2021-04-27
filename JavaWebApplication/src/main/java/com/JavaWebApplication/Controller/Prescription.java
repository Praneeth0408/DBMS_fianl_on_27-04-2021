package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaWebApplication.Model.UserDb;

/**
 * Servlet implementation class Prescription
 */
public class Prescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prescription() {
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
		String mname = request.getParameter("Mname");
		int quantity = Integer.parseInt(request.getParameter("quantity")) ;
		String pat_name = request.getParameter("Pat_name");
		
		//System.out.println(p_id);
		
		HttpSession session = request.getSession();
		int x = (int) session.getAttribute("doctor_id_in");
		
		UserDb u = new UserDb();
		
		int pat_id = u.getpat_id(pat_name);
		System.out.println(pat_id);
		
		String s12 = u.insertpres(x,pat_id,mname,quantity);
		System.out.println(s12);
		if(s12=="Data Inserted")
		{
			response.sendRedirect("http://localhost:8085/JavaWebApplication/doctorwelcome.jsp");
		}
		
	}

}
