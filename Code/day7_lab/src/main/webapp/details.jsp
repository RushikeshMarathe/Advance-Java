<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validated User Details</title>
</head>
<body>

	<h4>Login Successfull!..</h4>

	<h5>Hello, ${sessionScope.user_dtls}.</h5>
	
	<!--<h5>Hello, ${requestScope.user_dtls}</h5>  -->


	<h5>
		<a href="logout.jsp">Log-Out</a>
	</h5>

</body>
</html>