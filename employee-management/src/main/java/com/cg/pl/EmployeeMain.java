package com.cg.pl;

import com.cg.bean.Employee;
import com.cg.service.EmployeeService;
import com.cg.service.IEmployeeService;

import java.util.List;
import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) {
		IEmployeeService es=new EmployeeService();
		String id;
		Scanner sc = new Scanner(System.in);
		String result=es.createEmployee(new Employee("Parul", "parul@gmail.com", "2005-06-16"));
		System.out.println(result);

		System.out.println("Enter emp id : ");
		String eid = sc.next();
		Employee e = es.findById(eid);
		System.out.println(e.getEmpid()+"\t"+e.getName()+"\t"+e.getEmail()+"\t"+e.getDob());

		System.out.println("List of all Employees.....");
		List<Employee> ls = es.getAllEmployee();
		ls.stream().forEach(e1->{
			System.out.println(e1.getEmpid()+"\t"+e1.getName()+"\t"+e1.getEmail()+"\t"+e1.getDob());
		});

		System.out.println("Enter Employee Id : ");
		id = sc.next();
		System.out.println("Enter name to update");
		String name = sc.next();
		System.out.println(es.updateEmployeeName(id,name));

		System.out.println("Enter Employee Id to delete : ");
		id = sc.next();
		System.out.println(es.removeEmployee(id));





	}

}
