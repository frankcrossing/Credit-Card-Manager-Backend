package com.jieandata.dal.model;

public class ManageDepartmentDo {
    private Integer id;

    private String departName;

    private Integer departLevel;

    private Integer departParentId;

    private Integer departSort;

    private Boolean isModified;

    private Integer addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName == null ? null : departName.trim();
    }

    public Integer getDepartLevel() {
        return departLevel;
    }

    public void setDepartLevel(Integer departLevel) {
        this.departLevel = departLevel;
    }

    public Integer getDepartParentId() {
        return departParentId;
    }

    public void setDepartParentId(Integer departParentId) {
        this.departParentId = departParentId;
    }

    public Integer getDepartSort() {
        return departSort;
    }

    public void setDepartSort(Integer departSort) {
        this.departSort = departSort;
    }

    public Boolean getIsModified() {
        return isModified;
    }

    public void setIsModified(Boolean isModified) {
        this.isModified = isModified;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }
}