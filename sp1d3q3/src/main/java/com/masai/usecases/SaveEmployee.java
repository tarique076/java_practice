package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Employee;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class SaveEmployee {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee name");
		String name = sc.next();
		System.out.println("Enter address");
		String address = sc.next();
		System.out.println("Enter salary");
		int salary = sc.nextInt();
		
		Employee em = new Employee();
		em.setName(name);
		em.setAddress(address);
		em.setSalary(salary);
		
		EmployeeDao dao = new EmployeeDaoImpl();
		dao.save(em);
	}
}
