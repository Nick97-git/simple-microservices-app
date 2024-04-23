package com.spring.employee.service.service.client;

import com.spring.employee.service.dto.department.OrganizationResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE", path = "/api/organizations")
public interface OrganizationServiceFeignClient {
  @GetMapping("/{code}")
  OrganizationResponseDto getByCode(@PathVariable String code);
}
