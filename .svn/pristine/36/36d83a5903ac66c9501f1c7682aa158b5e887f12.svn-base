package com.jieandata.biz.user;

import com.github.pagehelper.PageInfo;
import com.jieandata.service.model.paging.PagingVO;
import com.jieandata.service.model.user.UserFeedBackConditionVO;
import com.jieandata.service.model.user.UserFeedBackVO;
import com.jieandata.utils.exception.BusinessException;

import java.util.*;


public interface UserFeedBackManager {
    PageInfo<UserFeedBackVO> getPagedUserFeedBackInfo(PagingVO<UserFeedBackConditionVO> paging) throws BusinessException;

    int deleteUserFeedback(List<Integer> Id) throws BusinessException;
}



