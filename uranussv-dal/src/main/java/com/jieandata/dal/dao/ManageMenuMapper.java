package com.jieandata.dal.dao;

import com.jieandata.dal.model.ManageMenuDo;

public interface ManageMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ManageMenuDo record);

    int insertSelective(ManageMenuDo record);

    ManageMenuDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ManageMenuDo record);

    int updateByPrimaryKey(ManageMenuDo record);
}