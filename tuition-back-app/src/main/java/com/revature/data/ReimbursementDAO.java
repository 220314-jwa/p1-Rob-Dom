package com.revature.data;

import java.util.List;

import com.revature.trms.*;

public interface ReimbursementDAO extends GenericDAO<Reimbursement>{
	public abstract List<Reimbursement> getAllByEmployee(Employees employee);
	public abstract List<Reimbursement> getReimbursementsByStatus(String status);
}
