package step_definitions.db_stepDefinitions;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import cucumber.api.java.en.Given;
import helper.DButils;

public class EmployeeDB_StepDefinition extends DButils{
	
	Connection connection;
	Statement statement;
	
	@Given("I am connecting to DB")
	public void i_am_connecting_to_DB() throws SQLException, ClassNotFoundException {
	 
	  connection = establishConnection();
	  System.out.println(getRowsCount("SELECT last_name, first_name FROM employees\r\n" + 
	  		"WHERE country='USA';"));
	   
	}

	@Given("getting result based on the query {string}")
	public void getting_result_based_on_the_query(String string) {
	   
	}

}
