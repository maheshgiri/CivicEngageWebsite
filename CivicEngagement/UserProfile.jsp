
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="java.sql.*" %>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.output.*" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0 ">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="expires" content="0"> 

<meta http-equiv="cache-control"  content="no-cache" > 
 <link rel="shortcut icon" href="images/repair_icon.png">
   
   



    <title>Welcome to your profile </title>
     
     
    <!-- Bootstrap core CSS -->
    <link href="css/dist/css/bootstrap.css" rel="stylesheet">
   <link href="css/icon.css"  rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="css/sticky-footer-navbar.css" rel="stylesheet">
    
	<link rel="stylesheet" href="css/UserProfileStyle.css">
    
    

 
         <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
    
   

    <script src="css/assets/js/html5shiv.js"></script>
      <script src="css/assets/js/respond.min.js"></script>
      
      <script src="css/js/FunctionsInUserProfile.js"></script>
   
   
     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
  <script src="http://maps.googleapis.com/maps/api/js?sensor=false&amp;libraries=places"></script>


    <script src="Geolocation/jquery.geocomplete.js"></script>
   <script src="css/js/tooltip.js"></script>
    

 <script>
	  $( document ).ready(function() {
    $("[rel='tooltip']").tooltip();    
 
    $('.thumbnail').hover(
        function(){
            $(this).find('.caption').slideDown(250); //.fadeIn(250)
        },
        function(){
            $(this).find('.caption').slideUp(250); //.fadeOut(205)
        }
    ); 
});
	  </script>
	
   <script src="css/js/YourIssuesFunction.js"></script>
   
   

<script src="css/js/NearbyIssuesFunction.js"></script>


   
   
  </head>





  <body >
  


<%
 response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
//allow access only if session exists
String user = null;
user=(String)session.getAttribute("user");
System.out.println("Current usr"+user);

if(session.getAttribute("user") == null){
    System.out.println("in user profile"+session.getAttribute("user"));
    response.sendRedirect("/CivicEngagement/LoginPage.jsp");
}



Statement stmt3;
Connection con3;
ResultSet rs3;
String url3 = "jdbc:mysql://localhost/CivicEngagement";
int total_nums=0;
int total_page=0;
//out.println(total_nums);


int rowsperpage=4;




try
{
Class.forName("com.mysql.jdbc.Driver");
con3 = DriverManager.getConnection(url3, "root", "pooja"); 

stmt3 = con3.createStatement();


 rs3=stmt3.executeQuery("Select * from Requests where username='"+user+"' ");
 rs3.last();

total_nums=rs3.getRow();
//out.println("total"+total_nums);
 total_page= (int)Math.ceil(total_nums/rowsperpage);
if(total_nums%4!=0)
{
total_page+=1;
}
//out.println( "total page"+total_page);

}
catch(Exception e)
{
System.out.println("Exception occured is:"+e);
}
 


%>
<%
//For Nearby issues

Statement stmt4;
Connection con4;
ResultSet rs4;
String url4 = "jdbc:mysql://localhost/CivicEngagement";
int total_nums_nearby_issues=0;
int total_page_nearby_issues=0;
//out.println(total_nums);
String cityname=null;
String tempcity=null;
int rowsperpage_nearby_issues=4;
int tempcityid=0;



try
{
Class.forName("com.mysql.jdbc.Driver");
con4 = DriverManager.getConnection(url4, "root", "pooja"); 








stmt4 = con4.createStatement();
rs4=stmt4.executeQuery("select city from user where username='"+user+"'");

 
 
 
 if(rs4.next())
 {
	 cityname=rs4.getString("City");
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
 
 rs4=stmt4.executeQuery("Select CityID from city where city like '"+tempcity+"' ");
 if(rs4.next())
 {
	 tempcityid=rs4.getInt("CityID");
 }
 //out.println(tempcityid);
 rs4=stmt4.executeQuery("Select * from Requests where CityID='"+tempcityid+"' ");
 rs4.last();

total_nums_nearby_issues=rs4.getRow();
//out.println("tota_nearby_issues"+total_nums_nearby_issues);
 total_page_nearby_issues= (int)Math.ceil(total_nums_nearby_issues/rowsperpage_nearby_issues);
if(total_nums_nearby_issues%4!=0)
{
total_page_nearby_issues+=1;
}
//out.println( "total page_nearby_issues"+total_page_nearby_issues);

}
catch(Exception e)
{
System.out.println("Exception occured is:"+e);
}


%>


<jsp:declaration>

Statement stmt;
Connection con;

String url = "jdbc:mysql://localhost/CivicEngagement";
String fn,ln,email,city,addr,mob,zip,pass;

</jsp:declaration>

<jsp:scriptlet>
user=(String)session.getAttribute("user");
System.out.println("Current usr"+user);
try
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(url, "root", "pooja"); 

stmt = con.createStatement();


ResultSet rs=stmt.executeQuery("Select Password,Firstname,Lastname,Email,City,Address,Mobile,Zipcode from user where username='"+user+"' ");

if(rs.next())
{
fn=rs.getString("Firstname");
ln=rs.getString("Lastname");
email=rs.getString("Email");
city=rs.getString("City");
addr=rs.getString("Address");
mob=rs.getString("Mobile");
zip=rs.getString("Zipcode");
pass=rs.getString("Password");
}


}
catch(Exception e)
{
System.out.println("Exception occured is:"+e);
}

