


import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//



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
 * Servlet implementation class SignUpValidation
 */
public class SignUp extends HttpServlet {
  
    private static String USER_NAME = "khandagalekrishna8@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "Hari@hari.com1"; // GMail password
    private static String RECIPIENT = "";



	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
		int flag=0;
		String email= request.getParameter("signup_email");
		String confirmemail=request.getParameter("signup_confirmemail");
		String password=request.getParameter("signup_password");
		String confirmpassword=request.getParameter("signup_confirmpassword");
		String city=request.getParameter("signup_city");
		if(email.equals(confirmemail)==false)
		{
			response.sendRedirect("SignUpEmail.jsp");
			flag=1;
		}
		else if (password.equals(confirmpassword)==false)
		{
			response.sendRedirect("SignUpPassword.jsp");
			flag=1;
		}
		else
		{
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
			response.sendRedirect("SignUpDifferentEmail.jsp");
		}
		
		stmt.close();
		con.close();
		}
		catch(Exception e)
		{
			flag=1;
		response.sendRedirect("SignUp.jsp");
	    e.printStackTrace();
		}
		}//else closed
		
		if(flag==0)
		{
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			   final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";

			   //  Database credentials
			   final String USER = "root";
			   final String PASS = "pooja";
		try{   
		Class.forName(JDBC_DRIVER);
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt=con.createStatement();
                                     String sql="insert into User(username,password,email,city)  values('"+email+"','"+password+"','"+email+"','"+city+"') ";
		int insert=stmt.executeUpdate(sql);
		if (insert==1) {
                
String user=request.getParameter("signup_email");
RECIPIENT = user;
String from = USER_NAME;
String pass = PASSWORD;
String[] to = { RECIPIENT }; // list of recipient email addresses
String subject = "Sign Up Confirmation";

SecureRandom random = new SecureRandom();


String code= new BigInteger(130, random).toString(32);
String body = "Copy and paste this code in confirmation code field .\n"+"Your code is:"+""+code+"\nThank you.\n-Fixstuff Admin.";

sendFromGMail(from, pass, to, subject, body);

String query=" UPDATE USER set SignUpCode='"+code+"' where username='"+user+"' ";


try{
Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
Statement codeinsert=conn.createStatement();
     int res=codeinsert.executeUpdate(query);
      if(res>=0)
      {
        response.sendRedirect("SignUpConfirmation.jsp");
       }
       else{
    	  response.sendRedirect("SignUp.jsp");
        }


}
catch(Exception e)
{
    e.printStackTrace();
}

            


			
			//response.sendRedirect("SignUpConfirmation.jsp");	
		}
		else
		{
			response.sendRedirect("SignUp.jsp");
		}
		
		stmt.close();
		con.close();
		}
		catch(Exception e)
		{
		response.sendRedirect("SignUp.jsp");
	    e.printStackTrace();
		}
		}
		
	}



public static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
	        Properties props = System.getProperties();
	        String host = "smtp.gmail.com";
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", from);
	        props.put("mail.smtp.password", pass);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");

	        Session session = Session.getDefaultInstance(props);
	        MimeMessage message = new MimeMessage(session);

	        try {
	            message.setFrom(new InternetAddress(from));
	            InternetAddress[] toAddress = new InternetAddress[to.length];

	            // To get the array of addresses
	            for( int i = 0; i < to.length; i++ ) {
	                toAddress[i] = new InternetAddress(to[i]);
	            }

	            for( int i = 0; i < toAddress.length; i++) {
	                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	            }

	            message.setSubject(subject);
	            message.setText(body);
	            Transport transport = session.getTransport("smtp");
	            transport.connect(host, from, pass);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	        }
	        catch (AddressException ae) {
	            ae.printStackTrace();
	        }
	        catch (MessagingException me) {
	            me.printStackTrace();
	        }
	    }



}
