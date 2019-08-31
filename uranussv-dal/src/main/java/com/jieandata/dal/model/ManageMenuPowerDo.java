package com.jieandata.dal.model;

public class ManageMenuPowerDo {
    private Integer id;

    private Integer menuId;

    private String actionPath;

    private String adtionMethod;

    private Integer addTime;

    private Integer updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getActionPath() {
        return actionPath;
    }

    public void setActionPath(String actionPath) {
        this.actionPath = actionPath == null ? null : actionPath.trim();
    }

    public String getAdtionMethod() {
        return adtionMethod;
    }

    public void setAdtionMethod(String adtionMethod) {
        this.adtionMethod = adtionMethod == null ? null : adtionMethod.trim();
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