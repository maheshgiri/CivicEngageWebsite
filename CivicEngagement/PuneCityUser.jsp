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
   
    



    <title>FixStuff</title>
     
     
    <!-- Bootstrap core CSS -->
    <link href="css/dist/css/bootstrap.css" rel="stylesheet">
   <link href="css/icon.css"  rel="stylesheet">
    
    <link rel="stylesheet" href="css/UserProfileStyle.css">
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
  
    
         <!--[if lt IE 9]>

      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="css/assets/js/html5shiv.js"></script>
      <script src="css/assets/js/respond.min.js"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script src="css/js/YourIssuesFunction.js"></script>
  <script src="css/js/Clicknextfunc.js" type="application/javascript"></script> 



<script>
var locations=new Array();
$(document).ready(function(){
  
    $.post("GetLocation?cityid=100000",
   
    function(data,status){
      //alert("Data: " + data + "\nStatus: " + status);
	  var temp=data.split(";");
	  var i;
	  for(i=0;i<temp.length-1;i++)
	  {
locations[i]=temp[i].split(",");
	  }


	
	  krishna();
    });
  
});
</script>
<script>

$(function(){
	
	
	
document.getElementById("clickcount").value=1

 var rstatus=document.getElementById("statusfilterid").value;
var servicetype=document.getElementById("typefilterid").value;
var sortby=document.getElementById("sortbyfilterid").value;


//alert(page_nearby_issues); 
//alert(page);
//alert(pages);
  var xmlhttp2;

if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp2=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp2=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp2.onreadystatechange=function()
  {
  if (xmlhttp2.readyState==4 && xmlhttp2.status==200)
    {

   
   
	var tot=xmlhttp2.responseText;
	//alert(tot);
	var tot1=parseInt(tot);
	if(tot1==0)
	{
		//alert("kk");
		document.getElementById("norequestslink").style.display="block";
		
	}
	if(tot1>0)
	{
		//alert("kk1");
	 
   document.getElementById("loadmore_nearby_issues").style.display="block";
	}
	
	document.getElementById("pages_nearby_issues").value=tot1;
	//alert(document.getElementById("pages_nearby_issues").value);
	pages_nearby_issues=tot1;
	
	
    }
  }
xmlhttp2.open("POST","GetAllFilteredIssues?city="+100000+"&status="+rstatus+"&sortby="+sortby+"&type="+servicetype+"");
xmlhttp2.send();


 var xmlhttp1;

if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp1=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp1=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp1.onreadystatechange=function()
  {
  if (xmlhttp1.readyState==4 && xmlhttp1.status==200)
    {





	
   //alert(xmlhttp1.responseText);
    $("#nearbyissues").html(xmlhttp1.responseText);
	 $("html, body").animate({ scrollTop: $(document).height() }, "slow");

	
    }
  }
xmlhttp1.open("POST","GetFilteredIssues?page=1&city="+100000+"&status="+rstatus+"&sortby="+sortby+"&type="+servicetype+"",true);
xmlhttp1.send();



       if(pages_nearby_issues==1){
        document.getElementById("loadmore_nearby_issues").style.display="none"; //IF ALL PAGES ARE LOADED, THE BUTTON WILL BE REMOVED
       }
 










   //WHEN THE 'LOAD MORE' BUTTON IS PRESSED



});




</script>
<script src="css/js/OnChangeJS.js"></script>

 <script src="Chart.js-master/Chart.js"></script>

