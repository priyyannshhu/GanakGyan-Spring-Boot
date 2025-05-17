package com.ganakgyan.employee_graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeUpdateInput {
    private String empId;
    private String empName;
    private Double salary;
    private String address;
}