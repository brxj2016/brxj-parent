package com.brxj.consumer.valid;

import com.brxj.consumer.valid.validator.CollectionLimitValidator;
import com.brxj.consumer.valid.validator.MapLimitValidator;
import com.brxj.consumer.valid.validator.StringLimitValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * 限定注解
 *
 * @author qianrui
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Limit.List.class)
@Documented
@Constraint(validatedBy = {StringLimitValidator.class, CollectionLimitValidator.class, MapLimitValidator.class})
public @interface Limit {

    /** 最小值 */
    int min() default -1;

    /** 最大值 */
    int max() default -1;

    /** 是否允许空 */
    boolean allowNull() default true;

    /** 是否允许空内容 */
    boolean allowEmpty() default false;

    /** 是否允许空白内容 */
    boolean allowBlack() default false;

    String message() default "内容不符合限定要求";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {

        Limit[] value();
    }
}
