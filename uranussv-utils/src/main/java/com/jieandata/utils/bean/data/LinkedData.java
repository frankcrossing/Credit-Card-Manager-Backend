package com.jieandata.utils.bean.data;

import lombok.Data;

/**
 * @Auther: pengke
 * @Date: 2019-7-2 10:32
 * @Description: 关联数据
 */
@Data
public class LinkedData {

    private String nextBeginTime;

    private Object content;

    public LinkedData(String nextBeginTime, Object content) {
        this.nextBeginTime = nextBeginTime;
        this.content = content;
    }
}
