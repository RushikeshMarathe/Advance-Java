<%@page import="java.time.LocalDate"%>
<%@page import="com.cdac.pojo.User"%>
<%@page import="java.time.Period"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log-Out</title>
</head>
<body>
<h5>Hello, ${user_dtls.name}
 </h5>
 
 <%
 
 User user = (User) session.getAttribute("user_dtls");
 int ageInYears = Period.between(user.getDob(), LocalDate.now()).getYears();
 
 %>
 
 <h5>
 Age - <%=ageInYears %></h5>
 
 
 <%
 session.invalidate();
 %>
 
 <h5>You have logged Out here...</h5>
 
 <h5>
 <a href="login.jsp">Visit again</a>
 </h5>



</body>
</html>