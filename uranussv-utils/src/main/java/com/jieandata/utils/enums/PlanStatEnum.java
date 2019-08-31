package com.jieandata.utils.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Auther: pengke
 * @Date: 2019-1-11 11:51
 * @Description: 计划状态枚举
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PlanStatEnum {
    NO_EXCUTE("noExcute", "未执行"),
    EXECUTING("exeCuting", "执行中"),
    COMPLETE("comPlete", "已完成"),
    TERMINATION("terMination", "意外终止"),
    CANCEL("canCel", "取消");

    private String code;
    private String desc;

    PlanStatEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static PlanStatEnum getMatchedEnum(String code) {
        for (PlanStatEnum tempEnum : PlanStatEnum.values()) {
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
