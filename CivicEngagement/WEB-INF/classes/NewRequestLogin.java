

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
public class NewRequestLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRequestLogin() {
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
	ResultSet rs=stmt.executeQuery("select password from user where username='"+user+"'");
	String ps;
	if(rs.next())
	{
	ps=rs.getString("password");
	if(ps.equals(password))
	{  
                              HttpSession session = request.getSession();
                               session.setAttribute("user", user);
                               //setting session to expiry in 30 mins
                              //session.setMaxInactiveInterval(30*60);
                              Cookie userName = new Cookie("user", user);
                             //userName.setMaxAge(30*60);
                            response.addCookie(userName);
	          response.sendRedirect("newrequestuser.jsp");
	}
	else
	{
		
		response.sendRedirect("/CivicEngagement/LoginDenied.jsp");
	}
	}
	
	else
	{
		response.sendRedirect("/CivicEngagement/LoginDenied.jsp");
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
