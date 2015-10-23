

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignUpValidation
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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
		String cp= request.getParameter("currentpass");
		String np=request.getParameter("newpass");
		String cnp=request.getParameter("cnewpass");
		
		HttpSession session=request.getSession();
                                     String user=(String)session.getAttribute("user");
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			   final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";

			   //  Database credentials
			   final String USER = "root";
			   final String PASS = "pooja";
		try{   
		Class.forName(JDBC_DRIVER);
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt=con.createStatement();
                                     String sql="update user set Password='"+np+"'  where username='"+user+"' ";
		int insert=stmt.executeUpdate(sql);
		if (insert>=0) {
			
			response.sendRedirect("PasswordSaveSuccess.jsp");	
		}
		else
		{
		       	
		}
		
		stmt.close();
		con.close();
		}
		catch(Exception e)
		{
		
	    e.printStackTrace();
		}
	
		
	}

}
