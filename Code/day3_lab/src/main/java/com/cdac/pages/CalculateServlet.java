package com.cdac.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

/**
 * Servlet implementation class CalculateServlet
 */
@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter())
		{
			int a = Integer.parseInt(request.getParameter("num1"));
			int b = Integer.parseInt(request.getParameter("num2"));
			String act = request.getParameter("action");
			int result=0 ;
			switch(act)
			{
			case "add":
				result = a+b;
				
				break;
				
			case "subtract":
				result = a-b;
				break;
				
			case "multiply":
				result = a*b;
				break;
				
			case "divide":
				result = a/b;
				break;
				
			default:
				pw.write("<h2>" + " Invalid data " + "</h2>");
				break;
			}
			
			//Cookie message ;
			
			HttpSession session ;
			
			if(result>=0)
			{
				
				//message = new Cookie("operation","Result is >=0 and Result : ".replace(' ', '.')+result);
				//response.addCookie(message);
				
				session = request.getSession();
				session.setAttribute("result", result);
				response.sendRedirect("first1");
			}else {
				//message = new Cookie("operation","Result is <0 and Result : ".replace(' ', '.')+result);
				//response.addCookie(message);
				session = request.getSession();
				session.setAttribute("result", result);
				response.sendRedirect("second2");
			}
			
			
			
		}
	}



}
