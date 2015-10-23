import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetRequestDetailsOnClick extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
                                 response.setContentType("text/html"); 
     response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
                                 HttpSession session=request.getSession();
                                 String user=(String)session.getAttribute("user");
                                
                                 String rid=request.getParameter("reqid");
                                 int rcid=0;
                                 PrintWriter out = response.getWriter();
		String run=null;
                                     String rtype=null;
  String rdate=null;
                                    String rdesc=null;
	                  String rphoto=null;
	                  String rstatus=null;
                                     String rcityname=null;
String un=null;
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			   final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";

			   //  Database credentials
			   final String USER = "root";
			   final String PASS = "pooja";
		try{   
		Class.forName(JDBC_DRIVER);
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from Requests where RequestID='"+rid+"' ");
		if(rs.next())
		{
		 run=rs.getString("Username");
                                    rcid=rs.getInt("CityID");
                                     rtype=rs.getString("RequestType");
                                    
                                     Date reqdate=rs.getDate("RequestDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMMMMMMMMMM-yyyy");
         rdate=dateFormat.format(reqdate);
                                     rdesc=rs.getString("RequestDescription");
	                   rphoto=rs.getString("RequestPhoto");
	                  rstatus=rs.getString("RequestStatus");
                           System.out.println(rstatus);
         
                                       }
                                rs= stmt.executeQuery("select City from City where CityID='"+rcid+"' ");   

                                   if(rs.next())
	                {
		rcityname=rs.getString("City");
                                   }
                                 if(user== null)
                                 {
                                  //Description when no user is present
                                    		
out.println("<!DOCTYPE html>");
out.println("<html lang='en'>");
out.println("  <head>");
out.println(" <meta charset='utf-8'>");
  out.println("  <meta name='viewport' content='width=device-width, initial-scale=1.0 '>");
  out.println("  <meta name='description' content=''>");
 out.println("   <meta name='author' content=''>");
  out.println("  <meta http-equiv='pragma' content='no-cache'> ");
out.println("<meta http-equiv'expires' content='0'>"); 

out.println("<meta http-equiv='cache-control'  content='no-cache' > ");
 out.println("<link rel='shortcut icon' href='images/repair_icon.png'>");
   
   



   out.println(" <title>Welcome to your profile </title>");
     
     
   
  out.println("  <link href='css/dist/css/bootstrap.css' rel='stylesheet'>");
 out.println("  <link href='css/icon.css'  rel='stylesheet'>");
 out.println("   <link href='css/RequestStyle.css' rel='stylesheet'>");
    
    out.println("<link href='css/sticky-footer-navbar.css' rel='stylesheet'>");
    
	
    
	
 
        
   out.println(" <script src='css/assets/js/html5shiv.js'></script>");
     out.println("<script src='css/assets/js/respond.min.js'></script>");
      
        out.println("   <script src='css/js/ExternalJS.js'></script>");
   
   
  out.println("  </head>");





  out.println("  <body >");
  






  out.println("    <!-- Wrap all page content here -->");
  out.println("    <div id='wrap'>");

       out.println(" <!-- static navbar -->");
  out.println("<div class='navbar navbar-inverse navbar-static-top ' style='background-color:rgb(22, 35, 52);color:#CCC;margin-bottom:0px'>");
      out.println("  <div class='container'>");
        out.println("  <div class='navbar-header' >");
          out.println("  <button type='button' class='navbar-toggle' data-toggle='collapse' data-target='.navbar-collapse'>");
              out.println("  <span class='icon-bar'></span>");
              out.println("  <span class='icon-bar'></span>");
                out.println("<span class='icon-bar'></span>");
              out.println("</button>");
              out.println("<a class='navbar-brand' href='index.jsp'>Home</a>");
            
           
               
            
            
            
            out.println("</div>");
         out.println(" <div class='collapse navbar-collapse'>");
          
            out.println("<!--Seach form-->");
            out.println(" <form class='navbar-form  navbar-left' action='/search' method='get'>"); 
            
               
             out.println("<input type='text'  spellcheck='false'  placeholder='Search places' class='form-control'  style='border-radius:15px;' required>");
          
          out.println("</form>");
          out.println("<!--End of search form-->");
          
            out.println("   <ul class='nav navbar-nav navbar-right'>");
            out.println("  <li><a href='newrequest.jsp'><span class='iconfix-fix'></span>  New Request</a></li>"); 
            out.println(" <li class=;dropdown'>");
            out.println("   <a href='#' class='dropdown-toggle' data-toggle='dropdown'><span class='icon-user  icon-white'></span> Login </a>");
              
              

           out.println("      <ul class='dropdown-menu  open' role='menu'  style='border-radius:10px;width:280px;' >");
                
                                 
                    
                    
                                        
                                    
                                   
                      out.println(" <form class='navbar-form navbar-left' method='post' action='./login'name='loginform' role='search'  style='padding-left:20px;' >");
                                         
                                            
                                         out.println("     <fieldset>");
                                          out.println("   <div class='form-group'>");
                                           out.println("   <a  class='btn btn-primary' href='#' style='margin-bottom:10px'>Login with facebook</a>");
                                         out.println("   </div>");
                                          
                                     out.println("        <div class='form-group'>");
          out.println("<input type='text' name='login_username'  autocomplete='off' class='form-control' placeholder='Username' style='margin-bottom:10px'>");
                                           out.println("  </div>");
                                            
                                          out.println("   <div class='form-group'>");
                                                                                
                                           out.println("  <input type='password' autocomplete='off'  name='login_password'  class='form-control' placeholder='Password' style='margin-bottom:10px'>");
                                            out.println(" </div>");
                                            
                                          out.println("  <br>");
                                        out.println("   <div class='form-group'>");
                                      out.println("    <button type='submit' class='btn btn-primary' style='margin-bottom:10px' value='Submit'>Submit</button>");
                                          
                                          out.println(" </div>");
                                           
                                          
                                           out.println(" <div class='form-group'>");
                                         out.println("  <a href='ForgotPassword.jsp' class='text-primary' style='font-size:10px'>Forgot password?</a>");
                                          out.println(" </div>");
                                      
                                      out.println(" </fieldset>");
                                      out.println(" </form>");
                                      
                        
            out.println("      </ul>");
             
          out.println("   </li>");
            out.println(" <li><a href='SignUp.jsp'>Sign Up</a></li>");
            
          out.println(" </ul>");
         out.println("  </div><!--/.nav-collapse -->");
       out.println("  </div>");
      out.println(" </div><!--navbar closed-->");
out.println("     <!-- Begin page content -->");
          out.println("  <div class='container' >");
           
            out.println("<div class='row'>");
          
  out.println("<div class='col-lg-8'>");
  out.println("<h2>"+rtype+"</h2>");
  out.println("<div class='panel'>");
  out.println("<div class='panel-heading'>");
  out.println("<a href='#'>"+run+"</a> submitted an issue to <a href='GetCityDetails?cid="+rcid+"'>"+rcityname+"</a>");
  out.println("<span class='text-muted' ><time class='request-time'  title="+rdate+">"+rdate+"</time></span>");
  out.println("</div>");


  out.println("<div class='panel-body'>");
  out.println("<div class='row'>");

  out.println("<div class='col-lg-8'>");
  out.println("<span data-request='description'>");
 out.println(rdesc);
out.println(rstatus);
  out.println("</span>");
  out.println("</div><!--Col-lg-8-->");
  out.println("<div class='col-lg-4'>");
  out.println("<img class='img-responsive' src='User/"+"/requests/"+rphoto+"' title='"+rtype+"'>");
 out.println("</div>");

 out.println("</div><!--row-->");
 out.println("</div><!--panel body-->");

 out.println("<div class='panel-footer'>");




if(rstatus.toLowerCase().equals("sent"))
{
 out.println("<span class='control-label text-success'>Sent</span>");
out.println("<span class='icon-check'></span>");
}
if(rstatus.toLowerCase().contains("progress"))
{
out.println("<span class='control-label text-success'>Sent</span>");
out.println("<span class='icon-check'></span>");
out.println("<span class='control-label text-success' style='margin-left:4px'>In progress</span>");
out.println("<span class='icon-check '></span>");
}
if(rstatus.toLowerCase().contains("completed"))
{
out.println("<span class='control-label text-success'>Sent</span>");
out.println("<span class='icon-check'></span>");
out.println("<span class='control-label text-success' style='margin-left:4px'>In progress</span>");
out.println("<span class='icon-check '></span>");
out.println("<span class='control-lab text-success' style='margin-left:4px'>Completed</span>");
out.println("<span class='icon-check'></span>");
}
if(rstatus.toLowerCase().contains("rejected"))

{

out.println("<span class='control-label text-success'>Rejected</span>");
out.println("<span class='icon-check'></span>");
}

out.println("</div>");
out.println("</div><!--panel-->	");

out.println("</div><!--col-lg-8 main-->");




out.println("</div>");
          
out.println("<button class='btn btn-default' id='gobackbtn' onClick='goBack()' ><span class='icon-backward'></span> Go to previous page</button>");
   
   out.println("     </div> <!--container closed-->");
          
        
        
        
        
    out.println(" </div><!--Wrap closed-->");
    
    out.println("<div id='footer' style='background-color:rgb(22, 35, 52);color:#FFF' >");
    out.println("      <div class='panel-footer'  style='background-color:rgb(22, 35, 52);color:#FFF'>");
        out.println("   <p> 2013 Civic Engagement");
        out.println("   </p>");
        out.println("  </div>");
        out.println("  </div>");
    
       
    
      
       
    out.println("    <script src='css/assets/js/jquery.js'></script>");
      out.println("  <script src='css/dist/js/bootstrap.min.js'></script>");
     out.println(" </body>");
  out.println("  </html>");
                                  



                                 }
	              
                                else
                                   {
		
out.println("<!DOCTYPE html>");
out.println("<html lang='en'>");
out.println("  <head>");
out.println(" <meta charset='utf-8'>");
  out.println("  <meta name='viewport' content='width=device-width, initial-scale=1.0 '>");
  out.println("  <meta name='description' content=''>");
 out.println("   <meta name='author' content=''>");
  out.println("  <meta http-equiv='pragma' content='no-cache'> ");
out.println("<meta http-equiv'expires' content='0'>"); 

out.println("<meta http-equiv='cache-control'  content='no-cache' > ");
 out.println("<link rel='shortcut icon' href='images/repair_icon.png'>");
   
   



   out.println(" <title>Welcome to your profile </title>");
     
     
   
  out.println("  <link href='css/dist/css/bootstrap.css' rel='stylesheet'>");
 out.println("  <link href='css/icon.css'  rel='stylesheet'>");
 out.println("   <link href='css/RequestStyle.css' rel='stylesheet'>");
    
    out.println("<link href='css/sticky-footer-navbar.css' rel='stylesheet'>");
    
	
    
	
 
        
   out.println(" <script src='css/assets/js/html5shiv.js'></script>");
     out.println("<script src='css/assets/js/respond.min.js'></script>");
      
        out.println("   <script src='css/js/ExternalJS.js'></script>");
   
   
  out.println("  </head>");





  out.println("  <body >");
  






  out.println("    <!-- Wrap all page content here -->");
  out.println("    <div id='wrap'>");

       out.println(" <!-- static navbar -->");
  out.println("<div class='navbar navbar-inverse navbar-static-top ' style='background-color:rgb(22, 35, 52);color:#CCC;margin-bottom:0px'>");
      out.println("  <div class='container'>");
        out.println("  <div class='navbar-header' >");
          out.println("  <button type='button' class='navbar-toggle' data-toggle='collapse' data-target='.navbar-collapse'>");
              out.println("  <span class='icon-bar'></span>");
              out.println("  <span class='icon-bar'></span>");
                out.println("<span class='icon-bar'></span>");
              out.println("</button>");
              out.println("<a class='navbar-brand' href='index.jsp'>Home</a>");
            
           
               
            
            
            
            out.println("</div>");
         out.println(" <div class='collapse navbar-collapse'>");
          
            out.println("<!--Seach form-->");
            out.println(" <form class='navbar-form  navbar-left' action='/search' method='get'>"); 
            
               
             out.println("<input type='text'  spellcheck='false'  placeholder='Search places' class='form-control'  style='border-radius:15px;' required>");
          
          out.println("</form>");
          out.println("<!--End of search form-->");
          
            out.println("   <ul class='nav navbar-nav navbar-right'>");
            out.println("  <li><a href='newrequest.jsp'><span class='iconfix-fix'></span>  New Request</a></li>");
              out.println("<!--<li  ><a href='#'  >Login</a></li>-->");
            out.println(" <li class='dropdown'>");
               out.println(" <a href='#' class='dropdown-toggle' data-toggle='dropdown'><span class='icon-user  icon-white'></span> User</a>");
              
              
    out.println("<!-- Link or button to toggle dropdown -->");
          out.println("        <ul class='dropdown-menu  open' role='menu'  style='border-radius:10px;' >");
                
                                 
                    
                    
                                        
                                    
                                   
                                                                         
                                           
                  out.println("<div class='form-group' style='margin:1px'>");
                       out.println(" <form action='/CivicEngagement/logout' method='post' >");
                                           out.println("<input type='submit'  class='btn btn-link' value='Logout' style='text-decoration:none'>");
                                     out.println("         </form>");
                                             out.println(" </div>");
                                          out.println("  <div class='form-group' style='margin:1px'>");
                                              out.println(" <a  class='btn ' href='UserProfile.jsp' >My Account</a>");
                                            out.println("  </div>");
                                          
                                            
                                            
                                            
                                      
                        
                out.println("   </ul>");
              
          out.println("  </li> ");
           
            
           out.println(" </ul>");
           out.println(" </div><!--/.nav-collapse -->");
        out.println("  </div>");
        out.println("</div><!--navbar closed-->");
     
      
           
           
           
           
       out.println("     <!-- Begin page content -->");
          out.println("  <div class='container' >");
           
            out.println("<div class='row'>");
          
  out.println("<div class='col-lg-8'>");
  out.println("<h2>"+rtype+"</h2>");
  out.println("<div class='panel'>");
  out.println("<div class='panel-heading'>");
  out.println("<a href='#'>"+run+"</a> submitted an issue to <a href='GetCityDetails?cid="+rcid+"'>"+rcityname+"</a>");
  out.println("<span class='text-muted' ><time class='request-time'  title="+rdate+">"+rdate+"</time></span>");
  out.println("</div>");


  out.println("<div class='panel-body'>");
  out.println("<div class='row'>");

  out.println("<div class='col-lg-8'>");
  out.println("<span data-request='description'>");
 out.println(rdesc);
  out.println("</span>");
  out.println("</div><!--Col-lg-8-->");
  out.println("<div class='col-lg-4'>");
  out.println("<img class='img-responsive' src='User/"+"/requests/"+rphoto+"' title='"+rtype+"'>");
 out.println("</div>");

 out.println("</div><!--row-->");
 out.println("</div><!--panel body-->");

 out.println("<div class='panel-footer'>");

if(rstatus.toLowerCase().equals("rejected"))
{
 out.println("<span class='control-label text-danger'>Rejected</span>");
out.println("<span class='icon-check'></span>");
}
if(rstatus.toLowerCase().equals("sent"))
{
 out.println("<span class='control-label text-success'>Sent</span>");
out.println("<span class='icon-check'></span>");
}
if(rstatus.toLowerCase().contains("progress"))
{
out.println("<span class='control-label text-success'>Sent</span>");
out.println("<span class='icon-check'></span>");
out.println("<span class='control-label text-success' style='margin-left:4px'>In progress</span>");
out.println("<span class='icon-check '></span>");
}
if(rstatus.toLowerCase().contains("completed"))
{
out.println("<span class='control-label text-success'>Sent</span>");
out.println("<span class='icon-check'></span>");
out.println("<span class='control-label text-success' style='margin-left:4px'>In progress</span>");
out.println("<span class='icon-check '></span>");
out.println("<span class='control-lab text-success' style='margin-left:4px'>Completed</span>");
out.println("<span class='icon-check'></span>");
}


out.println("</div>");
out.println("</div><!--panel-->	");

out.println("</div><!--col-lg-8 main-->");




out.println("</div>");
          
out.println("<button class='btn btn-default' id='gobackbtn' onClick='goBack()' ><span class='icon-backward'></span> Go to previous page</button>");
   
   out.println("     </div> <!--container closed-->");
          
        
        
        
        
    out.println(" </div><!--Wrap closed-->");
    
    out.println("<div id='footer' style='background-color:rgb(22, 35, 52);color:#FFF' >");
    out.println("      <div class='panel-footer'  style='background-color:rgb(22, 35, 52);color:#FFF'>");
        out.println("   <p> 2013 Civic Engagement");
        out.println("   </p>");
        out.println("  </div>");
        out.println("  </div>");
    
       
    
      
       
    out.println("    <script src='css/assets/js/jquery.js'></script>");
      out.println("  <script src='css/dist/js/bootstrap.min.js'></script>");
     out.println(" </body>");
  out.println("  </html>");
    


                 		}
		
		
		stmt.close();
		con.close();
		}
		catch(Exception e)
		{
			
	    e.printStackTrace();
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("path is :::::" + request.getContextPath());
		

		

	}

}