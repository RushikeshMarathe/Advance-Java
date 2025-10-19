package com.healthcare.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.healthcare.dao.AppointmentDao;
import com.healthcare.dao.AppointmentDaoImpl;
import com.healthcare.pojos.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AppointmentsServlet
 */
@WebServlet("/appointments")
public class AppointmentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppointmentDao appointmentDao;

	@Override
	public void destroy() {
		try {
			appointmentDao.cleanUp();
		} catch (Exception e) {
			throw new RuntimeException("err in destroy " + getClass(), e);
		}
	}

	@Override
	public void init() throws ServletException {
		try {
			appointmentDao = new AppointmentDaoImpl();
		} catch (Exception e) {
			// to inform WC - about init's failure
			throw new ServletException("err in init " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set reps cont type
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			//get session from WC
			HttpSession session=request.getSession();
			System.out.println("from "+getClass()+" session is new "+session.isNew());
			Patient patient=(Patient) session.getAttribute("patient_details");
			// get req parameters
			String action1 = request.getParameter("action");
			int doctorId = Integer.parseInt(request.getParameter("doc_id"));
			String timeStamp = request.getParameter("appointment_ts");
			System.out.println(timeStamp);
			Timestamp ts = Timestamp.valueOf(LocalDateTime.parse(timeStamp));
			if (action1.equals("book")) {
				// book appointment- call dao's method
				String message = appointmentDao.bookAppointment(doctorId, patient.getId(), ts);
				//add session scoped attribute
				session.setAttribute("mesg", message);
				response.sendRedirect("patient_dashboard");

			} else if (action1.equals("cancel")) {
				// cancel appointment
			}
		} catch (Exception e) {
			throw new ServletException("err in do post "+getClass(), e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int appointmentid = Integer.parseInt(request.getParameter("id"));
		HttpSession hs = request.getSession();
		int patientid = ((Patient)hs.getAttribute("patient_details")).getId();
		try{
			String message = appointmentDao.cancelAppointment(appointmentid, patientid);
		}catch(Exception e) {
			throw new ServletException("error in init"+getClass(),e);
		}
		response.sendRedirect("patient_dashboard");
		
	}

}
