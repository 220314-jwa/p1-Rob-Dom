package com.revature.data;

import java.security.Timestamp;
import java.sql.*;
import java.util.*;
import java.util.Date;

import com.revature.service.ConnectionFactory;
import com.revature.trms.Employees;
import com.revature.trms.Event;
import com.revature.trms.Reimbursement;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	Connection connect;

	public ReimbursementDAOImpl() throws ClassNotFoundException {
		connect = ConnectionFactory.getConnected();
	}

	@Override
	public int create(Reimbursement newObj) {
		 String sql = "insert into Reimbursement (requestId, submitterId, eventId, statusId, eventDate, description, location, submittedAt)" +
	                "values (default, ?, ?, ?, ?, ?, ?, ?)";
		 
		 try {
			 PreparedStatement preparedStatement = connect.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	            // set the fields:
	            preparedStatement.setLong(1, newObj.getRequestId());
	            preparedStatement.setLong(3, newObj.getEventId());
	            preparedStatement.setLong(4, newObj.getStatusId());
	            preparedStatement.setDate(5, new java.sql.Date(newObj.getEventDate().getTime()));
	            preparedStatement.setString(6, newObj.getDescription());
	            preparedStatement.setString(7, newObj.getDescription());
	            
	            int count = preparedStatement.executeUpdate();
	            ResultSet resultSet = preparedStatement.getGeneratedKeys();
	            if (count > 0) {
	            	System.out.println("Request completed");
	            	resultSet.next();
	            	int id = resultSet.getInt(1);
	                newObj.setEventId(id);
	                connect.commit();
	            } else {
	            	System.out.println("Request not completed");
	            	connect.rollback();
	            }
		 } catch (SQLException e) {
	            	e.printStackTrace();
	            	try {
	            		connect.rollback();
	            	} catch (SQLException e1) {
		            	e.printStackTrace();
	            } finally {
	            	try {
	            		connect.close();
	            	} catch(SQLException e2){
	            		e.printStackTrace();
	            	}
	            	}
	            }
		return -1;
	            	}

	@Override
	public Reimbursement getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Reimbursement updatedObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Reimbursement objToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reimbursement> getAllByEmployee(Employees employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementsByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Event newObj) {
		// TODO Auto-generated method stub
		return 0;
	}
}
