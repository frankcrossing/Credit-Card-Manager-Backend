package com.jieandata.dal.dao;

import com.jieandata.dal.model.PlanInfoDo;

import java.util.List;
import java.util.Map;

public interface PlanInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlanInfoDo record);

    int insertSelective(PlanInfoDo record);

    PlanInfoDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlanInfoDo record);

    int updateByPrimaryKey(PlanInfoDo record);

    Integer getCountByUserId(Integer userId);

    List<PlanInfoDo> getByConditions(Map<String, Object> conditions);

    Integer getCountByCreditId(Integer creditId);
}