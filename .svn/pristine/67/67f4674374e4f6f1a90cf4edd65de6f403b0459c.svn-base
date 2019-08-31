package com.jieandata.dal.dao;

import com.jieandata.dal.model.UserTokenInfoDo;

import java.util.List;
import java.util.Map;

public interface UserTokenInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserTokenInfoDo record);

    int insertSelective(UserTokenInfoDo record);

    UserTokenInfoDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserTokenInfoDo record);

    int updateByPrimaryKey(UserTokenInfoDo record);

    UserTokenInfoDo getOneByUserId(Integer userId);

    List<UserTokenInfoDo> getByConditions(Map<String, Object> conditions);
}