package com.ganakgyan.employee_graphql.config;

import com.ganakgyan.employee_graphql.model.Employee;
import com.ganakgyan.employee_graphql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
public class DataLoader {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Bean
    @Profile("dev")  // Only load sample data in development environment
    public CommandLineRunner loadData() {
        return args -> {
            // Check if we have data already
            if (employeeRepository.count() == 0) {
                // Add sample data
                List<Employee> employees = List.of(
                        Employee.builder()
                                .empName("John Doe")
                                .salary(75000.00)
                                .address("123 Main St, City")
                                .build(),
                        Employee.builder()
                                .empName("Jane Smith")
                                .salary(85000.00)
                                .address("456 Park Ave, Town")
                                .build()
                );

                employeeRepository.saveAll(employees);
                System.out.println("Sample data loaded successfully!");
            }
        };
    }
}