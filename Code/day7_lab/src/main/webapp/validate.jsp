<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.cdac.pojo.User"%>
<%@page import="java.util.HashMap"%>
<%@page
	import="jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validate JSP</title>
</head>

<%!//JSP declaration block

	HashMap<String, User> users;

	public void jspInit() {
		users = new HashMap<>();

		//populate the map
		users.put("rushi@gmail.com",
				new User("Rushikesh", "pass123", LocalDate.parse("2001-11-23"), "rushi@gmail.com"));
		users.put("satyam@gmail.com", new User("Satyam", "pass234", LocalDate.parse("2001-01-13"), "satyam@gmail.com"));
		users.put("dip@gmail.com", new User("Dipen", "pass123", LocalDate.parse("2001-10-15"), "dip@gmail.com"));

		System.out.println("map populated : jsInit");
	}%>




<body>

	<%
	System.out.println("validate login : scriptlet - jspService");

	User user = users.get(request.getParameter("em"));

	if (user != null) {
		//=> email valid -> check password
		if (user.getPassword().equals(request.getParameter("pass"))) {
			//=> valid password ->store user details (pojo) under session scope
			session.setAttribute("user_dtls", user);
			//redirect the client
			response.sendRedirect("details.jsp");
			
			
			//Server Pool
			//RequestDispatcher rd = request.getRequestDispatcher("details.jsp");
			//request.setAttribute("user_dtls", user);
			//rd.forward(request, response);
		} else {
			//invalid password
	%>


	<h5>
		Invalid Password, Please <a href="login.jsp">Retry</a>
	</h5>
	<%
	}
	} else {
	//invalid email
	%>

	<h5>
		Invalid Email , Please <a href="login.jsp">Retry</a>

	</h5>


	<%
	}
	%>




</body>
</html>