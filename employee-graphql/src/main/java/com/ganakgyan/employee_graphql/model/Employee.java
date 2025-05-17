package com.ganakgyan.employee_graphql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "employee")
public class Employee {
    @Id
    private String empId;
    private String empName;
    private Double salary;
    private String address;
}