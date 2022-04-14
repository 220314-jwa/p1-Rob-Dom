package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.service.ConnectionFactory;
import com.revature.trms.Department; //depHeadID
import com.revature.trms.Event;

public class DepartmentDAOImpl implements DepartmentDAO {
	Connection connection;

	public DepartmentDAOImpl() throws ClassNotFoundException {
		connection = ConnectionFactory.getConnected();
	}

	@Override
	public int create(Department newObj) {
		String sql = "insert into Department (depID, depName)" + "values (default, ?);";

		try {
			// create a prepared statement, we pass in the sql command
			// also the flag "RETURN_GENERATED_KEYS" so we can get that id that is generated
			PreparedStatement preparedStatement = connection.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			// set the fields:
			preparedStatement.setString(2, newObj.getDepName());
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
		} catch (SQLException e) {
			// print out what went wrong:
			e.printStackTrace();
			return -1;
		}

	}

	@Override
	public Department getById(int id) {
		String sql = "select * from department dep where Dep.id = ?; ";
		Department dept = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			 if(resultSet.next()) {
				 dept  = DepartmentDAOImpl.parseResultSet(resultSet);
				 return dept; }
			 else {
				 System.out.println("Something went wrong when querying the ID!");
			 }
		} catch(SQLException e){
			e.printStackTrace();
		} return null;
	}
	
	@Override
	public List<Department> getAll() {
		
		 List<Department> depts = new ArrayList<Department>();

	        String sql = "SELECT * FROM department;";
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            // get the result from our query:
	            ResultSet resultSet = preparedStatement.executeQuery();
	            // because the resultSet has multiple pets in it, we don't just want an if-statement. We want a loop:
	            while(resultSet.next()) {
	                Department dept = DepartmentDAOImpl.parseResultSet(resultSet);
	                depts.add(dept);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return depts;

		
	}

	private static Department parseResultSet(ResultSet resultSet) {
		// TODO Auto-generated method stub
		Department dept = new Department();

		try {
			dept.setDepID(resultSet.getInt(1));
			dept.setDepName(resultSet.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dept;
	}

	@Override
	public void update(Department updatedObj) {
		// we create the template for the SQL string:
    	String sql = "update department set dept_name = ? where id = ?;";
    	try {
        	PreparedStatement preparedStatement = connection.prepareStatement(sql);
        	// fill in the template:
        	preparedStatement.setString(1,updatedObj.getDepName());
        	preparedStatement.setLong(2,updatedObj.getDepID());

  
      
        	// return a count of how many records were updated
        	int count = preparedStatement.executeUpdate();
        	if(count != 1) {
        		System.out.println("Oops! Something went wrong with the update!");
        	}
        	
    		
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

	}

	@Override
	public void delete(Department objToDelete) {
		// TODO Auto-generated method stub
		String sql = "delete from department where id = ?;";
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, objToDelete.getDepID());
    		int count = preparedStatement.executeUpdate();
    		if (count != 1) {
    			System.out.println("Something went wrong with the deletion!");
    		}
    		else {
    			System.out.println("Dept with id"+objToDelete.getDepID()+"deleted");
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
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

	@Override
	public int create(Event newObj) {
		// TODO Auto-generated method stub
		return 0;
	}
}

//preparedStatement.setLong(1, newObj.getDepID());
//preparedStatement.setString(2, newObj.getDepName());
//preparedStatement.setLong(3, newObj.getDepHeadID());