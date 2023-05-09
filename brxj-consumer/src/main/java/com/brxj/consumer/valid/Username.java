package com.brxj.consumer.valid;

import com.brxj.consumer.valid.validator.UserNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * 用户名注解
 *
 * @author qianrui
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Username.List.class)
@Documented
@Constraint(validatedBy = UserNameValidator.class)
public @interface Username {

    /** 最小长度 */
    int min() default 4;

    /** 最大长度 */
    int max() default 20;

    /** 场景 */
    Scene scene() default Scene.USER_NAME;

    /** 字符集 */
    String charSet() default "!?._";

    String message() default "用户名不符合规范";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 用户名场景
     *
     * @author qianrui
     */
    enum Scene {

        /*
         * USER_NAME(用户名): 中文字符、大写字母、小写字母、数字、字符集任意组合
         * LOGIN_NAME(登录名): 大写字母、小写字母、数字、字符集任意组合
         * REAL_NAME(真实姓名): 限定中文字符
         * UID(用户ID): 限定数字
         * */
        USER_NAME, LOGIN_NAME, REAL_NAME, UID
    }

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {

        Username[] value();
    }
}
