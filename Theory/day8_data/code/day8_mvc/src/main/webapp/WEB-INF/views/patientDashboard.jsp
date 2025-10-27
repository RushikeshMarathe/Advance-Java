<%@page import="jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Dashboard</title>
</head>
<body>
	<h5>Hello , ${sessionScope.patient_details.name}</h5>
	<h5>Upcoming appointments</h5>
	<h4 style="color:red">${mesg}</h4>
	
	
	<table border="3px">

		<tr>
			<th>Appointment_ID</th>
			<th>DateTime</th>
			<th>Doctor Name</th>
			<th>Cancel</th>
		</tr>

		<c:forEach var="appointment" items="${appointment_list}">
			<tr>
				<td>${appointment.appointmentId}</td>
				<td>${appointment.appointmentTS}</td>
				<td>${appointment.docName}</td>
				
				<td><a href="appointments?action=cancel&id=${appointment.appointmentId}">Cancel</a></td>

			</tr>

		</c:forEach>
		
	
	</table>
	<h5><a href="appointments?action=show_form">Book New Appointment</a></h5>

		<h5><a href="logout">Log-Out</a></h5>
</body>
</html>