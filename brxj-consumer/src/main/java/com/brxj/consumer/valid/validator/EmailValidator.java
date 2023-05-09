package com.brxj.consumer.valid.validator;

import com.brxj.consumer.valid.Email;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * 邮箱校验器
 *
 * @author qianrui
 */
@NoArgsConstructor
public class EmailValidator implements ConstraintValidator<Email, String> {

    public static final String EMAIL_PATTERN =
            "^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][A-Za-z0-9]+)*$";

    @Override
    public void initialize(Email email) {
        ConstraintValidator.super.initialize(email);
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext context) {
        return Objects.isNull(str) || str.matches(EMAIL_PATTERN);
    }
}
