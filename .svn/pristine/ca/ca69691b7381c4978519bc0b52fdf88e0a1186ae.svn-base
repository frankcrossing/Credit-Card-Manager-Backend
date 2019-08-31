package com.jieandata.biz.plan.impl;

import com.jieandata.biz.base.BaseManagerImpl;
import com.jieandata.biz.plan.PlanManager;
import com.jieandata.dal.dao.PlanInfoMapper;
import com.jieandata.dal.dao.UserBaseInfoMapper;
import com.jieandata.dal.dao.UserFlagInfoMapper;
import com.jieandata.dal.dao.UserPlanDetailMapper;
import com.jieandata.dal.model.PlanInfoDo;
import com.jieandata.dal.model.UserFlagInfoDo;
import com.jieandata.dal.model.UserPlanDetailDo;
import com.jieandata.service.model.plan.PlanDetailInfoVO;
import com.jieandata.service.model.plan.PlanInfoConditionVO;
import com.jieandata.service.model.plan.PlanInfoVO;
import com.jieandata.utils.common.JsonUtils;
import com.jieandata.utils.common.enums.RespCodeEnum;
import com.jieandata.utils.enums.PlanDetailStatEnum;
import com.jieandata.utils.enums.PlanStatEnum;
import com.jieandata.utils.enums.PlanTypeEnum;
import com.jieandata.utils.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: pengke
 * @Date: 2019-8-7 17:31
 * @Description:
 */
@Slf4j
@Service
public class PlanManagerImpl extends BaseManagerImpl implements PlanManager {

    @Autowired
    private PlanInfoMapper planInfoMapper;

    @Autowired
    private UserFlagInfoMapper userFlagInfoMapper;

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;

    @Autowired
    private UserPlanDetailMapper userPlanDetailMapper;

    @Override
    public List<PlanInfoVO> getPlanInfoList(PlanInfoConditionVO condition) {
        if(isAllNull(condition, condition.getUserId(), condition.getMobile()) ){
            throw new BusinessException(RespCodeEnum.PARAM_ERROR);
        }
        Integer userId = condition.getUserId();
        Long mobile = condition.getMobile();
        Map<String, Object> conditions = new HashMap<>();
        if(isNotNull(userId)){
            conditions.put("userId", userId);
        }else if(isNotNull(mobile)){
            userId = userBaseInfoMapper.getUserIdByMobile(mobile);
            if(isNull(userId)){
                throw new BusinessException(RespCodeEnum.USER_MISS);
            }
            conditions.put("userId", userId);
        }else {
            throw new BusinessException(RespCodeEnum.PARAM_ERROR);
        }

        List<PlanInfoDo> planInfoDos = planInfoMapper.getByConditions(conditions);

        List<UserFlagInfoDo> userFlagInfoDos = userFlagInfoMapper.getByConditions(conditions);

        return buildPlanInfoVoList(planInfoDos, userFlagInfoDos);
    }

    @Override
    public List<PlanDetailInfoVO> getPlanDetailInfoList(String planNo) {
        if(isNull(planNo)){
            throw new BusinessException(RespCodeEnum.PARAM_ERROR);
        }
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("planNo", planNo);
        List<UserPlanDetailDo> userPlanDetailDos = userPlanDetailMapper.getByConditions(conditions);

        return buildPlanDetailInfoVOList(userPlanDetailDos);
    }

