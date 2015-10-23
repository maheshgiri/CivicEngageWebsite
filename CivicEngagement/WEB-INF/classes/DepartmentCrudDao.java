

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class DepartmentCrudDao {
	
	private Connection connection;

	public DepartmentCrudDao() {
		connection = DBUtility.getConnection();
	}
	
	public int getDepartmentCount(){
		int count=0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(*) as count from Departments  ");		
			while (rs.next()) {
				count=rs.getInt("count");
			}
		} catch (SQLException e) {
                        System.out.println("in department count");
			e.printStackTrace();
		}
		return count;
	}

	public void addDepartment(Department department) {
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Departments(departmentid,departmentname,departmenthead,departmentcontactnumber,departmentemail) values (?,?, ?, ? ,?)");
			// Parameters start with 1
			preparedStatement.setInt(1, department.getDepartmentid());
			preparedStatement.setString(2, department.getDepartmentname());
			preparedStatement.setString(3,department.getDepartmenthead());			
			preparedStatement.setInt(4, department.getDepartmentcontactnumber());
                        preparedStatement.setString(5, department.getDepartmentemail());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteDepartment(int departmentid) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Departments where departmentid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, departmentid);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateDepartment(Department department) throws ParseException {
		try {

Statement statement = connection.createStatement();


statement.executeUpdate("update Departments set departmentemail='"+department.getDepartmentemail()+"' ,departmentcontactnumber='"+department.getDepartmentcontactnumber()+"',departmenthead='"+department.getDepartmenthead()+"' where departmentid="+department.getDepartmentid()+"");

/*
			PreparedStatement preparedStatement = connection.prepareStatement("update Departments set requestdate=?,requesttype=?,requestlocation=?" +
							"where requestid=?");
			// Parameters start with 1			
			preparedStatement.setString(1, department.getRequestdate());
			preparedStatement.setString(2,department.getRequesttype());
                        preparedStatement.setString(3,department.getRequestlocation());			
			preparedStatement.setInt(4, department.getRequestid());
			preparedStatement.executeUpdate();
*/

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Department> getAllDepartments(int jtStartIndex, int jtPageSize) {
		List<Department> departments = new ArrayList<Department>();
		String startIndex=Integer.toString(jtStartIndex);
		String pageSize=Integer.toString(jtPageSize);
		String query="select * from Departments  limit "+startIndex+","+pageSize;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Department department = new Department();
				department.setDepartmentid (rs.getInt("departmentid"));
				department.setDepartmentname (rs.getString("departmentname"));
				department.setDepartmenthead(rs.getString("departmenthead"));
                                department.setDepartmentcontactnumber(rs.getInt("departmentcontactnumber"));				
				department.setDepartmentemail(rs.getString("departmentemail"));
                                department.setCityid(rs.getInt("cityid"));
                                Statement statement1=connection.createStatement();
                                ResultSet rs1=statement1.executeQuery("select city from city where cityid="+rs.getInt("cityid")+"");
                                if(rs1.next())
                                {
                                   department.setDepartmentcity(rs1.getString("city"));  
                                }
				departments.add(department);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return departments;
}
	
	public Department getDepartmentById(int departmentid) {
		Department department  = new Department  ();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from Departments where departmentid=?");
			preparedStatement.setInt(1, departmentid);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				department.setDepartmentid(rs.getInt("departmentid"));
				department.setDepartmentname(rs.getString("departmentname"));
				department.setDepartmenthead(rs.getString("departmenthead"));
                                department.setDepartmentcontactnumber(rs.getInt("departmentcontactnumber"));
                                department.setDepartmentemail(rs.getString("departmentemail"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
                         
		}
		return department;
	}

}
