package step_definitions.db_stepDefinitions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Given;
import helper.DButils;

public class EmployeeDB_StepDefinition extends DButils{
	
	private  static Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	@Given("I am connecting to DB")
	public void i_am_connecting_to_DB() throws SQLException, ClassNotFoundException {
	 
	  connection = establishConnection();
	 
	}

	@Given("getting result based on the query {string}")
	public void getting_result_based_on_the_query(String query) throws SQLException {
	   statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	   resultSet = statement.executeQuery(query);
	   ResultSetMetaData metaData = resultSet.getMetaData();
	   List<Map<String,Object>> list = runSQLQuery(query);
	   System.out.println(list.toString());
	}
}
