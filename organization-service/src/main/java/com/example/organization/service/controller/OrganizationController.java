package com.example.organization.service.controller;

import com.example.organization.service.dto.OrganizationCreationDto;
import com.example.organization.service.dto.OrganizationResponseDto;
import com.example.organization.service.entity.Organization;
import com.example.organization.service.mapper.OrganizationMapper;
import com.example.organization.service.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "OrganizationController")
@AllArgsConstructor
@RestController
@RequestMapping("/organizations")
public class OrganizationController {
  private final OrganizationMapper organizationMapper;
  private final OrganizationService organizationService;

  @Operation(summary = "Save an organization")
  @PostMapping
  public OrganizationResponseDto save(@RequestBody OrganizationCreationDto dto) {
    Organization organization = organizationMapper.mapToEntity(dto);
    organizationService.save(organization);
    return organizationMapper.mapToDto(organization);
  }

  @Operation(summary = "Get an organization by code")
  @GetMapping("/{code}")
  public OrganizationResponseDto getByCode(@PathVariable String code) {
    Organization organization = organizationService.getByCode(code);
    return organizationMapper.mapToDto(organization);
  }
}
