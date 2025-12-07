package com.wipro.employeemanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {
	
	public void addEmployee(Employee emp) throws SQLException{
		//PreparedStatement, Statement and CallableStatement
		String sql = "insert into employee(id, name, department, salary)values (?,?,?,?)";
		try(Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
		{
//			ps.setInt(1, 101);
//			ps.setString(2, "Sampath");
//			ps.setString(3, "Trainer");
//			ps.setDouble(4, 40000.00);
			ps.setInt(1, emp.getId());
	        ps.setString(2, emp.getName());
	        ps.setString(3, emp.getDepartment());
	        ps.setDouble(4, emp.getSalary());
			ps.executeUpdate();
		}
	}

}
