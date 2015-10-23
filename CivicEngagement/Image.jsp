<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
   
 <%@ page import=" java.io.*" %>
 <%@ page import=" javax.servlet.*"%>
 <%@ page import=" javax.servlet.http.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:scriptlet>
try{  
	String connectionURL = "jdbc:mysql://localhost/CivicEngagement";
	  java.sql.Connection con=null;
	   session=request.getSession();
	  String user=(String)session.getAttribute("user");
	System.out.println(user);
	  Class.forName("com.mysql.jdbc.Driver").newInstance();
	  con=DriverManager.getConnection(connectionURL,"root","pooja");  
	  Statement st1=con.createStatement();
	  ResultSet rs1 = st1.executeQuery("select Photo from user  where username='"+user+"' ");
	  String imgLen="";
	  if(rs1.next()){
	  imgLen = rs1.getString("Photo");
	  System.out.println(imgLen.length());
	  }  
	  rs1 = st1.executeQuery
	  ("select Photo from user  where username='"+user+"' ");
	  if(rs1.next()){
	  int len = imgLen.length();
	  byte [] rb = new byte[len];
	  InputStream readImg = rs1.getBinaryStream("Photo");
	  int index=readImg.read(rb, 0, len);  
	  System.out.println("index"+index);
	  st1.close();
	  response.reset();
	  response.setContentType("image/jpg");
	  response.getOutputStream().write(rb,0,len);
	  response.getOutputStream().flush();  
	  }
	  }
	  catch (Exception e){
	  e.printStackTrace();
	  }

</jsp:scriptlet>
</body>
</html>