</jsp:scriptlet>


<script src="css/js/PasschangeFunction.js"></script>
   

<jsp:declaration>
Statement stmt1;
Connection con1;

String url1 = "jdbc:mysql://localhost/CivicEngagement";
String filePath=null;
String fileName=null;
String source=null;
File file=null;
String photo;
</jsp:declaration>



<jsp:scriptlet>

source="images/UserPic.jpg";
user=(String)session.getAttribute("user");
System.out.println("Current usr"+user);
try
{
Class.forName("com.mysql.jdbc.Driver");
con1 = DriverManager.getConnection(url1, "root", "pooja"); 
stmt1 = con1.createStatement();

ResultSet rs1=stmt1.executeQuery("Select photo from user where username='"+user+"' ");

if(rs1.next())
{
photo=rs1.getString("Photo");

}
if(photo==null)
{
source="images/UserPic.jpg";
}
else
{
source="User"+"/"+user+"/"+"profile"+"/"+photo;
}
}
catch(Exception e)
{
System.out.println("Exception occured is:"+e);
}

//ServletContext context = pageContext.getServletContext();
//filePath = context.getInitParameter("file-upload");

//System.out.println(filePath+user+"\\");
//file=new File(filePath+user+"\\");

//if(file.exists())
//{
//source="User"+"/"+user+"/"+photo;
//}

</jsp:scriptlet>

    <!-- Wrap all page content here -->
    <div id="wrap">

      <!-- static navbar -->
      <div class="navbar navbar-inverse navbar-static-top " style="background-color:rgb(22, 35, 52);color:#CCC;margin-bottom:0px">
        <div class="container">
          <div class="navbar-header" >
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Home</a>
            
           
               
            
            
            
          </div>
          <div class="collapse navbar-collapse">
          
          <!--Seach form-->
           <form class="navbar-form  navbar-left" action="/search" method="get"> 
            
               
              <input type="text"  spellcheck="false"  placeholder="Search places" class="form-control"  style="border-radius:15px;" required>
          
        </form>
        <!--End of search form-->
          
             <ul class="nav navbar-nav navbar-right">
            <li><a href="newrequest.jsp"><span class="iconfix-fix"></span>  New Request</a></li>
            <!--<li  ><a href="#"  >Login</a></li>-->
           <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="icon-user  icon-white"></span> User</a>
              
              
  <!-- Link or button to toggle dropdown -->
                <ul class="dropdown-menu  open" role="menu"  style="border-radius:10px;" >
                
                                 
                    
                    
                                        
                                    
                                   
                                                                         
                                           
                                            <div class="form-group" style="margin:1px">
                                            <form action="/CivicEngagement/logout" method="post" >
                                            <input type="submit"  class="btn btn-link" value="Logout" style="text-decoration:none" >
                                            </form>
                                            </div>
                                          <div class="form-group" style="margin:1px">
                                             <a  class="btn " href="UserProfile.jsp" >My Account</a>
                                            </div>
                                          
                                            
                                            
                                            
                                      
                        
                 </ul>
              <!--<ul class="dropdown-menu">
               
               <form class="navbar-form " role="search"   action="#" >
                 <div class="form-group" style="border:5px">
                <input type="text" class="form-control" placeholder="Username" style="border-radius:10px">
                 </div>
                 <div class="form-group">
                <input type="text" class="form-control" placeholder="Password" style="border-radius:10px">
                 </div>
                 <hr>
                 <div class="form-group">
                <button type="submit" class="btn btn-primary">Submit</button>
                </div>
              </form>
              </ul>-->
            </li> 
           
            
          </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div><!--navbar closed-->
     
      
      
      
      <!-- Begin page content -->
     
    

<div class="container">



