package com.spring.employee.service.service;

import com.spring.employee.service.dto.department.DepartmentResponseDto;
import com.spring.employee.service.service.client.DepartmentServiceFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class DepartmentService {
  private final DepartmentServiceFeignClient client;

  @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
  @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
  public DepartmentResponseDto getByCode(String code) {
    log.info("Getting department by code: {}", code);
    return client.getByCode(code);
  }

  public DepartmentResponseDto getDefaultDepartment(Exception e) {
    log.warn("Getting default department due to error: {}", e.getMessage());
    DepartmentResponseDto dto = new DepartmentResponseDto();
    dto.setDescription("Default department");
    dto.setCode("Default code");
    dto.setDescription("Default department description");
    return dto;
  }
}
