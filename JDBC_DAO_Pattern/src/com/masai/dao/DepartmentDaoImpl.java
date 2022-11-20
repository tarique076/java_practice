package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.model.EmployeeDepartmentDTO;
import com.masai.utility.DBUtil;

public class DepartmentDaoImpl implements DepartmentDao{

	@Override
	public List<EmployeeDepartmentDTO> getEmpInAcc() throws DepartmentException {
		
		List<EmployeeDepartmentDTO> dtos = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from Employee e INNER JOIN department d "
														+ "ON e.deptid=d.did where dname='accounts'");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				EmployeeDepartmentDTO dto = new EmployeeDepartmentDTO();
				
				dto.setEmpid(rs.getInt("empid"));
				dto.setEname(rs.getString("ename"));
				dto.setAddress(rs.getString("address"));
				dto.setMobile(rs.getString("mobile"));
				dto.setDeptid(rs.getInt("deptid"));
				dto.setDname(rs.getString("dname"));
				dto.setLocation(rs.getString("location"));
				
				dtos.add(dto);
				
			}
			
			if(dtos.size()==0) {
				throw new DepartmentException("No employee in accounts department");
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new DepartmentException(e.getMessage()); 
		}
		
		return dtos;
	}

	@Override
	public String delDepartmentByDid(int did) throws DepartmentException {
		String res = "Department deleted..";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from department where did = ?");
			
			ps.setInt(1, did);
			
			int x = ps.executeUpdate();
			if(x>0) {
				res = "Department deleted successfully";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<EmployeeDepartmentDTO> getEmpsInMumbai() throws EmployeeException {
		List<EmployeeDepartmentDTO> emps = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select did, dname, location from department d"
					+ "INNER JOIN employee e ON d.did=e.deptid where e.address='mumbai' ");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				EmployeeDepartmentDTO dto = new EmployeeDepartmentDTO();
				dto.setDeptid(rs.getInt("did"));
				dto.setDname(rs.getString("dname"));
				dto.setLocation(rs.getString("location"));
				
				emps.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emps;
	}

	
}
