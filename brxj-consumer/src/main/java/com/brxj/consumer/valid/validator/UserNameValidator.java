package com.brxj.consumer.valid.validator;

import com.brxj.consumer.valid.Username;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * 用户名校验器
 *
 * @author qianrui
 */
@NoArgsConstructor
public final class UserNameValidator implements ConstraintValidator<Username, String> {

    /**
     * 正则表达式
     */
    private String pattern;

    @Override
    public void initialize(Username username) {
        ConstraintValidator.super.initialize(username);

        /* 字符集 */
        var charset = username.charSet();

        /* 表达式长度部分 */
        var length = String.format("{%d,%d}", Math.max(username.min(), 4), Math.min(username.max(), 20));

        this.pattern = String.format("^%s%s$", switch (username.scene()) {
            case USER_NAME -> String.format("[一-龥a-zA-Z0-9%s]", charset);
            case LOGIN_NAME -> String.format("[a-zA-Z0-9%s]", charset);
            case REAL_NAME -> "[一-龥]";
            case UID -> "[0-9]";
        }, length);
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return Objects.isNull(username) || !username.isBlank() && username.matches(this.pattern);
    }
}
