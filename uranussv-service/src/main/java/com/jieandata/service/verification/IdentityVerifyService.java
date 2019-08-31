package com.jieandata.service.verification;

import com.jieandata.dal.model.AgentInfoDo;
import com.jieandata.dal.model.ManageUserDo;
import com.jieandata.utils.exception.BusinessException;

/**
 * @Auther: pengke
 * @Date: 2019-8-5 18:42
 * @Description: 身份校验接口
 */
public interface IdentityVerifyService {
    /**
     * 管理员用户身份检查，并返回管理员信息
     * @param manageuserId
     * @return 管理员信息
     * @throws BusinessException
     */
    ManageUserDo manageuserIdentityCheck(Integer manageuserId) throws BusinessException;

    /**
     * 代理商身份检查，并返回代理商信息
     * @param agentId
     * @return 代理商信息
     * @throws BusinessException
     */
    AgentInfoDo agentIdentityCheck(String agentId) throws BusinessException;
}