<div class="tabbable">
 
  <ul class="nav nav-tabs" id="myTab">
     <li class="active" ><a href="#tab1" data-toggle="tab"><span class="icon-home"></span>Dashboard</a></li>
    <li><a href="#tab2" data-toggle="tab" ><span class=" iconfix-black" on></span>Your Issues</a></li>
    <li><a href="#tab3" data-toggle="tab"><span class="iconfix-black"></span>Nearby Issues</a></li>
   <!-- <li><a href="#tab4" data-toggle="tab"><span class="icon-user"></span>Suggested Neighbours</a></li>-->
    <li ><a href="#tab5" data-toggle="tab"><span class="icon-edit" ></span>Change Password</a></li>
   
  </ul>
  
  


  <div class="tab-content">
   <div   class="tab-pane active " id="tab1" >
      <!--<p>
     
     Dashboard content.</br>
     Show profile picture.</br>
     Show Name of the user.</br>
     Show city to which user belongs.</br>
     Show Email Address of the user.</br>
     
     Show number of issues submitted.</br>
     Show number of issues served.</br>
     
      </p>-->
      
      <div class="row">
      <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3" >
     <img src="<%=source %>" alt="" class="img-rounded " id="photobox" style="margin-top:10px;height:150px" >
      </div>
      
      </div>
      
      <div class="row">
       <div class="col-lg-6 col-sm-6 " >
      <!--Photo upload-->
      <form method="post" action="./ProfilePhotoUpdate" enctype="multipart/form-data" >
      <input type="file" name="uploadimage" id="inputfile" style="visibility:hidden" onChange="clicksubmit()">
      <button type="button"  id="fileUploadButton" class="btn btn-primary"  onClick="getfile()" style="margin-bottom:10px" rel="tooltip" title="Click to upload photo">       <span class="icon-camera icon-white" ></span> Update Photo</button>
       <button type="submit" id="updatebtn" style="visibility:hidden"></button>
       
      </form>
      </div>
      </div>
      
      
      <form method="post" action="./UserDataUpdate" >

      <div class="row">
      <div class="col-lg-3 col-sm-8 col-md-3 col-xs-8">
      <input type="text" class=" form-control " style="margin-top:10px" name="firstnameupdate" placeholder="Firstname" id="firstnameid" value="<%=fn %>" required disabled>
      
      </div>
      <div class="col-lg-3 col-sm-8 col-md-3 col-xs-8">
      <input type="text" class=" form-control " name="lastnameupdate" placeholder="Lastname"  style="margin-top:10px" id="lastnameid" value="<%=ln %>"  required disabled>
      </div>
      </div>
      
      
       <div class="row">
      <div class="col-lg-3 col-sm-8 col-md-3 col-xs-8">
     <input type="text" class="form-control"  name="emailupdate" placeholder="Email"style="margin-top:10px" id="emailid" value="<%=email %>"   required disabled>
      </div>
            
      </div>
      <div class="row">
      <div class="col-lg-3 col-sm-8 col-md-3 col-xs-8">
      <input type="text" class="form-control" name="addressupdate" placeholder="Address" style="margin-top:10px" id="geocomplete" value="<%=addr %>"  required disabled>
      </div>
      <div class="col-lg-3 col-sm-8 col-md-3 col-xs-8">
      <input type="text" class="form-control " name="zipcodeupdate" placeholder="Zip code"  style="margin-top:10px"  id="zipcodeid" value="<%=zip %>"  onChange="zipcodevalidation()" required  disabled>
      <p class="text-danger" id="zipcodehint" hidden="hidden">Enter valid zip code</p>
      </div>
      </div>
       
      <div class="row">
      <div class="col-lg-3 col-sm-8 col-md-3 col-xs-8">
     <input type="text" class="form-control "  name="mobileupdate" placeholder="Mobile" style="margin-top:10px" id="mobileid" value="<%=mob %>" onChange="mobilevalidation()"  required  disabled>
      <p class="text-danger" id="mobilehint" hidden="hidden">Enter valid mobile number.</p>
      </div>
            
      </div>

	  <div class="row">
      <div class="col-lg-3 col-sm-8 col-md-3 col-xs-8">
     <input type="submit" value="Save" class="btn btn-primary" id="submitdatabtn" style="margin-top:10px" disabled>
     <input type="button"  value="Edit" id="editbtn" class="btn btn-primary"  rel="tooltip" title="Click here to edit" style="margin-top:10px"   onClick="EnableFields()">


      </div>
            
      </div>
  </form>
    </div>
    
    <div class="tab-pane" id="tab2">
     
     
     
        




           
      

   
     
      
      
      
    
      
      <div class="row col-lg-10">
      <h2>Issues you have submitted.</h2>
      <ul class="media-list" id="content">

      </ul>
<%
//out.println("Krishna");

