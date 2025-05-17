package com.ganakgyan.employee_crud.repository;

import com.ganakgyan.employee_crud.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    // Add custom query methods if needed
}