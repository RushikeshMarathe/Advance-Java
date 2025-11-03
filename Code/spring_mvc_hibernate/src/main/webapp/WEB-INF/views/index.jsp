<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 
${requestScope.today_date} </h1>

<%--http://host:port/ctx_path/department/list --%>
<h5>
<a href="department/list">List All Departments</a>
</h5>
</body>
</html>