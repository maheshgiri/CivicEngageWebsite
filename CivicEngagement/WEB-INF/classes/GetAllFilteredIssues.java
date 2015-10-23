

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
public class GetAllFilteredIssues extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllFilteredIssues () {
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



			   final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";
  int pagenum=0;
PrintWriter out=response.getWriter();
int total_nums=0;
int total_pages=0;
int rowsperpage=0 ;
int offset=0;
ResultSet rs=null;
Connection con;
Statement stmt;
String tempcity=null;
int tempcityid=0;
String cityname=null;
			
int cityid=Integer.parseInt(request.getParameter("city"));

String rstatus=request.getParameter("status");
String sortby=request.getParameter("sortby");
String servicetype=request.getParameter("type");
System.out.println("--------inside get all-----------");
System.out.println("getllCityid"+cityid);
System.out.println("getallstatus"+rstatus);
System.out.println("getallSortby"+sortby);
System.out.println("getallStype"+servicetype);  

 //  Database credentials
			   final String USER = "root";
			   final String PASS = "pooja";
                                            rowsperpage=4;

  
try
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(DB_URL, "root", "pooja"); 

stmt = con.createStatement();


if(rstatus.equals("All") && servicetype.equals("All"))
{
if(sortby.equals("Most Recent"))
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+"  order by RequestID desc ");
}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+"  order by RequestID asc ");
}
}

if(rstatus.equals("All") && servicetype.equals("Dangerous Condition"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"'  order by RequestID desc ");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc ");

}
}//second closed


if(rstatus.equals("All") && servicetype.equals("Environmental Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc ");
}
}//All Environmental


if(rstatus.equals("All") && servicetype.equals("Garbage Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc ");
}
}//All garbage issue


if(rstatus.equals("All") && servicetype.equals("Health Hazard"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc ");
}
}//All health hazard issue


if(rstatus.equals("All") && servicetype.equals("Housing Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc ");
}
}//All housing issue

if(rstatus.equals("All") && servicetype.equals("Noise Complaint"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc ");
}
}//All Noise complaint

if(rstatus.equals("All") && servicetype.equals("Police Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc ");
}
}//All Police Issue

if(rstatus.equals("All") && servicetype.equals("Pothole"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc ");
}
}//All Pothol

if(rstatus.equals("All") && servicetype.equals("Redevelopement"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc ");
}
}//All Redevelopement

if(rstatus.equals("All") && servicetype.equals("Signage Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc ");
}
}//All Signage issue

if(rstatus.equals("All") && servicetype.equals("Transportation Problem"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc ");
}
}//All Transportation problem

if(rstatus.equals("All") && servicetype.equals("Other"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc ");
}
}//All Other

//--------------------for open

if(rstatus.equals("Open") && servicetype.equals("All"))
{
if(sortby.equals("Most Recent"))
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' )  order by RequestID desc ");
}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' )  order by RequestID asc ");
}
}

if(rstatus.equals("Open") && servicetype.equals("Dangerous Condition"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc ");
}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc ");

}
}//second closed

if(rstatus.equals("Open") && servicetype.equals("Environmental Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc ");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc ");
}
}//All Environmental

if(rstatus.equals("Open") && servicetype.equals("Garbage Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc ");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc ");
}
}//All garbage issue

if(rstatus.equals("Open") && servicetype.equals("Health Hazard"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc ");
}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc ");
}
}//All health hazard issue

if(rstatus.equals("Open") && servicetype.equals("Housing Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc ");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc ");


}
}//All housing issue

if(rstatus.equals("Open") && servicetype.equals("Noise Complaint"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc ");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc ");


}
}//All Noise complaint


if(rstatus.equals("Open") && servicetype.equals("Police Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc ");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc ");


}
}//All Police Issue


if(rstatus.equals("Open") && servicetype.equals("Pothole"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc ");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc ");


}
}//All Pothol

if(rstatus.equals("Open") && servicetype.equals("Redevelopement"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc ");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc ");

}
}//All Redevelopement

if(rstatus.equals("Open") && servicetype.equals("Signage Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc ");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc ");
}
}//All Signage issue

if(rstatus.equals("Open") && servicetype.equals("Transportation Problem"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc ");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc ");


}
}//All Transportation problem

if(rstatus.equals("Open") && servicetype.equals("Other"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc ");
}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc ");
}
}//All Other
//-----for closed


if(rstatus.equals("Closed") && servicetype.equals("All"))
{
if(sortby.equals("Most Recent"))
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and (RequestStatus like '%Completed%' )  order by RequestID desc ");
}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and (RequestStatus like '%Completed%' )  order by RequestID asc ");
}
}


if(rstatus.equals("Closed") && servicetype.equals("Dangerous Condition"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc ");
}
}//second closed

if(rstatus.equals("Closed") && servicetype.equals("Environmental Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc ");
}
}//Closed Environmental

if(rstatus.equals("Closed") && servicetype.equals("Garbage Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc ");
}
}//Closed garbage issue

if(rstatus.equals("Closed") && servicetype.equals("Health Hazard"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc ");
}
}//Closed health hazard issue

if(rstatus.equals("Closed") && servicetype.equals("Housing Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc ");
}
}//Closed housing issue

if(rstatus.equals("Closed") && servicetype.equals("Noise Complaint"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc ");
}
}//Closed Noise complaint


if(rstatus.equals("Closed") && servicetype.equals("Police Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc ");
}
}//Closed Police Issue

if(rstatus.equals("Closed") && servicetype.equals("Pothole"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc ");
}
}//Closed Pothol

if(rstatus.equals("Closed") && servicetype.equals("Redevelopement"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc ");
}
}//Closed Redevelopement

if(rstatus.equals("Closed") && servicetype.equals("Signage Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc ");
}
}//Closed Signage issue

if(rstatus.equals("Closed") && servicetype.equals("Transportation Problem"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc ");
}
}//Closed Transportation problem

if(rstatus.equals("Closed") && servicetype.equals("Other"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc ");
}
}//Closed Other


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
System.out.println("total pages in get all"+tot);
System.out.println("------------------------------------");
out.write(tot);



}
catch(Exception e)
{
System.out.println("get all"+e);
}

		
	}

}
