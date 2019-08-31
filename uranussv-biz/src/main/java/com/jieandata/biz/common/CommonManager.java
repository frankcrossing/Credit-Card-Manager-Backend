package com.jieandata.biz.common;

import com.jieandata.service.model.option.OptionVO;
import com.jieandata.utils.exception.BusinessException;

import java.util.List;
import java.util.Map;

/**
 * @Auther: pengke
 * @Date: 2019-7-25 19:15
 * @Description:
 */
public interface CommonManager {

    /**
     * 获取所有可选项
     * @return
     * @throws BusinessException
     */
    Map<String, List<OptionVO>> getAllOptions() throws BusinessException;
}
