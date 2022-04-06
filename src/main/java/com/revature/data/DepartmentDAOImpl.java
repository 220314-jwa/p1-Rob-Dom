package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.service.ConnectionFactory;
import com.revature.trms.Department; //depHeadID

public class DepartmentDAOImpl implements DepartmentDAO {
	 Connection connection;
	 
	 public DepartmentDAOImpl () throws ClassNotFoundException {
	        connection = ConnectionFactory.getConnected();
	 }
	 
	 @Override
	 public int create(Department newObj) {
		 String sql = "insert into Department (depID, depName, depHeadID, pendingDepApproval)" +
	                "values (default, ?, ?, ?)";
		 
		 try {
	            // create a prepared statement, we pass in the sql command
	            // also the flag "RETURN_GENERATED_KEYS" so we can get that id that is generated
	            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	            // set the fields:
	            preparedStatement.setLong(1, newObj.getDepID());
	            preparedStatement.setString(2, newObj.getDepName());
	            preparedStatement.setLong(3, newObj.getDepHeadID());

	            // shortcut for now, but we need the corresponding id for the status
	            int dephead_id;
	            if (newObj.getDepHeadID().equals(1)) {
	                dephead_id = 1;
	            }
	            else {
	            	dephead_id++;
	            }
	            preparedStatement.setInt(5, dephead_id);
	            // execute this command, return number of rows affected:
	            int count = preparedStatement.executeUpdate();
	            // lets us return the id that is auto-generated
	            ResultSet resultSet = preparedStatement.getGeneratedKeys();
	            // if we affected one or more rows:
	            if (count > 0) {
	                System.out.println("Department added!");
	                // return the generated id:
	                // before we call resultSet.next(), it's basically pointing to nothing useful
	                // but moving that pointer allows us to get the information that we want
	                resultSet.next();
	                int id = resultSet.getInt(1);
	                return id;
	            }
	            // if 0 rows are affected, something went wrong:
	            else {
	                System.out.println("Something went wrong when trying to add that department!");
	                return -1;
	            }
	        } catch (SQLException e){
	            // print out what went wrong:
	            e.printStackTrace();
	            return -1;
	        }
		 }

	@Override
	public Department getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Department updatedObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Department objToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Department> getDepHeadID(String depHeadID) {
		// TODO Auto-generated method stub
		return null;
	}
}