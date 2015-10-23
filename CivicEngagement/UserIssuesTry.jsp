
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="java.sql.*" %>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.output.*" %>
<% String mobUser=request.getParameter("mobUser");

System.out.println("Mobile user isuues"+mobUser);

%>



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
	
   <script>
   
  
	   var mob="<%= mobUser%>";
	   alert (mob);
$(function(){
	
   var page = 1;
   var pages = $("#pages").val(); //TOTAL NUMBER OF PAGES
//alert(page);
//alert(pages);
  var xmlhttp;

if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
 // alert(xmlhttp.responseText);
    $("#content").html(xmlhttp.responseText);
    }
  }
xmlhttp.open("POST","GetMobileUserIssues?mobUser="+mob);
xmlhttp.send();

  
if(page==pages){
         $("#loadmore").remove(); //IF ALL PAGES ARE LOADED, THE BUTTON WILL BE REMOVED
       }


   //WHEN THE 'LOAD MORE' BUTTON IS PRESSED
   $("#loadmore").live("click", function(){
     var next = page+=1;
  //  alert (page);
    //alert(next);
     
 var xmlhttp;

if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {

	$('.animation_image').show();
   //alert(xmlhttp.responseText);
    $("#content").append(xmlhttp.responseText);
	 $("html, body").animate({ scrollTop: $(document).height() }, "slow");
$('.animation_image').hide();
	
    }
  }
xmlhttp.open("POST","GetMobileUserIssues?page="+next+"&mobUser="+mob,true);
xmlhttp.send();



       if(next==pages){
         $("#loadmore").remove(); //IF ALL PAGES ARE LOADED, THE BUTTON WILL BE REMOVED
       }

       $("#content").append(data); //LOADS THE NEW PAGE OF CONTENT UNDER THE REST
    
   });


});
   
   </script>
   
   




   
   
  </head>





  <body >
  


<%
 response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
//allow access only if session exists
String user =mobUser;
System.out.println("user"+user);




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
finally{
	//do nothing
}


%>






   



    <!-- Wrap all page content here -->
    <div id="wrap">

      <!-- static navbar -->
      
     
      
      
      
      <!-- Begin page content -->
     
    

<div class="container">



 
  
  
  


  
   
    
    
   
  
      
      
      
    
      
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
    
    
    
    <!--<div class="tab-pane" id="tab4">
      <p>Show suggested neighbours</p>
    
    </div>-->
    
    
    
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
     
    
     








    
 </div><!--Wrap closed-->

<div id="footer" style="background-color:rgb(22, 35, 52);color:#FFF">
      <div class="panel-footer" style="background-color:rgb(22, 35, 52);color:#FFF;">
       <p>© 2013 CivicEngagement
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
