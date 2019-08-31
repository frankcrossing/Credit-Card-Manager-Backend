package com.jieandata.utils.common.enums;

/**
 * @Auther: pengke
 * @Date: 2019-7-4 14:00
 * @Description:单位时间枚举
 */
public enum UnitTimeEnum {
    MINUTE_1("1", 60, 60 * 1000),
    MINUTE_5("5", 60 * 5, 60 * 5 * 1000),
    MINUTE_10("10", 60 * 10, 60 * 10 * 1000),
    MINUTE_30("30", 60 * 30, 60 * 30 * 1000),
    MINUTE_60("60", 60 * 60, 60 * 60 * 1000);

    private String code;
    private int seconds;
    private long millisecond;

    public int getSeconds() {
        return seconds;
    }

    public long getMillisecond() {
        return millisecond;
    }

    UnitTimeEnum(String code, int seconds, long millisecond) {
        this.code = code;
        this.seconds = seconds;
        this.millisecond = millisecond;
    }

    public static UnitTimeEnum getMatchedUnitTime(String code) {
        for (UnitTimeEnum unitTimeEnum : UnitTimeEnum.values()) {
            if (unitTimeEnum.code.equals(code)) {
                return unitTimeEnum;
            }
        }
        return null;
    }
}
