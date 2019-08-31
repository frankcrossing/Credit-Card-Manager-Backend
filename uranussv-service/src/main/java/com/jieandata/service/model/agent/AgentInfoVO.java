package com.jieandata.service.model.agent;

import com.jieandata.utils.enums.AgentStatEnum;
import com.jieandata.utils.enums.ShareProfitModeEnum;
import lombok.Data;

/**
 * @Auther: pengke
 * @Date: 2019-7-22 16:45
 * @Description: 代理人信息
 */
@Data
public class AgentInfoVO {
    private Integer id;
    /**
     * 代理商代号
     */
    private String agentId;
    /**
     *代理商
     */
    private String agentName;
    /**
     * 状态
     */
    private AgentStatEnum status;
    /**
     * 分润比例
     */
    private String shareProfitRate;
    /**
     * 分润模式
     */
    private ShareProfitModeEnum shareProfitMode;
    /**
     * 添加日期
     */
    private String addTime;
    /**
     * 链接
     */
    private String linkurl;

    public AgentInfoVO(Integer id, String agentId, String agentName,
                       AgentStatEnum status, String shareProfitRate,
                       ShareProfitModeEnum shareProfitMode,
                       String addTime, String linkurl) {
        this.id = id;
        this.agentId = agentId;
        this.agentName = agentName;
        this.status = status;
        this.shareProfitRate = shareProfitRate;
        this.shareProfitMode = shareProfitMode;
        this.addTime = addTime;
        this.linkurl = linkurl;
    }

    public AgentInfoVO() {

    }
}
