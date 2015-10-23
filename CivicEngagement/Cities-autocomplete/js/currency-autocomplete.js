$(function(){
  var currencies = [
    { value: 'Pune City', data: 'PUN' },
    { value: 'Mumbai City', data: 'MUM' },
    { value: 'Nagpur City', data: 'NAG' },
    { value: 'Nashik City', data: 'NASH' },
    { value: 'Aurangabad City', data: 'AURA' },
    { value: 'Nanded City', data: 'NAN' },
    { value: 'Solapur City', data: 'SOL' },
    { value: 'Amravati City', data: 'AMR' },
    
  ];
  
  // setup autocomplete function pulling from currencies[] array
  $('#autocomplete').autocomplete({
    lookup: currencies,
    onSelect: function (suggestion) {
      var thehtml = '<strong>Currency Name:</strong> ' + suggestion.value + ' <br> <strong>Symbol:</strong> ' + suggestion.data;
	  if(suggestion.value.indexOf("Pune")>-1)
	  {
		  window.location.href="PuneCityUser.jsp";
	  }
	  else if(suggestion.value.indexOf("Mumbai")>-1)
	  {
		  window.location.href="MumbaiCityUser.jsp";
	  }
	   else if(suggestion.value.indexOf("Nagpur")>-1)
	  {
		  window.location.href="NagpurCityUser.jsp";
	  }
	  else if(suggestion.value.indexOf("Nashik")>-1)
	  {
		  window.location.href="NashikCityUser.jsp";
	  }
	   else if(suggestion.value.indexOf("Nanded")>-1)
	  {
		  window.location.href="NandedCityUser.jsp";
	  }
	  
	   else if(suggestion.value.indexOf("Solapur")>-1)
	  {
		  window.location.href="SolapurCityUser.jsp";

	  }
          else if(suggestion.value.indexOf("Amravati")>-1)
	  {
		  window.location.href="AmravatiCityUser.jsp";
	  }
           else if(suggestion.value.indexOf("Aurangabad")>-1)
	  {
		  window.location.href="AurangabadCityUser.jsp";
	  }
      $('#outputcontent').html(thehtml);
	  
    }
  });
  

});