package com.jieandata.utils.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Auther: pengke
 * @Date: 2019-1-11 11:51
 * @Description: 设备类型枚举
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DeviceTypeEnum {
    IOS("IOS", "苹果"),
    ANDROID("ANDROID", "安卓"),
    H5("H5", "HTML5页面"),
    UNKNOWN("UNKNOWN", "未知");

    private String code;
    private String desc;

    DeviceTypeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static DeviceTypeEnum getMatchedEnum(String code) {
        for (DeviceTypeEnum tempEnum : DeviceTypeEnum.values()) {
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
