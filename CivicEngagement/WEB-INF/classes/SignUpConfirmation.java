

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpConfirmation
 */

public class SignUpConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignUpConfirmation() {
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
		
		response.setContentType("text/html");
		String user= request.getParameter("email");
		String confirmationcode= request.getParameter("confirmationcode");
		
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";

		   //  Database credentials
		   final String USER = "root";
		   final String PASS = "pooja";
	try{   
	Class.forName(JDBC_DRIVER);
	Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
	Statement stmt=con.createStatement();
	Statement stmt1=con.createStatement();
    String query="select signupcode from user where username='"+user+"'";
    ResultSet rs=stmt.executeQuery(query);
    if(rs.next())
    {
    	String temp=rs.getString("signupcode");
    	if(temp.equals(confirmationcode))
    	{
    		String statusupdate="update user set status='1' where username='"+user+"'";
    		int resp=stmt1.executeUpdate(statusupdate);
    		if(resp>=0)
    		{
    		response.sendRedirect("SignUpSuccess.jsp");	
    		}
    		else
    		{
    			response.sendRedirect("SignUpConfirmationGoneWrong.jsp");	
    		}
    		
    		
    	}
    }
    else
    {
    	response.sendRedirect("SignUpConfirmationGoneWrong.jsp");
    }
    
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
		
		
		
	}

}
