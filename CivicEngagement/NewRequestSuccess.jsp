<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
     <!--For refresh--> <!--<meta http-equiv="refresh" content="5" >-->
   <link rel="shortcut icon" href="images/repair_icon.png">
   
    
   
    
    <title>FixStuff</title>
    
<!-- 
jquery.autocomplete.js requires a minor modification for geo_autocomplete to work
the following script includes the required mod
-->
	
    
 

  
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
    <script src="http://maps.googleapis.com/maps/api/js?sensor=false&amp;libraries=places"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	
    <script src="Geolocation/jquery.geocomplete.js"></script>
   <script>
   window.onload=function()
   {
	   $("#requesthint").show().delay(5000).fadeOut();
	   
   }
   </script>
    
    <script>
      $(function(){
        
        var options = {
          map: ".map_canvas",
          location: [18.520430, 73.856744],
          //details:"form",
          componentRestrictions: { country: 'in' }
        };
        
        $("#geocomplete").geocomplete(options);
        
      });
    </script>
    
    
    
    <script src="css/assets/js/html5shiv.js"></script>	  
	<script src="css/assets/js/respond.min.js"></script>
   
   
   <script>
   function getfile()
   {
	  var a=document.getElementById("inputfile");
	 
	  a.onclick=a.click(); 
	  
   }
   </script>
    <style>
	@media(max-width:767px)
{    
.navbar-collapse {
     max-height: none;
}
}
 
	</style>
    
    
    
    <script >
	
	
	
	
	
	function formvalidation()
	{  
	
	   
         var flag=0;
		
	
		var type=document.getElementById("rtype");
		var selectedValue = type.options[type.selectedIndex].value;
	    var temp="Select Request Type";
		var sbtn=document.getElementById("submitrequestbtnhidden");
		//var hint=document.getElementById("selectimagehint");
		var img=document.getElementById("inputfile").value;
	    
		/*var xmlhttp;   
		 var str=document.getElementById("passid").value; 
   
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
     passstatus=xmlhttp.responseText;
	 alert(passstatus);
     if(passstatus=="false")
		{
			flag=1;
			 $("passwronghint").show().delay(1000).fadeOut();	
			 document.getElementById("submitrequestbtn").setAttribute("disabled");
		}
		else
		{
		 document.getElementById("submitrequestbtn").removeAttribute("disabled");	
		}
	
	
	

    }
  }
xmlhttp.open("POST","SubmitNewRequest?requestpass="+str,true);
xmlhttp.send();
*/

var addr=document.getElementById("cityname").value.toLowerCase();

		 if(addr.indexOf("pune")==-1 && addr.indexOf("mumbai")==-1  && addr.indexOf("nagpur")==-1  && addr.indexOf("pimpari chinchwad")==-1  && addr.indexOf("nashik")==-1  && addr.indexOf("aurangabad")==-1  && addr.indexOf("solapur")==-1  && addr.indexOf("amaravati")==-1  && addr.indexOf("nanded")==-1 )
		 { 
		    $("html, body").animate({ scrollTop: 0 }, "slow");
			$("#addressinvalidhint").show().delay(3000).fadeOut(); 
			flag=1;
		 }
		 
		 
		if(img.indexOf("jpg")==-1 &&img.indexOf("jpeg")==-1 && img!="" && img.indexOf("jfif")==-1 &&img.indexOf("exif")==-1 && img.indexOf("tiff")==-1 &&img.indexOf("gif")==-1 &&img.indexOf("bmp")==-1 &&img.indexOf("png")==-1 )
		{
			flag=1;
			
			//alert(img.indexOf("jpg"));
			//alert(img.indexOf("jpeg"));
			 $("#imagenotsupportedhint").show().delay(1000).fadeOut();	
		}
		
		if(temp==selectedValue)
		{
			flag=1;
			 $("#selectoptionhint").show().delay(1000).fadeOut();	
		}
		if(img=="")
		{
			
			flag=1;
			 $("#selectimagehint").show().delay(1000).fadeOut();	
		}
		
		//alert("pass"+passstatus);
		
		
		
		
		//alert(flag);
		if(flag==0)
		{
			sbtn.onclick=sbtn.click();
		}
		
		
	}
	
	</script>

