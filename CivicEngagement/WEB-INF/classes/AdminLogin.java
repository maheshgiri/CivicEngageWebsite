

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
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
        String user = request.getParameter("login_username");
        String password = request.getParameter("login_password");
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";

		   //  Database credentials
		   final String USER = "root";
		   final String PASS = "pooja";
	try{   
	Class.forName(JDBC_DRIVER);
	Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("select password from admin where username='"+user+"'");
	String ps;
	if(rs.next())
	{
	ps=rs.getString("password");
System.out.println("inside "+ps);
	if(ps.equals(password))
	{  

System.out.println("inside true");
                              HttpSession session = request.getSession();
                               session.setAttribute("admin", user);
                               //setting session to expiry in 30 mins
                              //session.setMaxInactiveInterval(30*60);
                              Cookie admin = new Cookie("admin", user);
                             //userName.setMaxAge(30*60);
                            response.addCookie(admin);
               response.setHeader("Cache-control","no-store"); //HTTP 1.1 
response.setHeader("Pragma","no-cache"); //HTTP1.0 
response.setDateHeader("Expire",0); //prevents caching at the 
	          response.sendRedirect("/CivicEngagement/AdminProfile.jsp");
return;
	}
	else
	{
		
		response.sendRedirect("/CivicEngagement/AdminLoginPage.jsp");
return;
	}
	}
	
	else
	{
		response.sendRedirect("/CivicEngagement/AdminLoginPage.jsp");

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
