package com.jieandata.service.verification.impl;

import com.jieandata.dal.dao.AgentInfoMapper;
import com.jieandata.dal.dao.ManageUserMapper;
import com.jieandata.dal.model.AgentInfoDo;
import com.jieandata.dal.model.ManageUserDo;
import com.jieandata.service.base.BaseServiveImpl;
import com.jieandata.service.verification.IdentityVerifyService;
import com.jieandata.utils.common.enums.RespCodeEnum;
import com.jieandata.utils.enums.UserStatusEnum;
import com.jieandata.utils.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: pengke
 * @Date: 2019-8-5 18:46
 * @Description:
 */
@Slf4j
@Service
public class IdentityVerifyServiceImpl extends BaseServiveImpl implements IdentityVerifyService {

    @Autowired
    private ManageUserMapper manageUserMapper;

    @Autowired
    private AgentInfoMapper agentInfoMapper;

    @Override
    public ManageUserDo manageuserIdentityCheck(Integer manageuserId) throws BusinessException {
        if(isNull(manageuserId)){
            throw new BusinessException(RespCodeEnum.PARAM_ERROR);
        }

        ManageUserDo manageUserDo = manageUserMapper.selectByPrimaryKey(manageuserId);

        if(manageUserDo == null){
            throw new BusinessException(RespCodeEnum.MANAGER_MISS);
        }

        if(!StringUtils.equals(UserStatusEnum.NOR.getCode(), manageUserDo.getUserStatus())){
            throw new BusinessException(RespCodeEnum.MANAGER_STAT_EXCEPTION);
        }

        return manageUserDo;
    }

    @Override
    public AgentInfoDo agentIdentityCheck(String agentId) throws BusinessException {
        if(isNull(agentId)){
            throw new BusinessException(RespCodeEnum.PARAM_ERROR);
        }

        Map<String, Object> conditions = new HashMap<>();
        conditions.put("agentId", agentId);
        List<AgentInfoDo> oldAgentInfoDos = agentInfoMapper.getByConditions(conditions);
        if(isNull(oldAgentInfoDos)){
            throw new BusinessException(RespCodeEnum.AGENT_MISS);
        }
        if(oldAgentInfoDos.size() > 1) {
            throw new BusinessException(RespCodeEnum.SYSTEM_EXCEPTION);
        }
        AgentInfoDo agentInfoDo = oldAgentInfoDos.get(0);
        Boolean stat = agentInfoDo.getStat();
        if(stat == null || !stat){
            throw new BusinessException(RespCodeEnum.MANAGER_STAT_EXCEPTION);
        }

        return agentInfoDo;
    }
}
