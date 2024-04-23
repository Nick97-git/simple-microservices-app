package com.spring.employee.service.dto.employee;

public record EmployeeCreationDto(
    String firstName,
    String lastName,
    String email,
    String departmentCode,
    String organizationCode
) {
}
