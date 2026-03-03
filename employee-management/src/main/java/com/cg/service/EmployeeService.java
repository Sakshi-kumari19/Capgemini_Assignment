package com.cg.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.cg.bean.Employee;
import com.cg.dao.EmployeeDao;
import com.cg.dao.IEmployeeDao;


public class EmployeeService implements IEmployeeService {
	IEmployeeDao dao=new EmployeeDao();

	
	@Override
	public String createEmployee(Employee emp) {
		if(emp.getName()==null || emp.getName().length()<4 || emp.getEmail()==null ) {
			return "Invalid Employee Data";
		}
		else {
			Random r=new Random();
			String empid=emp.getName().substring(0,3)+r.nextInt(1000);
			emp.setEmpid(empid);
			return dao.saveEmployee(emp);
		}
	}

	@Override
	public Employee findById(String eid) {

        if(eid.length()<4){
			System.out.println("Invalid Id");

		}else{
            try {
                return dao.findEmployee(eid);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return dao.getAll();
	}

	@Override
	public String updateEmployeeName(String eid, String name) {
		if(eid==null || eid.length()<4 || name==null || name.length()<4){
			return "Invalid value";
		}
		return dao.updateEmployeeName(eid,name);
	}

	@Override
	public String removeEmployee(String empid) {
		if(empid.length()<4)
			return "Invalid Id";
		return dao.deleteEmployee(empid);
	}

}
