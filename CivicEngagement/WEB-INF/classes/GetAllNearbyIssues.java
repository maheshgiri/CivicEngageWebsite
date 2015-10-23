

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

/**
 * Servlet implementation class SignUpValidation
 */
public class GetAllNearbyIssues extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllNearbyIssues() {
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
if(user==null){
response.sendRedirect("Login.jsp");
}



			   final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";
  int pagenum=0;
PrintWriter out=response.getWriter();
int total_nums=0;
int total_pages=0;
int rowsperpage=0 ;
int offset=0;
ResultSet rs;
Connection con;
Statement stmt;
String tempcity=null;
int tempcityid=0;
String cityname=null;
			   //  Database credentials
			   final String USER = "root";
			   final String PASS = "pooja";
                                            rowsperpage=4;

  
try
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(DB_URL, "root", "pooja"); 

stmt = con.createStatement();
rs=stmt.executeQuery("select city from user where username='"+user+"'");
if(rs.next())
 {
	 cityname=rs.getString("City");
	 cityname=cityname.toLowerCase();
 }
// out.println(cityname);
if( cityname.contains("pune"))
{
	tempcity="pune";
}
else if( cityname.contains("mumbai"))
{
tempcity="mumbai";
}
else if( cityname.contains("nagpur"))
{
tempcity="nagpur";
}
else if( cityname.contains("solapur"))
{
tempcity="solapur";
}
else if( cityname.contains("nashik"))
{
tempcity="nashik";
}
else if( cityname.contains("aurangabad"))
{
tempcity="aurangabad";
}
else if( cityname.contains("amravati"))
{
tempcity="amravati";
}
else if ( cityname.contains("nanded"))
{tempcity="nanded";
}
else if ( cityname.contains("pimpri "))
{
	tempcity="pimpri";

}
else 
{
//do nothing
}
 rs=stmt.executeQuery("Select CityID from city where city like '"+tempcity+"' ");
 if(rs.next())
 {
	 tempcityid=rs.getInt("CityID");
 }
 //out.println(tempcityid);
 rs=stmt.executeQuery("Select * from Requests where CityID='"+tempcityid+"' ");


rs.last();

total_nums=rs.getRow();

//out.println(total_nums);
total_pages= (int)Math.ceil(total_nums/rowsperpage);

if(total_nums%4!=0)
{
total_pages+=1;
}
offset=(pagenum-1)*rowsperpage;
String tot=Integer.toString(total_pages);
out.write(tot);



}
catch(Exception e)
{
System.out.println(e);
}

		
	}

}
