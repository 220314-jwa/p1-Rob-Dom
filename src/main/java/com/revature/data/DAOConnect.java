package com.revature.data;
//this is essentially the DAO Factory
public class DAOConnect {
	private static DepartmentDAO departmentDAO = null;
    private static EmployeesDAO employeesDAO = null;
    private static EventDAO eventDAO = null;
    private static ManagersDAO managersDAO = null;
    private static ReimbursementDAO reimbursementDAO = null;
    private static StatusDAO statusDAO = null;
    
 // make our constructor private, so it can't be accessed publicly
    private DAOConnect() { 
    	
    }

    public static DepartmentDAO getDepartmentDAO() {
        // make sure we're not recreating the dao if it already exists:
        if (departmentDAO == null) {
        	departmentDAO = new DepartmentDAOImpl();
        }
        return departmentDAO;
    }
    
    public static EmployeesDAO getEmployeesDAO() {
    	if (employeesDAO == null) {
    		employeesDAO = new EmployeesDAOImpl();
    	}
    	return employeesDAO;
    }
    public static EventDAO getEventDAO() {
        // make sure we're not recreating the dao if it already exists:
        if (eventDAO == null) {
        	eventDAO = new EventDAOImpl();
        }
        return eventDAO;
    }
    
    public static ManagersDAO getManagersDAO() {
    	if (managersDAO == null) {
    		managersDAO = new ManagersDAOImpl();
    	}
    	return managersDAO;
    }
    public static ReimbursementDAO getReimbursementDAO() {
        // make sure we're not recreating the dao if it already exists:
        if (reimbursementDAO == null) {
        	reimbursementDAO = new ReimbursementDAOImpl();
        }
        return reimbursementDAO;
    }
    
    public static StatusDAO getStatusDAO() {
    	if (statusDAO == null) {
    		statusDAO = new StatusDAOImpl();
    	}
    	return statusDAO;
    }
}
