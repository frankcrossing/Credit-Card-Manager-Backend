package com.jieandata.dal.dao.extdao;

import com.jieandata.dal.model.extdo.UserFeedbackDto;

import java.util.List;


public interface UserFeedbackDtoMapper {
    List<UserFeedbackDto> getResultList();

    int getTotalData();
}