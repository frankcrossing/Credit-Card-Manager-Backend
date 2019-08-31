package com.jieandata.utils.bean.response;

import com.jieandata.utils.common.enums.RespCodeEnum;
import lombok.Data;

@Data
public class BaseResponse<T> {
	private int code;
	private String message;
	private T data;

	public BaseResponse() {

	}

	public BaseResponse(T data) {
		this.data = data;
	}

	public BaseResponse(RespCodeEnum respCodeEnum) {
		this.code = respCodeEnum.getRespCode();
		this.message = respCodeEnum.getRespDesc();
	}

	public BaseResponse(RespCodeEnum respCodeEnum, T data) {
		this.code = respCodeEnum.getRespCode();
		this.message = respCodeEnum.getRespDesc();
		this.data = data;
	}
}
