

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


import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * Servlet implementation class SignUpValidation
 */
public class MobileRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobileRequest() {
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
		String rloc= request.getParameter("reqCity");

                //logic to compare cities 
int cid=-1;
int did=-1;
String temp=rloc.toLowerCase();
if(temp.contains("pune"))
{
GetCityID gci=new GetCityID();
 cid=gci.GetID("pune");
}
else if(temp.contains("mumbai"))
{
GetCityID gci=new GetCityID();
cid=gci.GetID("mumbai");
}
else if(temp.contains("nagpur"))
{
GetCityID gci=new GetCityID();
cid=gci.GetID("nagpur");
}
else if(temp.contains("solapur"))
{
GetCityID gci=new GetCityID();
 cid=gci.GetID("solapur");
}
else if(temp.contains("nashik"))
{
GetCityID gci=new GetCityID();
 cid=gci.GetID("nashik");
}
else if(temp.contains("aurangabad"))
{
GetCityID gci=new GetCityID();
 cid=gci.GetID("aurangabad");
}
else if(temp.contains("amravati"))
{
GetCityID gci=new GetCityID();
 cid=gci.GetID("amravati");
}
else if (temp.contains("nanded"))
{
GetCityID gci=new GetCityID();
 cid=gci.GetID("nanded");
}
else if (temp.contains("pimpri "))
{
GetCityID gci=new GetCityID();
 cid=gci.GetID("pimpri");
}
else 
{
//do nothing
}
//logic for city ends here






                 
		String reqAddr=request.getParameter("reqLocation");
		String reqDescription=request.getParameter("reqDescription");
		String reqPhoto =request.getParameter("reqPhoto");
		String rtype=request.getParameter("reqType");
                String reqUser=request.getParameter("reqUser");
if(rtype.contains("Dangerous Condition"))
{
//getDepartmentID
GetDepartmentID gdi=new GetDepartmentID();
did=gdi.GetID("Emergency Department",cid);
}
else if(rtype.contains("Environmental Issue"))
{
GetDepartmentID gdi=new GetDepartmentID();
did=gdi.GetID("Urban Environment Department",cid);
}
else if(rtype.contains("Garbage Issue"))
{
GetDepartmentID gdi=new GetDepartmentID();
did=gdi.GetID("Waste Management Department",cid);
}
else if(rtype.contains("Health Hazard"))
{
GetDepartmentID gdi=new GetDepartmentID();
did=gdi.GetID("Public Health Department",cid);
}
else if(rtype.contains("Housing Issue"))
{
GetDepartmentID gdi=new GetDepartmentID();
did=gdi.GetID("Construction Department",cid);
}
else if(rtype.contains("Police Issue"))
{
GetDepartmentID gdi=new GetDepartmentID();
did=gdi.GetID("Police Department",cid);
}
else if(rtype.contains("Noise Complaint"))
{
GetDepartmentID gdi=new GetDepartmentID();
did=gdi.GetID("Public Convinience Department",cid);
}

else if(rtype.contains("Pothol"))
{
GetDepartmentID gdi=new GetDepartmentID();
did=gdi.GetID("Waste Management Department",cid);
}
else if(rtype.contains("Pothol"))
{
GetDepartmentID gdi=new GetDepartmentID();
did=gdi.GetID("Waste Management Department",cid);
}
else if(rtype.contains("Redevelopement"))
{
GetDepartmentID gdi=new GetDepartmentID();
did=gdi.GetID("Construction Department",cid);
}
else if(rtype.contains("Redevelopement"))
{
GetDepartmentID gdi=new GetDepartmentID();
did=gdi.GetID("Construction Department",cid);
}
else if(rtype.contains("Signage Issue"))
{
GetDepartmentID gdi=new GetDepartmentID();
did=gdi.GetID("Road Department",cid);
}
else if(rtype.contains("Transportation Problem"))
{
GetDepartmentID gdi=new GetDepartmentID();
did=gdi.GetID("Road Department",cid);
}
else if(rtype.contains("Other"))
{
GetDepartmentID gdi=new GetDepartmentID();
did=gdi.GetID("Other",cid);
}
else
{
//nothing do
}


//Ends DepartmetID logic here

Calendar currentDate = Calendar.getInstance();
SimpleDateFormat dateFormatter= new SimpleDateFormat("dd-MMMMMMMM-yyyy ");
 SimpleDateFormat timeFormatter=  new SimpleDateFormat("HH:mm:ss ");
String time = timeFormatter.format(currentDate.getTime());
  String date =  dateFormatter.format(currentDate.getTime());

                
		

			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			   final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";

			   //  Database credentials
			   final String USER = "root";
			   final String PASS = "pooja";
		try{   
		Class.forName(JDBC_DRIVER);
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt=con.createStatement();
                                     String sql="insert into requests(RequestLocation,RequestTitle,RequestType,RequestDescription,RequestPhoto,Username,RequestTime,CityID,DepartmentID) values ('"+reqAddr+"','"+rtype+"','"+rtype+"','"+reqDescription+"','"+reqPhoto+"','"+reqUser+"', '"+time+"','"+cid+"','"+did+"')";


		int insert=stmt.executeUpdate(sql);
		if (insert>=0) {
			
			response.getWriter().write("yes");	
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
