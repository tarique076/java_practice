package com.masai.dao;

import javax.persistence.EntityManager;

import com.masai.bean.Employee;
import com.masai.util.EMUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void save(Employee emp) {
		String res = "Could not be saved";
		
		EntityManager em = EMUtil.provideEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(emp);
		res = "Employee saved";
		
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println(res);
	}

	@Override
	public String getAddressOfEmployee(int empId) {
		String add = "";
		
		EntityManager em = EMUtil.provideEntityManager();
		
		Employee emp = em.find(Employee.class, empId);
		
		add = emp.getAddress();
		return add;
	}

	@Override
	public String giveBonusToEmployee(int empId, int bonus) {
		
		EntityManager em = EMUtil.provideEntityManager();
		
		Employee emp = em.find(Employee.class, empId);
		
		String res = "Bonus of " + bonus + " provided to employee " + emp.getName();
		
		return res;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		boolean flag = false;
		
		EntityManager em = EMUtil.provideEntityManager();
		
		Employee emp = em.find(Employee.class, empId);
		
		if(emp!=null) {
			em.getTransaction().begin();
			em.remove(emp);
			
			flag = true;
			
			em.getTransaction().commit();
		}
		
		
		return flag;
	}

}
