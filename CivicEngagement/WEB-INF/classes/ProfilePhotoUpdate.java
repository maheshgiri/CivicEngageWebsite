// Import required java libraries
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.naming.SizeLimitExceededException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

public class ProfilePhotoUpdate extends HttpServlet {
   
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
      String temp1=request.getParameter("uploadimage");
System.out.println("Image"+temp1);
      if( !isMultipart ){
         
         return;
      }
      DiskFileItemFactory factory = new DiskFileItemFactory();
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
      // Location to save data that is larger than maxMemSize.
      factory.setRepository(new File("c:\\temp"));

       //Getting user in the session
       HttpSession session=request.getSession();
        String user=(String)session.getAttribute("user");  

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

      
      while ( i.hasNext () ) 
      {
         FileItem fi = (FileItem)i.next();
         if ( !fi.isFormField () )	
         {
            // Get the uploaded file parameters
            String fieldName = fi.getFieldName();
            String fileName = fi.getName();
            System.out.println(fileName);
             String temp[]= fileName.split("\\.");
             
           if(temp[1].equals("jpg")||temp[1].equals("jpeg")||temp[1].equals("jfif")||temp[1].equals("exif")||temp[1].equals("tiff")||temp[1].equals("jpg")||temp[1].equals("gif")||temp[1].equals("bmp")||temp[1].equals("png"))
{

            String contentType = fi.getContentType();
            boolean isInMemory = fi.isInMemory();
            long sizeInBytes = fi.getSize();
            // Write the file
            if( fileName.lastIndexOf("\\") >= 0 ){
        System.out.println("Before");
                file = new File( filePath + user+"\\"+"profile"+"\\") ;
              System.out.println("After");
               if (file.exists()==false) {
                file.mkdir();  
                System.out.println("Created fie");
                 }

                 if (file.exists()==true) {
                file.mkdirs();  
                System.out.println(" in trueCreated fie");
                 }
                
             
                 
                if(file.length()==0)
                {
                 file = new File( filePath + user+"\\"+"profile"+"\\"+ fileName.substring( fileName.lastIndexOf("\\"))) ;
                }
                else
{
                    
                String [] files=new String [10];
        
         files=file.list();
         for(int p=0;p<files.length;p++)
         {
             File f=new File(file,files[p]);
          
             f.delete();
         } 
                file = new File( filePath + user+"\\"+"profile"+"\\"+ fileName.substring( fileName.lastIndexOf("\\"))) ;
                 }
                
  
            }

else{
             file = new File( filePath + user+"\\"+"profile"+"\\") ;
              
               if (file.exists()==false) {
                file.mkdirs();  
              
                }
        if(file.length()==0)
{
                file = new File( filePath + user+"\\"+"profile"+"\\"+ fileName.substring( fileName.lastIndexOf("\\")+1)) ;
                
}
else
{
  String [] files1=new String [10];
        
         files1=file.list();
         for(int k=0;k<files1.length;k++)
         {
             File f=new File(file,files1[k]);
          
             f.delete();
         } 
 file = new File( filePath + user+"\\"+"profile"+"\\"+ fileName.substring( fileName.lastIndexOf("\\")+1)) ;
}
                 
            }
            fi.write( file ) ;
           String sql="Update  user  set Photo='"+fileName+"' where username='"+user+"' ";
		int insert=stmt.executeUpdate(sql);
		if (insert>=0) {
			
		//out.println("record also in");	
                                     response.sendRedirect("/CivicEngagement/UserProfile.jsp");	
		}
		else
		{
		response.sendRedirect("/CivicEngagement/UserProfileFileNotSupported.jsp");	
		}
}//check if close
else
{
response.sendRedirect("/CivicEngagement/UserProfileFileNotSupported.jsp");	
}		
           
         }//if
      }//while
      
   }//try
    catch(Exception ex) {
     //  System.out.println(ex);
        response.sendRedirect("/CivicEngagement/UserProfileFileNotSupportedSize.jsp");	
    System.out.println( ex.getMessage());
   }
     
   }
   public void doGet(HttpServletRequest request, 
                       HttpServletResponse response)
        throws ServletException, java.io.IOException {
        
        throw new ServletException("GET method used with " +
                getClass( ).getName( )+": POST method required.");
   } 
}