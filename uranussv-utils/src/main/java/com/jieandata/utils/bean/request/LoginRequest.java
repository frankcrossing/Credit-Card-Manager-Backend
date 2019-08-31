package com.jieandata.utils.bean.request;

import lombok.Data;

@Data
public class LoginRequest {
	private String account;
	private String pwd;
	private String code;
	private String state;
	private String username;
	private String password;
}
