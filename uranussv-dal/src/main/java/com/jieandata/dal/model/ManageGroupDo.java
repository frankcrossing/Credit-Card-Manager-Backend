package com.jieandata.dal.model;

public class ManageGroupDo {
    private Integer id;

    private Integer departId;

    private String groupName;

    private String authIds;

    private Integer idDefault;

    private Integer addTime;

    private Integer updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getAuthIds() {
        return authIds;
    }

    public void setAuthIds(String authIds) {
        this.authIds = authIds == null ? null : authIds.trim();
    }

    public Integer getIdDefault() {
        return idDefault;
    }

    public void setIdDefault(Integer idDefault) {
        this.idDefault = idDefault;
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