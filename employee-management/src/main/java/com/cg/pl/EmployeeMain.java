package com.cg.pl;

import com.cg.bean.Employee;
import com.cg.service.EmployeeService;
import com.cg.service.IEmployeeService;

import java.util.List;
import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) {
		IEmployeeService es=new EmployeeService();
		Scanner sc = new Scanner(System.in);
		String id,name,email,dob,result;
		Employee e;


		int choice;
		while(true){
			System.out.println("-----Employee Management System--------------");
			System.out.println("1. Create Employee");
			System.out.println("2. Find Employee");
			System.out.println("3. List of All Employees");
			System.out.println("4. Update Employee Data");
			System.out.println("5. Delete Employee Data");
			System.out.println("6. Exit");
			System.out.println("--------------------------------------------");
			System.out.println("Enter your choice : ");
			choice = sc.nextInt();

			switch(choice){
				case 1:
					System.out.println("Enter name of employee : ");
					name = sc.next();
					System.out.println("Enter email : ");
					email = sc.next();
					System.out.println("Enter DOB : ");
					dob = sc.next();
					result=es.createEmployee(new Employee(name, email, dob));
					System.out.println(result);
					break;

				case 2:
					System.out.println("Enter Employee Id : ");
					id = sc.next();
					e = es.findById(id);
					if(e!=null)
						System.out.println(e.getEmpid()+"\t"+e.getName()+"\t"+e.getEmail()+"\t"+e.getDob());
					break;

				case 3:
					System.out.println("List of all Employees.....");
					List<Employee> ls = es.getAllEmployee();
					ls.forEach(e1-> System.out.println(e1.getEmpid()+"\t"+e1.getName()+"\t"+e1.getEmail()+"\t"+e1.getDob()));
					break;

				case 4:
					System.out.println("Enter Employee Id : ");
					id = sc.next();
					System.out.println("Enter data to update (press Enter to skip) : ");
					System.out.println("Name : ");
					sc.nextLine();
					name = sc.nextLine();
					System.out.println("Email : ");
					email = sc.nextLine();
					System.out.println("DOB : ");
					dob = sc.nextLine();
					e = new Employee();
					e.setEmpid(id);
					e.setName(name.isEmpty() ? null:name);
					e.setEmail(email.isEmpty() ? null:email);
					e.setDob(dob.isEmpty() ? null:dob);

					System.out.println(es.updateEmployeeName(e));
					break;

				case 5:
					System.out.println("Enter Employee Id to delete : ");
					id = sc.next();
					System.out.println(es.removeEmployee(id));
					break;

				case 6:
					return;



			}
		}

















	}

}
