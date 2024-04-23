package com.example.organization.service.service;

import com.example.organization.service.entity.Organization;
import com.example.organization.service.exception.EntityNotFoundException;
import com.example.organization.service.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrganizationService {
  private final OrganizationRepository organizationRepository;

  public void save(Organization organization) {
    organizationRepository.save(organization);
  }

  public Organization getByCode(String code) {
    return organizationRepository.findByCode(code)
        .orElseThrow(
            EntityNotFoundException.supplier(
                Organization.class,
                "code",
                code
            )
        );
  }
}
