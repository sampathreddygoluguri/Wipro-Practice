<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Current Date and Time: <%= new java.util.Date() %> </p>
<br>
<%
String empName = request.getParameter("name");
if(empName == null)empName = "Employee";
%>

<h2>Welcome, <%= empName %> ! </h2>

</body>
</html>