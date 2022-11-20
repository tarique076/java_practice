package com.masai.dao;

import java.util.List;

import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.model.EmployeeDepartmentDTO;

public interface DepartmentDao {

	public List<EmployeeDepartmentDTO> getEmpInAcc() throws DepartmentException;
	
	public String delDepartmentByDid(int did) throws DepartmentException;
	
	public List<EmployeeDepartmentDTO> getEmpsInMumbai() throws EmployeeException;
	
}
