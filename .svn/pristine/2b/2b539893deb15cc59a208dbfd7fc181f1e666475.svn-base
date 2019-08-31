package com.jieandata.utils.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Auther: pengke
 * @Date: 2019-7-24 18:01
 * @Description: 新客/老客
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserTypeEnum {
    NEW("NEW","新客"),
    OLD("OLD","老客");

    private String code;
    private String desc;

    UserTypeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static UserTypeEnum getMatchedEnum(String code) {
        for (UserTypeEnum tempEnum : UserTypeEnum.values()) {
            if (tempEnum.code.equals(code)) {
                return tempEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
