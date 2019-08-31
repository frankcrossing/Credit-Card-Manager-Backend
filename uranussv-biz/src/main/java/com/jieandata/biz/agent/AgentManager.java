package com.jieandata.biz.agent;

import com.github.pagehelper.PageInfo;
import com.jieandata.service.model.agent.AgentInfoConditionVO;
import com.jieandata.service.model.agent.AgentInfoDTO;
import com.jieandata.service.model.agent.AgentInfoVO;
import com.jieandata.service.model.paging.PagingVO;

/**
 * @Auther: pengke
 * @Date: 2019-8-14 13:55
 * @Description:
 */
public interface AgentManager {
    PageInfo<AgentInfoVO> getPagedAgentInfo(PagingVO<AgentInfoConditionVO> paging);

    /**
     * 保存代理人信息
     * @param agentInfoDTO
     * @return
     */
    int saveAgent(AgentInfoDTO agentInfoDTO);
}
