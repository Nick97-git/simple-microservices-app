package com.spring.department.service.controller;

import com.spring.department.service.dto.DepartmentCreationDto;
import com.spring.department.service.dto.DepartmentResponseDto;
import com.spring.department.service.entity.Department;
import com.spring.department.service.mapper.DepartmentMapper;
import com.spring.department.service.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "DepartmentController")
@AllArgsConstructor
@RestController
@RequestMapping("/departments")
public class DepartmentController {
  private final DepartmentMapper departmentMapper;
  private final DepartmentService departmentService;

  @Operation(summary = "Save a department")
  @PostMapping
  public DepartmentResponseDto save(@RequestBody DepartmentCreationDto departmentCreationDto) {
    Department department = departmentMapper.mapToEntity(departmentCreationDto);
    return departmentMapper.mapToDto(departmentService.save(department));
  }

  @Operation(summary = "Get a department by code")
  @GetMapping("/{code}")
  public DepartmentResponseDto getByCode(@PathVariable String code) {
     Department department = departmentService.getByCode(code);
     return departmentMapper.mapToDto(department);
  }
}
