package com.jieandata.dal.dao;

import com.jieandata.dal.model.ManageUserDo;

public interface ManageUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ManageUserDo record);

    int insertSelective(ManageUserDo record);

    ManageUserDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ManageUserDo record);

    int updateByPrimaryKey(ManageUserDo record);
}