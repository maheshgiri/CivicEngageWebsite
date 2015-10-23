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
   
    



    <title>FixStuff</title>
     
     
    <!-- Bootstrap core CSS -->
    <link href="css/dist/css/bootstrap.css" rel="stylesheet">
   <link href="css/icon.css"  rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="css/sticky-footer-navbar.css" rel="stylesheet">
    
	<style>
	@media(max-width:767px)
{    
.navbar-collapse {
     max-height: none;
}
}



 
	</style>
  
     <style>
	
.autocomplete-suggestions { border: 1px solid #999; background: #fff; cursor: default; overflow: auto; }
.autocomplete-suggestion { padding: 10px 5px; font-size: 1.2em; white-space: nowrap; overflow: hidden; font-family:Cambria, "Hoefler Text", "Liberation Serif", Times, "Times New Roman", serif }
.autocomplete-selected { background: #f0f0f0; }
.autocomplete-suggestions strong { font-weight: normal; color: #3399ff; }
 
.thumbnail {
    position:relative;
    overflow:hidden;
	height:200px;
}
 
.caption {
    position:absolute;
    bottom:-230px;
   
    width:100%;
    height:65%;
    
    background-color: rgba(0, 0, 0, 0.8);
    text-align:center;
    color:#fff !important;
    z-index:100;
	overflow:hidden;
-webkit-transition: all 0.8s ease;
-moz-transition: all 0.8s ease;
-o-transition: all 0.8s ease;

}
.thumbnail:hover> .caption
{
	
	bottom:0;
  
    
	
}

	</style>
    
<!--<style>
#loading {
background:url(http://loadinggif.com/images/image-selection/36.gif) no-repeat ;
height: 100px;
width: 100px;
position: fixed;
left: 50%;
top: 50%;
margin: -25px 0 0 -25px;
z-index: 1000;
}
</style>
-->   
    
 <!-- <script type="text/javascript">
$(window).load(function(){
  $("#loading").fadeOut("slow");
});

window.onload=document.getElementById("loading").hidden;
</script-->
    
         <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="css/assets/js/html5shiv.js"></script>
      <script src="css/assets/js/respond.min.js"></script>
       
        <script src="Cities-autocomplete/js/jquery.autocomplete.min.js"></script>
      <script src="Cities-autocomplete/js/currency-autocomplete.js"></script>
    
	 
      
       <script> 
	   
	    
    
    $( document ).ready(function() {
	
	 
  
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
    $(".RecentRequests").html(xmlhttp.responseText);
    }
  }
xmlhttp.open("POST","GetRecentIssuesForIndexPage");
xmlhttp.send();

  

});





</script>


  <script>
	  $( document ).ready(function() {
    $("[rel='tooltip']").tooltip();    
 
    
});
	
	  </script>    
   
  </head>

  <body>

<%
 response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
//allow access only if session exists

if(session.getAttribute("user") != null){
    response.sendRedirect("/CivicEngagement/indexuser.jsp");
}
%>
    <!-- Wrap all page content here -->
    <div id="wrap">
      
     <!-- <div id="loading"  ></div>
      -->
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
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="icon-user  icon-white"></span> Login </a>
              
              
  <!-- Link or button to toggle dropdown -->
                <ul class="dropdown-menu  open" role="menu"  style="border-radius:10px;width:280px;" >
                
                                 
                    
                    
                                        
                                    
                                   
                                     <form class="navbar-form navbar-left" method="post" action="./login" name="loginform" role="search"  style="padding-left:20px;" >
                                         
                                            
                                             <fieldset>
                                            <div class="form-group">
                                           
                                            </div>
                                          
                                            <div class="form-group">
                                            <input type="text" name="login_username"  autocomplete="off" class="form-control" placeholder="Username" style="margin-bottom:10px">
                                            </div>
                                            
                                            <div class="form-group">
                                                                                
                                            <input type="password" autocomplete="off"  name="login_password"  class="form-control" placeholder="Password" style="margin-bottom:10px">
                                            </div>
                                            
                                           <br>
                                          <div class="form-group">
                                         <button type="submit" class="btn btn-primary" style="margin-bottom:10px" value="Submit">Submit</button>
                                          
                                          </div>
                                           
                                          
                                           <div class="form-group">
                                          <a href="ForgotPassword.jsp" class="text-primary" style="font-size:10px">Forgot password?</a>
                                          </div>
                                      
                                      </fieldset>
                                      </form>
                                      
                        
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
            <li><a href="SignUp.jsp">Sign Up</a></li>
            
          </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div><!--navbar closed-->
      
       <div class="home">
    <div class="jumbotron" style="background-color:rgb(22, 35, 52);color:#CCC ;" >
    
    <div class="text-center">
    
  <h1>Get Stuff Fixed.</h1>
   <h3>Get Involved.</h3>
    
   
  
<!--
    <a class=" btn btn-primary btn-lg " href="#">Login with facebook</a>
    <br>
  
    <a class="btn btn-primary btn-lg" href="#">SignUp with facebook</a>-->
    
  
    
    </div><!-- center-dclosed-->
   
   
    </div>  <!-- jambotron closed-->
    </div>  <!-- Home closed-->
      <!-- Begin page content -->
      
      
      <div class="container">
<form  role="form" style="font-family:Cambria, 'Hoefler Text', 'Liberation Serif', Times, 'Times New Roman', serif;font-size:14px">
<div class="form-group">
<input type="text" class="form-control" placeholder="Search your city" id="autocomplete">
</div>
</form>

</div>

<div class="container">
<div class="row">
<h1 class="text-center">Explore your city</h1>
</div>

</div>
       <div class="container">
        <div class="row"> 
        
       
<div class=' col-lg-3 col-sm-4 col-md-4  col-xs-6'>            
<div class='thumbnail' style='height:200px'>
<div class='caption'>
<span class="icon-map-marker icon-white"></span><h4>Pune City</h4>


<a href='PuneCityUser.jsp' class='label label-success' >Explore your City</a>
</div>
<img class='img-responsive'  src='images/shivaji nagar.jpg' alt='Request photo'  style='height:200px'>
</div>
</div>


<div class=' col-lg-3 col-sm-4 col-md-4  col-xs-6'>            
<div class='thumbnail' style='height:200px'>
<div class='caption'>
<span class="icon-map-marker icon-white"></span><h4>Nanded City</h4>


<a href='NandedCityUser.jsp' class='label label-success'>Explore your City</a>
</div>
<img class='img-responsive'  src='images/hazoor_sahib_nanded.jpg' alt='Request photo'  style='height:200px'>
</div>
</div>

<div class=' col-lg-3 col-sm-4 col-md-4  col-xs-6'>            
<div class='thumbnail' style='height:200px'>
<div class='caption'>
<span class="icon-map-marker icon-white"></span><h4>Nashik City</h4>


<a href='NashikCityUser.jsp' class='label label-success'>Explore your City</a>
</div>
<img class='img-responsive'  src='images/Nashikcitypandavlene.jpg' alt='Request photo'  style='height:200px'>
</div>
</div>


<div class=' col-lg-3 col-sm-4 col-md-4  col-xs-6'>            
<div class='thumbnail' style='height:200px'>
<div class='caption'>
<span class="icon-map-marker icon-white"></span><h4>Aurangabad City</h4>


<a href='AurangabadCityUser.jsp' class='label label-success'>Explore your City</a>
</div>
<img class='img-responsive'  src='images/Ahilyabai_Holkar_Chowk.jpg' alt='Request photo'  style='height:200px'>
</div>
</div>


<div class=' col-lg-3 col-sm-4 col-md-4  col-xs-6'>            
<div class='thumbnail' style='height:200px'>
<div class='caption'>
<span class="icon-map-marker icon-white"></span><h4>Mumbai City</h4>


<a href='MumbaiCityUser.jsp' class='label label-success'>Explore your City</a>
</div>
<img class='img-responsive'  src='images/Worli_skyline_with_BSWL.jpg' alt='Request photo'  style='height:200px'>
</div>
</div>

<div class=' col-lg-3 col-sm-4 col-md-4  col-xs-6'>            
<div class='thumbnail' style='height:200px'>
<div class='caption'>
<span class="icon-map-marker icon-white"></span><h4>Amravati City</h4>


<a href='AmravatiCityUser.jsp' class='label label-success' >Explore your City</a>
</div>
<img class='img-responsive'  src='images/Amravati-city-developed.jpg' alt='Request photo'  style='height:200px'>
</div>
</div>

<div class=' col-lg-3 col-sm-4 col-md-4  col-xs-6'>            
<div class='thumbnail' style='height:200px'>
<div class='caption'>
<span class="icon-map-marker icon-white"></span><h4>Solapur City</h4>


<a href='SolapurCityUser.jsp' class='label label-success' >Explore your City</a>
</div>
<img class='img-responsive'  src='images/Siddheshwar_temple_Solapur.jpg' alt='Request photo'  style='height:200px'>
</div>
</div>
<div class=' col-lg-3 col-sm-4 col-md-4  col-xs-6'>            
<div class='thumbnail' style='height:200px'>
<div class='caption'>
<span class="icon-map-marker icon-white"></span><h4>Nagpur City</h4>


<a href='NagpurCityUser.jsp' class='label label-success' >Explore your City</a>
</div>
<img class='img-responsive'  src='images/Nagpuratnight.jpg' alt='Request photo'  style='height:200px'>
</div>
</div>
            
            
          </div>  <!--row-->
          
          
<div class="row">
<h1 class="text-center">Recent Requests</h1>

</div>
         
           <div class="row" style="padding-top:50px">
           <div class="RecentRequests">
        
        
      </div>            
        
  </div>
  
  
    </div><!-- Containnerclosed-->








    
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
  <!--  <script src="css/assets/js/jquery.js"></script>-->
    <script src="css/dist/js/bootstrap.min.js"></script>
  </body>
</html>
