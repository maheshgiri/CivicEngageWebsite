 
    
      $(function(){
        
        var options = {
          
          
          componentRestrictions: { country: 'in' }
        };
        
        $("#geocomplete").geocomplete(options);
        
      });
    

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