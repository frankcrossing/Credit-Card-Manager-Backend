package com.jieandata.dal.dao;

import com.jieandata.dal.model.ManageDistriAdminDo;

public interface ManageDistriAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ManageDistriAdminDo record);

    int insertSelective(ManageDistriAdminDo record);

    ManageDistriAdminDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ManageDistriAdminDo record);

    int updateByPrimaryKey(ManageDistriAdminDo record);
}