package com.healthcare.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import com.healthcare.dao.DoctorDao;
import com.healthcare.dao.DoctorDaoImpl;
import com.healthcare.pojos.Doctor;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterDocServlet
 */
@WebServlet("/registerdoctor")
public class RegisterDocServlet extends HttpServlet {
	@Override
	public void destroy() {
		System.out.println("in destroy");
		super.destroy();
	}
	private DoctorDao doctorDao;
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("in init");
		try{
			doctorDao = new DoctorDaoImpl();
		}catch(Exception e) {
			throw new ServletException("error in init"+getClass(),e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String timestamp = request.getParameter("dob");
		Date d = Date.valueOf(timestamp);
		try {
			boolean doc = doctorDao.signUp(new Doctor(request.getParameter("dname"),request.getParameter("dspeciality"),request.getParameter("email"),request.getParameter("dpass"),d));
			
			if(doc) {
				response.sendRedirect("login.html");
			}
			else {
				pw.print("<h4>Registration failed due to duplicate email <a href='DoctorRegister.html'>Register Doctor</a></h4>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
