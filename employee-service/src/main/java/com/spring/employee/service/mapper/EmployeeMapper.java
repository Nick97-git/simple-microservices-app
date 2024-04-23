package com.spring.employee.service.mapper;

import com.spring.employee.service.config.MapperConfig;
import com.spring.employee.service.dto.department.DepartmentResponseDto;
import com.spring.employee.service.dto.department.OrganizationResponseDto;
import com.spring.employee.service.dto.employee.EmployeeCreationDto;
import com.spring.employee.service.dto.employee.EmployeeResponseDto;
import com.spring.employee.service.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface EmployeeMapper {
  Employee mapToEntity(EmployeeCreationDto employeeCreationDto);

  EmployeeResponseDto mapToDto(Employee employee);

  @Mapping(target = "id", source = "employee.id")
  @Mapping(target = "department", source = "departmentDto")
  @Mapping(target = "organization", source = "organizationDto")
  EmployeeResponseDto mapToDto(
      Employee employee,
      DepartmentResponseDto departmentDto,
      OrganizationResponseDto organizationDto
  );
}
