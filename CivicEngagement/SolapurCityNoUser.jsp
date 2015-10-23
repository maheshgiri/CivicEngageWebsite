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
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="css/assets/js/html5shiv.js"></script>
      <script src="css/assets/js/respond.min.js"></script>
       
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
   <!--<script src="css/js/YourIssuesFunction.js"></script>-->
  <script src="css/js/ClicknextfuncSolapur.js" type="application/javascript"></script> 

      
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
xmlhttp2.open("POST","GetAllFilteredIssues?city="+100002+"&status="+rstatus+"&sortby="+sortby+"&type="+servicetype+"");
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
xmlhttp1.open("POST","GetFilteredIssues?page=1&city="+100002+"&status="+rstatus+"&sortby="+sortby+"&type="+servicetype+"",true);
xmlhttp1.send();



       if(pages_nearby_issues==1){
        document.getElementById("loadmore_nearby_issues").style.display="none"; //IF ALL PAGES ARE LOADED, THE BUTTON WILL BE REMOVED
       }
 










   //WHEN THE 'LOAD MORE' BUTTON IS PRESSED



});




</script>
<script src="css/js/OnChangeJSSolapur.js"></script>


<script src="http://maps.google.com/maps/api/js?sensor=false"></script>



<script>
var locations=new Array();
$(document).ready(function(){
  
    $.post("GetLocation?cityid=100002",
   
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

 <script src="Chart.js-master/Chart.js"></script>

<script>
	
	var dataarr= new Array();

  
    $.get("GetChartInformation?cityid=100002",
   
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

if(session.getAttribute("user") != null){
    response.sendRedirect("/CivicEngagement/SolapurCityUser.jsp");
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
            
               
              <input type="text"  spellcheck="false"  placeholder="Search places" class="form-control"  style="border-radius:15px;" autocomplete="off" required>
          
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
      
     Solapur is largest city in southern Maharashtra, India and 4th largest in maharashtra sharing its place with nashik which is equal in population and area. It lies on the border of Maharashtra and Karnataka. It is 2 TIER city classified as B-1 by HRA classification.It is 30 most Populated city in India and 43rd Largest Urban agglomeration. Solapur has speakers of Marathi, Kannada, Telugu and Urdu, with Marathi as major language and Kannada as sub-major. It is the fourth largest district in Maharashtra in terms of land area and seventh largest in terms of population. The district shares its the borders with southern Indian state Karnataka.
      </p>
      <p>
      Solapur is well known for its textile industries often referred as Manchester of India. Solapur chadars and towels are world famous. It has been a leading center for cotton mills and power looms in India . Solapur had the world's second largest and Asia largest spinning mill. The chief deity of the city is Shri Siddheshwar. The "Nandidhwaj" procession on Makar Sankranti is celebrated on 14 January. An annual fair locally known as 'Gadda yatra' attracts large crowd. Solapur municipal corporation extended its area up to 300 km2 with emerging its suburbs.
      </p>
      
      <h4><label>Major tourist attractions</label></h4>
      <p>
     <h5><label> Siddeshwar Temple</label> </h5> Siddheshwar (or Siddarama or Siddarameswara) was one among the many acharya of Lingayat (Veerashaivism). He was a great mystic and a Kannada poet who was a part of Basavanna's Veerashaiva revolution during the 12th century. Siddharama[1] claims to have written 68,000 vachanas out of which 1379 are in existence. Basavanna, Allama Prabhu, Devara Dasimayya, Channabasava, Siddharama (1150)are regarded as the most acknowledged and respected poets. Vachanakaras wrote in the genre of Veerashaivas,under Kannada literature from the mystic period. His philosophy was one of service to mankind, the path of karmayoga. He shares the world view of other vachana poets in his rejection of blind conventions of caste and sex discrimination and emphasis on realization through personal experience. He too borrows Metaphors from diverse spheres of everyday life. Apart from vachanas,he has written several devotional works in tripadi. writing three-line verse, used from 7th century.
     <img class="img-circle img-responsive" src="images/SolapurSiddheshwar"> 
    
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
  <!--  <script src="css/assets/js/jquery.js"></script>-->
    <script src="css/dist/js/bootstrap.min.js"></script>
  </body>
</html>
