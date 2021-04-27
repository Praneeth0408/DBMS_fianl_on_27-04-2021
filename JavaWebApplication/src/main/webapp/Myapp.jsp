<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
pageEncoding="ISO-8859-1"%>
<%@ page import="net.codejava.AppDAO" %>
<%@ page import="net.codejava.App" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
table {
  font-family: Century Gothic;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
  color:white;
  background-color: rgba(128,129,129);
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href=style.css>
</head>
<body>
<header>

<h1 style="text-align:center;color:white;padding:50px;">Hello</h1> 
<table>
<tr>

    <th>Doc_id</th>
    <th>Date</th>
    <th>Slot</th>
 </tr>
<% 
	String x = (String) session.getAttribute("Name");
	System.out.println(x + "\n");
	AppDAO cd = new AppDAO();
	List<App> listCategory = cd.apps();
	for(int i=0;i<listCategory.size();i++)
	{
		String y = (listCategory.get(i).getPatient_name());
		System.out.println(y);
		if(x.equals(y))
		{
%>
		   	<tr>
		
			    <td><%=listCategory.get(i).getid() %></td>
			    <td><%=listCategory.get(i).getWhich_day() %></td>
			    <td><%=listCategory.get(i).getWhich_slot() %></td>
		  	</tr>  
<%}
} %>
</table>
</header>
</body>
</html>