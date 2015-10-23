

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
public class GetCityDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCityDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html");
                         int cid=Integer.parseInt(request.getParameter("cid"));
System.out.println(cid+"city");
                         if(cid==100000)
{
response.sendRedirect("PuneCityUser.jsp");
}
else if(cid==100001)
{
response.sendRedirect("MumbaiCityUser.jsp");
}
else if(cid==100002)
{
response.sendRedirect("SolapurCityUser.jsp");
}
else if(cid==100004)
{
response.sendRedirect("NagpurCityUser.jsp");
}
else if(cid==100005)
{
response.sendRedirect("NashikCityUser.jsp");
}
else if(cid==100006)
{
response.sendRedirect("AurangabadCityUser.jsp");
}
 else if(cid==100007)
{
response.sendRedirect("AmravatiCityUser.jsp");
} 
else if(cid==100008)
{
response.sendRedirect("NandedCityUser.jsp");
} 
else
{
response.sendRedirect("PimpriCityUser.jsp");
}         

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get request parameters for userID and password
                         



	}

}
