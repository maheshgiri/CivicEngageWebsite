  <!DOCTYPE html>
    <html lang="en">
      <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
       <link rel="shortcut icon" href="images/repair_icon.png">
       <meta http-equiv="pragma" content="no-cache"> 
        <meta http-equiv="expires" content="0"> 

         <meta http-equiv="cache-control"  content="no-cache" > 
        
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
    
     <script src="http://maps.googleapis.com/maps/api/js?sensor=false&amp;libraries=places"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	
    <script src="Geolocation/jquery.geocomplete.js"></script>
  
     
     
     <script>
   function passwordValidation()
   {
   
   var newp=document.getElementById("passid").value;
   var cnewp=document.getElementById("cpassid").value;
   var passmatch=document.getElementById("passdntmatch");
   var passlen=document.getElementById("lesspasslen");
    var email=document.getElementById("email").value;
	var cemail=document.getElementById("confirmemail").value;
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var addr=document.getElementById("geocomplete").value.toLowerCase();

		 if(addr.indexOf("pune")==-1 && addr.indexOf("mumbai")==-1  && addr.indexOf("nagpur")==-1  && addr.indexOf("pimpari chinchwad")==-1  && addr.indexOf("nashik")==-1  && addr.indexOf("aurangabad")==-1  && addr.indexOf("solapur")==-1  && addr.indexOf("amaravati")==-1  && addr.indexOf("nanded")==-1 )
		 {
			$("#cityhint").show().delay(2500).fadeOut(); 
			return  false;
		 }
	
	if(!filter.test(email))
	{
	$("#emailnotvalidhint").show().delay(1500).fadeOut();
		 document.getElementById("confirmemail").value="";
		 document.getElementById("email").value="";
		 return false;	
	}
	if(email!=cemail)
	{
		 $("#emailhint").show().delay(1500).fadeOut();
		 document.getElementById("confirmemail").value="";
		 return false;
	}
	
	
   if(newp==cnewp &&  newp!=null && cnewp!=null &&newp.length>=6 && cnewp.length>=6 )
   {		    
	return true;
	
   }
   
   else if(newp!=cnewp && newp!=null && cnewp!=null  &&newp.length>=6 && cnewp.length>=1  )
   {
	
     $("#passdntmatch").show().delay(1500).fadeOut();
	document.getElementById("passid").value="";
   document.getElementById("cpassid").value="";
	  return false;
	
	 
   }
  
  
   
   
   else if (newp.length<6 || cnewp.length<6  && newp.length>0 && cnewp.length>0 )
   {
	 
	  $("#lesspasslen").show().delay(1500).fadeOut();
	  document.getElementById("passid").value="";
   document.getElementById("cpassid").value="";
	   return false;
   }
  
   else
   {
	 document.getElementById("passid").value="";
   document.getElementById("cpassid").value="";
	   
		 return false;
   }
   
  
   
   
   return false;
   }
   </script>
   
    <script>
      $(function(){
        
		
         var options = {
          types: ['(cities)'],
           componentRestrictions: { country: 'in' }
          
          
        };
        
        $("#geocomplete").geocomplete(options);
        
      });
    </script>
    
    
    
    <script>
   window.onload=function()
   {
	   $("#userexistshint").show().delay(5000).fadeOut();
	   
   }
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
          <div class="container" style="font-family:Cambria, 'Hoefler Text', 'Liberation Serif', Times, 'Times New Roman', serif" >
         
          
           <div class="row">
           
          <div class=" col-lg-6 col-md-6 col-sm-6 col-xs-12" >
          
          <div class="row">
          
          
          
          <h3 class="text-info"  style="font-family:Cambria, 'Hoefler Text', 'Liberation Serif', Times, 'Times New Roman', serif">
          <b> Create an account to get help.</b>
          </h3><!---->
          
          
          </div>
          <div class="row">
          
          <h4 class="text-info " style="font-family:Cambria, 'Hoefler Text', 'Liberation Serif', Times, 'Times New Roman', serif" >
          <img src="images/fix.png" style="height:30px;width:30px" class="img-responsive" alt="img">
          <b>Customize your experience to get the most <br>
          relevant and timely civic info.
          </b>
          </h4>
          
           
          </div>
          
           <div class="row">
           <h4 class="text-info" style="font-family:Cambria, 'Hoefler Text', 'Liberation Serif', Times, 'Times New Roman', serif">
           <img src="images/fix.png" style="height:30px;width:30px" class="img-responsive" alt="img">
           <b>
           Engage directly with neighbors and city officials<br>
            about what matters most to you.
            </b>
            </h4>
          </div>
          
          
          <div class="row">
          <h4 class="text-info" style="font-family:Cambria, 'Hoefler Text', 'Liberation Serif', Times, 'Times New Roman', serif">
          <img src="images/fix.png" style="height:30px;width:30px" class="img-responsive" alt="img">
          <b>
          Track your impact on your community, get<br>
          updated when your issues are addressed.
          </b>
           </h4>
          </div>
          
          
          </div><!--left side closed-->
          
          
          <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 pull-right " >
          <form class="form-group"  method="post" name="sineupform" action="./signup" onSubmit=" return passwordValidation()" >
          
         
          
           <div class="row" style="margin-bottom:10px">
          <input type="email" name="signup_email" id="email" class="form-control"  placeholder="Email"  spellcheck="false" required autocomplete="off">  
          <label class="text-info">This will be your username .</label>
          
          </div>
          
           <div class="row" style="margin-bottom:10px">
          <input type="email"    name="signup_confirmemail" id="confirmemail" class="form-control"  placeholder="Confirm email"  spellcheck="false" autocomplete="off" style="margin-bottom:10px"  required> 
          <label class=" text-danger" id="userexistshint" hidden="hidden">User alraedy exists choose different email address.</label>
          <label class="text-danger" id="emailhint" hidden="hidden">Email do not match.</label>
          <label class="text-danger" id="emailnotvalidhint" hidden="hidden">Email is not valid.</label>
                 
         
          </div>
          
          
          <div class="row" style="margin-bottom:10px">
          <input type="password"  autocomplete="off"   name="signup_password" id="passid" class="form-control"  placeholder="Password" style="margin-bottom:10px"  required > 
           <label class="text-danger" id="passdntmatch"  hidden="hidden">Password don not match.</label> 
           <label class="text-danger" id="lesspasslen" hidden="hidden">Password should have minimum six characters.</label>
          </div>
          
          <div class="row" style="margin-bottom:10px">
          <input type="password" autocomplete="off"  id="cpassid"  name="signup_confirmpassword" class="form-control"  placeholder="Confirm password" required >  
          </div>
          
          <div class="row" style="margin-bottom:10px">
          <input  id="geocomplete" type="text"  name="signup_city"  class="form-control" placeholder="City" autocomplete="off" required>
           
          <label class="text-info" >Enter the city to get help to develop it.</label>  
          </div>
          
           <div class="row" style="margin-bottom:10px">
          <label class="text-danger" id="cityhint" hidden="hidden">Selected city not available.</label>
           </div>
           
          <div class="row" style="margin-bottom:10px">
         <input type="submit" class="btn btn-primary " id="submitbtn" value="Submit"  >
          <input type="reset" class="btn btn-primary" value="Reset" >
          <a href="LoginPage.jsp" class="text-primary" >Already have account?</a>
          &nbsp; &nbsp;  <a href="SignUpConfirmation.jsp" class="text-primary" >Want to confirm account?</a>
         
          </div>
          
          
          
          </form>
          
          </div><!--Right side closed-->
         
        </div>  
       
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
        <!--<script src="css/assets/js/jquery.js"></script>-->
        <script src="css/dist/js/bootstrap.min.js"></script>
      </body>
    </html>
    