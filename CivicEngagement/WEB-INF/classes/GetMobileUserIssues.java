

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
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class SignUpValidation
 */
public class GetMobileUserIssues extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMobileUserIssues() {
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
response.sendRedirect("LoginPage.jsp");
}

			   final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";
  int pagenum;
PrintWriter out=response.getWriter();
int total_nums=0;
int total_pages=0;
int rowsperpage=0 ;
int offset=0;
ResultSet rs;
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

}
else
{
pagenum=1;
//out.println("in result null"+pagenum);

}

try
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(DB_URL, "root", "pooja"); 

stmt = con.createStatement();

rs=stmt.executeQuery("Select * from Requests where username='"+user+"' ");
rs.last();

total_nums=rs.getRow();

//out.println(total_nums);
total_pages= (int)Math.ceil(total_nums/rowsperpage);

if(total_nums%4!=0)
{
total_pages+=1;
}
offset=(pagenum-1)*rowsperpage;
//out.println("Select * from content limit "+offset+" ,"+rowsperpage +" ");
 rs=stmt.executeQuery("Select * from Requests where username='"+user+"'  limit "+offset+" ,"+rowsperpage +" ");

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
        //Date rdate=rs.getDate("RequestDate");
        String reqdate=rs.getString("RequestDate");
        int timedifference=0;
        PreparedStatement ps=con.prepareStatement("SELECT TIMESTAMPDIFF(hour,'"+reqdate+"',now()) as timediff");
                           ResultSet timediff=ps.executeQuery();
                           if(timediff.next()) 
                           {
                               timedifference=timediff.getInt("timediff");
                           }
        System.out.println("timediff"+timedifference);
        String sdays;
        int days=timedifference/24;
        if(days>0){
         sdays=""+days+"\t"+"days ago.";
        }
        else if(timedifference==0)
        {
            sdays="Just now.";
        }
        else
        {
            sdays=""+timedifference+"hours ago.";  
        }
       // SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMMMMMMMMMM-yyyy");
        //String reqdate=dateFormat.format(rdate);
        
        
       String rloc=rs.getString("RequestLocation");
       String un=rs.getString("Username");
      out.write("  <div class='well-inverted' style='margin-top:10px'>");
      out.write(" <li class='media'>");

       out.write("<a class='pull-right' href='GetRequestDetailsOnClick?reqid="+rid+"' title='"+requesttype+"'>");
         out.write("<img class='media-object'   style='width: 100px; height: 100px;' src='User/"+"/requests/"+photo+"'>");
         out.write(" </a>");
          out.write("<div class='media-body' style='margin-left:10px;margin-top:10px;font-family:Cambria, Hoefler Text, Liberation Serif, Times, Times New Roman, serif' >");
            out.write("<h4 class='media-heading'><a  href='GetRequestDetailsOnClick?reqid="+rid+"' title='"+requesttype+"' style='text-decoration:none'>"+requesttype+"</a>");
             out.write("    <span class='request-time' >");
             out.write("<time class='timeago' datetime='"+reqdate+"'>");
             out.write(sdays);
out.write("</time>");
out.write("</span>");
   out.write(" </h4>");
   out.write(requestdesc);
                   
  out.write("<p class='text-info' style='margin-top:5px'>");
         if(status.contains("Rejected"))
{
out.write("<span class='text-danger' rel='tooltip' title='Status of request'><span class='icon-check'></span>   "+ status+".</span></p>");
}
else{
         out.write("<span class='text-success' rel='tooltip' title='Status of request'><span class='icon-check'></span>   "+ status+".</span></p>");
}
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

}
catch(Exception e)
{
System.out.println(e);
}

		
	}

}
