package com.Mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class LoginTry
 */

public class LoginTry extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginTry() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
	String user = request.getParameter("username");
        String password = request.getParameter("password");
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";
        
        PrintWriter out=response.getWriter();

		   //  Database credentials
		   final String USER = "root";
		   final String PASS = "pooja";
	try{   
	Class.forName(JDBC_DRIVER);
	Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("select password from user where username='"+user+"'");
	String ps;
	if(rs.next())
	{
	ps=rs.getString("password");
	if(ps.equals(password))
	{  
                              
	          out.println("true");
	}
	else
	{
		
		out.println("false");
	}
	}
	
	else
	{
		out.println("false");
	}
	
	stmt.close();
	con.close();
	}
	catch(Exception e)
	{
		
	
                   e.printStackTrace();
	}


		
	}

}
