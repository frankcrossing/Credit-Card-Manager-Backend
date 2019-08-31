package com.jieandata.utils.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Auther: pengke
 * @Date: 2019-7-24 16:45
 * @Description: 分润模式枚举
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ShareProfitModeEnum {
    OFFLINE("0","线下"),
    ONLINE("1","线上");
    private String code;
    private String desc;

    ShareProfitModeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static ShareProfitModeEnum getMatchedEnum(String code) {
        for (ShareProfitModeEnum tempEnum : ShareProfitModeEnum.values()) {
            if (tempEnum.code.equals(code)) {
                return tempEnum;
            }
        }
        return null;
    }

    public String getCode(){
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
