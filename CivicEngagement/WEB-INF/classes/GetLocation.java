

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
public class GetLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLocation() {
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
        Statement stmt1=con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from requests where cityid='"+cityid+"' ");
        ResultSet rs1=stmt1.executeQuery("select * from requests where cityid='"+cityid+"' ");
        PrintWriter out=response.getWriter();
	String res="";
        
        if(rs1.next())
        {
        
        
	while(rs.next())
        {

           
            
             
            if(rs.getString("lat").equals("null")==false && rs.getString("lng").equals("null") ==false&& rs.getString("lat").equals("")==false && rs.getString("lng").equals("") ==false && rs.getString("lat").equals("none")==false && rs.getString("lng").equals("none") ==false)
            {
          
            SimpleDateFormat dateFormatter= new SimpleDateFormat("dd-MMMMMMMM-yyyy ");
            String date=dateFormatter.format(rs.getDate("RequestDate"));
            res+="<span class='icon-calendar'></span>"+date+"<br>"+rs.getString("RequestType")+"<br>"+rs.getString("RequestStatus")+""+"<span class='icon-check'></span>"+","+rs.getString("lat")+","+rs.getString("lng")+";";
            }
        }
        
	out.println(res);
        }
        else
        {
         if(cityid.contains("100000"))
                 {
                     System.out.println("yse");
                   res+="No Requests submitted yet."+",18.5204303,73.85674369999992"+";";
                 }
         
         if(cityid.contains("100001"))
                 {
                     System.out.println("yse");
                   res+="No Requests submitted yet."+",19.0759837,72.87765590000004"+";";
                 }
         
          if(cityid.contains("100002"))
                 {
                     System.out.println("yse");
                   res+="No Requests submitted yet."+",17.6599188,75.90639060000001"+";";
                 }
          
           if(cityid.contains("100004"))
                 {
                     System.out.println("yse");
                   res+="No Requests submitted yet."+",21.1458004,21.1458004"+";";
                 }
            if(cityid.contains("100005"))
                 {
                     System.out.println("yse");
                   res+="No Requests submitted yet."+",19.9974533,73.78980230000002"+";";
                 }
             if(cityid.contains("100006"))
                 {
                     System.out.println("yse");
                   res+="No Requests submitted yet."+",19.8761653,75.3433139"+";";
                 }
              if(cityid.contains("100007"))
                 {
                     System.out.println("yse");
                   res+="No Requests submitted yet."+",20.930679,77.75871299999994"+";";
                 }
               if(cityid.contains("100008"))
                 {
                     System.out.println("yse");
                   res+="No Requests submitted yet."+",19.153061,77.30584699999997"+";";
                 }
               
         
         out.println(res);
        
}
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
