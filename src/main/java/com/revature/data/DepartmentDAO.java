package com.revature.data;

import java.util.List;
import com.revature.trms.Department;

public interface DepartmentDAO extends GenericDAO<Department>{
	public List<Department> getDepHeadID(String depHeadID);
}
