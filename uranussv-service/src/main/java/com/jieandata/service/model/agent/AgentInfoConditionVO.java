package com.jieandata.service.model.agent;

import lombok.Data;

/**
 * @Auther: pengke
 * @Date: 2019-7-22 17:27
 * @Description: 代理人信息筛选条件
 */
@Data
public class AgentInfoConditionVO {
    /**
     * 管理员用户id
     */
    private Integer manageuserId;
    /**
     * 显示全部
     */
    private Boolean showAll;
}
