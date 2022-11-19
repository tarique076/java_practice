package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class DeleteEmployee {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id to delete");
		int id = sc.nextInt();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		if(dao.deleteEmployee(id)) {
			System.out.println("Employee deleted");
		}else {
			System.out.println("Employee not found.");
		}
	}
}
