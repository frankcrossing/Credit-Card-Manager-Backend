package com.jieandata.biz.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jieandata.biz.base.BaseManagerImpl;
import com.jieandata.biz.user.UserManager;
import com.jieandata.dal.dao.*;
import com.jieandata.dal.model.*;
import com.jieandata.jaguar.common.utils.convert.DateUtils;
import com.jieandata.service.builder.ReportBuilder;
import com.jieandata.service.common.MaskUtils;
import com.jieandata.service.model.paging.PagingVO;
import com.jieandata.service.model.report.ReportVO;
import com.jieandata.service.model.report.UserBaseInfoVO;
import com.jieandata.service.model.user.UserBindInfoVO;
import com.jieandata.service.model.user.UserInfoConditionVO;
import com.jieandata.service.model.user.UserInfoVO;
import com.jieandata.service.verification.IdentityVerifyService;
import com.jieandata.utils.bean.CommonUtils;
import com.jieandata.utils.cipher.CipherUtils;
import com.jieandata.utils.common.JsonUtils;
import com.jieandata.utils.common.enums.RespCodeEnum;
import com.jieandata.utils.enums.BindStatEnum;
import com.jieandata.utils.enums.DeviceTypeEnum;
import com.jieandata.utils.enums.RealTypeEnum;
import com.jieandata.utils.exception.BusinessException;
import com.yunrich.monster.common.constants.code.bizCode.enums.common.CommonYesOrNoEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Auther: pengke
 * @Date: 2019-7-22 16:44
 * @Description:
 */
@Slf4j
@Service
public class UserManagerImpl extends BaseManagerImpl implements UserManager {

    @Autowired
    private IdentityVerifyService identityVerifyService;

    @Autowired
    private ManageUserMapper manageUserMapper;

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;

    @Autowired
    private UserFlagRealMapper userFlagRealMapper;

    @Autowired
    private UserTokenInfoMapper userTokenInfoMapper;

    @Autowired
    private PlanInfoMapper planInfoMapper;

    @Autowired
    private UserLevelInfoMapper userLevelInfoMapper;

    @Autowired
    private UserDeviceInfoMapper userDeviceInfoMapper;

    @Autowired
    private UserLoginLogMapper userLoginLogMapper;

    @Autowired
    private UserFlagInfoMapper userFlagInfoMapper;

    @Override
    public PageInfo<UserInfoVO> getPagedUserInfo(PagingVO<UserInfoConditionVO> paging) throws BusinessException {
        if(isAnyNull(paging, paging.getCondition())){
            throw new BusinessException(RespCodeEnum.PARAM_ERROR);
        }

        Integer manageuserId = paging.getCondition().getManageuserId();

        ManageUserDo manageUserDo = identityVerifyService.manageuserIdentityCheck(manageuserId);

        Map<String, Object> conditions = buildConditions(paging.getCondition());
        // 代理商的操作员,只查询该代理商的用户
        String agentId = manageUserDo.getAgentId();
        if(isNotNull(agentId)){
            identityVerifyService.agentIdentityCheck(agentId);
            conditions.put("agentId", agentId);
        }

        PageHelper.startPage(paging.getPageNum(), paging.getPageSize());

        List<UserBaseInfoDo> userBaseInfoDoList = userBaseInfoMapper.getByConditions(conditions);

        PageInfo<UserBaseInfoDo> pageInfo0 = new PageInfo<>(userBaseInfoDoList);

        List<UserInfoVO> userInfoVOList = buildResults(userBaseInfoDoList);

        if(isNotNull(userInfoVOList)){
            PageInfo<UserInfoVO> pageInfo = new PageInfo<>(userInfoVOList);

            pageInfo.setTotal(pageInfo0.getTotal());

            return pageInfo;
        }

        return null;

    }

