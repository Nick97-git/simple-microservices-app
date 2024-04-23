package com.spring.employee.service.dto.employee;

import com.spring.employee.service.dto.department.DepartmentResponseDto;
import com.spring.employee.service.dto.department.OrganizationResponseDto;
import lombok.Data;

@Data
public class EmployeeResponseDto {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private DepartmentResponseDto department;
  private OrganizationResponseDto organization;
}
