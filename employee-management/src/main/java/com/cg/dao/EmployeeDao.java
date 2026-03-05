package com.cg.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.Employee;
import jakarta.persistence.*;

public class EmployeeDao implements IEmployeeDao{
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
	private static EntityManager em = emf.createEntityManager();
	private static EntityTransaction tx = em.getTransaction();
	//private static Connection con;
//	static {
//		try {
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Sk@24sql");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	@Override
	public String saveEmployee(Employee emp) {
//		try {
//			PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
//			ps.setString(1, emp.getEmpid());
//			ps.setString(2, emp.getName());
//			ps.setString(3, emp.getEmail());
//			ps.setString(4, emp.getDob());
//			int rows=ps.executeUpdate();
//			if(rows>0)
//				return "Employee Created";
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//		return "Employee Not Created";
		tx = em.getTransaction();
		tx.begin();
		em.persist(emp);
		tx.commit();
		return "Employee created";
	}

	@Override
	public Employee findEmployee(String empid) {

//        PreparedStatement ps = con.prepareStatement("select * from employee where eid=?");
//        ps.setString(1,empid);
//		ResultSet rs = ps.executeQuery();
//		rs.next();
//		Employee e = new Employee(rs.getString("name"),rs.getString("email"),rs.getString("dob"));
//		e.setEmpid(rs.getString("eid"));
//		return e;
		tx.begin();
		Employee emp = em.find(Employee.class,empid);
		tx.commit();
		if(emp!=null){
			return emp;
		}
		else{
			System.out.println("No Employee found...");
			return null;
		}
	}

	@Override
	public List<Employee> getAll() {
//		Employee emp;
//		List<Employee> ls;
//        try {
//            PreparedStatement ps = con.prepareStatement("select * from employee");
//			ResultSet rs = ps.executeQuery();
//			ls = new ArrayList<Employee>();
//			while(rs.next()){
//				   emp = new Employee(rs.getString(2),rs.getString(3),rs.getString(4));
//                   emp.setEmpid(rs.getString(1));
//				   ls.add(emp);
//			}
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return ls;
	       Query q = em.createQuery("select e from Employee e");
		   List<Employee> li = q.getResultList();
	       return li;

	}

	@Override
	public String updateEmployeeName(Employee emp) {
//        try {
//            PreparedStatement ps = con.prepareStatement("update employee set name=? where eid=?");
//			ps.setString(1,newName);
//			ps.setString(2,empid);
//			int rs = ps.executeUpdate();
//			if(rs>0)
//				return "Name Update Successfully...";
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return "Not Updated....";
		tx.begin();
		Employee e = em.find(Employee.class,emp.getEmpid());
		if (emp.getName() != null || emp.getEmail() != null || emp.getDob() != null) {
			if(emp.getName()!=null){
				e.setName(emp.getName());


			}
			if(emp.getEmail()!=null){
				e.setEmail(emp.getEmail());

			}
			if (emp.getDob() != null) {
				e.setDob(emp.getDob());

			}
			tx.commit();
			return "Data updated.....";
		}
		else {
			return "Data not updated..";
		}

	}

	@Override
	public String deleteEmployee(String empid) {
//        try {
//            PreparedStatement ps = con.prepareStatement("delete from employee where eid=?");
//			ps.setString(1,empid);
//		    int rs = ps.executeUpdate();
//			if(rs>0)
//				return "Data deleted...";
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return "Data not exists...";
		tx.begin();
		Employee emp = em.find(Employee.class,empid);
		if(emp!=null){
			em.remove(emp);
		    System.out.println(emp);
			tx.commit();
		    return "Data removed...";
		}else {
			return "Data not removed";
		}

	}

}
