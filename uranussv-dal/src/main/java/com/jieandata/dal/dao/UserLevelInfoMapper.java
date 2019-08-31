package com.jieandata.dal.dao;

import com.jieandata.dal.model.UserLevelInfoDo;

import java.util.List;
import java.util.Map;

public interface UserLevelInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLevelInfoDo record);

    int insertSelective(UserLevelInfoDo record);

    UserLevelInfoDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLevelInfoDo record);

    int updateByPrimaryKey(UserLevelInfoDo record);

    UserLevelInfoDo getOneByUserId(Integer userId);

    List<UserLevelInfoDo> getByConditions(Map<String, Object> conditions);
}