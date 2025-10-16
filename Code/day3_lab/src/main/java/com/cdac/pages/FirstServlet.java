package com.cdac.pages;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

/**
 * Servlet implementation class FirstServlet
 * WC creates a map of req mappings 
 * key - /first
 * value com.cdac.pages.FirstServlet
 */
@WebServlet(value="/first",loadOnStartup = 1)
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("in it "+getClass());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {

		System.out.println("in destroy"+getClass());

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in do-get of"+getClass());
		//1. set resp content type
		response.setContentType("text/html");
		
		//2 get writer to send text resp
		
		try(PrintWriter out = response.getWriter())
		{
			out.print("<h5>Hello from "+getClass()+ "@"+ LocalTime.now()+ "</h5>");
			
		}// JVM - out.close() - resp is sent -> clnt
		
	}

}
