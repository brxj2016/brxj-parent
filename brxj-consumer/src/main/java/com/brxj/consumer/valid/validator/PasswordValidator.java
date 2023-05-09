package com.brxj.consumer.valid.validator;

import com.brxj.consumer.valid.Password;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * 密码校验器
 *
 * @author qianrui
 */
@NoArgsConstructor
public final class PasswordValidator implements ConstraintValidator<Password, String> {

    /** 正则表达式 */
    private String pattern;

    @Override
    public void initialize(Password password) {
        ConstraintValidator.super.initialize(password);

        /* 字符集 */
        var charset = password.charSet();

        var min = Math.max(password.min(), 1);
        var max = password.max();
        max = max < min ? min + 10 : max;

        /* 表达式长度部分 */
        var length = String.format("{%d,%d}", min, max);
        /* 表达式限定部分 */
        var limit = String.format("[a-zA-Z0-9%s]", charset);
        /* 表达式正向匹配部分 */
        var positive = switch (password.weight()) {
            case NONE -> String.format("(?=.*[a-zA-Z0-9%s]", charset);
            case SIMPLE -> String.format("(?=.*[a-zA-Z])(?=.*[0-9%s])", charset);
            case STANDARD -> String.format("(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[%s])", charset);
            case STRICT -> String.format("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[%s])", charset);
        };

        this.pattern = String.format("^%s%s%s$", positive, limit, length);
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return Objects.isNull(password) || !password.isBlank() && password.matches(this.pattern);
    }
}
