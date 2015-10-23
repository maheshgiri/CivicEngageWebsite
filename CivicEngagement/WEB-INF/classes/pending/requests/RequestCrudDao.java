package pending.requests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class RequestCrudDao {
	
	private Connection connection;
        
	public RequestCrudDao() {
		connection = DBUtility.getConnection();
	}
	
	public int getRequestCount(String location,String rtype,String cid,String rstatus){
		int count=0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(*) as count from Requests where requestlocation like '%"+location+"%' && requesttype like  '%"+rtype+"%' && cityid like '%"+cid+"%' && requeststatus like '%"+rstatus+"%' ");		
			while (rs.next()) {
				count=rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public void addRequest(Request request) {
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Requests(requestid,requesttype,requestdate,requestdescription,requestlocation) values (?,?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setInt(1, request.getRequestid());
			preparedStatement.setString(2, request.getRequesttype());
			preparedStatement.setString(3, request.getRequestdate());			
			preparedStatement.setString(4, request.getRequestdescription());
                        preparedStatement.setString(4, request.getRequestlocation());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRequest(int requestid) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Requests where requestid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, requestid);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateRequest(Request request) throws ParseException {
		try {

Statement statement = connection.createStatement();
System.out.println(request.getRequestdate());
System.out.println(request.getRequesttype());
System.out.println(request.getRequestid());

statement.executeUpdate("update Requests set requeststatus='"+request.getRequeststatus()+"',requestdescription='"+request.getRequestdescription()+"' where requestid="+request.getRequestid()+"");

/*
			PreparedStatement preparedStatement = connection.prepareStatement("update Requests set requestdate=?,requesttype=?,requestlocation=?" +
							"where requestid=?");
			// Parameters start with 1			
			preparedStatement.setString(1, request.getRequestdate());
			preparedStatement.setString(2, request.getRequesttype());
                        preparedStatement.setString(3, request.getRequestlocation());			
			preparedStatement.setInt(4, request.getRequestid());
			preparedStatement.executeUpdate();
*/

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Request> getAllRequests(int jtStartIndex, int jtPageSize,String location,String rtype,String cid,String rstatus) {
		List<Request> requests = new ArrayList<Request>();
		String startIndex=Integer.toString(jtStartIndex);
		String pageSize=Integer.toString(jtPageSize);
		String query="select * from Requests where requestlocation like '%"+location+"%' && requesttype like  '%"+rtype+"%' && cityid like '%"+cid+"%' && requeststatus like '%"+rstatus+"%' limit "+startIndex+","+pageSize;
		
                try {
			Statement statement = connection.createStatement();
                        
			ResultSet rs = statement.executeQuery(query);
                        
			while (rs.next()) {
                            int timedifference=0;
                            String datetime= rs.getString("requestdate");
                            System.out.println(datetime);
                          PreparedStatement ps=connection.prepareStatement("SELECT TIMESTAMPDIFF(hour,'"+datetime+"',now()) as timediff");
                           ResultSet timediff=ps.executeQuery();
                           if(timediff.next()) 
                           {
                               timedifference=timediff.getInt("timediff");
                           }
                            System.out.println(timedifference);
                           if(rs.getString("requesttype").contains("Garbage Issue")&&timedifference>48)
                           {
                                
				Request request = new Request();
				request.setRequestid(rs.getInt("requestid"));
				request.setRequesttype(rs.getString("requesttype"));
				request.setRequestdate(rs.getString("requestdate"));
                                request.setRequestlocation(rs.getString("requestlocation"));				
				request.setRequestdescription(rs.getString("requestdescription"));
                                request.setRequeststatus(rs.getString("requeststatus"));
                                 request.setDepartmentid(rs.getInt("departmentid"));
                                 Statement statement1=connection.createStatement(); 
                              ResultSet  rs1=statement1.executeQuery("select city from city where cityid="+rs.getString("cityid")+"");
                              Statement statement2=connection.createStatement(); 
                              ResultSet  rs2=statement2.executeQuery("select departmentname from departments where departmentid="+rs.getString("departmentid")+"");
                              if(rs1.next())
                                {
                                    request.setRequestcity(rs1.getString("city")); 
                                }
                              
                              if(rs2.next())
                                {
                                    request.setRequestdepartment(rs2.getString("departmentname")); 
                                }
				requests.add(request);
                           }
                            if(rs.getString("requesttype").contains("Dangerous Condition ")&&timedifference>4)
                           {
                                
				Request request = new Request();
				request.setRequestid(rs.getInt("requestid"));
				request.setRequesttype(rs.getString("requesttype"));
				request.setRequestdate(rs.getString("requestdate"));
                                request.setRequestlocation(rs.getString("requestlocation"));				
				request.setRequestdescription(rs.getString("requestdescription"));
                                request.setRequeststatus(rs.getString("requeststatus"));
                                 request.setDepartmentid(rs.getInt("departmentid"));
                                 Statement statement1=connection.createStatement(); 
                              ResultSet  rs1=statement1.executeQuery("select city from city where cityid="+rs.getString("cityid")+"");
                              Statement statement2=connection.createStatement(); 
                              ResultSet  rs2=statement2.executeQuery("select departmentname from departments where departmentid="+rs.getString("departmentid")+"");
                              if(rs1.next())
                                {
                                    request.setRequestcity(rs1.getString("city")); 
                                }
                              
                              if(rs2.next())
                                {
                                    request.setRequestdepartment(rs2.getString("departmentname")); 
                                }
				requests.add(request);
                           }
                             if(rs.getString("requesttype").contains("Environmental Issue")&&timedifference>24)
                           {
                                
				Request request = new Request();
				request.setRequestid(rs.getInt("requestid"));
				request.setRequesttype(rs.getString("requesttype"));
				request.setRequestdate(rs.getString("requestdate"));
                                request.setRequestlocation(rs.getString("requestlocation"));				
				request.setRequestdescription(rs.getString("requestdescription"));
                                request.setRequeststatus(rs.getString("requeststatus"));
                                 request.setDepartmentid(rs.getInt("departmentid"));
                                 Statement statement1=connection.createStatement(); 
                              ResultSet  rs1=statement1.executeQuery("select city from city where cityid="+rs.getString("cityid")+"");
                              Statement statement2=connection.createStatement(); 
                              ResultSet  rs2=statement2.executeQuery("select departmentname from departments where departmentid="+rs.getString("departmentid")+"");
                              if(rs1.next())
                                {
                                    request.setRequestcity(rs1.getString("city")); 
                                }
                              
                              if(rs2.next())
                                {
                                    request.setRequestdepartment(rs2.getString("departmentname")); 
                                }
				requests.add(request);
                           }
                             
                              if(rs.getString("requesttype").contains("Health Hazard")&&timedifference>4)
                           {
                                
				Request request = new Request();
				request.setRequestid(rs.getInt("requestid"));
				request.setRequesttype(rs.getString("requesttype"));
				request.setRequestdate(rs.getString("requestdate"));
                                request.setRequestlocation(rs.getString("requestlocation"));				
				request.setRequestdescription(rs.getString("requestdescription"));
                                request.setRequeststatus(rs.getString("requeststatus"));
                                 request.setDepartmentid(rs.getInt("departmentid"));
                                 Statement statement1=connection.createStatement(); 
                              ResultSet  rs1=statement1.executeQuery("select city from city where cityid="+rs.getString("cityid")+"");
                              Statement statement2=connection.createStatement(); 
                              ResultSet  rs2=statement2.executeQuery("select departmentname from departments where departmentid="+rs.getString("departmentid")+"");
                              if(rs1.next())
                                {
                                    request.setRequestcity(rs1.getString("city")); 
                                }
                              
                              if(rs2.next())
                                {
                                    request.setRequestdepartment(rs2.getString("departmentname")); 
                                }
				requests.add(request);
                           }
                              
                                if(rs.getString("requesttype").contains("Housing Issue")&&timedifference>120)
                           {
                                
				Request request = new Request();
				request.setRequestid(rs.getInt("requestid"));
				request.setRequesttype(rs.getString("requesttype"));
				request.setRequestdate(rs.getString("requestdate"));
                                request.setRequestlocation(rs.getString("requestlocation"));				
				request.setRequestdescription(rs.getString("requestdescription"));
                                request.setRequeststatus(rs.getString("requeststatus"));
                                 request.setDepartmentid(rs.getInt("departmentid"));
                                 Statement statement1=connection.createStatement(); 
                              ResultSet  rs1=statement1.executeQuery("select city from city where cityid="+rs.getString("cityid")+"");
                              Statement statement2=connection.createStatement(); 
                              ResultSet  rs2=statement2.executeQuery("select departmentname from departments where departmentid="+rs.getString("departmentid")+"");
                              if(rs1.next())
                                {
                                    request.setRequestcity(rs1.getString("city")); 
                                }
                              
                              if(rs2.next())
                                {
                                    request.setRequestdepartment(rs2.getString("departmentname")); 
                                }
				requests.add(request);
                           }
                                    if(rs.getString("requesttype").contains("Noise Complaint")&&timedifference>(24*7))
                           {
                                
				Request request = new Request();
				request.setRequestid(rs.getInt("requestid"));
				request.setRequesttype(rs.getString("requesttype"));
				request.setRequestdate(rs.getString("requestdate"));
                                request.setRequestlocation(rs.getString("requestlocation"));				
				request.setRequestdescription(rs.getString("requestdescription"));
                                request.setRequeststatus(rs.getString("requeststatus"));
                                 request.setDepartmentid(rs.getInt("departmentid"));
                                 Statement statement1=connection.createStatement(); 
                              ResultSet  rs1=statement1.executeQuery("select city from city where cityid="+rs.getString("cityid")+"");
                              Statement statement2=connection.createStatement(); 
                              ResultSet  rs2=statement2.executeQuery("select departmentname from departments where departmentid="+rs.getString("departmentid")+"");
                              if(rs1.next())
                                {
                                    request.setRequestcity(rs1.getString("city")); 
                                }
                              
                              if(rs2.next())
                                {
                                    request.setRequestdepartment(rs2.getString("departmentname")); 
                                }
				requests.add(request);
                           }
                                      if(rs.getString("requesttype").contains("Police Issue")&&timedifference>6)
                           {
                                
				Request request = new Request();
				request.setRequestid(rs.getInt("requestid"));
				request.setRequesttype(rs.getString("requesttype"));
				request.setRequestdate(rs.getString("requestdate"));
                                request.setRequestlocation(rs.getString("requestlocation"));				
				request.setRequestdescription(rs.getString("requestdescription"));
                                request.setRequeststatus(rs.getString("requeststatus"));
                                 request.setDepartmentid(rs.getInt("departmentid"));
                                 
				requests.add(request);
                           }
                                      
                                      
                                             if(rs.getString("requesttype").contains("Pothole")&&timedifference>(24*7))
                           {
                                
				Request request = new Request();
				request.setRequestid(rs.getInt("requestid"));
				request.setRequesttype(rs.getString("requesttype"));
				request.setRequestdate(rs.getString("requestdate"));
                                request.setRequestlocation(rs.getString("requestlocation"));				
				request.setRequestdescription(rs.getString("requestdescription"));
                                request.setRequeststatus(rs.getString("requeststatus"));
                                 request.setDepartmentid(rs.getInt("departmentid"));
                                 Statement statement1=connection.createStatement(); 
                              ResultSet  rs1=statement1.executeQuery("select city from city where cityid="+rs.getString("cityid")+"");
                              Statement statement2=connection.createStatement(); 
                              ResultSet  rs2=statement2.executeQuery("select departmentname from departments where departmentid="+rs.getString("departmentid")+"");
                              if(rs1.next())
                                {
                                    request.setRequestcity(rs1.getString("city")); 
                                }
                              
                              if(rs2.next())
                                {
                                    request.setRequestdepartment(rs2.getString("departmentname")); 
                                }
				requests.add(request);
                           }
                                             
                                                       
                                             if(rs.getString("requesttype").contains("Redevelopement")&&timedifference>(24*15))
                           {
                                
				Request request = new Request();
				request.setRequestid(rs.getInt("requestid"));
				request.setRequesttype(rs.getString("requesttype"));
				request.setRequestdate(rs.getString("requestdate"));
                                request.setRequestlocation(rs.getString("requestlocation"));				
				request.setRequestdescription(rs.getString("requestdescription"));
                                request.setRequeststatus(rs.getString("requeststatus"));
                                 request.setDepartmentid(rs.getInt("departmentid"));
                                 Statement statement1=connection.createStatement(); 
                              ResultSet  rs1=statement1.executeQuery("select city from city where cityid="+rs.getString("cityid")+"");
                              Statement statement2=connection.createStatement(); 
                              ResultSet  rs2=statement2.executeQuery("select departmentname from departments where departmentid="+rs.getString("departmentid")+"");
                              if(rs1.next())
                                {
                                    request.setRequestcity(rs1.getString("city")); 
                                }
                              
                              if(rs2.next())
                                {
                                    request.setRequestdepartment(rs2.getString("departmentname")); 
                                }
				requests.add(request);
                           }
                                             
                                                              if(rs.getString("requesttype").contains("Signage Issue")&&timedifference>(24*2))
                           {
                                
				Request request = new Request();
				request.setRequestid(rs.getInt("requestid"));
				request.setRequesttype(rs.getString("requesttype"));
				request.setRequestdate(rs.getString("requestdate"));
                                request.setRequestlocation(rs.getString("requestlocation"));				
				request.setRequestdescription(rs.getString("requestdescription"));
                                request.setRequeststatus(rs.getString("requeststatus"));
                                 request.setDepartmentid(rs.getInt("departmentid"));
                                 Statement statement1=connection.createStatement(); 
                              ResultSet  rs1=statement1.executeQuery("select city from city where cityid="+rs.getString("cityid")+"");
                              Statement statement2=connection.createStatement(); 
                              ResultSet  rs2=statement2.executeQuery("select departmentname from departments where departmentid="+rs.getString("departmentid")+"");
                              if(rs1.next())
                                {
                                    request.setRequestcity(rs1.getString("city")); 
                                }
                              
                              if(rs2.next())
                                {
                                    request.setRequestdepartment(rs2.getString("departmentname")); 
                                }
				requests.add(request);
                           }
                              
                                                              
                                                               if(rs.getString("requesttype").contains("Transportation Problem")&&timedifference>(24*3))
                           {
                                
				Request request = new Request();
				request.setRequestid(rs.getInt("requestid"));
				request.setRequesttype(rs.getString("requesttype"));
				request.setRequestdate(rs.getString("requestdate"));
                                request.setRequestlocation(rs.getString("requestlocation"));				
				request.setRequestdescription(rs.getString("requestdescription"));
                                request.setRequeststatus(rs.getString("requeststatus"));
                                 request.setDepartmentid(rs.getInt("departmentid"));
                                 Statement statement1=connection.createStatement(); 
                              ResultSet  rs1=statement1.executeQuery("select city from city where cityid="+rs.getString("cityid")+"");
                              Statement statement2=connection.createStatement(); 
                              ResultSet  rs2=statement2.executeQuery("select departmentname from departments where departmentid="+rs.getString("departmentid")+"");
                              if(rs1.next())
                                {
                                    request.setRequestcity(rs1.getString("city")); 
                                }
                              
                              if(rs2.next())
                                {
                                    request.setRequestdepartment(rs2.getString("departmentname")); 
                                }
				requests.add(request);
                           }
                              
                                            
                                                               if(rs.getString("requesttype").contains("Other")&&timedifference>(24*8))
                           {
                                
				Request request = new Request();
				request.setRequestid(rs.getInt("requestid"));
				request.setRequesttype(rs.getString("requesttype"));
				request.setRequestdate(rs.getString("requestdate"));
                                request.setRequestlocation(rs.getString("requestlocation"));				
				request.setRequestdescription(rs.getString("requestdescription"));
                                request.setRequeststatus(rs.getString("requeststatus"));
                                 request.setDepartmentid(rs.getInt("departmentid"));
                                 Statement statement1=connection.createStatement(); 
                              ResultSet  rs1=statement1.executeQuery("select city from city where cityid="+rs.getString("cityid")+"");
                              Statement statement2=connection.createStatement(); 
                              ResultSet  rs2=statement2.executeQuery("select departmentname from departments where departmentid="+rs.getString("departmentid")+"");
                              if(rs1.next())
                                {
                                    request.setRequestcity(rs1.getString("city")); 
                                }
                              
                              if(rs2.next())
                                {
                                    request.setRequestdepartment(rs2.getString("departmentname")); 
                                }
				requests.add(request);
                           }
                                              
                                      
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return requests;
	}
	
	public Request getRequestById(int requestid) {
		Request request = new Request ();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from Requests where requestid=?");
			preparedStatement.setInt(1, requestid);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				request.setRequestid(rs.getInt("requestid"));
				request.setRequesttype(rs.getString("requesttype"));
				request.setRequestdate(rs.getString("requestdate"));
                                request.setRequestdescription(rs.getString("requestdescription"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return request;
	}

}
