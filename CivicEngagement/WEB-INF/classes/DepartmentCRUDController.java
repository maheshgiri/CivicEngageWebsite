

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



public class DepartmentCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmentCrudDao dao;
    
    public DepartmentCRUDController() {
        dao=new DepartmentCrudDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action")!=null){
			List<Department> lstDepartment=new ArrayList<Department>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				int startPageIndex=Integer.parseInt(request.getParameter("jtStartIndex"));
				int numRecordsPerPage=Integer.parseInt(request.getParameter("jtPageSize"));

                               
                               

				lstDepartment=dao.getAllDepartments(startPageIndex,numRecordsPerPage);



				//Get Total Record Count for Pagination
				int departmentCount=dao.getDepartmentCount();
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstDepartment, new TypeToken<List<Department>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData=jsonArray.toString();				
				//Return Json in the format required by jTable plugin
				listData="{\"Result\":\"OK\",\"Records\":"+listData+",\"TotalRecordCount\":"+departmentCount+"}";			
				response.getWriter().print(listData);
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					response.getWriter().print(error);
					ex.printStackTrace();
				}				
			}
			else if(action.equals("create") || action.equals("update")){
				Department departmentobj=new Department();
				if(request.getParameter("departmentid")!=null){				   
				   int departmentid=Integer.parseInt(request.getParameter("departmentid"));
				   departmentobj.setDepartmentid(departmentid);
				}
				if(request.getParameter("departmentname")!=null){
					String departmentname=(String)request.getParameter("departmentname");
					 departmentobj.setDepartmentname(departmentname);
				}
				if(request.getParameter("departmentcontactnumber")!=null){
				   int departmentcontactnumber=Integer.parseInt(request.getParameter("departmentcontactnumber"));
				   departmentobj.setDepartmentcontactnumber(departmentcontactnumber);
				}
				if(request.getParameter("departmentemail")!=null){
				   String departmentemail=(String)request.getParameter("departmentemail");
				   departmentobj.setDepartmentemail(departmentemail);
				}
                                
                                if(request.getParameter("departmenthead")!=null){
				   String departmenthead=(String)request.getParameter("departmenthead");
				   departmentobj.setDepartmenthead(departmenthead);
				}
                                 if(request.getParameter("cityid")!=null){
				   int cityid=Integer.parseInt(request.getParameter("cityid"));
				   departmentobj.setCityid(cityid);
				}
				
				try{											
					if(action.equals("create")){//Create new record
						dao.addDepartment(departmentobj);					
						lstDepartment.add(departmentobj);
						//Convert Java Object to Json				
						String json=gson.toJson(departmentobj);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateDepartment(departmentobj);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("departmentid")!=null){
						String departmentid=(String)request.getParameter("departmentid");
						dao.deleteDepartment(Integer.parseInt(departmentid));
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
