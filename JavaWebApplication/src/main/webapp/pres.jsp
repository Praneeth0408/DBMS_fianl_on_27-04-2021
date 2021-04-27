<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
pageEncoding="ISO-8859-1"%>
<%@ page import="net.codejava.PresDAO" %>
<%@ page import="net.codejava.Pres" %>
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
    <div class="main">
        <ul>
	    <li><a href="http://localhost:8085/JavaWebApplication/loginpage.jsp">Go Back</a></li>
	    
        </ul>
    </div>
    <h1 style="text-align:center;color:white;padding:50px;">Here is your Prescription</h1> 
    <table>
<tr>

    <th>Medicine</th>
    <th>Count</th>
 </tr>
<% 
	int x = (int) session.getAttribute("pid");
	System.out.println(x + "\n");
	PresDAO cd = new PresDAO();
	List<Pres> listCategory = cd.press();
	for(int i=0;i<listCategory.size();i++)
	{
		
		if(x == listCategory.get(i).getPat_id())
		{
%>
		   	<tr>
		
			    <td><%=listCategory.get(i).getMname() %></td>
			    <td><%=listCategory.get(i).getCount() %></td>
		  	</tr>  
<%}
} %>
</table>
</body>
</html>