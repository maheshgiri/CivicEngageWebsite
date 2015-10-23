package com.Mobile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Servlet implementation class SignUpValidation
 */
public class SignUpTry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpTry() {
        super();
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
                PrintWriter out=response.getWriter();
		int flag=0;
                String EXCEPTION="100";
                String USER_ERROR="101";
                String SUCCESS="102";

		String email= request.getParameter("signup_email");
		
		String password=request.getParameter("signup_password");
		
		String city=request.getParameter("signup_city");

		System.out.println("inide sign up from mobile "+email);
		
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			   final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";

			   //  Database credentials
			   final String USER = "root";
			   final String PASS = "pooja";
		try{   
		Class.forName(JDBC_DRIVER);
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select username from User where username='"+email+ "' ");
		if(rs.next())
		{
			flag=1;
			out.println(USER_ERROR);
		}
		
		stmt.close();
		con.close();
		}
		catch(Exception e)
		{
			flag=1;
		out.println(EXCEPTION);
	    e.printStackTrace();
		}
		
		
		if(flag==0)
		{
			  
			  
		try{   
		Class.forName(JDBC_DRIVER);
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt=con.createStatement();
                                     String sql="insert into User(username,password,email,city)  values('"+email+"','"+password+"','"+email+"','"+city+"') ";
		int insert=stmt.executeUpdate(sql);
		if (insert==1) {
			
			out.println(SUCCESS);	
		}
		else
		{
			out.println(EXCEPTION);
		}
		
		stmt.close();
		con.close();
		}
		catch(Exception e)
		{
		out.println(EXCEPTION);
	    e.printStackTrace();
		}
		}
		
	}

}
