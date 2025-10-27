package com.healthcare.pages;

import java.io.IOException;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import com.healthcare.dao.DoctorDao;
import com.healthcare.dao.DoctorDaoImpl;
import com.healthcare.pojos.Doctor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DoctorLogin
 */
@WebServlet("/authenticate")
public class DoctorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DoctorDao dDao;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		try {
			dDao = new DoctorDaoImpl();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException("error in init"+getClass(),e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			dDao.cleanUp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("error in destroy",e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("em");
		String password = request.getParameter("pass");
		
		try {
			Doctor loggedInDoctor = dDao.signIn(email, password);
			
			if(loggedInDoctor!=null)
			{
				HttpSession hs = request.getSession();
				hs.setAttribute("doctor_details",loggedInDoctor);
				response.sendRedirect("doctor_dashboard");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/");
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
