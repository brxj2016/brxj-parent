package com.brxj.consumer.valid;

import com.brxj.consumer.valid.validator.KeyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * 键限定
 *
 * @author qianrui
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Key.List.class)
@Documented
@Constraint(validatedBy = KeyValidator.class)
public @interface Key {

    /** 限定键 */
    String[] limit() default {};

    /** 必填键 */
    String[] require() default {};

    /** 是否允许空 */
    boolean allowNull() default false;

    String message() default "参数不符合限定要求";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {

        Key[] value();
    }
}
