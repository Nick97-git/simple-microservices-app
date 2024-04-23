package com.example.organization.service.mapper;

import com.example.organization.service.config.MapperConfig;
import com.example.organization.service.dto.OrganizationCreationDto;
import com.example.organization.service.dto.OrganizationResponseDto;
import com.example.organization.service.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface OrganizationMapper {
  @Mapping(target = "createTime", ignore = true)
  Organization mapToEntity(OrganizationCreationDto dto);

  OrganizationResponseDto mapToDto(Organization organization);
}
