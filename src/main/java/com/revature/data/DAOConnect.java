package com.revature.data;
//this is essentially the DAO Factory
public class DAOConnect {
	private static DepartmentDAO DepartmentDAO = null;
    private static EmployeesDAO EmployeesDAO = null;
    private static EventDAO EventDAO = null;
    private static ManagersDAO ManagersDAO = null;
    private static ReimbursementDAO ReimbursementDAO = null;
    private static StatusDAO StatusDAO = null;
    
 // make our constructor private, so it can't be accessed publicly
    private DAOConnect() { }

    public static DepartmentDAO getDepartmentDAO() throws ClassNotFoundException {
        // make sure we're not recreating the dao if it already exists:
        if (DepartmentDAO == null) {
        	DepartmentDAO = new DepartmentDAOImpl();
        }
        return DepartmentDAO;
    }
    
    public static EmployeesDAO getEmployeesDAO() throws ClassNotFoundException {
    	if (EmployeesDAO == null)
    		EmployeesDAO = new EmployeesDAOImpl();
    	return EmployeesDAO;
    }
    public static EventDAO getEventDAO() {
        // make sure we're not recreating the dao if it already exists:
        if (EventDAO == null) {
        	EventDAO = new EventDAOImpl();
        }
        return EventDAO;
    }
    
    public static ManagersDAO getManagersDAO() {
    	if (ManagersDAO == null)
    		ManagersDAO = new ManagersDAOImpl();
    	return ManagersDAO;
    }
    public static ReimbursementDAO getReimbursementDAO() throws ClassNotFoundException {
        // make sure we're not recreating the dao if it already exists:
        if (ReimbursementDAO == null) {
        	ReimbursementDAO = new ReimbursementDAOImpl();
        }
        return ReimbursementDAO;
    }
    
    public static StatusDAO getStatusDAO() {
    	if (StatusDAO == null)
    		StatusDAO = new StatusDAOImpl();
    	return StatusDAO;
    }
}