<script>
       function readURL(input) {
           var v=document.getElementById("imagepreview");
           v.removeAttribute("hidden");
           if (input.files && input.files[0]) {
               var reader = new FileReader();
               reader.onload = function(e) {
                   $('#imagepreview').attr('src', e.target.result);
               }
 
               reader.readAsDataURL(input.files[0]);
           }
       }
       $("#filePhoto").change(function() {
           readURL(this);
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
String user=(String)session.getAttribute("user");
if(session.getAttribute("user") == null){
    System.out.println("in user profile"+session.getAttribute("user"));
    response.sendRedirect("/CivicEngagement/NewRequestNotLogin.jsp");
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
          <div class="collapse navbar-collapse">
          
          <!--Seach form-->
          
        
            <form class="navbar-form navbar-left" action="./search" method="get"> 
            <div class="form-group"> 
               
              <input type="text" placeholder="Search places" class="form-control"  style="border-radius:15px;" required>
               
            </div> 
            
            </form>
        <!--End of search form-->
          
             <ul class="nav navbar-nav navbar-right">
            <li><a href="newrequest.jsp"><span class="iconfix-fix"></span>  New Request</a></li>
            <!--<li  ><a href="#"  >Login</a></li>-->
            <li class="dropdown" >
            
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"> <span class="icon-user icon-white"></span> User<!--<b class="caret"></b>--></a>
              
              
  <!-- Link or button to toggle dropdown -->
                
                                  <ul class="dropdown-menu" role="menu"  style="border-radius:10px;">
                    
                     
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
      <div class="container " >
     
     
    
     
    
    
    
     
    
     
     <form  action="./SubmitRequest"  name="New-request"   method="post" enctype="multipart/form-data" >
    
     <div class=" sign-in-form">
     
     
     <div class="row">  
     <div class="col-lg-6 col-sm-6 ">
      <label class="text-success" id="requesthint">Your request has been uploaded successfully.</label>
      
      </div>
      </div>
      
     <div class="row">  
     <div class="col-lg-6 col-sm-6 ">
      <label> 1.Eneter request  location </label>
      <div class="divider"></div>
      </div>
      </div>
      
     <div class="row">
     <div class="col-lg-6 col-sm-6" >
     <input id="geocomplete" type="text" name="requestlocation" class="form-control" placeholder="Enter location" style="margin-bottom:10px"    required/>
        <li class="text-info" style="list-style-type:none" >1. Please write detailed address.</li>
       
        <li class="text-info"  style="list-style-type:none;margin-bottom:10px">2. Please do not use abbreviated names.</li>
    
      </div>
      
      </div>
      
       <div class="row">
     <div class="col-lg-6 col-sm-6" >
    <div class="map_canvas" style="height:280px;margin-bottom:10px"></div>
      </div>
      </div>
      
       <div class="row">  
     <div class="col-lg-6 col-sm-6 ">
      <label> Select City from where you are making request</label>
      <div class="divider"></div>
      </div>
      </div>
      <div class="row">
      <div class="col-lg-6 col-sm-6" >
      <select name="locality" lang="en" xml:lang="en"  type="text" value="" class="form-control" placeholder="Enter the name of the city " id="cityname" required style="margin-bottom:10px" > 
       <option value="">Select City</option>
      <option value="Pune">Pune</option>
      <option value="Mumbai">Mumbai</option>
	<option value="Solapur">Solapur</option>
      <option value="Nanded">Nanded</option>
      <option value="Nashik">Nashik</option>
      <option value="Aurangabad">Aurangabad</option>
      <option value="Pimpri chinchwad">Pimpri chinchwad</option>
      <option value="Nagpur">Nagpur</option>
      <option value="Amravati">Amravati</option>
      </select>
      
      <label class="text-danger" id="addressinvalidhint" hidden="hidden" style="margin-bottom:10px">Please select valid  city above.</label>
       </div>
       </div> 
       
      
      
      <div class="row">
       <div class="col-lg-6 col-sm-6 " >
    <label>2.Details</label>
      
      </div>
      </div>
      
      
      
       <div class="row">
       <div class="col-lg-6 col-sm-6 " >
      <input type="text" class="form-control" name="requesttitle" maxlength="255" placeholder="Request Title" style="margin-bottom:10px" required>
    
      </div>
      </div>
      
       <div class="row">
       <div class="col-lg-6 col-sm-6">
          <select class="form-control"  id="rtype" style="margin-bottom:10px" name="requesttype" required >
            <option selected value="Select Request Type">Select Request Type</option>
            <option value="Dangerous Condition" >Dangerous Condition</option>
            <option value="Environmental Issue" >Environmental Issue</option>
            <option value="Garbage Issue" >Garbage Issue</option>
            <option value="Health Hazard" >Health Hazard</option>
            <option value="Housing Issue" >Housing Issue</option>
           <option value="Noise Complaint" >Noise Complaint</option>
             <option value="Police Issue" >Police Issue</option>
              <option value="Pothole" >Pothole</option>
               <option value="Redevelopement" >Redevelopement</option>
                <option value="Signage Issue" >Signage Issue</option>
                <option value="Transportation Problem" >Transportation Problem</option>
                 <option value="Other" >Other</option>
          </select>
          <label class="text-danger" id="selectoptionhint" hidden="hidden">Select request type.</label>
       </div>
      </div>
      
      
       <div class="row">
     <div class="col-lg-6 col-sm-6" >
       <textarea class="form-control"  name="requestdescription"  maxlength="255" placeholder="Request Description" style="margin-bottom:10px"  required></textarea>
      </div>
      </div>
      
     <%-- 
      <div class="row">
     <!-- Addind date-->
       <div class="col-lg-6 col-sm-6 " >
       <input class="form-control" type="date"  >
       </div>
       </div>--%>
      
      <div class="row">
       <div class="col-lg-6 col-sm-6 " >
      <!--Photo upload-->
      <input type="file" id="inputfile" style="visibility:hidden" name="requestimage" onchange="readURL(this)" accept="image/*"  required>
      <button type="button"  id="fileUploadButton" class="btn btn-primary"  onClick="getfile()" style="margin-bottom:10px"><span class="icon-camera icon-white" ></span> Upload Photo</button>
      
      </div>
      </div>

      <div class="row">
<div class="col-lg-6 col-sm-6 " >
<img id="imagepreview" class="img-rounded" src="#"  width="100" height="100"  hidden />
<label class="text-danger" id="selectimagehint" hidden="hidden">Please select image.</label>

</div>
</div>
<div class="row">
<div class="col-lg-6 col-sm-6 " >
<label class="text-danger" id="imagenotsupportedhint" hidden="hidden">File you have selected is not valid.</label>
</div>
</div>
      <div class="row">
     <div class="col-lg-6 col-sm-6" >
      <label>3.Finish</label>
        
      </div>
      </div>
      
    
      
      <div class="row">
       <div class="col-lg-6 col-sm-6 " >
      <input type="email" class="form-control" name="requestemail" value="<%= user%>" placeholder="Email" style="margin-bottom:10px"  disabled required>
      </div>
      </div>
      
      <!--<div class="row">
       <div class="col-lg-6 col-sm-6 " >
      <input type="password" class="form-control" name="requestpassword" placeholder="Password" style="margin-bottom:10px" required autocomplete="off"  id="passid" >
      <label class="text-danger" id="passwronghint" hidden="hidden">Password is wrong</label>
      <span class="help-block">Your account will be created automatically to track your request.</span>

      </div>
      </div>-->
      
      <div class="row">
       <div class="col-lg-6 col-sm-6 " >
    <input type="button" id="submitrequestbtn" class="btn btn-primary" value="Submit" onClick="formvalidation()" >
      <input type="submit" id="submitrequestbtnhidden"  class="btn btn-primary hidden" value="Submit"    >
      <input type="reset" class="btn btn-primary" onClick="history.go(0)" >
      </div>
      </div>
      
      
      
      
      
      
      
      </div>
      
     </form>
    
      </div>
      
    
    
    
    
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
