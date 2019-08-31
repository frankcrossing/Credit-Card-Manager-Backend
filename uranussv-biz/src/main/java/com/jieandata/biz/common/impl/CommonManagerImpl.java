package com.jieandata.biz.common.impl;

import com.jieandata.biz.base.BaseManagerImpl;
import com.jieandata.biz.common.CommonManager;
import com.jieandata.service.model.option.OptionVO;
import com.jieandata.utils.common.IdcardValidator;
import com.jieandata.utils.enums.DeviceTypeEnum;
import com.jieandata.utils.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: pengke
 * @Date: 2019-7-26 09:54
 * @Description:
 */
@Service
public class CommonManagerImpl extends BaseManagerImpl implements CommonManager {

    /*@Autowired
    private ChannelInfoMapper channelInfoMapper;*/

    @Override
    public Map<String, List<OptionVO>> getAllOptions() throws BusinessException {
        Map<String, List<OptionVO>> allOptions = new HashMap<>();

        // 客户来源
        /*List<OptionVO> sourcesList = new ArrayList<>();
        sourcesList.add(new OptionVO("undefined", "不限"));
        List<ChannelInfoDo> allChannel = channelInfoMapper.getAll();
        for (ChannelInfoDo channelInfoDo : allChannel) {
            if(!isAnyNull(channelInfoDo.getChannelNo(), channelInfoDo.getName())){
                sourcesList.add(new OptionVO(channelInfoDo.getChannelNo(), channelInfoDo.getName()));
            }
        }
        allOptions.put("sources", sourcesList);*/
        // 城市
        List<OptionVO> cityList = new ArrayList<>();
        cityList.add(new OptionVO("undefined", "不限"));
        String[][] codeAndCity = IdcardValidator.codeAndCity;
        for (int i = 0, length = codeAndCity.length; i < length; i++) {
            cityList.add(new OptionVO(codeAndCity[i][0], codeAndCity[i][1]));
        }
        allOptions.put("citys", cityList);
        // 注册客户端
        List<OptionVO> deviceTypeList = new ArrayList<>();
        deviceTypeList.add(new OptionVO("undefined", "不限"));
        for (DeviceTypeEnum deviceTypeEnum : DeviceTypeEnum.values()) {
            deviceTypeList.add(new OptionVO(deviceTypeEnum.getCode(), deviceTypeEnum.getDesc()));
        }
        allOptions.put("deviceTypes", deviceTypeList);
        return allOptions;
    }
}
