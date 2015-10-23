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


public class TryMobile extends HttpServlet {
   
   private boolean isMultipart;
   private String filePath;
   private int maxFileSize = 5*1024 * 1024;
   private int maxMemSize = 4 * 1024;
   private File file ;

   public void init( ){
      // Get the file location where it would be stored.
      filePath = 
             getServletContext().getInitParameter("mobilefile-upload"); 
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
       //HttpSession session=request.getSession();
        //String user=(String)session.getAttribute("user");  

File dir=new  File(filePath+"\\"+"requests"+"\\");

if(dir.exists()==false)
{
dir.mkdirs();
}

MultipartRequest  req=new  MultipartRequest(request, filePath+"\\"+"requests"+"\\");

String k=req.getParameter("krishna");
System.out.println("krishna"+k);




  String filename="";
      if( !isMultipart ){
         
         return;
      }
      
       
       
       

    
		
		
  
   }
   public void doGet(HttpServletRequest request, 
                       HttpServletResponse response)
        throws ServletException, java.io.IOException {
        
        throw new ServletException("GET method used with " +
                getClass( ).getName( )+": POST method required.");
   } 
}