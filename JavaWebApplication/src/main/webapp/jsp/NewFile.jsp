<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
pageEncoding="ISO-8859-1"%>
<%@ page import="net.codejava.MedicineDAO" %>
<%@ page import="net.codejava.Medicine" %>
<%@ page import="net.codejava.AppDAO" %>
<%@ page import="net.codejava.App" %>
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

<h1>Hello doc give prescription</h1>

<form method="post" action="http://localhost:8085/JavaWebApplication/Prescription">
<pre>
<select name="Mname">
<% 
	MedicineDAO cd = new MedicineDAO();
	List<Medicine> listCategory = cd.medicines();
	for(int i=0;i<listCategory.size();i++)
	{
%>
    <option value= <%=listCategory.get(i).getMname()%>>
    	<%= listCategory.get(i).getMname()%>
    </option>  
<%	} %>

</select>
<select name="Pat_name">
<% 
	int x = (int) session.getAttribute("doctor_id_in");
	String y = (String) session.getAttribute("d_date");
	AppDAO c = new AppDAO();
	List<App> listCategor = c.apps();
	for(int i=0;i<listCategor.size();i++)
	{
		if(listCategor.get(i).getid()==x )
		{
%>
    <option value= <%=listCategor.get(i).getPatient_name()%>>
    	<%= listCategor.get(i).getPatient_name() +" / "+ listCategor.get(i).getWhich_day() +" / "+ listCategor.get(i).getWhich_slot() %>
    </option>  
<%	}
} %>

</select>

<label for="quantity">Quantity:</label>
<input type="Number" name="quantity">
<br>
<input type="submit" value="Book">
</pre>
</form>

</body>
</html>