<script>
	
	var dataarr= new Array();

  
    $.get("GetChartInformation?cityid=100000",
   
    function(data,status){
     // alert("Data: " + data + "\nStatus: " + status);
	 
	  dataarr=data.split(",");
      document.getElementById("sent").innerHTML=dataarr[0];
	  document.getElementById("inprogress").innerHTML=dataarr[01];
	  document.getElementById("completed").innerHTML=dataarr[02];

	var barChartData = {
			labels : ["Recieved","In Progress.","Completed."],
			datasets : [
				{
					fillColor : "rgba(0,0,255,0.4)",
					strokeColor : "rgba(0,0,255,1)",
					data : dataarr
				}
			]
			
		}
  
	var myLine = new Chart(document.getElementById("canvas").getContext("2d")).Bar(barChartData,{ scaleFontColor: "rgba(0,128,0,1)" });
	
	 
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
if(session.getAttribute("user") == null){
    System.out.println("in user profile"+session.getAttribute("user"));
    response.sendRedirect("/CivicEngagement/PuneCityNoUser.jsp");
}
%>
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
            
               
              <input type="text"  spellcheck="false"  placeholder="Search places" class="form-control"  style="border-radius:15px;"  autocomplete="off" required>
          
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
      
      <!--<div class="home">
    <div class="jumbotron" style="background-image:url(images/UoP.jpg);background-repeat:no-repeat;background-size:cover" >
    
    <div class="text-center">
    
  <h1>Pune City.</h1>
   <h3>Explore your city.</h3>
    
   
  

   <!-- <a class=" btn btn-primary btn-lg " href="#">Login with facebook</a>
    <br>
  
    <a class="btn btn-primary btn-lg" href="#">SignUp with facebook</a>
    
 
    
    </div>
   
   
    </div> 
    </div>  -->
    

<div id="map" style="height:280px" class="col-lg-12"></div>

  <script type="text/javascript">
  function krishna()
  {
    // Define your locations: HTML content for the info window, latitude, longitude
  /* locations = [
      ['<h4>Bondi Beach</h4>', -33.890542, 151.274856],
      ['<h4>Coogee Beach</h4>', -33.923036, 151.259052],
      ['<h4>Cronulla Beach</h4>', -34.028249, 151.157507],
      ['<h4>Manly Beach</h4>', -33.80010128657071, 151.28747820854187],
      ['<h4>Maroubra Beach</h4>', -33.950198, 151.259302]
    ];
    */
    // Setup the different icons and shadows
    var iconURLPrefix = 'http://maps.google.com/mapfiles/ms/icons/';
    
    var icons = [
      iconURLPrefix + 'red-dot.png',
      iconURLPrefix + 'red-dot.png',
      iconURLPrefix + 'red-dot.png',
      iconURLPrefix + 'red-dot.png',
      iconURLPrefix + 'red-dot.png',
      iconURLPrefix + 'red-dot.png',      
      iconURLPrefix + 'red-dot.png' 
    ]
    var icons_length = icons.length;
    
    
    var shadow = {
      anchor: new google.maps.Point(15,33),
      url: iconURLPrefix + 'msmarker.shadow.png'
    };

    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 10,
      center: new google.maps.LatLng(-37.92, 151.25),
      mapTypeId: google.maps.MapTypeId.ROADMAP,
      mapTypeControl: false,
      streetViewControl: false,
      panControl: false,
      zoomControlOptions: {
      position: google.maps.ControlPosition.LEFT_BOTTOM
      }
    });


   

    var infowindow = new google.maps.InfoWindow({
      maxWidth: 160
    });

    var marker;
    var markers = new Array();
    
    var iconCounter = 0;
    
    // Add the markers and infowindows to the map
    for (var i = 0; i < locations.length; i++) {  
      marker = new google.maps.Marker({
        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
        map: map,
        icon : icons[iconCounter],
        shadow: shadow
      });

      markers.push(marker);

      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent(locations[i][0]);
          infowindow.open(map, marker);
        }
      })(marker, i));
      
      iconCounter++;
      // We only have a limited number of possible icon colors, so we may have to restart the counter
      if(iconCounter >= icons_length){
      	iconCounter = 0;
      }
    }

    function AutoCenter() {
      //  Create a new viewpoint bound
      var bounds = new google.maps.LatLngBounds();
      //  Go through each...
      $.each(markers, function (index, marker) {
        bounds.extend(marker.position);
      });
      //  Fit these bounds to the map
      map.fitBounds(bounds);
    }
    AutoCenter();
  }
  </script> 



<div class="text-info pull-right ">
<img src="http://maps.google.com/mapfiles/ms/icons/red-dot.png" alt="map-marker"><label style="font-size:11.5px">Shows requests submitted.</label>
</div>
<div class="container">
<div class="tabbable" style="font-family:Cambria, 'Hoefler Text', 'Liberation Serif', Times, 'Times New Roman', serif">
 
  <ul class="nav nav-tabs">
    <li class="active"><a href="#tab1" data-toggle="tab"><span class="icon-home"></span>Home</a></li>
    <li><a href="#tab2" data-toggle="tab"><span class="iconfix-black"></span>  Requests</a></li>
    <li><a href="#tab3" data-toggle="tab"><span class="icon-info-sign"></span> City Information</a></li>
    <li><a href="#tab4" data-toggle="tab"><span class="icon-list"></span> News</a></li>
   
  </ul>
  
  <div class="tab-content">
    <div class="tab-pane active" id="tab1">
     
      <div class="row">
      <div class="col-lg-6">
      <canvas  style="margin-top:50px;" id="canvas" height="290px"  ></canvas>
      </div>
      <div class="col-lg-6"  style="margin-top:50px;">
     <p> No of Requests submitted<div id="sent" ></div></p>
     <p> No of Requests In progress<div id="inprogress" ></div></p>
     <p> No of Requests Completed<div id="completed"></div></p>
      </div>
    </div>
      
    </div>
    
    <div class="tab-pane" id="tab2">
      <h2 style="font-family:Cambria, 'Hoefler Text', 'Liberation Serif', Times, 'Times New Roman', serif">Issues  submitted to  city.</h2>
       
        <div class="row" >
      <div class="col-lg-2 col-sm-3 col-md-2 ">
      <label style="margin-top:10px" >Status</label>
      <select name="Status" id="statusfilterid" class="form-control" style="margin-top:10px;font-size:11px" onChange="filterRecords()" >
      <option value="All" selected>All</option>
      <option value="Open">Open</option>
      <option value="Closed">Closed</option>
      </select>
      </div>
      
      <div class="col-lg-2 col-sm-3 col-md-3 ">
      <label style="margin-top:10px">Service Type</label>
       <select class="form-control"  id="typefilterid" style="margin-top:10px;font-size:11px" name="typefilter" onChange=" filterRecords()" >
            <option selected value="All">All</option>
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
      </div>
       <div class="col-lg-2 col-sm-3 col-md-3 ">
       <label style="margin-top:10px" >Sort By</label>
       <select class="form-control"  id="sortbyfilterid" style="margin-top:10px;font-size:11px" name="sortby" onChange=" filterRecords()">
            <option selected value="Most Recent">Most Recent</option>
            <option value="Most Older">Most Older</option>
            
          </select>
      </div>
      </div>

      <div class="row col-lg-10">
      <ul class="media-list" id="nearbyissues">

      </ul>





