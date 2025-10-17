package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.healthcare.dao.AppointmentDao;
import com.healthcare.dao.AppointmentDaoImpl;
import com.healthcare.dao.PatientDao;
import com.healthcare.dao.PatientDaoImpl;
import com.healthcare.pojos.Appointment;
import com.healthcare.pojos.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class PatientDashboard
 */
@WebServlet("/patient_dashboard")
public class PatientDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PatientDao pdService;
	private AppointmentDao adServce;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		try {
			pdService = new PatientDaoImpl();
			adServce = new AppointmentDaoImpl();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException("Error in in-it", e);
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		
		Patient loggedInPatient = (Patient)session.getAttribute("patient_details");
		
		try(PrintWriter pw = response.getWriter())
		{
			pw.print("<h1>Hello"+loggedInPatient.getName()+"</h1>");
			
			//pw.print("<h5> Patient details from HttpSession " + loggedInPatient + "</h5>");
			
			List<Appointment> appointments = adServce.getAppointment(loggedInPatient.getId());
			
			pw.print("<table border=3>"
					+ "<tr><th>Appointment Id</th> <th>Appointment Date&Time</th> <th>Doctor Name</th></tr>" );
					
			for (Appointment a : appointments) {
	            pw.print("<tr>");
	            pw.print("<td>" + a.getId() + "</td>");
	            pw.print("<td>" + a.getAppointment_datetime() + "</td>");
	            pw.print("<td>" + a.getDoctorName() + "</td>");
	            pw.print("<td><button>Cancel</button></td>");

	            pw.print("</tr>");
	        }
							
							
				pw.print("</table>");
				
				
				
			pw.print("<button>Book Appointment</button>");
			
			pw.print("<button>Log Out</button>");
					
			
			
					 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			//patient dao instance -clean up
			pdService.cleanUp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Error in destroy "+getClass(),e);

		}

	}

	
}
