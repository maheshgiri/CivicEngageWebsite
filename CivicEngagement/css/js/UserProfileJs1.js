	  function EnableFields()
       {
       var fn=document.getElementById("firstnameid");
	   fn.removeAttribute("disabled");
	   var ln=document.getElementById("lastnameid");
	   ln.removeAttribute("disabled");
	 
  var sdb=document.getElementById("submitdatabtn");
 sdb.removeAttribute("disabled");
	    var address=document.getElementById("geocomplete");
	   address.removeAttribute("disabled");
	    var zip=document.getElementById("zipcodeid");
	   zip.removeAttribute("disabled");
	    var mobile=document.getElementById("mobileid");
	   mobile.removeAttribute("disabled");
       }
	  
      
      
      
	  function zipcodevalidation()
	  {   
		  var zip=document.getElementById("zipcodeid").value;
		 
		  if(zip.length!=6 || isNaN(zip)==true)
		  {
			   $("#zipcodehint").show().delay(1000).fadeOut();	
			    document.getElementById("zipcodeid").value="";
		  }
	  }
	  function mobilevalidation()
	  {
		  var mobile=document.getElementById("mobileid").value;
		  if(mobile.length!=10 || (mobile.charAt(0)!=9  && mobile.charAt(0)!=8 && mobile.charAt(0)!=7) ||isNaN(mobile)==true )
		  {
			   $("#mobilehint").show().delay(1000).fadeOut();
			   document.getElementById("mobileid").value="";	
		  }
	  }
	  

   function getfile()
   {
	  var a=document.getElementById("inputfile");
	 
	  a.onclick=a.click(); 
	  
   }
   
   
   
  
   
   
  
   function clicksubmit()
   {
	   var b=document.getElementById("updatebtn");
		 b.onclick=b.click(); 
		
   }
  


    
   
  
	   
$(function(){

 var options = {
          
          
          componentRestrictions: { country: 'in' }
        };
        
        $("#geocomplete").geocomplete(options);

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
xmlhttp.open("POST","GetUserIssues1");
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
xmlhttp.open("POST","GetUserIssues1?page="+next,true);
xmlhttp.send();



       if(next==pages){
         $("#loadmore").remove(); //IF ALL PAGES ARE LOADED, THE BUTTON WILL BE REMOVED
       }

       $("#content").append(data); //LOADS THE NEW PAGE OF CONTENT UNDER THE REST
    
   });


var page_nearby_issues = 1;
   var pages_nearby_issues = $("#pages_nearby_issues").val(); //TOTAL NUMBER OF PAGES
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
    $("#nearbyissues").html(xmlhttp.responseText);
    }
  }
xmlhttp.open("POST","GetNearbyIssues");
xmlhttp.send();

  
if(page_nearby_issues==pages_nearby_issues){
         $("#loadmore_nearby_issues").remove(); //IF ALL PAGES ARE LOADED, THE BUTTON WILL BE REMOVED
       }


   //WHEN THE 'LOAD MORE' BUTTON IS PRESSED
   $("#loadmore_nearby_issues").live("click", function(){
     var next_nearby_issues = page_nearby_issues+=1;
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




	
   //alert(xmlhttp.responseText);
    $("#nearbyissues").append(xmlhttp.responseText);
	 $("html, body").animate({ scrollTop: $(document).height() }, "slow");

	
    }
  }
xmlhttp.open("POST","GetNearbyIssues?page="+next_nearby_issues,true);
xmlhttp.send();



       if(next_nearby_issues==pages_nearby_issues){
         $("#loadmore_nearby_issues").remove(); //IF ALL PAGES ARE LOADED, THE BUTTON WILL BE REMOVED
       }

       $("#nearbyissues").append(data); //LOADS THE NEW PAGE OF CONTENT UNDER THE REST
    
   });


});
   



  