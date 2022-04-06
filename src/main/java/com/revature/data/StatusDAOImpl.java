package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.revature.service.ConnectionFactory;
import com.revature.trms.Event;

public class StatusDAOImpl implements StatusDAO{
	private static ConnectionFactory conFactory = ConnectionFactory.getConnected();

	@Override
	// this method needs to insert the object into the database:
	// so, we need to connect to the database:
	public int create(Event newObj) {
		Connection connection = conFactory.getConnected();
		
	    // this stores our sql command, that we would normally to DBeaver/command line
	    //                             0   1     2        3            4    5
	    String sql = "insert into pet (dept_id, head_id, eventName)" +
	            "values (default, ?, ?)";
	    try {
	        // create a prepared statement, we pass in the sql command
	        // also the flag "RETURN_GENERATED_KEYS" so we can get that id that is generated
	        PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	        // set the fields:
	        preparedStatement.setString(1, newObj.getFirstName());
	        preparedStatement.setString(2, newObj.getLastName());
	        preparedStatement.setLong(3, newObj.getManagerId());

	        // shortcut for now, but we need the corresponding id for the status
	        int dept_id;
	        if (newObj.getDept().equals("available")) {
	            dept_id = 1;
	        }
	        else {
	            status_id = 2;
	        }
	        preparedStatement.setInt(5, status_id);
	        // execute this command, return number of rows affected:
	        int count = preparedStatement.executeUpdate();
	        // lets us return the id that is auto-generated
	        ResultSet resultSet = preparedStatement.getGeneratedKeys();
	        // if we affected one or more rows:
	        if (count > 0) {
	            System.out.println("Pet added!");
	            // return the generated id:
	            // before we call resultSet.next(), it's basically pointing to nothing useful
	            // but moving that pointer allows us to get the information that we want
	            resultSet.next();
	            int id = resultSet.getInt(1);
	            return id;
	        }
	        // if 0 rows are affected, something went wrong:
	        else {
	            System.out.println("Something went wrong when trying to add pet!");
	            return -1;
	        }
	    } catch (SQLException e){
	        // print out what went wrong:
	        e.printStackTrace();
	        return -1;
	    }
		}
}
