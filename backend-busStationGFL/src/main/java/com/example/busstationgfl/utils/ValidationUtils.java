package com.example.busstationgfl.utils;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.busstationgfl.exception.ValidationException;

import java.util.Set;

@Service
@AllArgsConstructor
public class ValidationUtils {
    private final Validator validator;

    public <T> void validate(T entity) {
        if (entity != null) {
            Set<ConstraintViolation<T>> validateResult = validator.validate(entity);
            if (!validateResult.isEmpty()) {
                String allValidateTroubles = validateResult.stream()
                        .map(ConstraintViolation::getMessage)
                        .reduce((m1, m2) -> m1 + ", " + m2)
                        .get();
                throw new ValidationException(allValidateTroubles);
            }
        }
    }
}
