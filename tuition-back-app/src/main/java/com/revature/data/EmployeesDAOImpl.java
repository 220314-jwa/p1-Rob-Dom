package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.service.ConnectionFactory;
import com.revature.trms.Employees;
import com.revature.trms.Event;

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
	            preparedStatement.setLong(4, newObj.getDeptId());
	            
	            // execute this command, return the number of impacted rows:
	            int count = preparedStatement.executeUpdate();
	            // return the id that's auto-generated
	            ResultSet resultSet = preparedStatement.getGeneratedKeys();
	            // if one or more rows are affected:
	            if (count > 0) {
	                System.out.println("Employee added!");
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
	public Employees getById(long id) {
		// TODO Auto-generated method stub
		String sql = "Select * from Employee e where e.empl_id= ?;";
		Employees empl = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setLong(1,id);
			// execute the command, and save the count of rows affected:
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				empl = EmployeesDAOImpl.parseResultSet(resultSet);
				// now, we've created a pet Java object based on the info from our table:
			} else {
				System.out.println("User with id - " + id +" - does not exist!");
				// return null in this case:
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empl;
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

	private static Employees parseResultSet(ResultSet resultSet) {
		// TODO Auto-generated method stub
		Employees employee = new Employees();

		try {
			employee.setDeptId(resultSet.getInt(1));
			employee.setFirstName(resultSet.getString(2));
			employee.setLastName(resultSet.getString(3));
			employee.setPassword(resultSet.getString(4));
			employee.setManagerId(resultSet.getInt(5));
			employee.setDeptId(resultSet.getInt(6));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}
	
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employees getByUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "Select * from Employee e where e.username= ?;";
		Employees empl = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1,username);
			// execute the command, and save the count of rows affected:
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				empl = EmployeesDAOImpl.parseResultSet(resultSet);
				// now, we've created a pet Java object based on the info from our table:
			} else {
				//System.out.println("Something went wrong when querying the employee!");
				// return null in this case:
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empl;
	}

	@Override
	public int create(Event newObj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
