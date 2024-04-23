package com.spring.employee.service.service;

import com.spring.employee.service.dto.department.OrganizationResponseDto;
import com.spring.employee.service.service.client.OrganizationServiceFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrganizationService {
  private final OrganizationServiceFeignClient client;

  public OrganizationResponseDto getByCode(String code) {
    return client.getByCode(code);
  }
}
