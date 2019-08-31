package com.jieandata.service.model.user;

import lombok.Data;

/**
 * @Auther: pengke
 * @Date: 2019-7-22 16:45
 * @Description: 客户信息
 */
@Data
public class UserInfoVO {

    private Integer userId;

    /**
     * 手机号
     */
    private String mobile;
    /**
     * 姓名
     */
    private String name;
    /**
     * 是否实名
     */
    private String realNameAuth;
    /**
     * 是否绑卡
     */
    private String bindCard;
    /**
     * 计划数
     */
    private Integer planNum;
    /**
     * 会员等级
     */
    private String memberLevel;
    /**
     * 注册时间(yyyy-MM-dd hh:mm:ss)
     */
    private String registerTime;

    public UserInfoVO(Integer userId, String mobile,
                      String name, String realNameAuth,
                      String bindCard, Integer planNum,
                      String memberLevel, String registerTime) {
        this.userId = userId;
        this.mobile = mobile;
        this.name = name;
        this.realNameAuth = realNameAuth;
        this.bindCard = bindCard;
        this.planNum = planNum;
        this.memberLevel = memberLevel;
        this.registerTime = registerTime;
    }

    public UserInfoVO() {

    }
}
