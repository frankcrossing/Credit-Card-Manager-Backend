package com.jieandata.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jieandata.service.common.MaskUtils;
import com.jieandata.service.model.user.UserInfoVO;

/**
 * @Auther: pengke
 * @Date: 2019-7-24 11:08
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setName("李一一");
        userInfoVO.setMobile("513822199208026791");
        UserInfoVO userInfoVO1 = (UserInfoVO)MaskUtils.getMaskedBean(userInfoVO);
        System.out.println(userInfoVO1.getName());
        System.out.println(userInfoVO1.getMobile());
        try {
            System.out.println(new ObjectMapper().writeValueAsString(userInfoVO1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
