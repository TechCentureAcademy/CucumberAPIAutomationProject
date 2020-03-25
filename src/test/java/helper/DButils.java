package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DButils {
	
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	
	public static Connection establishConnection() throws SQLException, ClassNotFoundException {
		
		Properties properties = new Properties();
		properties.setProperty("user", ConfigurationReader.getProperty("postgresdb.user"));
		properties.setProperty("password", ConfigurationReader.getProperty("postgresdb.password"));
		
		Class.forName("org.postgresql.Driver");

		
		if( connection == null)
				connection = DriverManager.getConnection(ConfigurationReader.getProperty("postgresdb.url"), properties);
				
			return connection;
	}
	public static int getRowsCount(String sql) throws SQLException {
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		resultSet = statement.executeQuery(sql);
		resultSet.last();
		return resultSet.getRow();
	}
	public static List<Map<String,Object>> runSQLQuery(String sql) throws SQLException{
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		resultSet = statement.executeQuery(sql);
		List<Map<String,Object>> list = new ArrayList<>();
		ResultSetMetaData rsMdata = resultSet.getMetaData();
		int colCount = rsMdata.getColumnCount();
		while(resultSet.next()) {
			  Map<String,Object> rowMap = new HashMap<>();
			  for(int col = 1; col <= colCount; col++) {
				  // change this lane to output only names
				  rowMap.put(rsMdata.getColumnName(col), resultSet.getObject(col));	  
			  }
			  list.add(rowMap);
		}
		return list;
	}
	public static void closeConnections() {
		try{
			if(resultSet != null) {
				resultSet.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
