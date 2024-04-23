package com.spring.department.service.service;

import com.spring.department.service.entity.Department;
import com.spring.department.service.exception.EntityNotFoundException;
import com.spring.department.service.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentService {
  private final DepartmentRepository departmentRepository;

  public Department save(Department department) {
    return departmentRepository.save(department);
  }

  public Department getByCode(String code) {
    return departmentRepository.findByCode(code)
        .orElseThrow(EntityNotFoundException.supplier(Department.class, "code", code));
  }
}
