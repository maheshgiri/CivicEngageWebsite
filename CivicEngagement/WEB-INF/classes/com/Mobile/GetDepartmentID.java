package com.Mobile;
//STEP 1. Import required packages
import java.sql.*;

public class GetDepartmentID{
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/CivicEngagement";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "pooja";
   
   public int GetID (String dname,int cid) {
   Connection conn = null;
 Statement stmt=null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
     
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt=conn.createStatement();
      ResultSet rs=stmt.executeQuery("select DepartmentID from Departments where  Departmentname like  '%"+dname+"%'  and CityID='"+cid+"' ");
      if(rs.next())
      {
      return rs.getInt("DepartmentID");
       }
        else{
        return -1;
        }
     

   }catch(SQLException se){
     
 //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
  return -1;  
}//end main
}//end GetCityID