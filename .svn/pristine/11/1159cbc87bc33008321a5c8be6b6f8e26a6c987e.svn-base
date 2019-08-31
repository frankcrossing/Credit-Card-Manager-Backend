package com.jieandata.service.model.user;

import lombok.Data;

import java.util.List;

/**
 * @Auther: pengke
 * @Date: 2019-8-2 16:39
 * @Description: 用户绑定信息
 */
@Data
public class UserBindInfoVO {
    /**
     * 是否实名
     */
    private String realNameAuth;

    /**
     * 是否绑卡
     */
    private String bindCard;

    /**
     * 认证状态
     */
    private String certificateStatus;

    /**
     * 绑卡信息
     */
    private List<BindCardInfo> bindCardInfos;

    @Data
    public static class BindCardInfo {
        private String cardNum;

        private String bankName;

        private Integer planNum;

        private String bindStatus;

        private String bindTime;

        public BindCardInfo(String cardNum, String bankName, Integer planNum, String bindStatus, String bindTime) {
            this.cardNum = cardNum;
            this.bankName = bankName;
            this.planNum = planNum;
            this.bindStatus = bindStatus;
            this.bindTime = bindTime;
        }
    }
}
