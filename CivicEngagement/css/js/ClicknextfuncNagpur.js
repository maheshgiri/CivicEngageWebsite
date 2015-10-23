
	
function clicknext() {
	
	var rstatus=document.getElementById("statusfilterid").value;
var servicetype=document.getElementById("typefilterid").value;
var sortby=document.getElementById("sortbyfilterid").value;
	var clkcnt= parseInt(document.getElementById("clickcount").value);
	 clkcnt=clkcnt+1;
	 var pages_nearby_issues=parseInt(document.getElementById("pages_nearby_issues").value);
	// alert("toatal pahes"+pages_nearby_issues);
	 document.getElementById("clickcount").value=clkcnt;
     var next_nearby_issues = clkcnt;
  //alert("pages"+pages_nearby_issues);
  //alert("pages_visited_clickcnt"+clkcnt);
      //alert("before call"+next_nearby_issues);
     var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  
  //alert(xmlhttp.readyState);
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
     $("#nearbyissues").append(xmlhttp.responseText);
	 $("html, body").animate({ scrollTop: $(document).height() }, "slow");
    }
  }
xmlhttp.open("POST","GetFilteredIssues?page="+clkcnt+"&city="+100004+"&status="+rstatus+"&sortby="+sortby+"&type="+servicetype+"",true);
xmlhttp.send();

//alert("after sent"+xmlhttp.readyState);

 if(next_nearby_issues>=pages_nearby_issues){
        document.getElementById("loadmore_nearby_issues").style.display="none"; //IF ALL PAGES ARE LOADED, THE BUTTON WILL BE REMOVED
       }





      
}
    

// JavaScript Document}