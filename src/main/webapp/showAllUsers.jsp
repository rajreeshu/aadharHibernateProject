<%@page import="aadharBin.AadharDetail"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>All users:- <br></h1>
<table>
<tr>
<th>Name</th>
<th>Aadhar No:</th>
</tr>
<%
	session = request.getSession();
	List userList = (List)session.getAttribute("allUser");
	
	Iterator itr = userList.iterator();
    
	while(itr.hasNext()) {
		AadharDetail s = (AadharDetail) itr.next();
		out.println("<tr>");
		out.println("<td>"+s.getName()+" </td><td> "+s.getAadharNo()+"<td></tr>");
	}
%>
</table>

</body>
</html>