package com.brxj.consumer.valid.validator;

import com.brxj.consumer.valid.Code;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * 编号校验器
 *
 * @author qianrui
 */
@NoArgsConstructor
public class CodeValidator implements ConstraintValidator<Code, String> {

    private String pattern;

    @Override
    public void initialize(Code code) {
        ConstraintValidator.super.initialize(code);

        var min = Math.max(code.min(), 0);
        var max = code.max();
        max = max < min ? min + 10 : max;

        this.pattern = String.format("[a-zA-Z0-9]{%d,%d}", min, max);
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext context) {
        return Objects.isNull(str) || str.matches(pattern);
    }
}
