package com.healthcare.pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.healthcare.dao.DoctorDao;
import com.healthcare.dao.DoctorDaoImpl;
import com.healthcare.dto.DoctorAppointment;
import com.healthcare.pojos.Doctor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DoctorDashboard
 */
@WebServlet("/doctor_dashboard")
public class DoctorDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DoctorDao dDao ;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			dDao = new DoctorDaoImpl();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException("Error in init",e);
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		System.out.println("action "+action);
		
		if(action==null)
		{
		HttpSession hs = request.getSession(false);
		
		if(hs!=null)
		{ 
			
		Doctor  authenticatedDoctor = (Doctor)hs.getAttribute("doctor_details");
		System.out.println("inside the doctor_dashboard");
		
		try {
			List<DoctorAppointment> allDoctorAppointment =  dDao.getDoctorAppointment(authenticatedDoctor.getId());
			System.out.println("alldoctors"+allDoctorAppointment);
			request.setAttribute("allAppointments", allDoctorAppointment);
		
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/doctor_dashboard.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		}else {
			response.sendRedirect("/day8_optional");
		}
		}
		
		
		
		else{
			System.out.println("in else");
			if(action.equals("done"))
			{
					try {
						dDao.updateStatus(Integer.parseInt(request.getParameter("appId")));
						response.sendRedirect("doctor_dashboard");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}else if(action.equals("cancel"))
			{
				try {
					dDao.cancelAppointment(Integer.parseInt(request.getParameter("appId")));
					response.sendRedirect("doctor_dashboard");

				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}

	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
