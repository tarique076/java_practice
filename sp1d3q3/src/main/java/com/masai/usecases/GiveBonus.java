package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class GiveBonus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id");
		int id = sc.nextInt();
		System.out.println("Enter bonus amount");
		int bonus = sc.nextInt();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		System.out.println(dao.giveBonusToEmployee(id, bonus));
	}
}
