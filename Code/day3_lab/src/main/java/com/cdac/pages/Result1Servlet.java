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

/**
 * Servlet implementation class Result1Servlet
 */
@WebServlet("/first1")
public class Result1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Cookie[] messages = request.getCookies();
		
		
		HttpSession session = request.getSession();
		Integer messages = (Integer)session.getAttribute("result");
		
		try(PrintWriter pw = response.getWriter())
		{
			if(messages!=null)
			{
				
			pw.print("<h1>"+messages+"</h1>");
			}else {
				pw.print("<h1>Cookies NULL</h1>");
			}
		}
	}

}
