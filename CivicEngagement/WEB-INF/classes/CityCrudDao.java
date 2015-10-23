

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class CityCrudDao {
	
	private Connection connection;

	public CityCrudDao() {
		connection = DBUtility.getConnection();
	}
	
	public int getCityCount(){
		int count=0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(*) as count from City  ");		
			while (rs.next()) {
				count=rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public void addCity(City city) {
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into City(cityid,city,citystate,citypopulation) values (?,?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setInt(1, city.getCityid());
			preparedStatement.setString(2, city.getCity());
			preparedStatement.setString(3, city.getCitystate());			
			preparedStatement.setInt(4, city.getCitypopulation());
                      
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCity(int cityid) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from City where cityid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, cityid);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCity(City city) throws ParseException {
		try {

Statement statement = connection.createStatement();

statement.executeUpdate("update city set city='"+city.getCity()+"' ,CityState='"+city.getCitystate()+"',CityPopulation='"+city.getCitypopulation()+"' where cityid="+city.getCityid()+"");

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

	public List<City> getAllCities(int jtStartIndex, int jtPageSize) {
		List<City> cities = new ArrayList<City>();
		String startIndex=Integer.toString(jtStartIndex);
		String pageSize=Integer.toString(jtPageSize);
		String query="select * from City  limit "+startIndex+","+pageSize+" ";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				City city = new City();
				city.setCityid(rs.getInt("cityid"));
				city.setCity(rs.getString("city"));
				city.setCitystate(rs.getString("citystate"));
                               city.setCitypopulation(rs.getInt("citypopulation"));				
				
				cities.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cities;
	}
	
	public City getCityById(int cityid) {
		City city = new City ();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from city where cityid=?");
			preparedStatement.setInt(1, cityid);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				
				city.setCityid(rs.getInt("cityid"));
				city.setCity(rs.getString("city"));
				city.setCitystate(rs.getString("citystate"));
                               city.setCitypopulation(rs.getInt("citypopulation"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return city;
	}

}
