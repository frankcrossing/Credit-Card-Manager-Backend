package com.jieandata.dal.model;

public class AgentInfoDo {
    private Integer id;

    private String agentId;

    private String agentName;

    private Boolean stat;

    private Boolean shareProfitMode;

    private Float shareProfitRate;

    private String linkurl;

    private Integer addTime;

    private Integer updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId == null ? null : agentId.trim();
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public Boolean getStat() {
        return stat;
    }

    public void setStat(Boolean stat) {
        this.stat = stat;
    }

    public Boolean getShareProfitMode() {
        return shareProfitMode;
    }

    public void setShareProfitMode(Boolean shareProfitMode) {
        this.shareProfitMode = shareProfitMode;
    }

    public Float getShareProfitRate() {
        return shareProfitRate;
    }

    public void setShareProfitRate(Float shareProfitRate) {
        this.shareProfitRate = shareProfitRate;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl == null ? null : linkurl.trim();
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