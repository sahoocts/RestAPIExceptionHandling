package com.dailycodebuffer.springbootdemoproject.service;

import com.dailycodebuffer.springbootdemoproject.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    List<Employee> getEmployee();

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String id);
}
