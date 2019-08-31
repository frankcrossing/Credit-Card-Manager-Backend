package com.jieandata.utils.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Auther: pengke
 * @Date: 2019-7-24 16:45
 * @Description: 完善状态枚举
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CompleteStatEnum {
    UN_PERFECT("0","未完善"),
    HAS_PERFECT("1","已完善");
    private String code;
    private String desc;

    CompleteStatEnum(String code, String desc){
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
