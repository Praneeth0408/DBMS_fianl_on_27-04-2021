<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%session.invalidate();
response.sendRedirect("http://localhost:8085/JavaWebApplication/index.jsp");
%>
</body>
</html>