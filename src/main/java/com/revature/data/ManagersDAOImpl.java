package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.service.ConnectionFactory;
import com.revature.trms.Event;
import com.revature.trms.Managers;

public class ManagersDAOImpl implements ManagersDAO {
	Connection connection;

	public ManagersDAOImpl() throws ClassNotFoundException {
		connection = ConnectionFactory.getConnected();
	}

	@Override
	// this method needs to insert the object into the database:
	// so, we need to connect to the database:
	public int create(Managers newObj) {
		
	    // this stores our sql command, that we would normally to DBeaver/command line
	    //                             0   1     2        3            4    5
	    String sql = "insert into Managers (managerID, managerName, pendingRequests)" +
	            "values (default, ?, ?)";
	    try {
	        // create a prepared statement, we pass in the sql command
	        // also the flag "RETURN_GENERATED_KEYS" so we can get that id that is generated
	        PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	        // set the fields:
	        preparedStatement.setInt(3, newObj.getManagerID());
	        preparedStatement.setString(1, newObj.getManagerName());
	        preparedStatement.setString(2, newObj.getPendingRequests());

	        // shortcut for now, but we need the corresponding id for the status
	        int count = preparedStatement.executeUpdate();
			
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
	        if (count > 0) {
	            System.out.println("Manager Added!");
	            resultSet.next();
	            int id = resultSet.getInt(1);
	            return id;
	        }
	        else {
	        	System.out.println("Something went wrong when trying to add a manager!");
	        }
	    } catch (SQLException e){
	        // print out what went wrong:
	        e.printStackTrace();
	    }
		return -1;
		}

	@Override
	public int create(Event newObj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Managers getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Managers> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Managers updatedObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Managers objToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}
}
