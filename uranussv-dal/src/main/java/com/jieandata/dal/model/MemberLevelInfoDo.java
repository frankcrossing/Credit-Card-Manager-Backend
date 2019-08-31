package com.jieandata.dal.model;

public class MemberLevelInfoDo {
    private Integer id;

    private String intefaceType;

    private String levelType;

    private String levelName;

    private String levelSimpleName;

    private String levelCardName;

    private Float money;

    private Float totalRate;

    private Float staticRate;

    private Boolean isPush;

    private Integer addTime;

    private Integer updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntefaceType() {
        return intefaceType;
    }

    public void setIntefaceType(String intefaceType) {
        this.intefaceType = intefaceType == null ? null : intefaceType.trim();
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType == null ? null : levelType.trim();
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public String getLevelSimpleName() {
        return levelSimpleName;
    }

    public void setLevelSimpleName(String levelSimpleName) {
        this.levelSimpleName = levelSimpleName == null ? null : levelSimpleName.trim();
    }

    public String getLevelCardName() {
        return levelCardName;
    }

    public void setLevelCardName(String levelCardName) {
        this.levelCardName = levelCardName == null ? null : levelCardName.trim();
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Float getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(Float totalRate) {
        this.totalRate = totalRate;
    }

    public Float getStaticRate() {
        return staticRate;
    }

    public void setStaticRate(Float staticRate) {
        this.staticRate = staticRate;
    }

    public Boolean getIsPush() {
        return isPush;
    }

    public void setIsPush(Boolean isPush) {
        this.isPush = isPush;
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