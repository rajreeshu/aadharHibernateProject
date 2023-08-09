<%@page import="aadharBin.AadharDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	session = request.getSession();
	AadharDetail user = (AadharDetail)session.getAttribute("userDetail");
	out.println("Aadhar No: "+user.getAadharNo()+"<br>");
	out.println("Name: "+user.getName()+"<br>");
	out.println("Father's Name: "+user.getName()+"<br>");
	out.println("Age: "+user.getAge()+"<br>");
	out.println("Address: "+user.getAddress()+"<br>");
	out.println("Phone no: "+user.getPhoneNo()+"<br>");
	out.println("Email Id: "+user.getEmail()+"<br>");
	
	
	
%>
</body>
</html>