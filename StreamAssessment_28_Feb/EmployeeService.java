package com.labs.StreamAssessment_28_Feb;

import com.labs.Employee;
import com.labs.EmployeeRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeService {


     /*
1. Calculate average salary.
2. Find employee with maximum salary in each department.
3. Calculate total salary per department.
4. Display employee name and salary.
5. Sort by salary in descending order
      */

    //1.
    public double avgSalary() {
        double avg = EmployeeRepository.getEmployees().stream().map(e -> e.getSalary()).collect(Collectors.averagingDouble(e -> e));

        return avg;
    }

    //2.
    public Map<String,Optional<Employee>> empWithMaxSalInEachDept() {
        Map<String,Optional<Employee>> emp  = EmployeeRepository.getEmployees().stream().filter(e->e.getDepartment()!=null).collect(Collectors.groupingBy(e->e.getDepartment().getDepartmentName(),Collectors.maxBy(Comparator.comparingDouble(e->e.getSalary()))));
        return emp;
    }


    //3.
    public Map<String, Double> totalSalPerDept() {
        Map<String, Double> mp = EmployeeRepository.getEmployees().stream().filter(e -> e.getDepartment() != null).collect(Collectors.groupingBy(e -> e.getDepartment().getDepartmentName(), Collectors.summingDouble(Employee::getSalary)));
        return mp;
    }

    //4.
     public List<String> empAndSalary() {
         List<String> mp = EmployeeRepository.getEmployees().stream().map(e -> {
             return e.getFirstName() + " " + e.getLastName() + "  " + e.getSalary();
         }).toList();
         return mp;
     }
     //5.
     public List<Employee> salByDesc(){
         List li = EmployeeRepository.getEmployees().stream().sorted((e1, e2)->Double.compare(e2.getSalary(), e1.getSalary())).toList();
         return li;
     }

}

