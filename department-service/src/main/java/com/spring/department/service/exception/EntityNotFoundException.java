package com.spring.department.service.exception;

import java.util.function.Supplier;

public class EntityNotFoundException extends RuntimeException {
  private EntityNotFoundException(String message) {
    super(message);
  }

  public static Supplier<EntityNotFoundException> supplier(
      Class<?> clazz,
      String parameterName,
      Object parameterValue
  ) {
    return () -> new EntityNotFoundException(
        "Can't find %s by %s = %s".formatted(
            clazz.getSimpleName(),
            parameterName,
            parameterValue
        )
    );
  }
}
