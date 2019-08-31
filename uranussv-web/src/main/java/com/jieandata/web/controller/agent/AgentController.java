package com.jieandata.web.controller.agent;

import com.github.pagehelper.PageInfo;
import com.jieandata.biz.agent.AgentManager;
import com.jieandata.service.model.agent.AgentInfoConditionVO;
import com.jieandata.service.model.agent.AgentInfoDTO;
import com.jieandata.service.model.agent.AgentInfoVO;
import com.jieandata.service.model.paging.PagingVO;
import com.jieandata.utils.bean.response.BaseResponse;
import com.jieandata.utils.common.enums.RespCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: pengke
 * @Date: 2019-8-14 13:50
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    private AgentManager agentManager;

    @RequestMapping(value = "/pagedAgentInfo",method = {RequestMethod.POST})
    public BaseResponse<PageInfo<AgentInfoVO>> pagedAgentInfo(@RequestBody PagingVO<AgentInfoConditionVO> paging){
        log.info("pagedAgentInfo paging:[{}]", paging);

        PageInfo<AgentInfoVO> data = agentManager.getPagedAgentInfo(paging);

        return new BaseResponse<>(RespCodeEnum.HANDLE_SUCCESS, data);
    }

    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    public BaseResponse save(@RequestBody AgentInfoDTO agentInfoDTO){
        log.info("save agentInfoDTO:[{}]", agentInfoDTO);

        int data = agentManager.saveAgent(agentInfoDTO);

        return new BaseResponse<>(RespCodeEnum.HANDLE_SUCCESS, data);
    }

}
