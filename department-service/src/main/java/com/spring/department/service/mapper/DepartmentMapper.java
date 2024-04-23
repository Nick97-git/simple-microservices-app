package com.spring.department.service.mapper;

import com.spring.department.service.config.MapperConfig;
import com.spring.department.service.dto.DepartmentCreationDto;
import com.spring.department.service.dto.DepartmentResponseDto;
import com.spring.department.service.entity.Department;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface DepartmentMapper {
  Department mapToEntity(DepartmentCreationDto departmentCreationDto);

  DepartmentResponseDto mapToDto(Department department);
}
