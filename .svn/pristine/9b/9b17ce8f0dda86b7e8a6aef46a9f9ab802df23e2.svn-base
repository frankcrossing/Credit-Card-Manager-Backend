package com.jieandata.utils.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Auther: pengke
 * @Date: 2019-1-11 11:51
 * @Description: 绑定状态枚举
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BindStatEnum {
    AUDRUN("AUDRUN", "处理中"),
    AUDPAS("AUDPAS", "成功"),
    AUDFAI("AUDFAI", "失败");

    private String code;
    private String desc;

    BindStatEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static BindStatEnum getMatchedEnum(String code) {
        for (BindStatEnum tempEnum : BindStatEnum.values()) {
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
