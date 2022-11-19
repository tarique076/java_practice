package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class GetAddress {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter empId to get address");
		int empId = sc.nextInt();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		System.out.println(dao.getAddressOfEmployee(empId));
	}
}
