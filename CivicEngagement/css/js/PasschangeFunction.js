
function validateCurrentPassword()
{
	 var xmlhttp;
var cpass=document.getElementById("currentpassword").value;
var passwrnhint=document.getElementById("passwrong");
var submtbtn=document.getElementById("passchngsbmtbtn");

var newp=document.getElementById("newpassword").value;
   var cnewp=document.getElementById("cnewpassword").value;
   
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
if(cpass==xmlhttp.responseText && submtbtn.disabled   && newp.length!=0 && cnewp.length!=0 )
{
	passwrnhint.setAttribute("hidden","hidden");
	submtbtn.removeAttribute("disabled");
	
}
else if(cpass==xmlhttp.responseText)
{
	passwrnhint.setAttribute("hidden","hidden");

	
}
else
{
	passwrnhint.removeAttribute("hidden");
	submtbtn.setAttribute("disabled");
}
 
  
    
    }
  }
xmlhttp.open("POST","GetUserPassword");
xmlhttp.send();

}

   function passchangeval()
   {
   var newp=document.getElementById("newpassword").value;
   var cnewp=document.getElementById("cnewpassword").value;
   var s=document.getElementById("passchngsbmtbtn");
   var passmatch=document.getElementById("passdntmatch");
   var passlen=document.getElementById("lesspasslen");
  var cpass=document.getElementById("currentpassword");
  
	
	
   if(newp==cnewp  && s.disabled && newp!=null && cnewp!=null &&newp.length>=6 && cnewp.length>=6)
   { 
   
	 cpass.removeAttribute("disabled"); 
	 passmatch.setAttribute("hidden","hidden");
	 passlen.setAttribute("hidden","hidden");
	
	
   }
   else if(newp!=cnewp && newp!=null && cnewp!=null  &&newp.length>=6 && cnewp.length>=1)
   {
     passmatch.removeAttribute("hidden","hidden");
	 cpass.setAttribute("disabled"); 
	 passlen.setAttribute("hidden","hidden");
	
	 
   }
   else if (newp.length<6 || cnewp.length<6  && newp.length>0 && cnewp.length>0 )
   {
	 cpass.setAttribute("disabled"); 
	  passmatch.setAttribute("hidden","hidden");
	  passlen.removeAttribute("hidden","hidden"); 
	 
   }
     
   else
   {
	  cpass.setAttribute("disabled"); 
	   passmatch.setAttribute("hidden","hidden");
	    passlen.setAttribute("hidden","hidden");
		pw.setAttribute("hidden","hidden");
   }
   }
   