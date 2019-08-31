package com.jieandata.utils.common.enums;

import com.jieandata.utils.bean.response.BaseResponse;

/**
 * 响应报文中 respCode 代表返回码
 */
public enum RespCodeEnum {
	HANDLE_SUCCESS(20000, "", "处理成功"),
	PARAM_ERROR(40001, "", "请求参数错误"),
	LOGIN_INFO_ERROR(40002, "", "登录信息错误"),
	FORBIDDEN(40003, "", "无操作权限"),
	MANAGER_MISS(40004, "", "操作员不存在"),
	MANAGER_STAT_EXCEPTION(40005, "", "操作员状态异常"),
	AGENT_MISS(40006, "", "代理商不存在"),
	AGENT_STAT_EXCEPTION(40007, "", "代理商状态异常"),
	USER_MISS(40008, "", "用户不存在"),
	UPDATE_FAIL(50001, "", "更新失败"),
	INSERT_FAIL(50002, "", "添加失败"),
	AGENT_ID_USED(50003, "", "代理商ID已被使用"),
	AGENT_NAME_USED(50004, "", "代理商名称已被使用"),
	BIND_SUCCESS(1, "", "绑定成功"),
	BIND_FAIL(-1, "", "绑定失败(请勿重复绑定)"),
	OAUTH_INFO_ERROR(-3, "", "无法获取授权"),
	OPEN_ID_IS_NULL(-4, "", "无法获取微信用户唯一标识"),
	USER_CLOSE(-5, "", "用户信息已关闭"),
	UNKNOWN_EXCEPTION(999, "", "未知错误"),
	SYSTEM_EXCEPTION(103, "", "系统错误"),
	ARCHITECTURE_ERROR(104, "", "框架错误");
	
	private int respCode;
	private String errCode;
	private String respDesc;
	
	RespCodeEnum(int respCode, String errCode, String respDesc) {
		this.respCode = respCode;
		this.errCode = errCode;
		this.respDesc = respDesc;
	}

	public static RespCodeEnum getMatchedResp(int respCode) {
		for (RespCodeEnum vprexRespCode : RespCodeEnum.values()) {
			if (vprexRespCode.respCode == respCode) {
				return vprexRespCode;
			}
		}
		return null;
	}
	
	public int getRespCode() {
		return respCode;
	}
	
	public String getErrCode() {
		return errCode;
	}
	
	public String getRespDesc() {
		return respDesc;
	}
	
	public BaseResponse getBaseResponse() {
		BaseResponse response = new BaseResponse();
		response.setCode(this.respCode);
		response.setMessage(this.respDesc);
		return response;
	}
}
