package com.example.organization.service.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrganizationResponseDto {
  private Long id;
  private String name;
  private String description;
  private String code;
  private LocalDateTime createTime;
}
