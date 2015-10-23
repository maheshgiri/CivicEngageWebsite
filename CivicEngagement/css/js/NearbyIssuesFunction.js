


$(function(){
	
	
	
	
	
   
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



