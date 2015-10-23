
package pending.requests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;



public class RequestCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestCrudDao dao;
    
    public RequestCRUDController() {
        dao=new RequestCrudDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action")!=null){
			List<Request> lstRequest=new ArrayList<Request>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				int startPageIndex=Integer.parseInt(request.getParameter("jtStartIndex"));
				int numRecordsPerPage=Integer.parseInt(request.getParameter("jtPageSize"));

                                String location=request.getParameter("location");
                                String rtype=request.getParameter("RequestType");
                                String cid=request.getParameter("cityId");
                                String rstatus=request.getParameter("RequestStatus");

                                System.out.println("************location"+location);
                                System.out.println("************rtype"+rtype);
                                System.out.println("************cityid"+cid);
                                System.out.println("************RequestStatus"+rstatus);

				lstRequest=dao.getAllRequests(startPageIndex,numRecordsPerPage,location,rtype,cid,rstatus);



				//Get Total Record Count for Pagination
				int requestCount=dao.getRequestCount(location,rtype,cid,rstatus);
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstRequest, new TypeToken<List<Request>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData=jsonArray.toString();				
				//Return Json in the format required by jTable plugin
				listData="{\"Result\":\"OK\",\"Records\":"+listData+",\"TotalRecordCount\":"+requestCount+"}";			
				response.getWriter().print(listData);
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					response.getWriter().print(error);
					ex.printStackTrace();
				}				
			}
			else if(action.equals("create") || action.equals("update")){
				Request requestobj=new Request();
				if(request.getParameter("requestid")!=null){				   
				   int requestid=Integer.parseInt(request.getParameter("requestid"));
				   requestobj.setRequestid(requestid);
				}
				if(request.getParameter("requesttype")!=null){
					String requesttype=(String)request.getParameter("requesttype");
					 requestobj.setRequesttype(requesttype);
				}
				if(request.getParameter("requestdate")!=null){
				   String requestdate=(String)request.getParameter("requestdate");
				   requestobj.setRequestdate(requestdate);
				}
				if(request.getParameter("requestdescription")!=null){
				   String requestdescription=(String)request.getParameter("requestdescription");
				   requestobj.setRequestdescription(requestdescription);
				}
				if(request.getParameter("requestlocation")!=null){
				   String requestlocation=(String)request.getParameter("requestlocation");
				   requestobj.setRequestdescription(requestlocation);
				}
                                if(request.getParameter("requeststatus")!=null){
				   String requeststatus=(String)request.getParameter("requeststatus");
				   requestobj.setRequeststatus(requeststatus);
				}

                                if(request.getParameter("departmentid")!=null){
				   int departmentid=Integer.parseInt(request.getParameter("departmentid"));
				   requestobj.setDepartmentid(departmentid);
				}
				try{											
					if(action.equals("create")){//Create new record
						dao.addRequest(requestobj);					
						lstRequest.add(requestobj);
						//Convert Java Object to Json				
						String json=gson.toJson(requestobj);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateRequest(requestobj);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("requestid")!=null){
						String requestid=(String)request.getParameter("requestid");
						dao.deleteRequest(Integer.parseInt(requestid));
						String listData="{\"Result\":\"OK\"}";								
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
				String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
				response.getWriter().print(error);
			}				
		}
	 }
  }
}
