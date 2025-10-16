package com.cdac.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
    public CalculateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
			int result ;
			switch(act)
			{
			case "add":
				result = a+b;
				pw.write("<h2>" + "Addition = "+result + "</h2>");
				break;
				
			case "subtract":
				result = a-b;
				pw.write("<h2>" + "Subtraction = "+result + "</h2>");
				break;
				
			case "multiply":
				result = a+b;
				pw.write("<h2>" + "Multiply = "+result + "</h2>");
				break;
				
			case "divide":
				result = a+b;
				pw.write("<h2>" + "Divide = "+result + "</h2>");
				break;
				
			default:
				pw.write("<h2>" + " Invalid data " + "</h2>");
				break;
			}
			
			
			
		}
	}



}
