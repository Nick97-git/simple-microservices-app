package com.spring.employee.service.service.client;

import com.spring.employee.service.dto.department.DepartmentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE", path = "/api/departments")
public interface DepartmentServiceFeignClient {
  @GetMapping("/{code}")
  DepartmentResponseDto getByCode(@PathVariable String code);
}
