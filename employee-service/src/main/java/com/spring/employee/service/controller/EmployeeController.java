package com.spring.employee.service.controller;

import com.spring.employee.service.dto.department.DepartmentResponseDto;
import com.spring.employee.service.dto.department.OrganizationResponseDto;
import com.spring.employee.service.dto.employee.EmployeeCreationDto;
import com.spring.employee.service.dto.employee.EmployeeResponseDto;
import com.spring.employee.service.entity.Employee;
import com.spring.employee.service.mapper.EmployeeMapper;
import com.spring.employee.service.service.DepartmentService;
import com.spring.employee.service.service.EmployeeService;
import com.spring.employee.service.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "EmployeeController")
@AllArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {
  private final DepartmentService departmentService;
  private final EmployeeMapper employeeMapper;
  private final EmployeeService employeeService;
  private final OrganizationService organizationService;

  @Operation(summary = "Save an employee")
  @PostMapping
  public EmployeeResponseDto save(@RequestBody EmployeeCreationDto employeeCreationDto) {
    Employee employee = employeeMapper.mapToEntity(employeeCreationDto);
    return employeeMapper.mapToDto(employeeService.save(employee));
  }

  @Operation(summary = "Get an employee by id")
  @GetMapping("/{id}")
  public EmployeeResponseDto getById(@PathVariable Long id) {
    Employee employee = employeeService.getById(id);
    DepartmentResponseDto departmentDto = departmentService.getByCode(employee.getDepartmentCode());
    OrganizationResponseDto organizationDto = organizationService.getByCode(employee.getOrganizationCode());
    return employeeMapper.mapToDto(employee, departmentDto, organizationDto);
  }
}
