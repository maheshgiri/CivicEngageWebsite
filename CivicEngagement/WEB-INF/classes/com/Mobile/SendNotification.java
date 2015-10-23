package com.Mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

import com.google.gson.internal.Primitives;

/**
 * Servlet implementation class SendNotification
 */

public class SendNotification extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 private static String USER_NAME = "khandagalekrishna8@gmail.com";  // GMail user name (just the part before "@gmail.com")
	 private static String PASSWORD = "Hari@hari.com1"; // GMail password
	 private static String RECIPIENT = "";

    /**
     * Default constructor. 
     */
    public SendNotification() {
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
		PrintWriter out=response.getWriter();
		String user=request.getParameter("user");
		
System.out.println("user"+user);

		  final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		  final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";

		   //  Database credentials
		   final String USER = "root";
		   final String PASS = "pooja";
		  
           String city=null;
           String temp="";
           
           int i=0;
try{ 
 
Class.forName(JDBC_DRIVER);
Connection con = DriverManager.getConnection(DB_URL, USER, PASS);  
System.out.println("con"+con);
Statement stmt=con.createStatement(); 
Statement stmt1= con.createStatement(); 
ResultSet cityname=stmt.executeQuery("select city from user where username='"+user+"'");
if(cityname.next())
{
	city=cityname.getString("city");
System.out.println("city"+city);
}

ResultSet users=stmt1.executeQuery("select username from user where city like '%"+city+"%'");
int k=0;
while(users.next())
{
	System.out.println("users"+users.getString("username"));
temp+=users.getString("username")+",";
k++;

}





}
catch(Exception e)
{
	  out.println("fail");
}
		
		
        String from = USER_NAME;
System.out.println(from);
        String pass = PASSWORD;
System.out.println(pass);
        // list of recipient email addresses
        String subject = request.getParameter("emailsubject");
        String body = request.getParameter("emailbody");
System.out.println(subject);
System.out.println(body);

String [] to=temp.split(",");
System.out.println(to[0]);


System.out.println(to.length);




        sendFromGMail(from, pass, to, subject, body);
        out.println("yes");
		
		
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
