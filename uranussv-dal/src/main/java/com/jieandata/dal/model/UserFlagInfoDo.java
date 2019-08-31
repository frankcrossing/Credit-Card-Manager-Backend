package com.jieandata.dal.model;

public class UserFlagInfoDo {
    private Integer id;

    private Integer userId;

    private String intefaceType;

    private String bankName;

    private String cardType;

    private String bankNo;

    private String cardBin;

    private String bankMd5Flag;

    private String bankFlag;

    private Boolean isDefault;

    private Boolean isUnbundled;

    private String userMobile;

    private String bankMobile;

    private String bindStat;

    private Integer addTime;

    private Integer updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIntefaceType() {
        return intefaceType;
    }

    public void setIntefaceType(String intefaceType) {
        this.intefaceType = intefaceType == null ? null : intefaceType.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    public String getCardBin() {
        return cardBin;
    }

    public void setCardBin(String cardBin) {
        this.cardBin = cardBin == null ? null : cardBin.trim();
    }

    public String getBankMd5Flag() {
        return bankMd5Flag;
    }

    public void setBankMd5Flag(String bankMd5Flag) {
        this.bankMd5Flag = bankMd5Flag == null ? null : bankMd5Flag.trim();
    }

    public String getBankFlag() {
        return bankFlag;
    }

    public void setBankFlag(String bankFlag) {
        this.bankFlag = bankFlag == null ? null : bankFlag.trim();
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Boolean getIsUnbundled() {
        return isUnbundled;
    }

    public void setIsUnbundled(Boolean isUnbundled) {
        this.isUnbundled = isUnbundled;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getBankMobile() {
        return bankMobile;
    }

    public void setBankMobile(String bankMobile) {
        this.bankMobile = bankMobile == null ? null : bankMobile.trim();
    }

    public String getBindStat() {
        return bindStat;
    }

    public void setBindStat(String bindStat) {
        this.bindStat = bindStat == null ? null : bindStat.trim();
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }
}