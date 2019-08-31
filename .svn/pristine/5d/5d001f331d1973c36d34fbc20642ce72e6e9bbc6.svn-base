package com.jieandata.biz.manageuser.impl;

import java.util.ArrayList;
import java.util.List;

import com.jieandata.biz.base.BaseManagerImpl;
import com.jieandata.biz.manageuser.ManageUserManager;
import com.jieandata.dal.dao.SystemConfigMapper;
import com.jieandata.utils.bean.data.BaseToken;
import com.jieandata.utils.bean.data.ManageUserInfo;
import com.jieandata.utils.bean.request.LoginRequest;
import com.jieandata.utils.common.enums.RespCodeEnum;
import com.jieandata.utils.constant.Constants;
import com.jieandata.utils.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userManager")
public class ManageUserManagerImpl extends BaseManagerImpl implements ManageUserManager {

	@Autowired
	private SystemConfigMapper systemConfigMapper;

	@Override
	public BaseToken login(LoginRequest loginRequest) throws BusinessException {
		if(isNull(loginRequest)){
			throw new BusinessException(RespCodeEnum.PARAM_ERROR);
		}

		if(isNull(loginRequest.getUsername()) || isNull(loginRequest.getPassword())){
			throw new BusinessException(RespCodeEnum.LOGIN_INFO_ERROR);
		}

		if(!StringUtils.equals("admin", loginRequest.getUsername())){
			throw new BusinessException(RespCodeEnum.LOGIN_INFO_ERROR);
		}

		String adminPwd = systemConfigMapper.getValueByKey(Constants.CONFIG_VAL_ADMIN_PWD);

		if(!StringUtils.equals(adminPwd, loginRequest.getPassword())){
			throw new BusinessException(RespCodeEnum.LOGIN_INFO_ERROR);
		}

		return new BaseToken("admin-token");
	}

	@Override
	public ManageUserInfo getUserInfoByToken(String token) throws BusinessException {
		// TODO 解析token,获取用户信息
		ManageUserInfo userInfo = new ManageUserInfo();
		userInfo.setManagerId("1");
		userInfo.setName("葫芦岛-刘能");
		userInfo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
		userInfo.setIntroduction("I am a super administrator");
		// TODO 设置用户权限
		List<String> roles = new ArrayList<>();
		roles.add("admin");
		userInfo.setRoles(roles);
		return userInfo;
	}
}
