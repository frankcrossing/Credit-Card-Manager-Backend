package com.jieandata.utils.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Auther: pengke
 * @Date: 2019-7-24 16:45
 * @Description: 代理状态枚举
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AgentStatEnum {
    CLOSE("0","关闭"),
    OPEN("1","正常");
    private String code;
    private String desc;

    AgentStatEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static AgentStatEnum getMatchedEnum(String code) {
        for (AgentStatEnum tempEnum : AgentStatEnum.values()) {
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
