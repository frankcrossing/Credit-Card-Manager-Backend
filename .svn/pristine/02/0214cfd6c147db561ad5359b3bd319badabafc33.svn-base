package com.jieandata.service.annotation;

import java.lang.annotation.*;

/**
 * @Auther: pengke
 * @Date: 2019-7-24 10:26
 * @Description: 脱敏字段注解
 * @See: https://github.com/DannyHoo/desensitized
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SensitiveField {

    SensitiveTypeEnum type() default SensitiveTypeEnum.CERT_NAME;

    enum SensitiveTypeEnum {
        /**
         * 姓名(李**)
         */
        CERT_NAME,
        /**
         * 手机(135****7120)
         */
        MP,
        /**
         * 固话(********1234)
         */
        FIXED_PHONE,
        /**
         * 身份证(**************1234)
         */
        CERT_ID,
        /**
         * 银行卡(6222600**********1234)
         */
        CARD_ID,
        /**
         * 地址(北京市海淀区****)
         */
        ADDRESS,
        /**
         * 邮箱(d**@126.com)
         */
        EMAIL,
        /**
         * 密码(******)
         */
        PASSWORD;
    }

}
