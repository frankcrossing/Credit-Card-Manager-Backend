package com.jieandata.utils.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Auther: pengke
 * @Date: 2019-7-24 16:45
 * @Description: 计划类型枚举
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PlanTypeEnum {
    CONSUMPTION("CP","消费"),
    REPAY("RP","还款");
    private String code;
    private String desc;

    PlanTypeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static PlanTypeEnum getMatchedEnum(String code) {
        for (PlanTypeEnum tempEnum : PlanTypeEnum.values()) {
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
