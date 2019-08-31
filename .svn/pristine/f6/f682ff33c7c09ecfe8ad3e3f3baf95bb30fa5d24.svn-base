package com.jieandata.utils.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Auther: pengke
 * @Date: 2019-1-7 09:49
 * @Description: 订单状态枚举
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderStatEnum {
    APPROVE("APPROVE","审核中"),
    TO_PAY("TO_PAY","放款中"),
    PAYED("PAYED","已放款"),
    PART_REPAY("PART_REPAY","部分还款"),
    REPAYED("REPAYED","已还款"),
    OVERDUE("OVERDUE","逾期"),
    PAY_FAILED("PAY_FAILED","放款失败"),
    BAD_DEBT("BAD_DEBT","坏账"),
    AUDIT_REFUSE("AUDIT_REFUSE","审核失败"),
    REPAYING("REPAYING","还款中");

    private String code;
    private String desc;

    OrderStatEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
