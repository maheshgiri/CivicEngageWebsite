

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
/**
 * Servlet implementation class ForgotPassword
 */

public class ForgotPassword extends HttpServlet {
	
	
	private static String USER_NAME = "khandagalekrishna8@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "Hari@hari.com1"; // GMail password
    private static String RECIPIENT = "";
	private static final long serialVersionUID = 1L;
   String code=null;
    /**
     * Default constructor. 
     */
    public ForgotPassword() {
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
		
		String user=request.getParameter("email");
		RECIPIENT = user;
String from = USER_NAME;
String pass = PASSWORD;
String[] to = { RECIPIENT }; // list of recipient email addresses
String subject = "Password recovery";

SecureRandom random = new SecureRandom();

code= new BigInteger(130, random).toString(32);


//Logic for inserting  code in database






   // JDBC driver name and database URL
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";

   //  Database credentials
   final String USER = "root";
  final String PASS = "pooja";
   
   
   Connection conn = null;
 Statement stmt=null;
Statement stmt1=null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

     PreparedStatement ps=null;
      //STEP 3: Open a connection
     String query=" UPDATE USER set OTP='"+code+"' where username='"+user+"' ";
     String query1="Select * from user where username='"+user+"' ";

      conn = DriverManager.getConnection(DB_URL, USER, PASS);
     
      stmt=conn.createStatement();
      stmt1=conn.createStatement();
      ResultSet rs=stmt1.executeQuery(query1);

     if(rs.next())
{


String body = "Copy and paste this code in reset code  field .\n"+"Your code is:"+""+code+"\nYour have requested to change your password and will be processed. \nThank you.\n-Fixstuff Admin.";

sendFromGMail(from, pass, to, subject, body);


     int result=stmt.executeUpdate(query);
      if(result>=0)
      {
        response.sendRedirect("PasswordReset.jsp");
       }
       else{
    	  response.sendRedirect("PasswordResetTryAgain.jsp");
        }
 }
     else
     {
    	 response.sendRedirect("PasswordResetTryAgain.jsp"); 
     }

   }catch(SQLException se){
     
 //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
 


		
//		
	
	
	
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
