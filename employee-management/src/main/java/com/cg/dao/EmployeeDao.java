package com.cg.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.Employee;

public class EmployeeDao implements IEmployeeDao{
	private static Connection con;
	static {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Sk@24sql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String saveEmployee(Employee emp) {
		try {
			PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
			ps.setString(1, emp.getEmpid());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getDob());
			int rows=ps.executeUpdate();
			if(rows>0)
				return "Employee Created";
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "Employee Not Created";
	}

	@Override
	public Employee findEmployee(String empid) throws SQLException {

        PreparedStatement ps = con.prepareStatement("select * from employee where eid=?");
        ps.setString(1,empid);
		ResultSet rs = ps.executeQuery();
		rs.next();
		Employee e = new Employee(rs.getString("name"),rs.getString("email"),rs.getString("dob"));
		e.setEmpid(rs.getString("eid"));
		return e;
	}

	@Override
	public List<Employee> getAll() {
		Employee emp;
		List<Employee> ls;
        try {
            PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			ls = new ArrayList<Employee>();
			while(rs.next()){
				   emp = new Employee(rs.getString(2),rs.getString(3),rs.getString(4));
                   emp.setEmpid(rs.getString(1));
				   ls.add(emp);
			}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ls;
	}

	@Override
	public String updateEmployeeName(String empid, String newName) {
        try {
            PreparedStatement ps = con.prepareStatement("update employee set name=? where eid=?");
			ps.setString(1,newName);
			ps.setString(2,empid);
			int rs = ps.executeUpdate();
			if(rs>0)
				return "Name Update Successfully...";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Not Updated....";
	}

	@Override
	public String deleteEmployee(String empid) {
        try {
            PreparedStatement ps = con.prepareStatement("delete from employee where eid=?");
			ps.setString(1,empid);
		    int rs = ps.executeUpdate();
			if(rs>0)
				return "Data deleted...";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return "Data not exists...";
	}

}
