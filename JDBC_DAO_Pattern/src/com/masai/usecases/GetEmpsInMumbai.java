package com.masai.usecases;

import java.util.List;

import com.masai.dao.DepartmentDao;
import com.masai.dao.DepartmentDaoImpl;
import com.masai.exception.EmployeeException;
import com.masai.model.EmployeeDepartmentDTO;

public class GetEmpsInMumbai {

	public static void main(String[] args) {
		DepartmentDao dao = new DepartmentDaoImpl();
		try {
			List<EmployeeDepartmentDTO> empDets = dao.getEmpsInMumbai();
			empDets.forEach(emp -> System.out.println(emp));
		} catch (EmployeeException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
