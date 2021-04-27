<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
pageEncoding="ISO-8859-1"%>
<%@ page import="net.codejava.CategoryDAO" %>
<%@ page import="net.codejava.Category" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href=style1.css>
</head>
<body>  
<h1>Hello You have logged in Succesfully</h1>   
<br>
<h2 style="color:white;text-align:center;'">Book your appointment</h2>
<br>
<form method="post" action="http://localhost:8085/JavaWebApplication/BookAppointment">
<pre>
<select name="category">
<% 
	CategoryDAO cd = new CategoryDAO();
	List<Category> listCategory = cd.categories();
	for(int i=0;i<listCategory.size();i++)
	{
%>
    <option value= <%=listCategory.get(i).getId()%>>
    	<%= listCategory.get(i).getName()%>
    </option>  
<%	} %>

</select>
<label for="appointment">Appointment date:</label>
<input type="date" name="appointment">
<label> Choose the Slot:</label>
<select name="slot">
	<option value="Morning">Morning slot</option>
	<option value="Afternoon">Afternoon slot</option>
	<option value="Evening">Evening slot</option>
</select>
<br>
<input type="submit" value="Book">
</pre>
</form>

</body>
</html>