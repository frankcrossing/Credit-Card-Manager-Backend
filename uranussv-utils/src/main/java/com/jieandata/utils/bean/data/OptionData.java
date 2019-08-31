package com.jieandata.utils.bean.data;

import lombok.Data;

/**
 * @Auther: pengke
 * @Date: 2019-7-3 13:48
 * @Description:
 */
@Data
public class OptionData {
    private String label;
    private String value;

    public OptionData(String label, String value) {
        this.label = label;
        this.value = value;
    }
}
