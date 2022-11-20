package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.DepartmentDao;
import com.masai.dao.DepartmentDaoImpl;
import com.masai.exception.DepartmentException;

public class DeleteDeptByDid {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter department id to be deleted.");
		int did = sc.nextInt();
		
		DepartmentDao dao = new DepartmentDaoImpl();
		
		try {
			String res = dao.delDepartmentByDid(did);
			System.out.println(res);
		} catch (DepartmentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
