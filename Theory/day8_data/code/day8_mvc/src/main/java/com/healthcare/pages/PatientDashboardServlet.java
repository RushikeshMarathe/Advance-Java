package com.healthcare.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.healthcare.dao.AppointmentDao;
import com.healthcare.dao.AppointmentDaoImpl;
import com.healthcare.dto.AppointmentDTO;
import com.healthcare.pojos.Patient;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class PatientDashboardServlet
 */
@WebServlet(value="/patient_dashboard",loadOnStartup = 2)
public class PatientDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppointmentDao appointmentDao;
	

	@Override
	public void init() throws ServletException {
		
		try {
			appointmentDao=new AppointmentDaoImpl();
		} catch (Exception e) {
			//to inform WC - about init's failure
			throw new ServletException("err in init "+getClass(), e);
		}
	}
	@Override
	public void destroy() {
		try {
		appointmentDao.cleanUp();
		} catch (Exception e) {
			throw new RuntimeException("err in destroy "+getClass(), e);
		}
	}


	


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			
			/* 1. get HttpSession from WC
			 * WC return null - in case of no HttpSession founds
			 * otherwise returns EXISTING HttpSession
			 */
			
			HttpSession hs = request.getSession(false);
			
			if(hs!=null) {
			
			System.out.println("session is new "+hs.isNew());//f
			System.out.println("Session ID "+hs.getId());//same id for the same clnt

			// 2. get patient details from HttpSession
			Patient patient = (Patient) hs.getAttribute("patient_details");
				String message=(String) hs.getAttribute("mesg");
				if(message != null)
				{
					hs.removeAttribute("mesg");
				}
				//3. invoke dao's method - to get the list
				List<AppointmentDTO> allUpcomingAppoints = appointmentDao.listAllUpcomingAppoints(patient.getId());
				
				//add appointment list under request scope
				request.setAttribute("appointment_list", allUpcomingAppoints);

				//forward the client to the view layer - patient_dashboard.jsp
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/patientDashboard.jsp");
				rd.forward(request, response);

			} else {
				// => no session found -> redirect the client to the login page, with error message
				
				response.sendRedirect("/day8_mvc?message='Cookies are blocked, can't continue...'");
				
			}
		} catch (Exception e) {
			throw new ServletException("err in do-get "+getClass(), e);
		}
	}

}
