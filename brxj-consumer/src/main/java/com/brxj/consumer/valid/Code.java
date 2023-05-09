package com.brxj.consumer.valid;

import com.brxj.consumer.valid.validator.CodeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * 编号注解
 *
 * @author qianrui
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Code.List.class)
@Documented
@Constraint(validatedBy = CodeValidator.class)
public @interface Code {

    /** 最小值 */
    int min() default 2;

    /** 最大值 */
    int max() default 20;

    String message() default "编号不符合规范";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {

        Code[] value();
    }
}
