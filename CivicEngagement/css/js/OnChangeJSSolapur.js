
function filterRecords()
{

var rstatus=document.getElementById("statusfilterid").value;
var servicetype=document.getElementById("typefilterid").value;
var sortby=document.getElementById("sortbyfilterid").value;


 //alert(rstatus);
 //alert(servicetype);
// alert(sortby);
document.getElementById("clickcount").value=1;
document.getElementById("pages_nearby_issues").value=0;
//alert(page_nearby_issues); 
//alert(page);
//alert(pages);
  var xmlhttp3;

if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp3=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp3=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp3.onreadystatechange=function()
  {
  if (xmlhttp3.readyState==4 && xmlhttp3.status==200)
    {

   
   
	var tot=xmlhttp3.responseText;
	//alert("tot>>>"+tot);
	var tot1=parseInt(tot);
	if(tot1==0)
	{
		//alert("kk");
		 document.getElementById("loadmore_nearby_issues").style.display="none";
		document.getElementById("norequestslink").style.display="block";
		
	}
	if(tot1>0)
	{
		//alert("kk1");
		
   document.getElementById("loadmore_nearby_issues").style.display="block";
   document.getElementById("norequestslink").style.display="none";
	}
	
	//alert("tot1 onchange"+tot1);
	//alert("tot"+tot);
    document.getElementById("pages_nearby_issues").value=tot;
	
	
	

	
	
    }
  }
xmlhttp3.open("POST","GetAllFilteredIssues?city="+100002+"&status="+rstatus+"&sortby="+sortby+"&type="+servicetype+"");
xmlhttp3.send();




 var xmlhttp4;

if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp4=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp4=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp4.onreadystatechange=function()
  {
  if (xmlhttp4.readyState==4 && xmlhttp4.status==200)
    {




	
   //alert(xmlhttp.responseText);
    $("#nearbyissues").html(xmlhttp4.responseText);
	 $("html, body").animate({ scrollTop: $(document).height() }, "slow");
     var pages_nearby_issues=parseInt(document.getElementById("pages_nearby_issues").value);
//alert("total pages"+pages_nearby_issues);


var clkcnt=parseInt(document.getElementById("clickcount").value);
 //alert("before clkcnt"+clkcnt);
       
	   if(clkcnt>=pages_nearby_issues){
        document.getElementById("loadmore_nearby_issues").style.display="none"; //IF ALL PAGES ARE LOADED, THE BUTTON WILL BE REMOVED
       }
	
    }
  }
xmlhttp4.open("POST","GetFilteredIssues?page=1&city="+100002+"&status="+rstatus+"&sortby="+sortby+"&type="+servicetype+"",true);
xmlhttp4.send();


	   
	   
	   
	   
	   
 
   //WHEN THE 'LOAD MORE' BUTTON IS PRESSED
   

}


