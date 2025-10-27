<%@page import="jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput"%>
<%@page import="com.healthcare.pojos.Doctor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h5>Hello, ${doctor_details.docName}</h5>
	<h5>{doctor_details.speciality}</h5>


	<table border=2px>

		<tr>

			<th>Patient Name</th>
			<th>Patient PhoneNo</th>
			<th>DateTime</th>
			<th>Status</th>
		</tr>
		

	<c:forEach var="appointment" items="${requestScope.allAppointments}">
	<tr>
	
	<td>${appointment.patientName}  </td>
	<td>${appointment.phoneNo}</td>
	<td>${appointment.dTime}</td>
	<td>${appointment.status}</td>
	<td><a href="doctor_dashboard?action=done&appId=${appointment.id}" >Mark-Done</a> </td>
	<td><a href="doctor_dashboard?action=cancel&appId=${appointment.id}">Cancel</a></td>
	
	
	</tr>
	
	
	</c:forEach>
	
	
	
	
	
	</table>
	
	<h3><a href="logout">Logout</a></h3>

</body>
</html>