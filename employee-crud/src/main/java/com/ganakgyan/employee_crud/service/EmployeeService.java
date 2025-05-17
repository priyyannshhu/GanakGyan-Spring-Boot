package com.ganakgyan.employee_crud.service;

import com.ganakgyan.employee_crud.dto.EmployeeDTO;
import com.ganakgyan.employee_crud.model.Employee;
import com.ganakgyan.employee_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = Employee.builder()
                .empName(employeeDTO.getEmpName())
                .dob(employeeDTO.getDob())
                .address(employeeDTO.getAddress())
                .build();

        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(String id, EmployeeDTO employeeDTO) {
        // Check if employee exists
        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setEmpName(employeeDTO.getEmpName());
            employee.setDob(employeeDTO.getDob());
            employee.setAddress(employeeDTO.getAddress());

            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}