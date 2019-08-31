package com.jieandata.service.base;

import lombok.Data;

/**
 * @Auther: pengke
 * @Date: 2019-8-15 17:03
 * @Description:
 */
@Data
public class BaseDTO {
    /**
     * 数据的id,用于判断是否是新增的数据
     */
    private Integer id;

    public boolean isNew(){
        if(id != null && id > 0){
            return false;
        }
        return true;
    }
}
