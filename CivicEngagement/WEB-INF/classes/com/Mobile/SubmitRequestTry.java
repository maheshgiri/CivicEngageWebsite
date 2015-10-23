

package com.Mobile;

// Import required java libraries
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//for date and time
import java.text.SimpleDateFormat;
import java.util.Calendar;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;
import com.oreilly.servlet.MultipartRequest;
public class SubmitRequestTry extends HttpServlet {
   
   private boolean isMultipart;
   private String filePath;
   private int maxFileSize = 5*1024 * 1024;
   private int maxMemSize = 4 * 1024;
   private File file ;

   public void init( ){
      // Get the file location where it would be stored.
      filePath = 
             getServletContext().getInitParameter("file-upload"); 
   }
   public void doPost(HttpServletRequest request, 
               HttpServletResponse response)
              throws ServletException, java.io.IOException {
      // Check that we have a file upload request
      isMultipart = ServletFileUpload.isMultipartContent(request);
      response.setContentType("text/html");
      java.io.PrintWriter out = response.getWriter( );
  //String temp1=request.getParameter("uploadimage");
//System.out.println("Image"+temp1);
  //Getting user in the session
     
        
File dir=new  File(filePath+"\\"+"requests"+"\\");

if(dir.exists()==false)
{
dir.mkdirs();
}

MultipartRequest  req=new  MultipartRequest(request, filePath+"\\"+"requests"+"\\");
System.out.println(req.getParameter("uploaded_file"));
String user=req.getParameter("user");
System.out.println("user "+user);

 String rtype=req.getParameter("requesttype");
String rloc1=req.getParameter("requestlocation");
String rloc=req.getParameter("locality");
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
//Logic for updating department ID
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

String rtitle=req.getParameter("requesttitle");
String rdesc=req.getParameter("requestdescription");
String remail=req.getParameter("requestemail");
String rimage=req.getFilesystemName("requestimage");
System.out.println(rimage+"rimage");
Calendar currentDate = Calendar.getInstance();
SimpleDateFormat dateFormatter= new SimpleDateFormat("dd-MMMMMMMM-yyyy ");
 SimpleDateFormat timeFormatter=  new SimpleDateFormat("HH:mm:ss ");
String time = timeFormatter.format(currentDate.getTime());
  String date =  dateFormatter.format(currentDate.getTime());



  String filename="";
      if( !isMultipart ){
         
         return;
      }
      DiskFileItemFactory factory = new DiskFileItemFactory();
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
      // Location to save data that is larger than maxMemSize.
      factory.setRepository(new File("c:\\temp"));
       
       
       

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );
final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			   final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";

			   //  Database credentials
			   final String USER = "root";
			   final String PASS = "pooja";

      try{ 
        
      Class.forName(JDBC_DRIVER);
      Connection con = DriverManager.getConnection(DB_URL, USER, PASS);  
       Statement stmt=con.createStatement();       
      // Parse the request to get file items.
      List fileItems = upload.parseRequest(request);
	
      // Process the uploaded file items
      Iterator i = fileItems.iterator();
     
   


      String sql="insert into requests(RequestLocation,RequestTitle,RequestType,RequestDescription,RequestPhoto,Username,RequestDate,RequestTime,CityID,DepartmentID) values ('"+rloc1+"','"+rtitle+"','"+rtype+"','"+rdesc+"','"+rimage+"','"+user+"','"+date+"','"+time+"','"+cid+"','"+did+"')";
		int insert=stmt.executeUpdate(sql);
		if (insert>=0) {
			
		//out.println("record also in");	
          out.println("success");	
		}
		
		
   }//try
    catch(Exception ex) {
       out.println("fail");
     ex.printStackTrace();
   }
   }
   public void doGet(HttpServletRequest request, 
                       HttpServletResponse response)
        throws ServletException, java.io.IOException {
        
        throw new ServletException("GET method used with " +
                getClass( ).getName( )+": POST method required.");
   } 
}