package com.jieandata.web.controller.manageuser;

import com.jieandata.biz.manageuser.ManageUserManager;
import com.jieandata.utils.bean.data.BaseToken;
import com.jieandata.utils.bean.data.ManageUserInfo;
import com.jieandata.utils.bean.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jieandata.utils.bean.request.LoginRequest;
import com.jieandata.utils.common.enums.RespCodeEnum;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/manageuser")
public class ManageUserController {
	
	@Autowired
    private ManageUserManager manageUserManager;

	/**
	 * 管理员用户登录
	 * @param loginRequest
	 * @return
	 */
	@RequestMapping(value = "/login",method = {RequestMethod.POST})
    public BaseResponse<BaseToken> login(@RequestBody LoginRequest loginRequest){
		//TODO 登录，生成token
		log.info("loginRequest:", loginRequest);
		return new BaseResponse<>(RespCodeEnum.HANDLE_SUCCESS, manageUserManager.login(loginRequest));
	}

	/**
	 * 管理员用户信息
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/info",method = {RequestMethod.GET})
	public BaseResponse<ManageUserInfo> info(@RequestParam String token){
		return new BaseResponse<>(RespCodeEnum.HANDLE_SUCCESS, manageUserManager.getUserInfoByToken(token));
	}

	/**
	 * 管理员用户登出
	 * @return
	 */
	@RequestMapping(value = "/logout",method = {RequestMethod.POST})
	public BaseResponse logout(){
		//TODO 登出处理
		return new BaseResponse(RespCodeEnum.HANDLE_SUCCESS);
	}
}
