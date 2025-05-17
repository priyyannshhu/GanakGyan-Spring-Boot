package com.ganakgyan.employee_graphql.service;

import com.ganakgyan.employee_graphql.dto.EmployeeInput;
import com.ganakgyan.employee_graphql.dto.EmployeeUpdateInput;
import com.ganakgyan.employee_graphql.model.Employee;
import com.ganakgyan.employee_graphql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createEmployee(EmployeeInput employeeInput) {
        try {
            Employee employee = Employee.builder()
                    .empName(employeeInput.getEmpName())
                    .salary(employeeInput.getSalary())
                    .address(employeeInput.getAddress())
                    .build();

            employeeRepository.save(employee);
            return "Employee created successfully";
        } catch (Exception e) {
            return "Error creating employee: " + e.getMessage();
        }
    }

    public List<Employee> getAllEmployees() {
        try {
            return employeeRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching employees: " + e.getMessage());
        }
    }

    public Optional<Employee> getEmployeeById(String empId) {
        try {
            return employeeRepository.findById(empId);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching employee: " + e.getMessage());
        }
    }

    public String updateEmployee(EmployeeUpdateInput employeeUpdateInput) {
        try {
            Optional<Employee> existingEmployee = employeeRepository.findById(employeeUpdateInput.getEmpId());

            if (existingEmployee.isPresent()) {
                Employee employee = existingEmployee.get();

                // Update only non-null fields
                if (employeeUpdateInput.getEmpName() != null) {
                    employee.setEmpName(employeeUpdateInput.getEmpName());
                }

                if (employeeUpdateInput.getSalary() != null) {
                    employee.setSalary(employeeUpdateInput.getSalary());
                }

                if (employeeUpdateInput.getAddress() != null) {
                    employee.setAddress(employeeUpdateInput.getAddress());
                }

                employeeRepository.save(employee);
                return "Employee updated successfully";
            } else {
                return "Employee not found with ID: " + employeeUpdateInput.getEmpId();
            }
        } catch (Exception e) {
            return "Error updating employee: " + e.getMessage();
        }
    }

    public String deleteEmployee(String empId) {
        try {
            if (employeeRepository.existsById(empId)) {
                employeeRepository.deleteById(empId);
                return "Employee deleted successfully";
            } else {
                return "Employee not found with ID: " + empId;
            }
        } catch (Exception e) {
            return "Error deleting employee: " + e.getMessage();
        }
    }
}