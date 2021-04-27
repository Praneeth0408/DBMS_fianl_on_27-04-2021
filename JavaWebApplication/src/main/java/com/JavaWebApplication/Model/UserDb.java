package com.JavaWebApplication.Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.JavaWebApplication.Beans.DoctorBean;
import com.JavaWebApplication.Beans.LoginBean;
import com.JavaWebApplication.Beans.PatientBean;
import com.JavaWebApplication.Beans.RegisterBean;
public class UserDb 
{
	String s1=null;
	public String insertUSer(RegisterBean rb) 
	{
		MyDb db = new MyDb();
		Connection con = db.getCon();
		try 
		{ 
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into register(name,email,password) values('"+rb.getName()+"','"+rb.getEmail()+"','"+rb.getPassword()+"')");
			s1="Data Inserted"; 
		}
		catch(SQLException e) 
		{
			e.printStackTrace(); 
		}
		return s1; 
	}
	public String searchUser(LoginBean lb) 
	{ 
		String s1 = "Hi";
		MyDb db = new MyDb();
		Connection con = db.getCon();
		try 
		{ 
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from register where name='"+lb.getName()+"' and password='"+lb.getPassword()+"'");
			if(rs.next())
			{
				s1="You have succesfully Logged in"; 
			}
			else
			{
				s1="Sorry";
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace(); 
		}
		return s1; 
	}
	public String searchDoctor(LoginBean lb) 
	{ 
		String s1 = "Hi";
		MyDb db = new MyDb();
		Connection con = db.getCon();
		try 
		{ 
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from doctor where name='"+lb.getName()+"' and ssn='"+lb.getPassword()+"'");
			if(rs.next())
			{
				s1="You have succesfully Logged in"; 
			}
			else
			{
				s1="Sorry";
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace(); 
		}
		return s1; 
	}
	public String Bookapt(String x1,String x2,String x3,String x4) throws NullPointerException
	{
		String s="Not Booked ";
		MyDb d = new MyDb();
		Connection con = d.getCon();
		try 
		{ 
			int i=Integer.parseInt(x1);
			PreparedStatement stmt=con.prepareStatement("select count(*) from javawebapplication.Appointment where Doc_id=? and Datee=? and slot=?");
			stmt.setInt(1, i);
			stmt.setString(2, x3);
			stmt.setString(3, x4);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int c = rs.getInt(1);
			if(c==0)
			{
				
				PreparedStatement ps=con.prepareStatement("insert into javawebapplication.Appointment(Doc_id,Aname,Datee,Slot) values(?,?,?,?)");
				  
				ps.setInt(1, i);
				ps.setString(2, x2);
				ps.setString(3, x3);
				ps.setString(4, x4);
				int status = ps.executeUpdate();
				System.out.println(status);
				s="Booked Succesfully";
				//return s;
			}
			else
			{
				s="Selected date and slot are not free";
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace(); 
		}
		return s; 		
	}
	
	public int getdocid(String name)
	{
		int x=0;
		MyDb db = new MyDb();
		Connection con = db.getCon();
		try
		{
			PreparedStatement stmt = con.prepareStatement("select doc_id from doctor where Name=?");
			stmt.setString(1,name);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			x=rs.getInt(1);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return x;
	}
	
	public String insertpres(int x,int pat_id,String mname,int quantity)
	{
		String s = "not inserted";
		MyDb db = new MyDb();
		Connection con = db.getCon();
		try
		{
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into prescription(Doc_id,Pat_id,PDate,Mname,count) values('"+x+"','"+pat_id+"','"+java.time.LocalDate.now()+"','"+mname+"','"+quantity+"')");
			s="Data Inserted"; 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return s;
	}
	public int getpat_id(String name)
	{
		int x=0;
		MyDb db = new MyDb();
		Connection con = db.getCon();
		try
		{
			PreparedStatement stmt = con.prepareStatement("select Pat_id from patient where Name=?");
			stmt.setString(1,name);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			x=rs.getInt(1);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return x;
	}
}