    private List<PlanDetailInfoVO> buildPlanDetailInfoVOList(List<UserPlanDetailDo> userPlanDetailDos) {
        if(isNull(userPlanDetailDos)){
            return new ArrayList<>();
        }
        List<PlanDetailInfoVO> planDetailInfoVOList = new ArrayList<>();
        PlanDetailInfoVO planDetailInfoVO;
        Map<String, Object> jsonMap;
        String jsonStr;
        Map<String, Object> jsonStrMap;

        String orderNo;
        String planType;
        String money;
        String userRateFee;
        String gkRateFee;
        String aisleRateFee;
        String planDate;
        String planStatus;
        String logString;

        for (UserPlanDetailDo userPlanDetailDo : userPlanDetailDos) {
            orderNo = userPlanDetailDo.getOrderNo();

            PlanTypeEnum planTypeEnum = PlanTypeEnum.getMatchedEnum(userPlanDetailDo.getPlanType());
            if(isNotNull(planTypeEnum)){
                planType = planTypeEnum.getDesc();
            }else{
                planType = "未知";
            }

            money = String.valueOf(userPlanDetailDo.getMoney());
            userRateFee = String.valueOf(userPlanDetailDo.getUserRateFee());
            gkRateFee = String.valueOf(userPlanDetailDo.getGkRateFee());
            aisleRateFee = String.valueOf(userPlanDetailDo.getAisleRateFee());
            planDate = buildTime(userPlanDetailDo.getPlanDate());

            PlanDetailStatEnum detailStatEnum = PlanDetailStatEnum.getMatchedEnum(userPlanDetailDo.getPlanStatus());
            if(isNotNull(detailStatEnum)){
                planStatus = detailStatEnum.getDesc();
            }else {
                planStatus = "未知";
            }

            logString = userPlanDetailDo.getLogString();

            if(isNotNull(logString)){
                logString = StringEscapeUtils.unescapeJava(logString);

                jsonMap = JsonUtils.str2Map(logString);
                if (isNotNull(jsonMap)) {
                    jsonStr = (String)jsonMap.get("jsonStr");
                    if(isNotNull(jsonStr)){
                        jsonStrMap = JsonUtils.str2Map(jsonStr);
                        jsonMap.put("jsonStr", jsonStrMap);
                        logString = JsonUtils.convertObj2String(jsonMap);
                    }
                }

                logString = JsonUtils.jsonFormat(logString);
            }

            planDetailInfoVO = new PlanDetailInfoVO(
                    orderNo,planType,
                    money, userRateFee,
                    gkRateFee, aisleRateFee,
                    planDate, planStatus,
                    logString);

            planDetailInfoVOList.add(planDetailInfoVO);

        }
        return planDetailInfoVOList;
    }

    private List<PlanInfoVO> buildPlanInfoVoList(List<PlanInfoDo> planInfoDos, List<UserFlagInfoDo> userFlagInfoDos) {
        if(CollectionUtils.isEmpty(planInfoDos)){
            return new ArrayList<>();
        }

        List<PlanInfoVO> planInfoVoList = new ArrayList<>();
        PlanInfoVO planInfoVO;
        Integer creditId;
        PlanStatEnum planStatEnum;

        String planNo;
        String cardNo;
        String bankName;
        String totalAmount;
        String tionAmount;
        String totalFee;
        String planDays;
        String planCurrentNum;
        String planStatus;
        String addTime;
        for (PlanInfoDo planInfoDo : planInfoDos) {
            planNo = planInfoDo.getPlanNo();
            creditId = planInfoDo.getCreditId();

            bankName = null;
            cardNo = null;
            for (UserFlagInfoDo userFlagInfoDo : userFlagInfoDos) {
                if(userFlagInfoDo.getId().equals(creditId)){
                    bankName = userFlagInfoDo.getBankName();
                    cardNo = buildCardNum(userFlagInfoDo.getCardBin(), planInfoDo.getCreditCardNo());
                }
            }
            totalAmount = String.valueOf(planInfoDo.getRepayTotalAmount());
            tionAmount = String.valueOf(planInfoDo.getConsumpTionAmount());
            totalFee = String.valueOf(planInfoDo.getTotalFee());
            planDays = String.valueOf(planInfoDo.getPlanDays());
            planCurrentNum = String.valueOf(planInfoDo.getPlanCurrentNum());

            planStatEnum = PlanStatEnum.getMatchedEnum(planInfoDo.getPlanStatus());
            if(isNotNull(planStatEnum)){
                planStatus = planStatEnum.getDesc();
            } else {
                planStatus = PlanStatEnum.NO_EXCUTE.getDesc();
            }

            addTime = buildTime(planInfoDo.getAddTime());

            planInfoVO = new PlanInfoVO(
                    planNo, cardNo,
                    bankName, totalAmount,
                    tionAmount, totalFee,
                    planDays, planCurrentNum,
                    planStatus, addTime);
            planInfoVoList.add(planInfoVO);

        }

        return planInfoVoList;
    }
}
