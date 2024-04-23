package com.spring.department.service.dto;

import lombok.Data;

@Data
public class DepartmentResponseDto {
  private Long id;
  private String name;
  private String description;
  private String code;
}
