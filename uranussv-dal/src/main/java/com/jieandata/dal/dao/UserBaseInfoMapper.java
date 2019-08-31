package com.jieandata.dal.dao;

import com.jieandata.dal.model.UserBaseInfoDo;

import java.util.List;
import java.util.Map;

public interface UserBaseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBaseInfoDo record);

    int insertSelective(UserBaseInfoDo record);

    UserBaseInfoDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBaseInfoDo record);

    int updateByPrimaryKey(UserBaseInfoDo record);

    List<UserBaseInfoDo> getByConditions(Map<String, Object> conditions);

    Integer getUserIdByMobile(Long mobile);
}