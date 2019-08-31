package com.jieandata.service.annotation;

import java.lang.annotation.*;

/**
 * @Auther: pengke
 * @Date: 2019-8-2 17:37
 * @Description:
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ReportField {
    String value();
}