    private List<UserInfoVO> buildResults(List<UserBaseInfoDo> userBaseInfoDoList) {
        if(isNull(userBaseInfoDoList)){
            return new ArrayList<>();
        }
        List<UserInfoVO> userInfoVOList = new ArrayList<>();

        final List<Integer> userIds = new ArrayList<>();
        userBaseInfoDoList.forEach(n -> userIds.add(n.getId()));
        // in 查询条件
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("userIds", userIds);

        UserInfoVO userInfoVO;
        UserFlagRealDo userFlagRealDo;
        UserTokenInfoDo userTokenInfoDo;
        UserLevelInfoDo userLevelInfoDo;
        Integer userId;
        String mobile;
        String name;
        String realNameAuth;
        String bindCard;
        Integer planNum;
        String memberLevel;
        String registerTime;

        List<UserFlagRealDo> userFlagRealDos = userFlagRealMapper.getByConditions(conditions);

        List<UserTokenInfoDo> userTokenInfoDos = userTokenInfoMapper.getByConditions(conditions);

        List<UserLevelInfoDo> userLevelInfoDos = userLevelInfoMapper.getByConditions(conditions);

        for (UserBaseInfoDo userBaseInfoDo : userBaseInfoDoList) {
            userId = userBaseInfoDo.getId();
            mobile = String.valueOf(userBaseInfoDo.getMobile());

            userFlagRealDo = null;
            for (UserFlagRealDo flagRealDo : userFlagRealDos) {
                if(userId.equals(flagRealDo.getUserId())){
                    userFlagRealDo = flagRealDo;
                }
            }

            name = buildName(userBaseInfoDo, userFlagRealDo);

            userTokenInfoDo = null;
            for (UserTokenInfoDo tokenInfoDo : userTokenInfoDos) {
                if(userId.equals(tokenInfoDo.getUserId())){
                    userTokenInfoDo = tokenInfoDo;
                }
            }

            if(isNotNull(userTokenInfoDo)){
                realNameAuth = StringUtils.equals(CommonYesOrNoEnum.Y.getCode(), userTokenInfoDo.getIsUserAuth())? "已实名": "未实名";
                bindCard = StringUtils.equals(CommonYesOrNoEnum.Y.getCode(), userTokenInfoDo.getIsBindCard())? "已绑卡": "未绑卡";
            } else {
                realNameAuth = "未实名";
                bindCard = "未绑卡";
            }

            planNum = planInfoMapper.getCountByUserId(userId);
            if(isNull(planNum)){
                planNum = 0;
            }

            userLevelInfoDo = null;
            for (UserLevelInfoDo levelInfoDo : userLevelInfoDos) {
                if(userId.equals(levelInfoDo.getUserId())){
                    userLevelInfoDo = levelInfoDo;
                }
            }

            memberLevel = null;
            if(isNotNull(userLevelInfoDo)){
                memberLevel = userLevelInfoDo.getLevelName();
            }

            registerTime = buildTime(userBaseInfoDo.getAddTime());

            userInfoVO = new UserInfoVO(userId, mobile,
                    name, realNameAuth,
                    bindCard, planNum,
                    memberLevel, registerTime);
            userInfoVO = (UserInfoVO) MaskUtils.getMaskedBean(userInfoVO);
            userInfoVOList.add(userInfoVO);
        }

        return userInfoVOList;
    }

    private Map<String, Object> buildConditions(UserInfoConditionVO condition){
        String registerBeginDate = condition.getRegisterBeginDate();
        String registerEndDate = condition.getRegisterEndDate();
        if(StringUtils.isAllBlank(registerBeginDate, registerEndDate)){
            return new HashMap<>();
        }

        Map<String, Object> conditions = new HashMap<>();
        if(!isNull(registerBeginDate)){
            int beginAddTime = DateUtils.getSecondTimestamp(DateUtils.parseMailDateDtPartString(registerBeginDate));
            conditions.put("beginAddTime", beginAddTime);
        }
        if(!isNull(registerEndDate)){
            int endAddTime = DateUtils.getSecondTimestamp(DateUtils.parseMailDateDtPartString(registerEndDate));
            conditions.put("endAddTime", endAddTime);
        }

        return conditions;
    }

    @Override
    public List<ReportVO> getUserBaseInfoReport(Integer userId) throws BusinessException {
        if(isNull(userId)){
            return new ArrayList<>();
        }

        UserBaseInfoDo userBaseInfoDo = userBaseInfoMapper.selectByPrimaryKey(userId);

        UserFlagRealDo userFlagRealDo = userFlagRealMapper.getOneByUserId(userId);

        UserLevelInfoDo userLevelInfoDo = userLevelInfoMapper.getOneByUserId(userId);

        UserDeviceInfoDo userDeviceInfoDo = userDeviceInfoMapper.getOneByUserId(userId);

        UserLoginLogDo userLoginLogDo = userLoginLogMapper.getOneByUserId(userId);

        UserBaseInfoVO userBaseInfoVO = buildUserBaseInfo(userBaseInfoDo, userFlagRealDo, userLevelInfoDo, userDeviceInfoDo, userLoginLogDo);

        return new ReportBuilder(userBaseInfoVO).colSize(4).buildList();
    }



    private String buildName(UserBaseInfoDo userBaseInfoDo, UserFlagRealDo userFlagRealDo){
        if(isNull(userBaseInfoDo)){
            return StringUtils.EMPTY;
        }
        String name = null;
        String userFlag;
        if(isNotNull(userFlagRealDo)){
            userFlag = CipherUtils.spanDecode(userFlagRealDo.getUserFlag());
            if(isNotNull(userFlag)){
                name = JsonUtils.findValueFromJsonStr(userFlag, "userName");
                name = isNull(name)? "" : CommonUtils.decodeUnicode(name);
            }
        }

        if(isNull(name)){
            name = isNull(userBaseInfoDo.getNickName())?StringUtils.EMPTY : userBaseInfoDo.getNickName() + "(昵称)";
        }
        return name;
    }

