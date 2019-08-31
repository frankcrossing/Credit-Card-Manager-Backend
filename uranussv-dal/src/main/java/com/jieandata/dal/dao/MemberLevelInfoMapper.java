package com.jieandata.dal.dao;

import com.jieandata.dal.model.MemberLevelInfoDo;

public interface MemberLevelInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberLevelInfoDo record);

    int insertSelective(MemberLevelInfoDo record);

    MemberLevelInfoDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberLevelInfoDo record);

    int updateByPrimaryKey(MemberLevelInfoDo record);

}