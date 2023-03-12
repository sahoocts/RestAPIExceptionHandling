package com.dailycodebuffer.springbootdemoproject.service;

import com.dailycodebuffer.springbootdemoproject.error.EmployeeNotFoundException;
import com.dailycodebuffer.springbootdemoproject.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    List<Employee> employees=new ArrayList<>();
    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId()==null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getEmployee() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees.stream().filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst().orElseThrow(()->new EmployeeNotFoundException(""+"Employee not found with id:"+id));
    }

   /* @Override-------for generic exception
    public Employee getEmployeeById(String id) {
        return employees.stream().filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst().orElseThrow(()->new RuntimeException(""+"Employee not found with id:"+id));
    }*/

    public String deleteEmployeeById(String id){
        Employee employee=employees.stream().filter(e->e.getEmployeeId().equalsIgnoreCase(id)).findFirst()
                .get();
        employees.remove(employee);
        return "Emloyee deleted by id"+id;
    }
}
