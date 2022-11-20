package com.masai.usecases;

import java.util.List;

import com.masai.dao.DepartmentDao;
import com.masai.dao.DepartmentDaoImpl;
import com.masai.exception.DepartmentException;
import com.masai.model.*;

public class GetEmpInAcc {

	public static void main(String[] args) {
		
		DepartmentDao dao = new DepartmentDaoImpl();
		
		try {
			List<EmployeeDepartmentDTO> dtos = dao.getEmpInAcc();
			
			dtos.forEach(dto -> System.out.println(dto));
		} catch (DepartmentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
