package com.cg.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.cg.bean.Employee;

public interface IEmployeeDao {
	public String saveEmployee(Employee emp);
	public Employee findEmployee(String empid) throws SQLException;
	public List<Employee> getAll();
	public String updateEmployeeName(Employee emp);
	public String deleteEmployee(String empid);
}
