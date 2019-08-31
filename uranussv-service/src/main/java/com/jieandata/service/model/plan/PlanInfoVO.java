package com.jieandata.service.model.plan;

import lombok.Data;

/**
 * @Auther: pengke
 * @Date: 2019-8-7 17:19
 * @Description: 计划信息
 */
@Data
public class PlanInfoVO {
    private String planNo;
    private String cardNo;
    private String bankName;
    private String totalAmount;
    private String tionAmount;
    private String totalFee;
    private String planDays;
    private String planCurrentNum;
    private String planStatus;
    private String addTime;

    public PlanInfoVO(String planNo, String cardNo,
                      String bankName, String totalAmount,
                      String tionAmount, String totalFee,
                      String planDays, String planCurrentNum,
                      String planStatus, String addTime) {
        this.planNo = planNo;
        this.cardNo = cardNo;
        this.bankName = bankName;
        this.totalAmount = totalAmount;
        this.tionAmount = tionAmount;
        this.totalFee = totalFee;
        this.planDays = planDays;
        this.planCurrentNum = planCurrentNum;
        this.planStatus = planStatus;
        this.addTime = addTime;
    }
}
