 package com.jieandata.web.controller.user;

import com.github.pagehelper.PageInfo;
import com.jieandata.biz.user.UserManager;
import com.jieandata.biz.user.UserFeedBackManager;
import com.jieandata.service.model.paging.PagingVO;
import com.jieandata.service.model.report.ReportVO;
import com.jieandata.service.model.user.*;
import com.jieandata.utils.bean.response.BaseResponse;
import com.jieandata.utils.common.enums.RespCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: pengke
 * @Date: 2019-7-22 17:43
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserFeedBackManager userFeedbackManager;

    /**
     * 用户信息(分页)
     * @param paging
     * @return
     */
    @RequestMapping(value = "/pagedUserInfo",method = {RequestMethod.POST})
    public BaseResponse<PageInfo<UserInfoVO>> pagedUserInfo(@RequestBody PagingVO<UserInfoConditionVO> paging){
        log.info("paging:[{}]", paging);

        PageInfo<UserInfoVO> data = userManager.getPagedUserInfo(paging);

        return new BaseResponse<>(RespCodeEnum.HANDLE_SUCCESS, data);
    }

    /**
     * 用户反馈(分页)
     * @param paging
     * @return
     */
    @RequestMapping(value = "/pagedFeedBack",method = {RequestMethod.POST})
    public BaseResponse<PageInfo<UserFeedBackVO>> pagedFeedBack(@RequestBody PagingVO<UserFeedBackConditionVO> paging){
        log.info("paging:[{}]", paging);

        PageInfo<UserFeedBackVO> data = userFeedbackManager.getPagedUserFeedBackInfo(paging);

        return new BaseResponse<>(RespCodeEnum.HANDLE_SUCCESS, data);
    }

    @RequestMapping(value = "/deleteUserFeedback",method = {RequestMethod.POST})
    public int deleteUserFeedback(@RequestBody List<Integer> idList){
        return userFeedbackManager.deleteUserFeedback(idList);
    }

    /**
     * 客户基本信息报告
     * @param userId
     * @return
     */
    @RequestMapping(value = "/userBaseInfoReport",method = {RequestMethod.POST})
    public BaseResponse<List<ReportVO>> userBaseInfoReport(@RequestParam Integer userId){
        log.info("in userBaseInfoReport, userId:[{}]", userId);

        List<ReportVO> data = userManager.getUserBaseInfoReport(userId);

        return new BaseResponse<>(RespCodeEnum.HANDLE_SUCCESS, data);
    }

    /**
     * 用户绑定信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/userBindInfo",method = {RequestMethod.POST})
    public BaseResponse<UserBindInfoVO> userBindInfo(@RequestParam Integer userId){
        log.info("in userBindInfo, userId:[{}]", userId);

        UserBindInfoVO data = userManager.getUserBindInfo(userId);

        return new BaseResponse<>(RespCodeEnum.HANDLE_SUCCESS, data);
    }

}
