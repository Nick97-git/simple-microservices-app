package com.spring.department.service.dto;

public record DepartmentCreationDto(
  String name,
  String description,
  String code
) {
}
