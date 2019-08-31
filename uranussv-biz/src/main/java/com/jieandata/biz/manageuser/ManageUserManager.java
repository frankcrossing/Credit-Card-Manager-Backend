package com.jieandata.biz.manageuser;

import com.jieandata.utils.bean.data.BaseToken;
import com.jieandata.utils.bean.data.ManageUserInfo;
import com.jieandata.utils.bean.request.LoginRequest;
import com.jieandata.utils.exception.BusinessException;

public interface ManageUserManager {
	/**
	 * 登录
	 * @param loginRequest
	 * @return
	 */
	BaseToken login(LoginRequest loginRequest) throws BusinessException;

	/**
	 * 获取管理员用户信息
	 * @param token
	 * @return
	 * @throws BusinessException
	 */
	ManageUserInfo getUserInfoByToken(String token) throws BusinessException;
}
