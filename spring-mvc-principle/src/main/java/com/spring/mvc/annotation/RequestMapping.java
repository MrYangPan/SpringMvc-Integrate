package com.spring.mvc.annotation;

import java.lang.annotation.*;

/**
 * Created by Mr.PanYang on 2018/5/24.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface RequestMapping {
    String value() default "";
}
