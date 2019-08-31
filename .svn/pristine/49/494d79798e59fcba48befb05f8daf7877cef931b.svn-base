package com.jieandata.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

	/**
	 * 验证入口
	 * @return
	 */
	@RequestMapping(value = "/do",method = RequestMethod.GET)
    public String test(){
		log.info("in test/do");
		return "OK";
    }

}
