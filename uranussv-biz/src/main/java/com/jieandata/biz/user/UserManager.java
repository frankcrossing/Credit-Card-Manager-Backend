package com.jieandata.biz.user;

import com.github.pagehelper.PageInfo;
import com.jieandata.service.model.paging.PagingVO;
import com.jieandata.service.model.report.ReportVO;
import com.jieandata.service.model.user.UserBindInfoVO;
import com.jieandata.service.model.user.UserInfoConditionVO;
import com.jieandata.service.model.user.UserInfoVO;
import com.jieandata.utils.exception.BusinessException;

import java.util.List;

/**
 * @Auther: pengke
 * @Date: 2019-7-22 16:44
 * @Description:
 */
public interface UserManager {
    PageInfo<UserInfoVO> getPagedUserInfo(PagingVO<UserInfoConditionVO> paging) throws BusinessException;

    /**
     * 查询用户基本信息报告
     * @param userId
     * @return
     * @throws BusinessException
     */
    List<ReportVO> getUserBaseInfoReport(Integer userId) throws BusinessException;

    /**
     * 查询用户绑定信息
     * @param userId
     * @return
     */
    UserBindInfoVO getUserBindInfo(Integer userId) throws BusinessException;
}
