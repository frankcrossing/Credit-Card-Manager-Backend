package com.jieandata.dal.model;

import java.math.BigDecimal;

public class UserDeviceInfoDo {
    private Integer id;

    private Integer userId;

    private String intefaceType;

    private String deviceType;

    private String deviceNo;

    private String phoneType;

    private String systemType;

    private BigDecimal phoneStorage;

    private BigDecimal phoneDisk;

    private String ip;

    private String clientMac;

    private Integer addTime;

    private Integer updateTime;

    private String userAgent;

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

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo == null ? null : deviceNo.trim();
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType == null ? null : phoneType.trim();
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType == null ? null : systemType.trim();
    }

    public BigDecimal getPhoneStorage() {
        return phoneStorage;
    }

    public void setPhoneStorage(BigDecimal phoneStorage) {
        this.phoneStorage = phoneStorage;
    }

    public BigDecimal getPhoneDisk() {
        return phoneDisk;
    }

    public void setPhoneDisk(BigDecimal phoneDisk) {
        this.phoneDisk = phoneDisk;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getClientMac() {
        return clientMac;
    }

    public void setClientMac(String clientMac) {
        this.clientMac = clientMac == null ? null : clientMac.trim();
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

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }
}