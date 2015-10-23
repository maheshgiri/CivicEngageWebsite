
  
	   
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


});
   