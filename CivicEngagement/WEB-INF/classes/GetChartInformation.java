

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import  com.google.gson.*;
import java.text.SimpleDateFormat;
/**
 * Servlet implementation class Login
 */
public class GetChartInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetChartInformation () {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get request parameters for userID and password
            String cityid=request.getParameter("cityid");
       response.setContentType("text/html");
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";

		   //  Database credentials
		   final String USER = "root";
		   final String PASS = "pooja";
	try{   
	Class.forName(JDBC_DRIVER);
	Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
	Statement stmt=con.createStatement();
        PrintWriter out=response.getWriter();
        String res=null;
        String sent=null;
        String inprogress=null;
        String completed=null;
	ResultSet rs=stmt.executeQuery("select count(*) as cnt from requests where cityid='"+cityid+"' and RequestStatus='Sent' ");
       if(rs.next())
       {
        sent=rs.getString("cnt");
       }
        rs=stmt.executeQuery("select count(*) as cnt from requests where cityid='"+cityid+"' and RequestStatus='In Progress' "); 
        if(rs.next())
        {
         inprogress=rs.getString("cnt");   
        }
        
        rs=stmt.executeQuery("select count(*) as cnt from requests where cityid='"+cityid+"' and RequestStatus='Completed' ");
       if(rs.next())
       {
        completed=rs.getString("cnt");
       }
        res=sent+","+inprogress+","+completed;
        
        System.out.println(res);
	out.println(res);
       
	stmt.close();
	con.close();
	}
	catch(Exception e)
	{
		
	//response.sendRedirect("/CivicEngagement/sineup.html");
                   e.printStackTrace();
	}
       //String res="<h4>Bondi Beach</h4>,-33.890542,151.274856;<h4>Coogee Beach</h4>, -33.923036,151.259052";
    
    
    
      
	
	
	
	
	}

}
