package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public class InsertEmployeeUseCase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee id");
		int empid = sc.nextInt();
		System.out.println("Enter employee name");
		String ename = sc.next();
		System.out.println("Enter address");
		String address = sc.next();
		System.out.println("Enter mobile");
		String mobile = sc.next();
		System.out.println("Enter department id");
		int deptid = sc.nextInt();
		
		Employee emp = new Employee(empid, ename, address, mobile, deptid);
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			String res = dao.insertEmployee(emp);
			System.out.println(res);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
 	}
}
