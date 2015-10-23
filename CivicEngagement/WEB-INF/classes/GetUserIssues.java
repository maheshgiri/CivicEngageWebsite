

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class GetUserIssues extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserIssues() {
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
  response.setContentType("text/html");
       HttpSession session = request.getSession();
     String user=(String)session.getAttribute("user");
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";

		   //  Database credentials
		   final String USER = "root";
		   final String PASS = "pooja";
	try{   
	Class.forName(JDBC_DRIVER);
                  String resp="";
	Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("select RequestType,RequestDescription,RequestDate,RequestStatus from Requests where username='"+user+"'");
	if(rs.next())
                  {
 response.getWriter().write(rs.getString("RequestType")+"\n"+rs.getString("RequestDescription")+"\n"+rs.getString("RequestDate")+"\n"+rs.getString("RequestStatus"));
                   }
                   else
                  {
  response.getWriter().write("No");
                  }
	
	
	stmt.close();
	con.close();
	}
	catch(Exception e)
	{
		
	//response.sendRedirect("/CivicEngagement/sineup.html");
                   e.printStackTrace();
	}
	}

}
