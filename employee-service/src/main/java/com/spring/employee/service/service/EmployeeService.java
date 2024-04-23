package com.spring.employee.service.service;

import com.spring.employee.service.entity.Employee;
import com.spring.employee.service.exception.EntityNotFoundException;
import com.spring.employee.service.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployeeService {
  private final EmployeeRepository employeeRepository;

  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

  public Employee getById(Long id) {
    return employeeRepository.findById(id)
        .orElseThrow(EntityNotFoundException.supplierById(Employee.class, id));
  }
}
