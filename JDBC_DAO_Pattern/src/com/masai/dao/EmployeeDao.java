package com.masai.dao;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public interface EmployeeDao {
	
	public String insertEmployee(Employee emp) throws EmployeeException;
	
	public String delEmpbyDid(int deptid) throws EmployeeException;
}
