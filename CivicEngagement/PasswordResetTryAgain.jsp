<!DOCTYPE html>
    <html lang="en">
      <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
       <link rel="shortcut icon" href="images/repair_icon.png">
        
        <title>FixStuff</title>
        
      
        <!-- Bootstrap core CSS -->
        <link href="css/dist/css/bootstrap.css" rel="stylesheet">
        <link href="css/icon.css"  rel="stylesheet">
    
        <!-- Custom styles for this template -->
        <link href="css/sticky-footer-navbar.css" rel="stylesheet">
        
         
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="../../assets/js/html5shiv.js"></script>
          <script src="../../assets/js/respond.min.js"></script>
        <![endif]-->
        <style>
	@media(max-width:767px)
{    
.navbar-collapse {
     max-height: none;
}
}
 
	</style>
      </head>
    
      <body>
   <%
 response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
//allow access only if session exists
if(session.getAttribute("user") != null){
    System.out.println("in user profile"+session.getAttribute("user"));
    response.sendRedirect("/CivicEngagement/UserProfile.jsp");
}
%>
        <!-- Wrap all page content here -->
        <div id="wrap">
    
          <!-- static navbar -->
          <div class="navbar navbar-inverse navbar-static-top" style="background-color:rgb(22, 35, 52);color:#CCC;margin-bottom:0px;">
            <div class="container">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Home</a>
              </div>
              
              <!--Navbar header closed-->
              <div class="collapse navbar-collapse">
              
              <!--Seach form-->
              
            
                <form class="navbar-form navbar-left" action="#" method="get"> 
                <div class="form-group"> 
                   
                  <input type="text" placeholder="Search places" class="form-control"  style="border-radius:15px;" required>
                   
                </div> 
                
                </form>
            <!--End of search form-->
              
                 <ul class="nav navbar-nav navbar-right">
                <li><a href="newrequest.jsp"><span class="iconfix-fix"></span>  New Request</a></li>
                <!--<li  ><a href="#"  >Login</a></li>-->
                <li class="dropdown" >
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="icon-user icon-white"></span>  Login<!--<b class="caret"></b>--></a>
                  
                  
      <!-- Link or button to toggle dropdown -->
                    <ul class="dropdown-menu" role="menu"  style="border-radius:10px;width:280px">
                    
                    
                                        
                                    
                                    
                                     <form class="navbar-form navbar-left" method="post" name="loginform" role="search" action="./login" style="padding-left:20px">
                                     <fieldset>
                                     <div class="form-group">
                                         
                                        </div>    
                                            <div class="form-group">
                                            <input type="text" autocomplete="off" name="login_username"  class="form-control" placeholder="Username" style="margin-bottom:10px">
                                            </div>
                                            <div class="form-group">
                                                                                
                                            <input type="password"  autocomplete="off" name="login_password"  class="form-control" placeholder="Password" style="margin-bottom:10px">
                                            </div>
                                            
                                            <br>
                                          <div class="form-group">
                                         <button type="submit" class="btn btn-primary"  style="margin-bottom:10px" value="Submit">Submit</button>
                                          
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
           
           
           
           
          <!-- Begin page content -->
          <div class="container col-lg-offset-5" >
         
          <label class="text-danger">Something went wrong please try again.</label>
         <form method="post" action="./ForgotPassword" style="padding-left:20px;width:270px;border: 1px solid rgb(204, 204, 204);border-radius:5px">
         <legend class="text-info" style="width:200px">Forgot passwod?</legend>
         <div class="form-group col-lg-12 col-sm-12 col-md-12">
         <input type="email" name="email" placeholder="Enter email address" class="form-control" style="margin-bottom:10px;margin-top:10px" required>
          <p class="text-info">Temporory password will be sent to this email.</p>
         
         </div>
         <div class="form-group col-lg-12 col-sm-12 col-md-12">
         <input type="submit" name="submit" value="Submit" class="btn btn-primary "style="margin-bottom:10px;margin-top:10px"  >
         
         
         </div>
         
         </form>
       
        </div> <!--container closed-->
          
        
        
        
        
     </div><!--Wrap closed-->
    
    <div id="footer" style="background-color:rgb(22, 35, 52);color:#FFF" >
          <div class="panel-footer"  style="background-color:rgb(22, 35, 52);color:#FFF">
           <p>© 2013 Civic Engagement
           </p>
          </div>
          </div>
    
       
    
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="css/assets/js/jquery.js"></script>
        <script src="css/dist/js/bootstrap.min.js"></script>
      </body>
    </html>
    