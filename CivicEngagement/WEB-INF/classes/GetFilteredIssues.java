

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
public class GetFilteredIssues extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public  GetFilteredIssues() {
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
System.out.println("inside get filterd issues first line");
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

			   //  Database credentials
			   final String USER = "root";
			   final String PASS = "pooja";
                                            rowsperpage=4;

   if(request.getParameter("page")!=null)
{
pagenum=Integer.parseInt(request.getParameter("page"));
//out.println("in result not null"+pagenum);
System.out.println("inside get issues"+pagenum);
}
else
{
pagenum=1;
//out.println("in result null"+pagenum);

}
//Getting parameters

int cityid=Integer.parseInt(request.getParameter("city"));

String rstatus=request.getParameter("status");
String sortby=request.getParameter("sortby");
String servicetype=request.getParameter("type");
System.out.println("---inside get fileterd issuse---");
System.out.println("getPagenum"+pagenum);
System.out.println("getCityid"+cityid);
System.out.println("getstatus"+rstatus);
System.out.println("getSortby"+sortby);
System.out.println("getStype"+servicetype);  


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




//-----closed
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
//-------------------------------------------------last
total_nums=rs.getRow();
System.out.println("getfil"+total_nums);
total_pages= (int)Math.ceil(total_nums/rowsperpage);

if(total_nums%4!=0)
{
total_pages+=1;
}
System.out.println("getfil"+total_pages);
offset=(pagenum-1)*rowsperpage;
//out.println("Select * from content limit "+offset+" ,"+rowsperpage +" ");
 //--------------------------------------

if(rstatus.equals("All") && servicetype.equals("All"))
{
if(sortby.equals("Most Recent"))
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+"  order by RequestID desc limit "+offset+" ,"+rowsperpage +" ");
}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+"  order by RequestID asc limit "+offset+" ,"+rowsperpage +" ");
}
}

if(rstatus.equals("All") && servicetype.equals("Dangerous Condition"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"'  order by RequestID desc limit "+offset+" ,"+rowsperpage +" ");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc limit "+offset+" ,"+rowsperpage +"");

}
}//second closed

if(rstatus.equals("All") && servicetype.equals("Environmental Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc  limit "+offset+" ,"+rowsperpage +" ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc limit "+offset+" ,"+rowsperpage +" ");
}
}//All Environmental

if(rstatus.equals("All") && servicetype.equals("Garbage Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc limit "+offset+" ,"+rowsperpage +"");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc limit "+offset+" ,"+rowsperpage +"");
}
}//All garbage issue


if(rstatus.equals("All") && servicetype.equals("Health Hazard"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc  limit "+offset+" ,"+rowsperpage +" ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc  limit "+offset+" ,"+rowsperpage +" ");
}
}//All health hazard issue

if(rstatus.equals("All") && servicetype.equals("Housing Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc  limit "+offset+" ,"+rowsperpage +"");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc  limit "+offset+" ,"+rowsperpage +"");
}
}//All housing issue

if(rstatus.equals("All") && servicetype.equals("Noise Complaint"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc limit "+offset+" ,"+rowsperpage +" ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc limit "+offset+" ,"+rowsperpage +" ");
}
}//All Noise complaint

if(rstatus.equals("All") && servicetype.equals("Police Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc limit "+offset+" ,"+rowsperpage +" ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc  limit "+offset+" ,"+rowsperpage +"");
}
}//All Police Issue

if(rstatus.equals("All") && servicetype.equals("Pothole"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc   limit "+offset+" ,"+rowsperpage +" ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc   limit "+offset+" ,"+rowsperpage +" ");
}
}//All Pothol

if(rstatus.equals("All") && servicetype.equals("Redevelopement"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc  limit "+offset+" ,"+rowsperpage +" ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc  limit "+offset+" ,"+rowsperpage +"");
}
}//All Redevelopement

if(rstatus.equals("All") && servicetype.equals("Signage Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc  limit "+offset+" ,"+rowsperpage +"");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc limit "+offset+" ,"+rowsperpage +" ");
}
}//All Signage issue

if(rstatus.equals("All") && servicetype.equals("Transportation Problem"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc limit "+offset+" ,"+rowsperpage +"");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc limit "+offset+" ,"+rowsperpage +"");
}
}//All Transportation problem

