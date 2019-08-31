package com.jieandata.utils.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Auther: pengke
 * @Date: 2019-1-11 11:51
 * @Description: 计划详情状态枚举
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PlanDetailStatEnum {
    NOT_EXCUTE("notExecute", "未消费"),
    COMPLETE("comPlete", "已消费"),
    NOT_REPAYMENT("notRepayment", "未还款"),
    REPAYMENT("rePayment", "已还款"),
    FAIL("fail", "失败");

    private String code;
    private String desc;

    PlanDetailStatEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static PlanDetailStatEnum getMatchedEnum(String code) {
        for (PlanDetailStatEnum tempEnum : PlanDetailStatEnum.values()) {
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
