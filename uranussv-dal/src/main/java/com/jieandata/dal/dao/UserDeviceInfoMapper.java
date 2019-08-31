package com.jieandata.dal.dao;

import com.jieandata.dal.model.UserDeviceInfoDo;

public interface UserDeviceInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDeviceInfoDo record);

    int insertSelective(UserDeviceInfoDo record);

    UserDeviceInfoDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDeviceInfoDo record);

    int updateByPrimaryKeyWithBLOBs(UserDeviceInfoDo record);

    int updateByPrimaryKey(UserDeviceInfoDo record);

    UserDeviceInfoDo getOneByUserId(Integer userId);
}