if(rstatus.equals("All") && servicetype.equals("Other"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID desc limit "+offset+" ,"+rowsperpage +" ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' order by RequestID asc limit "+offset+" ,"+rowsperpage +" ");
}
}//All Other


if(rstatus.equals("Open") && servicetype.equals("All"))
{
if(sortby.equals("Most Recent"))
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' )  order by RequestID desc limit "+offset+" ,"+rowsperpage +" ");
}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' )  order by RequestID asc limit "+offset+" ,"+rowsperpage +"");
}
}

if(rstatus.equals("Open") && servicetype.equals("Dangerous Condition"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc  limit "+offset+" ,"+rowsperpage +" ");
}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc  limit "+offset+" ,"+rowsperpage +" ");

}
}//second closed

if(rstatus.equals("Open") && servicetype.equals("Environmental Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc  limit "+offset+" ,"+rowsperpage +"");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc  limit "+offset+" ,"+rowsperpage +"");
}
}//All Environmental

if(rstatus.equals("Open") && servicetype.equals("Garbage Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc  limit "+offset+" ,"+rowsperpage +" ");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc  limit "+offset+" ,"+rowsperpage +"");
}
}//All garbage issue

if(rstatus.equals("Open") && servicetype.equals("Health Hazard"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc  limit "+offset+" ,"+rowsperpage +"");
}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc  limit "+offset+" ,"+rowsperpage +"");
}
}//All health hazard issue

if(rstatus.equals("Open") && servicetype.equals("Housing Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc  limit "+offset+" ,"+rowsperpage +"");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc  limit "+offset+" ,"+rowsperpage +"");


}
}//All housing issue

if(rstatus.equals("Open") && servicetype.equals("Noise Complaint"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc  limit "+offset+" ,"+rowsperpage +"");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc  limit "+offset+" ,"+rowsperpage +"");


}
}//All Noise complaint


if(rstatus.equals("Open") && servicetype.equals("Police Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc  limit "+offset+" ,"+rowsperpage +"");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc  limit "+offset+" ,"+rowsperpage +"");


}
}//All Police Issue


if(rstatus.equals("Open") && servicetype.equals("Pothole"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc  limit "+offset+" ,"+rowsperpage +"");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc  limit "+offset+" ,"+rowsperpage +"");


}
}//All Pothol

if(rstatus.equals("Open") && servicetype.equals("Redevelopement"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc  limit "+offset+" ,"+rowsperpage +"");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc  limit "+offset+" ,"+rowsperpage +"");

}
}//All Redevelopement

if(rstatus.equals("Open") && servicetype.equals("Signage Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc  limit "+offset+" ,"+rowsperpage +"");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc  limit "+offset+" ,"+rowsperpage +"");
}
}//All Signage issue

if(rstatus.equals("Open") && servicetype.equals("Transportation Problem"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc  limit "+offset+" ,"+rowsperpage +"");

}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc  limit "+offset+" ,"+rowsperpage +"");


}
}//All Transportation problem

if(rstatus.equals("Open") && servicetype.equals("Other"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID desc  limit "+offset+" ,"+rowsperpage +"");
}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Sent%' or RequestStatus like '%In Progress%' ) order by RequestID asc  limit "+offset+" ,"+rowsperpage +"");
}
}//All Other

//---for closed

if(rstatus.equals("Closed") && servicetype.equals("All"))
{
if(sortby.equals("Most Recent"))
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and (RequestStatus like '%Completed%' )  order by RequestID desc limit "+offset+" ,"+rowsperpage +"");
}
else
{
rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and (RequestStatus like '%Completed%' )  order by RequestID asc limit "+offset+" ,"+rowsperpage +"");
}
}

if(rstatus.equals("Closed") && servicetype.equals("Dangerous Condition"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc limit "+offset+" ,"+rowsperpage +"");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc limit "+offset+" ,"+rowsperpage +"");
}
}//second closed

if(rstatus.equals("Closed") && servicetype.equals("Environmental Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc limit "+offset+" ,"+rowsperpage +" ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc limit "+offset+" ,"+rowsperpage +"");
}
}//Closed Environmental


if(rstatus.equals("Closed") && servicetype.equals("Garbage Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc limit "+offset+" ,"+rowsperpage +" ");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc limit "+offset+" ,"+rowsperpage +"");
}
}//Closed garbage issue