<a href="newrequestuser.jsp" id="norequestslink"  style="display:none;text-decoration:none" >There are no  submitted  requests . Make first request.</a>





<input  class="btn btn-block btn-info" id="loadmore_nearby_issues" type="button" value="Click to load more"  style="font-family:Cambria, 'Hoefler Text', 'Liberation Serif', Times, 'Times New Roman', serif;display:none" onClick="clicknext()" >
<input id="pages_nearby_issues" type="text"  style="display:none"  value="" >
<input id="clickcount" type="text"  style="display:none"   value="1">



      
      
      
     
        
      </div><!--Row nearby issues closed-->
      
       
      
      </div>

   <div id="issues">
   
   
   </div>
     
    
    <div class="tab-pane" id="tab3">
     
      <p style="margin-top:10px">
      
      <label>Pune</label><span class="icon-volume-up"></span><a href="voice/PuneVoice.ogg">Listen</a> (pronounced formerly known as Poona, is the eighth largest metropolis in India and the second largest in the state of Maharashtra. It is situated 560 metres (1,837 feet) above sea level on the Deccan plateau at the right bank of the Mutha river. Pune city is the administrative headquarters of Pune district and was once the centre of power of the Maratha Empire.

Pune is known to have existed as a town since 847 AD. It was the first capital of the Maratha Empire under Shivaji. In the 18th century, Pune became the political centre of Indian subcontinent, as the seat of Peshwas, the Maratha Empire's prime ministers.

Pune is the cultural capital of Maharashtra.[6] Since the 1950-60s, Pune has had traditional old-economy industries which continue to grow. The city is now also known for Manufacturing, Automobile, Government and Private sector Research Institutes, Information technology (IT) and Educational, Management,Training institutes that attract migrants, students and Professionals not only from India but also students from South east Asia, Middle East and African countries.
      </p>
      
      <h4><label>Major tourist attractions</label></h4>
      <p>
     <h5><label> Shaniwar Wada</label> </h5> Shaniwar Wada was the palace of the great rulers Peshwa Dynasty in Pune. The structure was built by the Peshwa Baji Rao in 1730. The Palace was destroyed in a big fire in 1827; the mammoth structure of the walls survived the fire. Shaniwar Wada stands testimony to the Maratha culture and its architectural design shows influences of Mughal style and features of Maratha artistic styles too. The 21 feet tall massive door of the palace known as Delhi Darwaza is one of the remains of the grand old Palace.
     <img class="img-circle img-responsive" src="images/200px-Pune_ShaniwarWada_DelhiGate.jpg"> 
    <h5> <label> Dagadusheth Halwai Ganapati Temple </label></h5> The temple was founded in 1893 by Dagadusheth Halwai, a sweetmart seller who became a wealthy businessman. Halwai had lost his son the previous year, and at the request of his guru created murtis (image of a deity) of Ganesha and Dattatreya. He later established the Halwai Ganapati Trust.Bal Gangadhar Tilak, during the British Raj, gave a public form to the Ganesh festival celebrations as a way of getting around an order that barred public meetings
      <img class="img-circle img-responsive" src="images/dagdusheth-halwai-ganapati-temple-pune.jpg"> 
    <h5><label>  Saras Baug </label></h5> Saras Baug constructed by Nanasaheb Peshwa is located against the scenic background of Parvati Hills. The imposing garden is a popular relaxation spot and is exquisite with elegant fountains and lush green lawns. The garden houses a renowned temple constructed in 1774 by Madhav Rao Peshwa. The temple is dedicated to Lord Ganesha and there is a Ganesh Murthi Museum, enclosing large number of Ganesh statues. Saras Garden has been used by citizens of Pune as a walking and jogging track and it also serves as a beautiful hangout for the populace during the weekends and evenings.
      <img class="img-circle img-responsive" src="images/Sarasbaug2.jpg"> 
      </p>
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
    <!-- <script src="css/assets/js/jquery.js"></script>-->
    <script src="css/dist/js/bootstrap.min.js"></script>
  </body>
</html>
