package com.brxj.consumer.valid;

import com.brxj.consumer.valid.validator.PasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * 密码注解
 *
 * @author qianrui
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Password.List.class)
@Documented
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {

    /** 最小长度 */
    int min() default 6;

    /** 最大长度 */
    int max() default 16;

    /** 权重 */
    Weight weight() default Weight.STANDARD;

    /** 字符集 */
    String charSet() default "!?._";

    String message() default "密码不符合规范";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 密码权重枚举
     *
     * @author qianrui
     */
    enum Weight {

        /*
         * NONE(无): 大写字母、小写字母、数字、字符集任意组合
         * SIMPLE(简易): 大写字母或小写字母、数字或字符集组合
         * STANDARD(标准): 大写字母或小写字母、数字、字符集组合
         * STRICT(严格): 大写字母、小写字母、数字、字符集组合
         *  */
        NONE, SIMPLE, STANDARD, STRICT
    }

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {

        Password[] value();
    }
}
