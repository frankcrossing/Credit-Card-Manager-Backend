package com.jieandata.web.controller.common;

import com.jieandata.biz.common.CommonManager;
import com.jieandata.service.model.option.OptionVO;
import com.jieandata.utils.bean.response.BaseResponse;
import com.jieandata.utils.common.enums.RespCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Auther: pengke
 * @Date: 2019-7-25 18:58
 * @Description: 通用接口
 */
@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private CommonManager commonManager;

    /**
     * 获取所有可选项
     * @return
     */
    @RequestMapping(value = "/allOptions",method = {RequestMethod.POST})
    public BaseResponse<Map<String, List<OptionVO>>> allOptions(){
        log.info("in allOptions");
        Map<String, List<OptionVO>> data = commonManager.getAllOptions();
        return new BaseResponse<>(RespCodeEnum.HANDLE_SUCCESS, data);
    }
}
