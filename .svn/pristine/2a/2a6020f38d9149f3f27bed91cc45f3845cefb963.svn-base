package com.jieandata.dal.dao;

import com.jieandata.dal.model.UserFlagRealDo;

import java.util.List;
import java.util.Map;

public interface UserFlagRealMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserFlagRealDo record);

    int insertSelective(UserFlagRealDo record);

    UserFlagRealDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserFlagRealDo record);

    int updateByPrimaryKeyWithBLOBs(UserFlagRealDo record);

    int updateByPrimaryKey(UserFlagRealDo record);

    UserFlagRealDo getOneByUserId(Integer userId);

    List<UserFlagRealDo> getByConditions(Map<String, Object> conditions);
}