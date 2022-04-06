package com.revature.data;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.service.ConnectionFactory;
import com.revature.trms.Employees;
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
	            preparedStatement.setLong(2, newObj.getSubmitterId());
	            preparedStatement.setLong(3, newObj.getEventId());
	            preparedStatement.setLong(4, newObj.getStatusId());
	            preparedStatement.setTimestamp(5, new Timestamp(newObj.getEventDate()));
	            preparedStatement.setString(6, newObj.getDescription());
	            preparedStatement.setString(7, newObj.getLocation());
	            preparedStatement.setTimestamp(8, new Timestamp(newObj.getSubmittedAt()));
	            
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
	            	}

	@Override
	public Reimbursement getById(int id) {
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
}
