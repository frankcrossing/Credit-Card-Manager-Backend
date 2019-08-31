package com.jieandata.utils.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Auther: pengke
 * @Date: 2019-1-11 11:51
 * @Description: 认证状态类型枚举
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RealTypeEnum {
    NO_REAL(0, "未实名"),
    REALED(1, "识别成功"),
    OCR_FAILED(2, "ocr识别失败"),
    LIVING_FAILED(3, "活体认证失败"),
    BODY_CERT_FAILED(4, "人证认证失败");

    private Integer code;
    private String desc;

    RealTypeEnum(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static RealTypeEnum getMatchedEnum(Integer code) {
        for (RealTypeEnum tempEnum : RealTypeEnum.values()) {
            if (tempEnum.code.equals(code)) {
                return tempEnum;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
