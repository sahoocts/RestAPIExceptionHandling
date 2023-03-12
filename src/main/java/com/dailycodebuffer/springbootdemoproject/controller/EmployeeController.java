package com.dailycodebuffer.springbootdemoproject.controller;

import com.dailycodebuffer.springbootdemoproject.model.Employee;
import com.dailycodebuffer.springbootdemoproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public Employee save(@RequestBody Employee employee){
           return employeeService.save(employee);
    }
    @GetMapping("/getE")
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable String id){
        return employeeService.deleteEmployeeById(id);
    }
}