    private UserBaseInfoVO buildUserBaseInfo(UserBaseInfoDo userBaseInfoDo, UserFlagRealDo userFlagRealDo,
                                             UserLevelInfoDo userLevelInfoDo, UserDeviceInfoDo userDeviceInfoDo,
                                             UserLoginLogDo userLoginLogDo) {
        if(userBaseInfoDo == null){
            return new UserBaseInfoVO();
        }

        UserBaseInfoVO userBaseInfoVO = new UserBaseInfoVO();

        userBaseInfoVO.setName(buildName(userBaseInfoDo, userFlagRealDo));

        userBaseInfoVO.setMobile(String.valueOf(userBaseInfoDo.getMobile()));

        if(isNotNull(userLevelInfoDo)){
            userBaseInfoVO.setMemberLevel(userLevelInfoDo.getLevelName());
        }

        userBaseInfoVO.setRegisterTime(buildTime(userBaseInfoDo.getAddTime()));

        if(isNotNull(userDeviceInfoDo)){
            DeviceTypeEnum deviceTypeEnum = DeviceTypeEnum.getMatchedEnum(userDeviceInfoDo.getDeviceType());
            if(isNotNull(deviceTypeEnum)){
                userBaseInfoVO.setPhoneSystem(deviceTypeEnum.getDesc());
            }

            userBaseInfoVO.setPhoneBrand(userDeviceInfoDo.getPhoneType());
        }

        if(isNotNull(userLoginLogDo)){
            userBaseInfoVO.setLastLoginTime(buildTime(userLoginLogDo.getLogTime()));
        }

        return userBaseInfoVO;
    }

    @Override
    public UserBindInfoVO getUserBindInfo(Integer userId) throws BusinessException {
        if(isNull(userId)){
            return new UserBindInfoVO();
        }

        UserFlagRealDo userFlagRealDo = userFlagRealMapper.getOneByUserId(userId);

        UserTokenInfoDo userTokenInfoDo = userTokenInfoMapper.getOneByUserId(userId);

        Map<String, Object> conditions = new HashMap<>();
        conditions.put("userId", userId);
        List<UserFlagInfoDo> userFlagInfoDos = userFlagInfoMapper.getByConditions(conditions);

        return buildUserBindInfo(userFlagRealDo, userTokenInfoDo, userFlagInfoDos);
    }

    private UserBindInfoVO buildUserBindInfo(UserFlagRealDo userFlagRealDo,
                                             UserTokenInfoDo userTokenInfoDo, List<UserFlagInfoDo> userFlagInfoDos) {
        UserBindInfoVO userBindInfoVO = new UserBindInfoVO();
        String realNameAuth;
        String bindCard;
        if(isNotNull(userTokenInfoDo)){
            realNameAuth = StringUtils.equals(CommonYesOrNoEnum.Y.getCode(), userTokenInfoDo.getIsUserAuth())? "已实名": "未实名";
            bindCard = StringUtils.equals(CommonYesOrNoEnum.Y.getCode(), userTokenInfoDo.getIsBindCard())? "已绑卡": "未绑卡";
        } else {
            realNameAuth = "未实名";
            bindCard = "未绑卡";
        }
        userBindInfoVO.setRealNameAuth(realNameAuth);
        userBindInfoVO.setBindCard(bindCard);
        if(isNotNull(userFlagRealDo)){
            Integer realType = userFlagRealDo.getRealType();
            RealTypeEnum realTypeEnum = RealTypeEnum.getMatchedEnum(realType);
            if(isNotNull(realTypeEnum)){
                userBindInfoVO.setCertificateStatus(realTypeEnum.getDesc());
            }
        }

        List<UserBindInfoVO.BindCardInfo> bindCardInfos = new ArrayList<>();
        UserBindInfoVO.BindCardInfo bindCardInfo;
        BindStatEnum bindStatEnum;
        Integer creditId;
        String cardNum;
        String bankName;
        Integer planNum;
        String bindStatus;
        String bindTime;

        for (UserFlagInfoDo userFlagInfoDo : userFlagInfoDos) {
            cardNum = buildCardNum(userFlagInfoDo.getCardBin(), userFlagInfoDo.getBankFlag());
            bankName = userFlagInfoDo.getBankName();
            creditId = userFlagInfoDo.getId();
            planNum = planInfoMapper.getCountByCreditId(creditId);

            bindStatEnum = BindStatEnum.getMatchedEnum(userFlagInfoDo.getBindStat());
            if(isNotNull(bindStatEnum)){
                bindStatus = bindStatEnum.getDesc();
            }else{
                bindStatus = "其他";
            }
            bindTime = buildTime(userFlagInfoDo.getAddTime());

            bindCardInfo = new UserBindInfoVO.BindCardInfo(cardNum, bankName, planNum, bindStatus, bindTime);
            bindCardInfos.add(bindCardInfo);
        }
        userBindInfoVO.setBindCardInfos(bindCardInfos);
        return userBindInfoVO;
    }
}
