package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.revature.data.DAOConnect;
import com.revature.service.ConnectionFactory;
import com.revature.trms.Employees;

public class EmployeesDAOImpl implements EmployeesDAO {
	 Connection connection;
	 
	 public EmployeesDAOImpl () throws ClassNotFoundException {
	        connection = ConnectionFactory.getConnected();
	 }
	 
	 @Override
	 public int create(Employees newObj) {
		 String sql = "insert into Employees (employeeId, firstName, lastName, managerId, deptId)" +
	                "values (default, ?, ?, ?, ?)";
		 
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

	@Override
	public Employees getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employees> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Employees updatedObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employees objToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

}