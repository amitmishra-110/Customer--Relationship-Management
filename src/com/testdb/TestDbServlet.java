package com.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		//Setup connection variables
		
		String userName="springstudent";
		String passWord="springstudent";
		String jdbcurl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver="com.mysql.jdbc.Driver";
			
		//get connection to DB
		
		try
		{
			PrintWriter out=response.getWriter();
			out.println("Connecting to Database"+jdbcurl);
			
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(jdbcurl,userName,passWord);
			out.println("Connection Successful!!");
			conn.close();	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new ServletException(ex);
		}
		
		
	}

}