if(total_nums==0)
{
%>
<a class="btn" href="newrequestuser.jsp">You have not  submitted any requests . Make first request.</a>
<%
}
%>

<%
if(total_nums>rowsperpage)
{
%>

<input  class="btn btn-block btn-info" id="loadmore" type="button" value="Click to load more"  style="font-family:Cambria, 'Hoefler Text', 'Liberation Serif', Times, 'Times New Roman', serif" >
<input id="pages" type="hidden" value="<%=total_page%>" >
<div class="animation_image" style="display:none;"><img src="images/ajax-loader.gif"> Loading...</div>

<%
}
%>
      
      
      
     
        
      </div><!--Row my issues closed-->
      
    </div><!-- tab closed-->
    
    <div class="tab-pane" id="tab3">
      
       <h2>Issues  submitted to your city.</h2>
      <div class="row col-lg-10">
      <ul class="media-list" id="nearbyissues">

      </ul>
<%
//out.println("Krishna");

if(total_nums_nearby_issues==0)
{
%>
<a class="btn" href="newrequestuser.jsp">You have not  submitted any requests . Make first request.</a>
<%
}
%>

<%
if(total_nums_nearby_issues>rowsperpage_nearby_issues)
{
%>

<input  class="btn btn-block btn-info" id="loadmore_nearby_issues" type="button" value="Click to load more"  style="font-family:Cambria, 'Hoefler Text', 'Liberation Serif', Times, 'Times New Roman', serif" >
<input id="pages_nearby_issues" type="hidden" value="<%=total_page_nearby_issues%>" >


<%
}
%>
      
      
      
     
        
      </div><!--Row nearby issues closed-->
      
      
      
    </div>
    
    <!--<div class="tab-pane" id="tab4">
      <p>Show suggested neighbours</p>
    
    </div>-->
    
    <div class="tab-pane " id="tab5">
     <!-- <p>Allow to change password.</p>-->
     
     
     
     
      <form method="post" action="./ChangePassword" >
     
    <!-- <div class="row">
      
     <div class="col-lg-2 col-sm-8 col-md-8 help-block">
     
     <label class="control-label">Change Password</label>
     <hr>
     </div>
     </div>-->
    
     <div class="row">
     
     
     <div class="col-lg-2 col-sm-8 col-md-8 help-block">
      <label class="control-label">Current Password</label>
     <input type="password" class="form-control" style="margin-top:10px"  placeholder="Current password" id="currentpassword" name="currentpass"  autocomplete="off" onChange="validateCurrentPassword()"  disabled required >
      <label class="text-danger" id="passwrong" hidden="hidden">Password is wrong.</label>
     </div>
     
     
     <div class="col-lg-2 col-sm-8 col-md-8 help-block">
     <label class="control-label">New Password</label>
     
     
     <input type="password" class="form-control"  style="margin-top:10px" placeholder="Minimun six characters"  id="newpassword" name="newpass"  onChange="passchangeval()" required>
      <label class="text-danger" id="lesspasslen" hidden="hidden">Password should have minimum six characters.</label>
     </div>
     <div class="col-lg-2 col-sm-8 col-md-8 help-block">
     <label class="control-label">Confirm Password</label>
     <input type="password" class="form-control" style="margin-top:10px"  placeholder="Minimun six characters" id="cnewpassword" name="cnewpass"  onChange="passchangeval()" required>
     <label class="text-danger" id="passdntmatch" hidden="hidden">Password don not match.</label>
     </div>
      
     </div>
     <div class="row">
     <div class="col-lg-2 col-sm-6 col-md-6 help-block">
     <input type="Submit"   class="btn btn-primary"  id="passchngsbmtbtn" value="Save" disabled >
     </div>
     </div>
         
    </form>
    <hr>
    
     <!--<div class="row">
      
     <div class="col-lg-2 col-sm-8 col-md-8 help-block">
     
     <label class="control-label">Deactivate account.</label>
     <hr>
     </div>
     </div>-->
    
     <!--<div class="row">
     <div class="col-lg-2 col-sm-6 col-md-6 help-block">
     <input type="submit" class="btn btn-danger" value="Deactivate account" >
     </div>
     </div>-->
    </div>
  
  </div>
</div>
</div>
     
    
     








    
 </div><!--Wrap closed-->

<div id="footer" style="background-color:rgb(22, 35, 52);color:#FFF">
      <div class="panel-footer" style="background-color:rgb(22, 35, 52);color:#FFF;">
       <p>© 2013 Civic Engagement
       </p>
       
      </div>
      </div>
   

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!--<script src="css/assets/js/jquery.js"></script>-->
    <script src="css/dist/js/bootstrap.min.js"></script>
  </body>
</html>
