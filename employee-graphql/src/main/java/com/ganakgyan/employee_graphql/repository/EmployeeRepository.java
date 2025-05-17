package com.ganakgyan.employee_graphql.repository;

import com.ganakgyan.employee_graphql.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    // You can add custom query methods here if needed
}