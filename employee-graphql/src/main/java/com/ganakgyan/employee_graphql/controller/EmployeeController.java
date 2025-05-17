package com.ganakgyan.employee_graphql.controller;

import com.ganakgyan.employee_graphql.dto.EmployeeInput;
import com.ganakgyan.employee_graphql.dto.EmployeeUpdateInput;
import com.ganakgyan.employee_graphql.model.Employee;
import com.ganakgyan.employee_graphql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @QueryMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @QueryMapping
    public Employee getEmployeeById(@Argument String empId) {
        return employeeService.getEmployeeById(empId)
                .orElse(null);
    }

    @MutationMapping
    public String createEmployee(@Argument EmployeeInput employee) {
        return employeeService.createEmployee(employee);
    }

    @MutationMapping
    public String updateEmployee(@Argument EmployeeUpdateInput employee) {
        return employeeService.updateEmployee(employee);
    }

    @MutationMapping
    public String deleteEmployee(@Argument String empId) {
        return employeeService.deleteEmployee(empId);
    }
}