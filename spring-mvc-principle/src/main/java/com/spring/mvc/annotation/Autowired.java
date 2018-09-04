package com.spring.mvc.annotation;

import java.lang.annotation.*;

/**
 * Created by Mr.PanYang on 2018/5/24.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface Autowired {
    String value() default "";
}
