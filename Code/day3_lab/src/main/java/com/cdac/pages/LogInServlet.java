package com.cdac.pages;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.healthcare.dao.PatientDao;
import com.healthcare.dao.PatientDaoImpl;
import com.healthcare.pojos.Patient;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet(value ="/login",loadOnStartup = 1)
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
		PatientDao pdService = new PatientDaoImpl();
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			//patient dao instance -clean up
			PatientDao pdService = new PatientDaoImpl();
			pdService.cleanUp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//set cont type, get pw
		//get rq params - email,password
		//invoke dao sign'in  method -> not null => success -> login success mesg
		response.setContentType("text/html");
	

		
		try(PrintWriter pw = response.getWriter()) {
			PatientDao pdService = new PatientDaoImpl();
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			
			Patient loginPatient =  pdService.signIn(email, password);

			if(loginPatient != null)
			{
				pw.print("<h1>Successfully sign in!.." +loginPatient.getEmail()+"</h1>");
			}else {
				pw.print("<h1>Error while Sign In!...</h1>");
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
