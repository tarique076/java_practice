package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.utility.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String insertEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		String res = "Not inserted..";
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("insert into Employee values(?,?,?,?,?)");
			
			ps.setInt(1, emp.getEmpid());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getAddress());
			ps.setString(4, emp.getMobile());
			ps.setInt(5, emp.getDeptid());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				res = "Employee details added successfully";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		return res;
		
	}

	@Override
	public String delEmpbyDid(int deptid) throws EmployeeException {
		String res = "No employee in the department";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("delete from employee where deptid = ?");
			
			ps.setInt(1, deptid);
			
			int x = ps.executeUpdate();
			if(x>0) {
				res = ("Employees in department" + deptid +"deleted..");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		return res;
	}	
}
