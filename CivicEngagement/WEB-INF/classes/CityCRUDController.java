

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



public class CityCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CityCrudDao dao;
    
    public CityCRUDController() {
        dao=new CityCrudDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action")!=null){
			List<City> lstCity=new ArrayList<City>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				int startPageIndex=Integer.parseInt(request.getParameter("jtStartIndex"));
				int numRecordsPerPage=Integer.parseInt(request.getParameter("jtPageSize"));

                               

				lstCity=dao.getAllCities(startPageIndex,numRecordsPerPage);



				//Get Total Record Count for Pagination
				int cityCount=dao.getCityCount();
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstCity, new TypeToken<List<City>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData=jsonArray.toString();				
				//Return Json in the format required by jTable plugin
				listData="{\"Result\":\"OK\",\"Records\":"+listData+",\"TotalRecordCount\":"+cityCount+"}";			
				response.getWriter().print(listData);
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					response.getWriter().print(error);
					ex.printStackTrace();
				}				
			}
			else if(action.equals("create") || action.equals("update")){
				City cityobj=new City();
				if(request.getParameter("cityid")!=null){				   
				   int cityid=Integer.parseInt(request.getParameter("cityid"));
				   cityobj.setCityid(cityid);
				}
				if(request.getParameter("city")!=null){
					String city=(String)request.getParameter("city");
					 cityobj.setCity(city);
				}
				if(request.getParameter("citystate")!=null){
				   String citystate=(String)request.getParameter("citystate");
				   cityobj.setCitystate(citystate);
				}
				if(request.getParameter("citypopulation")!=null){
				   int citypopulation=Integer.parseInt(request.getParameter("citypopulation"));
				   cityobj.setCitypopulation(citypopulation);
				}
				

                               
				try{											
					if(action.equals("create")){//Create new record
						dao.addCity(cityobj);					
						lstCity.add(cityobj);
						//Convert Java Object to Json				
						String json=gson.toJson(cityobj);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateCity(cityobj);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("cityid")!=null){
						String cityid=(String)request.getParameter("cityid");
						dao.deleteCity(Integer.parseInt(cityid));
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
