package com.jieandata.service.user.impl;

import com.jieandata.dal.dao.UserBaseInfoMapper;
import com.jieandata.service.base.BaseServiveImpl;
import com.jieandata.service.user.UserService;
import com.jieandata.utils.common.enums.RespCodeEnum;
import com.jieandata.utils.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: pengke
 * @Date: 2019-8-5 19:05
 * @Description:
 */
@Slf4j
@Service
public class UserServiceImpl extends BaseServiveImpl implements UserService {
    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;
    @Override
    public List<Integer> getUserIdsByAgentId(String agentId) throws BusinessException {
        if(isNull(agentId)){
            throw new BusinessException(RespCodeEnum.PARAM_ERROR);
        }

        //List<Integer> userIds = userBaseInfoMapper.getUserIdsByAgentId(agentId);


        return null;
    }
}
