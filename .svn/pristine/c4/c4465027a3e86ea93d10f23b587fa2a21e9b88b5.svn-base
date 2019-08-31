package com.jieandata.dal.dao;

import com.jieandata.dal.model.SystemConfigDo;
import org.apache.ibatis.annotations.Param;

public interface SystemConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemConfigDo record);

    int insertSelective(SystemConfigDo record);

    SystemConfigDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemConfigDo record);

    int updateByPrimaryKeyWithBLOBs(SystemConfigDo record);

    int updateByPrimaryKey(SystemConfigDo record);

    String getValueByKey(@Param("key") String key);
}