package com.spring.employee.service.exception;

import java.util.function.Supplier;

public class EntityNotFoundException extends RuntimeException {
  private EntityNotFoundException(String message) {
    super(message);
  }

  public static Supplier<EntityNotFoundException> supplierById(
      Class<?> clazz,
      Long id
  ) {
    return () -> new EntityNotFoundException(
        "Can't find %s by id = %s".formatted(clazz.getSimpleName(), id)
    );
  }
}
