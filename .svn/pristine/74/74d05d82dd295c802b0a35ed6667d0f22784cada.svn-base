package com.jieandata.utils.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Auther: pengke
 * @Date: 2019-7-24 16:39
 * @Description: 认证状态枚举
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AuthenticationStatEnum {
    UN_AUTHORIZED("0","未认证"),
    AUTHORIZED("1","已认证");
    private String code;
    private String desc;

    AuthenticationStatEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode(){
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
