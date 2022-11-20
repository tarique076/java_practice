package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;

public class DeleteEmpByDid {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter department id to delete records");
		int deptid = sc.nextInt();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			String res = dao.delEmpbyDid(deptid);
			System.out.println(res);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
