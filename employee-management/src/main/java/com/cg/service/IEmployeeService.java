package com.cg.service;

import java.util.List;

import com.cg.bean.Employee;

public interface IEmployeeService {
	public String createEmployee(Employee emp);
	public Employee findById(String eid);
	public List<Employee> getAllEmployee();
	public String updateEmployeeName(Employee emp);
	public String removeEmployee(String empid);
}