if(rstatus.equals("Closed") && servicetype.equals("Health Hazard"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc limit "+offset+" ,"+rowsperpage +"");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc limit "+offset+" ,"+rowsperpage +"");
}
}//Closed health hazard issue

if(rstatus.equals("Closed") && servicetype.equals("Housing Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc limit "+offset+" ,"+rowsperpage +"");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc limit "+offset+" ,"+rowsperpage +"");
}
}//Closed housing issue


if(rstatus.equals("Closed") && servicetype.equals("Noise Complaint"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc limit "+offset+" ,"+rowsperpage +"");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc limit "+offset+" ,"+rowsperpage +"");
}
}//Closed Noise complaint


if(rstatus.equals("Closed") && servicetype.equals("Police Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc limit "+offset+" ,"+rowsperpage +"");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc limit "+offset+" ,"+rowsperpage +"");
}
}//Closed Police Issue

if(rstatus.equals("Closed") && servicetype.equals("Pothole"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc limit "+offset+" ,"+rowsperpage +"");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc limit "+offset+" ,"+rowsperpage +"");
}
}//Closed Pothol

if(rstatus.equals("Closed") && servicetype.equals("Redevelopement"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc limit "+offset+" ,"+rowsperpage +"");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc limit "+offset+" ,"+rowsperpage +" ");
}
}//Closed Redevelopement

if(rstatus.equals("Closed") && servicetype.equals("Signage Issue"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc limit "+offset+" ,"+rowsperpage +"");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc limit "+offset+" ,"+rowsperpage +"");
}
}//Closed Signage issue


if(rstatus.equals("Closed") && servicetype.equals("Transportation Problem"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc limit "+offset+" ,"+rowsperpage +"");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc limit "+offset+" ,"+rowsperpage +"");
}
}//Closed Transportation problem

if(rstatus.equals("Closed") && servicetype.equals("Other"))
{
if(sortby.equals("Most Recent"))
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID desc limit "+offset+" ,"+rowsperpage +"");
}
else
{
 rs=stmt.executeQuery("Select * from Requests where CityID="+cityid+" and RequestType='"+servicetype+"' and (RequestStatus like '%Completed%' ) order by RequestID asc limit "+offset+" ,"+rowsperpage +"");
}
}//Closed Other




if(pagenum>=1&&pagenum<=total_pages)
{
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
      out.write("  <div class='well-inverted' style='margin-top:10px'>");
      out.write("             <li class='media'>");

       out.write("      <a class='pull-right' href='GetRequestDetailsOnClick?reqid="+rid+"' title='"+requesttype+"'>");
         out.write(" <img class='media-object'   style='width: 100px; height: 100px;' src='User/"+"/requests/"+photo+"'>");
         out.write("       </a>");
          out.write("      <div class='media-body' style='margin-left:10px;margin-top:10px;font-family:Cambria, Hoefler Text, Liberation Serif, Times, Times New Roman, serif' >");
            out.write("<h4 class='media-heading'><a  href='GetRequestDetailsOnClick?reqid="+rid+"' title='"+requesttype+"' style='text-decoration:none'>"+requesttype+"</a>");
             out.write("    <span class='request-time' >");
             out.write("<time class='timeago' datetime='"+reqdate+"'>");
             out.write(reqdate);
out.write("</time>");
out.write("</span>");
   out.write(" </h4>");
   out.write(requestdesc);
                   
  out.write("<p class='text-info' style='margin-top:5px'>");
         out.write("<span class='text-success' rel='tooltip' title='Status of request'><span class='icon-check'></span>   "+ status+".</span></p>");
          out.write("<div class='request-meta' style='margin-top:0px'>");
            out.write("<small>");
             out.write("<span class='icon-user'></span>");
           out.write("<a href='#' style='text-decoration:none'>"+un+"</a>");
             out.write("</small>");
             out.write("<small>");
           out.write("<span class='icon-map-marker'></span>");
          out.write("<span data-feed='address'>"+rloc+".</span>");
          out.write("</small>");
           out.write("</div>");
                 
                 
           out.write("     </div>");
               
             out.write(" </li>");
              
              out.write(" </div>");
    }

}
System.out.println("---end get fileterd issuse---");
}
catch(Exception e)
{
System.out.println("get filreed"+e);
}

		
	}

}
