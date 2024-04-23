package com.spring.employee.service.dto.department;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrganizationResponseDto {
  private Long id;
  private String code;
  private String name;
  private String description;
  private LocalDateTime createTime;
}
