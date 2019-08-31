package com.jieandata.dal.dao;

import com.jieandata.dal.model.ManageDepartmentDo;

public interface ManageDepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ManageDepartmentDo record);

    int insertSelective(ManageDepartmentDo record);

    ManageDepartmentDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ManageDepartmentDo record);

    int updateByPrimaryKey(ManageDepartmentDo record);
}