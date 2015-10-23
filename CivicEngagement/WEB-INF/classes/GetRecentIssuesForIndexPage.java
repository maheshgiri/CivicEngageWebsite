

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
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class SignUpValidation
 */
public class GetRecentIssuesForIndexPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRecentIssuesForIndexPage() {
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
		response.setContentType("text/html");
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
HttpSession session=request.getSession();
String user=(String)session.getAttribute("user");


 final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";
 
PrintWriter out=response.getWriter();

ResultSet rs,rscity;
Connection con;
Statement stmt;
String cityname=null;
 //  Database credentials
  final String USER = "root";
  final String PASS = "pooja";
                                           

 

try
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(DB_URL, "root", "pooja"); 

stmt = con.createStatement();






 rs=stmt.executeQuery("Select * from Requests limit 0 ,10 ");


    //THE RESULTS WILL APPEAR
    while(rs.next())
    {
        int rid=rs.getInt("RequestID");
        String requesttype = rs.getString("RequestType");
        String requestdesc=rs.getString("RequestDescription");
        String photo=rs.getString("RequestPhoto");
        String status=rs.getString("RequestStatus");
       
        Date rdate=rs.getDate("RequestDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMMMMMMMMMM-yyyy");
        String reqdate=dateFormat.format(rdate);
        
       String rloc=rs.getString("RequestLocation");
       String un=rs.getString("Username");
       int cid=rs.getInt("CityID");     
       
out.write("<div class=' col-lg-3 col-sm-4 col-md-4  col-xs-6'>");            
out.write("<div class='thumbnail' style='height:200px'>");
out.write("<div class='caption'>");
out.write("<h4><span class='iconfix-fix '></span>"+requesttype+"</h4>");
out.write("<h6><span class='icon-time icon-white'></span>"+reqdate+"</h6>");
out.write("<a href='GetRequestDetailsOnClick?reqid="+rid+"' class='label label-success' rel='tooltip' title='View Details'>View Details</a>");
out.write(" </div>");
out.write("<img class='img-responsive'  src='User/"+"/requests/"+photo+"' alt='Request photo'  style='height:200px'>");
out.write("</div>");
out.write("</div>");  

    }//While Closed


stmt.close();
con.close();
}//Try closed
catch(Exception e)
{
System.out.println(e);
}

}	

}
