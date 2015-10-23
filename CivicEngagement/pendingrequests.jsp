<!DOCTYPE html>
<%
//String par= request.getParameter("par");
//System.out.println("par"+par);
 response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
//allow access only if session exists
String admin=(String)session.getAttribute("admin");
if(admin== null){
	
	System.out.println("Inside admin if");
	
    response.sendRedirect("/CivicEngagement/AdminLoginPage.jsp");
	
}
%>
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
   
    


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>FixStuff</title>
     
     <!-- Include one of jTable styles. -->
<link href="Table/css/lightcolor/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="Table/css/lightcolor/jquery-ui.css" rel="stylesheet" type="text/css"/>

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
    
	
	
  
     <!--<style>
	
	
 
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

	</style>-->
     <link rel="stylesheet" href="css/UserProfileStyle.css">
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
    <!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>-->
    
	 
   <!--<script src="css/js/YourIssuesFunction.js"></script>-->
 
      
     

<!-- Include jTable script file. -->
<script src="Table/js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="Table/js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="Table/js/jquery.jtable.js" type="text/javascript"></script>

    <script>
	
	
	
  $(document).ready(function () {
        $('#RequestTableContainer').jtable({
            title: 'Pending Requests',
            paging: true, //Enable paging
            pageSize:5, //Set page size (default: 10)   
                  
            actions: {
                listAction: 'PendingRequestCRUDController?action=list',
                createAction:'PendingRequestCRUDController?action=create',
                updateAction: 'PendingRequestCRUDController?action=update',
                deleteAction: 'PendingRequestCRUDController?action=delete'
            },
            fields: {
                requestid: {
                    title:'RequestID',
                    key: true,
                    list: true,
                    

                },
                requesttype: {
                    title: 'Request Type',
                    width: '20%',
					edit:false 
                    
                   
                },
                requestdate: {
                    title: 'Request Time',
                    width: '30%',
                    edit:false                  
                   
                },
                requestdescription: {
                    title: 'Request Desc.',
                    width: '20%',
                    edit: true
                },
                requestlocation: {
                    title: 'Location',
                    width: '30%',
					edit:false 
                    
                },
                requeststatus: {
                    title: 'Status',
                    width: '20%',
					type: 'radiobutton',
					 options: { 'Sent': 'Recieved', 'In Progress': 'In Progress','Completed':'Completed','Rejected':'Reject' },
                    edit: true
                },
				 city:{
					
				    title: 'City',
                    width: '20%',
					edit:false 
                    
				},
				department:{
					
				    title: 'Department',
                    width: '20%',
					edit:false 
                    
				}            
                           
            }
        });
        
        $('#RequestTableContainer').jtable('load', {
                location: $('#name').val(),
                cityId: $('#cityId').val(),
                RequestType:$('#RequestType').val(),
                 RequestStatus:$('#RequestStatus').val()

            });
		$('#LoadRecordsButton').click(function (e) {
            e.preventDefault();
            $('#RequestTableContainer').jtable('load', {
                location: $('#name').val(),
                cityId: $('#cityId').val(),
                RequestType:$('#RequestType').val(),
                RequestStatus:$('#RequestStatus').val()
            });
        });
    
       
    });
</script> 
  </head>

  <body>


    <!-- Wrap all page content here -->
    <div id="wrap">
      
       <div class="navbar navbar-inverse navbar-static-top " style="background-color:rgb(22, 35, 52);color:#CCC;margin-bottom:0px">
        <div class="container">
          <div class="navbar-header" >
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
                      
           <a class="navbar-brand" href="AdminProfile.jsp"><label>Welcome to admin panel.</label></a>
               
            
            
            
          </div>
          <div class="collapse navbar-collapse">
          
          <!--Seach form-->
           
        <!--End of search form-->
          
             <ul class="nav navbar-nav navbar-right">
            <!--<li><a href="newrequest.jsp"><span class="iconfix-fix"></span>  New Request</a></li>-->
            <!--<li  ><a href="#"  >Login</a></li>-->
           <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="icon-user  icon-white"></span>Your Account</a>
              
              
  <!-- Link or button to toggle dropdown -->
                <ul class="dropdown-menu  open" role="menu"  style="border-radius:10px;" >
                
                                 
                    
                    
                                        
                                    
                                   
                                                                         
                                           
                                            <div class="form-group" style="margin:1px">
                                            <form action="/CivicEngagement/AdminLogout" method="post" >
                                            <input type="submit"  class="btn btn-link" value="Logout" style="text-decoration:none" >
                                            </form>
                                            </div>
                                          <div class="form-group" style="margin:1px">
                                             <a  class="btn " href="AdminProfile.jsp" >My Account</a>
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
     <!-- <div id="loading"  ></div>
      -->
<!-- static navbar -->
      
   
<div class="container">
<div class="tabbable" style="font-family:Cambria, 'Hoefler Text', 'Liberation Serif', Times, 'Times New Roman', serif">
 
  <ul class="nav nav-tabs">
    <li class="active"><a href="#tab1" data-toggle="tab"><span class="icon-home"></span>Pending requests</a></li>
    
   
   
  </ul>
  
  <div class="tab-content">
    <div class="tab-pane active" id="tab1">
     <div style="width:80%;margin-right:2%;margin-left:2%;text-align:center;margin-top:10px" >
<div class="filtering">
    <form>
        Location: <input type="text" name="name" id="name" />
        City: 
        <select id="cityId" name="cityId">
            <option selected="selected" value="1">All</option>
            <option value="100000">Pune</option>
            <option value="100001">Mumbai</option>
            <option value="100004">Nagpur</option>
            <option value="100005">Nashik</option>
            <option value="100002">Solapur</option>
            <option value="100008">Nanded</option>
            <option value="100007">Amravati</option>
            <option value="100006">Aurangabad</option>
              <option value="100003">Pimpri Chichwad</option>
            
        </select>
        Request Type:
         <select id="RequestType" name="RequestType">
            <option selected="selected" value="">All</option>
            <option value="Garbage Issue">Garbage Issue</option>
            <option value="Dangerous Condition">Dangerous Condition</option>
            <option value="Environmental Issue">Environmental Issue</option>
            <option value="Health Hazard">Health Hazard</option>
            <option value="Housing Issue">Housing Issue</option>
            <option value="Noise Complaint">Noise Complaint</option>
            <option value="Police Issue">Police Issue</option>
            <option value="Pothole">Pothole</option>
            <option value="Redevelopement">Redevelopement</option>
            <option value="Signage Issue">Signage Issue</option>
            <option value="Transportation Problem">Transportation Problem</option>
             <option value="Other">Other</option>

            
        </select>

           Request Status:
         <select id="RequestStatus" name="RequestStatus">
            <option selected="selected" value="">All</option>
            <option value="In Progress">In Progress</option>
            <option value="Completed">Completed</option>
            

            
        </select>

        <button type="submit" id="LoadRecordsButton">Filter Requests</button>
    </form>

<div id="RequestTableContainer" ></div>
</div>
</div>
    
    </div>
    
    
    
    <div class="tab-pane" id="tab4">
     
    
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
  <!--  <script src="css/assets/js/jquery.js"></script>-->
    <script src="css/dist/js/bootstrap.min.js"></script>
  </body>
</html>
