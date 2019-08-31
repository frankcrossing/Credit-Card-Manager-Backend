package com.jieandata.utils.enums;

/**
 * @Auther: pengke
 * @Date: 2019-8-5 18:28
 * @Description:
 */
public enum UserStatusEnum {
    NOR("NOR","正常"),
    DEL("DEL","删除"),
    HAN("HAN","挂起"),
    QT("QT","其他");

    private String code;
    private String desc;

    UserStatusEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static UserStatusEnum getMatchedEnum(String code) {
        for (UserStatusEnum tempEnum : UserStatusEnum.values()) {
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
