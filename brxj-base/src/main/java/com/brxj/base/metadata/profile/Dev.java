package com.brxj.base.metadata.profile;

import org.springframework.context.annotation.Profile;

import java.lang.annotation.*;

/**
 * 开发环境
 *
 * @author qianrui
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Profile(Active.DEV)
public @interface Dev {
}
