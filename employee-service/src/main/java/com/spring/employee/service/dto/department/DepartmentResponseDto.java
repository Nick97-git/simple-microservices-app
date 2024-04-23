package com.spring.employee.service.dto.department;

import lombok.Data;

@Data
public class DepartmentResponseDto {
  private Long id;
  private String code;
  private String name;
  private String description;
}
